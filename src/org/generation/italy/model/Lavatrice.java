package org.generation.italy.model;

public class Lavatrice {
	private boolean sportelloChiuso;		//indica se lo sportello è chiuso
	private int stato;						//0: spenta; 1:standby; 2: lavaggio in corso
	private boolean detersivoPresente;		//indica se è stato aggiunto il detersivo
	private int programmaCorrente;			//indica il programma correntemente selezionato
	
	
	private Programma[] elencoProgrammi;	//contiene sia oggetti di tipo "Lavaggio" che oggetti di tipo "Operazione" 	(POLIMORFISMO)
	
	
	
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
	
	

	
	
	public void avviaProgramma() {
		if (programmaCorrente>=0) {
			if (sportelloChiuso && stato==1 && detersivoPresente) {
				System.out.println(
					"Programma "+ elencoProgrammi[programmaCorrente].getNome()+ " in corso. "
					+ "Durata prevista: "+ elencoProgrammi[programmaCorrente].getDurata()+ " minuti");
				stato=2;
			}
			else
				System.out.println("Impossibile avviare il programma");	
		} else
			System.out.println("Programma non selezionato");
	}
	
	public void terminaProgramma() {
		if (stato==2)  {
			stato=1;					//ritorna in standby
			detersivoPresente=false;	//il detersivo è stato consumato dal lavaggio
		}
		else
			System.out.println("Nessun programma in corso");
			
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

	//costruttore
	public Lavatrice() throws Exception {
		//super();		//chiamata implicita al costruttore della superclasse
		super();		//chiamata esplicita al costruttore della superclasse
		sportelloChiuso=true;
		stato=0;		
		detersivoPresente=false;
		//inizializzo i programmi
		elencoProgrammi=new Programma[] {
			new Lavaggio("Cotone",30,45),
			new Lavaggio("Lana",40,30),
			new Lavaggio("Jeans",50,45),	
			new Operazione("Centrifuga", 15, true),
			new Operazione("Risciacquo", 10, true),
			new Operazione("Scarico acqua", 5, true),
			new Operazione("Asciugatura", 25, false)
		};
		programmaCorrente=-1;		//-1: non è stato selezionato il programma
	}

	@Override
	public String toString() {
		return "Lavatrice [sportello: " + (sportelloChiuso?"chiuso":"aperto")				
				+ ", stato: " + (stato==0?"spento":(stato==1?"standby":"programma in corso")) +
				", detersivo: " + (detersivoPresente?"presente":"non presente") + 
				", programma corrente: "+(programmaCorrente>=0?elencoProgrammi[programmaCorrente].getNome():"non impostato") ;
	}

	public int getProgrammaCorrente() {
		return programmaCorrente;
	}

	public void setProgrammaCorrente(int programmaCorrente) {
		if (stato==1) {	//sono in standby 
			
			if (programmaCorrente>=0 && programmaCorrente<elencoProgrammi.length)
				this.programmaCorrente = programmaCorrente;
			else {
				System.err.println("Programma non valido");
			}
		} else
			System.out.println("Impossibile impostare il programma");
	}

	public Programma[] getElencoProgrammi() {
		return elencoProgrammi;
	}
	
	
	
	
	
}
