package br.uniriotec.vitor.padilha.dissertacao.dataModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="field")
public class Field extends XmlFunctionPointElementWithParent<Subset> implements ElementValidator{

	private String name;
	
	private String ref;
	
	private String description;
	
	private Boolean primaryKey;

	private String dataModelElement;
	
	private Subset subsetRef;
	
	private Boolean flagcanBeDetInTransation;
	
	@XmlAttribute(required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(required=false)
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@XmlAttribute(required=false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean validate() throws ElementException {
		if(getName()==null || getName().equals(""))
		{
			throw new ElementException("Nome obrigatório",this);
		}
		if(getRef()!=null && !getRef().equals("")) {
			if(getDataModelElement()==null || getDataModelElement().equals("")){
				setDataModelElement(getRef());
			}
			boolean achouElement = false;
			for(DataModelElement modelElement:getParent().getParent().getParent().getEifs()){
				if(modelElement.getName()!=null && modelElement.getName().equals(getDataModelElement())) {
					for(Subset subset:modelElement.getSubsets()){
						if(subset.getName().equals(getRef())) {
							achouElement=true;
							setSubsetRef(subset);
						}
					}
				}
			}
			for(DataModelElement modelElement:getParent().getParent().getParent().getIlfs()){
				if(modelElement.getName()!=null && modelElement.getName().equals(getDataModelElement())) {
					for(Subset subset:modelElement.getSubsets()){
						if(subset.getName().equals(getRef())) {
							achouElement=true;
							setSubsetRef(subset);
						}
					}
				}
			}
			if(!achouElement) {
				throw new ElementException("Elemento: "+getDataModelElement()+"."+getRef()+" não encontrado", this);
			}
		}
		return true;
	}

	@XmlAttribute(required=false)
	public String getDataModelElement() {
		return dataModelElement;
	}

	public void setDataModelElement(String dataModelElement) {
		this.dataModelElement = dataModelElement;
	}

	@XmlAttribute(required=false)
	public Boolean getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	@XmlTransient
	public Subset getSubsetRef() {
		return subsetRef;
	}

	public void setSubsetRef(Subset subsetRef) {
		this.subsetRef = subsetRef;
	}

	@XmlTransient
	public Boolean getFlagcanBeDetInTransation() {
		return flagcanBeDetInTransation;
	}

	public void setFlagcanBeDetInTransation(Boolean flagcanBeDetInTransation) {
		this.flagcanBeDetInTransation = flagcanBeDetInTransation;
	}
}
