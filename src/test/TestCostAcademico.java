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
 * Class that implements test cases for calculation of cost in function points - instance ACAD
 * 
 * @author marciobarros
 */
public class TestCostAcademico
{
	private static SoftwareSystem system;
	private static ClassicFunctionPointsCalculator classicCalculator;
	private static OptimizedFunctionPointsCalculator optimizedCalculator;

	@BeforeClass
	public static void setup() throws Exception
	{
		system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		classicCalculator = new ClassicFunctionPointsCalculator(system);
		optimizedCalculator = new OptimizedFunctionPointsCalculator(system);
	}
	
	@Test
	public void testSolutionsFromDissertationClassic10p()
	{
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000110000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000011000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000100100000000]")));	}
	
	@Test
	public void testSolutionsFromDissertationClassic20p()
	{
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111000110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000101010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001000101010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111000000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101100100000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000101010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001010101110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110001010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110110000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010000000000000000000000000000]")));
		assertEquals(36, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100000101110000000000000000000000000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic30p()
	{
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000001100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010000000000000000110000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000111000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101110110000000000000000001000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110011010000000000000000100100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100100000000000000000110100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000110000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000000000001100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101000000000000000000011000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100110000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000111000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000110000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000101010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000111000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101010010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000000000100100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110010110000000000000000010100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000011000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000100100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000001100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000000111000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000010000000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001100000000000000000010100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000100010000000000000000010100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110000000000000000000100000000]")));
		assertEquals(52, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000010000000000]")));	
	}
	
