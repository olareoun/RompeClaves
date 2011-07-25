package org.todofluye.rompeclaves.frase;
import java.util.List;


public interface Frase {

	int longitud();
	boolean estaEnLaListaDeFrases(List<Frase> frases);
	boolean esIgualA(Frase otraFrase);
	Frase cambiaLaNesimaPalablaSiNoEsComodin(int n, String comodin) throws YaEstabaCambiadaException;
	String dameLaNesimaPalabra(int i);

}
