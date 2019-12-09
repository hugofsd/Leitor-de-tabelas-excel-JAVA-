package br.com.exceljava;
import java.io.IOException; 
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
	//Instancia de dados
		GerenciadorCheques gerenciadorCheques = new GerenciadorCheques();
		
		List<Cheque> cheques = gerenciadorCheques.criar();
		
		gerenciadorCheques.imprimir(cheques);
		

	}

}
