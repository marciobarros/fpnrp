package br.uniriotec.vitor.padilha.dissertacao.dataModel;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="data-model")
public class DataModel extends XmlFunctionPointElementWithParent<FunctionPointSystem> implements ElementValidator{

	private List<ILF> ilfs;
	
	
	private List<EIF> eifs;

	@XmlElement(required=false,name="ilf")
	public List<ILF> getIlfs() {
		return ilfs;
	}

	public void setIlfs(List<ILF> ilfs) {
		this.ilfs = ilfs;
	}
	@XmlElement(required=false,name="eif")
	public List<EIF> getEifs() {
		return eifs;
	}

	public void setEifs(List<EIF> eifs) {
		this.eifs = eifs;
	}

	@Override
	public boolean validate() throws ElementException {
		for(EIF eif:getEifs()) {
			if(!eif.validate())
				return false;
		}
		for(ILF ilf:getIlfs()) {
			if(!ilf.validate())
				return false;
		}
		return true;
	}
}
