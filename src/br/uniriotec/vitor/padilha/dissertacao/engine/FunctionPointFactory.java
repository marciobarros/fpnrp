package br.uniriotec.vitor.padilha.dissertacao.engine;


public class FunctionPointFactory
{
//	public static FunctionPointSystem getFunctionPointSystem(Boolean[] representBinary, FunctionPointSystem functionPointSystemReference)
//	{
//		Binary binary = new Binary(representBinary.length);
//		for (int i = 0; i < representBinary.length; i++)
//		{
//			binary.bits_.set(i, representBinary[i]);
//		}
//		return FunctionPointFactory.getFunctionPointSystem(binary, functionPointSystemReference);
//	}
//
//	/**
//	 * Retorna uma contagem de pontos de função a partir de um BitSet (ex:
//	 * 010010100111111001)
//	 * 
//	 * @param bitset
//	 * @param functionPointSystemReference
//	 * @return
//	 */
//	public static FunctionPointSystem getFunctionPointSystem(Binary binary, FunctionPointSystem functionPointSystemReference)
//	{
//		FunctionPointSystem functionPointSystem = null;
//		try
//		{
//			// functionPointSystem =
//			// FunctionsPointReader.clone(functionPointSystemReference);
//			XmlFunctionPointElement.clones = new HashMap<Object, Object>();
//			functionPointSystem = (FunctionPointSystem) functionPointSystemReference.cloneElement();
//			TransactionFunction[] transactionsInArray = new TransactionFunction[binary.getNumberOfBits()];
//			int cont = 0;
//			for (int a = 0; a < functionPointSystem.getTransactionModel().getTransactionFunctions().size(); a++)
//			{
//				TransactionFunction transaction = functionPointSystem.getTransactionModel().getTransactionFunctions().get(a);
//				if (transaction.getReleaseImplementation() == 0)
//				{
//					transactionsInArray[cont] = functionPointSystem.getTransactionModel().getTransactionFunctions().get(a);
//					cont++;
//				}
//			}
//			functionPointSystem.charge();
//			for (int a = 0; a < transactionsInArray.length; a++)
//			{
//				if (!binary.bits_.get(a) && transactionsInArray[a] != null)
//				{
//					TransactionFunction transaction = (TransactionFunction) transactionsInArray[a];
//					transaction.eliminateDependendyTransactions(transactionsInArray);
//					functionPointSystem.getTransactionModel().getTransactionFunctions().remove(transaction);
//					transactionsInArray[a] = null;
//				}
//			}
//
//			functionPointSystem.clear();
//			
//			if (functionPointSystem.validate())
//			{
//				functionPointSystem.setStakeholderInterests(functionPointSystemReference.getStakeholderInterests());
//			} 
//			else
//			{
//				System.out.println("Erro de validação");
//			}
//		} 
//		catch (ElementException e)
//		{
//			e.printStackTrace();
//		} 
//		catch (CloneException e)
//		{
//			e.printStackTrace();
//		}
//
//		return functionPointSystem;
//	}
}