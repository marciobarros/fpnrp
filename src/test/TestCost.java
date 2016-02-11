package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.uniriotec.vitor.padilha.dissertacao.MainProgram;
import br.uniriotec.vitor.padilha.dissertacao.calc.ClassicFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.OptimizedFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.reader.FunctionsPointReader;

/**
 * Class that implements test cases for calculation of satisfaction
 * 
 * @author marciobarros
 */
public class TestCost
{
	@Test
	public void testGestaoPessoas() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		ClassicFunctionPointsCalculator classicCalculator = new ClassicFunctionPointsCalculator(system);
		OptimizedFunctionPointsCalculator optimizedCalculator = new OptimizedFunctionPointsCalculator(system);
		
		assertEquals(56, classicCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")));
		assertEquals(48, optimizedCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		assertEquals(23.0947, classicCalculator.calculateSatisfactionPercentile(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		
		assertEquals(61, classicCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		assertEquals(27.7136, classicCalculator.calculateSatisfactionPercentile(classicCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		
		assertEquals(56, classicCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(48, optimizedCalculator.calculateCost(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0184, classicCalculator.calculateSatisfactionPercentile(classicCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
	}
}