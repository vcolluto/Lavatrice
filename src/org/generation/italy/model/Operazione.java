package org.generation.italy.model;

//sottoclasse di Programma: "eredita" nome e durata 
public class Operazione extends Programma {
	private boolean presenzaAcqua;

	public Operazione(String nome, int durata, boolean presenzaAcqua) throws Exception {
		super(nome, durata);
		this.presenzaAcqua = presenzaAcqua;
	}

	public boolean isPresenzaAcqua() {
		return presenzaAcqua;
	}

}
