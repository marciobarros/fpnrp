package br.uniriotec.ese;

import br.uniriotec.ese.constantes.Aplicacao;
import br.uniriotec.ese.constantes.DistribuicaoDosDados;

public class Instancia {
	private int ciclo;	

	private DistribuicaoDosDados distribuicao;
	
	private Aplicacao aplicacao;
	
	private long tempoDeExecucao;
	
	private double valor;
	
	private int numeroDeRestart;
	
	private int numeroDoRestartQueEncontrouAMelhorSolucao;

	public DistribuicaoDosDados getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(DistribuicaoDosDados distribuicao) {
		this.distribuicao = distribuicao;
	}
	
	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public long getTempoDeExecucao() {
		return tempoDeExecucao;
	}

	public void setTempoDeExecucao(long tempoDeExecucao) {
		this.tempoDeExecucao = tempoDeExecucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumeroDeRestart() {
		return numeroDeRestart;
	}

	public void setNumeroDeRestart(int numeroDeRestart) {
		this.numeroDeRestart = numeroDeRestart;
	}

	public int getNumeroDoRestartQueEncontrouAMelhorSolucao() {
		return numeroDoRestartQueEncontrouAMelhorSolucao;
	}

	public void setNumeroDoRestartQueEncontrouAMelhorSolucao(
			int numeroDoRestartQueEncontrouAMelhorSolucao) {
		this.numeroDoRestartQueEncontrouAMelhorSolucao = numeroDoRestartQueEncontrouAMelhorSolucao;
	}
}
