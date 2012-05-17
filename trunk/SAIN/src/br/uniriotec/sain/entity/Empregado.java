package br.uniriotec.sain.entity;

import java.util.Set;

public class Empregado extends Generic{
	
	

	private Cidade cidade;
	
	private Escolaridade escolaridade;
	
	private Set<Afastamento> afastamentos;
	
	private Set<Falta> faltas;
	
	private Set<HistoricoFuncional> cargos;
	
	private Set<HistoricoLotacao> lotacoes;
	
	private Set<HoraExtra> horasExtras;
	
	private Set<Gerente> gerencias;
	
	private Set<ContraCheque> contraCheques;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Set<Afastamento> getAfastamentos() {
		return afastamentos;
	}

	public void setAfastamentos(Set<Afastamento> afastamentos) {
		this.afastamentos = afastamentos;
	}

	public Set<Falta> getFaltas() {
		return faltas;
	}

	public void setFaltas(Set<Falta> faltas) {
		this.faltas = faltas;
	}

	public Set<HistoricoFuncional> getCargos() {
		return cargos;
	}

	public void setCargos(Set<HistoricoFuncional> cargos) {
		this.cargos = cargos;
	}

	public Set<HistoricoLotacao> getLotacoes() {
		return lotacoes;
	}

	public void setLotacoes(Set<HistoricoLotacao> lotacoes) {
		this.lotacoes = lotacoes;
	}

	public Set<ContraCheque> getContraCheques() {
		return contraCheques;
	}

	public void setContraCheques(Set<ContraCheque> contraCheques) {
		this.contraCheques = contraCheques;
	}

	public Set<HoraExtra> getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(Set<HoraExtra> horasExtras) {
		this.horasExtras = horasExtras;
	}

	public Set<Gerente> getGerencias() {
		return gerencias;
	}

	public void setGerencias(Set<Gerente> gerencias) {
		this.gerencias = gerencias;
	}
}
