package br.uniriotec.vitor.padilha.dissertacao.transactionModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="FTRfield")
public class FTRField extends XmlFunctionPointElementWithParent<FTR> implements ElementValidator{

	private String name;
	
	private Field field;

	@XmlAttribute(required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public boolean validate() throws ElementException {
		List<DataModelElement> elements = new ArrayList<DataModelElement>();
		elements.addAll(getParent().getParent().getParent().getParent().getDataModel().getEifs());
		elements.addAll(getParent().getParent().getParent().getParent().getDataModel().getIlfs());
		for(DataModelElement dataModelElement:elements){
			if(dataModelElement.getName().equals(getParent().getDataModelElement())) {
				for(Subset subset:dataModelElement.getSubsets()){
					if(subset.getName().equals(getParent().getSubset())){
						for(Field field:subset.getFields()){
							if(field.getName().equals(getName())) {
								this.field=field;
							}
						}
					}
				}
			}
		}
		if(getName()==null || getName().equals(""))
		{
			throw new ElementException("Nome obrigatório",this);
		}
		return true;
	}
}
