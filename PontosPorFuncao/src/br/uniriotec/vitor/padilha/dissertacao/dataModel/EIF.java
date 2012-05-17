package br.uniriotec.vitor.padilha.dissertacao.dataModel;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;

@XmlType(name="eif")
public class EIF extends DataModelElement  implements ElementValidator{

	@Override
	@XmlTransient
	public DataModelElementType getType() {
		return DataModelElementType.EIF;
	}	
	
}
