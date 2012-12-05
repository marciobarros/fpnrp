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

	public static int getIntervaloDadosGrafico(Aplicacao aplicacao) {
		switch (aplicacao) {
			case SEEMP:
				return 1;
			case XMLDOM:
				return 10;
			case DOM4J:
				return 10;
			default:
				return 0;
		}
	}
	
	public static long getValorMaximoDadosGrafico(Aplicacao aplicacao) {
		switch (aplicacao) {
			case SEEMP:
				return 20000000;
			case XMLDOM:
				return 80000000;
			case DOM4J:
				return 80000000;
			default:
				return 0;
		}
	}

	public static int getValorDivisaoDadosGrafico(Aplicacao aplicacao) {
		switch (aplicacao) {
			case SEEMP:
				return 0;
			case XMLDOM:
				return 10;
			case DOM4J:
				return 10;
			default:
				return 0;
		}
	}
	
}
