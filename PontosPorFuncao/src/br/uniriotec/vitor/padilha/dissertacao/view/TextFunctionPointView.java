package br.uniriotec.vitor.padilha.dissertacao.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;

public class TextFunctionPointView extends GenericFunctionPointView {

	
	private File file;
	@Override
	public void renderTransactionModelValue(TransactionModel transactionModel,
			int totalTransations, int totalFunctionsPoint) {
		try {
			adicionaLinha("### Total de pontos por função não ajustado para transações: "+totalFunctionsPoint+" para "+totalTransations+" transações");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TextFunctionPointView() throws IOException {
		super();
		File f = new File(".");
		deletar("resultado.txt");
		criarArquivo("resultado.txt");
	}
	
	private void criarArquivo(String nomeArquivo) throws IOException {
		File f = new File(".");
		f  = new File(f.getCanonicalPath()+"\\resources\\"+nomeArquivo);
		if(!f.exists()) {
			f.createNewFile();
		}
		this.file=f;		
	}
	
	private void adicionaLinha(String conteudo) throws IOException {
		FileReader in = new FileReader(this.file);
		BufferedReader buff = new BufferedReader(in);
		String linha = "";
		List<String> linhas = new ArrayList<String>();
		while((linha = buff.readLine())!=null) {
			linhas.add(linha);
		}
		FileWriter wr = new FileWriter(this.file);
		PrintWriter pw = new PrintWriter(wr);
		for(String linhaA:linhas){
			pw.write(linhaA);
			pw.println();
		}
		pw.write(conteudo);
		wr.close();
	}

	private void deletar(String nomeArquivo) throws IOException {
		File f = new File(".");
		f  = new File(f.getCanonicalPath()+"\\resources\\"+nomeArquivo);
		if(f.exists()) {
			f.delete();
		}
	}

	@Override
	public void renderTransactionValue(Transaction transaction, String[] ftrs,
			String[] dets, int totalFunctionsPoint) {
		try {
			adicionaLinha("### "+transaction.getType().name()+" - "+transaction.getName()+ " (DETs: "+dets.length+", FTRs: "+ftrs.length+"). Pontos Por Função: "+totalFunctionsPoint);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void renderDataModelValue(DataModel dataModel,
			int totalDataModelElement, int totalFunctionsPoint) {
		try {
			adicionaLinha("#### Total de pontos por função não ajustado para função de dados: "+totalFunctionsPoint+" para "+totalDataModelElement+" arquivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void renderDataModelElementValue(DataModelElement dataModelElement,
			List<String[]> rets, String[] dets, int totalFunctionsPoint) {
		try {
			adicionaLinha("### "+dataModelElement.getType().name()+" - "+dataModelElement.getName()+" (DETs: "+dets.length+", RETs: "+rets.size()+"). Pontos por Função: "+totalFunctionsPoint);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
