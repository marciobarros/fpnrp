package br.uniriotec.vitor.padilha.dissertacao.engine;


public class GenerateReleasesInstancesForExperiment
{
//	private boolean monoObjective;
//
//	private FunctionPointSystem functionPointSystemReference;
//
////	private FunctionPointCalculator functionPointCalculator;
//
//	private Map<String, TransactionFunction> transactionsNamesOfReference;
//
//	private Map<String, DataElement> detsNamesOfReference;
//
//	protected FunctionsPointDetailsListener listerner;
//
//	public boolean isMonoObjective()
//	{
//		return monoObjective;
//	}
//
//	public void setMonoObjective(boolean monoObjective)
//	{
//		this.monoObjective = monoObjective;
//	}
//
//	@SuppressWarnings("unchecked")
//	public void run(Algorithms algorithmNumber, Vector<FunctionPointSystem> instance2, FunctionPointCalculator functionPointCalculator, Integer maxFunctionsPointValue, int releases, int ciclos) throws Exception
//	{
//		FunctionPointSystem instance = instance2.firstElement();
////		this.functionPointCalculator = functionPointCalculator;
//		this.functionPointSystemReference = instance;
//		configureElementsNames();
//		int numeroTransacoes = instance.getTransactionModel().getTransactionFunctions().size();
//		int numeroTransacoesFaltantes = numeroTransacoes;
//		Long baseSatisfaction = functionPointCalculator.calculateSatisfaction(instance);
//		int releaseNumber = 1;
//		Binary conjuntoTestesN = new Binary(numeroTransacoes);
//		for (int i = 0; i < numeroTransacoes; i++)
//		{
//			conjuntoTestesN.bits_.set(i, true);
//		}
//		publishSolution(0, 0, 0, 0, this.functionPointSystemReference, this.functionPointSystemReference, 0, conjuntoTestesN);
//		int functionsPointValue = 0;
//		if (numeroTransacoesFaltantes > 0)
//		{
//			IFunctionsPointExperiment<FunctionPointSystem> experiment = null;
//			if (monoObjective && numeroTransacoesFaltantes > 1)
//			{
//				experiment = new FunctionsPointMonoObjectiveExperiment();
//				((FunctionsPointMonoObjectiveExperiment) experiment).setAlgoritmo(algorithmNumber);
//				((FunctionsPointMonoObjectiveExperiment) experiment).setFunctionPointCalculator(functionPointCalculator);
//				((FunctionsPointMonoObjectiveExperiment) experiment).setNumeroMaximoDePontosDeFuncao(maxFunctionsPointValue);
//				((FunctionsPointMonoObjectiveExperiment) experiment).setNumeroTransacoesFaltantes(numeroTransacoesFaltantes);
//				((FunctionsPointMonoObjectiveExperiment) experiment).setBaseSatisfaction(baseSatisfaction);
//				((FunctionsPointMonoObjectiveExperiment) experiment).addListerner(new StreamMonoExperimentListener(new OutputStreamWriter(System.out), true));
//
//			} else if (numeroTransacoesFaltantes > 1)
//			{
//				FunctionsPointDetailsListener.criarDiretorio(functionPointSystemReference.getName());
//				FunctionsPointDetailsListener.criarDiretorio(functionPointSystemReference.getName() + "\\" + algorithmNumber.name());
//				int executionNumber = FunctionsPointDetailsListener.getLastExecutionNumber(functionPointSystemReference.getName() + "\\" + algorithmNumber.name());
//				FunctionsPointDetailsListener.criarDiretorio(functionPointSystemReference.getName() + "\\" + algorithmNumber.name() + "\\" + (executionNumber + 1));
//				
//				// FunctionsPointDetailsListener.deletar(algorithmNumber.name()+"\\output.txt");
//				// FunctionsPointDetailsListener.criarArquivo(algorithmNumber.name()+"\\output.txt");
////				experiment = new FunctionsPointMultiObjectiveExperiment();
////				((FunctionsPointMultiObjectiveExperiment) experiment).setAlgoritmo(algorithmNumber);
////				((FunctionsPointMultiObjectiveExperiment) experiment).setFunctionPointCalculator(functionPointCalculator);
////				((FunctionsPointMultiObjectiveExperiment) experiment).setNumeroMaximoDePontosDeFuncao(maxFunctionsPointValue);
////				((FunctionsPointMultiObjectiveExperiment) experiment).setNumeroTransacoesFaltantes(numeroTransacoesFaltantes);
////				((FunctionsPointMultiObjectiveExperiment) experiment).setBaseSatisfaction(baseSatisfaction);
////				((FunctionsPointMultiObjectiveExperiment) experiment).addListerner(new FileMultiExperimentListener(FunctionsPointDetailsListener.getResultDir() + functionPointSystemReference.getName() + "\\" + algorithmNumber.name() + "\\" + (executionNumber + 1) + "\\output_" + algorithmNumber.name() + ".txt", true));
//				
//				// ((FunctionsPointMultiObjectiveExperiment)experiment).addListerner(new
//				// FileMultiExperimentListener(new
//				// OutputStreamWriter(System.out), true));
//			}
//			experiment.run2(instance2, ciclos);
//			Map<Integer, Map<Integer, Vector<Solution>>> solutionSet = experiment.getSolutions();
//
//			for (Integer instanceNumberSolution : solutionSet.keySet())
//			{
//				Map<Integer, Vector<Solution>> solutionsInstance = solutionSet.get(instanceNumberSolution);
//				for (Integer cycleNumber : solutionsInstance.keySet())
//				{
//					Vector<Solution> solutions = solutionsInstance.get(cycleNumber);
//					int i = 1;
//					for (Solution solution : solutions)
//					{
//						Binary conjuntoTestes = (Binary) solution.getDecisionVariables()[0];
//						FunctionPointSystem pontosPorFuncao = FunctionPointFactory.getFunctionPointSystem(conjuntoTestes, this.functionPointSystemReference);
//						functionsPointValue = functionPointCalculator.calculate(pontosPorFuncao, releaseNumber, null);
//						// setImplementedInElementsOfRelease(pontosPorFuncao,
//						// releaseNumber);
//						// publishSolution(instanceNumberSolution,
//						// cycleNumber+1, releaseNumber, i, pontosPorFuncao,
//						// this.functionPointSystemReference,
//						// functionsPointValue, conjuntoTestes);
//						i++;
//					}
//				}
//			}
//
//			releaseNumber++;
//		}
//		initializeReference();
//		listerner.terminateExperiment();
//	}
//
//	/**
//	 * Configura o nomes das Transações e DET's para posteriormente verificar se
//	 * já foi implementada.
//	 */
//	private void configureElementsNames()
//	{
//		transactionsNamesOfReference = new HashMap<String, TransactionFunction>();
//		for (TransactionFunction transaction : functionPointSystemReference.getTransactionModel().getTransactionFunctions())
//		{
//			transactionsNamesOfReference.put(transaction.getName(), transaction);
//		}
//		detsNamesOfReference = new HashMap<String, DataElement>();
//		for (DataFunction dataModelElement : functionPointSystemReference.getDataModel().getDataFunctions())
//		{
//			for (RecordType ret : dataModelElement.getRecordTypes())
//			{
//				for (DataElement det : ret.getDataElements())
//				{
//					detsNamesOfReference.put(dataModelElement.getName() + "." + ret.getName() + "." + det.getName(), det);
//				}
//			}
//		}
//	}
//
////	private void setImplementedInElementsOfRelease(FunctionPointSystem pontosPorFuncao, int releaseNumber)
////	{
////		for (Transaction selectedTransaction : pontosPorFuncao.getTransactionModel().getTransactions())
////		{
////			if (selectedTransaction.getReleaseImplementation() == 0)
////				transactionsNamesOfReference.get(selectedTransaction.getName()).setReleaseImplementation(releaseNumber);
////		}
////		for (DataModelElement dataModelElement : pontosPorFuncao.getDataModel().getDataModelElements())
////		{
////			if (dataModelElement.getFunctionsPointValue() == null || dataModelElement.getFunctionsPointValue() == 0)
////			{
////				dataModelElement.setFunctionsPointValue(functionPointCalculator.calculateDataModelElementValue(dataModelElement, null, releaseNumber));
////			}
////			for (RET ret : dataModelElement.getRets())
////			{
////				for (DET det : ret.getDets())
////				{
////
////					detsNamesOfReference.get(dataModelElement.getName() + "." + ret.getName() + "." + det.getName()).setImplementada(true);
////				}
////			}
////		}
////	}
//
//	private void initializeReference()
//	{
//		for (TransactionFunction selectedTransaction : this.functionPointSystemReference.getTransactionModel().getTransactionFunctions())
//		{
//			selectedTransaction.setReleaseImplementation(0);
//		}
//		for (DataFunction dataModelElement : this.functionPointSystemReference.getDataModel().getDataFunctions())
//		{
//			dataModelElement.setFunctionsPointValue(0);
//			for (RecordType ret : dataModelElement.getRecordTypes())
//			{
//				for (DataElement det : ret.getDataElements())
//				{
//					det.setImplementada(false);
//				}
//			}
//		}
//	}
//
//	private void publishSolution(int instanceNumber, int cycleNumber, int releaseNumber, int solutionNumber, FunctionPointSystem pontosPorFuncao, FunctionPointSystem pontosPorFuncaoReferencia, int functionsPointValue, Binary binary) throws IOException, FileNotFoundException
//	{
//		listerner.publishSolution(instanceNumber, cycleNumber, releaseNumber, solutionNumber, pontosPorFuncao, pontosPorFuncaoReferencia, functionsPointValue, binary);
//	}
//
//	public FunctionsPointDetailsListener getListerner()
//	{
//		return listerner;
//	}
//
//	public void setListerner(FunctionsPointDetailsListener listerner)
//	{
//		this.listerner = listerner;
//	}
}