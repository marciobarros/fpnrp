package br.uniriotec.ese;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import br.uniriotec.ese.constantes.Aplicacao;
import br.uniriotec.ese.constantes.DistribuicaoDosDados;

public class GeraInformacoesEstatisticas {
	
	/**
	 * Gera os arquivos de entrada para leitura do script R
	 */
	public static void geraArquivosEntrada(String nomeTabelaMQ, String nomeTabelaEVM, String nomeTabelaEvolutionMQ) throws Exception {
		
		File arquivoMQ   = new File(ParserSimpl.CAMINHO+"saida_rr_mq_2000.txt");
		File arquivoEVM   = new File(ParserSimpl.CAMINHO+"saida_rr_evm_2000.txt");
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasMQ = ParserSimpl.retornaInstancias(arquivoMQ);
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasEVM = ParserSimpl.retornaInstancias(arquivoEVM);
		ParserSimpl.montaTabelaR(nomeTabelaMQ, instanciasMQ);
		ParserSimpl.montaTabelaR(nomeTabelaEVM, instanciasEVM);

		// desconsidera as linhas com maior tempo de execução
		File arquivoEvolutionMQ   = new File(ParserSimpl.CAMINHO+"saida rr mq 2000 details.txt");
		Map<Aplicacao,Map<DistribuicaoDosDados,List<Instancia>>> instanciasEvolutionMQ = ParserSimpl.retornaInstanciasEvolution(arquivoEvolutionMQ);
		ParserSimpl.montaTabelaR(nomeTabelaEvolutionMQ, instanciasEvolutionMQ);
	}
	
