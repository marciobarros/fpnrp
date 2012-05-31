package br.uniriotec.vitor.padilha.dissertacao;

import org.xml.sax.Locator;

import com.sun.xml.internal.bind.annotation.XmlLocation;

public class XmlFunctionPointElement {
	
	@XmlLocation
	private Locator location;

	
	public Locator getLocation() {
		return location;
	}
	
}
