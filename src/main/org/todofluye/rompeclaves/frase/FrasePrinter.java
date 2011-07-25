package org.todofluye.rompeclaves.frase;

public class FrasePrinter {
	
	private Frase frase;
	
	public FrasePrinter(Frase frase){
		this.frase = frase;
	}

	public void print() {
		String linea = "";
		for (int i = 0; i < frase.longitud() - 1; i++){
			linea = linea.concat(frase.dameLaNesimaPalabra(i).concat("-"));
		}
		linea = linea.concat(frase.dameLaNesimaPalabra(frase.longitud() - 1));
		System.out.println("posible clave: " + frase);
	}

}
