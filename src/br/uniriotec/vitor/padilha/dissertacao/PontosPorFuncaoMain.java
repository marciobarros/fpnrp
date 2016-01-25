package br.uniriotec.vitor.padilha.dissertacao;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.uniriotec.vitor.padilha.dissertacao.calculator.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.jaxb.MyValidationEventHandler;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests.StakeholderInterests;

public class PontosPorFuncaoMain
{
	/**
	 * @param args
	 * @throws JAXBException
	 */
	public static void main(String[] args) throws JAXBException, IOException
	{
		JAXBContext context = JAXBContext.newInstance(FunctionPointSystem.class);
		JAXBContext contextInterests = JAXBContext.newInstance(StakeholderInterests.class);

		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Unmarshaller um = context.createUnmarshaller();
		um.setEventHandler(new MyValidationEventHandler());
		Unmarshaller um2 = contextInterests.createUnmarshaller();
		um2.setEventHandler(new MyValidationEventHandler());

		Object obj = um.unmarshal(new File("D:/Google Drive/Mestrado/Estudo Dirigido/Instancias/InstanciaDoMarcio/functions-point.xml"));

		FunctionPointSystem functionPointSystem = (FunctionPointSystem) obj;
		// IFunctionPointView functionPointView = new WebFunctionPointView(0,
		// functionPointSystem);
		// Set<IFunctionPointView> views = new HashSet<IFunctionPointView>();
		// views.add(functionPointView);

		FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator();

		try
		{
			functionPointSystem.charge();
			if (functionPointSystem.validate())
			{
				// List<Transaction> transactions= new
				// ArrayList<Transaction>(functionPointSystem.getTransactionModel().getTransactions());
				// Transaction[] transactionsInArray = (Transaction[])
				// transactions.toArray();
				// for(Transaction transaction:transactions){
				// if(transaction.getName().equals("IncluirMotivoDeTransferencia")
				// ||
				// transaction.getName().equals("RemoverMotivoDeTransferencia")
				// ||
				// transaction.getName().equals("AlterarMotivoDeTransferencia")
				// ||
				// transaction.getName().equals("ConsultarMotivosDeTransferencia")
				// ) {
				// functionPointSystem.getTransactionModel().getTransactions().remove(transaction);
				// }
				// }
				functionPointSystem.clear();

//				System.out.println("Total:" + functionPointCalculator.calculate(functionPointSystem, 0, views));
				// functionPointView.render();
			}
		} 
		catch (Exception e)
		{
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
}