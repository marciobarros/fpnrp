package br.uniriotec.vitor.padilha.dissertacao.main;

import java.io.OutputStreamWriter;
import java.util.Vector;

import unirio.experiments.monoobjective.execution.StreamMonoExperimentListener;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.experiment.FunctionsPointGAExperiment;
import br.uniriotec.vitor.padilha.dissertacao.listener.FunctionsPointDetailsListener;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.utils.FunctionsPointReader;

public class MainProgram {
	private static final int CICLOS = 1;
	
	private static final int LIMITES_PONTOS_POR_FUNCAO = 180;
	public static void main(String[] args) throws Exception
	{
		// Carrega os dados da instância desejada
		FunctionsPointReader reader = new FunctionsPointReader("resources/teste.xml","resources/grauInteresse.xml");

		FunctionPointSystem functionPointSystem = reader.read();
		FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator();

       	// Executa os experimentos com algoritmos genéticos
       	FunctionsPointGAExperiment ga = new FunctionsPointGAExperiment();
       	ga.setFunctionPointCalculator(functionPointCalculator);
       	ga.setMaxFunctionsPointValue(LIMITES_PONTOS_POR_FUNCAO);
       	ga.addListerner(new FunctionsPointDetailsListener("saida.txt", true,functionPointCalculator,functionPointSystem, CICLOS));
       	ga.addListerner(new StreamMonoExperimentListener(new OutputStreamWriter(System.out), true));
       	Vector<FunctionPointSystem> instancias = new Vector<FunctionPointSystem>();
		instancias.add(functionPointSystem);
       	ga.run(instancias, CICLOS);
	}
}
