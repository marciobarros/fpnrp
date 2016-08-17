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
fpdata <- read.table(file="/Users/Marcio/Desktop/Codigos/fpnrp/result/analysis 393c/dados fpnrp.txt", sep=" ", header=TRUE);
cldata <- read.table(file="/Users/Marcio/Desktop/Codigos/fpnrp/result/analysis 393c/dados clnrp.txt", sep=" ", header=TRUE);

# drops the solution column
drops <- c("SOL", "CYCLE", "BEST")
fpdata <- fpdata[ , !(names(fpdata) %in% drops)]
cldata <- cldata[ , !(names(cldata) %in% drops)]

# Loads the data table library
library("data.table")
fpdt <- data.table(fpdata)
cldt <- data.table(cldata)

# Descriptive statistics for FP-NRP
fpmedians <- fpdt[, .(mean = median(FIT)), by=list(INST, MODEL, PERC)]
fpmedianByRound <- reshape(fpmedians, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

fpmaxs <- fpdt[, .(max = max(FIT)), by=list(INST, MODEL, PERC)]
fpmaxByRound <- reshape(fpmaxs, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

fpmins <- fpdt[, .(min = min(FIT)), by=list(INST, MODEL, PERC)]
fpminByRound <- reshape(fpmins, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

# Descriptive statistics for CL-NRP
clmedians <- cldt[, .(mean = median(FIT)), by=list(INST, MODEL, PERC)]
clmedianByRound <- reshape(clmedians, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

clmaxs <- cldt[, .(max = max(FIT)), by=list(INST, MODEL, PERC)]
clmaxByRound <- reshape(clmaxs, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

clmins <- cldt[, .(min = min(FIT)), by=list(INST, MODEL, PERC)]
clminByRound <- reshape(clmins, idvar = c("MODEL", "PERC"), timevar = "INST", direction = "wide")

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

# confidence interval ???