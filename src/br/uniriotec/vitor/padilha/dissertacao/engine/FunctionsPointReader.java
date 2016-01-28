package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunctionType;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Stakeholder;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.StakeholderModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReferenceField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionDependency;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunctionType;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.utils.XmlUtils;

/**
 * Classe responsável por carregar arquivos que representam um sistema 
 * 
 * @author marcio.barros
 */
public class FunctionsPointReader
{
	/**
	 * Loads a system from its XMl representations
	 */
	public SoftwareSystem execute(String functionsPointFileName, String stakeholdersInterestFileName) throws Exception
	{
		SoftwareSystem system = new SoftwareSystem();
		loadFunctionPointSystem(system, functionsPointFileName);
		loadStakeholderModel(system, stakeholdersInterestFileName);
		return system;
	}

	/**
	 * Loads the structure of the system
	 */
	private void loadFunctionPointSystem(SoftwareSystem system, String fileName) throws Exception 
	{
		File xmlFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement();

		Element xmlName = XmlUtils.getSingleElement(root, "name");
		
		if (xmlName != null)
			system.setName(xmlName.getTextContent());

		Element xmlDataModel = XmlUtils.getSingleElement(root, "data-model");
		
		if (xmlDataModel != null)
			loadDataModel(system.getDataModel(), xmlDataModel);

		Element xmlTransactionModel = XmlUtils.getSingleElement(root, "transaction-model");
		
		if (xmlTransactionModel != null)
			loadTransactionModel(system.getTransactionModel(), system.getDataModel(), xmlTransactionModel);
	}

	/**
	 * Loads the data model
	 */
	private void loadDataModel(DataModel dataModel, Element xmlDataModel) throws Exception
	{
		for (Element xmlInternalFile : XmlUtils.getElements(xmlDataModel, "ilf"))
			dataModel.addDataFunction(loadDataFunction(dataModel, xmlInternalFile, DataFunctionType.ILF));

		for (Element xmlExternalFile : XmlUtils.getElements(xmlDataModel, "eif"))
			dataModel.addDataFunction(loadDataFunction(dataModel, xmlExternalFile, DataFunctionType.EIF));

		createFieldReferencesRecordTypes(dataModel);
	}

