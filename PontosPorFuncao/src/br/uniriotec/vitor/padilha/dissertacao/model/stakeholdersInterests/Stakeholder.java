package br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;

@XmlType(name="stakeholder")
public class Stakeholder extends XmlFunctionPointElementWithParent<StakeholderInterests>{
	private String name;

	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