	/**
	 * Gera o script R
	 */
	public static void geraScriptR(String nomeTabelaMQ, String nomeTabelaEVM, String nomeTabelaEvolutionMQ) throws Exception {
		
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
			
			
			fileWriterPacotes.append("desvioPadraoET"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("mediaET"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("valoresET"+informacao+"Sobol <- NULL\r\n");
			fileWriterPacotes.append("wilcoxET"+informacao+"Values <- NULL\r\n");
			fileWriterPacotes.append("effectSizeET"+informacao+"Values <- NULL\r\n");
			fileWriterPacotes.append("mediaRR"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("desvioPadraoRR"+informacao+"Pseudo <- NULL\r\n");
			fileWriterPacotes.append("RR"+informacao+"Sobol <- NULL\r\n");
			
			fileWriterPacotes.append("i<-1\r\n");

			fileWriterPacotes.append("tabela"+informacao+"PSEUDO<-subset(tabela"+informacao+",tabela"+informacao+"$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.PSEUD.name()+"')\r\n");
			fileWriterPacotes.append("tabela"+informacao+"SOBOL<-subset(tabela"+informacao+",tabela"+informacao+"$"+ParserSimpl.CABECALHO_DISTRIBUICAO+"=='"+DistribuicaoDosDados.SOBOL.name()+"')\r\n");
			
			fileWriterPacotes.append("aplicacoes"+informacao+"<-names(table(tabela"+informacao+"PSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"))\r\n");
			
			fileWriterPacotes.append("for ( proj in aplicacoes"+informacao+" ) { \r\n");
			fileWriterPacotes.append("	tabela"+informacao+"PSEUDOProj<-subset(tabela"+informacao+"PSEUDO,tabela"+informacao+"PSEUDO$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
			fileWriterPacotes.append("	tabela"+informacao+"SOBOLProj<-subset(tabela"+informacao+"SOBOL,tabela"+informacao+"SOBOL$"+ParserSimpl.CABECALHO_APLICACAO+"==proj)\r\n");	
			fileWriterPacotes.append("	tamanho<-nrow(tabela"+informacao+"SOBOLProj)\r\n");	
			fileWriterPacotes.append("	tamanhoPSEUD<-nrow(tabela"+informacao+"PSEUDOProj)\r\n");	
			// Primeira tabela - 
			fileWriterPacotes.append("	minimos"+informacao+"Pseudo[proj]<-round(min(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+"),2)\r\n");
			fileWriterPacotes.append("	maximos"+informacao+"Pseudo[proj]<-round(max(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+"),2)\r\n");
			fileWriterPacotes.append("	media"+informacao+"Pseudo[proj]<-round(mean(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+"),2)\r\n");
			fileWriterPacotes.append("	desvioPadrao"+informacao+"Pseudo[proj]<-round(sd(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+"),2)\r\n");
			fileWriterPacotes.append("	wilcox"+informacao+"Values[proj]<-round(wilcox.test(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+",tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+")$p.value,2)\r\n");
			fileWriterPacotes.append("	valores"+informacao+"Sobol[proj]<-round(tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"[1],2)\r\n");
			fileWriterPacotes.append("	rx <- sum(rank(c(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+", tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_VALOR+"))[seq_along(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_VALOR+")])\r\n");
			fileWriterPacotes.append("	effectSize"+informacao+"Values[proj]<-round(((rx / tamanhoPSEUD - (tamanhoPSEUD + 1) / 2) / tamanho),2) \r\n");
			
			// Segunda tabela - Execution Time
			
			
			fileWriterPacotes.append("	mediaET"+informacao+"Pseudo[proj]<-round(mean(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+"),2)\r\n");
			fileWriterPacotes.append("	desvioPadraoET"+informacao+"Pseudo[proj]<-round(sd(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+"),2)\r\n");
			fileWriterPacotes.append("	wilcoxET"+informacao+"Values[proj]<-round(wilcox.test(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+",tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+")$p.value,2)\r\n");
			fileWriterPacotes.append("	valoresET"+informacao+"Sobol[proj]<-round(tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+",2)\r\n");
			fileWriterPacotes.append("	rxET <- sum(rank(c(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+", tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+"))[seq_along(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_TEMPO_DE_EXECUCAO+")])\r\n");
			fileWriterPacotes.append("	effectSizeET"+informacao+"Values[proj]<-round(((rxET / tamanhoPSEUD - (tamanhoPSEUD + 1) / 2) / tamanho),2) \r\n");
			
			
			
			fileWriterPacotes.append("	mediaRR"+informacao+"Pseudo[proj] <- round(mean(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_NUMEROS_DE_RESTART+"),2)\r\n");
			fileWriterPacotes.append("	desvioPadraoRR"+informacao+"Pseudo[proj] <- round(sd(tabela"+informacao+"PSEUDOProj$"+ParserSimpl.CABECALHO_NUMEROS_DE_RESTART+"),2)\r\n");
			fileWriterPacotes.append("	RR"+informacao+"Sobol[proj] <- round(tabela"+informacao+"SOBOLProj$"+ParserSimpl.CABECALHO_NUMEROS_DE_RESTART+",2)\r\n");
			
			fileWriterPacotes.append("	i<-i+1\r\n");
			fileWriterPacotes.append("}\r\n");
			fileWriterPacotes.append("resultados"+informacao+"<-data.frame(valores"+informacao+"Sobol,minimos"+informacao+"Pseudo,media"+informacao+"Pseudo,desvioPadrao"+informacao+"Pseudo,maximos"+informacao+"Pseudo,wilcox"+informacao+"Values,effectSize"+informacao+"Values)\r\n");
			fileWriterPacotes.append("resultados"+informacao+"\r\n");
			fileWriterPacotes.append("write.csv2(resultados"+informacao+",file = \"resultado"+informacao+".csv\")\r\n");
			
			
			fileWriterPacotes.append("resultadosET"+informacao+"<-data.frame(valoresET"+informacao+"Sobol,mediaET"+informacao+"Pseudo,desvioPadraoET"+informacao+"Pseudo,wilcoxET"+informacao+"Values,effectSizeET"+informacao+"Values,RR"+informacao+"Sobol,mediaRR"+informacao+"Pseudo,desvioPadraoRR"+informacao+"Pseudo)\r\n");
			fileWriterPacotes.append("write.csv2(resultadosET"+informacao+", file = \"resultadoTempoExecucao"+informacao+".csv\")\r\n");
		}
		
		String[] aplicacoesGrafico = { "XMLDOM", "DOM4J", "SEEMP" };
		fileWriterPacotes.append("#################################\r\n");
		fileWriterPacotes.append("# Gráficos\r\n");
		fileWriterPacotes.append("#################################\r\n");
		fileWriterPacotes.append("tabelaEvolutionMQ<-read.table(\"" + nomeTabelaEvolutionMQ + ".txt\",h=T,sep=\";\")\r\n");
		for (String aplicacao : aplicacoesGrafico) {
			fileWriterPacotes.append("===========> GRAFICO PARA APLICACAO " + aplicacao + "\r\n");
			fileWriterPacotes.append("proj=\"" + aplicacao + "\"\r\n");
			fileWriterPacotes.append("dadosSobol       <- subset(tabelaEvolutionMQ,tabelaEvolutionMQ$APLICACAO==proj & tabelaEvolutionMQ$DISTRIBUICAO==\"SOBOL\")\r\n");
			fileWriterPacotes.append("dadosPseudo      <- subset(tabelaEvolutionMQ,tabelaEvolutionMQ$APLICACAO==proj & tabelaEvolutionMQ$DISTRIBUICAO==\"PSEUD\")\r\n");
			fileWriterPacotes.append("temposExecucao   <- as.numeric(names(table(subset(tabelaEvolutionMQ$TEMPOEXECUCAO,tabelaEvolutionMQ$APLICACAO==proj))))\r\n");
			fileWriterPacotes.append("valoresMin <- NULL\r\n");
			fileWriterPacotes.append("valoresMax <- NULL\r\n");
			fileWriterPacotes.append("valoresMed <- NULL\r\n");
			fileWriterPacotes.append("i <- 1\r\n");
			fileWriterPacotes.append("for ( tempo in temposExecucao ) {\r\n");
			fileWriterPacotes.append("	valoresMin[i] <- min (subset(dadosPseudo$VALOR,dadosPseudo$TEMPOEXECUCAO==tempo))\r\n");
			fileWriterPacotes.append("	valoresMax[i] <- max (subset(dadosPseudo$VALOR,dadosPseudo$TEMPOEXECUCAO==tempo))\r\n");
			fileWriterPacotes.append("	valoresMed[i] <- mean(subset(dadosPseudo$VALOR,dadosPseudo$TEMPOEXECUCAO==tempo))\r\n");
			fileWriterPacotes.append("	i <- i + 1\r\n");
			fileWriterPacotes.append("}\r\n");
			fileWriterPacotes.append("\r\n");
			fileWriterPacotes.append("valoresSobol <- dadosSobol$VALOR\r\n");
			fileWriterPacotes.append("xrange<-range(0,2000)\r\n");
			fileWriterPacotes.append("yrange<-range(0,valoresSobol)\r\n");
			fileWriterPacotes.append("\r\n");
			fileWriterPacotes.append("plot(xrange, yrange, type=\"l\", xlab=\"Time Step\", ylab=\"MQ\")\r\n");
			fileWriterPacotes.append("title(proj)\r\n");
			fileWriterPacotes.append("\r\n");
			fileWriterPacotes.append("lines(temposExecucao, valoresMin  , type=\"l\", lwd=1.5, lty=2, col=\"black\", pch=18)\r\n"); 
			fileWriterPacotes.append("lines(temposExecucao, valoresMed  , type=\"l\", lwd=1.5, lty=1, col=\"black\", pch=18)\r\n"); 
			fileWriterPacotes.append("lines(temposExecucao, valoresMax  , type=\"l\", lwd=1.5, lty=4, col=\"black\", pch=18)\r\n");
			fileWriterPacotes.append("lines(temposExecucao, valoresSobol, type=\"l\", lwd=2.0, lty=1, col=\"black\", pch=18)\r\n");
		}
		
		fileWriterPacotes.close();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String nomeTabelaMQ = "TabelaMQ";
		String nomeTabelaEVM = "TabelaEVM";
		String nomeTabelaEvolutionMQ = "TabelaEvolutionMQ";
		
		geraArquivosEntrada(nomeTabelaMQ, nomeTabelaEVM, nomeTabelaEvolutionMQ);
		geraScriptR(nomeTabelaMQ, nomeTabelaEVM, nomeTabelaEvolutionMQ);
		
	}
}
