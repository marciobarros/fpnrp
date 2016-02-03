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
public class TestSatisfaction
{
	@Test
	public void testAcademico10p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000110000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000001100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000011000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000010000000000]")), 0.0001);
		assertEquals(10.4265, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000000000000000000000000100100000000]")), 0.0001);
	}
	
	@Test
	public void testAcademico20p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000000000000000]")), 0.0001);
		assertEquals(27.0142, calculator.calculateSatisfactionPercentile(calculator.fromString("[000111000110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000101010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[001000101010000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111000000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010000000000000000000000000000]")), 0.0001);
		assertEquals(27.0142, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010000000000000000000000000000]")), 0.0001);
		assertEquals(26.0664, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101100100000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100110000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101000000000000000000000000000000]")), 0.0001);
		assertEquals(27.0142, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110000000000000000000000000000]")), 0.0001);
		assertEquals(27.4882, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110001110000000000000000000000000000]")), 0.0001);
		assertEquals(27.4882, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110001110000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000101010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(27.4882, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110001010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110010000000000000000000000000000]")), 0.0001);
		assertEquals(27.0142, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000010000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101000000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[001010101110000000000000000000000000000]")), 0.0001);
		assertEquals(27.4882, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110001010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000000000000]")), 0.0001);
		assertEquals(27.4882, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110001010000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110110000000000000000000000000000]")), 0.0001);
		assertEquals(28.91, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100010000000000000000000000000000]")), 0.0001);
		assertEquals(26.5403, calculator.calculateSatisfactionPercentile(calculator.fromString("[100000101110000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testAcademico30p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000001111100000000]")), 0.0001);
		assertEquals(43.128, calculator.calculateSatisfactionPercentile(calculator.fromString("[001010000110000000000000000100100010000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110000000000000001011100000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[000111100010000000000001100110000000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000001000100000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110000110000000000000000001000010000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[001101100010000000000001001001100000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000100111100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110101010000000000000001100100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101010000000000000001001100000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000001010100000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110000000000000011011100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111010000000000001011110000000000]")), 0.0001);
		assertEquals(44.0758, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110010010000000000000000011000100000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101110010000000000000011000100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010000000000001001011100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110010000000000000001010100000000]")), 0.0001);
		assertEquals(45.4976, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101010000000000001100110000000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[100111100010000000000001010011100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000001111100000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[100111100110000000000001011001100000000]")), 0.0001);
		assertEquals(44.5498, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101010000000000000011001000000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100110000000000001011110100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111010000000000000001110000000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100010000000000000000001000100000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000011010100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110010000000000001001110100000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[101111100010000000000000001010000000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100110000000000000001110100000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110000010000000000000000001000010000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111010000000000000001011000000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110010001100100000000000000000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110000000000000001010100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110110000000000000011011100000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000101001100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110010000000000001011011100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110010000000000000001011100000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110001001100000000000000000000]")), 0.0001);
		assertEquals(45.4976, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101010000000000000110011000000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000011010100000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000001110100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100101010000000000000001000100000000]")), 0.0001);
		assertEquals(45.0237, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110110010011000100000000000000000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101110000000000001010110100000000]")), 0.0001);
		assertEquals(43.6019, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110001010001001100000000000000000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101110000000000000001001100000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100111010000000000000001010000000000]")), 0.0001);
		assertEquals(46.9194, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010000000000000001010100000000]")), 0.0001);
		assertEquals(45.9716, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101100010000000000000001010000000000]")), 0.0001);
		assertEquals(46.4455, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111010000000000001001110000000000]")), 0.0001);
	}

	@Test
	public void testAcademico40p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100011001100100000000111100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101110011001100000000111000000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110011011000100000000110100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101011001101100000000110000000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110001000100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010001000100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110010001001100000000011100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101110001000100000000001100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110011011001100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011001001100000000110100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010011000100000000110100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100111010011101100000000010000000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100011001100100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110011001000100000000010100000000]")), 0.0001);
		assertEquals(56.3981, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110010011110100000000001100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100101110011000100000000110000000000]")), 0.0001);
		assertEquals(56.3981, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110010101000100000000101100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110010001000100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010001000100000000011100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111011001000100000000000100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101010011001100000000111000000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110111110011000100000000101100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000101010100110]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101011001101100000000010000000000]")), 0.0001);
		assertEquals(56.3981, calculator.calculateSatisfactionPercentile(calculator.fromString("[110100110011001001100000000010000000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110011011001100000000010100000000]")), 0.0001);
		assertEquals(54.5024, calculator.calculateSatisfactionPercentile(calculator.fromString("[100101100110000000000000000110111010000]")), 0.0001);
		assertEquals(55.4502, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110000000000000000000100100100]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010011100100000000110100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110010001000100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110010001000100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100011011000100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100110011000100000000111100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110111011101100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011011100100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110011001001100000000111100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110011000100000000111100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100011001100100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110011001001100000000010100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010001100100000000010100000000]")), 0.0001);
		assertEquals(54.9763, calculator.calculateSatisfactionPercentile(calculator.fromString("[000010100110000000000000000010000100110]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100111010011000100000000100100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100010001000100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110011000100000000011100000000]")), 0.0001);
		assertEquals(56.872, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111010011000100000000100100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011001001100000000110100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110110011100100000000110100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100010011000100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110001100100000000011100000000]")), 0.0001);
		assertEquals(57.346, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100111001000100000000110100000000]")), 0.0001);
	}
	
	@Test
	public void testAcademico50p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(36.4929, calculator.calculateSatisfactionPercentile(calculator.fromString("[000001100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110010000000000000000110000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000111000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000010000000000]")), 0.0001);
		assertEquals(38.3886, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101110110000000000000000001000000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110110000000000000000010000000000]")), 0.0001);
		assertEquals(37.9147, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110011010000000000000000100100000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100100000000000000000110100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000110000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010000000000000000001100000000]")), 0.0001);
		assertEquals(36.9668, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101000000000000000000011000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100110000000000000000000100000000]")), 0.0001);
		assertEquals(36.9668, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101000000000000000000111000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000110000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000010000000000]")), 0.0001);
		assertEquals(36.9668, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000101010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000111000000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000110000000000000000010000000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101010010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010000000000000000100100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110110000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000000100000000]")), 0.0001);
		assertEquals(38.3886, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110010110000000000000000010100000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101000010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000011000000000]")), 0.0001);
		assertEquals(37.9147, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110001010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110000000000000000000100000000]")), 0.0001);
		assertEquals(37.9147, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110001010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000100100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110110000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000001100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110000000000000000111000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010000000000000000010000000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110000000000000000010000000000]")), 0.0001);
		assertEquals(36.019, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110001100000000000000000010100000000]")), 0.0001);
		assertEquals(37.4408, calculator.calculateSatisfactionPercentile(calculator.fromString("[000000100010000000000000000010100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110000000000000000000100000000]")), 0.0001);
		assertEquals(39.3365, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010000000000000000010000000000]")), 0.0001);
	}
	
	@Test
	public void testAcademico60p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110001000100000000111100110000]")), 0.0001);
		assertEquals(67.2986, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101110011000100000000000110010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010011001100000000000111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010011101100000000010011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110111001000100000000011001110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110111011001100000000010110110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100110001001100000000001111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010001001100000000101111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100111011000100000000000101110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110001000100000000011011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010011001100000000011110010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010001000100000000010110010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011011100100000000111100110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110110111011000100000000010001110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110111011100100000000100111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010011001100000000010100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110010011000100000000010011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110010011001100000000000101010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100011011100100000000111001010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011001000100000000010011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110001100100000000100101010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100011001001100000000010100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100011001001100000000000111110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110001100100000000001101010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100111001100100000000111100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010011101100000000110011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110010001001100000000010100110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100011001000100000000010110110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100111001000100000000111001010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110010001100100000000001111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110010001101100000000010110010000]")), 0.0001);
		assertEquals(67.2986, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100111010011000100000000000100110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110111001101100000000011001110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100011011001100000000110100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100111011001100000000010011010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110001000100000000111110010000]")), 0.0001);
		assertEquals(67.2986, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100111011001001100000000011000110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100010001100100000000010100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100010011100100000000010110110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110010001100100000000011100110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100111001001100000000011001010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100111001000100000000001111110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110110011000100000000011100010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100111001100100000000001111010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100010011000100000000111001010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100111001100100000000010001010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110011011000100000000110110010000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010001100100000000101111110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110011001001100000000011100110000]")), 0.0001);
		assertEquals(67.7725, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110001100100000000111001110000]")), 0.0001);
	}
	
	@Test
	public void testAcademico70p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110110011001101100000000010110110110]")), 0.0001);
		assertEquals(79.1469, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110101110001101100000000101100011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100010001000100000000011110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010011101100000000010100011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110011001000100000000111100010110]")), 0.0001);
		assertEquals(79.1469, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101111011100100000000011000011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110111011000100000000110110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100111011000100000000111110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110011101100000000110110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110111001001100000000010110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110011000100000000010100110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110110001000100000000010110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100111011001100000000110100111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100111001100100000000111110111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010001100100000000110100111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110110001101100000000011100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100111001000100000000010110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110111001101100000000010100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110010001101100000000111100111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110011001100000000010110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110110110001000100000000111100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110110011001100000000010100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110110011000100000000110100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100010001001100000000010100011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100100110011000100000000010100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010001101100000000010110011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110110010001001100000000111110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110001000100000000010100111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110110110001100100000000010100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100110011100100000000011110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100100011011000100000000110110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110110001101100000000110100010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100011011100100000000011110111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110111001101100000000110100011110]")), 0.0001);
		assertEquals(79.1469, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101011001100100000000010000110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100110001001100000000110110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011001000100000000011110111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110010001000100000000011110111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100110010011001100000000010110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110001000100000000110110011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110001101100000000110100111110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110110011101100000000010110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100010001100100000000111100011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110100010011100100000000111100110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100010011101100000000111110010110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100110110011001100000000110110011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100111001001100000000010110011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100110001001100000000011100011110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100110011000100000000111110110110]")), 0.0001);
		assertEquals(79.6209, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100010011100100000000111100010110]")), 0.0001);
	}
	
	@Test
	public void testAcademico80p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101010001100110000000011111110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110101110011111100000000010101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100101110011101110000000111111111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[110110101010011100100000000111101111111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101111010011101111110000010100010110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100111010001010100000000011101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[001101111010011100100000000011101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111011011001110000000110111110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[010100101111001000100000000010111010111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101011001111101010000010100010110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101111101000100000000110111010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101110101001100000000011101110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110111010001011100000000111101111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101111101101100000000111101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101111011000110000000011111110111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111011001110101110000010110111110]")), 0.0001);
		assertEquals(85.3081, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100100011001001100001001000101010110]")), 0.0001);
		assertEquals(85.3081, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100111011001100000001111001110110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110111111011101110000000110101010111]")), 0.0001);
		assertEquals(86.2559, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100110011001100110100000110111010111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101011011101101000000010101110110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[001111111011011000100000000011101010111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101110001000110110000011101110110]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111010011101101000000111111011110]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111110101100100100000010111111110]")), 0.0001);
		assertEquals(86.2559, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110100110001000110100000111101110111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111111011101100010000010111011110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111010101100100000000011101110111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101101011001111100010000111110110110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101111001100110000000011111111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110101010001101110000000010101111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111110001011100000000110111011111]")), 0.0001);
		assertEquals(86.2559, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100110110011101100100000111111010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111110001011100000000011111011111]")), 0.0001);
		assertEquals(85.782, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101010001101101000000110101110110]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100111010001110100000000010111010111]")), 0.0001);
		assertEquals(85.3081, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100111011000100001011000101110110]")), 0.0001);
		assertEquals(86.2559, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110110110001100100100000011101110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101101011011100100000000110101011111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100101011001010100000000010101010111]")), 0.0001);
		assertEquals(86.2559, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100100010011000100100000011101110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101010111101100000000110111111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[010110101010011000100000000011101111111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101011011101110000000011111010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101110101100100000000010101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100101011011110100000000011111110111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101011011100110000000110101011111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101110011010100000000011101011111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101011001010100000000111101010111]")), 0.0001);
		assertEquals(86.7299, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111111001001110000000011111011111]")), 0.0001);
	}
	
	@Test
	public void testAcademico90p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Academico/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Academico/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(92.891, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110100110001100111100011011111011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100101111011101110101011111111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000100111111011011110000001011111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111010001101110000111111101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100111110011001100100001111101011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100111011001000110100011011101111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110111111001100110100001111111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111010011000100100011010111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111111001101110101001010111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101101111001101110000011111101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101111011000110001111111111011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001111111010001010100000001111111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101010001001100101011110111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101111101110001001100001111110111011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111110001100110000111110111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000101111110001000110001001111101011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101011011000110100011010111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001111101111001101110000001010111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101011001101100101001011101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001101101111001000110001001110101010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100111011001100100101001111101011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101110001010110000001110111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101011011101110101011110111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100101101111001101110000011110111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100100111110011111110001001111111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100111011011010100001101010111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101111101011001101110001001011101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100111101110011101110001001111101010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101101010001011100001011010101111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100111111111001001100000111111101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111111011100110101011010101111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110101110001101110101011011111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110111110001101110100011110111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101011001001110101011111101011111]")), 0.0001);
		assertEquals(92.891, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110100111001100110011001111111011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110111111001110110000001110101111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111110011111110000011010101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101101011001100100000111010111111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101011001110110000001011101011111]")), 0.0001);
		assertEquals(92.4171, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110101011011000111010011011111010110]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101111001001110100011111111010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100101110011000110101001110111011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001100101011001101110101001011101110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111111011101110101011010101011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101110111111001001110100001111101010111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[001110111111001100110101011110111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101101101110001000110001011010111110111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[100110101010001101100100011011101111111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[000110101011001000110000111110101011111]")), 0.0001);
		assertEquals(93.3649, calculator.calculateSatisfactionPercentile(calculator.fromString("[101100111110011100110100011011101010111]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas10p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000010110111000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100011000000]")), 0.0001);
		assertEquals(11.0855, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000100000000001000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(11.0855, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000100000000001000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100011000000]")), 0.0001);
		assertEquals(12.9330, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000010111001000000]")), 0.0001);
		assertEquals(10.1617, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010000000000000000000000000000001000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(14.7806, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000100000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000010000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001101100000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000101010000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001110100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000010100111000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000011110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(11.0855, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000100010000001000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000111010000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100101000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000011100100000000]")), 0.0001);
		assertEquals(12.9330, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000010010100000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(14.7806, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")), 0.0001);
		assertEquals(12.0092, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000000110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000101111000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000110110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000011101100000000]")), 0.0001);
		assertEquals(10.1617, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000100000000000000000000001000000]")), 0.0001);
		assertEquals(14.7806, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000100000000]")), 0.0001);
		assertEquals(13.8568, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100010000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100110000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001000110000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000110111000000]")), 0.0001);
		assertEquals(16.6282, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(15.7044, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000101110000000]")), 0.0001);
		assertEquals(11.0855, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000100001000000000]")), 0.0001);
		assertEquals(14.7806, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000000000000100101000000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas20p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000000000000000000000000000000000000110000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000001100000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000001100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000000000000000000000000000000000000110000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000100000000000000000000000000000000000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000010000000000000000000000000000000001000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000010001000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(22.6328, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000001000000000000001000100001000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000000000000000000000000000000000011010000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000010000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000010000011000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000000000000000000000000000000000000000000000101000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.9423, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010101011000000000000000001100110000000]")), 0.0001);
		assertEquals(21.709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000001000000000000000000001000010100000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000100000000000000000000000000000000000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(23.5566, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000001000000000000000001001001100000000]")), 0.0001);
		assertEquals(22.1709, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001100000000000000000000000000000000000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.4804, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000010011000000000000000001100110000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(24.0185, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000101000000]")), 0.0001);
		assertEquals(23.0947, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000000000000000000000000000000000000011000000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas30p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111000000000000000000001100000000000000000000000011000001000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000100000000000000100000000000000000000000000000101000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000100000000000010000011000000000000000000000101000000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000011000000000000000000000010011001001000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011000000000000000000100000000100000000000000000000100000000]")), 0.0001);
		assertEquals(35.1039, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000011000010000000000000000000000000110000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000001000000000000010000010000000000000000000000001100000000]")), 0.0001);
		assertEquals(37.8753, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110000000000000000000001000000000000000000000000001100100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000011100000000000000000000001000000100000000]")), 0.0001);
		assertEquals(33.7182, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000001000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000100000000000000010100000000000000000000000000100100000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000001000000000000010010000000000000000000000010101001000000]")), 0.0001);
		assertEquals(36.4896, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000100000000000000010000000000000000000000000000110010000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000011100000000000000000000001100010100000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000100000000000000001010010000000000000000000000000001000000]")), 0.0001);
		assertEquals(36.0277, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000000000000011000000000000000000000010000001010000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000100000000000000010100001000000000000000000011000001000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000100000000000000001000000000000000000000000010000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000011010000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000000000000000000001100000000000000000000001010010001000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010000000000000000000100000000000000000000000000111000000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000100100000000000010000000000000000000000000001000101000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010000000000000000000100000000000000000000000000000100000000]")), 0.0001);
		assertEquals(36.0277, calculator.calculateSatisfactionPercentile(calculator.fromString("[00011000000000000000000001000000000000000000000000000100010000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000100000000000000001000000000000000000000000001001001000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000101000000000000010010001000000000000000000000000100000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001000000000000010000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(35.1039, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010000000000000000000000000000000000000000000001000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000000011100000000000000000000001000010001000000]")), 0.0001);
		assertEquals(35.5658, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000000000011000000000000000000010000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000010000010100000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000001000000000000010100000000000000000000000000101000000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000000000000000000001000000000000000000000111000000100000000]")), 0.0001);
		assertEquals(36.4896, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000000100000000000010010000000000000000000000000000111000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000100000000000000011000000000000000000000000000000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101000000000000000000010000000000000000000000000001101100000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000100000000000000100000000000000000000000000000100000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000000000000000000010000000000000000000000001000100100000000]")), 0.0001);
		assertEquals(36.0277, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000100000000000000010101000000000000000000000000000101000000]")), 0.0001);
		assertEquals(36.4896, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000100000000000000001000000000000000000000000000000010000000]")), 0.0001);
		assertEquals(35.5658, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000000000000011010001001000000000000000010000101000000]")), 0.0001);
		assertEquals(36.9515, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011000000000000000000100000000000000000000000001011000000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000001000000000000010000000000000000000000000001000001000000]")), 0.0001);
		assertEquals(36.4896, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000000100001000000000000000000000000000000001000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000100000000000010000000000000000000000000001000001000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000100000000000000001000001000000000000000000000101000000000]")), 0.0001);
		assertEquals(36.4896, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000100000000000000001100001000000000000000000000000010000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000000000110011000000000000000000010001000000000]")), 0.0001);
		assertEquals(37.4134, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000000100000000000000000000000010000001000000]")), 0.0001);
		assertEquals(35.5658, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000100000000000000000001000000000000000000001000100000000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas40p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000101001000011000000000000000000011100100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000000100000000000000100010000000000000000111000100100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001100000000010011000010000000000000000000001101011000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000101000000000000011011001001000000000000000001110110000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000101001100010000000000000000000011111100000000]")), 0.0001);
		assertEquals(48.9607, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000101000000000010000100111000000000000000000000101110000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000001000000000001001010010000000000000000000001101100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000001001000010001000000000000000011001100000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001100000000000011010100010000000000000000001100101000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000100001101001001000000000000000011100100000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000000001101001011000000000000000001101100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001100000000100110100010001000000000000000001100111000000]")), 0.0001);
		assertEquals(48.9607, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000101000000000000000100101000000000000000000100100101000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000101000000000000011100010110000000000000000011100101000000]")), 0.0001);
		assertEquals(48.4988, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010010001000000000000001000001000000000000000000000010100000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000101000000000001011101001000000000000000000010110101000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000100001110011101000000000000000001111101000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001000000000001111111000000000000000000000011010100000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000101001010010000000000000000000001100101000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001000000000101100110111000000000000000000011101100000000]")), 0.0001);
		assertEquals(48.4988, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001001000000000000010000010000000000000000000001000100000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000101000000000100011001011000000000000000000011100110000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000101100000000000111000011001000000000000000001001110000000]")), 0.0001);
		assertEquals(48.9607, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000011101001001000000000000000000010100001000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000001000111011000000000000000011100100000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001100000000101011100101000000000000000000001110001000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000011000010010000000000000000001101110000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000101000000000110101100011000000000000000000001100101000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001100000000000101010010011000000000000000011010100000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000010101010011000000000000000000011100100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000101100000000000010100010000000000000000110000111100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000000010000000000000000000000011011101100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000010001100010001000000000000000001001100000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001100000000101001000011000000000000000000001000110000000]")), 0.0001);
		assertEquals(49.4226, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000100000000000000011000011001000000000000101001100001000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000001000000000000000110011000000000000000010011000100000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000100001001001001000000000000000011100100000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000100001110010011000000000000000001101100000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000001011000010000000000000000000001100100000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000001000000000001001000100000000000000000000011110100000000]")), 0.0001);
		assertEquals(48.4988, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000001000010000000000000000000000000001000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000001000000000000010100000000000000000000011101100100000000]")), 0.0001);
		assertEquals(49.8845, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000000101011000001000000000000000000110101000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001000000000010001000010000000000000000000011100100000000]")), 0.0001);
		assertEquals(48.9607, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000101110100010000000000000000000010101000000]")), 0.0001);
		assertEquals(51.2702, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000101000000000000111010010000000000000000000011110110000000]")), 0.0001);
		assertEquals(49.4226, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000101000000000001110100010010000000000000000011010100000000]")), 0.0001);
		assertEquals(50.8083, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000001000000000000101110100000000000000000000001111101000000]")), 0.0001);
		assertEquals(49.4226, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010000101000000000000000110010001000000000000111000110001000000]")), 0.0001);
		assertEquals(50.3464, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000000000100010000000000000000001001000101000000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas50p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111111001100111011011110011010110111001101111101101111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110011011110110011001010010011010111010100111001100111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100110011111000110011101010010011010111010101111001110110011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111110111101110110111111100011010110101010100011111110111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111111111100110111001010011010110001001101111011100111011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110011101100110111011010010010110011011100111111111111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111111001110110011111000010010010001000101011001101110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111111011000111111011100010010110111000101111101110111011010]")), 0.0001);
		assertEquals(94.6882, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010111111000110111011100100010010011010100111111110110011010]")), 0.0001);
		assertEquals(94.6882, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110011011100100011111010101010110001000100111111101111011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111111101100110011101100011010010101000101111101110110111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110011101000110111111100011010010111011101011111110111011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111011111010110111001100010011110111011100111001100111011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111111011100110011001010010010110101011101011011100111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100110111111100111011111010011010110101010100111001101111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111111101010110011001010011011110111011101011001110111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111111011010111111101000011010110111010101111111110110011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110111011000111011001000011011110011001100111011100111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111011001110111011111110010011010101000101011111101110111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110011011010110011011010011010110011000100011111100111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101110011111110110011101110011011010111010101011001111110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110111101010111011001100010011010101011100011001101110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110111101110111111111010010011110001011101111111111110011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111011011110111111001110010011010001000100011011110110111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111011011110111111111100010010110111011100111101101111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101110011011110111011001010010011110101000101111001110110111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111111101010111111111110010011010111010101111001100111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111011111010111011111100010011010101001100111111111111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111111011111110111011111100010011010101000100111101100110111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101110111101100111011011010011011010111000100111111111110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110011001000110011101100011011110001001100011011101110011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111110011111000111111101010010011010001010101111011110111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111111011001100111011001010010011010011011101111001110111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111111111101110111011101010010010110111001101011001100110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111011111010111111011100010011110011001100011001101111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111111011011100111111111000010010010111001101011011110111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111111011110110111111000011010110111000100011001101110111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110111011000110011111100010011110101010100111111110110111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101110011001100110111111100011010010111011101011101111111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111011001000110111111110011011010011000100011101101111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110011011000110111011000010010010111000100011101110111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111011101110110111001100010010110101000101011101100110011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111110111111110111011001010011010010011000101111101111111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110011011010111111101110011011110101011101011011101111111000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110011001010111011101110010010110111011100011111100111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110011011000110111111100010011110101011100111111101111111010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111110111001110111011001000010011110001010101011001110111011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111011101100111011111100011010010101011101111111100111011000]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111111111011100110011011100011010010111000100011011110110011010]")), 0.0001);
		assertEquals(95.1501, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101111111011010110011011100010010010111011101111101100110011000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas60p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001100100101001011000010010000111011000111011111101111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101101010111011001010010000010110000000011001100100111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100111001100100010011101100010001000000000001111001101110111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101110001001000100000011010011000000001000101011101101110111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101111101011100010110011000010011000000010000011111111101111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001000110001010001110010010100011000100011001110100111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001010100001111001000010001000001001100011111100100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010011010010101011111100010011000001010000011001100100111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001101000010010001000010000100101011001111001100101111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011101110110100101101100010010100010010101111101111100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001001000000010111110011001010100010001011001101111111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010011101010101000101110010010100110001001011001101100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101101100001110101010010001010010000001011011101111111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111001001000111100101000010010100010000001111111100100011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010111110000011000011010010001010001011100111101111101011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010011010100000111011110011001010000001001011101111110011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101001100000010011000011001000101001001011011100111111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011101110110011100101110011001010000010101011101101100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010111011010001001001000010010100001000000011101100100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100011001101000001011011100010001110100011000011011101101111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011101100000000010001100010010010101010101111001110101011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001001100110100111000010000010001000000011101101100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110101100100000110101000011011010010011001111011101101011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001011010111101001000011011000000001000111001110111011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010111100100010010001100011000110100001100011111111100011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110101101000010110101010010000110100010000011001101101011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101111001000100000111001110011011110100000001111001111101111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001111100001110001010010011000011000000011011101110111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010111110000000111011010010000110011000101111101111101011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111101010000001101001110011000010011001101011011100100111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110001011100100101011110010000100100000001111001101110111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100110101001000010010101110010001100010010001111111100100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111101000100111100001000010010000100000001111011101110111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001100010100000111000010011010011011001111011100100111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101000110011110101000011000100101000101011101100100111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001001000001111111100011001000011000000111101110111111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010001010000010000111110010010010110011001111111100110011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001010000011101111110011010110101010000011001100101011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001000110010110011110010011000011011001011111100100011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101011011100110010000111110011010010110000000011001101111011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001111000000100111010010011010110011001011001111110111000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111101100010110100001000010011010000011001111011100101011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001101000001010011100010001000011000101111101110100011010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010011001000011011111000010000100100000001111001100100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001100000010100101010010010110010010101111101110100111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101011100001001001110010000000110011101111001101110011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010101101100011001101010010010000010010000011011100110011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001100000011110101000010001010101010001011101100100011000]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001001010111000011000011001010100001001111101100110111010]")), 0.0001);
		assertEquals(86.836, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101110001011010001101011100011010000100000001011101111101011010]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas70p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010101100000000000011000010000000000000000110001110100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001100000000000011010011000000000000000010011111101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001000000000000001100010001100000000000010000100100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010000000000000100001000011000000000000000011101111100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001000000000000011110011000000000000000101011100101000000]")), 0.0001);
		assertEquals(60.0462, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010111000000000100001101010000010100000000000001101101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000011000010000000000000000010011010111000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010101100000000100000110010000000000000000011001000100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100011001100000000101111100011010000000000000000001101101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011001000000000000011100010000100100000000001100110101000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010101000000000000001100010000000000000000011100100100000000]")), 0.0001);
		assertEquals(60.0462, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000011001011000000000000000110000111101000000]")), 0.0001);
		assertEquals(60.0462, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010101000000000000010110101000000000000000010011100100000000]")), 0.0001);
		assertEquals(60.97, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000010011101010001000000000000011001111110000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010111000000000100001000010000010000000000000011101111000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010101000000000000001000010000000100000000010010110101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001000000000110011000011001100100000000000011110100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010010001000000000000001000000000000100000000011101111101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101111001000000000000101000011010100000000000000011110101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001000000000010001100011001000000000000000001101111000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001100000000000001000011000000000000000101001101100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001101100000000000001000011000100000000000111001100100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101011001100000000000001000011001100000000000000101100100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001100000000000001100001001000000000000110001100100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001000000000000001000010000000000000000010001101101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011111000000000111011010010000000000000000000001100100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001001100000000000001010011001000000000000001001101100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111110001000000000101111010011000100100000000000001111100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010100100000000000011000001001000000000000011001110101000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101100000000000011100010000100000000000001001110100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101100000000000001110010000100000000000011001100001000000]")), 0.0001);
		assertEquals(59.5843, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101000000100000000000111000010000100000000000011001101100000000]")), 0.0001);
		assertEquals(59.5843, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001100000000000011010011010000000000000010001011001000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000100111000010011100000000000000011111110000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001000000000000001000010000000000000000110011100100000000]")), 0.0001);
		assertEquals(60.0462, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101000000000000101000100001100000000000000001111110000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001100000000000001000011000100000000000010011100101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001000000000011101100011001000000000000000001111100000000]")), 0.0001);
		assertEquals(59.5843, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111001101100000000000011100010010000000000000010101001101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010100100000000100001100011000000000000000011011001101000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[00011011001000000000000011000010000000000000000111001100100000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101000000000000010100011000000000000000111001100100000000]")), 0.0001);
		assertEquals(59.1224, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010101000000000110101000100010000000000000000001001100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000010100010001000000000000010111101101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111001101100000000100000100010000100000000000011001100101000000]")), 0.0001);
		assertEquals(61.4319, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101000000000000011000011000000000000000010001110100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101011001000000000100001100010000100000000000001100110100000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110110001000000000000001110010010010000000000000001110101000000]")), 0.0001);
		assertEquals(60.97, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001100000000101111000100010000000000000011101101101000000]")), 0.0001);
		assertEquals(60.5081, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010011000000000000010110010000100000000000011000110100000000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas80p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001000010000000001010010001100000000000111101101100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100011001110000000100011100010000000100000000111101110100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010101000000000100011000010000100100001000111111101100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011001110110000100001000011000000010001000011101110101111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101110110000100011000011000000000000000011101110100011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101110010001100011110011000000000000000011001100100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101010000000000101010011000000010000000011111111100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001000000000000001100010001000000000000011101100100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011101000000001000001010010000000000000000011001100101011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011101110000000100111000011000100000000000111111101101011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001000010000000001100011000000000011000011001100100011000]")), 0.0001);
		assertEquals(77.5982, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001100110000000011110010000000100000000001011100100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101000000000000001000010000000110000000111011110100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000001000010000100010011000011101101100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011001100000000000001000010000000000011000011011110101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001110000000000111100011000000000000000011101111101111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000000101000011000100010000000111101101100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101100000000000011100011000000000000001111001110100011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010001100010001000011000010000100000000000011001110100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000010000000001110010000000000010000111001100101011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001000010000000101000011000100010001000011001100101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001110000000000011000011001000000001000111011101101111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101010001110100000000001100010000000010000000111001110101111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100011001100000000000001100010000000000001001011101111101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001100010000000111100010000000000000000011001110100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011101000100000000011010010000000010001000011101101101111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001100000000100001010010001000000001000111001100100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011001000010001000001000011000100010000000011001101100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001110010000000111000010000100000000000011011101100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001000010000100001100010000000000011000011101110101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001010000000000111010010000100000000000011011110101111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011001110000001000011100010000000000000000111011110100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010001000010000100011110011000000110000000111001111101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001110000001100001100010000000000000000111011101100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101110110000000001100010000000010000000011111100101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011001010000000100001100011001000010001000111001111100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010001110010000100001010010000100000010000111101100100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101100000000000001000011001000000000000011011111101111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111011101000010000100001100011001100000001000011111110100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010101010010000000001010010000100010000000111111100110111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001000000000100001000010000000000000001011101100100111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010101010000000100011010010000000010010000011011110101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111011001000000000000101100010000000000001000111011110101011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011101010000000000111100010000000010001000011101100100111000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100011101100000000000111100010000000000000000011011101100011000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011001010000000100001010010000000000000001011101110101111010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010101000010000000011000010000000000010000011101110101011010]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011001100000000100001010011000100100001000111111111101011000]")), 0.0001);
		assertEquals(77.5982, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001010000010000001110010000100000000000111001110101001000]")), 0.0001);
		assertEquals(78.5219, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101011101000000000100111000010000000010000000111001110101011000]")), 0.0001);
	}
	
	@Test
	public void testGestaoPessoas90p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "GestaoDePessoas/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(67.4365, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010101000000000100111100000000101011010000111001101101000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101010101110000000100000100011010110000000000011001111101000000]")), 0.0001);
		assertEquals(67.8984, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010101101000000000001110100000100100001000001001110101000000]")), 0.0001);
		assertEquals(68.8222, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010101000000000000001100010001010000000100111011100100000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001010000000000001000011010100100001000011001110100000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011100000000000100000010010000100000000000011001000100000010]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111000000000000000000011100010000000000001000010111110101110000]")), 0.0001);
		assertEquals(70.2079, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010011100000000001001100011000111000000000111011110111000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010101110100000000001110010000100000000100011101110101000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010000000000000000011010010000000010000000010101100001100000]")), 0.0001);
		assertEquals(68.3603, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001110000000100001000010001000000000001011100100111000000]")), 0.0001);
		assertEquals(67.4365, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001011100100000000011010010010000100000000010001101100000000]")), 0.0001);
		assertEquals(70.2079, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010001000000000110011100010010001000000000111111101110000000]")), 0.0001);
		assertEquals(68.8222, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001000100000000001010110001000000000000111101101100000000]")), 0.0001);
		assertEquals(70.6697, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100111001000000000010101000011010000100000000011001110111000000]")), 0.0001);
		assertEquals(68.3603, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010101111100000100010110010000000000001100111000100110000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101000000000010000000000100010000000010000000011011000100001000]")), 0.0001);
		assertEquals(66.9746, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001101000100000100011000111000000100001001110111101100000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001010000000100011100011011100000000000111001111100000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010000010000000000000010010000000000000000010101101100100010]")), 0.0001);
		assertEquals(69.746, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010001000000000101101010111100110000000000111101110100000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101000101000000000000010100011000100010001000011101001001100010]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010010000000000000100000100010000000000000000001111101100000010]")), 0.0001);
		assertEquals(70.2079, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100010101100000000010001011001010100100000000111011100110000000]")), 0.0001);
		assertEquals(67.4365, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010101000000000000100100100001100011000000011111111100000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101000000000010000000000110010000100000001000010101111101110010]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011101010000000100000110011000010000000100111001100101000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110110001010000000100001100010000000000000000111101110111000000]")), 0.0001);
		assertEquals(65.5889, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101001100110000000110010110100100110000000000110011100101000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001110000000000010100010000000010000000101100011100100000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111010001000100000011100110011000100000001000111111110100000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011111110000000100011100011000100100001000111101101101000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000000000100000010010000100010001000010011100101010000]")), 0.0001);
		assertEquals(70.6697, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011011100000000010101000011001010000000000011011110110000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001110000000010100110010010100000000000111111101101000000]")), 0.0001);
		assertEquals(68.3603, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010101010000000000100100011010010100000000111100111100000000]")), 0.0001);
		assertEquals(68.3603, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111010001000100000000011100010000010100001000011001000111000000]")), 0.0001);
		assertEquals(70.6697, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101000000000010001110010010010000000000111101101110000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010101110000000101000110010000000100000001011001100101000000]")), 0.0001);
		assertEquals(69.746, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010011100000000000101000011011110000000000111011111100000000]")), 0.0001);
		assertEquals(68.3603, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101011001100000000001001011001010000000000000001111110111000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110010001100100000000011110010001100100001000011011101101000000]")), 0.0001);
		assertEquals(69.746, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010001000000000100011100110010011100000000011011110110000000]")), 0.0001);
		assertEquals(68.8222, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011001010000000100100101000001100100001000111001110100000000]")), 0.0001);
		assertEquals(67.8984, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101010000110000000110010100010001100000001010111101110100000000]")), 0.0001);
		assertEquals(69.2841, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101011001101000000010100100011000000000000000011111110100000000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010010101000000000000000100011000100000000000011001010001100000]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100010000000000000000000000000000100010000000011101100100000010]")), 0.0001);
		assertEquals(64.6651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101000001000000000000000110011000000010001000010101010101100010]")), 0.0001);
		assertEquals(70.2079, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110010011000000000000101111001010010000000000111001110100000000]")), 0.0001);
	}
	
	@Test
	public void testParametros10p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(15.3061, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000010000000000000000000000000110100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000010100000000000000000000000000010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.7392, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000010001000000000000000000000000011100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.3991, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000001010000000000000000000000000000110100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010110000000000000000000000000010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000010100000000000000000000000000010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.966, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000010100000000000110001010000000000000000000000000000000]")), 0.0001);
		assertEquals(12.9252, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000010000000000000000001001000000000000000100000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000100000000000000000000000000011100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100001000000110000000000000000000000000111000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000000100000000000000000000000000111000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000000100000000000000000000000000100100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.3991, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000001110000000000000000000000000100000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000010100000000000000000000000000110000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000001000000100000000000000000000000000110000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.0794, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000000000000110000000000000010010001000000000000000000000000000000]")), 0.0001);
		assertEquals(14.5125, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000011011000000000000000000000000010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000000111000000000000000000000001010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000010100000000000000000000000001010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010101000000000000000000000001010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.059, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000000101000000000000000000000000000100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000000100000000000000000000000000110000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000100000000000000000000000001010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.966, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000011110000000000000000000000000010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000110000000000000000000000000010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.5125, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100101000010110000000000000000000000000010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(14.5125, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000011001000000000000000000000000010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.1927, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000000100000000000000000000000000010100000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000000110000000000000000000000000110000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(15.7596, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000000110000000000000000000000000110000000000000000000000000000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros20p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(28.458, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000110000000000000000000000000110100000000000001010000000000000001000000000000000000]")), 0.0001);
		assertEquals(29.3651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000001000101000000000000000000110100000000000000000000000000000001000100000000000000]")), 0.0001);
		assertEquals(28.5714, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100001000001101000000000000000000000001010100000000000001001011000000000001000000000000000000]")), 0.0001);
		assertEquals(28.2313, calculator.calculateSatisfactionPercentile(calculator.fromString("[00010100001000011110000000000000000000000000110000000000000100000001000000000001000100000000000000]")), 0.0001);
		assertEquals(28.458, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101000000000101000000000000000000000000110000000000000001101110000000000000000000000000000000]")), 0.0001);
		assertEquals(27.6644, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000010101000000000000000000000000010000000000000001000100000000000000100100000000000000]")), 0.0001);
		assertEquals(28.0045, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000001000010000000100100000000000000000110000000000000001000011000000000000000000000000000000]")), 0.0001);
		assertEquals(29.3651, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000010110000000000000000000000001111000000000000100100010000000000001000100000000000000]")), 0.0001);
		assertEquals(27.7778, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000000001000000010000000000000000111000000000000111100001000000000000000000000000000000]")), 0.0001);
		assertEquals(28.3447, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000000100000000000000000000000000011000000000000010100011000000000001000100000000000000]")), 0.0001);
		assertEquals(29.8186, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000000111000000100000000000000000110000000000000000000000000000000001000100000000000000]")), 0.0001);
		assertEquals(28.9116, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000000111000000100000000000000001110000000000000100100011000000000000000000000000000000]")), 0.0001);
		assertEquals(29.4785, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000010111001000100000000000000001110100000000000000000000000000000100000000000000000000]")), 0.0001);
		assertEquals(27.7778, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100001000010011000000000000000000000000110100000000000000101001000000000001010000000000000000]")), 0.0001);
		assertEquals(28.6848, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100101000010100000000000000000000000001111100000000000101000010000000000001000000000000000000]")), 0.0001);
		assertEquals(29.1383, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010100000000000000000000000001111000000000000101011000000000000001000100000000000000]")), 0.0001);
		assertEquals(27.551, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100100100000010101000000000000000000000000010000000000000000000000000000000101000100000000000000]")), 0.0001);
		assertEquals(28.9116, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001110000000000000000000000001111000000000000001111010000000000001000000000000000000]")), 0.0001);
		assertEquals(29.1383, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100001000011010000000100000000000000001111100000000000000000000000000000001000100000000000000]")), 0.0001);
		assertEquals(28.458, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000001101000000000000000000000000110000000000000011100001000000000001000000000000000000]")), 0.0001);
		assertEquals(27.551, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000001101000001100000000000000000101100000000000000000000000000001000000100000000000000]")), 0.0001);
		assertEquals(28.458, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000010010001001000000000000000001111000000000000101010001000000000000000000000000000000]")), 0.0001);
		assertEquals(27.6644, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000000101100000110000000000000000010000000000000000000000000000000001001000000000000000]")), 0.0001);
		assertEquals(28.6848, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000010100000000100000000000000001111000000000000000000000000000000000101100000000000000]")), 0.0001);
		assertEquals(29.1383, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000010101000000000000000000000001110000000000000101011010000000000001000000000000000000]")), 0.0001);
		assertEquals(30.0454, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000001000010001011000100000000000000000110100000000000000000000000000000000000100000000000000]")), 0.0001);
		assertEquals(27.6644, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000010011110011000100000000000000001010000000000000000000000000000000000001000000000000000]")), 0.0001);
		assertEquals(27.551, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001001000101000000000000000000000000110000000000000101000000100000000001000000000000000000]")), 0.0001);
		assertEquals(28.0045, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110000001000011100000001000000000000000001111000000000000000000000000000000010000100000000000000]")), 0.0001);
		assertEquals(27.8912, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000010100000000000000000000000000010100000000000001111001000000000001001000000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros30p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
	
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100000000001111001001110000000000000000111000000000000101011010000000000011000100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100100001000000111110100100000000000000000111100000000000101100010000000000011000100000000000000]")), 0.0001);
		assertEquals(42.7438, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000000101110000101000000000000001111100000000000000010111000000000001001100000000000000]")), 0.0001);
		assertEquals(42.7438, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000001011110001101100000000000000001110000000000000001100011100000000001000100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000010101011100100000000000000000111100000000000101101010100000000001001100000000000000]")), 0.0001);
		assertEquals(44.1043, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100000000010101101000100000000000000000110100000000000001100111000000000001000100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100000000000111111011110000000000000000110000000000000001100101000000000011000100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000011100101001010000000000000001110100000000000111010110000000000011000100000000000000]")), 0.0001);
		assertEquals(42.2902, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100101000001100011101100000000000000000110000000000000111011001000000000011001100000000000000]")), 0.0001);
		assertEquals(43.3107, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000010101111100111000000000000000110000000000000101000010000000000101000000000000000000]")), 0.0001);
		assertEquals(42.9705, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101101000000001001001100000000000000001110000000000000101010011000000000011001100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000100001000011101011010100000000000000001110000000000000001000011000000000001001100000000000000]")), 0.0001);
		assertEquals(43.1973, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000001000011110001000101000000000000000111100000000000001110011000000000011001100000000000000]")), 0.0001);
		assertEquals(42.7438, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000100001000000110011001100000000000000000111100000000000110011110000000000001000100000000000000]")), 0.0001);
		assertEquals(42.7438, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000001001000000111101001000000000000000000110100000000000011001110000000000001000100000000000000]")), 0.0001);
		assertEquals(43.8776, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100000000000100101101100000000000000001111100000000000011110010000000000001001100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101000000000010100111000110000000000000000111100000000000101111110000000000000001100000000000000]")), 0.0001);
		assertEquals(43.8776, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000111101100010000000000000000110100000000000011001011000000000001001100000000000000]")), 0.0001);
		assertEquals(43.8776, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100100100000010101001101100000000000000000110100000000000101001010000000000011000100000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100100001000001110011001101000000000000001110100000000000101110111000000000001000000000000000000]")), 0.0001);
		assertEquals(43.424, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000001000010110111001110000000000000001111100000000000100111111000000000011001100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010111101000110000000000000001110000000000000101001010000000000011100100000000000000]")), 0.0001);
		assertEquals(44.3311, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000010111001000100000000000000001110100000000000001111011000000000001000100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000001000000111010010110000000000000001111000000000000001111011000000000001001100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000011110001001010000000000000000110100000000000001000110000000000001000100000000000000]")), 0.0001);
		assertEquals(41.2698, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010100001101000000000000000001111000000000000100000010100000000101111100000000000000]")), 0.0001);
		assertEquals(42.6304, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100001000011111101101100000000000000000010000000000000111000010100000000011000100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000000000000101011000110000000000000000111000000000000101101010000000000001000100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000100000011101001100100000000000000001111100000000000001101111000000000001000100000000000000]")), 0.0001);
		assertEquals(43.6508, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000011100001100110000000000000001110100000000000101110010000000000001000100000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros40p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(53.7415, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111000000010111111000011000001000000100110100000000000001010011000000001111001100000000000000]")), 0.0001);
		assertEquals(55.5556, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101000000011111011101111000000000000001111100000000000001000110000000001101110100000000000000]")), 0.0001);
		assertEquals(54.3084, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100100001000010111011111110000000000000000110101000100000001001011000000000001001101000000000000]")), 0.0001);
		assertEquals(54.4218, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000100000011101011010111000000000000001110100000000001001110010000000000101001100000000000000]")), 0.0001);
		assertEquals(55.3288, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100101001000001101011110110000000000000001110100000000000001110010000000000111100100000000000000]")), 0.0001);
		assertEquals(53.8549, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000001000001111011011110000001000011101111100000000000101010010000000000001101100000000000000]")), 0.0001);
		assertEquals(55.102, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000001101000000101111001100000000000000000110100000000000001110110100000010101010100000000000000]")), 0.0001);
		assertEquals(55.3288, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100100100000000111011001111000000000000000110100000000000001011010100000010111000100000000000000]")), 0.0001);
		assertEquals(55.3288, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100100101000000101011101110000000000000001110100000000000111111111000000110101001100000000000000]")), 0.0001);
		assertEquals(53.9683, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111100000000011111011100101000000000000000111100000000000101110010100000000111001101000000000000]")), 0.0001);
		assertEquals(54.4218, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000001111011101110000001000010100110100000000000001011011000000000111010100000000000000]")), 0.0001);
		assertEquals(55.102, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111000101000000101111010110000000000000001111100000000000011111011000000001101111100000000000000]")), 0.0001);
		assertEquals(54.4218, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100100000000010101101000110000000000000001110100000000000110111111100000010101000111000000000000]")), 0.0001);
		assertEquals(54.195, calculator.calculateSatisfactionPercentile(calculator.fromString("[10010000001000011111111101110000000000000000111100000000010101110011000000000101111100000000000000]")), 0.0001);
		assertEquals(55.5556, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001100001010101011000111000000000000000110100000000000001010011000000011111001100000000000000]")), 0.0001);
		assertEquals(55.3288, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000001001001111001010111000000000000000110100000000000111110010000000011101000100000000000000]")), 0.0001);
		assertEquals(56.0091, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000001111001101110000000000000000111100000000000001011110000000010111011100000000000000]")), 0.0001);
		assertEquals(54.4218, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000000000111101100110000000000000000110100000000001001011011000000001111110100000000000000]")), 0.0001);
		assertEquals(54.6485, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110000001000010100111101110000001000010100110100000000000001110011000000011101000100000000000000]")), 0.0001);
		assertEquals(54.8753, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001101000011110111101110000000000000000110100000000000101110111000000011101000100000000000000]")), 0.0001);
		assertEquals(54.8753, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001000000010101011001100000000000000001110100000000000001111010000000000101111101000000000000]")), 0.0001);
		assertEquals(53.6281, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001001000010100111001111000001011000101111100000000000011011111000000000001000100000000000000]")), 0.0001);
		assertEquals(55.7823, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101100000000001111111011111000000000000001110100000000000101010010000000000111010100000000000000]")), 0.0001);
		assertEquals(55.5556, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101001000011101101001111000000000000001110100000000000101110111000000110101001100000000000000]")), 0.0001);
		assertEquals(54.0816, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000000000111011101110000000000000000110100000000001011110011100000000011010100000000000000]")), 0.0001);
		assertEquals(55.5556, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101100000000101111001111000000000000000110100000000000011110011000000000101110100000000000000]")), 0.0001);
		assertEquals(55.2154, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100001001000001101111001110000000000000000111100000000000011110010000000011001001100000000000000]")), 0.0001);
		assertEquals(54.6485, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001000000011101011001111000000000000000111100000000000101110010000000101111000100000000000000]")), 0.0001);
		assertEquals(55.3288, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101000000010101011011011000000000000000110100000000000011010010000000011101001100000000000000]")), 0.0001);
		assertEquals(54.8753, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001101001010100011100110000000000000000111100000000000011110111000000110111001100000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros50p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(63.9456, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000010101011110110000000011010000111100000011011001010011000000011101011100000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000010011111011001110000000011010100110100000000000011010011000000010111010101000000000000]")), 0.0001);
		assertEquals(63.9456, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001100000010101111001110000000000010100111111000100000001110010000000001101010111000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100001000001111111101110000000000001101110100000011001101111110000000011101011100000000000000]")), 0.0001);
		assertEquals(65.0794, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101001000001101111101110000000000000001110100000001011101010110000000110111011101000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100101000000111111000111000000000000001111101001000000001110110100000010111110101000000000000]")), 0.0001);
		assertEquals(63.8322, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110101100000010111011000110000000000000001010100000000000011010010011100011101111101000000000000]")), 0.0001);
		assertEquals(65.3061, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001000000001101011001110000000000000000111101001100000001011010000000010111011101000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000010011101011010110000000000010100111100000000000011011011100000011101111101000000000000]")), 0.0001);
		assertEquals(63.7188, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100001000000101011111110000001000010100110100000100000011111110000000001111110111000000000000]")), 0.0001);
		assertEquals(65.0794, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101101000001101011000111000000000000001111011010100000101010011000000110101010111000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101001000011111111011101000000000000000110101011100000101100110000000011101100111000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011111000001101111111110000000000000000110101011000000111010110000000110111000101000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101100000001111111000111000000000000000111000000000000101111011011110011101100111000000000000]")), 0.0001);
		assertEquals(65.0794, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000001111111100110000000000000001110101001100000111010010100000010111010101000000000000]")), 0.0001);
		assertEquals(64.3991, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100000000001111011000111000001010010100111100000011011111010111000000010101000100000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101000001000011111011000110000000011001100111100000000000111010011000000111111111111000000000000]")), 0.0001);
		assertEquals(64.3991, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000001111111000111000001000010101111101010100000101110011000000000101010101000000000000]")), 0.0001);
		assertEquals(64.3991, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000000001101111100100000000000000001111111000110011011110110000000010111000101000000000000]")), 0.0001);
		assertEquals(65.3061, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101100000001111111011110000000000000001110111000000000111110010000000010101010111000000000000]")), 0.0001);
		assertEquals(64.8526, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101000000001111011111111000001000010100111100000000000001011011000000010111011111000000000000]")), 0.0001);
		assertEquals(64.8526, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101000000001111011001110000000010010101111100000000000101010011100000111101111101000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101101000011111011010110000001011011100111100000000000111011011100000011101011100000000000000]")), 0.0001);
		assertEquals(64.1723, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001001000010111011101110000000010000101110100000000000111010111000000011101011100010000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101001000001111011100111000000000000100110100000000001011111011000000010111100100000000000000]")), 0.0001);
		assertEquals(64.6259, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101000001000011111011000111000000000000001111100000001001001110111100000110111101111000000000000]")), 0.0001);
		assertEquals(65.0794, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001110000001111111011110000000000000001110100000011111111110110000000010111111100000000000000]")), 0.0001);
		assertEquals(65.3061, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001000000001101111111111000000010000101110100000000000011111111000000011111010100000000000000]")), 0.0001);
		assertEquals(65.3061, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000001000001111011011111000000000000000110011000100000101111110000000011101110111000000000000]")), 0.0001);
		assertEquals(64.8526, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001001000011101011001111000000000000001111100000011011011010011000000010101011110000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros60p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111101000000011101111111110000000010011100110111100100000011011111100000011101011101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101101100000001111011101110000001011010101111111001110011101111111000000111111111111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110101000000001101011111110000001000010100110111010100001111010110100000111101111111000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110101001000001111011010110000000011000101111101100010011011010110000000011101110111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110100000000011111111010111000001000010101111111011101001011111111000000110111110111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101100000001111111000110000001011000101111101000100011111110110000000111101010111000000000000]")), 0.0001);
		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111101000000001111111101110000001011000101110101111100001101010011000000010101111101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001000000001101011011111000000000000100110101010001011111011110000000011111111111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001101000011101111110111000001000000101111101001101001001010010000000111111110101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001000011111011000111000001000010101111111011100001001110110100000010111110111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001001000011111111111110000000000000001110101000010011001110111011100111111110101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100001000001111111010111000000010010100110101010011011111111110000000011101011111000000000000]")), 0.0001);
		assertEquals(74.3764, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001001000001111011010110000000000000000111101000000001101010010011111011111010101000000000000]")), 0.0001);
		assertEquals(73.0159, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001100000011111111001111000000011001100111111100000000011111010001100010111000111000000000000]")), 0.0001);
		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001100000011111111010111000001011010101111111011100000001110111000000010111010111010000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001000000011111011001111000000000011101110101010110001111010110000000010101010111000000000000]")), 0.0001);
		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101100000001111011110111000001000010101110101011100000111111111001110000111011111000000000000]")), 0.0001);
		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111001000001101011000111000000000001000111101000110011111010110000000011101010101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011101000001111011100110000000010000100111101001110001011011011000000011101010101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100101000000001101111001111000001000010101111111000110011101110111100000011111110101000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100101000010011111011110111000001011000101111101000100000011010111000000111111110111000000000000]")), 0.0001);
		assertEquals(73.2426, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110100001010011101111111111000000000000000110100000001111101010111101100111111111101000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001001000001111111000110000000000010101110101001101101111111111000000010101111101000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001100010011111111011111000001011000100110111000100000011010110100000010111011101000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111001000011111011001110000000000000100110111010101001111111110000000110111011111000000000000]")), 0.0001);
		assertEquals(74.1497, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101001000001101111011110000000000000001110101010001011001010010011100010111010101000000000000]")), 0.0001);
		assertEquals(73.6961, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001101000001111011000111000001011000101110101010000111111110111000000010101111101000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110001000000001101111100111000001000000100111101010110011111110110000000011101011101000000000000]")), 0.0001);
		assertEquals(73.4694, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101100000001111011011110001000000011100111101001100000011010111000000111111011111000000000000]")), 0.0001);
		assertEquals(73.9229, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001100000001111011000111000001000011101111101000110011011011110000000011111111111000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros70p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001101000011101111010111000000011000101111101000111001011010110011111110101110111000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111000000011111011010111000001011010101110111011101001101110111001111110111011101000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110101001000001101111011111000000011000100110101001101011011010110011111110101010111000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111001101000011101111010111000001010000101111111011101011111011010011101111111011111000000000000]")), 0.0001);
		assertEquals(82.5397, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110111101000011111011010111001010000000000110101010110001111010111011101110101110101000000000000]")), 0.0001);
		assertEquals(82.5397, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101101000001111011011111101010011000100111111000100000011011111011111011101111111000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001001000001111011110111000000010010100111111001111001111111111001101011101110111000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001100000011101111011111000000011010101110101000101011101111111101111011111011111000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001001000001101111010111000001010010101111101011101001111011111001101110101110111000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101000000011101111110111000000011011101111111001111011011111011001111010111111111000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101100000001101011010111000000011001101111101001111001111011010001111011101111101000000000000]")), 0.0001);
		assertEquals(82.5397, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001001000001101011110111001111010010100111101010100000011010110011101010101010101000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001101000001111011010111000001011000101111111101111011111011010011111010101111111000000000000]")), 0.0001);
		assertEquals(82.0862, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001001010011111011111111101001011000101110111010100000011011010011111110111011101000000000000]")), 0.0001);
		assertEquals(82.0862, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111100000011111011000111101010000000001111111011100001011010011001111011111111101000000001100]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001100000001111011111111000000010010100111101000111011011111110011101011101111101000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110101001000001111011111111000000010000100110101010101001111011110011101010101010111000000000000]")), 0.0001);
		assertEquals(82.3129, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100101101000011111111110111000001010010101110111010111011011110110101001011101111111000000000000]")), 0.0001);
		assertEquals(81.4059, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110001001000001101111111111101001010010100110101001101001111010111000000010111110101000000001100]")), 0.0001);
		assertEquals(82.3129, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101000000001101111011110101100000000100110111000111001101111010001111010101110101000000000000]")), 0.0001);
		assertEquals(82.7664, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001000000001111011010111000000010001101111111000100001011111110011111011111110101000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001101000001111111111111000000010010100110111000101011111011111011101011101010111000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100001001000001101111010111000001010010100110111010101001011010111011101111101010111000000000000]")), 0.0001);
		assertEquals(82.7664, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100001000010001101111010111000000011010100110101011111001001111010001101011111111101000000000000]")), 0.0001);
		assertEquals(83.22, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001000000011101111110111000001011000101110111010111001011010110011111010111111101000000000000]")), 0.0001);
		assertEquals(82.7664, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110001101000001101011111111001110000000000111101011111101101011111011101111101111111000000000000]")), 0.0001);
		assertEquals(82.7664, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101100000011111011111111000001010010100110111000100001111111111101101111101110101000000000000]")), 0.0001);
		assertEquals(82.3129, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110100001000011111011111110001010000000101110111011101001111011011011101010111011101000000000000]")), 0.0001);
		assertEquals(82.9932, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110101100000011101011111111000001010010101110101000101001011011010011111011111110111000000000000]")), 0.0001);
		assertEquals(82.5397, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100101001000001101111010111000001010010101110101001110111001010111011101010101010111000000000000]")), 0.0001);
	}
	
	@Test
	public void testParametros80p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001101011001101111111111001111011000100110101000100011111010111001111011111111101010000000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011001011001101011111111001011010001100110111011111011111110110011111110101111101000000001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111001000000001111011111111101111010010100110111000111111011011111111101111101010101000000001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111101010001111011111111001011011010100110111100111011011110110001101010111111101110000000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110101101011011101111011111001010010000101110111100101011011111111101111011111110111001100000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111100011001111111011111101111011010100110101100101011111010110001101010111011101001100000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100111101010011111011110111001110010000101111111011111001011011111111101010111011101010000000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110011101011001111111111111001011011000100111111011111011011110110101111011101010111000000001100]")), 0.0001);
		assertEquals(89.5692, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111000011001111011011111000001111010100110101100101111111011111111111011111011111011100000000]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100101100000011111011000111101011010010100110101111111001011110111011101010111011111010000001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100111000010011111111110111001010011000101111101001111001111010111011111010101010111000000000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101001100010011111111110111001010010010101111101011111011111111110101101011101110111000000001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111001001011001101011010111001110010000100110111011111011011111111011101110101011111001100000000]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110001101010001111011001111101010010000101111101010111001111111110001101110111111111010000001100]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011000010011101111110111101011000010101111101001111011111011110001111110111010111010000001100]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100111100000011111011110111001011000000101110101110101011011010111011111010111010111001100001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110101101010011111111111111001110011010101110101110101001011010111001101111101111101000000000100]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110001101000001111011000111001110010011100111111001111001011010111001111011101110101001100001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100101101010001111111111111001110011001100111101001101001011011110001111010111010111000000000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110001001010001111111110111101010010000100111101111101011111110110111111111101111111000100000000]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110111000000011111111101111101110010000100111101000111011011011111011111110111110101000100001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100111000000001101111110111001010010001100110111110111001111010111101111011101110101000000000100]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111011101000001101011010111001011010000100111101001110011011110111011111011111110101001100000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100101100011001101111110111101110011001101111101001111111011110110011101010101111111000000001100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110111100010011101111011111101010010000101111101000101001111111110101111010111011101000100000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00110011001000011101111011111101110010001101110101100101011011011111111111011101110111000000000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100011001011001111011011111001010011000100111101011111001111010111101101110101011101010000000000]")), 0.0001);
		assertEquals(89.7959, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111101101000011111011111111101010000011100110111010101011011010111101101110111011111010000000100]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110111100000001111111110111101110010011101111101111111011111010111011101110101111111000100000000]")), 0.0001);
		assertEquals(90.0227, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111001000000001101011110111101111011001100110111010111101111110110101111110101110111000100000000]")), 0.0001);
	}
	
	@Test
	public void testParametros90p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "Parametros/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "Parametros/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);

		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110011000010001111111110111101011010011101111111100101101011111110111101111101010111111100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111011001011011101011010111101110010011100110101011111111111110110111101010111110101011100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101011001011011101011111111001110011010100111101111101101111110110101101010101111111011100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[00111011101010001111011111111001010011001100111111111101111011011110101101111101010101110100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100111001010001111011011111001110010001101111111100101111011111110101101010111011101011100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111101011001111011110111101011010001101110101110111101111011110101101011101111111010100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101111101011011101011111111001110010011101111111100111111111111110011111011111011101111100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101101000011001101011011111101010011011101110111101111101111010110101101110101010111110100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011101010011101111010111101110010011100111111000101101111010110111101010111010111110100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101101101010011101111111111001110010011101111111110101101011010111111111010101011111111100111100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011000010011111111110111101011010001101110111001101111111111110101111111101111101111100111100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111001000011001111111111111001111010001100111111101101101111010110111101110111010111111100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011101010011111111011111001111010001100111101100111111111110110101101110111110101110100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110111101011001111111010111101111010011101110111111111111011110111101101110101011111110100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011000011001101111011111101110010011100111101110101111011111110001101110101111101111100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101111101010001101011011111101110011010101110111111111111011010111101111110111111111010100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110111000010011101111010111101011011001101110111100111111111111111101111110101110111110100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111100010001111111111111101110010001101110101101111011111111111101111010111011101111100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101111000010001111111111111101010011001101111101111101111011110110011101011111111111110100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101011100010001101011110111001010010001101110101100101101011111111001111110111110111011100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111101011011101111111111001111011011100110101011101101111011110111111011101111111010100111100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111101010011101111111111101110010010101110111101101111111011111101101110101011101111100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111000010011101111011111101111011011101111101100101111011010110001111110101010101010100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111001010011101111110111101111011000101111101101111101011011111101111010101011101111100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01101111000011011101111011111001110010001100111111110111001111110110101101011101011111011100111100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110111101010011101011010111001011010011101111101111101111011011111111111110111011111010100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011101011011101111010111101111011011100110111110111101111110111111111110101011111010100110100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011001011001101011010111101110010000100111111111101111111011110111111011101010111110100010100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111100010011111111111111101111011011101110101000101111011111111111101111101010111111100011100]")), 0.0001);
		assertEquals(96.3719, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111001010011111011110111001111010010100111111101101101111111110101101110101011111010100110100]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores10p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110000000000110010010000000100000000111000000011010110011111110000000000000000000001001000000000000011000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100000000100110011100100000100000000100000000011001111100111110000000000000000000000000000000000000101000000000000000100000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110000010101000101000000101000000000011000000001001110101111110000000000000000000000001000000000000110100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.4545, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000100000000000110000010011000101100011100001000000110000010011010110111111000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.7792, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000010000000100000000011010111110000000000000100010000010011011110111111010000000000000000000000001000000000000000000000000000000000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.4805, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010010000011000100110000000010000000100010000011011110101111000010000000000000000000000000000000000111100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000000011110110010010000000000000010000000011011010100111110000000000000000000000001000000000000111100000000000000000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.1299, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000100010101101101100000100011000000000000000011011111101011010000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110100000100010000100110000000000000110010000011011110011111010010000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(21.2662, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000010000000110100000100100101111001000000000000101000000011010111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000001010101011100000000000001000111000000011010110111110010000000000000000000000000000000000000111100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100000000000111000110001101000100000110000000011011110100111010000000000000000000000000000000000000101100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.2922, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000000010110011011010010000000000000011010000011011111101111000000000000000000000000000000000000000101000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110000000011100010110000010010000000100000000011010101111101010010000000000000000000000000000000000110100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110000000110010100010000000010000000000010000011010111111011100000000000000000000000000000000000000011000000000000001000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100000010000011010100000100010000000000000000011011110110111110000000000000000000000000000000000000001000000000000001100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100000000100010000010000001000100000110010000011011010111110110000000000000000000000000000000000000111100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010000010010000101001000010011100000110010001011010011111110110010000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.3182, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010010010011110001010010000010000000100000000011011111000111000000000000000000000000001000000000000100100000000000001000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010010010011100011101000000000000000101000000011000111101110010000000000000000000000000000000000000111000000000000001000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.1299, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000000000000110000000101001000000000000000000000010000000011011101111111010000000000000000000000000000000000000111000000000000001100000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010000011110011000000010000100000000000000000011011110111110100000000000000000000000000000000000000111000000000000000000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.2922, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000000010011001000010100000000010000000100000000011011111111111100000000000000000000000000000000000000010100000000000000000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.7792, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110100010100101111000000000011000000110000000011010011111111010000000000000000000000101000000000000000000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100110000001100001000001100000100000110000000011011010111111010000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010000000000100010011000000000110000010001000000101000000001011111101111110000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.1558, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000100000010011000010010011010000000000110000000011010111100101010000000000000000000000100000000000000101100000000000001000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(20.9416, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010010010000110011001001010010000100110010000011011110101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.4805, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010000000101000010000000100000001000011010000010011111101111010000000000000000000000001000000000000111100000000000000000000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(19.4805, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000010000000111001011000001010011000000000000000011011101110011110000000000000000000000000000000000000000100000000000000100000000000000000000000000000000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores20p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(38.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001010000000110110001111111111111101101001100000101000000011111111111111110100000000000000000000001000000000000111101010100010110100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.7987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010000000000110100011101111111110110010111100000110010100011011111111111110000000000000000100000000000000000000111001010101010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.7987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010100000000110110011111111111000011110110100000110000000011011111111111110000000000000000010000001000000000000111101010101000111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010000000000110000011111111111110011001001100000110000000011011111111111110100000000000000000000001000000000000111101010011001111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001000000000110100010111110111011110110001000000111010000011111111111111110000000000110100000000001000000000000111100010101010110100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.1494, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000100000000000110000001111111101111010011011100000111010000011011111111111110100000000110010000000000000000000000111100010100010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.8247, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001001000000110000010111111111011011001100100000110000100011011111111111110010000000000000000000000001000000000111100011111110010100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110110011111111111101101110110110000111010000011011111111111110000000000000000010000000000000000000111100010100000100111010000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000000000000110000011111111111110111110011100000100000000011011111111111110000000000000000100000000000000000000110100010101010111111100000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000000000000110110010101111111111111101001000000111001000011011111111111110010000000000000100000000001000000000111100101010101001100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000110000000000110010011111101111111000100111110000111010100011011111111111110000000000000000000000000000001000000111101010101010010100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001110000000110110010011111101110001111100100000110010000011011111111111110000000000000000000000000000000000000111100010101010111101000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(39.2857, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000001000000110010011111111111110101110101110000110010000011011111111111110000000000000000000000001000000000000111100010101010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.8247, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010000000000110010010111111111100011100110000000111010000011011111111111110000000000111100000000001000000000000011100010100010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.1494, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000010000000110110011111101101111100101101000100111010000011111111111111110000000000000000000000101000000000000111101000001010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.1494, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010000000000110010011111111111111101110110000000111000001011111110111111110000000000000000000000000000000000000111100011001111101000000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000100100000000110010011101110111111100010101101000110010000011011111111111110000000000000000010000000001000000000111100010101010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000100000000000010110010111111111110111110010000000110010000011011111111111110000000000000000010000001001000000000111101010101010101100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000100000000000110110010111111111111110001011100000111010000011011110111111110010000000000000000000100000000000000111101010101000111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.1494, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001010000000111100010111111101111011110111000100111001000011011111011111110000000000000000000000001000000000000111100010101000111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.6623, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000100000000110000010111111001101110011111100100111000000111011111111111110000000000000000000000000000000000000111100011110110101100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000000010000000100100011111111111011111010111100000111000000011011111111111110000000000000000000000001001000000000111100010100010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000011000000110110011111110111110110101100000000110000100011011111111111110000000000000000010000001000000000000111100010101010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001000000000110010011111111110111001000100100000111000000011011111111111110000000000000000000000001000000000000111100001111101111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000100000000110110010111011111101101111011100000110010000011011111111111111000000000000000100000000000000000000111100101010101001100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.961, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010100000000110000011110111111111111011110000000111010010011011111111111110000000000000000000000000000001000000101100010101010111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(36.3636, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000100000000110110000111011111111001000000010000010000001011011111111111110000010001000000000000000000000000000111110011011101111100000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000011000000110100011011111111111000101101100000110010000011011111111111110000000000000000000001001000000000000010100011111101001100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(37.013, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000100000000000110100011101111111101100011011101000101000000011010111111111110000000000000000100000100000000000000110100011001111111100000000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(38.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000000110000000110100010111110111110100111111100000110000001011011111111111110000000000000000100000000000000000000111101010101010011100000000000000100000000000000000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores30p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(59.9026, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111000100111010001011011111111111110000110000111110110000001001001000000111111111111111111111110000000000100000000001100000000000001100000001101000]")), 0.0001);
		assertEquals(60.3896, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111110100000111011000011111111111111110100011111111110010000001001001000000111111111111111111111110000000000100000000001100000001100000000001100000000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000011111000000111110011111111111111111111111110000111011001011111111111111110100011111111010110001001000001000000111111111111111111111110000000001111000000000000001101010000000000000000000]")), 0.0001);
		assertEquals(61.039, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110111111111111111111111111100000111011110011011111111111110100011101111110110000101000001000000111111111111111111111110000000001111000000000000000001100000000000000000000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000111111000000111110011111111111111111111111110000111010000011011111111111111010011110111110110001001001000000000111111111111111111101110000000001111000000000000001100000000000000001101000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111110111100100111011000011011111111111111000011111111110010001001000001000000111111111111111111111100000000001111000001100000000000000000000000001110000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110111111111111111111111111110000111010011011011111111111111000011110111110100000101000001000000111111111111111111111100000000000100000000000001100000000000000000001111000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000000111111000000111110111111111111111111111111100000111010001011011111111111110100011111111110100000101000000000000111111111111111111111100000000000100000000000000001110000000000000001101000]")), 0.0001);
		assertEquals(59.9026, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000011111000000111110111111111111111111111111100000111010001011011111111111110100011110011110110000101001000000000111111111111111111110010000000001111000001001000000000000000001100000000000]")), 0.0001);
		assertEquals(59.7403, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000011111000000111110011111111111111101111111100000111010010011111111111111110010011111111110100001101000000000000111111111111111111111110000000001110000000000000001100000101110000000000000]")), 0.0001);
		assertEquals(60.8766, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000011111000000111110011111111111111111111011110100111010000011011111111111110010011111111110110000001001001000000111111111111111111111110000000001111000000000000000001101100000000000000000]")), 0.0001);
		assertEquals(60.2273, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000110110011111111111111111111111101100111011000011011111111111110000011101111110100000101000001100000111111111111111111111110001100000100000000000000000000001100001100000000000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000111111000000111110011111111111111111111111100000111010001011011111111111110010011101111100110000001000001000000111111111111111111111110000000001111000000001100000000000000000001100100000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111100100111010001111011111111111110100001110110110110000001001001000000111111111111111111111111100000001111000000000000000001100000000000000000000]")), 0.0001);
		assertEquals(60.3896, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111101111101000111010000011011111111111110001111101110110100000001001001000000111111111111111111111110000001101101000000000000000000000000000000001101000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111100000111011011011011111111111111000011111111110100000001000001000000111101111111111111111110000001101111000000001110000000000000000000000000000]")), 0.0001);
		assertEquals(60.8766, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000110111000000111110011111111111111111111111100000111010000011011111111111110001111111111110110000000000001000000111111111111111111111110000000001101000000000001100000001110000000000000000]")), 0.0001);
		assertEquals(60.3896, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000111111000000111110011111111111111111101111100000111011100111011111111111110110011111111100110000101001001000000111111111111111111111100000000001111000001011100000000000000000000000000000]")), 0.0001);
		assertEquals(61.2013, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111100000111010110011011111111111110100011111111110110001001000000000000111111111111111111111110000000001111000000000000000000000000001100001100000]")), 0.0001);
		assertEquals(60.3896, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000111111011000000111110011111111111111111111111101100111011110011011111111111110000011101111110000000001001000000000111110111111111111111110000000001111000000000000000000000000001100001100000]")), 0.0001);
		assertEquals(60.3896, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000010111111000000111110011111111111111111111111100000111010110011011111111111110100011111111000100001001000001000000111111111111111111111110000000001111000000000000001100000000000000100000000]")), 0.0001);
		assertEquals(60.2273, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111011000000111110011111111111111111111111100100111010000011111111111111111000011110111010010000001000001000000111111111111111111111110000000001110000001100100000000000000000000001101000]")), 0.0001);
		assertEquals(59.9026, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111001000000111110011111111111111111111111111000111011000011011111111111111000011111111000100000001000001000000111111111111111111111100000000000111000000000000001100000001100000001101000]")), 0.0001);
		assertEquals(60.0649, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111110100111010001111011111111111110000011101000000110000101001000000000111111111111111111111110000000001111000000101100000000000000000001110000000]")), 0.0001);
		assertEquals(59.9026, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111100001111011011011011111111111110100011011000000110000000000001000000111111111111111111111110000000001111000000001100000000000001000000001101000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111101000111011000111111111111111110110011111011110110000000000000000000111111111111111111111110000000001111000000000000001100000000000001100000000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000111111000000111110011111111111111111111111101000111010000011011111111111110001011101111010110000001001101000000111111111111111111111110000000001111000000000000000000000000000000001101000]")), 0.0001);
		assertEquals(60.5519, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111010000111110011111111111111111111111100000111011100011011111111111110000011111111010110000001001001000100111111011111111111111110000000001111000000000000000000000000000000001100000]")), 0.0001);
		assertEquals(60.7143, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000110111100000111110011111111111111111111111100000111010000011011111111111111000011111111010110000001001000000000111111111111111111111100000000001111000001100000000000000000000000001101000]")), 0.0001);
		assertEquals(60.2273, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111110011111111111111111111111110100111010000011011111111111110010100000111100110000001001001000000111111111111111111111110001100001111000001100001000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores40p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(67.6948, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111100010111011000011111111111111110000011111111110110000101000001000101111111111111111111111100000001101111000000000000001100000000001101101111100]")), 0.0001);
		assertEquals(67.8571, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000100111111000000111110111111111111111111111111101011111010000111011111111111110010011111111110110001101000001110000111111111111111111111100000000001111000000000001110001100000000001101101100]")), 0.0001);
		assertEquals(68.5065, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111110011111010000011011111111111111001111111111110110000101001001000000111111111111111111111111001100001110000000000000001100000001100001101101000]")), 0.0001);
		assertEquals(67.5325, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101010000111111111000000111110011111111111111111111111100000111011010111111111111111110010011111111100010000001000001000000111111111111111111111110001101111110000000001110000000001100000000001111100]")), 0.0001);
		assertEquals(68.0195, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000110111111000000111110111111111111111111111111110111111011000111011111111111110001111101111110110000100001000000000111111111111111111111100000000001111000000001111110000001100000000001111000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000011111111000000111110111111111111111111111111101011111010001011111111111111111111111110111110110000101000001000000111111111111111111111111110000001111000000000000000000000001101100001101100]")), 0.0001);
		assertEquals(67.5325, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000111111111000000111110111111111111111111111111101000111010100111111111111111110010011111111010100001001111001000000111111111111111111111110001100000100000001100001110000001101110000001101000]")), 0.0001);
		assertEquals(67.5325, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101010000010111111000000111110011111111111111111111111101011111010100011111111111111110000011111111110110000001001001111000111111111111111111111110000000001111000001100000001110000001000000001101100]")), 0.0001);
		assertEquals(67.6948, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111011101000000111110011111111111111111111111100000111010101111111111111111110001111111111100110000001001001000000111111111111111111111110000001111111000000001101100000001001001100001101000]")), 0.0001);
		assertEquals(67.3701, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000111000111111000000111110111111111111111111111111100100111011010011011111111111111010111101111110110000001001001000000111111111111111111111101100000001111000000000000001110000000001100001111000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111100100111010001111011111111111111001111111111110110000101001001000000111111111111111111111010001100001111000001110001101110000000000000001111000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100000000111111111000000111110111111111111111111111111110100111011001111011111111111111101111101111110110000000001001000000111111111111111111111111100001101111000000000000000000001100000001101101000]")), 0.0001);
		assertEquals(67.3701, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000101111111000000111110011111111111111111111111100011111010001011111111111111110000011100111110110001001001110100000111111111111111111111110000001101111000000000001001100001100000001101010000]")), 0.0001);
		assertEquals(68.0195, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111111000000111111111111111111111111111111110011111110000011011111111111110001011111111110110000001001001000000111111111111111111111110000000101111000000001100000000001111100000001111000]")), 0.0001);
		assertEquals(68.0195, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111010010111110111111111111111111111111101100111011100011011111111111111101111111111100110001001001001000000111111111111111111111110000000000100000000001100001101101100000000001100100]")), 0.0001);
		assertEquals(68.0195, calculator.calculateSatisfactionPercentile(calculator.fromString("[11000000000000111111010010111110111111111111111111111111100111111011001011111111111111110000011111111100110000001001001000000111111111111111111111110000000001111000001100000001101110000000001111101000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111101111111010001011011111111111110101111100111110100000101001111000000111111111111111111111110000000001111000000000000000001101110000001101111000]")), 0.0001);
		assertEquals(68.3442, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111100000111010110111011111111111111011111111111110110000001001111000000111111111111111111111110000001101111000000001100000001100001101100000000000]")), 0.0001);
		assertEquals(68.3442, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110111111111111111111111111101100111010011011011111111111110000011111111110110000101001001000000111111111111111111111110001100001111000001101101100001100000000000001101000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[01100000000111111101000000111111111111111111111111111111101100111111010111011111111111110001111111111110010001001001001000000111111111111111111111110000000001111000000001100001110001101110000000000000]")), 0.0001);
		assertEquals(68.6688, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111101111111010000111111111111111111001111111111110110000001001001000000111111111111111111111110001101101111000000000000000000001110000001101100000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110111111111111111111111111100111111010000111011111111111110010011111111010110001001001001000000111111111111111111111110000000001111000001100001101100000001001000001101100]")), 0.0001);
		assertEquals(68.0195, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000110111111000000111110111111111111111111111111100011111010100111011111111111110010011101111110110000001001001000000111111111111111111111110001000001111000000000000001100001000001101111101000]")), 0.0001);
		assertEquals(67.8571, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111010011111110011111111111111111111111111011111010000011011111111111110000011110111100110000001001001000000111111111111111111111110000000001111000001001100001100001000000001001111000]")), 0.0001);
		assertEquals(67.6948, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101010000111111111000000111110011111111111111111111111110000111011110011111111111111110110011111111110110000001000000000000111111111111111111111110000001001111000001000000000000000001101111101101000]")), 0.0001);
		assertEquals(67.8571, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111101000000111110011111111111111111111111100000111010010111011111111111110011111111111100010000101001001000000111111111111111111111110000001101111000001100001110001100000001100001111000]")), 0.0001);
		assertEquals(68.3442, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111000000111110011111111111111111111111101000111010010011111111111111111001111110111110110000101001001000000111111111111111111111110000001101111000000001100000001100000001110001111100]")), 0.0001);
		assertEquals(67.8571, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000000111111000000111110111111111111111111111111110000111010101011111111111111111000011111111100110001001001001111000111111111111111111111110000000001111000001100000001100001100000001101101100]")), 0.0001);
		assertEquals(67.6948, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000000111111000000111110111111111111111111111111100000111010000111111111111111110010011111111010110000101111001000000111111111111111111111110001100001111000000000110000001101100001100001101000]")), 0.0001);
		assertEquals(68.1818, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111011111000000111110111111111111111111111111110000111010000011111111111111111000011111111110110000001001001000000111111111111111111111111100000001111000000000001101110000001110000001101100]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores50p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000011111000000110110011111111111111111110111100100111010000011011111111111110000000000000000010001000000001000000111110111111111111111100000000001111000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.487, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000011110000000110110011111111111111011111111110100111010000011011111111111110000000000110010110001000000001000000111101111111111111101010000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.7857, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000011111000000111110011111111111111011111111100100111010010011011111111111110000000000000000110000001001001000000111111111111111111110110000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.1364, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000000011000000111110011111111111110111111111100000111010001011011111111111111100000000111110010000000000000000000111111111110111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000110011000000110100011111111111111011111111100000111010011011011111111111110110000000110010110000001000001000000111111011111111011111110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000111010000000111110011111111111111101001111110000111010001011111111111111110000000000111100100000001000001000000111111011111111111111100000000000000000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.6234, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000110111000000110110011111111111111111101111100000111000000011011111111111110000000000110110010000001000000000000111111111111111111111110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000011101000000111110011111111111111111011011100000111010000011011111111111110000000000111010110001001000000000000111111111111111111100000000000000110000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.1364, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000100111000000111010011111111111111111011111110100111010100011011111111111110000000000111110110000101000000000000111100011111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000111100000000110110011111111111111111111111110000111010000011011111111111110000010000000000110000101001001000000111101111111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.7857, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000110011000000110110011111111111111111111111100000111010000011011111111111110000011010111110010000001001000000000111110011111111111101100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.8117, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000011010000000110100011111111111111111111100100000111010000011011111111111110000011101111010110000000000000000000111111111011111111001100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.6494, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000111111000000110110011111111111111011111111100000111010000111011111111111110000011111000000000000100000000000000111111011011110011111110000000000100000000000000001000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000110110000000111110011111110111111011111110100000110010000011011111111111110110011111000000010000001001000000000111111111111111111110100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.2987, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000011100000000110010011111111111101111111111100000111011000011011111111111110000011010110110000000001000000000000111111111111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000111110000000110110011101111111111111111111100000111011000011011111111111110110000000111110010000101001000000000111111111111111110100000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000101111000000110110011111111111111100111110100000111010000111011111111111110010000000111010100000000001000000000111111111111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.2987, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000001011000000110110011111111111111110110110100000111010000011011111111111110000011110111000010000000001000000000111110111111111111111110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000111010000000110110011111111111111111101111100000111010001011111111111111110000000000111110010000000000000000000111111111111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000111111000000110010011111111111111111111110100000111010000011011111111111110110000000000000110000101000001000000111111011111110111101100000000001111000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.2987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000011011000000111110011111111111111111111101100000111010000111011111111111111000000000111110010000100001000000000111111011111111111001110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.1364, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000101111000000111110011111111111111011111011000000111010100011011111111111111000000000111110100000101000000000000111111011111111111011110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.2987, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000110111000000110110010111111111111111111111100000111000000011111111111111110000011101000000110000001000000000000111111111111111111110010000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.2987, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000001111000000111110011111011111111111111011100000111011000011111111111111110000000000111000010001000000001000000111111111111111111101110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[00000000000000010100000000110110011111111111110111111111100000111010100011011111111111110000011001111000110000000000000000000111111111111111111101110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.461, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000000011100000000111110011111111111111111111101100000111001000011011111111111111000000000111010100000000001000000000111110111111111111111100000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000001011000000110110011111111111111111011011100000111010000011011111111111110000000000111010110001001000001000000111100011111111111111100000000001111000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.1364, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000111010000000110110011111111111111101111111100100111010100011011111111111110010011110000000010000001001001000000111111111101111111101000000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(51.7857, calculator.calculateSatisfactionPercentile(calculator.fromString("[00100000000000100011000000111110011111111111111111111111100000111010000011011111111111110000011101000000110000001000000000000111100111111111111111110000000000100000000000000000000000000000000000000000]")), 0.0001);
		assertEquals(50.974, calculator.calculateSatisfactionPercentile(calculator.fromString("[10000000000000101010000000110110011111111111111111111110100100111010000111011111111111110000011100111100000001001001001000000111111111101111111100000000000000100000000000000000000000000000000000000000]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores60p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(74.513, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000000111111010011111111111111111111111111111111110000111110010111011111111111110110011111111010110000001111111000000111111111111111111111110000001101111000001110000001111100000001111101101000]")), 0.0001);
		assertEquals(74.513, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101100111111111111000000111110111111111111111111111111110000111011010011011111111111111011111111111100110000001111000110000111110111111111111111110000001111111000000000001101100000001101111101101000]")), 0.0001);
		assertEquals(75, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111111111010011111111111111111111111111111111100010111011011011011111111111111001111111111100110000101001110000000111111111111111111111111101101101111000000001100000001101101100000001111000]")), 0.0001);
		assertEquals(75.1623, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101100110111111111000000111111111111111111111111111111101011111110011011011111111111111001111101111110110001001001111000000111111111111111111111110000000001111000001100001101101110001100000001101100]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000111111111101000111110111111111111111111111111100000111011000111011111111111110011111111111110110001001000111000110111111111111111111111110000001101111000001110000001111100001100001101101000]")), 0.0001);
		assertEquals(75.3247, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111010011111110011111111111111111111111101111111010000011111111111111111101111111111110110000001001001110000111111111111111111111110000001101111000000001110001101100001101111101111100]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000000111111111110111110111111111111111111111111101111111010110111011111111111111011111110111110110000101111001000000111111111111111111111011110000001111000000001100001101101101111100001100000]")), 0.0001);
		assertEquals(75, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111101111111111000000111110111111111111111111101111100011111010001011011111111111111101111111111110110000001001001110000111111111111111111111110000000001111000000001101101011100001101110001101000]")), 0.0001);
		assertEquals(75.1623, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111111111000000111111111111111111111111111111111000111110010111111111111111110101111111111110110000101110001000110111111111111111111111111100001111111000000001100000001101101101100001101000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000111111111000000111111111111111111111111111111111100111111000011011111111111110101111111111110010000001001101110000111111111111111111111110000000001111000000001101101100001110001101111101100]")), 0.0001);
		assertEquals(75.3247, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111110111111111000000111111111111111111111111111111101000111111000011111111111111110001111111111110110000101001000000000111111111111111111111110001101101111000000000000001101101101100001101101000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101000000111111111010011111110111111111111111111111111100111111011011111011111111111110101111111111110110000101001001110000111111111111111111111110100000001111000000001110001110000001101110001111000]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[00101111110111111111000000111110111111111111111111111111110100111011001111011111111111110011111110111110110001001101001110000111111111111111111111110001101101111000000000001110001100001100001101101000]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[10100000000111111111010010111110011111111111111111111111101000111011101011111111111111110111111111111010110000101001111111000111111111111111111111110001110001111000001100001100001111101101100001101000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101111111111111000000111110111111111111111111111111100000111011001111011111111111110110011111111110110000001000001000000111111111111111111111110001101111111000001111100000000000001111101101110000]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101011111111111111000000111110011111111111111111111111110011111011000111111111111111111100011111111010110001101001001111000111111111111111111111111100001101110000001101100000000001100001101101101000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000111111111000000111110111111111111111111111111100011111010010011011111111111110001111111111110110000101001111110000111111111111111111111110000001101111000001110001110000001111101101000100000]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111011101111111111000000111110011111111111111111111111101111111011000111011111111111110110011111111110110000101001000110000111111111111111111111111010000001111000001100000001101111111100000001111100]")), 0.0001);
		assertEquals(75, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000111111111000000111110111111111111111111111111101100111011101111011111111111111101111111111110110000101111001000000111111111111111111111110000001101111000001100001110000001101111110001111100]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101111000111111000000111110111111111111111111111111110100111011000111011111111111110011111111111110110001001001110110000111111111111111111111110000000001111000001100001111110001100001110001111000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110101101111111111000000111110111111111111111111111111110001111010000111111111111111111001111111111110110000001110001000000111111111111111111111110001110001111000001110001100001110000000001111101100]")), 0.0001);
		assertEquals(74.6753, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101111000111111000000111110111111111111111111111111100100111010100011111111111111111011111110111110110001101111001000110111111111111111111111111100000001111000001111110000001100000000001101111000]")), 0.0001);
		assertEquals(74.3506, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111011111000111111000000111110111111111111111111111111100011111011001011011111111111110000011111111110110000001101001110100111111111111111111111110000001111111000000001100000001111111100001101100000]")), 0.0001);
		assertEquals(74.513, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111101000101111000000111110011111111111111111111111100011111010000011011111111111110111111111111110110000001111111111000111111111111111111111110001100001111000001110001100001110001101000001101000]")), 0.0001);
		assertEquals(75.3247, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111111111000000111111111111111111111111111111101100111110011011011111111111111001111111111110110000101001111000000111111111111111111111111111100001111000001101100001100000001110001101111100]")), 0.0001);
		assertEquals(75.1623, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111111111111101111110111111111111111111111111111100111011100111011111111111110111111111111110110001001001001110000111111111111111111111100001100001111000000001101101100001111100000001111000]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111000111111000000111111111111111111111111111111110100111010011011111111111111110001111111111100110000101001001000000111111111111111111111111110000001111000001001101101100000000001101101101100]")), 0.0001);
		assertEquals(75.1623, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100000000111111111101000111111111111111111111111111111100000111110110111111111111111110001111111111110110000001001111000000111111111111111111111111100001101111000001101001111100000000001110001101100]")), 0.0001);
		assertEquals(74.8377, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111110110111111111000000111110111111111111111111111111101011111011100011111111111111110001111110111000110000001001001000000111111111111111111111111101101101111000000001100001100000000001111101101000]")), 0.0001);
		assertEquals(74.513, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101110000111111010011111110111111111111111111111111110000111010000111011111111111110100011111111110100000001001001000000111111111111111111111110001111111111000001101110000001111101100000001111000]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores70p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[01110000110111111111111111111110111111111111111111111111111011111010011011011111111111110101111111111010110001001111111110000111111111111111111111111101100001111000001100000001101101101101101101101000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111000000111111111111111111111111111111101100111010100011011111111111110011111111111110110000101111111111000111111111111111111111110001101101110000001101101101101110001100001101101100]")), 0.0001);
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111011111111111000000111110111111111111111111111101100111111010000111111111111111110101111111111110110011101111111110110111111111111111111111110001101101111000000000001101110001111101111101101000]")), 0.0001);
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101110101111111111010011111110111111111111111111111111110011111010001111111111111111110001111111111110110001101111111000000111111111111111111111111110001101111011001110001101100000001111101111101000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101010000111111111010011111110111111111111111111111111100011111010001111111111111111111001111111111010110000101111111110110111111111111111111111111101101101111000000000001101111101101101110001101100]")), 0.0001);
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110110111111111111000000111111111111111111111111111111100100111111000011011111111111110011111111111110110000001111111000110111111111111111111111111101101111111000000001111101101100001111110001111000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111110111111111000000111111111111111111111111111111110100111111100111011111111111111101111101111110110000101001001111110111111111111111111111111101111101111000001100001101111110000001101101101000]")), 0.0001);
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[11100110111000111111111111111110111111111111111111111111101111111011101011011111111111110001111111111110110001101001001110110111111111111111111111110000001101111000001111101110001101101111101101100000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111110111011111000000111111111111111111111111111111100011111110111011011111111111110001111111111110110000101111111000111111111111111111111111111101101101111000001101100001110001100001101101101000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111000000111111111111111111111111111111100111111011010011011111111111111101111111111100110000001101111110000111111111111111111111111101101101111000001101100000001111101100001111101100]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111101000111111111111111111111111111111110000111011001011011111111111110001111111111110110000101111111110000111111111111111111111111111101111111000000001101101100000001100001101111100]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111111111111111000000111111111111111111111111111111101011111110101111011111111111110000011111111110110001001000111110000111111111111111111111111111101101111000000001101101101111101100001101101100]")), 0.0001);
		assertEquals(81.9805, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101101111111111111000000111111111111111111111111111111100011111110100011011111111111111011111111111110110100001111111110110111111111111111111111111100001111111000000001101110000001111101100001101100]")), 0.0001);
		assertEquals(81.9805, calculator.calculateSatisfactionPercentile(calculator.fromString("[10110111111111111111010011111111111111111111111111111111101011111111001011111111111111110001111111111110110001001111001110000111111111111111111111110001111101111000001101101101000001110001100001111100]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111000000111111111111111111111111111111100111111010001011111111111111110001111111111110110000001111111000111111111111111111111111111101100001111000001110001010000001111111111101101000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11110111110000111111010010111111111111111111111111111111100111111110000111011111111111110001111111111110110001101111111000000111111111111111111111111101100001111000001111110001101101110001111101101100]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111100000111111111111111111111111111111101111111010100111011111111111111101111111111110110000101001111000111111111111111111111111110000001101111000001001111101101110001110001111101000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111011111000000111111111111111111111111111111111011111010010011011111111111111101111111111110110000001000001110000111111111111111111111111111101111111000000001101111101101101101100001111000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111000000111111111111111111111111111111110000111110000111011111111111110011111111111110110000101110110000110111111111111111111111111111101111111000001101100001101101100001101101100000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011111111111111000000111111111111111111111111111111100111111011010111011111111111111001111111111110110000101111001000111111111111111111111111111100001101111000001101101101100000001101101111111100]")), 0.0001);
		assertEquals(81.1688, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111011111000000111110111111111111111111111111100101111010101111111111111111110100011111111110110000101111001110101111111111111111111111110001110001111000001101111101101100001101111111101000]")), 0.0001);
		assertEquals(82.1429, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111010011111110111111111111111111111111100111111011000011111111111111111001111111111110110000101001000111000111111111111111111111110001101101111000001101101110001101101101101101111000]")), 0.0001);
		assertEquals(81.4935, calculator.calculateSatisfactionPercentile(calculator.fromString("[10101111011111111111111101111111111111111111111111111111100000111011011011111111111111111101111111111110110000100001111111000111111111111111111111110000001101111000001101101101111101100001100001111100]")), 0.0001);
		assertEquals(81.9805, calculator.calculateSatisfactionPercentile(calculator.fromString("[10111111111111111111000000111110111111111111111111111111101111111011101011111111111111110001111111111110110000101111111000000111111111111111111111110001101111111000001101100001111111100001101111101100]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111101111111110010011111111111111111111111111111111101011111110000111011111111111110011111111111010110001001001111110000111111111111111111111111110001101111000001111100001110001111100001111101000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101101111111111111010010111110111111111111111111111111100011111010001011011111111111110101111111111110110001001111001000111111111111111111111111111110001111111000000001111101101101111101000001111000]")), 0.0001);
		assertEquals(81.3312, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101110111000111111010011111110111111111111111111111111100111111010001011111111111111110011111111111110110001001001111110110111111111111111111111110001101111111000000000001101111111001101111101101000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101011110111111111010011111111111111111111111111111111100011111011101111011111111111110011111111111110110000001001001110111111111111111111111111111101100001111000001111101110001111101100000001111000]")), 0.0001);
		assertEquals(81.6558, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111101111111111000000111110111111111111111111111111110000111010000111011111111111110001111111111110110001001001111111111111111111111111111111110001101101111000001101111110001111100001101101111000]")), 0.0001);
		assertEquals(81.8182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111110111111111111111111111111110111111010010111011111111111110001111110111010110000001001001000110111111111111111111111111101111101111000000001101101101110001111101101100000]")), 0.0001);
	}

	@Test
	public void testBolsaValores80p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101101111111111111111111111111111111111111111111111111111011111110100011011111111111110001111111111110110100101111111110111111111111111111111111111100001111111000000001101111101111111101111101101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111101011111010001011011111111111110111111111111110110000001111111100111111111111111111111111111101111101111000001110001111101101111111111111101000]")), 0.0001);
		assertEquals(88.7987, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111110000111111111111111110011111111111110110110001110111111110111111111111111111111111100001111111000001101101111100001101111101101101000]")), 0.0001);
		assertEquals(88.1494, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111110111111111111111111111111101011111010110111011111111111110011111101111111111000101111111110110111111111111111111111110001111111111000001101111101101111111101101101101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111010001111111111111111111111111111111110011111111001111011111111111110011111111111110110001001111111000111111111111111111111111111111111101111000001100001111111101111111111111111000]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111100111111111000111011111111111110001111111111110110000001111110110110111111111111111111111111101111101111000001101101101101111101111101111101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111111100111111111111111111111111111111100011111110000011011111111111110001111111111110110001101111000110110111111111111111111111111101101101111000001101111111111111111101111101101100]")), 0.0001);
		assertEquals(88.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111110111111111111111111110111111111111111111111111100111111011000011011111111111111101111111111110110000101111110110111111111111111111111111111101111111111000001101101111101101110001111101101100]")), 0.0001);
		assertEquals(88.961, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110011111111100111111111111111110001111111111110110001001001001000000111111111111111111111111111111111111000001111101101101111111111111101111100]")), 0.0001);
		assertEquals(88.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111000111111111111111111111111111111111111111111100011111110010111011111111111110111111111111110110100001111111110111111111111111111111111111100001111111000001101111101110001101101111111111100]")), 0.0001);
		assertEquals(88.7987, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111100111111110011111011111111111111011111111111110110001101111001110110111111111111111111111111101101101111000001101101111101111111101101111101000]")), 0.0001);
		assertEquals(88.7987, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111111111111111111111111111111111111111101011111111000011011111111111110101111111111110110101001111111111111111111111111111111111111110000001111000000001111101101111101111101111101100]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111110111110111111111111111111111111110011111011100011011111111111110001111111111110110111101111111110110111111111111111111111111111101101111000001111100001101100001111111101111100]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111110011111111111111110111111111111111111111111111111100011111110111111011111111111111001111111111110110001001111111110111111111111111111111111111100001111111000001100001111111101111101101111101100]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[01111111111111111111111111111110111111111111111111111111110111111010100011011111111111110001111111111110110000001111111000110111111111111111111111111111111111111000001101101111101101101111111101101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101111111111111111111111111111111111111111111111111111011111110000011011111111111110001111111111110110000101110110110100111111111111111111111111101111101111000001101111110001101101111111101111000]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111110111111111111111111110111111111111111111111111101011111010001011011111111111110101111111111110110001001111110111000111111111111111111111111111101111111000001111111111101101101101101111101000]")), 0.0001);
		assertEquals(88.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111000111111111111111111111111111111111111111111101111111111110111011111111111110101111111111110110000101111111110110111111111111111111111101101101101111000001101101101101111101101101111101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111100011111110000011011111111111110001111111111110110101001111110110110111111111111111111111111101101101111000001101111101101110001111101101111011]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111110111111111111111111111111101011111011100111111111111111110101111111111110110000001111111100110111111111111111111111111101111101111000001101111101101111101111101111101100]")), 0.0001);
		assertEquals(88.961, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100111111110010111111111111111110001111111111110110001101111110110000111111111111111111111110001101101111000001101111111101111101111101101101100]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111101111111111111111111110111111111111111111111111101111111011100011011111111111111001111110111110110110001111111110110111111111111111111111110001101101111000001111101111111101101101111101101000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111101111111111111010011111111111111111111111111111111100111111111001011011111111111111101111111111110110100001111110111111111111111111111111111110001101101111000001101101111101101111101101111101100]")), 0.0001);
		assertEquals(88.3117, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111011111111111111111111111110111111111111111111111111101011111010001111011111111111110001111111111110110001001111111100110111111111111111111111111101111101111000001101101111111101111101110001101010]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111110111111111110111111111111111111111111111111111101111111110100011011111111111111101111111111110110000001111111110000111111111111111111111111101101101111000001111101101101101111110001111101111]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11101111111111111111010011111111111111111111111111111111100011111110000011011111111111111111111111111110110000101111111000110111111111111111111111111101111101111000001111111101111111111101111101101000]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111110111111110000011111111111111111011111111111110110101001111111100110111111111111111111111111101101111111000001111101101110001101101111101101100]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111000000111111111111111111111111111111111011111111001011011111111111110011111111111110110111001111111110110111111111111111111111111101111111111000001111101101101001101111101101111000]")), 0.0001);
		assertEquals(88.474, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111011111111111111111111111110111111111111111111111111100011111010000011111111111111111011111111111110110001001101111110110111111111111111111111111101111111111000001101101101101101101101111111101000]")), 0.0001);
		assertEquals(88.6364, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111110111111111111111111111111100011111011011011011111111111110001111111111110110010101111111110111111111111111111111111111111101101111000001101111101101101101101101101111100]")), 0.0001);
	}
	
	@Test
	public void testBolsaValores90p() throws Exception
	{
		SoftwareSystem system = new FunctionsPointReader().execute(MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/functions-point.xml", MainProgram.INSTANCE_DIRECTORY + "BolsaDeValores/stakeholders-interest.xml");
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111101011111111001111011111111111110101111111111110110101101111111111110111111111111111111111111111111111111101001101101111111111111111111111111100]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111111010011011111111111111101111111111110110101101111111111110111111111111111111111111111101111111000001111111101111111111111111111111110]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111110111111011111111111110111111111111110110110001111111110110111111111111111111111111111111111111000001111111111111111111111101101111011]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100111111110111011111111111111111001111111111110110111101111111111110111111111111111111111111111111111111000001111111101101111111111101111111011]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111110101111111111111111111001111111111110110000101111111110111111111111111111111111111111101111111000001111111101111111111111111111111111]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110111111111110111111111111111111101111111111111111011001111111111111111111111111111111111111110001111111000001111101111111111111101101111111110]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110111111111111111011111111111111011111111111110110001101111111110110111111111111111111111111101111111111101001111111111111111111111101111111100]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111110111011011111111111110001111111111110110110101111111111111111111111111111111111111111101111111111001111111111111101101111111101111100]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111110011111011111111111111011111111111110110010101111111110111111111111111111111111111111111111111000001111111101101111111111111111101111]")), 0.0001);
		assertEquals(94.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110111111110111011011111111111110011111111111110110110101111111110111111111111111111111111111101111111111001111111101111111101111101101111111100]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111101011111110001111011111111111110111111111111111111101001111111110111111111111111111111111111111111111111000001101111111111101101111101111111110]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111101011111111011111011111111111111001111111111111111101101111111110111111111111111111111111111111111111111000000001111111111111101111111101111111]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111111111110111011111111111111110001111111111111111010101111111111110111111111111111111111111111111101111000001111111101101111111111111111111100]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110111111111100111111111111111111101111111111110110111101111111111111111111111111111111111111111101101111000001101111111111101111101111111111011]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111101111111111101011111111111111111111111111111110110101001111111111111111111111111111111111111111101111111000001101101111111101111111111101111111]")), 0.0001);
		assertEquals(94.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111110011111111111111111111011111111111111111010001111111111110111111111111111111111111111111101111001001111101111101101111111111111111100]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111110101011111111111111110111111111111111111100101111111110111111111111111111111111111101101111111000001101111111101101111101111111111111]")), 0.0001);
		assertEquals(95.1299, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110011111110011111011111111111110111111111111110110011101111111110111111111111111111111111111111111111111000001111111111111111111111111111111100]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111110101111011111111111110011111111111110110111101111111110111111111111111111111111111111111111111000001111111101101111111101111111111111]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110011111110001011111111111111111001111111111111111011101111111110111111111111111111111111111101111111111000001111101101111111111111101101111111]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110111111110010011011111111111111011111111111110110111001111111110111111111111111111111111111111101111111000001101111111111111111111111111101111]")), 0.0001);
		assertEquals(94.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111011111111000111011111111111111011111111111110110101001111111111111111111111111111111111111101111101111011001101111101111111101111111111111110]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111110101011111111111111111011111111111110110110101111111110111111111111111111111111111111101101111000001111111111111111111101111111111111]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111111111110100011111111111111111111111111111110110011101111111111110111111111111111111111111111101111111111001111101111111101111101111111111100]")), 0.0001);
		assertEquals(94.9675, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111111111111111011011111111111111110001111111111110110111001111111111111111111111111111111111111111101111111000001111101101111111101111101111111111]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111101011111110001011111111111111110011111111111111111100001111111111111111111111111111111111111111111101111000001101111111111101101111111101111111]")), 0.0001);
		assertEquals(94.8052, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111111100011011111111111110101111111111111110100101111111111110111111111111111111111111111101111111000001111111101111111101111111111111111]")), 0.0001);
		assertEquals(94.3182, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111100011111110010111111111111111111101111111111110110101101111111111110111111111111111111111111101101111111101111110001101111111111111101111111111]")), 0.0001);
		assertEquals(94.4805, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111010011111111111111111111111111111111101111111111100011111111111111111001111111111111111111001111111111111111111111111111111111111111101111111011001101111111101111111111111111111100]")), 0.0001);
		assertEquals(94.6429, calculator.calculateSatisfactionPercentile(calculator.fromString("[11111111111111111111111111111111111111111111111111111111110011111111000111111111111111111101111111111110110011101111111111110111111111111111111111111101101101111111001111111111101111101111101111111111]")), 0.0001);
	}
}