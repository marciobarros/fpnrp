package br.uniriotec.vitor.padilha.dissertacao.calc;

import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;

/**
 * 
 * 
 * @author marciobarros
 */
public class DataModelStatus
{
	private DataModel dataModel;
	private DataFunctionStatus[] dataFunctionStatus;
	
	public DataModelStatus(DataModel dataModel)
	{
		this.dataModel = dataModel;
		createStatusForDataFunction(dataModel);
		clear();
	}
	
	private void createStatusForDataFunction(DataModel dataModel)
	{
		int count = dataModel.countDataFunctions();
		this.dataFunctionStatus = new DataFunctionStatus[count];
		
		for (int i = 0; i < count; i++)
		{
			DataFunction dataFunction = dataModel.getDataFunctionIndex(i);
			dataFunctionStatus[i] = new DataFunctionStatus(dataFunction);
		}
	}
	
	public void clear()
	{
		for (int i = 0; i < dataFunctionStatus.length; i++)
			dataFunctionStatus[i].clear();
	}
	
	public void useDataElement(DataElement det)
	{
		DataFunction df = det.getRecordType().getDataFunction();
		int index = dataModel.getIndexForDataFunction(df);
		dataFunctionStatus[index].useDataElement(det);
	}
	
	public DataFunctionStatus getDataFunctionStatus(DataFunction dataFunction)
	{
		int index = dataModel.getIndexForDataFunction(dataFunction);
		return dataFunctionStatus[index];
	}
}

/**
 * 
 * 
 * @author marciobarros
 */
class DataFunctionStatus
{
	private DataFunction dataFunction;
	private RecordTypeStatus[] recordTypeStatus;
	
	public DataFunctionStatus(DataFunction dataFunction)
	{
		this.dataFunction = dataFunction;
		createStatusForRecordTypes(dataFunction);
		clear();
	}
	
	private void createStatusForRecordTypes(DataFunction dataFunction)
	{
		int count = dataFunction.countRecordTypes();
		this.recordTypeStatus = new RecordTypeStatus[count];
		
		for (int i = 0; i < count; i++)
		{
			RecordType recordType = dataFunction.getRecordTypeIndex(i);
			recordTypeStatus[i] = new RecordTypeStatus(recordType);
		}
	}
	
	public void clear()
	{
		for (int i = 0; i < recordTypeStatus.length; i++)
			recordTypeStatus[i].clear();
	}
	
	public void useDataElement(DataElement det)
	{
		RecordType recordType = det.getRecordType();
		int index = dataFunction.getIndexForRecordType(recordType);
		recordTypeStatus[index].useDataElement(det);
	}
	
	public int countRecordTypes()
	{
		int counter = 0;
		
		for (int i = 0; i < recordTypeStatus.length; i++)
			if (recordTypeStatus[i].getFieldCounter() > 0)
				counter++;
		
		return counter;
	}
	
	public int countDataElements()
	{
		int counter = 0;
		
		for (int i = 0; i < recordTypeStatus.length; i++)
			counter += recordTypeStatus[i].getFieldCounter();
		
		return counter;
	}
}

/**
 * 
 * 
 * @author marciobarros
 */
class RecordTypeStatus
{
	private RecordType recordType;
	private int usedFieldMask;
	private @Getter int fieldCounter;
	
	public RecordTypeStatus(RecordType recordType)
	{
		this.recordType = recordType;
		clear();
	}
	
	public void clear()
	{
		usedFieldMask = 0;
		fieldCounter = 0;
	}
	
	public void useDataElement(int index)
	{
		int fieldMask = (1 << index);
		
		if ((usedFieldMask & fieldMask) == 0)
		{
			usedFieldMask |= (1 << index);
			fieldCounter++;
		}
	}
	
	public void useDataElement(DataElement det)
	{
		int index = recordType.getIndexForDataElement(det);
		useDataElement(index);
	}
}