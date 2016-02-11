package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.uniriotec.vitor.padilha.dissertacao.calc.ClassicFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.reader.FunctionsPointReader;

public class TestFunctionPointCalculator
{
	private static SoftwareSystem system = null;
	private static FunctionPointsCalculator calculador = null;
	
	@BeforeClass
	public static void setup() throws Exception
	{
		system = new FunctionsPointReader().execute("data/instancias/Academico/functions-point.xml", "data/instancias/Academico/stakeholders-interest.xml");
		calculador = new ClassicFunctionPointsCalculator(system);
	}
	
	@Test
	public void testLoadingDataModel() throws Exception
	{
		assertEquals(7, system.getDataModel().countDataFunctions());
		
		DataFunction df0 = system.getDataModel().getDataFunctionIndex(0);
		assertEquals("Aluno", df0.getName());
		assertEquals(5, df0.countRecordTypes());
		
		RecordType rt00 = df0.getRecordTypeIndex(0);
		assertEquals("Aluno", rt00.getName());
		assertEquals(29, rt00.countDataElements());
		checkBasicField(rt00, 0, "nome");
		checkPrimaryKeyField(rt00, 1, "idAluno");
		checkBasicField(rt00, 2, "dre");
		checkBasicField(rt00, 28, "grau");
		
		RecordType rt01 = df0.getRecordTypeIndex(1);
		assertEquals("AlunoDoutorado", rt01.getName());
		assertEquals(3, rt01.countDataElements());
		checkPrimaryKeyField(rt01, 0, "idAlunoDoutorado");
		checkReferenceField(rt01, 1, "idAluno", "Aluno", false);
		checkBasicField(rt01, 2, "qualificacao");
		
		RecordType rt02 = df0.getRecordTypeIndex(2);
		assertEquals("Morto", rt02.getName());
		assertEquals(4, rt02.countDataElements());
		checkPrimaryKeyField(rt02, 0, "idAlunoMorto");
		checkReferenceField(rt02, 1, "idAluno", "Aluno", false);
		checkBasicField(rt02, 2, "motivo");
		checkBasicField(rt02, 3, "data");
		
		RecordType rt03 = df0.getRecordTypeIndex(3);
		assertEquals("Bolsista", rt03.getName());
		assertEquals(5, rt03.countDataElements());
		checkPrimaryKeyField(rt03, 0, "idBolsista");
		checkReferenceField(rt03, 1, "idAluno", "Aluno", false);
		checkBasicField(rt03, 2, "iniciobolsa");
		checkBasicField(rt03, 3, "terminobolsa");
		checkBasicField(rt03, 4, "instituicao_bolsa");
		
		RecordType rt04 = df0.getRecordTypeIndex(4);
		assertEquals("Trancamento", rt04.getName());
		assertEquals(5, rt04.countDataElements());
		checkPrimaryKeyField(rt04, 0, "idTrancamento");
		checkReferenceField(rt04, 1, "idAluno", "Aluno", false);
		checkBasicField(rt04, 2, "data_fim_trancamento");
		checkBasicField(rt04, 3, "data_inicio_trancamento");
		checkBasicField(rt04, 4, "motivo_trancamento");
		
		DataFunction df1 = system.getDataModel().getDataFunctionIndex(1);
		assertEquals("Professor", df1.getName());
		assertEquals(1, df1.countRecordTypes());
		
		DataFunction df2 = system.getDataModel().getDataFunctionIndex(2);
		assertEquals("Area", df2.getName());
		assertEquals(2, df2.countRecordTypes());
		
		DataFunction df3 = system.getDataModel().getDataFunctionIndex(3);
		assertEquals("Usuario", df3.getName());
		assertEquals(1, df3.countRecordTypes());
		
		DataFunction df4 = system.getDataModel().getDataFunctionIndex(4);
		assertEquals("Disciplina", df4.getName());
		assertEquals(3, df4.countRecordTypes());
		
		RecordType rt41 = df4.getRecordTypeIndex(0);
		assertEquals("Disciplina", rt41.getName());
		assertEquals(10, rt41.countDataElements());
		checkPrimaryKeyField(rt41, 0, "idDisciplina");
		checkBasicField(rt41, 1, "codigo");
		checkBasicField(rt41, 2, "nome");
		checkBasicField(rt41, 3, "tipo");
		checkBasicField(rt41, 9, "externa");
		
		RecordType rt42 = df4.getRecordTypeIndex(1);
		assertEquals("PreRequisitos", rt42.getName());
		assertEquals(2, rt42.countDataElements());
		checkReferenceField(rt42, 0, "idDisciplinaPreRequisito", "Disciplina", true);
		checkReferenceField(rt42, 1, "idDisciplina", "Disciplina", false);
		
		DataFunction df5 = system.getDataModel().getDataFunctionIndex(5);
		assertEquals("Turma", df5.getName());
		assertEquals(1, df5.countRecordTypes());
		
		DataFunction df6 = system.getDataModel().getDataFunctionIndex(6);
		assertEquals("Inscricao", df6.getName());
		assertEquals(1, df6.countRecordTypes());
	}

