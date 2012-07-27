package br.uniriotec.vitor.padilha.dissertacao.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElement;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElementType;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests.StakeholderInterests;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FTR;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FTRField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionType;

@XmlRootElement(name="system")
public class FunctionPointSystem extends XmlFunctionPointElement implements ElementValidator{

	private DataModel dataModel;
	
	private TransactionModel transactionModel;
	
	private StakeholderInterests stakeholderInterests;
	
	@XmlElement(required=true,name="data-model")
	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	@XmlElement(required=true,name="transaction-model")
	public TransactionModel getTransactionModel() {
		return transactionModel;
	}

	public void setTransactionModel(TransactionModel transactionModel) {
		this.transactionModel = transactionModel;
	}

	@Override
	public boolean validate() throws ElementException {
		if(this.getDataModel().validate() && this.getTransactionModel().validate())
			return true;
		return false;
	}
	
	public void charge(){
		this.getDataModel().charge();
		this.getTransactionModel().charge();
	}
	public void clear() {
		clearNoUsedFields();
		clearNoUsedRets();
		transformILFInEIF();
	}
	
	private void transformILFInEIF(){
		List<String> ilfsInInputTransactions = new ArrayList<String>();
		if(this.transactionModel!=null) {
			if(this.transactionModel.getTransactions()!=null) {
				for(Transaction transaction:this.transactionModel.getTransactions()) {
					if(transaction.getType().equals(TransactionType.EI)) {
						for(FTR ftr:transaction.getFtrList()) {
							ilfsInInputTransactions.add(ftr.getSubsetRef().getParent().getName());
						}
					}
				}
			}
		}
		if(this.getDataModel()!=null) {
			for(DataModelElement ilf:this.getDataModel().getDataModelElements()) {
				if(!ilfsInInputTransactions.contains(ilf.getName()))
					ilf.setType(DataModelElementType.EIF);
			}
		}
	}
	private void clearNoUsedRets() {
		List<DataModelElement> dataModelElements = new ArrayList<DataModelElement>(this.dataModel.getDataModelElements());
		
		for(DataModelElement dataModelElement:this.dataModel.getDataModelElements()) {
			List<Subset> rets = new ArrayList<Subset>(dataModelElement.getSubsets());
			for(Subset ret:dataModelElement.getSubsets()) {
				if(ret.getFields().isEmpty()) {
					//System.out.println("RET removido = "+ret.getParent().getName()+"/"+ret.getName());
					rets.remove(ret);
				}
			}
			dataModelElement.setSubsets(rets);
			if(rets.isEmpty()) {
				//System.out.println("ILF removido = "+ilf.getName());
				dataModelElements.remove(dataModelElement);
			}
		}
		
		this.dataModel.setDataModelElements(dataModelElements);
	}

	protected void clearNoUsedFields() {
		Set<Field> utilsFields = new HashSet<Field>();
		for(Transaction transaction:transactionModel.getTransactions()){
			for(FTR ftr:transaction.getFtrList()) {
				if(ftr.getUseAllFields()!=null && ftr.getUseAllFields()){
					if(ftr.getSubsetRef().getFields()!=null) {
						for(Field field:ftr.getSubsetRef().getFields()) {
							utilsFields.add(field);
						}
					}
				}
				else {
					for(FTRField field:ftr.getFields()){
						utilsFields.add(field.getField());
					}
				}
			}
		}
		for(DataModelElement dataModelElement:dataModel.getDataModelElements()) {
			for(Subset subset:dataModelElement.getSubsets()) {
				List<Field> fields = new ArrayList<Field>(subset.getFields());
				for(Field field:subset.getFields()) {
					if(!utilsFields.contains(field)) {
						//System.out.println("Campo removido = "+field.getParent().getName()+"/"+field.getName());
						fields.remove(field);
					}
				}
				subset.setFields(fields);
			}
		}
		
	}

	@XmlTransient
	public StakeholderInterests getStakeholderInterests() {
		return stakeholderInterests;
	}

	public void setStakeholderInterests(StakeholderInterests stakeholderInterests) {
		this.stakeholderInterests = stakeholderInterests;
	}
	
	public String doDot(FunctionPointSystem baseFunctionPointSystem,boolean showDataModel) {
		
		String returnValue = "digraph teste {\n";
		if(showDataModel) {
			returnValue+=this.dataModel.doDot(baseFunctionPointSystem.getDataModel().getDataModelElements());
		}
		returnValue+=this.transactionModel.doDot(baseFunctionPointSystem.getTransactionModel().getTransactions(),showDataModel);
		
		returnValue+="}";
		return returnValue;
	}
}
