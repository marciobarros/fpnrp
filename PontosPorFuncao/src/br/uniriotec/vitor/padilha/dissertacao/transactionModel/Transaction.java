package br.uniriotec.vitor.padilha.dissertacao.transactionModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="transaction",propOrder={"ftrList","dependencies"})
public class Transaction extends XmlFunctionPointElementWithParent<TransactionModel> implements ElementValidator{
	
	private String name;
	
	private Boolean errorMsg;
	
	private TransactionType type;
	
	private List<Dependency> dependencies;
	
	private List<FTR> ftrList;

	@XmlAttribute(required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(required=false)
	public Boolean getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Boolean errorMsg) {
		this.errorMsg = errorMsg;
	}

	@XmlAttribute(required=true)
	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	@XmlElementWrapper(name = "dependencies") 
	@XmlElement(name="dependency")
	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	@XmlElementWrapper(name = "ftr-list") 
	@XmlElement(name="ftr")
	public List<FTR> getFtrList() {
		return ftrList;
	}

	public void setFtrList(List<FTR> ftrList) {
		this.ftrList = ftrList;
	}

	@Override
	public boolean validate() throws ElementException {
		if(getName()==null || getName().equals(""))
		{
			throw new ElementException("Nome obrigat�rio!",this);
		}
		if(getType()==null || getType().equals("") || (!getType().equals(TransactionType.EI) && !getType().equals(TransactionType.EO) && !getType().equals(TransactionType.EQ)))
		{
			throw new ElementException("Tipo de transa��o inv�lida!",this);
		}
		if(getFtrList()!=null)
			for(FTR ftr:getFtrList()) {
				if(!ftr.validate()) {
					return false;
				}
			}
		if(getDependencies()!=null)
			for(Dependency dependency:getDependencies()) {
				if(!dependency.validate()) {
					return false;
				}
			}
		return true;
	}
	public String doDot() {
		String retorno = "";
		if(getDependencies()!=null) {	
			for(Dependency dependency:getDependencies()) {
				retorno+=getName()+"->"+dependency.getRef()+"\n";
			}
		}
		return retorno;
	}

}
