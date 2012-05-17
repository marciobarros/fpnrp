package br.uniriotec.sain.entity;

import java.util.Date;

public class HistoricoLotacao  extends Generic{

	private MotivoTransferencia motivoTransferencia;
	
	private Empregado empregado;
	
	private CentroDeCusto centroDeCusto;
	
	private Date dataInicio;
	
	private Date dataTermino;

	public MotivoTransferencia getMotivoTransferencia() {
		return motivoTransferencia;
	}

	public void setMotivoTransferencia(MotivoTransferencia motivoTransferencia) {
		this.motivoTransferencia = motivoTransferencia;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
}
