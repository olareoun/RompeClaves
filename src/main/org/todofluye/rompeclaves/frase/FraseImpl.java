package org.todofluye.rompeclaves.frase;
import java.util.List;


public class FraseImpl implements Frase{

	private String[] palabras;

	public FraseImpl(String[] palabras) {
		this.palabras = palabras;
	}

	public int longitud() {
		return palabras.length;
	}

	public Frase cambiaLaNesimaPalablaSiNoEsComodin(int n, String comodin) throws YaEstabaCambiadaException {
		String[] clonPalabras = palabras.clone();
		if (!clonPalabras[n].equals(comodin)){
			clonPalabras[n] = comodin;
			return new FraseImpl(clonPalabras);
		}else{
			throw new YaEstabaCambiadaException();
		}
	}

	public boolean estaEnLaListaDeFrases(List<Frase> combinacionesClaves) {
		boolean esta = false;
		for (int i = 0; i < combinacionesClaves.size(); i++){
			Frase combinacion = combinacionesClaves.get(i);
			if (esIgualA(combinacion)){
				esta = true;
			}
		}
		return esta;
	}

	public boolean esIgualA(Frase otraFrase) {
		if (this.longitud() != otraFrase.longitud()){
			return false;
		}
		for (int i = 0; i < this.longitud(); i++){
			if (this.dameLaNesimaPalabra(i) != otraFrase.dameLaNesimaPalabra(i)){
				return false;
			}
		}
		return true;
	}

	public String dameLaNesimaPalabra(int i) {
		return this.palabras[i];
	}

}
