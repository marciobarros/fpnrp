package br.uniriotec.vitor.padilha.dissertacao.dataModel;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ilf")
public class ILF extends DataModelElement{

	@Override
	@XmlTransient
	public DataModelElementType getType() {
		return DataModelElementType.ILF;
	}

}
