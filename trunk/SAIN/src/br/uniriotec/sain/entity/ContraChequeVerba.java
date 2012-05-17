package br.uniriotec.sain.entity;

public class ContraChequeVerba extends Generic {
	private ContraCheque contraCheque;
	
	private Verba verba;
	
	private Double valor;

	public ContraCheque getContraCheque() {
		return contraCheque;
	}

	public void setContraCheque(ContraCheque contraCheque) {
		this.contraCheque = contraCheque;
	}

	public Verba getVerba() {
		return verba;
	}

	public void setVerba(Verba verba) {
		this.verba = verba;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
