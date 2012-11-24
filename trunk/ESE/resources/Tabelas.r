setwd(".\resources\")
# Tabela com informacoes do MQ para as aplicações para sobol e pseudo
tabelaMQ<-read.table("TabelaMQ.txt",h=T,sep=";")
# Tabela com informacoes do EVM para as aplicações para sobol e pseudo
tabelaEVM<-read.table("TabelaEVM.txt",h=T,sep=";")
#################################
# Calcula min, max e desvio padrão para MQ
#################################
minimosMQPseudo <- NULL
maximosMQPseudo <- NULL
desvioPadraoMQPseudo <- NULL
mediaMQPseudo <- NULL
valoresMQSobol <- NULL
wilcoxMQValues <- NULL
effectSizeMQValues <- NULL
i<-1
tabelaMQPSEUDO<-subset(tabelaMQ,tabelaMQ$DISTRIBUICAO=='PSEUD')
tabelaMQSOBOL<-subset(tabelaMQ,tabelaMQ$DISTRIBUICAO=='SOBOL')
aplicacoes<-names(table(tabelaMQPSEUDO$APLICACAO))
for ( proj in aplicacoes ) { 
	tabelaMQPSEUDOProj<-subset(tabelaMQPSEUDO,tabelaMQPSEUDO$APLICACAO==proj)
	tabelaMQSOBOLProj<-subset(tabelaMQSOBOL,tabelaMQSOBOL$APLICACAO==proj)
	tamanho<-nrow(tabelaMQSOBOLProj)
	minimosMQPseudo[proj]<-min(tabelaMQPSEUDOProj$VALOR)
	maximosMQPseudo[proj]<-max(tabelaMQPSEUDOProj$VALOR)
	mediaMQPseudo[proj]<-mean(tabelaMQPSEUDOProj$VALOR)
	desvioPadraoMQPseudo[proj]<-sd(tabelaMQPSEUDOProj$VALOR)
	wilcoxMQValues[proj]<-wilcox.test(tabelaMQPSEUDOProj$VALOR,tabelaMQSOBOLProj$VALOR)$p.value
	valoresMQSobol[proj]<-tabelaMQSOBOLProj$VALOR[1]
	rx <- sum(rank(c(tabelaMQPSEUDOProj$VALOR, tabelaMQSOBOLProj$VALOR))[seq_along(tabelaMQPSEUDOProj$VALOR)])
	effectSizeMQValues[proj]<-(rx / tamanho - (tamanho + 1) / 2)
	wilcox.test(tabelaMQSOBOLProj$VALOR,tabelaMQPSEUDOProj$VALOR)
	i<-i+1
}
resultadosMQ<-data.frame(valoresMQSobol,minimosMQPseudo,mediaMQPseudo,desvioPadraoMQPseudo,maximosMQPseudo,wilcoxMQValues,effectSizeMQValues)
resultadosMQ
