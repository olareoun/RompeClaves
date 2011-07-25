package org.todofluye.rompeclaves;
import java.util.ArrayList;
import java.util.List;

import org.todofluye.rompeclaves.frase.Frase;
import org.todofluye.rompeclaves.frase.FraseImpl;
import org.todofluye.rompeclaves.frase.FraseVaciaException;


public class RompeClaves {

	private Frase frase;
	private String comodin;
	private List<Frase> combinacionesClaves;
	private Frase combinacionParada;

	public RompeClaves(String[] frase, String comodin) throws FraseVaciaException {
		if (frase.length > 0){
			this.frase = new FraseImpl(frase);
			this.comodin = comodin;
			this.combinacionesClaves = new ArrayList<Frase>();
			crearCombinacionDeParada();
		}else{
			throw new FraseVaciaException();
		}
	}

	public List<Frase> dameLasCombinaciones() {
		while (!estaLaCombinacionDeParada()){
			anadePosiblesClavesConOtraSustitucion();
		}
		return combinacionesClaves;
	}

	private void anadePosiblesClavesConOtraSustitucion() {
		List<Frase> combinaciones = crearRondaDeCombinaciones();
		anadirCombinacionesSiNoEstan(combinaciones);
	}

	private List<Frase> crearRondaDeCombinaciones() {
		if (combinacionesClaves.size() == 0){
			return crearPrimeraRondaDeCombinaciones();
		}else{
			return crearNuevaRondaDeCombinaciones();
		}
	}

	private List<Frase> crearNuevaRondaDeCombinaciones() {
		List<Frase> combinaciones = new ArrayList<Frase>();
		for (int i = 0; i < combinacionesClaves.size(); i++){
			Frase fraseACombinar = combinacionesClaves.get(i);
			List<Frase> combinacionesFrase = creaCombinacionesFrase(fraseACombinar);
			combinaciones.addAll(combinacionesFrase);
		}
		return combinaciones;
	}

	private List<Frase> crearPrimeraRondaDeCombinaciones() {
		Frase fraseACombinar = frase;
		List<Frase> combinacionesFrase = creaCombinacionesFrase(fraseACombinar);
		return combinacionesFrase;
	}

	private List<Frase> creaCombinacionesFrase(Frase fraseACombinar) {
		Combinador combinador = new CombinadorPorSustitucionDeUnicoItem(fraseACombinar, comodin);
		List<Frase> combinacionesFrase = combinador.creaCombinaciones();
		return combinacionesFrase;
	}
	
	private void anadirCombinacionesSiNoEstan(List<Frase> combinaciones) {
		for (int i = 0; i < combinaciones.size(); i++){
			anadeCombinacionSiNoEsta(combinaciones.get(i));
		}
	}

	private boolean estaLaCombinacionDeParada() {
		for (int i = 0; i < combinacionesClaves.size(); i++){
			Frase combinacion = combinacionesClaves.get(i);
			if (combinacion.esIgualA(combinacionParada)){
				return true;
			}
		}
		return false;
	}

	private void anadeCombinacionSiNoEsta(Frase frase) {
		if (!frase.estaEnLaListaDeFrases(combinacionesClaves)){
			combinacionesClaves.add(frase);
		}
	}

	private void crearCombinacionDeParada() {
		String[] palabrasParada = new String[frase.longitud()];
		for (int i = 0; i < frase.longitud(); i++){
			palabrasParada[i] = comodin;
		}
		combinacionParada = new FraseImpl(palabrasParada);
	}
}

