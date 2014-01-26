package br.uniriotec.vitor.padilha.dissertacao.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

import br.uniriotec.vitor.padilha.dissertacao.algorithm.Algorithms;
import br.uniriotec.vitor.padilha.dissertacao.calculator.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.engine.GenerateReleasesInstancesForExperiment;
import br.uniriotec.vitor.padilha.dissertacao.listener.mono.FunctionsPointDetailsListener;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.utils.FunctionsPointReader;

public class MainProgram {
	private static final int CICLOS = 50;
	private static final int LIMITES_PONTOS_POR_FUNCAO = 2000;
	private static final String[] INSTANCES_NAMES = new String[]{"Academico","GestaoDePessoas","Parametros","BolsaDeValores"};
	private static final Algorithms[] ALGORITHMS = new Algorithms[]{Algorithms.NSGAII,Algorithms.SPEA2};
	public static void main(String[] args) throws Exception
	{
	    
		for (String instance : INSTANCES_NAMES) {
			FunctionsPointReader reader = new FunctionsPointReader(FunctionsPointDetailsListener.getProp().getProperty("diretorio.instancia")+instance+"/functions-point.xml",FunctionsPointDetailsListener.getProp().getProperty("diretorio.instancia")+instance+"/stakeholders-interest.xml");
			FunctionPointSystem functionPointSystem = reader.read();
			FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator();
	       	// Executa os experimentos com algoritmos genéticos
	       	GenerateReleasesInstancesForExperiment ga = new GenerateReleasesInstancesForExperiment();
	       	Algorithms[] algorithms = new Algorithms[1];
	       	if(ALGORITHMS.length==0) {
		      	System.out.println("Informe o algoritmo que deseja utilizar:");
				int algorithmNumber = 0;
				Scanner in = new Scanner(System.in);
				System.out.print("Digite ");
				for(int i=0;i<Algorithms.values().length;i++){
					System.out.print(" "+(i+1)+" para "+Algorithms.values()[i]+", ");
				}
				System.out.println("");
				while (algorithmNumber<1 || algorithmNumber>Algorithms.values().length){
					System.out.println("Numero inválido, digite novamente: ");
					algorithmNumber = in.nextInt();
					System.out.println("");
				}
				algorithms[0] = Algorithms.values()[algorithmNumber-1];
	       	}
	       	else {
	       		algorithms = ALGORITHMS;
	       	}
//			
	       	for (int i = 0; i < algorithms.length; i++) {
	       		System.out.println("Processando Algoritmo "+ algorithms[i].name()+" para instância "+ instance);
	       		ga.setListerner(new FunctionsPointDetailsListener("resources/saida"+algorithms[i].name()+".txt", true,functionPointCalculator,functionPointSystem, CICLOS, algorithms[i]));
		      	Vector<FunctionPointSystem> instancias = new Vector<FunctionPointSystem>();
				instancias.add(functionPointSystem);
		       	ga.run(algorithms[i], instancias, functionPointCalculator, LIMITES_PONTOS_POR_FUNCAO, 1, CICLOS);
			}
	    }		
	}
}
