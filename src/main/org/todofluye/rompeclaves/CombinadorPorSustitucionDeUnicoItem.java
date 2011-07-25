package org.todofluye.rompeclaves;

import java.util.ArrayList;
import java.util.List;

import org.todofluye.rompeclaves.frase.Frase;
import org.todofluye.rompeclaves.frase.YaEstabaCambiadaException;

public class CombinadorPorSustitucionDeUnicoItem implements Combinador{

	private Frase frase;
	private String comodin;
	private ArrayList<Frase> combinaciones;
	
	public CombinadorPorSustitucionDeUnicoItem(Frase frase, String comodin){
		this.frase = frase;
		this.comodin = comodin;
		this.combinaciones = new ArrayList<Frase>();
	}

	public List<Frase> creaCombinaciones() {
		for (int i = 0; i < frase.longitud(); i++){
			anadeNuevaCombinacion(i);
		}
		return combinaciones;
	}

	private void anadeNuevaCombinacion(int i) {
		try {
			Frase posibleClave = frase.cambiaLaNesimaPalablaSiNoEsComodin(i, comodin);
			combinaciones.add(posibleClave);
		} catch (YaEstabaCambiadaException e) {
		}
	}

}
