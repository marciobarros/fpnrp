package br.uniriotec.vitor.padilha.dissertacao.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jmetal.qualityIndicator.GenerationalDistance;
import jmetal.qualityIndicator.Hypervolume;
import jmetal.qualityIndicator.Spread;
import unirio.experiments.multiobjective.analysis.model.MultiExperimentInstance;
import unirio.experiments.multiobjective.analysis.model.MultiExperimentResult;
import unirio.experiments.multiobjective.analysis.model.ParetoFront;
import unirio.experiments.multiobjective.analysis.reader.MultiExperimentFileReader;
import unirio.experiments.statistics.ExperimentalData2;
import unirio.experiments.statistics.ExperimentalData2.CycleInfos;
import unirio.experiments.statistics.Script2;
import unirio.experiments.statistics.Script2.DataSet;
import br.uniriotec.vitor.padilha.dissertacao.algorithm.Algorithms;
import br.uniriotec.vitor.padilha.dissertacao.listener.mono.FunctionsPointDetailsListener;
import br.uniriotec.vitor.padilha.dissertacao.marcio.GenerationFileReader;

@SuppressWarnings("unused")
public class MainProgram
{
	private static final String RESULT_DIRECTORY = "C:/Users/PADILHA/Desktop/resultadoAlgoritmo/instances/";

	private static final String BASE_DIRECTORY = FunctionsPointDetailsListener.getResultDir();
	private static final String DIRECTORY_NSGAII = BASE_DIRECTORY + Algorithms.NSGAII.name()+ "\\";
	private static final String DIRECTORY_SPEA2 = BASE_DIRECTORY + Algorithms.SPEA2.name()+ "\\";
	private static final String DIRECTORY_MOCELL = BASE_DIRECTORY + Algorithms.MOCELL.name()+"\\";
	private static final Integer SOLUTION_SIZE = 39;
	private static final Integer CYCLES = 50;
	//private static final NewInstance[] INSTANCES = new NewInstance[]{new NewInstance("Gestao De Pessoas",65),new NewInstance("Academico",39),new NewInstance("Parametros",98)};
	
