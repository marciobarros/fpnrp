package br.uniriotec.ese;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uniriotec.ese.constantes.Aplicacao;
import br.uniriotec.ese.constantes.DistribuicaoDosDados;

public class ParserSimpl {

	public static final String CABECALHO_APLICACAO = "APLICACAO";
	public static final String CABECALHO_DISTRIBUICAO = "DISTRIBUICAO";
	public static final String CABECALHO_CICLO = "CICLO";
	public static final String CABECALHO_VALOR = "VALOR";
	public static final String CABECALHO_TEMPO_DE_EXECUCAO = "TEMPOEXECUCAO";
	public static final String CABECALHO_NUMEROS_DE_RESTART = "NUMEROSDERESTART";
	//public static final String CAMINHO = "D://Google Drive//Mestrado//Engenharia de Software Experimental//Trabalho Experimentacao ES//";
	//public static final String CAMINHO = ".\\resources\\";
	//public static final String CAMINHO = "C://Documents and Settings//Alexandre//Meus documentos//Projetos//workspace_clustering//ESE//Resources//";
	public static final String CAMINHO = "D://Usuarios//094282050361//Meus documentos//Meus Projetos//workspace_clustering//ESE//resources//";

	public static Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> retornaInstancias (File arquivo) throws IOException {
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasPorTipo = new HashMap<Aplicacao, Map<DistribuicaoDosDados,List<Instancia>>>();
		
		BufferedReader in  = new BufferedReader(new FileReader(arquivo));
		String str;
		while (in.ready()) {
            str = in.readLine();
            if(!str.equals("")) {
            	String[] strSplit = str.split(";");
            	DistribuicaoDosDados distribuicao = DistribuicaoDosDados.valueOf(strSplit[0].trim());
            	String[] aplicacaoECiclo = strSplit[1].split("#");
            	Aplicacao aplicacao = Aplicacao.valueOf(aplicacaoECiclo[0].trim().toUpperCase());
            	int ciclo = Integer.valueOf(aplicacaoECiclo[1].trim());
            	long tempoDeExecucao = Long.valueOf(strSplit[2].trim());
            	double valor = Double.valueOf(strSplit[3].trim());
            	int numerosDeRestart = Integer.valueOf(strSplit[4].trim());
            	Instancia instancia = new Instancia();
            	instancia.setCiclo(ciclo);
            	instancia.setAplicacao(aplicacao);
            	instancia.setDistribuicao(distribuicao);
            	instancia.setValor(valor);
            	instancia.setNumeroDeRestart(numerosDeRestart);
            	instancia.setTempoDeExecucao(tempoDeExecucao);
            	if(instanciasPorTipo.get(aplicacao)==null) {
            		instanciasPorTipo.put(aplicacao, new HashMap<DistribuicaoDosDados, List<Instancia>>());
            	}
            	if(instanciasPorTipo.get(aplicacao).get(distribuicao)==null) {
            		instanciasPorTipo.get(aplicacao).put(distribuicao, new ArrayList<Instancia>());
            	}
            	instanciasPorTipo.get(aplicacao).get(distribuicao).add(instancia);
            }
		}
		in.close();
		return instanciasPorTipo;
	}
	
	public static void montaTabelaR(String nomeArquivo,Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instancias) throws IOException {
		File arquivoSaidaPacotes = new File(CAMINHO+nomeArquivo+".txt");
		FileWriter fileWriterPacotes = new FileWriter(arquivoSaidaPacotes);		
		
		fileWriterPacotes.append(CABECALHO_APLICACAO+";"+CABECALHO_DISTRIBUICAO+";"+CABECALHO_TEMPO_DE_EXECUCAO+";"+CABECALHO_VALOR+";"+CABECALHO_CICLO+";"+CABECALHO_NUMEROS_DE_RESTART);
		for(Aplicacao aplicacao:instancias.keySet()){			
			for(DistribuicaoDosDados distribuicao:instancias.get(aplicacao).keySet()){
				for(Instancia instancia:instancias.get(aplicacao).get(distribuicao)) {
					fileWriterPacotes.append("\r\n");
					fileWriterPacotes.append(aplicacao.name()+";"+distribuicao.name()+";"+(Double.valueOf(instancia.getTempoDeExecucao())/1000)+";"+instancia.getValor()+";"+instancia.getCiclo()+";"+instancia.getNumeroDeRestart());
				}
			}
		}
		fileWriterPacotes.close();
	}
	
