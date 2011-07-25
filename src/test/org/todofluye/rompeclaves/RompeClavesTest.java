package org.todofluye.rompeclaves;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.todofluye.ext.MiFactorial;
import org.todofluye.rompeclaves.frase.Frase;
import org.todofluye.rompeclaves.frase.FraseVaciaException;



public class RompeClavesTest {

	private String comodin = "comodin";;

	@Test(expected=FraseVaciaException.class)
	public void testRomperFraseVacia() throws FraseVaciaException{
		String[] fraseVacia = {};
		new RompeClaves(fraseVacia, null);
	}
	
	@Test
	public void testRomperFraseSoloUnaPalabraDevuelveUnaCombinacion() throws FraseVaciaException{
		int numeroPalabrasFrase = 1;
		int numeroResultadosCorrectos = dameElNumeroDeResultadosCorrecto(numeroPalabrasFrase);
		List<Frase> posiblesClaves = probrarFaseNPalabras(numeroPalabrasFrase);
		assertEquals(numeroResultadosCorrectos, posiblesClaves.size());
	}

	@Test
	public void testRomperFraseSoloUnaPalabraDevuelveSoloComodin() throws FraseVaciaException{
		int numeroPalabrasFrase = 1;
		List<Frase> posiblesClaves = probrarFaseNPalabras(numeroPalabrasFrase);
		String resultado = posiblesClaves.get(0).dameLaNesimaPalabra(0);
		assertTrue(comodin.equals(resultado));
	}
	
	@Test
	public void testRomperFraseDosPalabrasDevuelveTresPosiblesClaves() throws FraseVaciaException{
		int numeroPalabrasFrase = 2;
		int numeroResultadosCorrectos = dameElNumeroDeResultadosCorrecto(numeroPalabrasFrase);
		List<Frase> posiblesClaves = probrarFaseNPalabras(numeroPalabrasFrase);
		assertEquals(numeroResultadosCorrectos, posiblesClaves.size());
	}
	
	@Test
	public void testRomperFraseTresPalabrasDevuelveSietePosiblesClaves() throws FraseVaciaException{
		int numeroPalabrasFrase = 3;
		int numeroResultadosCorrectos = dameElNumeroDeResultadosCorrecto(numeroPalabrasFrase);
		List<Frase> posiblesClaves = probrarFaseNPalabras(numeroPalabrasFrase);
		assertEquals(numeroResultadosCorrectos, posiblesClaves.size());
	}

	@Test
	public void testRomperFrasePalabrasDevuelve() throws FraseVaciaException{
		int numeroPalabrasFrase = 4;
		int numeroResultadosCorrectos = dameElNumeroDeResultadosCorrecto(numeroPalabrasFrase);
		List<Frase> posiblesClaves = probrarFaseNPalabras(numeroPalabrasFrase);
		assertEquals(numeroResultadosCorrectos, posiblesClaves.size());
	}
	
	@Test
	public void testFrasesDe1a100PalabrasDevuelvenElResultadoCorrecto() throws FraseVaciaException{
		int numeroFrases = 10;
		for (int i = 1; i <= numeroFrases; i++){
			int numeroResultadosCorrectos = dameElNumeroDeResultadosCorrecto(i);
			List<Frase> posiblesClaves = probrarFaseNPalabras(i);
			assertEquals(numeroResultadosCorrectos, posiblesClaves.size());
		}
	}
	
	private List<Frase> probrarFaseNPalabras(int numeroPalabrasFrase)
	throws FraseVaciaException {
		String[] frase = crearFraseNPalabras(numeroPalabrasFrase);
		RompeClaves rompeClaves = new RompeClaves(frase, comodin);
		List<Frase> posiblesClaves = rompeClaves.dameLasCombinaciones();
		return posiblesClaves;
	}
	
	private int dameElNumeroDeResultadosCorrecto(int numeroPalabras){
		BigInteger resultado = BigInteger.ZERO;
		BigInteger factorialN = MiFactorial.factorial(numeroPalabras);
		for (int i = 1; i <= numeroPalabras; i++){
			BigInteger factorialNmenosI = MiFactorial.factorial(numeroPalabras - i); 
			BigInteger factorialI = MiFactorial.factorial(i);
			resultado = resultado.add(factorialN.divide(factorialI.multiply(factorialNmenosI)));
		}
		return resultado.intValue();
	}

	private String[] crearFraseNPalabras(int n) {
		String[] frase = new String[n];
		for (int i = 0; i < n; i++){
			frase[i] = damePalabra();
		}
		return frase;
	}

	private String damePalabra() {
		String palabra = "bla";
		return palabra;
	}
	
}
