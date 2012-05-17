package br.uniriotec.sain.entity;

import java.util.Date;

public class HoraExtra extends Generic {

	private Empregado empregado;
	
	private Gerente gerenteQueAprovou;
	
	private Date horarioInicio;
	
	private Date horarioTermino;
	
	//
	//private Time 

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Gerente getGerenteQueAprovou() {
		return gerenteQueAprovou;
	}

	public void setGerenteQueAprovou(Gerente gerenteQueAprovou) {
		this.gerenteQueAprovou = gerenteQueAprovou;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(Date horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
}