	/**
	 * Loads a data function
	 */
	private DataFunction loadDataFunction(DataModel dataModel, Element xmlDataFunction, DataFunctionType type) throws Exception 
	{
		String name = XmlUtils.getStringAttribute(xmlDataFunction, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a data function is empty.");
		
		if (dataModel.getDataFunctionName(name) != null)
			throw new Exception("There already exists a data function named '" + name + "'.");

		DataFunction element = new DataFunction(name, type);
		
		for (Element xmlRecordType : XmlUtils.getElements(xmlDataFunction, "ret"))
			element.addRecordType(loadRecordType(dataModel, element, xmlRecordType));

		return element;
	}

	/**
	 * Loads a record type within a data function
	 */
	private RecordType loadRecordType(DataModel dataModel, DataFunction dataFunction, Element xmlRecordType) throws Exception
	{
		String name = XmlUtils.getStringAttribute(xmlRecordType, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a record type is empty.");
		
		if (dataFunction.getRecordTypeName(name) != null)
			throw new Exception("There already exists a record type named '" + name + "' in the data function '" + dataFunction.getName() + "'.");

		RecordType ret = new RecordType(dataFunction, name);
		
		for (Element xmlField : XmlUtils.getElements(xmlRecordType, "det"))
			ret.addDataElement(loadDataElement(ret, xmlField));

		return ret;
	}

	/**
	 * Loads the data element within a record type
	 */
	private DataElement loadDataElement(RecordType recordType, Element xmlDataElement) throws Exception
	{
		String name = XmlUtils.getStringAttribute(xmlDataElement, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a field of the record type '" + recordType.getName() + "' is empty.");
		
		if (recordType.getDataElementName(name) != null)
			throw new Exception("There already exists a field named '" + name + "' in the record type '" + recordType.getName() + "'.");

		String description = XmlUtils.getStringAttribute(xmlDataElement, "description", "");
		boolean primaryKey = XmlUtils.getBooleanAttribute(xmlDataElement, "primaryKey", false);
		String referencedRecordTypeName = XmlUtils.getStringAttribute(xmlDataElement, "ref", "");
		String referencedDataModelElementName = XmlUtils.getStringAttribute(xmlDataElement, "dataModelElement", referencedRecordTypeName);
		boolean hasSemanticMeaning = XmlUtils.getBooleanAttribute(xmlDataElement, "hasSemanticMeaning", false);
		return new DataElement(name, description, recordType, primaryKey, referencedDataModelElementName, referencedRecordTypeName, hasSemanticMeaning);
	}

	/**
	 * Builds the references from data elements to record types
	 */
	private void createFieldReferencesRecordTypes(DataModel dataModel) throws Exception
	{
		for (DataFunction dataFunction : dataModel.getDataFunctions())
		{
			for (RecordType recordType : dataFunction.getRecordTypes())
			{
				for (DataElement dataElement : recordType.getDataElements())
				{
					if (dataElement.getReferencedDataModelElementName().length() > 0 || dataElement.getReferencedRecordTypeName().length() > 0)
					{
						DataFunction referencedDataFunction = dataModel.getDataFunctionName(dataElement.getReferencedDataModelElementName());
						
						if (referencedDataFunction == null)
							throw new Exception("The data function '" + dataElement.getReferencedDataModelElementName() + "' referenced by DET '" + dataElement.getName() + "' in record type '" + dataFunction.getName() + "." + recordType.getName() + "' was not found.");

						RecordType referencedRecordType = referencedDataFunction.getRecordTypeName(dataElement.getReferencedRecordTypeName());
						
						if (referencedRecordType == null)
							throw new Exception("The record type '" + dataElement.getReferencedRecordTypeName() + "' referenced by DET '" + dataElement.getName() + "' in record type '" + dataFunction.getName() + "." + recordType.getName() + "' was not found.");
						
						dataElement.setReferencedRecordType(referencedRecordType);
					}
				}
			}
		}
	}

	/**
	 * Loads the transaction model
	 */
	private void loadTransactionModel(TransactionModel transactionModel, DataModel dataModel, Element xmlTransactionModel) throws Exception 
	{
		for (Element xmlTransaction : XmlUtils.getElements(xmlTransactionModel, "transaction"))
			transactionModel.addTransactionFunction(loadTransaction(transactionModel, dataModel, xmlTransaction));

		createDependencyReferencesTransactionFunctions(transactionModel);
	}

	/**
	 * Loads a transaction function
	 */
	private TransactionFunction loadTransaction(TransactionModel transactionModel, DataModel dataModel, Element xmlTransaction) throws Exception 
	{
		String name = XmlUtils.getStringAttribute(xmlTransaction, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a transaction is empty.");
		
		if (transactionModel.getTransactionFunctionName(name) != null)
			throw new Exception("There already exists a transaction named '" + name + "' in the model.");

		String typeName = XmlUtils.getStringAttribute(xmlTransaction, "type", "");
		
		if (typeName.length() == 0)
			throw new Exception("The type of transaction '" + name + "' is undefined.");
		
		TransactionFunctionType type = TransactionFunctionType.get(typeName);
		
		if (type == null)
			throw new Exception("The type of transaction '" + name + "' is invalid.");
		
		boolean errorMessages = XmlUtils.getBooleanAttribute(xmlTransaction, "errorMsg", false);
		int extraDataElements = XmlUtils.getIntAttribute(xmlTransaction, "extraDET", 0);
		TransactionFunction transaction = new TransactionFunction(name, type, errorMessages, extraDataElements);

		for (Element xmlFileReference : XmlUtils.getElements(xmlTransaction, "ftr"))
			transaction.addFileReference(loadFileReference(transaction, dataModel, xmlFileReference));

		for (Element xmlDependency : XmlUtils.getElements(xmlTransaction, "dependency"))
			transaction.addDependency(loadDependency(transaction, dataModel, xmlDependency));

		return transaction;
	}

	/**
	 * Loads a file reference within a transaction function
	 */
	private FileReference loadFileReference(TransactionFunction transaction, DataModel dataModel, Element xmlFileReference) throws Exception
	{
		String referencedRecordTypeName = XmlUtils.getStringAttribute(xmlFileReference, "ret", "");
		
		if (referencedRecordTypeName.length() == 0)
			referencedRecordTypeName = XmlUtils.getStringAttribute(xmlFileReference, "name", "");
		
		String referencedDataModelElementName = XmlUtils.getStringAttribute(xmlFileReference, "dataModelElement", "");
		
		RecordType recordType = null;

		if (referencedDataModelElementName.length() > 0)
		{
			DataFunction element = dataModel.getDataFunctionName(referencedDataModelElementName);

			if (element == null)
				throw new Exception("The data model element '" + referencedDataModelElementName + "' referenced by transaction '" + transaction.getName() + "' is missing in the data model.");
			
			recordType = element.getRecordTypeName(referencedRecordTypeName);
			
			if (recordType == null)
				throw new Exception("The record type '" + referencedRecordTypeName + "' referenced by transaction '" + transaction.getName() + "' is missing in the data model.");
		}
		else
		{
			recordType = dataModel.getRecordTypeName(referencedRecordTypeName);
			
			if (recordType == null)
				throw new Exception("The record type '" + referencedRecordTypeName + "' referenced by transaction '" + transaction.getName() + "' is missing in the data model.");
		}
		
		boolean useAllFields = XmlUtils.getBooleanAttribute(xmlFileReference, "useAllDets", false);
		
		FileReference fileReference = new FileReference(recordType, useAllFields);

		for (Element xmlField : XmlUtils.getElements(xmlFileReference, "det"))
			fileReference.addField(loadFileReferenceField(transaction, fileReference, xmlField));
		
		return fileReference;
	}

	/**
	 * Loads a file reference field within a file reference
	 */
	private FileReferenceField loadFileReferenceField(TransactionFunction transaction, FileReference fileReference, Element xmlField) throws Exception 
	{
		String name = XmlUtils.getStringAttribute(xmlField, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a field referenced by transaction '" + transaction.getName() + "' is empty.");
		
		DataElement field = fileReference.getReferencedRecordType().getDataElementName(name);
		
		if (field == null)
			throw new Exception("The field named '" + name + "', referenced by transaction '" + transaction.getName() + "' is missing in the record type '" + fileReference.getReferencedRecordType().getName() + "'.");
		
		return new FileReferenceField(fileReference, field);
	}

	/**
	 * Loads a dependency within a transaction function
	 */
	private TransactionDependency loadDependency(TransactionFunction transaction, DataModel dataModel, Element xmlDependency) throws Exception 
	{
		String referencedTransactionName = XmlUtils.getStringAttribute(xmlDependency, "ref", "");
		
		if (referencedTransactionName.length() == 0)
			throw new Exception("The name of a transaction referenced by transaction '" + transaction.getName() + "' is empty.");
		
		boolean canBeWeak = XmlUtils.getBooleanAttribute(xmlDependency, "canBeWeak", false);
		return new TransactionDependency(referencedTransactionName, canBeWeak);
	}

	/**
	 * Builds the references from dependencies to transactions
	 */
	private void createDependencyReferencesTransactionFunctions(TransactionModel transactionModel) throws Exception
	{
		for (TransactionFunction transactionFunction : transactionModel.getTransactionFunctions())
		{
			for (TransactionDependency dependency : transactionFunction.getDependencies())
			{
				TransactionFunction referencedTransactionFunction = transactionModel.getTransactionFunctionName(dependency.getReferencedTransactionFunctionName());
				
				if (referencedTransactionFunction == null)
					throw new Exception("The transaction function '" + dependency.getReferencedTransactionFunctionName() + "' referenced by transaction '" + transactionFunction.getName() + "' was not found.");

				dependency.setReferencedTransactionFunction(referencedTransactionFunction);
			}
		}
	}

	/**
	 * Load the stakeholders model
	 */
	private void loadStakeholderModel(SoftwareSystem system, String fileName) throws Exception
	{
		File xmlFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement();

		Element xmlStakeholders = XmlUtils.getSingleElement(root, "stakeholders");
		
		if (xmlStakeholders != null)
			loadStakeholders(system.getStakeholderModel(), xmlStakeholders);

		Element xmlInterests = XmlUtils.getSingleElement(root, "interests");
		
		if (xmlInterests != null)
			loadInterests(system.getStakeholderModel(), system.getTransactionModel(), xmlInterests);
	}

	/**
	 * Loads the stakeholders within a stakeholder model
	 */
	private void loadStakeholders(StakeholderModel stakeholderModel, Element xmlStakeholders) throws Exception 
	{
		for (Element xmlStakeholder : XmlUtils.getElements(xmlStakeholders, "stakeholder"))
		{
			String name = XmlUtils.getStringAttribute(xmlStakeholder, "name", "");
			
			if (name.length() == 0)
				throw new Exception("The name of a stakeholder is empty.");
			
			if (stakeholderModel.getStakeholderName(name) == null)
				throw new Exception("There are at least two stakeholders named '" + name + "'.");
			
			int weight = XmlUtils.getIntAttribute(xmlStakeholder, "weight", 0);
			
			if (weight <= 0)
				throw new Exception("The weight of the stakeholder '" + name + "' is invalid.");
			
			stakeholderModel.addStakeholder(new Stakeholder(name, weight));			
		}
	}

	/**
	 * Loads the interests of stakeholders
	 */
	private void loadInterests(StakeholderModel stakeholderModel, TransactionModel transactionModel, Element xmlInterests) throws Exception
	{
		for (Element xmlInterest : XmlUtils.getElements(xmlInterests, "interest"))
		{
			String transactionName = XmlUtils.getStringAttribute(xmlInterest, "transactionRef", "");
			TransactionFunction transaction = transactionModel.getTransactionFunctionName(transactionName);
			
			if (transaction == null)
				throw new Exception("The transaction '" + transactionName + "', referenced by a stakeholder, was not found in the system.");
			
			String stakeholderName = XmlUtils.getStringAttribute(xmlInterest, "stakeholder", "");
			Stakeholder stakeholder = stakeholderModel.getStakeholderName(stakeholderName);
			
			if (stakeholder == null)
				throw new Exception("The stakeholder '" + stakeholderName + "', referenced in an interest, was not found in the system.");
			
			int value = XmlUtils.getIntAttribute(xmlInterest, "value", 0);
			
			if (value <= 0)
				throw new Exception("The value of a stakeholder's interest is invalid.");
			
			stakeholder.addInterest(new Interest(transaction, value));			
		}
	}
}