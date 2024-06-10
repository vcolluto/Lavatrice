/*
 * PARTE 1

Scrivere una classe “Lavatrice” che contiene i seguenti attributi:

boolean sportelloChiuso (indica se lo sportello è chiuso)
int stato (0: spenta; 1:standby; 2:lavaggio in corso)
boolean detersivoPresente (indica se è stato aggiunto il detersivo)
int temperatura

e i seguenti metodi;
void accendi()  //da "spento" passa in "stand by"
void spegni()
void apriSportello()
void chiudiSportello()
void aggiungiDetersivo()
void impostaTemperatura(int temperatura)
void avviaLavaggio() (mostra il messaggio “lavaggio in corso a x gradi”, dove “x” è la temperatura)
void terminaLavaggio() (mostra il messaggio “lavaggio terminato”)
aggiungere costruttore e opportuni  getter e setter, e fare in modo da impedire 
un utilizzo inappropriato della lavatrice 
(ad esempio si può avviare il lavaggio solo se lo sportello è chiuso, il detersivo è presente 
e la lavatrice è in standby)



Nella classe Main proporre un menu di scelta che consente di richiamare i vari metodi 

PARTE 2 (ereditarietà)

Rimuovere dalla classe Lavatrice l'attributo temperatura;
Creare una classe Programma contenente i seguenti attributi:
nome (String)
durata (int)
Creare una classe Lavaggio che eredita da Programma e che aggiunge l'attributo:
temperatura (int)
Creare una classe Operazione che eredita da Programma e che aggiunge l'attributo:
presenzaAcqua (boolean)
Aggiungere alla classe Lavatrice:
un array di Programma, contenente alcuni oggetti di Lavaggio (es: "cotone", "jeans", "delicati") e alcuni oggetti di Operazione (es: "centrifuga", "risciacquo", "scarico acqua")
un attributo programmaCorrente (int)
un metodo selezionaProgramma(int programma)
rinominare il metodo  avviaLavaggio() in avviaProgramma(); il messaggio deve essere: “Programma <nome programma> in corso. Durata prevista: <durata programma> minuti"
 */

package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Lavatrice;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lavatrice l=new Lavatrice();
		String scelta;
		do{
			System.out.println("\n\n\n\n\n\n\nGestione lavatrice:");
			System.out.println("1. Accendi");
			System.out.println("2. Spegni");
			System.out.println("3. Apri sportello");
			System.out.println("4. Chiudi sportello");
			System.out.println("5. Aggiungi detersivo");
			System.out.println("6. Imposta temperatura");
			System.out.println("7. Avvia lavaggio");
			System.out.println("8. Termina lavaggio");
			System.out.println("0. Esci\n");

			
			System.out.println(l.toString());	//mostra lo stato della lavatrice
		

			System.out.print("\nInserisci la tua scelta:");
			scelta = sc.nextLine();

			switch (scelta) {
			case "1":		
				l.accendi();				
				break;
			case "2":
				l.spegni();
					
				break;
			case "3":
				l.apriSportello();
				break;
			case "4":
				l.chiudiSportello();
				break;
			case "5":
				l.aggiungiDetersivo();
				break;
			case "6":
				System.out.print("Inserisci la temperatura (0-90):");
				try {
					int temperatura = Integer.parseInt(sc.nextLine());
					l.impostaTemperatura(temperatura);
				} catch (NumberFormatException e) {
					System.out.println("Temperatura non valida");
				}
				break;
			case "7":
				l.avviaLavaggio();
				break;
			case "8":
				l.terminaLavaggio();
				break;
			
			case "0":
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
				break;
				
			}
			System.out.println("\nPremi invio per continuare...");
			sc.nextLine();
		} while (!scelta.equals("0"));
		sc.close();
		
		

	}

}