	@Test
	public void testLoadingTransactionModel() throws Exception
	{
		assertEquals(39, system.getTransactionModel().countTransactionFunctions());
	}
	
	@Test
	public void testExpansionTransaction00() throws Exception
	{
		boolean[] selected = selectTransactions(0);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(1, calculador.countTransactions(selected));
		assertTrue(selected[0]);
	}
	
	@Test
	public void testExpansionTransaction02() throws Exception
	{
		boolean[] selected = selectTransactions(2);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(2, calculador.countTransactions(selected));
		assertTrue(selected[0]);
		assertTrue(selected[2]);
	}
	
	@Test
	public void testExpansionTransaction10() throws Exception
	{
		boolean[] selected = selectTransactions(10);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(5, calculador.countTransactions(selected));
		assertTrue(selected[0]);
		assertTrue(selected[2]);
		assertTrue(selected[7]);
		assertTrue(selected[9]);
		assertTrue(selected[10]);
	}
	
	@Test
	public void testExpansionTransaction00And10() throws Exception
	{
		boolean[] selected = selectTransactions(0, 10);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(5, calculador.countTransactions(selected));
		assertTrue(selected[0]);
		assertTrue(selected[2]);
		assertTrue(selected[7]);
		assertTrue(selected[9]);
		assertTrue(selected[10]);
	}
	
	@Test
	public void testExpansionTransaction02And10() throws Exception
	{
		boolean[] selected = selectTransactions(2, 10);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(5, calculador.countTransactions(selected));
		assertTrue(selected[0]);
		assertTrue(selected[2]);
		assertTrue(selected[7]);
		assertTrue(selected[9]);
		assertTrue(selected[10]);
	}
	
	@Test
	public void testExpansionTransactionAllBut00And02() throws Exception
	{
		boolean[] selected = calculador.allTransactions();
		selected = calculador.removeTransactions(selected, 0);
		selected = calculador.removeTransactions(selected, 2);
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(39, calculador.countTransactions(selected));
	}
	
	@Test
	public void testExpansionSubsetTransactions() throws Exception
	{
		boolean[] selected = selectTransactions("[011101101010111110101110111011111011111]");
		selected = calculador.expandSelectionDueDependencies(selected);
		assertEquals(39, calculador.countTransactions(selected));
	}
	
	@Test
	public void testSatisfactionTransaction00() throws Exception
	{
		assertEquals(200, calculador.calculateSatisfaction(selectTransactions(0)));
	}
	
	@Test
	public void testSatisfactionTransaction02() throws Exception
	{
		assertEquals(425, calculador.calculateSatisfaction(selectTransactions(2)));
	}
	
	@Test
	public void testSatisfactionTransaction10() throws Exception
	{
		assertEquals(975, calculador.calculateSatisfaction(selectTransactions(10)));
	}
	
