package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.uniriotec.vitor.padilha.dissertacao.Complexity;
import br.uniriotec.vitor.padilha.dissertacao.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElementType;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.FTR;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.FTRField;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.view.IFunctionPointView;

public class FunctionPointCalculator {
	
	private IFunctionPointView functionPointView;
	
	private Map<String, List<String>> ignoredFields;
	
	public FunctionPointCalculator(IFunctionPointView functionPointView) {
		this.functionPointView = functionPointView;
		ignoredFields = new HashMap<String, List<String>>();
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
		List<DataModelElement> dataModelElements = new ArrayList<DataModelElement>();
		dataModelElements.addAll(dataModel.getIlfs());
		dataModelElements.addAll(dataModel.getEifs());
		for(DataModelElement dataModelElement:dataModelElements) {
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
					if(field.getSubsetRef()!=null){
						if(field.getSubsetRef().getParent().getName().equals(ret.getParent().getName())) {
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
			int totalFunctionPointRet = calculateFunctionPointRetDataModelElement(totalRet, totalDet, dataModelElement.getType());
			getFunctionPointView().renderDataModelElementValue(dataModelElement, retsNorm, detsNorm, totalFunctionPointRet);
			totalFunctionPoint+=totalFunctionPointRet;
		}
		getFunctionPointView().renderDataModelValue(dataModel, dataModelElements.size(), totalFunctionPoint);
		return totalFunctionPoint;
	}

	private int calculateTransactionModel(TransactionModel transactionModel) {
		int totalFunctionPoint = 0;
		for(Transaction transaction:transactionModel.getTransactions()){
			int totalFtr = 0;
			int totalDet = 0;
			Set<String> arquivosLidos = new HashSet<String>();
			for(FTR ftr:transaction.getFtrList()){
				if(!arquivosLidos.contains(ftr.getDataModelElement())) {
					arquivosLidos.add(ftr.getDataModelElement());
					totalFtr++;
				}
				List<Field> fields = new ArrayList<Field>();
				if(ftr.getFields()!=null && (ftr.getUseAllFields()==null || !ftr.getUseAllFields())) {
					for(FTRField field:ftr.getFields()) {
						totalDet++;
						fields.add(field.getField());
					}
				}
				else if(ftr.getUseAllFields()!=null && ftr.getUseAllFields()){
					for(Field field:ftr.getSubsetRef().getFields()) {
						if(field.getPrimaryKey()==null || !field.getPrimaryKey()){
							totalDet++;
							fields.add(field);
						}
					}
				}
				
			}
			if(transaction.getErrorMsg()){
				totalDet++;
			}
			
		}
		return totalFunctionPoint;
	}
	
	private int calculateFunctionPointRetDataModelElement(int ret, int det, DataModelElementType dataModelElementType){
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
	
	public IFunctionPointView getFunctionPointView() {
		return functionPointView;
	}

	public void setFunctionPointView(IFunctionPointView functionPointView) {
		this.functionPointView = functionPointView;
	}
}