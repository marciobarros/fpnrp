package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.uniriotec.vitor.padilha.dissertacao.MainProgram;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
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
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(48, calculator.calculateClassicCost(calculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")));
		assertEquals(48, calculator.calculateOptimizedCost(calculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		
		assertEquals(56, calculator.calculateClassicCost(calculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(56, calculator.calculateOptimizedCost(calculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		assertEquals(27.7136, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		
		assertEquals(48, calculator.calculateClassicCost(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(48, calculator.calculateOptimizedCost(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0184, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
	}
}