	@Test
	public void testSatisfactionTransaction27And28() throws Exception
	{
		boolean[] selected = selectTransactions(new int[] {27, 28});
		assertEquals(550, calculador.calculateSatisfaction(selected));
		assertEquals(0.104265, calculador.calculateSatisfaction(selected) / 5275.0, 0.001);
	}
	
	@Test
	public void testSatisfactionAllTransactions() throws Exception
	{
		boolean[] selected = calculador.allTransactions();
		assertEquals(5275, calculador.calculateSatisfaction(selected));
	}
	
	@Test
	public void testCostAllTransactions() throws Exception
	{
		assertEquals(190, calculador.calculateCost(calculador.allTransactions()));
		assertEquals(14, calculador.calculateCost(selectTransactions(0)));
		assertEquals(22, calculador.calculateCost(selectTransactions(1)));
		assertEquals(18, calculador.calculateCost(selectTransactions(2)));
		assertEquals(21, calculador.calculateCost(selectTransactions(3)));
		assertEquals(21, calculador.calculateCost(selectTransactions(4)));
		assertEquals(24, calculador.calculateCost(selectTransactions(5)));
		assertEquals(24, calculador.calculateCost(selectTransactions(6)));
		assertEquals(21, calculador.calculateCost(selectTransactions(7)));
		assertEquals(27, calculador.calculateCost(selectTransactions(8)));
		assertEquals(24, calculador.calculateCost(selectTransactions(9)));
		assertEquals(27, calculador.calculateCost(selectTransactions(10)));
	}
	
	private void checkBasicField(RecordType rt, int index, String name)
	{
		assertEquals(false, rt.getDataElementIndex(index).isPrimaryKey());
		assertEquals(name, rt.getDataElementIndex(index).getName());
		assertEquals(false, rt.getDataElementIndex(index).isSemanticMeaning());
	}
	
	private void checkPrimaryKeyField(RecordType rt, int index, String name)
	{
		assertEquals(true, rt.getDataElementIndex(index).isPrimaryKey());
		assertEquals(name, rt.getDataElementIndex(index).getName());
		assertEquals(false, rt.getDataElementIndex(index).isSemanticMeaning());
	}
	
	private void checkReferenceField(RecordType rt, int index, String name, String referencedName, boolean semanticMeaning)
	{
		assertEquals(false, rt.getDataElementIndex(index).isPrimaryKey());
		assertEquals(name, rt.getDataElementIndex(index).getName());
		assertEquals(referencedName, rt.getDataElementIndex(index).getReferencedRecordType().getName());
		assertEquals(semanticMeaning, rt.getDataElementIndex(index).isSemanticMeaning());
	}
	
	private boolean[] selectTransactions(int... transactions)
	{
		boolean[] result = calculador.noTransactions();
		
		for (int i = 0; i < transactions.length; i++)
			result[transactions[i]] = true;
		
		return result;
	}
	
	public double calculateSatisfactionPercentile(int... transactions) throws Exception
	{
		boolean[] selected = selectTransactions(transactions);
		int satisfaction = calculador.calculateSatisfaction(selected);
		int totalSatisfaction = calculador.getTotalSatisfaction();
		return (100.0 * satisfaction) / totalSatisfaction;
	}
	
	public double calculateSatisfactionPercentile(String transactions) throws Exception
	{
		boolean[] selected = selectTransactions(transactions);		
		int satisfaction = calculador.calculateSatisfaction(selected);
		int totalSatisfaction = calculador.getTotalSatisfaction();
		return (100.0 * satisfaction) / totalSatisfaction;
	}

	private boolean[] selectTransactions(String transactions)
	{
		boolean[] selected = calculador.noTransactions();
		
		for (int i = 1; i < transactions.length()-1; i++)
			if (transactions.charAt(i) == '1')
				selected[i-1] = true;
		
		return selected;
	}
}