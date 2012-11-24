package br.uniriotec.ese.constantes;

public enum Aplicacao {
	JODAMONEY,
	JXLSREADER,
	SEEMP,
	JAVAOCR,
	SERVLET,
	JXLSCORE,
	JPASSWORD,
	JUNIT,
	XMLDOM,
	TINYTIM,
	JAVACC,
	XMLAPI,
	JMETAL,
	DOM4J;
	
	public static boolean isAplicacaoParaGrafico(Aplicacao aplicacao) {
		if (aplicacao==Aplicacao.DOM4J)  return true;
		if (aplicacao==Aplicacao.XMLDOM) return true;
		if (aplicacao==Aplicacao.SEEMP)  return true;
		return false;
	}
}
