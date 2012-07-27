package br.uniriotec.vitor.padilha.dissertacao.listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jmetal.base.Solution;
import jmetal.base.variable.Binary;
import unirio.experiments.monoobjective.execution.StreamMonoExperimentListener;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointFactory;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.utils.NumberUtils;
import br.uniriotec.vitor.padilha.dissertacao.view.IFunctionPointView;
import br.uniriotec.vitor.padilha.dissertacao.view.WebFunctionPointView;

public class FunctionsPointDetailsListener extends StreamMonoExperimentListener
{
	private FunctionPointCalculator functionPointCalculator;
	
	private FunctionPointSystem functionPointSystem;
	
	private int totalCycles;
	/**
	 * Inicializa o analisador de experimentos que publica resultados em arquivos
	 * 
	 * @param filename		Nome do arquivo que será usado como resultado
	 */
	public FunctionsPointDetailsListener(String filename, FunctionPointCalculator functionPointCalculator, FunctionPointSystem functionPointSystem, int totalCycles) throws FileNotFoundException
	{
		this(filename, false,functionPointCalculator,functionPointSystem, totalCycles);
	}

	/**
	 * Inicializa o analisador de experimentos que publica resultados em arquivos
	 * 
	 * @param filename		Nome do arquivo que será usado como resultado
	 */
	public FunctionsPointDetailsListener(String filename, boolean details, FunctionPointCalculator functionPointCalculator, FunctionPointSystem functionPointSystem, int totalCycles) throws FileNotFoundException
	{
		super(new OutputStreamWriter(new FileOutputStream(filename)), details);
		this.functionPointCalculator=functionPointCalculator;
		this.functionPointSystem=functionPointSystem;
		this.totalCycles = totalCycles;
	}

	/**
	 * Termina o experimento
	 */
	public void terminateExperiment() throws Exception
	{
		getWriter().close();
	}
	
	@Override
	public void publishCycle(int cycleNumber, int instanceNumber,
			Solution solution, long executionTime, double[] data)
			throws Exception {
		Binary conjuntoTestes = (Binary) solution.getDecisionVariables()[0];
		
		
		FunctionPointSystem functionPointSystem = FunctionPointFactory.getFunctionPointSystem(conjuntoTestes.bits_, this.functionPointSystem);
		println("Número de Pontos por função: "+ getFunctionPointCalculator().calculate(functionPointSystem));
		
		if((cycleNumber+1)==this.totalCycles){
			Long satisfaction = getFunctionPointCalculator().calculateUserSatisfaction(functionPointSystem);
			Long baseSatisfaction = getFunctionPointCalculator().calculateUserSatisfaction(this.functionPointSystem);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(new Date());
			IFunctionPointView functionPointView = new WebFunctionPointView();
			functionPointView.addSatisfactionPercentForFunctionPoint(functionPointSystem, NumberUtils.formatNumber(((satisfaction.doubleValue()/baseSatisfaction)*100),2));
			getFunctionPointCalculator().getFunctionsView().add(functionPointView);
			getFunctionPointCalculator().calculate(this.getFunctionPointSystem());
			getFunctionPointCalculator().calculate(functionPointSystem);
			//OutputStreamWriter grafo = new OutputStreamWriter(new FileOutputStream("resources/grafo-"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+".xdot"));
			OutputStreamWriter grafo = new OutputStreamWriter(new FileOutputStream("resources/grafo.xdot"));
			OutputStreamWriter grafoOnlyTransactions = new OutputStreamWriter(new FileOutputStream("resources/grafoOnlyTransactions.xdot"));
			grafo.write(this.getFunctionPointSystem().doDot(functionPointSystem,true));
			grafoOnlyTransactions.write(this.getFunctionPointSystem().doDot(functionPointSystem,false));
			for(IFunctionPointView view:getFunctionPointCalculator().getFunctionsView()){
				view.render();
			}
			grafo.close();
			grafoOnlyTransactions.close();
		}
	}

	public FunctionPointCalculator getFunctionPointCalculator() {
		return functionPointCalculator;
	}

	public void setFunctionPointCalculator(
			FunctionPointCalculator functionPointCalculator) {
		this.functionPointCalculator = functionPointCalculator;
	}

	public FunctionPointSystem getFunctionPointSystem() {
		return functionPointSystem;
	}

	public void setFunctionPointSystem(FunctionPointSystem functionPointSystem) {
		this.functionPointSystem = functionPointSystem;
	}
}