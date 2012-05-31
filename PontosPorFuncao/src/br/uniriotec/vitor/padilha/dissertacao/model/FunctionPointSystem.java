package br.uniriotec.vitor.padilha.dissertacao.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.EIF;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.ILF;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.FTR;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.FTRField;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;

@XmlRootElement(name="system")
public class FunctionPointSystem extends XmlFunctionPointElement implements ElementValidator{

	private DataModel dataModel;
	
	private TransactionModel transactionModel;
	
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
	public void clear() {
		clearNoUsedFields();
		clearNoUsedRets();
	}
	

	private void clearNoUsedRets() {
		List<ILF> ilfs = new ArrayList<ILF>(this.dataModel.getIlfs());
		
		for(ILF ilf:this.dataModel.getIlfs()) {
			List<Subset> rets = new ArrayList<Subset>(ilf.getSubsets());
			for(Subset ret:ilf.getSubsets()) {
				if(ret.getFields().isEmpty()) {
					System.out.println("RET removido = "+ret.getParent().getName()+"/"+ret.getName());
					rets.remove(ret);
				}
			}
			ilf.setSubsets(rets);
			if(rets.isEmpty()) {
				System.out.println("ILF removido = "+ilf.getName());
				ilfs.remove(ilf);
			}
		}
		List<EIF> eifs = new ArrayList<EIF>(this.dataModel.getEifs());
		
		for(EIF eif:this.dataModel.getEifs()) {
			List<Subset> rets = new ArrayList<Subset>(eif.getSubsets());
			for(Subset ret:eif.getSubsets()) {
				if(ret.getFields().isEmpty()) {
					System.out.println("Campo removido = "+ret.getParent().getName()+"/"+ret.getName());
					rets.remove(ret);
				}
			}
			eif.setSubsets(rets);
			if(rets.isEmpty()) {
				System.out.println("ILF removido = "+eif.getName());
				ilfs.remove(eif);
			}
		}
		this.dataModel.setIlfs(ilfs);
		this.dataModel.setEifs(eifs);
	}

	protected void clearNoUsedFields() {
		Set<Field> utilsFields = new HashSet<Field>();
		for(Transaction transaction:transactionModel.getTransactions()){
			for(FTR ftr:transaction.getFtrList()) {
				if(ftr.getUseAllFields()!=null && ftr.getUseAllFields()){
					for(Field field:ftr.getSubsetRef().getFields()) {
						utilsFields.add(field);
					}
				}
				else {
					for(FTRField field:ftr.getFields()){
						utilsFields.add(field.getField());
					}
				}
			}
		}
		for(DataModelElement dataModelElement:dataModel.getIlfs()) {
			for(Subset subset:dataModelElement.getSubsets()) {
				List<Field> fields = new ArrayList<Field>(subset.getFields());
				for(Field field:subset.getFields()) {
					if(!utilsFields.contains(field)) {
						System.out.println("Campo removido = "+field.getParent().getName()+"/"+field.getName());
						fields.remove(field);
					}
				}
				subset.setFields(fields);
			}
		}
		for(DataModelElement dataModelElement:dataModel.getEifs()) {
			for(Subset subset:dataModelElement.getSubsets()) {
				List<Field> fields = new ArrayList<Field>(subset.getFields());
				for(Field field:subset.getFields()) {
					if(!utilsFields.contains(field)) {
						System.out.println("Campo removido = "+field.getParent().getName()+"/"+field.getName());
						fields.remove(field);
					}
				}
				subset.setFields(fields);
			}
		}
	}
	
}
