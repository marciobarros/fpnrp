package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElementType;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Dependency;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionType;
import br.uniriotec.vitor.padilha.dissertacao.utils.XmlUtils;

public class FunctionsPointReader
{
	/**
	 * Loads a system from its XMl representations
	 */
	public FunctionPointSystem execute(String functionsPointFileName, String stakeholdersInterestFileName) throws Exception
	{
		FunctionPointSystem system = new FunctionPointSystem();
		loadFunctionPointSystem(system, functionsPointFileName);
		loadStakeholderInterests(system, stakeholdersInterestFileName);
		return system;
	}

	/**
	 * Loads the structure of the system
	 */
	private void loadFunctionPointSystem(FunctionPointSystem system, String fileName) throws Exception 
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
			dataModel.addElement(loadDataModelElement(dataModel, xmlInternalFile, DataModelElementType.ILF));

		for (Element xmlExternalFile : XmlUtils.getElements(xmlDataModel, "eif"))
			dataModel.addElement(loadDataModelElement(dataModel, xmlExternalFile, DataModelElementType.EIF));
	}

	/**
	 * Loads a data model element
	 */
	private DataModelElement loadDataModelElement(DataModel dataModel, Element xmlDataModelElement, DataModelElementType type) throws Exception 
	{
		String name = XmlUtils.getStringAttribute(xmlDataModelElement, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a data model element is empty.");
		
		if (dataModel.getDataModelElementName(name) != null)
			throw new Exception("There already exists a data model element named '" + name + "'.");

		DataModelElement element = new DataModelElement(name, type);
		
		for (Element xmlRecordType : XmlUtils.getElements(xmlDataModelElement, "ret"))
			element.addRecordType(loadRecordType(element, xmlRecordType));

		return element;
	}

	/**
	 * Loads a record type
	 */
	private RecordType loadRecordType(DataModelElement element, Element xmlRecordType) throws Exception
	{
		String name = XmlUtils.getStringAttribute(xmlRecordType, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a record type is empty.");
		
		if (element.getRecordTypeName(name) != null)
			throw new Exception("There already exists a record type named '" + name + "' in the data model element '" + element.getName() + "'.");

		RecordType ret = new RecordType(name);
		
		for (Element xmlField : XmlUtils.getElements(xmlRecordType, "det"))
			ret.addDataElement(loadField(ret, xmlField));

		return ret;
	}

	/**
	 * Loads the field within a record type
	 */
	private DataElement loadField(RecordType ret, Element xmlField) throws Exception
	{
		String name = XmlUtils.getStringAttribute(xmlField, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a field of the record type '" + ret.getName() + "' is empty.");
		
		if (ret.getDataElementName(name) != null)
			throw new Exception("There already exists a field named '" + name + "' in the record type '" + ret.getName() + "'.");

		String description = XmlUtils.getStringAttribute(xmlField, "description", "");
		boolean primaryKey = XmlUtils.getBooleanAttribute(xmlField, "primaryKey", false);
		String referencedRecordType = XmlUtils.getStringAttribute(xmlField, "ref", "");
		String referencedDataModelElement = XmlUtils.getStringAttribute(xmlField, "dataModelElement", referencedRecordType);
		boolean hasSemanticMeaning = XmlUtils.getBooleanAttribute(xmlField, "hasSemanticMeaning", false);
		return new DataElement(name, description, primaryKey, referencedRecordType, referencedDataModelElement, hasSemanticMeaning);
	}

	/**
	 * Loads the transaction model
	 */
	private void loadTransactionModel(TransactionModel transactionModel, DataModel dataModel, Element xmlTransactionModel) throws Exception 
	{
		for (Element xmlTransaction : XmlUtils.getElements(xmlTransactionModel, "ilf"))
			transactionModel.addTransaction(loadTransaction(transactionModel, dataModel, xmlTransaction));
	}

	/**
	 * Loads a transaction
	 */
	private Transaction loadTransaction(TransactionModel transactionModel, DataModel dataModel, Element xmlTransaction) throws Exception 
	{
		String name = XmlUtils.getStringAttribute(xmlTransaction, "name", "");
		
		if (name.length() == 0)
			throw new Exception("The name of a transaction is empty.");
		
		if (transactionModel.getTransactionName(name) != null)
			throw new Exception("There already exists a transaction named '" + name + "' in the model.");

		String typeName = XmlUtils.getStringAttribute(xmlTransaction, "type", "");
		
		if (typeName.length() == 0)
			throw new Exception("The type of transaction '" + name + "' is undefined.");
		
		TransactionType type = TransactionType.get(typeName);
		
		if (type == null)
			throw new Exception("The type of transaction '" + name + "' is invalid.");
		
		boolean errorMessages = XmlUtils.getBooleanAttribute(xmlTransaction, "errorMsg", false);
		Transaction transaction = new Transaction(name, errorMessages, type);

		for (Element xmlFileReference : XmlUtils.getElements(xmlTransaction, "ftr"))
			transaction.addFileReference(loadFileReference(transaction, dataModel, xmlFileReference));

		for (Element xmlDependency : XmlUtils.getElements(xmlTransaction, "dependency"))
			transaction.addDependency(loadDependency(transaction, dataModel, xmlDependency));

		return transaction;
	}

	private FileReference loadFileReference(Transaction transaction, DataModel dataModel, Element xmlFileReference) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Dependency loadDependency(Transaction transaction, DataModel dataModel, Element xmlDependency) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void loadStakeholderInterests(FunctionPointSystem system, String fileName) 
	{
		// TODO Auto-generated method stub
	}
}