	private static final NewInstance[] INSTANCES = new NewInstance[]{new NewInstance("Gestao De Pessoas",65),new NewInstance("Academico",39)};
	
	
//	private void saveGenerationFile(String filename, double[][] result, int dataCount, int generationCount, int cycleCount) throws Exception
//	{
//		PrintWriter out = new PrintWriter(new FileWriter(filename));
//		
//		for (int generation = 0; generation < generationCount; generation++)
//		{
//			for (int data = 0; data < dataCount; data++)
//				for (int cycle = 0; cycle < cycleCount; cycle++)
//					out.print(result[cycle][generation * dataCount + data] + "\t");
//			
//			out.println();
//		}
//		
//		out.close();
//	}

//	private void publishEvolutionQualityIndicators(String name, ParetoFront bestFrontier) throws Exception
//	{
//		double[][] nsgaII = new ExperimentGenerationFileReader().execute(DIRECTORY_NSGAII, name, 3, 200, 30, 5, 3, bestFrontier);
//		saveGenerationFile(RESULT_DIRECTORY.replace('/', '\\') + "eca_" + name + ".txt", nsgaII, 3, 200, 30);
//		
//		double[][] spea2 = new ExperimentGenerationFileReader().execute(DIRECTORY_SPEA2, name, 3, 200, 30, 5, 3, bestFrontier);
//		saveGenerationFile(RESULT_DIRECTORY.replace('/', '\\') + "evm_" + name + ".txt", spea2, 3, 200, 30);
//		
//		double[][] mocell = new ExperimentGenerationFileReader().execute(DIRECTORY_MOCELL, name, 3, 200, 30, 4, -1, bestFrontier);
//		saveGenerationFile(RESULT_DIRECTORY.replace('/', '\\') + "seca_" + name + ".txt", mocell, 3, 200, 30);
//	}
	private void saveGenerationFile(ExperimentalData2 experimentalData, Algorithms algorithm, String instanceName, Integer executionNumber) throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter(BASE_DIRECTORY + instanceName + "\\"+ algorithm.name()+ "\\"+executionNumber+"\\qualityIndicators_"+algorithm.name()+".txt"));
		
		for (CycleInfos cycleInfo : experimentalData.getData()) {
			for (String group : cycleInfo.getInfoValue().keySet()) {
				Double[] value = cycleInfo.getInfoValue().get(group);
				out.print(value[0] + "\t");
			}
			out.println();
		}
		out.println();
		
		
		out.close();
	}
	
	private Double[] transform(double[] init) {
		Double[] return1 = new Double[init.length];
		for(int i=0;i<init.length;i++) {
			if(init[i]<0)
					return1[i] = new Double(-init[i]);
				else
					return1[i] = new Double(init[i]);
		}
		return return1;
	}
	private ExperimentalData2 publishFrontier(MultiExperimentResult multiExperimentResult, Algorithms algorithm, String instanceName, Integer executionNumber) throws Exception
	{
			ExperimentalData2 return1 = new ExperimentalData2("data", algorithm.name(), instanceName, executionNumber);
			for (int i=0;i<multiExperimentResult.getInstanceIndex(0).getCycleCount();i++) {
				Map<String,Double[]> dataInfo = new HashMap<String, Double[]>();
				ParetoFront paretoFront = multiExperimentResult.getInstanceIndex(0).getCycleIndex(i).getFront();
				double[] satistacoes = new double[paretoFront.getValues().length];
				double[] pfs = new double[paretoFront.getValues().length];
				for(int j=0;j<paretoFront.getValues().length;j++){
					satistacoes[j] = paretoFront.getValues()[j][0];
					pfs[j] = paretoFront.getValues()[j][1];
				}
				dataInfo.put("satisfacao", transform(satistacoes));
				dataInfo.put("pf", transform(pfs));
				return1.addData(i, dataInfo);
			}
//			double[] algorithmName = new double[paretoFront.getSolutionSize()];
//			for (int i=0;i<algorithmName.length;i++) {
//				algorithmName[i] = algorithm.
//			}
			return return1;
	}
	
	private ExperimentalData2 publishEvolutionQualityIndicators(MultiExperimentInstance resInstance, ParetoFront bestFront, Algorithms algorithm, String instanceName, Integer executionNumber) throws Exception
	{
			ExperimentalData2 return1 = new ExperimentalData2("data", algorithm.name(), instanceName, executionNumber);
			for (int i=0;i<resInstance.getCycleCount();i++) {
				ParetoFront front = resInstance.getCycleIndex(i).getFront();
				double[][] bestFrontValues = bestFront.getValues();
				double[][] currentFrontValues = front.getValues();
				Map<String,Double[]> dataInfo = new HashMap<String, Double[]>();
				dataInfo.put("errt", new Double[]{1.0 - ((double)bestFront.countCommonVertices(front)) / front.getVertexCount()});
				dataInfo.put("gdst", new Double[]{new GenerationalDistance().generationalDistance(currentFrontValues, bestFrontValues, bestFront.getObjectiveCount())});
				dataInfo.put("sprd", new Double[]{new Spread().spread(currentFrontValues, bestFrontValues, bestFront.getObjectiveCount())});
				dataInfo.put("hpvl", new Double[]{new Hypervolume().hypervolume(currentFrontValues, bestFrontValues, bestFront.getObjectiveCount())});
				dataInfo.put("time", new Double[]{ resInstance.getCycleIndex(i).getExecutionTime()});
				return1.addData(i, dataInfo);
			}
			saveGenerationFile(return1, algorithm,  instanceName,  executionNumber);
			return return1;
	}
	private void saveBestFront(String name, String configuration, ParetoFront front, String instanceName) throws Exception
	{
		String filename = RESULT_DIRECTORY.replace('/', '\\') + instanceName+ "\\"+ configuration + "_" + name + ".txt";
		/*front.removeObjective(3);
		front.removeObjective(2);*/
		
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		out.println("cohe\tcoup");
		
		for (int i = 0; i < front.getVertexCount(); i++)
			out.println(-front.getVertex(i, 0) + "\t" + front.getVertex(i, 1));
		
		out.close();
	}
	
	//private MultiExperimentResult loadInstance(List<ExperimentalData> ecaData, Algorithms algorithm, int solutionSize) throws Exception
	private MultiExperimentResult loadInstance(Algorithms algorithm, int solutionSize, String instanceName, Integer executionNumber) throws Exception
	{
		System.out.println("Processando '" + algorithm.name() + "("+instanceName+", execução = "+executionNumber+")' ...");
		
		MultiExperimentResult result = (new MultiExperimentFileReader()).execute(BASE_DIRECTORY + "\\"+instanceName+ "\\" + algorithm + "\\"+executionNumber+"\\output_"+algorithm.name()+".txt", 1, CYCLES, 2, solutionSize);
		
		return result;
		
	}
	private ParetoFront getBestFront(ParetoFront ... paretosFront) {
		ParetoFront bestFront = null;
		for (int i =0; i<paretosFront.length;i++) {
			if(bestFront==null)
				bestFront = paretosFront[i].clone();
			else
				bestFront.merge(paretosFront[i]);
		}
		return bestFront;
	}
	private List<ParetoFront> getParetosFrontsFromExperimentResult(MultiExperimentResult experimentResult, int instanceNumber){
		List<ParetoFront> paretoFronts = new ArrayList<ParetoFront>();
		for(int i=0;i<experimentResult.getInstanceIndex(instanceNumber).getCycleCount();i++){
			paretoFronts.add(experimentResult.getInstanceIndex(instanceNumber).getCycleIndex(i).getFront());
		}
		
		return paretoFronts;
	}
	public static void main(String[] args) throws Exception
	{
		MainProgram mp = new MainProgram();
//		List<ExperimentalData> nSGAIIData = new ArrayList<ExperimentalData>();
//		List<ExperimentalData> spea2Data = new ArrayList<ExperimentalData>();
		
		File dir = new File(BASE_DIRECTORY);
		Map<String, ParetoFront> bestsFronts = new HashMap<String, ParetoFront>();
		Map<String,Map<Algorithms,Map<Integer,MultiExperimentResult>>> results = new HashMap<String, Map<Algorithms,Map<Integer,MultiExperimentResult>>>();
		Script2 script = new Script2(RESULT_DIRECTORY + "script.r");
		List<String> instancesNames = new ArrayList<String>();
		Set<String> algorithmsNames = new HashSet<String>();
		List<ExperimentalData2> datas = new ArrayList<ExperimentalData2>();
		if(dir.exists()) {
			for(NewInstance instance:INSTANCES){
				ParetoFront bestFront = null;
				File dirInstance = new File(BASE_DIRECTORY+"\\"+instance.getInstanceName());
				instancesNames.add(instance.getInstanceName());
				if(dirInstance.exists()) {
					if(!results.containsKey(instance.getInstanceName()))
						results.put(instance.getInstanceName(), new HashMap<Algorithms, Map<Integer,MultiExperimentResult>>());
					for(File dirInstanceAlgorithm:dirInstance.listFiles()){
						if(dirInstanceAlgorithm.isDirectory()) {
							boolean searchAlgorithm = false;
							for(Algorithms algorithmInt : Algorithms.values()){
								if(algorithmInt.name().equals(dirInstanceAlgorithm.getName()))
									searchAlgorithm = true;
							}
							if(!searchAlgorithm)
								continue;
							algorithmsNames.add(dirInstanceAlgorithm.getName());
							Algorithms algorithm = Algorithms.valueOf(dirInstanceAlgorithm.getName());
							if(!results.get(instance.getInstanceName()).containsKey(algorithm)) {
								results.get(instance.getInstanceName()).put(algorithm, new HashMap<Integer, MultiExperimentResult>());
							}
							for(File dirExecutionNumber:dirInstanceAlgorithm.listFiles()){
								Integer executionNumber = Integer.valueOf(dirExecutionNumber.getName());
								MultiExperimentResult resultAlgorithm = mp.loadInstance(algorithm, instance.getTransactionsNumber(),instance.getInstanceName(),executionNumber);
								results.get(instance.getInstanceName()).get(algorithm).put(executionNumber, resultAlgorithm);
								if(bestFront==null)
									bestFront = resultAlgorithm.getInstanceIndex(0).getBestFront().clone();
								else
									bestFront = mp.getBestFront(bestFront,resultAlgorithm.getInstanceIndex(0).getBestFront().clone());
								datas.add(mp.publishFrontier(resultAlgorithm, algorithm, instance.getInstanceName(), executionNumber));
								
							}
						}
					}
				}
				bestsFronts.put(instance.getInstanceName(), bestFront);
			}
		}
		DataSet dataSet = script.writeDataFile(RESULT_DIRECTORY+"datas.data", datas, "datas");
		script.loadFile(dataSet, RESULT_DIRECTORY+"datas.data");
		script.drawDispersionPlot(dataSet, "Pontos por Função", "Safisfação", "", instancesNames, algorithmsNames, "pf", "satisfacao", RESULT_DIRECTORY+"grafico-dispersao.jpg");
		List<ExperimentalData2> experimentalDataSet = new ArrayList<ExperimentalData2>();
		for (String instanceName : results.keySet()) {
			ParetoFront bestFront = bestsFronts.get(instanceName);
			for (Algorithms algorithm : results.get(instanceName).keySet()) {
				for (Integer executionNumber :  results.get(instanceName).get(algorithm).keySet()) {					
					ExperimentalData2 experimentalData = mp.publishEvolutionQualityIndicators(results.get(instanceName).get(algorithm).get(executionNumber).getInstanceIndex(0), bestFront, algorithm, instanceName, executionNumber);
					experimentalDataSet.add(experimentalData);
					String dirName = RESULT_DIRECTORY + instanceName + "/"+ algorithm.name() + "/"+ executionNumber + "/";
					String archiveName = dirName + algorithm.name()+"-"+instanceName+"-"+executionNumber+".data";
					
					DataSet dataSet1= script.writeDataFile(archiveName, experimentalData, algorithm.name());
					script.loadFile(dataSet1, archiveName);
					
					script.tableSummary(experimentalData, "errt", algorithm.name());
					script.tableSummary(experimentalData, "gdst", algorithm.name());
					script.tableSummary(experimentalData, "sprd", algorithm.name());
					script.tableSummary(experimentalData, "hpvl", algorithm.name());
					script.tableSummary(experimentalData, "time", algorithm.name());
					
					script.drawBoxPlot(experimentalData, "time", algorithm.name(), "Tempo de Execução - "+instanceName+" - "+algorithm.name());
					
					script.sendCommand("summary <- data.frame(meanTime=mean_"+algorithm.name()+"_time, sdTime=sd_"+algorithm.name()+"_time, minTime=min_"+algorithm.name()+"_time, maxTime=max_"+algorithm.name()+"_time, " +
							"meanErrt=mean_"+algorithm.name()+"_errt, sdErrt=sd_"+algorithm.name()+"_errt,  minErrt=min_"+algorithm.name()+"_errt, maxErrt=max_"+algorithm.name()+"_errt, " +
							"meanGdst=mean_"+algorithm.name()+"_gdst, sdGdst=sd_"+algorithm.name()+"_gdst, minGdst=min_"+algorithm.name()+"_gdst, maxGdst=max_"+algorithm.name()+"_gdst, " +
							"meanSpread=mean_"+algorithm.name()+"_sprd, sdSpread=sd_"+algorithm.name()+"_sprd, minSpread=min_"+algorithm.name()+"_sprd, maxSpread=max_"+algorithm.name()+"_sprd, " +
							"meanHpvl=mean_"+algorithm.name()+"_hpvl, sdHpvl=sd_"+algorithm.name()+"_hpvl, minHpvl=min_"+algorithm.name()+"_hpvl, maxHpvl=max_"+algorithm.name()+"_hpvl)");
					script.sendCommand("write.csv2(summary, quote=FALSE, file=\""+dirName+"/summary-"+algorithm.name()+"-"+instanceName+"-"+executionNumber+".csv\")");
			
					for (Algorithms algorithmComp : results.get(instanceName).keySet()) {
						if(!algorithmComp.equals(algorithm)) {
							for (Integer executionNumberComp :  results.get(instanceName).get(algorithmComp).keySet()) {
								ExperimentalData2 experimentalDataComp = mp.publishEvolutionQualityIndicators(results.get(instanceName).get(algorithmComp).get(executionNumberComp).getInstanceIndex(0), bestFront, algorithmComp, instanceName, executionNumberComp);
								String dirNameComp = RESULT_DIRECTORY + instanceName + "/"+ algorithmComp.name() + "/"+ executionNumberComp + "/";
								String archiveNameComp = dirNameComp + algorithmComp.name()+"-"+instanceName+"-"+executionNumberComp+".data";
								
								DataSet dataSet2 = script.writeDataFile(archiveNameComp, experimentalDataComp, algorithmComp.name());
								script.loadFile(dataSet2, archiveNameComp);
								script.tableMannWhitney(experimentalData, "errt", algorithm.name(), algorithmComp.name());
								script.tableMannWhitney(experimentalData, "gdst", algorithm.name(), algorithmComp.name());
								script.tableMannWhitney(experimentalData, "sprd", algorithm.name(), algorithmComp.name());
								script.tableMannWhitney(experimentalData, "hpvl", algorithm.name(), algorithmComp.name());
								script.tableMannWhitney(experimentalData, "time", algorithm.name(), algorithmComp.name());
								
								script.tableEffectSize(experimentalData, "errt", algorithm.name(), algorithmComp.name());
								script.tableEffectSize(experimentalData, "gdst", algorithm.name(), algorithmComp.name());
								script.tableEffectSize(experimentalData, "sprd", algorithm.name(), algorithmComp.name());
								script.tableEffectSize(experimentalData, "hpvl", algorithm.name(), algorithmComp.name());
								script.tableEffectSize(experimentalData, "time", algorithm.name(), algorithmComp.name());
								
								String dirComp = RESULT_DIRECTORY+instanceName+"/"+algorithm.name()+"["+executionNumber+"]"+algorithmComp.name()+"["+executionNumberComp+"]";
								FunctionsPointDetailsListener.criarDiretorio(instanceName+"/"+algorithm.name()+"["+executionNumber+"]"+algorithmComp.name()+"["+executionNumberComp+"]");
								script.sendCommand("\npvalues <- data.frame(timee=pvalue_"+algorithm.name()+"_"+algorithmComp.name()+"_time, errt=pvalue_"+algorithm.name()+"_"+algorithmComp.name()+"_errt, gdst=pvalue_"+algorithm.name()+"_"+algorithmComp.name()+"_gdst, sprd=pvalue_"+algorithm.name()+"_"+algorithmComp.name()+"_sprd, hpvl=pvalue_"+algorithm.name()+"_"+algorithmComp.name()+"_hpvl)");
								script.sendCommand("write.csv2(pvalues, quote=FALSE, file=\""+dirComp+"/pvalues.csv\")");
								script.sendCommand("\neffectsizes <- data.frame( timee=effectsize1_"+algorithm.name()+"_"+algorithmComp.name()+"_time, errt=effectsize1_"+algorithm.name()+"_"+algorithmComp.name()+"_errt, gdst=effectsize1_"+algorithm.name()+"_"+algorithmComp.name()+"_gdst, sprd=effectsize1_"+algorithm.name()+"_"+algorithmComp.name()+"_sprd, hpvl=effectsize1_"+algorithm.name()+"_"+algorithmComp.name()+"_hpvl)");
								script.sendCommand("write.csv2(effectsizes, quote=FALSE, file=\""+dirComp+"/effectsizes.csv\")");
							}
						}
					}
				}
			}
			mp.saveBestFront("best", "best", bestFront, instanceName);
		}
		DataSet dataSet2 = script.writeDataFile(RESULT_DIRECTORY+"datas-quality.data", experimentalDataSet, "datasQuality");
		script.loadFile(dataSet2, RESULT_DIRECTORY+"datas-quality.data");
		script.drawBoxPlot(dataSet2, "Tempo de Execução", "time",instancesNames, RESULT_DIRECTORY+"boxplot-time.jpg");
		script.drawBoxPlot(dataSet2, "Error Ratio", "errt",instancesNames, RESULT_DIRECTORY+"boxplot-errt.jpg");
		script.drawBoxPlot(dataSet2, "Generational Distance", "gdst", instancesNames, RESULT_DIRECTORY+"boxplot-gdst.jpg");
		script.drawBoxPlot(dataSet2, "Spread", "sprd",instancesNames, RESULT_DIRECTORY+"boxplot-sprd.jpg");
		script.drawBoxPlot(dataSet2, "Hipervolume", "hpvl",instancesNames, RESULT_DIRECTORY+"boxplot-hpvl.jpg");
		
		script.close();
		
//		MultiExperimentResult resultNSGAII = mp.loadInstance(Algorithms.NSGAII, SOLUTION_SIZE);
//		MultiExperimentResult resultSPEA2 = mp.loadInstance(Algorithms.SPEA2, SOLUTION_SIZE);
//		ParetoFront bestFront = mp.getBestFront(resultNSGAII.getInstanceIndex(0).getBestFront(),resultSPEA2.getInstanceIndex(0).getBestFront());
//
//		nSGAIIData.addAll(mp.publishEvolutionQualityIndicators(resultNSGAII.getInstanceIndex(0), bestFront, Algorithms.NSGAII));
//		spea2Data.addAll(mp.publishEvolutionQualityIndicators(resultSPEA2.getInstanceIndex(0), bestFront, Algorithms.SPEA2));
//		mp.saveBestFront("best", "best", bestFront);
//		Script script = new Script(RESULT_DIRECTORY + "script.r");
//		script.writeDataFile(RESULT_DIRECTORY + "nsgaII.data", nSGAIIData, CYCLES);
//		script.writeDataFile(RESULT_DIRECTORY + "spea2.data", spea2Data, CYCLES);
//		
//		script.loadFile(Algorithms.NSGAII.name(), RESULT_DIRECTORY + "nsgaII.data");
//		script.loadFile(Algorithms.SPEA2.name(), RESULT_DIRECTORY + "spea2.data");
//
//		script.tableSummary(nSGAIIData, "errt", Algorithms.NSGAII.name());
//		script.tableSummary(nSGAIIData, "gdst", Algorithms.NSGAII.name());
//		script.tableSummary(nSGAIIData, "sprd", Algorithms.NSGAII.name());
//		script.tableSummary(nSGAIIData, "hpvl", Algorithms.NSGAII.name());
//		script.tableSummary(nSGAIIData, "time", Algorithms.NSGAII.name());
//
//		script.tableSummary(spea2Data, "errt", Algorithms.SPEA2.name());
//		script.tableSummary(spea2Data, "gdst", Algorithms.SPEA2.name());
//		script.tableSummary(spea2Data, "sprd", Algorithms.SPEA2.name());
//		script.tableSummary(spea2Data, "hpvl", Algorithms.SPEA2.name());
//		script.tableSummary(spea2Data, "time", Algorithms.SPEA2.name());
//		
//		
//		script.tableMannWhitney(nSGAIIData, "errt", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableMannWhitney(nSGAIIData, "gdst", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableMannWhitney(nSGAIIData, "sprd", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableMannWhitney(nSGAIIData, "hpvl", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableMannWhitney(nSGAIIData, "time", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		
//		script.tableEffectSize(nSGAIIData, "errt", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableEffectSize(nSGAIIData, "gdst", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableEffectSize(nSGAIIData, "sprd", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableEffectSize(nSGAIIData, "hpvl", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		script.tableEffectSize(nSGAIIData, "time", Algorithms.NSGAII.name(), Algorithms.SPEA2.name());
//		
//		script.sendCommand("\npvalues <- data.frame(timee=pvalue_NSGAII_SPEA2_time, errt=pvalue_NSGAII_SPEA2_errt, gdst=pvalue_NSGAII_SPEA2_gdst, sprd=pvalue_NSGAII_SPEA2_sprd, hpvl=pvalue_NSGAII_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(pvalues, quote=FALSE, file=\""+RESULT_DIRECTORY+"/pvalues.csv\")");
//
//		script.sendCommand("\neffectsizes <- data.frame( timee=effectsize1_NSGAII_SPEA2_time, errt=effectsize1_NSGAII_SPEA2_errt, gdst=effectsize1_NSGAII_SPEA2_gdst, sprd=effectsize1_NSGAII_SPEA2_sprd, hpvl=effectsize1_NSGAII_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(effectsizes, quote=FALSE, file=\""+RESULT_DIRECTORY+"/effectsizes-nsgaiixspea2.csv\")");
//
//		script.sendCommand("\neffectsizes <- data.frame( timee=effectsize2_NSGAII_SPEA2_time, errt=effectsize2_NSGAII_SPEA2_errt, gdst=effectsize2_NSGAII_SPEA2_gdst, sprd=effectsize2_NSGAII_SPEA2_sprd, hpvl=effectsize2_NSGAII_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(effectsizes, quote=FALSE, file=\""+RESULT_DIRECTORY+"/effectsizes-spea2xnsgaii.csv\")");
//		
//		script.sendCommand("means <- data.frame(mtNSGAII=mean_NSGAII_time, mtSPEA2=mean_SPEA2_time, meNSGAII=mean_NSGAII_errt, meSPEA2=mean_SPEA2_errt, mgNSGAII=mean_NSGAII_gdst, mgSPEA2=mean_SPEA2_gdst, msNSGAII=mean_NSGAII_sprd, msSPEA2=mean_SPEA2_sprd, mhNSGAII=mean_NSGAII_hpvl, mhSPEA2=mean_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(means, quote=FALSE, file=\""+RESULT_DIRECTORY+"/means.csv\")");
//
//		script.sendCommand("sds <- data.frame(sdtNSGAII=sd_NSGAII_time, sdtSPEA2=sd_SPEA2_time, sdeNSGAII=sd_NSGAII_errt, sdeSPEA2=sd_SPEA2_errt, sdgNSGAII=sd_NSGAII_gdst, sdgSPEA2=sd_SPEA2_gdst, sdsNSGAII=sd_NSGAII_sprd, sdsSPEA2=sd_SPEA2_sprd, sdhNSGAII=sd_NSGAII_hpvl, sdhSPEA2=sd_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(sds, quote=FALSE, file=\""+RESULT_DIRECTORY+"/sds.csv\")");
//		
//		script.sendCommand("min <- data.frame(mintNSGAII=min_NSGAII_time, mintSPEA2=min_SPEA2_time, mineNSGAII=min_NSGAII_errt, mineSPEA2=min_SPEA2_errt, mingNSGAII=min_NSGAII_gdst, sdgSPEA2=min_SPEA2_gdst, minsNSGAII=min_NSGAII_sprd, minsSPEA2=min_SPEA2_sprd, minhNSGAII=min_NSGAII_hpvl, minhSPEA2=min_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(min, quote=FALSE, file=\""+RESULT_DIRECTORY+"/min.csv\")");
//		
//		
//		script.sendCommand("max <- data.frame(maxtNSGAII=max_NSGAII_time, maxtSPEA2=max_SPEA2_time, maxeNSGAII=max_NSGAII_errt, maxeSPEA2=max_SPEA2_errt, maxgNSGAII=max_NSGAII_gdst, sdgSPEA2=max_SPEA2_gdst, maxsNSGAII=max_NSGAII_sprd, maxsSPEA2=max_SPEA2_sprd, maxhNSGAII=max_NSGAII_hpvl, maxhSPEA2=max_SPEA2_hpvl)");
//		script.sendCommand("write.csv2(max, quote=FALSE, file=\""+RESULT_DIRECTORY+"/max.csv\")");
//		
//		script.close();
	}
}

class NewExperimentGenerationFileReader extends GenerationFileReader
{
	@Override
	protected void calculateValue(ParetoFront front, ParetoFront bestFront, double[] data)
	{
		double[][] bestFrontValues = bestFront.getValues();
		double[][] currentFrontValues = front.getValues();

		data[0] = 1.0 - ((double)bestFront.countCommonVertices(front)) / front.getVertexCount();
		data[1] = new GenerationalDistance().generationalDistance(currentFrontValues, bestFrontValues, bestFront.getObjectiveCount());
		data[2] = new Spread().spread(currentFrontValues, bestFrontValues, bestFront.getObjectiveCount());
	}
}

class NewInstance {
	private String instanceName;
	NewInstance(String instanceName, Integer transactionsNumber) {
		super();
		this.instanceName = instanceName;
		this.transactionsNumber = transactionsNumber;
	}
	private Integer transactionsNumber;
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public Integer getTransactionsNumber() {
		return transactionsNumber;
	}
	public void setTransactionsNumber(Integer transactionsNumber) {
		this.transactionsNumber = transactionsNumber;
	}
}