	@Test
	public void testSolutionsFromDissertationClassic40p()
	{
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000001111100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001010000110000000000000000100100010000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110000000000000001011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111100010000000000001100110000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000001000100000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110000110000000000000000001000010000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101100010000000000001001001100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000100111100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101010000000000000001100100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010000000000000001001100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000001010100000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110000000000000011011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111010000000000001011110000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110010010000000000000000011000100000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101110010000000000000011000100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000001001011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010000000000000001010100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101010000000000001100110000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111100010000000000001010011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000001111100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111100110000000000001011001100000000]")));
		assertEquals(68, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101010000000000000011001000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100110000000000001011110100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111010000000000000001110000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010000000000000000001000100000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000011010100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010000000000001001110100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101111100010000000000000001010000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100110000000000000001110100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000010000000000000000001000010000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010000000000000001011000000000]")));
		assertEquals(70, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110010001100100000000000000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110000000000000001010100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110000000000000011011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000101001100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010000000000001011011100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010000000000000001011100000000]")));
		assertEquals(70, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110001001100000000000000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010000000000000110011000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000011010100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000001110100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101010000000000000001000100000000]")));
		assertEquals(70, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110010011000100000000000000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101110000000000001010110100000000]")));
		assertEquals(70, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110001010001001100000000000000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101110000000000000001001100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111010000000000000001010000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000001010100000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101100010000000000000001010000000000]")));
		assertEquals(71, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111010000000000001001110000000000]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic50p()
	{
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100011001100100000000111100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101110011001100000000111000000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110011011000100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101011001101100000000110000000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110001000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010001001100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101110001000100000000001100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011011001100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001001100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010011000100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010011101100000000010000000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100011001100100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011001000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010011110100000000001100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101110011000100000000110000000000]")));
		assertEquals(90, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110010101000100000000101100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010001000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010001000100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111011001000100000000000100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010011001100000000111000000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111110011000100000000101100000000]")));
		assertEquals(90, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000101010100110]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101011001101100000000010000000000]")));
		assertEquals(90, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[110100110011001001100000000010000000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110011011001100000000010100000000]")));
		assertEquals(87, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101100110000000000000000110111010000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110000000000000000000100100100]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010011100100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010001000100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010001000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011011000100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100110011000100000000111100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110111011101100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011011100100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110011001001100000000111100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110011000100000000111100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100011001100100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110011001001100000000010100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001100100000000010100000000]")));
		assertEquals(90, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000010100110000000000000000010000100110]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111010011000100000000100100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010001000100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110011000100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010011000100000000100100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001001100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110011100100000000110100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010011000100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110001100100000000011100000000]")));
		assertEquals(89, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111001000100000000110100000000]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic60p()
	{
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110001000100000000111100110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101110011000100000000000110010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011001100000000000111010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011101100000000010011010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110111001000100000000011001110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110111011001100000000010110110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110001001100000000001111010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001001100000000101111010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111011000100000000000101110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110001000100000000011011010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011001100000000011110010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001000100000000010110010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011011100100000000111100110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110111011000100000000010001110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110111011100100000000100111010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010011001100000000010100010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010011000100000000010011010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010011001100000000000101010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011011100100000000111001010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001000100000000010011010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110001100100000000100101010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100011001001100000000010100010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100011001001100000000000111110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110001100100000000001101010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100111001100100000000111100010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011101100000000110011010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010001001100000000010100110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100011001000100000000010110110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100111001000100000000111001010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010001100100000000001111010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010001101100000000010110010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111010011000100000000000100110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110111001101100000000011001110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100011011001100000000110100010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100111011001100000000010011010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110001000100000000111110010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111011001001100000000011000110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001100100000000010100010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010011100100000000010110110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110010001100100000000011100110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001001100000000011001010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100111001000100000000001111110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110011000100000000011100010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100111001100100000000001111010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010011000100000000111001010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100111001100100000000010001010000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011011000100000000110110010000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010001100100000000101111110000]")));
		assertEquals(107, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110011001001100000000011100110000]")));
		assertEquals(108, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110001100100000000111001110000]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic70p()
	{
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110011001101100000000010110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101110001101100000000101100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010001000100000000011110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010011101100000000010100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011001000100000000111100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101111011100100000000011000011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110111011000100000000110110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100111011000100000000111110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110011101100000000110110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110111001001100000000010110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110011000100000000010100110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001000100000000010110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100111011001100000000110100111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100111001100100000000111110111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010001100100000000110100111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001101100000000011100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001000100000000010110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110111001101100000000010100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110010001101100000000111100111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110011001100000000010110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110110001000100000000111100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110011001100000000010100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110011000100000000110100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010001001100000000010100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110011000100000000010100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010001101100000000010110011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010001001100000000111110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110001000100000000010100111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110110001100100000000010100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110011100100000000011110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011011000100000000110110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110001101100000000110100010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100011011100100000000011110111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110111001101100000000110100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101011001100100000000010000110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110001001100000000110110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001000100000000011110111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010001000100000000011110111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010011001100000000010110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110001000100000000110110011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110001101100000000110100111110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110011101100000000010110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010001100100000000111100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010011100100000000111100110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010011101100000000111110010110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110011001100000000110110011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100111001001100000000010110011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100110001001100000000011100011110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100110011000100000000111110110110]")));
		assertEquals(126, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010011100100000000111100010110]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic80p()
	{
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010001100110000000011111110111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110101110011111100000000010101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101110011101110000000111111111111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[110110101010011100100000000111101111111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101111010011101111110000010100010110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111010001010100000000011101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101111010011100100000000011101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111011011001110000000110111110111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[010100101111001000100000000010111010111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101011001111101010000010100010110]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101111101000100000000110111010111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101110101001100000000011101110111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111010001011100000000111101111111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101111101101100000000111101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101111011000110000000011111110111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111011001110101110000010110111110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001001100001001000101010110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111011001100000001111001110110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111111011101110000000110101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110011001100110100000110111010111]")));
		assertEquals(142, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101011011101101000000010101110110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111111011011000100000000011101010111]")));
		assertEquals(142, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101110001000110110000011101110110]")));
		assertEquals(142, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010011101101000000111111011110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111110101100100100000010111111110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110001000110100000111101110111]")));
		assertEquals(142, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111111011101100010000010111011110]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111010101100100000000011101110111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101101011001111100010000111110110110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101111001100110000000011111111111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110101010001101110000000010101111111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111110001011100000000110111011111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110110011101100100000111111010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111110001011100000000011111011111]")));
		assertEquals(142, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101010001101101000000110101110110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111010001110100000000010111010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111011000100001011000101110110]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001100100100000011101110111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101011011100100000000110101011111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101011001010100000000010101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010011000100100000011101110111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010111101100000000110111111111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[010110101010011000100000000011101111111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011011101110000000011111010111]")));
		assertEquals(144, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101110101100100000000010101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101011011110100000000011111110111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101011011100110000000110101011111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101110011010100000000011101011111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011001010100000000111101010111]")));
		assertEquals(143, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111111001001110000000011111011111]")));
	}
	
	@Test
	public void testSolutionsFromDissertationClassic90p()
	{
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100110001100111100011011111011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101111011101110101011111111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111111011011110000001011111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111010001101110000111111101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111110011001100100001111101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111011001000110100011011101111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111111001100110100001111111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111010011000100100011010111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111001101110101001010111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101111001101110000011111101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101111011000110001111111111011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111111010001010100000001111111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010001001100101011110111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101111101110001001100001111110111011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111110001100110000111110111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101111110001000110001001111101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101011011000110100011010111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111101111001101110000001010111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101011001101100101001011101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101101111001000110001001110101010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111011001100100101001111101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101110001010110000001110111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101011011101110101011110111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101101111001101110000011110111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111110011111110001001111111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111011011010100001101010111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101111101011001101110001001011101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111101110011101110001001111101010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101010001011100001011010101111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111111111001001100000111111101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111011100110101011010101111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110101110001101110101011011111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111110001101110100011110111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101011001001110101011111101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111001100110011001111111011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111111001110110000001110101111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111110011111110000011010101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101011001100100000111010111111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101011001110110000001011101011111]")));
		assertEquals(161, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101011011000111010011011111010110]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101111001001110100011111111010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101110011000110101001110111011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101011001101110101001011101110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111011101110101011010101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111111001001110100001111101010111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111001100110101011110111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101110001000110001011010111110111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101010001101100100011011101111111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011001000110000111110101011111]")));
		assertEquals(162, classicCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111110011100110100011011101010111]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized10p()
	{
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000011000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(18, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001000000000000000000000000000000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000100100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000111000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000100100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000011000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000001100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000000100000000]")));
		assertEquals(16, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000000000000000000000000010000000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized20p()
	{
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101010010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001000101010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110011110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111000000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111010010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110011010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110011010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110011010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101100000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101100000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100000101010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101010110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101000010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111010010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111000010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100000101110000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101010010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110001010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101000010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000000000000]")));
		assertEquals(36, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000000000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized30p()
	{
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110011110000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101000010000000000000000110000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101010110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110000000000000000011000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000000100000000]")));
		assertEquals(53, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[010100100010000000000000000101000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000010001110000000000000000010100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001010000000000000000101100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110100000000000000000010100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000111010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110000000000000000001100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110001110000000000000000110000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000110000000000000000010100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110000000000000000001100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010000000000000000001100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101100010000000000000000001000000000]")));
		assertEquals(49, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010000000000000000001000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000100100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110001010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110001110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010000000000000000100100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000000100110000000000000000011100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000000000100000000]")));
		assertEquals(53, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[111110000010000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000011000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101000000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000100100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010000000000000000011000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000111000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110000000000000000001100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000110000000000000000010100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000010000000000000000110100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101000000000000000000010000000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000001100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000000000100000000]")));
		assertEquals(52, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000000100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized40p()
	{
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101010000000000000001011000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110000000000000000001000100000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110010000000000000101111000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010000000000000011110100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110011000100000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010000000000001001111000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111010000000000000001011000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111110000000000000010010100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110010000000000000001010100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010101001000000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010000000000000001110100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000010000000000000000001000010000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000011011100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110011110001000100000000000000000000]")));
		assertEquals(72, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[011100110110000000000001011000100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000001011100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110001110000000000001100110100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011001001100000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000011110100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101010000000000000011010000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110000000000000011110100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101010000000000000001011000000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011001000100000000000000000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010011001100000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110000000000000011111100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111010000000000000001010000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110110000000000001001010100000000]")));
		assertEquals(72, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[010110000110000000000001001110100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111111001001000000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000101000100000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100110000000000000000101000100000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010000000000000101001100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010000000000000001100100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110000000000000001110100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010000000000000001010100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001010010010000000000000000011000010000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000001011010100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001000100000000000000000000]")));
		assertEquals(68, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000001001100000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101111011101000000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000011110100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101010000000000000100101100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010000000000000001010000000000]")));
		assertEquals(70, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110001000100000000000000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000101101100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010000000000000101110000000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111110000000000000010011100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000011011100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010000000000000001111100000000]")));
		assertEquals(71, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101110110000000000000001001100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized50p()
	{
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011001001100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001001100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110001001110000000111000000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111010001001100000000101100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110010010000000000000000010000010100]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011000100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100111001100100000000111100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010001100100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001000100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001100100000000110100000000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101111110000000000000000010111010000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110010110000000000000000001000010110]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010001001100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011001101100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010001101100000000011000000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010001000100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000010000000000000000111000010100]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100111001001100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110001101100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100011001100100000000010100000000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110000110000000000000000001110101110]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100011011001100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100010001001100000000111100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011001000100000000111100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100110011100100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010001101100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011011001100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010001000100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101110110001001000000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110010001000100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110110011100100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110011001100000000111100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010011100100000000101100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101111001100100000000010000000000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110000000000000000001011101100]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101111001000100000000111000000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110011001100100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101110001000100000000110000000000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010000000000000000001010100110]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011001001100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001101100000000111100000000]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110000010000000000000000001010110110]")));
		assertEquals(90, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110000010000000000000000101000111110]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110000000000000000101000110100]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100011001001100000000110100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001000100000000010100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100111001001100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110010001100110000000111000000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110111001000100000000011100000000]")));
		assertEquals(89, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100010011100100000000010100000000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized60p()
	{
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110011001101100000000010001010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110111001100100000000001101010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110001101100000000010110110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110111011001100000000010110010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011001001100000000100101010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110011001100000000010001010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110001000100000000010100010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100011001000100000000000111110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100011011100100000000011100010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110011001100000000010100010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110010011100100000000000101010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100111011000100000000110001010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111011000100000000111110010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001000100000000011100010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001001100000000010011010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110111001100100000000010001010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110110001000100000000101101010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001001100000000110100110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011100100000000110110010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100111001100100000000111011010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010001101100000000110001110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001101100000000000101110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110011001000100000000111001010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100011001001100000000000111110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100110001100100000000101101110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001000100000000111001010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011001000100000000101111110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110110011101100000000001101110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111110011011100000000101000110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010011000100000000010001110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010001000100100000101000010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110011000100000000010100110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110001001100000000110110110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100011001000100000000001101010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110111001000100000000111110010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110111001000100000000110100010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010011001100000000111100010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110111001001100000000010110110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100011011000100000000010100010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010011100100000000100101110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110011000100000000110110110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110110001010100000000101100010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110011000100000000010110010000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110011000100000000110100110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001001100000000010001110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100111001001100000000010110110000]")));
		assertEquals(107, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010011101100000000010100010000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010011000100000000101101110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110001000100000000100101110000]")));
		assertEquals(108, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001000100000000101101010000]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized70p()
	{
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100010001000100000000110100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100011011100100000000110100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100111001101100000000010110011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110110011100100000000110100111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101010001000100000000010000011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010001001100000000010110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110010001001100000000110110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100010001000100000000010100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010001000100000000101110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100110011001100000000110100011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010011001100000000011100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110110001001100000000010110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110011001110000000110010010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110011001100100000000010110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001101100000000111110110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101111011101100000000110000110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100101110001100100000000001100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110001101100000000010100111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011011001100000000011100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011001101100000000010100011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110010001100100000000110100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100110001000100000000111100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110100010011000100000000010110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110100111011000100000000010110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001101100000000110100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101110001000100000000010000011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100110011001001100000000111100011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110011000100000000111110110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100111011100100000000111100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110011011100100000000110100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100110001101100000000110100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100100110011100100000000111110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110110110011000100000000111110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110110110011101100000000111100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110110001001100000000011100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100010011000100000000011110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111001100100000000010110010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100110011001100000000010100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110010001000100000000110100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100010001101100000000011110110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001000100000000110110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110100111011001100000000011110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100110111011100100000000111110011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010001000100000000010110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110110111001001110000000000110111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100110001100100000000011100010110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110100111011000100000000110100111110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010001100100000000110100110110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101110001100100000000011010011110]")));
		assertEquals(126, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100100111011101100000000010110011110]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized80p()
	{
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[111100111010011100100000000111111010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111111011100110000000111111010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100110110001000100100000011101010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101111101001100000000011101011111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[010110101110011000100000000010101110111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100100011001100100100000111111111111]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101110011101111100000111101111110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101110001001110000000110111011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101110011001110000000111101111111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100110010111101110000000110111010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[111100101010001101100000000110111010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101010101101100000000111111111111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111010001111100000000110111111111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111101111001010100110000111100111110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011011110100000000011111010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[011100111110011001100000000010101110111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101111010011000100000000010101011111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101011111001100000000110101011111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111110001110111010000010100111110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101111001001110000000011101011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111011001010100000000111101110111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011001101110000000111101010111]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100111010001100101100000011111010110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111010001001110100000011001010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101110011110100000000110111011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101011001011100000000011101010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111110001000110000000110111011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110101010011110100000000011101010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101101111011101111110000011100110110]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111011001100100010000111101111110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110111011001001110000000110101010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[011100111010011101100000000010101011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111110001101110000000110101111111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101111110001110101000000111110010110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101010001000110000000110111010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111111011000110000000110101010111]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101111001100110010000011101010110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111010001100110000000010101111111]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110110011011100100001001011100010110]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101101011011011110110000111110110110]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[110100111111011001100000000010101010111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101101011011100100000000110101011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111111001001110000000010101010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010101000100000000110111110111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111110011100110000000011101011111]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111011001001110000000011111110111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010101100100000000110101010111]")));
		assertEquals(142, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101011001101110010000110101110110]")));
		assertEquals(143, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101110001001110000000111101010111]")));
		assertEquals(144, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100101011111100100000000011111011111]")));
	}

	@Test
	public void testSolutionsFromDissertationOptimized90p()
	{
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101111110011000100001101111101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101010011101110001101011101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101111001001100100001011101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111111001010110000011010101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100111010001010110000011010101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111101110001110100000001110111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101101111001001110001011010111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101111001101100100001011111011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111111111011001100001101010101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111011100100101001011101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111011110110001011011101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111010011100110000111111111011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010001000100101001010101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100101111011011100100000101110111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111111011001100100011011111110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100100111111001001110101001111101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111101111001000110000001110101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111111011001100101001110101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111101110001001110000001010111011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111011011101110101011011111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110111011001000110101001111101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010011100110101011111101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000111111111001100110001011011111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010011101100101011011101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101111001100100101001010111011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101011011100110000101010101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100111101010001100100000111010111110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101111001111110000011011111110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001101111111001101110001011011111010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111111011001100100001101010111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101111011101110100001010101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110101011001100100100011110101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101101011011001100001111110101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100101010001000110001101110101111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000110111011011101110100011110111010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110111110001111100001101111111010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000100100010001100101001011011101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001100111010011000100100001011111011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111101010011001110001011010101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101111110001001110001001011111010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101101110011100100000101110101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001111111111001000100001101110111110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101101110011100110000001110101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[001110101111011001110101011110111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[000101101110011000110001001010101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101011001100110101011110101010111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101101111010011101110001011111101110111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101110101110011000110101001111111111111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[101100101010011100100100001010101011111]")));
		assertEquals(162, optimizedCalculator.calculateCost(FunctionPointsCalculator.fromString("[100110101111011101110101001011101011111]")));
	}
}