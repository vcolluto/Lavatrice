package org.generation.italy.model;

//superclasse
public class Programma {
	private String nome;
	private int durata;
	private boolean detersivoNecessario;
	
	//rappresenta un programma della lavatrice (es: "cotone", "lana", ecc.)
	public Programma(String nome, int durata, boolean detersivoNecessario) throws Exception {
		super();
		if (!nome.isBlank())
			this.nome = nome;
		else
			throw new Exception("nome programma obbligatorio");
		
		if (durata>0)
			this.durata = durata;
		else
			throw new Exception("durata non valida");
		
		this.detersivoNecessario=detersivoNecessario;
	}

	public String getNome() {
		return nome;
	}

	public int getDurata() {
		return durata;
	}

	@Override
	public String toString() {
		return "Programma [nome=" + nome + ", durata=" + durata + "]";
	}

	public boolean isDetersivoNecessario() {
		return detersivoNecessario;
	}
	
	
	
	
	
}
