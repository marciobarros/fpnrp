package br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model.MonoExperimentCycle;
import br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model.MonoExperimentInstance;
import br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model.MonoExperimentResult;

/**
 * Class that loads the results of a mono-objective experiment
 * 
 * @author Marcio Barros
 */
public class MonoExperimentFileReader
{
	private int currentLineNumber;

	/**
	 * Loads the results from a file
	 */
	public MonoExperimentResult execute(String filename) throws Exception
	{
		try
		{
			return execute(extractFileName(filename), new FileInputStream(filename));
		}
		catch(IOException e)
		{
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Loads the results from a strem
	 */
	public MonoExperimentResult execute (String name, InputStream stream) throws Exception
	{
		currentLineNumber = 0;
		Scanner scanner = new Scanner(stream);
		
		try
		{
			MonoExperimentResult result = new MonoExperimentResult(name);
			
			while (scanner.hasNextLine())
				readInstance(result, scanner);

			return result;
		}
		finally
		{
			scanner.close();
		}
	}

	/**
	 * Reads an instance of the experiment
	 */
	private void readInstance(MonoExperimentResult result, Scanner scanner) throws Exception
	{
		MonoExperimentInstance instance = new MonoExperimentInstance();
		
		if (!readInstanceHeader(instance, scanner))
			return;
		
		int cycleNumber = 0;
		
		while(readCycle (instance, cycleNumber, scanner))
			cycleNumber++;

		result.addInstance(instance);
	}
	
	/**
	 * Reads the header of an instance
	 */
	private boolean readInstanceHeader(MonoExperimentInstance instance, Scanner scanner) throws Exception
	{
		String firstHeaderLine = readLine(scanner);
		
		if (firstHeaderLine == null)
			return false;
		
		if (firstHeaderLine.compareTo("=============================================================") != 0)
			throwException("expected header start");

		String secondHeaderLine = readLine(scanner);
		
		if (secondHeaderLine == null)
			throwException("expected header instance count");
		
		String headerStart = "Instance #";
		
		if (!secondHeaderLine.startsWith(headerStart))
			throwException("expected header instance count");

		String thirdHeaderLine = readLine(scanner);
		
		if (thirdHeaderLine == null)
			throwException("expected header instance count");
		
		if (thirdHeaderLine.compareTo("=============================================================") != 0)
			throwException("expected header finish");

		return true;
	}
	
	/**
	 * Reads a cycle for an instance
	 */
	private boolean readCycle(MonoExperimentInstance instance, int cycleNumber, Scanner scanner) throws Exception
	{
		// Loads a string from the file
		String line = readLine(scanner);
		
		if (line == null)
			return false;
		
		// Checks whether has found the end of the cycles
		line = line.trim();
		
		if (line.length() == 0)
			return false;
		
		// Breaks the string in tokens
		String[] tokens = line.split(";");
		
		if (tokens.length < 5)
			throwException("expected at least five tokens in the string");
		
		// Checks cycle header
		String cycleHeader = "Cycle #" + cycleNumber;
		
		if (tokens[0].trim().compareTo(cycleHeader) != 0)
			throwException("expected 'Cycle #" + cycleNumber + "'");
		
		// Gets execution time in miliseconds
		int executionTime = parseInteger(tokens[1].trim());
		
		// Gets the solution
		String lastToken = tokens[tokens.length-1].trim();
		
		if (!lastToken.endsWith("]"))
			throwException("expected ']' by the end of the line");

		if (!lastToken.startsWith("["))
			throwException("expected '[' at solution start");
		
		String solution = lastToken.substring(1, lastToken.length()-1);
		
		// Gets the location
		String locationToken = tokens[tokens.length-2].trim();
		int location = parseInteger(locationToken.trim());
		
		// Gets the objective
		String objectiveToken = tokens[tokens.length-3].trim();
		double objective = parseDouble(objectiveToken.trim());

		// Gets the aditional data count
		int additionalDataCount = tokens.length - 5;
		
		// Creates the cycle
		MonoExperimentCycle cycle = new MonoExperimentCycle(additionalDataCount);
		cycle.setExecutionTime(executionTime);
		cycle.setObjective(objective);
		cycle.setLocation(location);
		cycle.setSolution(solution);
		
		// Collects aditional data
		for (int i = 0; i < additionalDataCount; i++)
		{
			String dataToken = tokens[i + 2].trim();
			double data = parseDouble(dataToken);
			cycle.setAdditionalData(i, data);
		}
		
		// Adds the cycle to the instance
		instance.addCycle(cycle);
		return true;
	}
	
	/**
	 * Returns the name of a file, given its full path
	 */
	private String extractFileName (String path)
	{
		int barPosition = path.lastIndexOf('\\');
		
		if (barPosition >= 0)
			path = path.substring(barPosition + 1);
		
		int pointPosition = path.lastIndexOf('.');
		
		if (pointPosition >= 0)
			path = path.substring(0, pointPosition);
		
		return path;
	}

	/**
	 * Loads a line from a file
	 */
	private String readLine (Scanner scanner)
	{
		String result = scanner.nextLine();
		currentLineNumber++;
		return result;
	}

	/**
	 * Converts a string to its integer value
	 */
	private int parseInteger (String s) throws Exception
	{
		try
		{
			return Integer.parseInt(s.trim());
		}
		catch(Exception e)
		{
			throwException ("invalid integer value");
		}
		
		return 0;
	}

	/**
	 * Converts a string to its numeric value
	 */
	private double parseDouble (String s) throws Exception
	{
		try
		{
			s = s.replace(',', '.');
			return Double.parseDouble(s.trim());
		}
		catch(Exception e)
		{
			throwException ("invalid double value");
		}
		
		return 0;
	}

	/**
	 * Throws an exception showing the erroneous line number
	 */
	private void throwException(String message) throws Exception
	{
		throw new Exception("Line " + currentLineNumber + ":" + message);
	}
}