	public static Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> retornaInstanciasEvolution(File arquivo) throws IOException {
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasPorTipo = new HashMap<Aplicacao, Map<DistribuicaoDosDados,List<Instancia>>>();
		
		long maxTempoExecucao = 0;
		int valorDivisao = 0;
		int contador  = 0;
		int intervalo = 1;
		
		BufferedReader in  = new BufferedReader(new FileReader(arquivo));
		String str;
		boolean cabecalho = true;
		boolean descartaAplicacao = false;
		DistribuicaoDosDados distribuicao = null;
		Aplicacao aplicacaoAnterior = null;
		Aplicacao aplicacao = null;
		int ciclo = -1;
		while (in.ready()) {
            str = in.readLine();
            if(str.equals("")) {
            	cabecalho = true;
            	continue;
            }
            
            if (cabecalho) {
            	String[] strSplit = str.split(" ");
            	distribuicao = DistribuicaoDosDados.valueOf(strSplit[0].trim());
            	aplicacao = Aplicacao.valueOf(strSplit[1].trim().toUpperCase());
            	if (aplicacaoAnterior==null||aplicacao!=aplicacaoAnterior)
            		ciclo = 0;
            	else
            		ciclo++;
            	aplicacaoAnterior = aplicacao;
            	cabecalho = false;
            	contador = 0;
            	
            	if (Aplicacao.isAplicacaoParaGrafico(aplicacao)) {
            		descartaAplicacao = false;
            		intervalo = Aplicacao.getIntervaloDadosGrafico(aplicacao);
            		maxTempoExecucao = Aplicacao.getValorMaximoDadosGrafico(aplicacao);
            		valorDivisao = Aplicacao.getValorDivisaoDadosGrafico(aplicacao);
            	}
            	else {
            		descartaAplicacao = true;
            	}
            }
            else if (!descartaAplicacao) {
            	String[] strSplit = str.split(";");
            	int i1 = 0;
            	int i2 = 1;
            	// algumas linhas estão com um elemento string a mais
            	if (strSplit.length==3) { 
            		i1 = 1; 
            		i2 = 2;
            	}
            	long tempoDeExecucao = Long.valueOf(strSplit[i1].trim());
            	double valor = Double.valueOf(strSplit[i2].trim());
            	
            	// desconsidera tempos maiores para o projeto
            	if (tempoDeExecucao>maxTempoExecucao) continue;
            	
            	// considera somente no intervalo
            	contador++;
            	if(contador != intervalo) {
            		continue;
            	}
            	contador = 0;

            	Instancia instancia = new Instancia();
            	instancia.setCiclo(ciclo);
            	instancia.setAplicacao(aplicacao);
            	instancia.setDistribuicao(distribuicao);
            	instancia.setValor(valor);
            	if (valorDivisao==0)
            		instancia.setTempoDeExecucao(tempoDeExecucao);
            	else
            		instancia.setTempoDeExecucao((long)(tempoDeExecucao/(double)valorDivisao));
            	instancia.setNumeroDeRestart(-1);
            	
            	if(instanciasPorTipo.get(aplicacao)==null) {
            		instanciasPorTipo.put(aplicacao, new HashMap<DistribuicaoDosDados, List<Instancia>>());
            	}
            	if(instanciasPorTipo.get(aplicacao).get(distribuicao)==null) {
            		instanciasPorTipo.get(aplicacao).put(distribuicao, new ArrayList<Instancia>());
            	}
            	instanciasPorTipo.get(aplicacao).get(distribuicao).add(instancia);
            }
		}
		in.close();
		return instanciasPorTipo;
	}
	
}
