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
		
		fileWriterPacotes.append("#################################\r\n");
		fileWriterPacotes.append("# Calcula min, max e desvio padrão para MQ\r\n");
		fileWriterPacotes.append("#################################\r\n");
		fileWriterPacotes.append("minimosMQPseudo <- NULL\r\n");
		fileWriterPacotes.append("maximosMQPseudo <- NULL\r\n");
		fileWriterPacotes.append("desvioPadraoMQPseudo <- NULL\r\n");
		fileWriterPacotes.append("mediaMQPseudo <- NULL\r\n");
		fileWriterPacotes.append("valoresMQSobol <- NULL\r\n");
		fileWriterPacotes.append("wilcoxMQValues <- NULL\r\n");
		fileWriterPacotes.append("effectSizeMQValues <- NULL\r\n");
		fileWriterPacotes.append("i<-1\r\n");

		fileWriterPacotes.append("tabelaMQPSEUDO<-subset(tabelaMQ,tabelaMQ$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.PSEUD.name()+"')\r\n");
		fileWriterPacotes.append("tabelaMQSOBOL<-subset(tabelaMQ,tabelaMQ$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.SOBOL.name()+"')\r\n");
		
		fileWriterPacotes.append("aplicacoes<-names(table(tabelaMQPSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"))\r\n");
		
		fileWriterPacotes.append("for ( proj in aplicacoes ) { \r\n");
		fileWriterPacotes.append("	tabelaMQPSEUDOProj<-subset(tabelaMQPSEUDO,tabelaMQPSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
		fileWriterPacotes.append("	tabelaMQSOBOLProj<-subset(tabelaMQSOBOL,tabelaMQSOBOL$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
		fileWriterPacotes.append("	tamanho<-nrow(tabelaMQSOBOLProj)\r\n");	
		fileWriterPacotes.append("	minimosMQPseudo[proj]<-min(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
		fileWriterPacotes.append("	maximosMQPseudo[proj]<-max(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
		fileWriterPacotes.append("	mediaMQPseudo[proj]<-mean(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
		fileWriterPacotes.append("	desvioPadraoMQPseudo[proj]<-sd(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
		fileWriterPacotes.append("	wilcoxMQValues[proj]<-wilcox.test(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+",tabelaMQSOBOLProj$"+ParserSimpl.CABECALHO_VALOR+")$p.value\r\n");
		fileWriterPacotes.append("	valoresMQSobol[proj]<-tabelaMQSOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"[1]\r\n");
		
		fileWriterPacotes.append("	rx <- sum(rank(c(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+", tabelaMQSOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"))[seq_along(tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")])\r\n");

		
		
		fileWriterPacotes.append("	effectSizeMQValues[proj]<-(rx / tamanho - (tamanho + 1) / 2)\r\n");
		
		
		fileWriterPacotes.append("	wilcox.test(tabelaMQSOBOLProj$"+ParserSimpl.CABECALHO_VALOR+",tabelaMQPSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")\r\n");
		
		fileWriterPacotes.append("	i<-i+1\r\n");
		fileWriterPacotes.append("}\r\n");
		fileWriterPacotes.append("resultadosMQ<-data.frame(valoresMQSobol,minimosMQPseudo,mediaMQPseudo,desvioPadraoMQPseudo,maximosMQPseudo,wilcoxMQValues,effectSizeMQValues)\r\n");
		fileWriterPacotes.append("resultadosMQ\r\n");
		
		
		
		
		
		fileWriterPacotes.close();
	}
}
