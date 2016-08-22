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
fpdata <- read.table(file="/Users/Marcio/Desktop/Codigos/fpnrp/result/ciclos/dados fpnrp.txt", sep=" ", header=TRUE);
cldata <- read.table(file="/Users/Marcio/Desktop/Codigos/fpnrp/result/ciclos/dados clnrp.txt", sep=" ", header=TRUE);

# drops the solution column
drops <- c("SOL", "CYCLE", "BEST")
fpdata <- fpdata[ , !(names(fpdata) %in% drops)]
cldata <- cldata[ , !(names(cldata) %in% drops)]

# Instances and percentiles
instances <- unique(fpdata$INST)
percentiles <- unique(fpdata$PERC)

# Loads the data table library
library("data.table")
fpdt <- data.table(fpdata)
cldt <- data.table(cldata)

#
# Descriptive statistics for FP-NRP
#
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

#
# Normality tests
#
for (instance_ in instances)
{
	for (percentile_ in percentiles)
	{
		cls <- subset(cldata, INST == instance_ & PERC == percentile_ & MODEL == "CL")$FIT
		
		if (shapiro.test(cls)$p.value > 0.05) {
			warning(paste("CL ", instance_, " @", percentile_, " showed normal distribution.", sep=""))
		}
		
		fp <- subset(fpdata, INST == instance_ & PERC == percentile_ & MODEL == "FP")$FIT
		
		if (shapiro.test(fp)$p.value > 0.05) {
			warning(paste("FP ", instance_, " @", percentile_, " showed normal distribution.", sep=""))
		}
	}
}

#
# Inference tests, confidence interval and effect-size
#
names <- c()
pvalues <- c()
conf.lower <- c()
conf.upper <- c()
effectsizes <- c()

for (instance_ in instances)
{
	for (percentile_ in percentiles)
	{
		cls <- subset(cldata, INST == instance_ & PERC == percentile_ & MODEL == "CL")$FIT
		fp <- subset(fpdata, INST == instance_ & PERC == percentile_ & MODEL == "FP")$FIT
		
		name <- paste(instance_, "-", percentile_, sep="")
		names <- c(names, name)
		
		wt <- wilcox.test(cls, fp, conf.int=TRUE, conf.level=0.95)
		
		pvalues <- c(pvalues, wt$p.value)
		conf.lower <- c(conf.lower, wt$conf.int[1])
		conf.upper <- c(conf.upper, wt$conf.int[2])
		
		effectsize <- vargha.delaney(cls, fp)
		effectsizes <- c(effectsizes, effectsize)
	}
}

result <- data.frame(instance=names, pvalue=pvalues, lower=conf.lower, upper=conf.upper, es=effectsizes)

#
# Line charts
#
pdf(file = "rplot.pdf", 8, 8)
par(mfrow=c(2, 2))
par(mar=c(2.5, 2.5, 2.0, 0.1))
par(mai=c(0.5, 0.5, 0.25, 0.1))
par(mgp=c(1.0, 0.0, 0.0))
par(lab=c(9, 9, 7))
par(tck=-0.01)

for (instance_ in instances)
{
	cl1 <- c()
	fp1 <- c()
	
	for (percentile_ in percentiles)
	{
		cls <- median(subset(cldata, INST == instance_ & PERC == percentile_ & MODEL == "CL")$FIT)
		fp <- median(subset(fpdata, INST == instance_ & PERC == percentile_ & MODEL == "FP")$FIT)
		
		cl1 <- c(cl1, cls)
		fp1 <- c(fp1, fp)
	}

	x <- seq(from = 10, to = 90, by = 10)
	xrange <- range(x)
	yrange <- range(c(cl1, fp1)) 

	plot(xrange, yrange, type="n", cex.axis=0.7, xlab="Effort (% Total)", ylab="Satisfaction (%)", main=instance_) 
	legend(xrange[1], yrange[2], c("CL-RP","FP-RP"), cex=0.8, col=c("red", "black"), pch=c(18,21), lty=c(1,2))

	lines(x, cl1, type="b", lwd=1.5, lty=1, col="red", pch=18) 
	lines(x, fp1, type="b", lwd=1.5, lty=2, col="black", pch=21) 
}

dev.off();
