import java.util.Scanner;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare!
 * Fuegen Sie Code hinzu!
 * Aendern Sie vom vorhandenen Code nur return-Anweisungen!
 ****************************************************************************************************** */

public class Spiel {

	/* Verwenden Sie unbedingt diese Klassenattribute in den Methoden der Klasse! */
	private static Scanner sc = new Scanner(System.in);
	public static Spieler spieler;
	public static Spielfeld sf;

	public static void main(String[] args) {
		System.out.println("Herzlich Willkommen zu Sudoku");
		int eingabe;
		boolean spielen = true;
		do {
			eingabe = menu();
			if (eingabe < 4) {
				/*
				 * Namen des Spielers einlesen. Sie duerfen von korrekter Eingabe ausgehen.
				 * Konstruktor fuer spieler aufrufen.
				 * 
				 */
				// TODO
				// Anweisung(en) hinzufuegen

				/* NICHT AENDERN */
				  System.out.println("Gib den Namen des Spielers ein: ");
				  String name=sc.next();
				  spieler=new Spieler(name);
				  sf = new Spielfeld(eingabe);
				  System.out.println(sf);
				  spielen();
			}else {
				System.out.println("Programm wurde beendet");
				return;
			}
			/* Dafuer sorgen, dass bei Eingabe 4 das Programm endet */
			// TODO
			// Anweisung(en) hinzufuegen

		} while (spielen);

		sc.close();
	}

	/*
	 * Fragt solange nach einer Menu-Eingabe bis eine erlaubte Zahl eingegeben wird.
	 * Methode checkEingabeMenu() verwenden
	 */
	public static int menu() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		int eingabe;
		do {
			System.out.println("1- Sudoku Leicht ");
			System.out.println("2- Sudoku mittel");
			System.out.println("3- Sudoku schwer");
			System.out.println("4- Programm beenden");
			eingabe = sc.nextInt();
		} while (!checkEingabeMenu(eingabe));
		return eingabe;
	}

	/*
	 * Gibt bei Eingabe von 1, 2, 3 oder 4 true zurueck. Sonst false.
	 */
	public static boolean checkEingabeMenu(int eingabe) {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		if (eingabe == 1 || eingabe == 2 || eingabe == 3 || eingabe == 4) {
			return true;
		}
		return false;
	}

	/*
	 * Die Methode spielzug() aufrufen und das Spielfeld ausgeben, solange das
	 * Spielfeld nicht voll (siehe Methode istVoll()) ist.
	 */
	public static void spielen() {
		// TODO
		// Anweisung(en) hinzufuegen

		// NICHT AENDERN
		do {
			spielzug();
			System.out.println(sf);
		}while(!sf.istVoll());
		System.out.println(auswertung());
	}

	/*
	 * Der Spieler wird solange nach einer Eingabe von Zeile, Spalte und Wert
	 * gefragt, bis eine gueltige Eingabe erfolgt (siehe Methode gueltigeEingabe()).
	 * Danach wird setStelle mit diesen Eingaben aufgerufen.
	 */
	public static void spielzug() {
		// TODO
		// Anweisung(en) hinzufuegen
		int zeile;
		int spalte;
		int wert;
		do {
			System.out.println(spieler.getName() + " ,Gib eine Zeile an: ");
			zeile = sc.nextInt();
			System.out.println(spieler.getName() + " ,Gib eine Spalte an: ");
			spalte = sc.nextInt();
			System.out.println(spieler.getName() + " ,Welchen Wert moechtst du an diese Stelle setzen? ");
			wert = sc.nextInt();

		} while (!sf.gueltigeEingabe(zeile, spalte, wert));
		sf.setStelle(zeile, spalte, wert);
		
	}

	/*
	 * Wird aufgerufen, wenn das Spielfeld komplett gefuellt ist. Gibt den String
	 * geloest zurueck, wenn das Sudoku geloest wurde. Sonst den String nichtGeloest
	 * zurueckgeben.
	 */
	public static String auswertung() {
		String geloest = "Herzlichen Glueckwunsch! Du hast das Sudoku korrekt geloest!";
		String nichtGeloest = "Schade! Da ist was falsch. Naechstes Mal klappt es bestimmt besser.";

		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		if (sf.istVoll()) {
			return geloest;
		}
		return nichtGeloest;
	}

}
