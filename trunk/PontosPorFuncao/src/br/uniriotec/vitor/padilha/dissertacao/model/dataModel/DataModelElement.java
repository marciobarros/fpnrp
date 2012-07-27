package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

public abstract class DataModelElement extends XmlFunctionPointElementWithParent<DataModel> implements ElementValidator{
	
	private List<Subset> subsets;
	
	private String name;
	
	private DataModelElementType type;
	
	@XmlTransient
	public DataModelElementType getType() {
		return type;
	}
	public void setType(DataModelElementType type){
		this.type = type;
	}
	
	@XmlElement(required=true,name="subset")
	public List<Subset> getSubsets() {
		return subsets;
	}

	public void setSubsets(List<Subset> subsets) {
		this.subsets = subsets;
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
		for(Subset subset:getSubsets()) {
			if(!subset.validate())
				return false;
		}
		return true;
	}
	@Override
	public void charge() {
		for(Subset subset:getSubsets()) {
			subset.charge();
		}		
	}
}
