package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionDependency;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;

public class DotNotationGenerator 
{
	/**
	 * Creates the DOT representation for the data model
	 */
	public String doDot(DataModel dataModel, List<DataFunction> baseDataElements)
	{
		String result = "";
		Map<String, DataFunction> baseNames = new HashMap<String, DataFunction>();
		
		for (DataFunction dataModelElement : baseDataElements)
		{
			baseNames.put(dataModelElement.getName(), dataModelElement);
		}
		
		for (DataFunction dataModelElement : dataModel.getDataFunctions())
		{
			result += dataModelElement.getName();
			result += "[";
		
			if (!baseNames.containsKey(dataModelElement.getName()))
			{
				result += "color=red fontcolor=red";
			} 
			else if (!baseNames.get(dataModelElement.getName()).getType().equals(dataModelElement.getType()))
			{
				result += "color=blue fontcolor=blue";
			}
			
			result += " shape=box]\n";
		}
		
		return result;
	}

	public String doDot(TransactionModel transactionModel, List<TransactionFunction> baseTransaction, boolean showDataModel)
	{
		List<String> baseNames = new ArrayList<String>();

		for (TransactionFunction transaction : baseTransaction)
			baseNames.add(transaction.getName());

		String retorno = "";

		for (TransactionFunction transaction : transactionModel.getTransactionFunctions())
		{
			boolean present = baseNames.contains(transaction.getName());
			String dotTransaction = doDot(transaction, present);
			
			if (!dotTransaction.equals(""))
				retorno += dotTransaction;
			
			if (showDataModel)
			{
				for (FileReference ftr : transaction.getFileReferences())
				{
					retorno += transaction.getName() + "->" + ftr.getReferencedRecordType().getName() + "[arrowType=none";
					
					if (!present)
						retorno += " color=red";
					
					retorno += "]\n";
				}
			}
		}

		retorno += "";
		return retorno;
	}

	public String doDot(TransactionFunction transaction, boolean present)
	{
		String retorno = "";

		if (!present)
			retorno += transaction.getName() + "[color=red fontcolor=red]\n";
		
//		if (this.getReleaseImplementation() > 0)
//		{
//			switch (this.getReleaseImplementation())
//			{
//			case 1:
//				retorno += transaction.getName() + "[color=blue fontcolor=blue]\n";
//				break;
//			case 2:
//				retorno += transaction.getName() + "[color=yellow fontcolor=yellow]\n";
//				break;
//			case 3:
//				retorno += transaction.getName() + "[color=green fontcolor=green]\n";
//				break;
//			case 4:
//				retorno += transaction.getName() + "[color=orange fontcolor=orange]\n";
//				break;
//			case 5:
//				retorno += transaction.getName() + "[color=purple fontcolor=purple]\n";
//				break;
//			case 6:
//				retorno += transaction.getName() + "[color=gray fontcolor=gray]\n";
//				break;
//			}
//		}
		
		if (transaction.getDependencies() != null)
		{
			for (TransactionDependency dependency : transaction.getDependencies())
			{
				retorno += transaction.getName() + "->" + dependency.getReferencedTransactionFunctionName();
				retorno += "[";
				if (dependency.getCanBeWeak())
					retorno += "style=dotted ";
				retorno += ((present) ? "" : "color=red");
				retorno += "]";
				retorno += "\n";
			}
		}
		return retorno;
	}
}