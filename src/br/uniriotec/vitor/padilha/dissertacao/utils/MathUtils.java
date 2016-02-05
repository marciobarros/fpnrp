package br.uniriotec.vitor.padilha.dissertacao.utils;

/**
 * Utility class for basic math operations
 * 
 * @author marciobarros
 */
public class MathUtils
{
	/**
	 * Calculates the mean from a set of data points
	 */
	public static double mean(double[] data)
	{
		double sum = 0;
		
		for (double d : data)
			sum += d;
		
		return (data.length > 0) ? sum / data.length : 0.0;
	}
}