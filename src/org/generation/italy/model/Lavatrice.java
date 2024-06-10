package org.generation.italy.model;

public class Lavatrice {
	private boolean sportelloChiuso;		//indica se lo sportello è chiuso
	private int stato;						//0: spenta; 1:standby; 2: lavaggio in corso
	private boolean detersivoPresente;		//indica se è stato aggiunto il detersivo
	private int temperatura;				//tra 0 e 90
	
	
	public void accendi() {
		if (stato==0)	//spento
			stato=1;	//standby
		else
			System.out.println("Lavatrice già accesa");
	}
	
	public void spegni() {
		if (stato!=0)	//se non è spento
			stato=0;	//si spegne
		else
			System.out.println("Lavatrice già spenta");
	}
	
	public void apriSportello() {
		if (stato!=2) {
			if (sportelloChiuso)
				sportelloChiuso=false;
			else
				System.out.println("Sportello già aperto");
		} else
			System.out.println("Impossibile aprire lo sportello");
	}
	
	public void chiudiSportello() {
		if (!sportelloChiuso)
			sportelloChiuso=true;
		else
			System.out.println("Sportello già chiuso");
	}
	
	public void aggiungiDetersivo() {
		if (!detersivoPresente)
			detersivoPresente=true;
		else
			System.out.println("Detersivo già presente");
	}
	
	

	public void impostaTemperatura(int temperatura) {
		if (temperatura>=0 && temperatura<=90)
			this.temperatura = temperatura;
		else
			System.out.println("Temperatura non valida");	
	}
	
	public void avviaLavaggio() {
		if (sportelloChiuso && stato==1 && detersivoPresente) {
			System.out.println("lavaggio in corso a "+ temperatura +" gradi");
			stato=2;
		}
		else
			System.out.println("Impossibile avviare il lavaggio");
	}
	
	public void terminaLavaggio() {
		if (stato==2)  {
			stato=1;					//ritorna in standby
			detersivoPresente=false;	//il detersivo è stato consumato dal lavaggio
		}
		else
			System.out.println("Nessun lavaggio in corso");
			
	}

	//getters
	public boolean isDetersivoPresente() {	
		return detersivoPresente;
	}

	public boolean isSportelloChiuso() {
		return sportelloChiuso;
	}

	public int getStato() {
		return stato;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public Lavatrice() {
		//super();		//chiamata implicita al costruttore della superclasse
		super();		//chiamata esplicita al costruttore della superclasse
		sportelloChiuso=true;
		stato=0;
		temperatura=0;
		detersivoPresente=false;
	}

	@Override
	public String toString() {
		return "Lavatrice [sportello: " + (sportelloChiuso?"chiuso":"aperto")				
				+ ", stato: " + (stato==0?"spento":(stato==1?"standby":"lavaggio in corso")) +
				", detersivo: " + (detersivoPresente?"presente":"non presente") +
				", temperatura=" + temperatura + "]";
	}
	
	
	
	
	
}
