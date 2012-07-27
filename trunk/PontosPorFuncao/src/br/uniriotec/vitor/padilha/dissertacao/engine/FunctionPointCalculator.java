package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.uniriotec.vitor.padilha.dissertacao.Complexity;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElementType;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FTR;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FTRField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionType;
import br.uniriotec.vitor.padilha.dissertacao.view.IFunctionPointView;

public class FunctionPointCalculator {
	
	private Set<IFunctionPointView> functionsView;
	
	public FunctionPointCalculator() {
		this.functionsView = new HashSet<IFunctionPointView>();
	}
	public FunctionPointCalculator(Set<IFunctionPointView> functionsView) {
		this.functionsView = functionsView;
	}

	public int calculate(FunctionPointSystem functionPointSystem){
		int totalPontosPorFuncaoNaoAjustada = 0;
		if(functionPointSystem.getDataModel()!=null) {
			totalPontosPorFuncaoNaoAjustada+=calculateDataModel(functionPointSystem.getDataModel());
		}
		if(functionPointSystem.getTransactionModel()!=null) {
			totalPontosPorFuncaoNaoAjustada+=calculateTransactionModel(functionPointSystem.getTransactionModel());
		}
		
		return totalPontosPorFuncaoNaoAjustada;
	}
	
	private int calculateDataModel(DataModel dataModel) {
		int totalFunctionPoint = 0;

		for(DataModelElement dataModelElement:dataModel.getDataModelElements()) {
			int totalDet = 0;
			int totalRet = 0;
			Set<String> dets = new HashSet<String>();
			Map<String,List<String>> rets = new HashMap<String, List<String>>();
			rets.put("", new ArrayList<String>());
			Set<String> jaExtendidos = new HashSet<String>();
			for(Subset ret:dataModelElement.getSubsets()){
				totalRet++;
				if(ret.getExtendsRet()!=null){					
					if(jaExtendidos.contains(ret.getExtendsRet())) {
						totalRet--;					
					}
					else {
						jaExtendidos.add(ret.getExtendsRet());
						rets.put(ret.getExtendsRet(), new ArrayList<String>());
					}
					rets.get(ret.getExtendsRet()).add(ret.getName());					
				}
				else {
					rets.get("").add(ret.getName());
				}
				for(Field field:ret.getFields()) {
					totalDet++;
					field.setFlagcanBeDetInTransation(true);
					if(field.getSubsetRef()!=null){
						if(field.getSubsetRef().getParent().getName().equals(ret.getParent().getName())) {
							totalDet--;
							continue;
						}
						else if(field.getPrimaryKey()!=null && field.getPrimaryKey()) {
							field.setFlagcanBeDetInTransation(false);
							totalDet--;
							continue;
						}
					}
					dets.add(field.getParent().getName()+"."+field.getName());
				}
			}
			List<String[]> retsNorm = new ArrayList<String[]>();
			for(String chave:rets.keySet()){				
				if(chave.equals("")) {					
					for(String ret:rets.get(chave)){
						String[] retGroup = new String[1];
						retGroup[0]=ret;
						retsNorm.add(retGroup);
					}					
				}
				else {
					String[] retGroup = new String[rets.get(chave).size()];
					int cont = 0;
					for(String ret:rets.get(chave)){
						retGroup[cont]=ret;
						cont++;
					}
					retsNorm.add(retGroup);
				}				
				
			}
			String[] detsNorm = new String[dets.size()];
			int cont = 0;
			for(String det:dets){
				detsNorm[cont]=det;
				cont++;
			}
			Complexity complexity = calculateDataModelElementComplexity(totalRet, totalDet);
			int totalFunctionPointRet = calculateFunctionPointDataModelElement(complexity, dataModelElement.getType());
			for(IFunctionPointView view :getFunctionsView()) {
				view.addDataModelElementValue(dataModelElement, retsNorm, detsNorm,complexity, totalFunctionPointRet);
			}
			totalFunctionPoint+=totalFunctionPointRet;
		}
		for(IFunctionPointView view :getFunctionsView()) {
			view.renderDataModelValue(dataModel, dataModel.getDataModelElements().size(), totalFunctionPoint);
		}
		return totalFunctionPoint;
	}

	private int calculateTransactionModel(TransactionModel transactionModel) {
		int totalFunctionPoint = 0;
		for(Transaction transaction:transactionModel.getTransactions()){
			int totalFtr = 0;
			int totalDet = 0;
			Set<String> arquivosLidos = new HashSet<String>();
			List<String> fields = new ArrayList<String>();
			for(FTR ftr:transaction.getFtrList()){
				if(!arquivosLidos.contains(ftr.getDataModelElement())) {
					arquivosLidos.add(ftr.getDataModelElement());
					totalFtr++;
				}
				
				if(ftr.getFields()!=null && (ftr.getUseAllFields()==null || !ftr.getUseAllFields())) {
					for(FTRField field:ftr.getFields()) {
						if(field.getField()!=null && field.getField().getFlagcanBeDetInTransation()!=null && field.getField().getFlagcanBeDetInTransation()) {
							totalDet++;
							fields.add(field.getParent().getName()+"."+field.getField().getName());
						}
					}
				}
				else if(ftr.getUseAllFields()!=null && ftr.getUseAllFields()){
					for(Field field:ftr.getSubsetRef().getFields()) {
						if(field.getFlagcanBeDetInTransation()){
							totalDet++;
							fields.add(field.getParent().getName()+"."+field.getName());
						}
					}
				}
				
			}
			if(transaction.getErrorMsg()){
				totalDet++;
				fields.add("Mensagens em geral");
			}
			String[] ftrs = new String[arquivosLidos.size()];
			int cont = 0;
			for(String ftr1:arquivosLidos){
				ftrs[cont]=ftr1;
				cont++;
			}
			
			String[] dets = new String[fields.size()];
			cont = 0;
			for(String det1:fields){
				dets[cont]=det1;
				cont++;
			}
			Complexity complexity = calculateTransactionComplexity(ftrs.length, dets.length, transaction.getType());
			int totalFunctionsPoint = calculateFunctionPointTransactionModelElement(complexity, transaction.getType());
			for(IFunctionPointView view :getFunctionsView()) {
				view.addTransactionValue(transaction, ftrs, dets, complexity, totalFunctionsPoint);
			}
			totalFunctionPoint+=totalFunctionsPoint;
		}
		for(IFunctionPointView view :getFunctionsView()) {
			view.renderTransactionModelValue(transactionModel, transactionModel.getTransactions().size(), totalFunctionPoint);
		}
		return totalFunctionPoint;
	}
	
