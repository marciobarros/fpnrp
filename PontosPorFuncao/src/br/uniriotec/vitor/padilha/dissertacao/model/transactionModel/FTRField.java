package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Subset;

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
	@XmlTransient
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public boolean validate() throws ElementException {
	
		if(getName()==null || getName().equals(""))
		{
			throw new ElementException("Nome obrigatório",this);
		}
		if(getField()==null) {
			throw new ElementException("Campo não encontrado: "+getParent().getName()+" - "+getName(),this);
		}
		return true;
	}

	@Override
	public void charge() {
		for(DataModelElement dataModelElement:getParent().getParent().getParent().getParent().getDataModel().getDataModelElements()){
			if(dataModelElement.getName().equals(getParent().getDataModelElement())) {
				for(Subset subset:dataModelElement.getSubsets()){
					if(subset.getName().equals(getParent().getSubset())){
						for(Field field:subset.getFields()){
							if(field.getName().equals(getName())) {
								setField(field);
							}
						}
					}
				}
			}
		}		
	}
}
