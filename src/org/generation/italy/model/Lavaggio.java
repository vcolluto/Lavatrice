package org.generation.italy.model;

//sottoclasse di Programma ("eredita" il nome e la durata dalla classe Programma)
public class Lavaggio extends Programma {
	
	private int temperatura;

	public Lavaggio(String nome, int durata, int temperatura) throws Exception {
		super(nome, durata);		//chiamata al costruttore della superclasse (Programma)
		
		if (temperatura>=0 && temperatura<=90)
			this.temperatura = temperatura;
		else
			throw new Exception("Temperatura non valida");		
	}

	public int getTemperatura() {
		return temperatura;
	}
	
	
	
	
}