	private int calculateFunctionPointDataModelElement(Complexity complexity, DataModelElementType dataModelElementType){
		
		if((complexity==Complexity.LOW && dataModelElementType.equals(DataModelElementType.ILF)) ||
				(complexity==Complexity.MEDIUM && dataModelElementType.equals(DataModelElementType.EIF)) 
				)
			return 7;
		else if((complexity==Complexity.MEDIUM && dataModelElementType.equals(DataModelElementType.ILF)) ||
				(complexity==Complexity.HIGH && dataModelElementType.equals(DataModelElementType.EIF)) 
				)
			return 10;
		else if(complexity==Complexity.LOW && dataModelElementType.equals(DataModelElementType.EIF))
			return 5;
		else if(complexity==Complexity.HIGH && dataModelElementType.equals(DataModelElementType.ILF))
			return 15;
		else return 0;
	}
	private Complexity calculateDataModelElementComplexity(int ret, int det) {
		Complexity complexity = null;
		if((ret>=6 && det>=20) || (ret<=5 && ret>=2 && det>=51) ) {
			complexity=Complexity.HIGH;
		}
		else if(ret>=6 || (ret<=5 && ret>=2 && det>=20 && det<=50) || (ret==1 && det>=51)) {
			complexity=Complexity.MEDIUM;
		}
		else if((ret==1 && det<=50) || (ret<=5 && ret>=2 && det<20)) {
			complexity=Complexity.LOW;
		}
		return complexity;
	}
	
	private int calculateFunctionPointTransactionModelElement(Complexity complexity, TransactionType transactionType){
	
		if((complexity==Complexity.LOW && transactionType.equals(TransactionType.EO) ) ||
				(complexity==Complexity.MEDIUM && (transactionType.equals(TransactionType.EI) || transactionType.equals(TransactionType.EQ)) ) 
				)
			
			return 4;
		else if((complexity==Complexity.MEDIUM && transactionType.equals(TransactionType.EO)))
			return 5;
		else if(complexity==Complexity.HIGH && transactionType.equals(TransactionType.EO))
			return 7;
		else if(complexity==Complexity.LOW && (transactionType.equals(TransactionType.EI) || transactionType.equals(TransactionType.EQ)))
			return 3;
		else if(complexity==Complexity.HIGH && (transactionType.equals(TransactionType.EI) || transactionType.equals(TransactionType.EQ)))
			return 6;
		else 
			return 0;
	}
	private Complexity calculateTransactionComplexity(int ftrs, int dets,
			TransactionType transactionType) {
		Complexity complexity = null;
		if(	
				(((ftrs>=3 && dets>=5) || (ftrs==2 && dets>=16)) && transactionType.equals(TransactionType.EI)) 
				||
				(((ftrs>=4 && dets>=6) || (ftrs>=2 && ftrs<=3 && dets>=20)) && (transactionType.equals(TransactionType.EO)||transactionType.equals(TransactionType.EQ))) 
			){
			complexity=Complexity.HIGH;
		}
		else if(	
				(((ftrs>=3 && dets <=4) || (ftrs==2 && dets>=5 && dets<=15)
						|| (ftrs<=1 && dets>=16)) && transactionType.equals(TransactionType.EI)) 
				||
				(((ftrs>=4 && dets <=5) || (ftrs>=2 && ftrs<=3 && dets>=6 && dets<=19)
						|| (ftrs<=1 && dets>=20)) && (transactionType.equals(TransactionType.EO)||transactionType.equals(TransactionType.EQ))) 
			){
			complexity=Complexity.MEDIUM;
		}
		else if(	
				(((ftrs<=1 && dets<=15)
						|| (ftrs==2 && dets<=4)) && transactionType.equals(TransactionType.EI)) 
				||
				(((ftrs<=1 && dets<=19)
						|| (ftrs<=3 && ftrs>=2 && dets>=5)) && (transactionType.equals(TransactionType.EO)||transactionType.equals(TransactionType.EQ))) 
			){
			complexity=Complexity.LOW;
		}
		return complexity;
	}
	public Long calculateUserSatisfaction(FunctionPointSystem functionPointSystem) {
		Long interesseTotal = 0L;
		List<String> transactionsNames = new ArrayList<String>();
		for(Transaction transaction:functionPointSystem.getTransactionModel().getTransactions()) {
			transactionsNames.add(transaction.getName());
		}
		for(Interest interest:functionPointSystem.getStakeholderInterests().getInterests()) {
			if(transactionsNames.contains(interest.getTransaction().getName()))
				interesseTotal+=interest.getInterest();
		}
		return interesseTotal;
	}
	public Set<IFunctionPointView> getFunctionsView() {
		return functionsView;
	}

	public void setFunctionsView(Set<IFunctionPointView> functionsView) {
		this.functionsView = functionsView;
	}
	
}