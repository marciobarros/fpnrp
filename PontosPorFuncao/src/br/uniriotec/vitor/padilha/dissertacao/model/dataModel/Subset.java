package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="subset")
public class Subset extends XmlFunctionPointElementWithParent<DataModelElement> implements ElementValidator{
	private List<Field> fields;
	
	private String name;
	
	private String extendsRet;

	@XmlElement(required=false,name="field")	
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@XmlAttribute(required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean validate() throws ElementException {
		if(this.getName()==null || this.getName().equals(""))
			throw new ElementException("Nome obrigatório",this);
		for(Field field:getFields()) {
			if(!field.validate())
				return false;
		}
		return true;
	}

	public String getExtendsRet() {
		return extendsRet;
	}

	public void setExtendsRet(String extendsRet) {
		this.extendsRet = extendsRet;
	}

	@Override
	public void charge() {
		for(Field field:getFields()) {
			field.charge();
		}
	}
}
