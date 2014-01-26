package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="ret")
public class RET extends XmlFunctionPointElementWithParent<DataModelElement> implements ElementValidator{
	private List<DET> dets;
	
	private String name;
	
	private String extendsRet;

	@XmlElement(required=false,name="det")	
	public List<DET> getDets() {
		return dets;
	}

	public void setDets(List<DET> dets) {
		this.dets = dets;
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
		for(DET field:getDets()) {
			if(!field.validate())
				return false;
		}
		return true;
	}

	/**
	 * Verifica se o RET faz parte de um único conjunto. Empregado, Estagiário, Requisitado seriam todo um Contrato, portanto seria preenchido Contrato.
	 * @return
	 */
	public String getExtendsRet() {
		return extendsRet;
	}

	public void setExtendsRet(String extendsRet) {
		this.extendsRet = extendsRet;
	}

	@Override
	public void charge() {
		for(DET field:getDets()) {
			field.charge();
		}
	}
}
