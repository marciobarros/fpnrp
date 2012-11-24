package br.uniriotec.ese;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import br.uniriotec.ese.constantes.Aplicacao;
import br.uniriotec.ese.constantes.DistribuicaoDosDados;

public class GeraInformacoesEstatisticas {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File f = new File(".");
		File arquivoMQ   = new File(ParserSimpl.CAMINHO+"saida_rr_mq_2000.txt");
		File arquivoEVM   = new File(ParserSimpl.CAMINHO+"saida_rr_evm_2000.txt");
		
		String nomeTabelaMQ = "TabelaMQ";
		
		String nomeTabelaEVM = "TabelaEVM";
		
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasMQ = ParserSimpl.retornaInstancias(arquivoMQ);
		
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasEVM = ParserSimpl.retornaInstancias(arquivoEVM);
		
		ParserSimpl.montaTabelaR(nomeTabelaMQ, instanciasMQ);
		
		ParserSimpl.montaTabelaR(nomeTabelaEVM, instanciasEVM);
		
		File arquivoSaidaPacotes = new File(ParserSimpl.CAMINHO+"Tabelas"+".r");
		FileWriter fileWriterPacotes = new FileWriter(arquivoSaidaPacotes);		
		
		fileWriterPacotes.append("setwd(\""+ParserSimpl.CAMINHO+"\")\r\n");

		fileWriterPacotes.append("# Tabela com informacoes do MQ para as aplicações para sobol e pseudo\r\n");
		fileWriterPacotes.append("tabelaMQ<-read.table(\""+nomeTabelaMQ+".txt\",h=T,sep=\";\")\r\n");

		fileWriterPacotes.append("# Tabela com informacoes do EVM para as aplicações para sobol e pseudo\r\n");
		fileWriterPacotes.append("tabelaEVM<-read.table(\""+nomeTabelaEVM+".txt\",h=T,sep=\";\")\r\n");
		String[] informacoes = new String[]{"MQ","EVM"};
		for (String informacao : informacoes) {
			fileWriterPacotes.append("#################################\r\n");
			fileWriterPacotes.append("# Calcula min, max e desvio padrão para "+informacao+"\r\n");
			fileWriterPacotes.append("#################################\r\n");
			fileWriterPacotes.append("minimos"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("maximos"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("desvioPadrao"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("media"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("valores"+informacao+"Sobol <- NULL\r\n");
			fileWriterPacotes.append("wilcox"+informacao+"Values <- NULL\r\n");
			fileWriterPacotes.append("effectSize"+informacao+"Values <- NULL\r\n");
			fileWriterPacotes.append("i<-1\r\n");

			fileWriterPacotes.append("tabela"+informacao+"PSEUDO<-subset(tabela"+informacao+",tabela"+informacao+"$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.PSEUD.name()+"')\r\n");
			fileWriterPacotes.append("tabela"+informacao+"SOBOL<-subset(tabela"+informacao+",tabela"+informacao+"$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.SOBOL.name()+"')\r\n");
			
			fileWriterPacotes.append("aplicacoes"+informacao+"<-names(table(tabela"+informacao+"PSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"))\r\n");
			
			fileWriterPacotes.append("for ( proj in aplicacoes"+informacao+" ) { \r\n");
			fileWriterPacotes.append("	tabela"+informacao+"PSEUDOProj<-subset(tabela"+informacao+"PSEUDO,tabela"+informacao+"PSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
			fileWriterPacotes.append("	tabela"+informacao+"SOBOLProj<-subset(tabela"+informacao+"SOBOL,tabela"+informacao+"SOBOL$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
			fileWriterPacotes.append("	tamanho<-nrow(tabela"+informacao+"SOBOLProj)\r\n");	
			fileWriterPacotes.append("	tamanhoPSEUD<-nrow(tabela"+informacao+"PSEUDOProj)\r\n");	
			fileWriterPacotes.append("	minimos"+informacao+"Pseudo[proj]<-min(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
			fileWriterPacotes.append("	maximos"+informacao+"Pseudo[proj]<-max(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
			fileWriterPacotes.append("	media"+informacao+"Pseudo[proj]<-mean(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
			fileWriterPacotes.append("	desvioPadrao"+informacao+"Pseudo[proj]<-sd(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
			fileWriterPacotes.append("	wilcox"+informacao+"Values[proj]<-wilcox.test(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+",tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+")$p.value\r\n");
			fileWriterPacotes.append("	valores"+informacao+"Sobol[proj]<-tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"[1]\r\n");
			
			fileWriterPacotes.append("	rx <- sum(rank(c(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+", tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"))[seq_along(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")])\r\n");
			
			fileWriterPacotes.append("	effectSize"+informacao+"Values[proj]<-((rx / tamanhoPSEUD - (tamanhoPSEUD + 1) / 2) / tamanho) \r\n");
			fileWriterPacotes.append("	i<-i+1\r\n");
			fileWriterPacotes.append("}\r\n");
			fileWriterPacotes.append("resultados"+informacao+"<-data.frame(valores"+informacao+"Sobol,minimos"+informacao+"Pseudo,media"+informacao+"Pseudo,desvioPadrao"+informacao+"Pseudo,maximos"+informacao+"Pseudo,wilcox"+informacao+"Values,effectSize"+informacao+"Values)\r\n");
			fileWriterPacotes.append("resultados"+informacao+"\r\n");
		}
		
		
		
		
		
		
		fileWriterPacotes.close();
	}
}
