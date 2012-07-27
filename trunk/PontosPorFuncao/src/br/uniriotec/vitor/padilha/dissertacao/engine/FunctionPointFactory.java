package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElement;
import br.uniriotec.vitor.padilha.dissertacao.exception.CloneException;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;

public class FunctionPointFactory {

	@SuppressWarnings("unused")
	public static FunctionPointSystem getFunctionPointSystem(BitSet bitset, FunctionPointSystem functionPointSystemReference) {
		//FunctionPointSystem functionPointSystem = new FunctionPointSystem();
//		functionPointSystem.setTransactionModel(new TransactionModel());
//		functionPointSystem.setDataModel(new DataModel());
//		functionPointSystem.getDataModel().setIlfs(functionPointSystemReference.getDataModel().getIlfs());
//		functionPointSystem.getDataModel().setEifs(functionPointSystemReference.getDataModel().getEifs());
//		for(DataModelElement element:functionPointSystem.getDataModel().getIlfs()){
//			element.setParent(functionPointSystem.getDataModel());
//		}
//		functionPointSystem.getTransactionModel().setTransactions(new ArrayList<Transaction>());
//		functionPointSystem.getTransactionModel().setTransactions(new ArrayList<Transaction>());
//		functionPointSystem.getTransactionModel().getTransactions().addAll(functionPointSystemReference.getTransactionModel().getTransactions());
//		
//		for(Transaction transaction:functionPointSystem.getTransactionModel().getTransactions()){
//			transaction.setParent(functionPointSystem.getTransactionModel());
//		}
//		for (int a = 0; a < functionPointSystemReference.getTransactionModel().getTransactions().size(); a++) {
//			if(!bitset.get(a)) {
//				functionPointSystem.getTransactionModel().getTransactions().get(a).eliminateDependendyTransactions();
//				functionPointSystem.getTransactionModel().getTransactions().remove(functionPointSystemReference.getTransactionModel().getTransactions().get(a));
//			}
//		}
//		for(Transaction transaction:functionPointSystemReference.getTransactionModel().getTransactions()){
//			transaction.setParent(functionPointSystemReference.getTransactionModel());
//		}
		FunctionPointSystem functionPointSystem=null;
		try {
			//functionPointSystem = FunctionsPointReader.clone(functionPointSystemReference);
			XmlFunctionPointElement.clones = new HashMap<Object, Object>();
			functionPointSystem = (FunctionPointSystem) functionPointSystemReference.cloneElement();
			Transaction[] transactionsInArray = new Transaction[functionPointSystem.getTransactionModel().getTransactions().size()];
			for (int a = 0; a < functionPointSystem.getTransactionModel().getTransactions().size(); a++) {
				transactionsInArray[a] = functionPointSystem.getTransactionModel().getTransactions().get(a);
			}
			functionPointSystem.charge();
			for (int a = 0; a < transactionsInArray.length; a++) {
				if(!bitset.get(a) && transactionsInArray[a]!=null) {
					Transaction transaction = (Transaction) transactionsInArray[a];
					transaction.eliminateDependendyTransactions(transactionsInArray);
					functionPointSystem.getTransactionModel().getTransactions().remove(transaction);	
					transactionsInArray[a] = null;
				}
			}
			
			functionPointSystem.clear();
			if(functionPointSystem.validate()) {
				
				functionPointSystem.setStakeholderInterests(functionPointSystemReference.getStakeholderInterests());
				//FunctionsPointReader.putStakeholderInterests(functionPointSystem);
			}
			else {
				System.out.println("Erro de validação");
			}
		} catch (ElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return functionPointSystem;
	}
}
