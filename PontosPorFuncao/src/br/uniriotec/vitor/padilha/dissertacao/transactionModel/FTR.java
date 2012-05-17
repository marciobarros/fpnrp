package br.uniriotec.vitor.padilha.dissertacao.transactionModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Subset;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="ftr")
public class FTR extends XmlFunctionPointElementWithParent<Transaction> implements ElementValidator{

	private List<FTRField> fields;
	
	private String name;  
	private String subset; 
	private String dataModelElement;
	private Boolean useAllFields;
	private Subset subsetRef;

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute
	public String getSubset() {
		return subset;
	}

	public void setSubset(String subset) {
		this.subset = subset;
	}
	@XmlAttribute
	public String getDataModelElement() {
		return dataModelElement;
	}

	public void setDataModelElement(String dataModelElement) {
		this.dataModelElement = dataModelElement;
	}
	@XmlAttribute
	public Boolean getUseAllFields() {
		return useAllFields;
	}

	public void setUseAllFields(Boolean useAllFields) {
		this.useAllFields = useAllFields;
	}

	@XmlElement(name="field")
	public List<FTRField> getFields() {
		return fields;
	}

	public void setFields(List<FTRField> fields) {
		this.fields = fields;
	}

	public Subset getSubsetRef() {
		return subsetRef;
	}

	public void setSubsetRef(Subset subsetRef) {
		this.subsetRef = subsetRef;
	}

	@Override
	public boolean validate() throws ElementException {
		if(getName()==null || getName().equals(""))
		{
			throw new ElementException("Nome obrigatório",this);
		}
		String referencia = getName();
		if(getSubset()!=null && !getSubset().equals("")) {
			referencia=getSubset();
		}
		
		if(getSubset()==null || getSubset().equals("")){
			setSubset(getName());
		}
		if(getDataModelElement()==null || getDataModelElement().equals("")){
			setDataModelElement(getName());
		}

		boolean achouElement = false;
		for(DataModelElement modelElement:getParent().getParent().getParent().getDataModel().getEifs()){
			if(modelElement.getName()!=null && modelElement.getName().equals(getDataModelElement())) {
				for(Subset subset:modelElement.getSubsets()){
					if(subset.getName().equals(referencia)) {
						this.subsetRef = subset;
						achouElement=true;
					}
				}
			}
		}
		for(DataModelElement modelElement:getParent().getParent().getParent().getDataModel().getIlfs()){
			if(modelElement.getName()!=null && modelElement.getName().equals(getDataModelElement())) {
				for(Subset subset:modelElement.getSubsets()){
					if(subset.getName().equals(referencia)) {
						this.subsetRef = subset;
						achouElement=true;
					}
				}
			}
		}
		if(!achouElement) {
			throw new ElementException("Elemento: "+getDataModelElement()+"."+referencia+" não encontrado", this);
		}
		if(getFields()!=null) {
			for(FTRField ftrField:getFields()) {
				if(!ftrField.validate())
					return false;
			}
		}
		return true;
	}
}
