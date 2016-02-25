package br.uniriotec.vitor.padilha.dissertacao.calc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

public class DetailedReport
{
	private List<DataFunctionReport> dataFunctions;
	private List<TransactionFunctionReport> transactionFunctions;
	
	public DetailedReport()
	{
		this.dataFunctions = new ArrayList<DataFunctionReport>();
		transactionFunctions = new ArrayList<TransactionFunctionReport>();
	}
	
	public DataFunctionReport addDataFunction(DataFunction dataFunction, int cost)
	{
		DataFunctionReport dfr = new DataFunctionReport(dataFunction, cost);
		dataFunctions.add(dfr);
		return dfr;
	}

	public TransactionFunctionReport addTransactionFunction(TransactionFunction transactionFunction, int cost)
	{
		TransactionFunctionReport tfr = new TransactionFunctionReport(transactionFunction, cost);
		transactionFunctions.add(tfr);
		return tfr;
	}
	
	public void report(String filename)
	{
		Collections.sort(dataFunctions, new DataFunctionDetailComparator());
		Collections.sort(transactionFunctions, new TransactionFunctionDetailComparator());

		try
		{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			
			for (DataFunctionReport dfr : dataFunctions)
				writer.println(dfr.getDataFunction().getName() + " R: " + + dfr.getRet() + " D: " + dfr.getDet() + " C: " + dfr.getCost());
			
			writer.println("===");
		
			for (TransactionFunctionReport tfr : transactionFunctions)
				writer.println(tfr.getTransactionFunction().getName() + " F: " + + tfr.getFtr() + " D: " + tfr.getDet() + " C: " + tfr.getCost());
		
			writer.close();
		}
		catch(IOException ioe) { }
	}
}

class DataFunctionReport
{
	private @Getter DataFunction dataFunction;
	private @Getter int cost;
	private @Getter @Setter int ret;
	private @Getter @Setter int det;
	
	public DataFunctionReport(DataFunction dataFunction, int cost)
	{
		this.dataFunction = dataFunction;
		this.cost = cost;
	}
}

class DataFunctionDetailComparator implements Comparator<DataFunctionReport>
{
	@Override
	public int compare(DataFunctionReport o1, DataFunctionReport o2)
	{
		return o1.getDataFunction().getName().compareTo(o2.getDataFunction().getName());
	}
}

class TransactionFunctionReport
{
	private @Getter TransactionFunction transactionFunction;
	private @Getter int cost;
	private @Getter @Setter int ftr;
	private @Getter @Setter int det;
	
	public TransactionFunctionReport(TransactionFunction transactionFunction, int cost)
	{
		this.transactionFunction = transactionFunction;
		this.cost = cost;
	}
}

class TransactionFunctionDetailComparator implements Comparator<TransactionFunctionReport>
{
	@Override
	public int compare(TransactionFunctionReport o1, TransactionFunctionReport o2)
	{
		return o1.getTransactionFunction().getName().compareTo(o2.getTransactionFunction().getName());
	}
}