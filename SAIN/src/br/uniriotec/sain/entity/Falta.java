package br.uniriotec.sain.entity;

import java.sql.Date;

public class Falta {

	private Empregado empregado;
	
	private MotivoFalta motivoFalta;
	
	private Gerente gerenteAbonou;
	
	private Date dataFalta;

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public MotivoFalta getMotivoFalta() {
		return motivoFalta;
	}

	public void setMotivoFalta(MotivoFalta motivoFalta) {
		this.motivoFalta = motivoFalta;
	}

	public Gerente getGerenteAbonou() {
		return gerenteAbonou;
	}

	public void setGerenteAbonou(Gerente gerenteAbonou) {
		this.gerenteAbonou = gerenteAbonou;
	}

	public Date getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}
	
}
