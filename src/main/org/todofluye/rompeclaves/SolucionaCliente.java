package org.todofluye.rompeclaves;
import java.util.List;

import org.todofluye.rompeclaves.frase.Frase;
import org.todofluye.rompeclaves.frase.FrasePrinter;
import org.todofluye.rompeclaves.frase.FraseVaciaException;


public class SolucionaCliente {

	public static void main(String[] args) {
		String[] fraseCliente = args[0].split("-");
		String comodincliente = args[1];
		
		try {
			RompeClaves rompeclaves = new RompeClaves(fraseCliente, comodincliente) ; 
			List<Frase> posiblesclaves = rompeclaves.dameLasCombinaciones() ; 
			imprimeFrases(posiblesclaves);
		} catch (FraseVaciaException e) {
			e.printStackTrace();
		}
	}

	private static void imprimeFrases(List<Frase> posiblesclaves) {
		for ( int i  = 0 ; i< posiblesclaves.size(); i++)
		{
			imprimeFrase(posiblesclaves, i);
		}
	}

	private static void imprimeFrase(List<Frase> posiblesclaves, int i) {
		FrasePrinter printer = new FrasePrinter(posiblesclaves.get(i));
		printer.print();
	}

}
