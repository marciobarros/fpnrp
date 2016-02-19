package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import br.uniriotec.vitor.padilha.dissertacao.MainProgram;
import br.uniriotec.vitor.padilha.dissertacao.calc.ClassicFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.OptimizedFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.reader.FunctionsPointReader;

/**
 * Class that implements test cases for calculation of cost in function points - instance PSOA
 * 
 * @author marciobarros
 */
public class TestCostGestaoPessoas
{
	private static SoftwareSystem system;
	private static ClassicFunctionPointsCalculator classicCalculator;
	private static OptimizedFunctionPointsCalculator optimizedCalculator;

	@BeforeClass
	public static void setup() throws Exception
	{
		system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		classicCalculator = new ClassicFunctionPointsCalculator(system);
		optimizedCalculator = new OptimizedFunctionPointsCalculator(system);
	}
	
	@Test
	public void testBasic() throws Exception
	{
		
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")));
		assertEquals(48, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		assertEquals(23.0947, classicCalculator.calculateSatisfactionPercentile(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
		
		assertEquals(61, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		assertEquals(27.7136, classicCalculator.calculateSatisfactionPercentile(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")), 0.0001);
		
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(48, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0184, classicCalculator.calculateSatisfactionPercentile(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
	}
	
	@Test
	public void testSolutionsFromDissertationClassic10p()
	{
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000010110111000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100011000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100000000001000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100000000001000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100011000000]")));
		assertEquals(22, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000010111001000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000010000000000000000000000000000001000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000010000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001101100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000101010000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001110100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000010100111000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000011110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100010000001000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000111010000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000011100100000000]")));
		assertEquals(22, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000010010100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(22, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000000110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000101111000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000011101100000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000100000000000000000000001000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000100000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100010000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000110111000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(28, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000101110000000]")));
		assertEquals(26, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000100001000000000]")));
		assertEquals(25, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100101000000]")));		
	}
	
	@Test
	public void testSolutionsFromDissertationClassic20p()
	{
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000110000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000001100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000001100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000110000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000000000000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(55, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")));
		assertEquals(55, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000010000000000000000000000000000000001000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000010001000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000001000000000000001000100001000000]")));
		assertEquals(55, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000011010000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000010000011000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000000000000000000000000000000000000101000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000010101011000000000000000001100110000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000001000000000000000000001000010100000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000000000000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(54, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000001000000000000000001001001100000000]")));
		assertEquals(55, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001100000000000000000000000000000000000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(53, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000010011000000000000000001100110000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")));
		assertEquals(56, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic30p()
	{
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000101001000011000000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000000100000000000000100010000000000000000111000100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100000000010011000010000000000000000000001101011000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000101000000000000011011001001000000000000000001110110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000101001100010000000000000000000011111100000000]")));
		assertEquals(111, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000101000000000010000100111000000000000000000000101110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001000000000001001010010000000000000000000001101100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000001001000010001000000000000000011001100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100000000000011010100010000000000000000001100101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000100001101001001000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000001101001011000000000000000001101100000000]")));
		assertEquals(111, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100000000100110100010001000000000000000001100111000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000000000100101000000000000000000100100101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000000011100010110000000000000000011100101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010010001000000000000001000001000000000000000000000010100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101000000000001011101001000000000000000000010110101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000100001110011101000000000000000001111101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000001111111000000000000000000000011010100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000101001010010000000000000000000001100101000000]")));
		assertEquals(111, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000101100110111000000000000000000011101100000000]")));
		assertEquals(111, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110001001000000000000010000010000000000000000000001000100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101000000000100011001011000000000000000000011100110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000101100000000000111000011001000000000000000001001110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000011101001001000000000000000000010100001000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000001000111011000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100000000101011100101000000000000000000001110001000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000011000010010000000000000000001101110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000110101100011000000000000000000001100101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001100000000000101010010011000000000000000011010100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000010101010011000000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101100000000000010100010000000000000000110000111100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000010000000000000000000000011011101100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000010001100010001000000000000000001001100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100000000101001000011000000000000000000001000110000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000100000000000000011000011001000000000000101001100001000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001000000000000000110011000000000000000010011000100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000100001001001001000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000100001110010011000000000000000001101100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000001011000010000000000000000000001100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000001000000000001001000100000000000000000000011110100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000001000010000000000000000000000000001000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000001000000000000010100000000000000000000011101100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000101011000001000000000000000000110101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000010001000010000000000000000000011100100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000101110100010000000000000000000010101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000000111010010000000000000000000011110110000000]")));
		assertEquals(111, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000101000000000001110100010010000000000000000011010100000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000101110100000000000000000000001111101000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000101000000000000000110010001000000000000111000110001000000]")));
		assertEquals(112, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000000100010000000000000000001001000101000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic40p()
	{
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111000000000000000000001100000000000000000000000011000001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000000100000000000000000000000000000101000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000100000000000010000011000000000000000000000101000000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000011000000000000000000000010011001001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011000000000000000000100000000100000000000000000000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000011000010000000000000000000000000110000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000001000000000000010000010000000000000000000000001100000000]")));
		assertEquals(82, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[01110000000000000000000001000000000000000000000000001100100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000011100000000000000000000001000000100000000]")));
		assertEquals(82, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000001000000000000000000000000000000000000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000100000000000000010100000000000000000000000000100100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000010010000000000000000000000010101001000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000100000000000000010000000000000000000000000000110010000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000011100000000000000000000001100010100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000100000000000000001010010000000000000000000000000001000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000011000000000000000000000010000001010000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000010100001000000000000000000011000001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000001000000000000000000000000010000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000011010000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000001100000000000000000000001010010001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010000000000000000000100000000000000000000000000111000000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000100100000000000010000000000000000000000000001000101000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010000000000000000000100000000000000000000000000000100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00011000000000000000000001000000000000000000000000000100010000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000100000000000000001000000000000000000000000001001001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000000010010001000000000000000000000000100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000000010000000000000000000000000000000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010000000000000000000000000000000000000000000001000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000011100000000000000000000001000010001000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000000000011000000000000000000010000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000010000010100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000010100000000000000000000000000101000000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000111000000100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000100000000000010010000000000000000000000000000111000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000100000000000000011000000000000000000000000000000100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000000000000000000010000000000000000000000000001101100000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000000100000000000000000000000000000100000000]")));
		assertEquals(82, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000010000000000000000000000001000100100000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000100000000000000010101000000000000000000000000000101000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000001000000000000000000000000000000010000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000011010001001000000000000000010000101000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011000000000000000000100000000000000000000000001011000000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000010000000000000000000000000001000001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000100001000000000000000000000000000000001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000010000000000000000000000000001000001000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000100000000000000001000001000000000000000000000101000000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000100000000000000001100001000000000000000000000000010000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000000110011000000000000000000010001000000000]")));
		assertEquals(84, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000000100000000000000000000000010000001000000]")));
		assertEquals(83, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000000000001000000000000000000001000100000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic50p()
	{
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100000000000011000010000000000000000110001110100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001100000000000011010011000000000000000010011111101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000000000000001100010001100000000000010000100100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010000000000000100001000011000000000000000011101111100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000000000000011110011000000000000000101011100101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010111000000000100001101010000010100000000000001101101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000011000010000000000000000010011010111000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100000000100000110010000000000000000011001000100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001100000000101111100011010000000000000000001101101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011001000000000000011100010000100100000000001100110101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010101000000000000001100010000000000000000011100100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000011001011000000000000000110000111101000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010101000000000000010110101000000000000000010011100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000010011101010001000000000000011001111110000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010111000000000100001000010000010000000000000011101111000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101000000000000001000010000000100000000010010110101000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000000110011000011001100100000000000011110100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010010001000000000000001000000000000100000000011101111101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111001000000000000101000011010100000000000000011110101000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001000000000010001100011001000000000000000001101111000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100000000000001000011000000000000000101001101100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100001101100000000000001000011000100000000000111001100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001100000000000001000011001100000000000000101100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001100000000000001100001001000000000000110001100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001000000000000001000010000000000000000010001101101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011111000000000111011010010000000000000000000001100100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100001001100000000000001010011001000000000000001001101100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110001000000000101111010011000100100000000000001111100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010100100000000000011000001001000000000000011001110101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101100000000000011100010000100000000000001001110100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101100000000000001110010000100000000000011001100001000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000000100000000000111000010000100000000000011001101100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001100000000000011010011010000000000000010001011001000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000100111000010011100000000000000011111110000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001000000000000001000010000000000000000110011100100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101000000000000101000100001100000000000000001111110000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001100000000000001000011000100000000000010011100101000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000000000011101100011001000000000000000001111100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111001101100000000000011100010010000000000000010101001101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010100100000000100001100011000000000000000011011001101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00011011001000000000000011000010000000000000000111001100100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000000010100011000000000000000111001100100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010101000000000110101000100010000000000000000001001100000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000010100010001000000000000010111101101000000]")));
		assertEquals(139, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111001101100000000100000100010000100000000000011001100101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000000011000011000000000000000010001110100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001000000000100001100010000100000000000001100110100000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110001000000000000001110010010010000000000000001110101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000101111000100010000000000000011101101101000000]")));
		assertEquals(140, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010011000000000000010110010000100000000000011000110100000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic60p()
	{
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101000000000100111100000000101011010000111001101101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010101110000000100000100011010110000000000011001111101000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101101000000000001110100000100100001000001001110101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101000000000000001100010001010000000100111011100100000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001010000000000001000011010100100001000011001110100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011100000000000100000010010000100000000000011001000100000010]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111000000000000000000011100010000000000001000010111110101110000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010011100000000001001100011000111000000000111011110111000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010101110100000000001110010000100000000100011101110101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010000000000000000011010010000000010000000010101100001100000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001110000000100001000010001000000000001011100100111000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100001011100100000000011010010010000100000000010001101100000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000000000110011100010010001000000000111111101110000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001000100000000001010110001000000000000111101101100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111001000000000010101000011010000100000000011001110111000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101111100000100010110010000000000001100111000100110000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000000000010000000000100010000000010000000011011000100001000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100001101000100000100011000111000000100001001110111101100000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001010000000100011100011011100000000000111001111100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010000010000000000000010010000000000000000010101101100100010]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001000000000101101010111100110000000000111101110100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000101000000000000010100011000100010001000011101001001100010]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010010000000000000100000100010000000000000000001111101100000010]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100000000010001011001010100100000000111011100110000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101000000000000100100100001100011000000011111111100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101000000000010000000000110010000100000001000010101111101110010]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011101010000000100000110011000010000000100111001100101000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110110001010000000100001100010000000000000000111101110111000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101001100110000000110010110100100110000000000110011100101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001110000000000010100010000000010000000101100011100100000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001000100000011100110011000100000001000111111110100000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011111110000000100011100011000100100001000111101101101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000100000010010000100010001000010011100101010000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011011100000000010101000011001010000000000011011110110000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110000000010100110010010100000000000111111101101000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101010000000000100100011010010100000000111100111100000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000100000000011100010000010100001000011001000111000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000010001110010010010000000000111101101110000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101110000000101000110010000000100000001011001100101000000]")));
		assertEquals(165, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010011100000000000101000011011110000000000111011111100000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[01101011001100000000001001011001010000000000000001111110111000000]")));
		assertEquals(166, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100100000000011110010001100100001000011011101101000000]")));
		assertEquals(167, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000100011100110010011100000000011011110110000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001010000000100100101000001100100001000111001110100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010000110000000110010100010001100000001010111101110100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001101000000010100100011000000000000000011111110100000000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010010101000000000000000100011000100000000000011001010001100000]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010000000000000000000000000000100010000000011101100100000010]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000001000000000000000110011000000010001000010101010101100010]")));
		assertEquals(168, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010011000000000000101111001010010000000000111001110100000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic70p()
	{
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001000010000000001010010001100000000000111101101100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001110000000100011100010000000100000000111101110100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010101000000000100011000010000100100001000111111101100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001110110000100001000011000000010001000011101110101111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101110110000100011000011000000000000000011101110100011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101110010001100011110011000000000000000011001100100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101010000000000101010011000000010000000011111111100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001000000000000001100010001000000000000011101100100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000001000001010010000000000000000011001100101011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101110000000100111000011000100000000000111111101101011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000010000000001100011000000000011000011001100100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100110000000011110010000000100000000001011100100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000000001000010000000110000000111011110100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000001000010000100010011000011101101100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001100000000000001000010000000000011000011011110101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001110000000000111100011000000000000000011101111101111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000101000011000100010000000111101101100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101100000000000011100011000000000000001111001110100011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001100010001000011000010000100000000000011001110100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000010000000001110010000000000010000111001100101011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000010000000101000011000100010001000011001100101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110000000000011000011001000000001000111011101101111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010001110100000000001100010000000010000000111001110101111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001100000000000001100010000000000001001011101111101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001100010000000111100010000000000000000011001110100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000100000000011010010000000010001000011101101101111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001100000000100001010010001000000001000111001100100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011001000010001000001000011000100010000000011001101100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001110010000000111000010000100000000000011011101100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000010000100001100010000000000011000011101110101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001010000000000111010010000100000000000011011110101111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011001110000001000011100010000000000000000111011110100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001000010000100011110011000000110000000111001111101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001110000001100001100010000000000000000111011101100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101110110000000001100010000000010000000011111100101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001010000000100001100011001000010001000111001111100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001110010000100001010010000100000010000111101100100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101100000000000001000011001000000000000011011111101111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011101000010000100001100011001100000001000011111110100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010101010010000000001010010000100010000000111111100110111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000000100001000010000000000000001011101100100111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101010000000100011010010000000010010000011011110101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011001000000000000101100010000000000001000111011110101011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101010000000000111100010000000010001000011101100100111000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011101100000000000111100010000000000000000011011101100011000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011001010000000100001010010000000000000001011101110101111010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101000010000000011000010000000000010000011101110101011010]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011001100000000100001010011000100100001000111111111101011000]")));
		assertEquals(195, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001010000010000001110010000100000000000111001110101001000]")));
		assertEquals(196, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011101000000000100111000010000000010000000111001110101011000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic80p()
	{
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100100101001011000010010000111011000111011111101111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101101010111011001010010000010110000000011001100100111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111001100100010011101100010001000000000001111001101110111010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110001001000100000011010011000000001000101011101101110111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111101011100010110011000010011000000010000011111111101111000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000110001010001110010010100011000100011001110100111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001010100001111001000010001000001001100011111100100011000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010011010010101011111100010011000001010000011001100100111000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001101000010010001000010000100101011001111001100101111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011101110110100101101100010010100010010101111101111100011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001001000000010111110011001010100010001011001101111111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010011101010101000101110010010100110001001011001101100011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101101100001110101010010001010010000001011011101111111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111001001000111100101000010010100010000001111111100100011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010111110000011000011010010001010001011100111101111101011000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010011010100000111011110011001010000001001011101111110011010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101001100000010011000011001000101001001011011100111111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101110110011100101110011001010000010101011101101100011000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010111011010001001001000010010100001000000011101100100011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001101000001011011100010001110100011000011011101101111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101100000000010001100010010010101010101111001110101011010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001001100110100111000010000010001000000011101101100011000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110101100100000110101000011011010010011001111011101101011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001011010111101001000011011000000001000111001110111011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010111100100010010001100011000110100001100011111111100011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110101101000010110101010010000110100010000011001101101011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111001000100000111001110011011110100000001111001111101111000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001111100001110001010010011000011000000011011101110111010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010111110000000111011010010000110011000101111101111101011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111101010000001101001110011000010011001101011011100100111010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110001011100100101011110010000100100000001111001101110111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110101001000010010101110010001100010010001111111100100011000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111101000100111100001000010010000100000001111011101110111000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100010100000111000010011010011011001111011100100111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101000110011110101000011000100101000101011101100100111000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001001000001111111100011001000011000000111101110111111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001010000010000111110010010010110011001111111100110011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001010000011101111110011010110101010000011001100101011010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000110010110011110010011000011011001011111100100011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011011100110010000111110011010010110000000011001101111011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001111000000100111010010011010110011001011001111110111000]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111101100010110100001000010011010000011001111011100101011010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001101000001010011100010001000011000101111101110100011010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010011001000011011111000010000100100000001111001100100011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100000010100101010010010110010010101111101110100111010]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101011100001001001110010000000110011101111001101110011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101101100011001101010010010000010010000011011100110011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001100000011110101000010001010101010001011101100100011000]")));
		assertEquals(223, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001001010111000011000011001010100001001111101100110111010]")));
		assertEquals(224, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110001011010001101011100011010000100000001011101111101011010]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic90p()
	{
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111001100111011011110011010110111001101111101101111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110011011110110011001010010011010111010100111001100111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110011111000110011101010010011010111010101111001110110011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110111101110110111111100011010110101010100011111110111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111111100110111001010011010110001001101111011100111011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110011101100110111011010010010110011011100111111111111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101111111001110110011111000010010010001000101011001101110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111111011000111111011100010010110111000101111101110111011010]")));
		assertEquals(251, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010111111000110111011100100010010011010100111111110110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110011011100100011111010101010110001000100111111101111011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111111101100110011101100011010010101000101111101110110111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110011101000110111111100011010010111011101011111110111011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111011111010110111001100010011110111011100111001100111011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111111011100110011001010010010110101011101011011100111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110111111100111011111010011010110101010100111001101111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111101010110011001010011011110111011101011001110111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101111111011010111111101000011010110111010101111111110110011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111011000111011001000011011110011001100111011100111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111011001110111011111110010011010101000101011111101110111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110011011010110011011010011010110011000100011111100111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110011111110110011101110011011010111010101011001111110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111101010111011001100010011010101011100011001101110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110111101110111111111010010011110001011101111111111110011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111011011110111111001110010011010001000100011011110110111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111011011110111111111100010010110111011100111101101111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110011011110111011001010010011110101000101111001110110111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111111101010111111111110010011010111010101111001100111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111011111010111011111100010011010101001100111111111111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011111110111011111100010011010101000100111101100110111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110111101100111011011010011011010111000100111111111110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110011001000110011101100011011110001001100011011101110011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110011111000111111101010010011010001010101111011110111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011001100111011001010010011010011011101111001110111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111111101110111011101010010010110111001101011001100110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111011111010111111011100010011110011001100011001101111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011011100111111111000010010010111001101011011110111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101111111011110110111111000011010110111000100011001101110111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111011000110011111100010011110101010100111111110110111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110011001100110111111100011010010111011101011101111111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111011001000110111111110011011010011000100011101101111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110011011000110111011000010010010111000100011101110111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111011101110110111001100010010110101000101011101100110011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110111111110111011001010011010010011000101111101111111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110011011010111111101110011011110101011101011011101111111000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110011001010111011101110010010110111011100011111100111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110011011000110111111100010011110101011100111111101111111010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110111001110111011001000010011110001010101011001110111011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111011101100111011111100011010010101011101111111100111011000]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111111011100110011011100011010010111000100011011110110011010]")));
		assertEquals(252, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111111011010110011011100010010010111011101111101100110011000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized10p()
	{
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000100001000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100000011000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000011000111000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000100000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000111000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000101000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000011000101000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100010000001000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100010000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000010100110000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001001100000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001010110000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000100000000001000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001110101000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001010110000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000010000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(28, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001000010000000]")));
		assertEquals(26, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000000000000000]")));
		assertEquals(25, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000000000000000000000000000000001010010000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized20p()
	{
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000100000001100000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00011000000000000000000000000000000000000000000000000000001000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000001000000000000000000000000000000100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000000100110000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[01000000000000000000000000000000000000000000000000000100001000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000001000101000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100010000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000100000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000010100000000000000000000000000000010000000]")));
		assertEquals(51, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000000000000000000000000000000000100001000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000010000000000000000000000000000000101000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000100000000000000000000000010101000000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000010000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000010000000000000000000000000000000100000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000011100000000000000000000000000010000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000100000000010000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000001000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000000001000000]")));
		assertEquals(53, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000000000000000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000001000000000000000000000000000000001000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000001000000000000000000000000000111000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000000000000000000000001000000000000001000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000001100001000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000000000000000000000000000001001100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000001110001000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000010000000000000000000000000000011001000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000000001000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000100000000000000000000000000000100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000110100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000000000000000000000000000000011000110000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000001000000000000000000000000000000100000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000010000000000000000000010001000000000]")));
		assertEquals(51, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000000000000000000000000000001101000000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000010000000000000000000000000000001010000000]")));
		assertEquals(56, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00000000000000000000000001000000000000000000000000000101000000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000010110000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000001001011000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000000000000001000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000110100000000]")));
		assertEquals(54, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000000000000000000000000000000100100000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000010000000000000000000000000000000100000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000000000000000000010000000000000000000000000000110001000000]")));
		assertEquals(55, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000100000000000000000000000000001001000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized30p()
	{
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000000100000000000010100100000000000000000000001001000000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000010000010000000000000000000000001100000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010000000000000000001000000000000000000000000000000100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000010000010000000000000000000000101001000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000010000000000000000000000000011000010000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000010000000000000010000010000000000000000000000100001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001100011000000000000000000001010100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000001010010001000000000000000000110001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000001000010010000000000000000000000100000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001100000000000001000000000000000000000000011001000000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000100100000000000001000000000000000000000000001001000000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000000000000000000001000000000000000000000010000100100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000011010010001000000000000000000100001000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100000000000001100000000000000000000000000000001000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000010000000000000010001001000000000000000000000000001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000100000000000000000100000001000000000000000001000101000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000100000000000000010110000000000000000000000001100100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000000010010010000000000000000000000010001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000110100000000000000000000000000001110000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000010110000000000000000000000000000101000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000000100001000000000000000000000010100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000001000100100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000100000000000000100000000000000000000000001000001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000100000000000000000100000000000000000000000001101100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000001000000000000000000000000011001001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000100000000000000010110000000000000000000000001100101000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000000100000000000000000000001001100010000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000001000100000000000000000000000001011000000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000101111010100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000100000000000000000100000000000000000000000010111110000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000001000100100000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000000000100000000000000000000001011100100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000000110000000000000000000000000000100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000110100000000000000000000000001000001000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000010000000000000000000000000011010100000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000000100000000000000000000000000000100000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000011000000000000000100000000000000000000000011001000000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001000000000000000000000000101010110000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000001000000000000000000000000000101000000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000100000110000011000000000000000010010001000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000001100000000000000000000000011000001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000001010001000000000000000000001110010000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000011010011000000000000000000001101001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000000000000100010100000000000000000000000001000101000000]")));
		assertEquals(82, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000010000010000000000000000000010000100000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000000000000000000010100000000000000000000011101100001000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000000100010000000000000000000010101101000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000000000000000000000100000000000000000000010001100010000000]")));
		assertEquals(83, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000001000000000000001000000000000000000000000000000100000000]")));
		assertEquals(84, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010000100000000000000000111010000000000000000000001001100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized40p()
	{
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101100000000000001000010000000000000000010001000100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000111100000000110101000011000000000000000000001101101000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00010011001000000000000010100000000000100000000000011100100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000100000000000011101011000000000000000111000110001000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111000001100000000000011111000000100000000000000000110100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001100000000000001010011000000000000000001101011100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000001000111001010000000000000000001111100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000011000000000100101100010000000000000000000001100111000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000001001000011001000000000000000011110100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110001001000000000000010100001001000000000000000001100100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010100100000000000010110010000000100000000000000100100000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000010101010010000000000000000000001101110000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100001101000000000000010110011000000000000000000001100010000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000100001000011000000000000000010010100001000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000000100000000000000100000000000000000000111001100111000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100100000000000001110011000000000000000010001101100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101100000000010110111100000000000000000000001111110000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010100000000000100011010011000000000000000000000100101000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001000000000100000101000111000000000000000001100110000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000000011000010000000000000000001010100100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000100000000000000010100010011000000000000011001011110000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101000000000010001100010000000000000000000001100111000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100000000000110110010000000000000000000011001000000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101000000000110001110011001000000000000000001101101000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101000000000100011000010011000000000000000001101111000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101000101000000000100011100010000000100000000000000010100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011100000000000000001110011000000000000000000011100101000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000000001010001001000000000000110011001101000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001100000000000001001000011000000000000000011100110000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101100000000110101010011000000000000000000001111111000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000011000000000110011100011000000000000000000011101101000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000011100000000000000000000010001111100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10010000001100000000000001000010000000000000000001111100100000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000101000000000010001100001011000000000000000011100100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000110000000000000000100011000000000000000011001001101000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010100000000000000011000011001000000000000000010110100000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001000000000010001110011001000000000000000011101100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000101100000000001000100100001000000000000000001101111000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010001000000000000010100001000000000000000000001110101000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001000000000100000100000000000000000000000001011101000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000000100000100000000100000000000000001001100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010100000000000000011110010000000100000000000000100100000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001100000000000011000010000000000000000110011010101000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000001100000000001001010010000000000000000000011100110000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000111100000000010011110101000000000000000000001100001000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001000000000000001100000000000000000000010011111100000000]")));
		assertEquals(112, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001100000000110010100100010000000000000000001100101000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000000100000000100011100010000000000000000100111100101000000]")));
		assertEquals(111, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001100000000000011000000000000000000000111010111011000000]")));
		assertEquals(110, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110000101100000000001011000100000000000000000000001111100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized50p()
	{
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001100000000000000110010000010100000000011101110100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011101000000000000000100011011100000000000011001100100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001000000000100001010011000000000000000110011101100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001100000000100001000010000100000000000010111100100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000101110000000010011110011000000000000000111101101101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001100000000000001100110000100000000000010011100100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000100000110101000000100000000111000111101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100000000000011000111000000000000000011000100101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101000000000100010100010001000000000000111011111100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010000000000000001001100011000000000000000111001100101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001100000000100001100010000000000000000011110101101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001000000000100010110011001000000000000001101100111000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000000000000011100101000100000000000011001001101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101100000000000010110010011000100000000111101000100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100000000100000100010000100100000000011011100100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110001001000000000100011000010000000000000000011001100100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011001100000000100100110011000000000000000011001101101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000000000000100011000110000000000111011100100000000]")));
		assertEquals(139, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000111100000000011101010011010000000000000011001101101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000000001001000010100010000000000000001101100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011000100000000001110110010000000000000000101101100111000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101100000000100010100010001100100000000010011101100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011001000000000000010100100000000000000000011001110111000000]")));
		assertEquals(139, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000011100000000011011000010010000000000000111111101101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000100010100010000000100000000011001101100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100000000000010110100000000100000000011000101110000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100000000100000110111000000000000000011001110101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101000000000000010110011011100000000000011001101101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001000000000010000100000001100000000000001001111100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101100000000000001010011001000100000000010110100101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000000000100010001000000000000011101101111000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101000000000000011000010000000000000000111101111101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101100000000000011110011000100000000000011011100100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101100000000000001010010000000100000000001101100100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001000000000000000101000001000000000000111101111100000000]")));
		assertEquals(139, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001100100000000010100010001000000001101111001101100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101000000000100000110011001000000000000111001110101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101000000000000011000010000100000000000010001101110000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101000000000000000110011000000100000000111101101110000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000000000001000011001000000000000110001110101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000000000010110011000110000000000111001110100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010000000000000101001010010000000000000000111001111100000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110000001000000000111001001000010000000000000011101101100000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010101100000000010101100011001010100000000000001110110000000]")));
		assertEquals(139, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010111000000000000011110011000000000000000110011111101000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100000000000010100110000000000000000011001100111000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011101000000000000001000011000000000000000011011100101000000]")));
		assertEquals(138, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101100000000000001000010000100000000000010001111111000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000000011111010010011000000000000000001110111000000]")));
		assertEquals(140, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100000001111100000000001100111000000000001000011011111100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized60p()
	{
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010111110000000000001000111000010100001000011011111110000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101001000000000001000010001110000000001010011110100000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111001100000000001001110011101110100000000111111101110000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001011000000000001010101001100000000001011101100100000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111101000000000011001011001011000000000000011011100110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111101110100000000001000010010000000000000111011111110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011001100000000011001001000010010000000000011001111111000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011111010000000000001100111000010100000001011011111101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001101000000000001001001011100000000000111101111100000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011101000000000011001100111010111000000000011101111100000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011011000000000010001110010010110000000000111011110110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101000000000011101111101010000100000000011111100110000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001000100000000011000010001010000000000011001110111000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101000000000111011010010010011000000000111101101110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010000000000000100001000010000100000000000001001100001100000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001101000000000001000011000010000000000011011101110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001000000000101011100100110110100000000011111100111000000]")));
		assertEquals(165, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101111001010000000000001000011100000100000000111100111110000000]")));
		assertEquals(161, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101010000000000011000011010000000000001011011111100000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100000001100010000000000010010000000000000000110011100100110000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101101100000000001010010010000100001000011001100100000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110100000000001000010000010100000100011101100101000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110001100100000000001010011000000000000100011011111110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[11111010101100000000111011000010011010100000000011001101101000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110101000000000010011000101001111000000000111101100100000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001010100000000001110010001010100000000011101110111000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110111100000000001101010011010010100000000011101111101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110011100000000001001110110001010000000000011001100101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101101000000000011010011010100100001000111001100101000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110001100000010000000010110011000000000001000011011010100000010]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001000000000010101100110010111000000000111001101111000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010011100000000011001110010001110000000000011111110111000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010011000000000001001110010010010100000000111001100110000000]")));
		assertEquals(165, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011101000000000010011000101011001100000000011101110111000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101100100000000001010010001010100001000111011110110000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101000000000011101110101110000100000000011011100110000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001001000000000011000010010100000000000011001110111000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010111100100000000011010010000111000001000111011101101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111111000000000101111010011110000100000000111111100101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001010000000000011100010001010100000101011001111100000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110001100000000011011010010001010000000000111001110111000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110100110100000000011010010100110000000000111001101101000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100100000000010100110010101000000001011011010101000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001100100000000001110010001010100000000011111110111000000]")));
		assertEquals(166, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110001000000000011001101011010100000000000111001100111000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101000100000000011000010001010000000001011011101101000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010011100100000000001110010000000100001001111011110111000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110111000000000010001110011011010100000000011001111101000000]")));
		assertEquals(168, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110001110000000000011100110000010100000000111111100111000000]")));
		assertEquals(167, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101010100000000011000010000000100001100011011100111000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized70p()
	{
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001100010000100101010011000000000000000011101111101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101110000000100001000011001100000000000011111110101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110000001100001100010000000000000000011001100100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101110000000100001000011000100000001000111001100110111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001000010000000001110010000100110000000011001100100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010101110000000000001100011000100110000000111101100101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111011101110000000100011000010000000000011000011001100100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100010001100011010011000000010000000011011100100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101000000000100001010010001000010000000111011100101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001010000000100001010010000100010000000011011100111011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101110000000100001010010001000010000000011101100100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001010000000100101100010000000000001000111101111100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001010000001000001010010000000000000000011101100100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011001000000001000001000010000100000000000011001100100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011101110000000000011010010000000000010000011101110100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010001100000000000011010010001000000001000011001100101111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001010000000000101110010000000000001000011111101100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101110010001000011110011000100000000000111001110100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101100000000000011100010000000010010000011111100101011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100000000100001110010000000110000000011001100100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001010010000000011000010000100000000001011101110100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000001000011100010000100000001000011101101100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100011001000000000000001010011000100000011000111111111101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010101000000000100101010010000000010000000011101100100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001100010000000001000011000000110000000011001101101111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001000010000000001000010000000110001000111001100100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001010000000000011110011000100000011000011101101100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010001000000000000111010011000100010000000011101111101011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001000000001100001110011000100000000000111111100100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110000001100001110010000000000000000011101110101111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001000010001100001100011000100010000000011101110101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001000000000100101110010000000010000000011001100100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010101000010001000001000010000000010000000011101100101111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001100010001100001000010000100000000000011101110101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101000100000100001000011000000000001000111011110100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001110000000100101010010000100000001000011011110100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001010000000000011100010001100010001000011001100100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100000000000001000011001000010000000011101100101011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100000000100011110010000000000011000011111101101111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010101000000001100001100011000100000001000011101100100011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101010010000100011110010000000000011000011111100101011000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011101100000000000001000010000000000010000011111101101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001100010000100101100011000100000001000111001100100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101000000001000001100010000000000000000011001111100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001110010001000011000010000000000000000111011110100111010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100000000100101100011000100000000000011011111100111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100100000000001010011000000000000000111011101101111000]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011001000000000100011110010000000000000001111101110100011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001000010000100001000010000100110000000011101100101011010]")));
		assertEquals(196, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010101100100000100011000010000100000000000011001111101011000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized80p()
	{
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001011100101101011000010011000000000101111001111100011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001110100001000101100011010000111001001011111100110111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000110010001000011001000001011100011011110100111010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010011101100111100001000010000000101000000111001100111111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001111000010011101100011001000100001001011001101101011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011101111000001001001100011000010011010001111111101100011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110101100100000001011000011010000001010001111111110110011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101111100000001001110011000110110011101011111110110011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010101001010100010001000011001100110011000011101101111111000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001010010010001011100010010110001010000111111100100111010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011011101100100000001100011001000100010001011001100110011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010011011000001010101100011011000000000101111111100101011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010101100100000010001000010010110011011001011101101100011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101011001011100001110101100010000000111001101011011111100111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001001000001110101110010000010100011100011011110101111010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110001000000011001101010011010100110000101011001111100011010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100110101010000101101001110010000010111000000011011111111011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110001001010000111011000010010000100011000011101110100111000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111011011010010010100001010010011010101001001111001110101011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111001101010010001111010010011100100000000011001101101111000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001000100100011101110010001100111011000111101111101011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011001100100001011011110010011100110000001011101111110011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011011101000110001001100010001100010000000011011110111111000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011111100000010101001100011000110011001001011001110101011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001111100000011101100011001000110010001111101100110011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101010111101000101010011010011001000000011000111101101110111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101111100001011001010011000000110010101011101101100011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110001001010110000011100011001000100011001011011111100011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111010011111110100011111010011000000010001001011011101110011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100010001011110011110001100011000000000011100111011110110111000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011011001100001011001110010010100100001000111101101101011010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010011010000100110111010011010100010010100011111101101111000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101100010100000101010010011010111001000011101100111011000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110001101110011000111010011010000001000000011001110100011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101011101001000001001111010011011100101011000111001100101111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011001000100100100101000010001010100000100011001110110011010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110001010110001011001000010011000010001001011001100111011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101010001001100010110001000011010100001010000011101100101111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011001010110100010001110011011110110011000111011100101011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011101101100011101001100010000000100001101111001101111011010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110011101110000111111111010011011000010000101011101110101011000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100010001110010111010101100011000010110010100111101100101111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010101000100001101001110010010100101000001111001101100111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111010001100100100110101110011001110110000001111001101110111010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011011010010110010111110010000110000001001111101100111111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110011101000000101001001010010011010001001000011001111100111010]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110010001110000110001011110011001110011010000011001111101111000]")));
		assertEquals(223, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110010001100100110100111010011000000100010101011001110110111000]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100011111011100001010001110010010100010000100011101101100111010]")));
		assertEquals(224, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111001100000000010011000010011000101000001011001101110011010]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized90p()
	{
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111011011100111111101100011011010101011101111101110111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110111111110111011001010010011010111000100011011111110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110011001110110110001000100010010011000100111001110111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111111011010111111001100011011110011001100111101100110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110111111111110111111001110011011010001011101011111101110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110111101000110011001110011011010001011101111111110111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111111111110111111101110010011010011010100011111100111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110011001000111111001110011010010101011100011001101111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110011001110110011001000011011110111011101111001101110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110011001110111011111010010011010101000100011001100111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111111101000110111101010010011010101010100111001101110111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110110011111010110111111000011011110011000101111111110110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100110011111110110111011110010010010111000100111011100111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111111101100111111111010010011010001000101111101111111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110111011110111111111010011010110101010100011101101110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111011001100111111111010011010010001000100111011101110111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111011111000110111111100010011010101011101111011100110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111111111100110011011000010010010011000100011101110111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111111001000111111011100010011010111001101111011100110011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011101100110011111010011010010001001101011011100111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011001110110011001100010011110001001101111101100110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101111011111100111111011100010011110011011101111101110110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111111101110110111101010011010110111010100011001110110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011011010111011001000011010010011010100011101111111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111111011000111011011000011010110101011101111111101111011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111011111100111111001100010010110101000101111011111110111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111011010111111001010011011010111001100011101110111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110011111010110111111100011011010001010100111011111111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111101010110111101010010011110101010100011111110110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110011101000110011011110011011110011011100011011111111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111011101000110111101100011011010101001100111001111110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110110111011100111011011100011011110101011100011101111111011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111011011110110111101110011010110111010100011011101111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111101100111111101110010010110011010101011011100111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111011100110111001100010010010011010101011111101111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111111001010111011011110011011110101000101111111111110011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111111001000111111001100011010010011000101011001100111111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111110011001110110011111110010011010111011100011001110110011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110011101110110111001110011011110101011100011011111110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111111111001110110111111000010011010001011101111011111111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111011111100110011101000011010010111011101111011110111011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10101110111001000111011011110011011010001010100111101101110011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10100111111111010111111011100011010110101010101111101100110011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00110110111001010111111011110011011010011010100111011101111111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101111111011100110011111100011010110101011101011011111110111010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00100111111011100110011011010010011110101000101111101110111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10110111011101000110111001000011010110001000100111001100110111000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[10111111111101010110011011000011010010001011101011011110110011000]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00111110011001000111011111110010010110101011100011101101111011010]")));
		assertEquals(252, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[00101110011111110111111011110011011110011001101111011100110111000]")));
	}
}