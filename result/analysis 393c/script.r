# Clean up
rm(list=ls())
options(scipen=100, digits=4)

# Effect Size from Varga & Delaney (A12)
vargha.delaney <- function(r1, r2) {
	m <- length(r1);
	n <- length(r2);
	return ((sum(rank(c(r1, r2))[seq_along(r1)]) / m - (m + 1) / 2) / n);
}

# Load data - micro do Marcio
data <- read.table(file="/Users/Marcio/Desktop/Codigos/fpnrp/result/analysis 393c/dados.txt", sep=" ", header=TRUE);

# drops the solution column
drops <- c("SOL", "CYCLE", "BEST")
data <- data[ , !(names(data) %in% drops)]

# Loads the data table library
library("data.table")
dt <- data.table(data)

# Descriptive statistics
medians <- dt[, .(mean = median(FIT)), by=list(INST, MODEL, PERC)]
medianByRound <- reshape(medians, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

maxs <- dt[, .(max = max(FIT)), by=list(INST, MODEL, PERC)]
maxByRound <- reshape(maxs, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

mins <- dt[, .(min = min(FIT)), by=list(INST, MODEL, PERC)]
minByRound <- reshape(mins, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

# Inference tests and effect-size
instances <- unique(data$INST)
percentiles <- unique(data$PERC)

names <- c()
pvalues <- c()
effectsizes <- c()

for (instance_ in instances)
{
	for (percentile_ in percentiles)
	{
		cls <- subset(data, INST == instance_ & PERC == percentile_ & MODEL == "CLS")$FIT
		fp <- subset(data, INST == instance_ & PERC == percentile_ & MODEL == "FP")$FIT
		
		name <- paste(instance_, "-", percentile_, sep="")
		names <- c(names, name)
		
		pvalue <- wilcox.test(cls, fp)$p.value
		pvalues <- c(pvalues, pvalue)
		
		effectsize <- vargha.delaney(cls, fp)
		effectsizes <- c(effectsizes, effectsize)
	}
}

result <- data.frame(instance=names, pvalue=pvalues, es=effectsizes)
