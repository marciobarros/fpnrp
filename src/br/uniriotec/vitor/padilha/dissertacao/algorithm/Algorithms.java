package br.uniriotec.vitor.padilha.dissertacao.algorithm;


public enum Algorithms {
	HILL_CLIMBING(true),
	GENETIC(true),
	RANDOM(true),
	NSGAII(false),
	MOCELL(false),
	SPEA2(false),
	PAES(false);
	
	private Algorithms( boolean monoobjective) {
		this.monoobjective = monoobjective;
	}

	private boolean monoobjective;

	public boolean isMonoobjective() {
		return monoobjective;
	}

	public void setMonoobjective(boolean monoobjective) {
		this.monoobjective = monoobjective;
	}
}
