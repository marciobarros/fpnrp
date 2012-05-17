package br.uniriotec.sain.entity;

public class SalarioCargo extends Generic{
	private Cargo cargo;
	private Double valor;
	private Long anoMesInicio;
	private Long anoMesTermino;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getAnoMesInicio() {
		return anoMesInicio;
	}

	public void setAnoMesInicio(Long anoMesInicio) {
		this.anoMesInicio = anoMesInicio;
	}

	public Long getAnoMesTermino() {
		return anoMesTermino;
	}

	public void setAnoMesTermino(Long anoMesTermino) {
		this.anoMesTermino = anoMesTermino;
	}
}
