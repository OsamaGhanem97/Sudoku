/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden!
 * Fuegen Sie Code, insbesondere weitere Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen
 ****************************************************************************************************** */

public class Spielfeld {
	private int[][] feld;
	private boolean[][] gegebeneStellen;
	private int n;

	/*
	 * NICHT AENDERN! Wird in main bereits aufgerufen.
	 */
	public Spielfeld(int level) {
		switch (level) {
		case 1:
			n = 2;
			int[][] leicht = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 0 }, { 4, 3, 0, 1 } };
			feld = leicht;
			break;
		case 2:
			n = 2;
			int[][] mittel = { { 1, 0, 0, 4 }, { 0, 4, 1, 0 }, { 2, 0, 4, 3 }, { 4, 3, 0, 1 } };
			feld = mittel;
			break;
		case 3:
			n = 3;
			int[][] schwer = { { 5, 0, 4, 6, 7, 8, 9, 1, 0 }, { 6, 7, 2, 0, 9, 5, 3, 0, 8 },
					{ 1, 9, 8, 3, 0, 2, 5, 6, 7 },

					{ 8, 5, 0, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 0, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 0, 0, 5, 6 },

					{ 9, 6, 1, 5, 3, 7, 2, 0, 4 }, { 2, 0, 7, 4, 1, 9, 6, 3, 5 }, { 0, 4, 5, 2, 8, 6, 1, 7, 0 } };
			feld = schwer;
			break;
		}
		initialisiereGegebeneStellen();
	}

	/*
	 * NICHT AENDERN! Konstruktor ist zu Testzwecken vorhanden.
	 */
	public Spielfeld(int[][] feld) {
		this.feld = feld;
		n = (int) Math.sqrt(feld.length);
		initialisiereGegebeneStellen();
	}

	/*
	 * Array gegebeneStellen erstellen. Alle Stellen, die in feld > 0 sind, werden
	 * in gegebeneStellen auf true gesetzt, die anderen auf false.
	 */
	public void initialisiereGegebeneStellen() {
		// TODO
		// Anweisung(en) hinzufuegen
		gegebeneStellen = new boolean[feld.length][feld.length];
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld.length; j++) {
				if (feld[i][j] > 0) {
					gegebeneStellen[i][j] = true;
				} else {
					gegebeneStellen[i][j] = false;
				}
			}
		}

	}

	/*
	 * NICHT AENDERN! Zu Testzwecken vorhanden. Darf verwendet werden, muss aber
	 * nicht.
	 */
	public boolean getGegebeneStellen(int zeile, int spalte) {
		return gegebeneStellen[zeile][spalte];
	}

	/*
	 * Gibt Wert an Stelle [zeile, spalte] in feld zurueck. Es ist sichergestellt,
	 * dass die Methode nur mit gueltigen Werten aufgerufen wird.
	 */
	public int getStelle(int zeile, int spalte) {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		return feld[zeile][spalte];
	}

	/*
	 * Setzt wert an Stelle [zeile, spalte] in feld. Es ist sichergestellt, dass die
	 * Methode nur mit gueltigen Werten aufgerufen wird.
	 */
	public void setStelle(int zeile, int spalte, int wert) {
		// TODO
		// Anweisung(en) hinzufuegen
		feld[zeile][spalte] = wert;

	}

	/*
	 * True wenn Zeile und Spalte zwischen 0 und n*n-1 und wert zwischen 1 und n*n
	 * und gegebeneStellen(zeile,spalte) false. False sonst.
	 */
	public boolean gueltigeEingabe(int zeile, int spalte, int wert) {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern //
		if (zeile < 0 || zeile >= feld.length || spalte < 0 || spalte >= feld[0].length) {
			return false;
		}
		if (gegebeneStellen[zeile][spalte] == true) {
			return false;
		}
		if (wert < 1 || wert > n * n) {
			return false;
		}
		return true;
	}

	/*
	 * True wenn alle Stellen gesetzt wurden, also keine 0 mehr im feld vorhanden
	 * ist. False sonst.
	 */
	public boolean istVoll() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Gibt true zurueck, wenn das uebergebene Feld alle Zahlen von 1 bis n*n genau
	 * enthaelt. Sonst false.
	 */ // 2 1 1 4 1 2 3 4
	public boolean enthaeltJedeZahl(int[] feld) {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		for (int zahl = 1; zahl <= n * n; zahl++) {
			int anzahl = 0;
			for (int i = 0; i < feld.length; i++) {
				if (feld[i] == zahl) {
					anzahl++;
				}
			}
			if (anzahl != 1) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Gibt true zurueck, wenn jede Zeile von feld jede Ziffer zwischen 1 und n*n
	 * enthaelt. False sonst. enthaeltJedeZiffer(int[] feld) verwenden.
	 */
	public boolean checkZeilen() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		for (int zeile = 0; zeile < feld.length; zeile++) {
			int[]sf=new int[feld.length];
			for(int spalte=0;spalte<feld.length;spalte++) {
				sf[spalte]=feld[zeile][spalte];
			}
			if (!enthaeltJedeZahl(sf)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Gibt true zurueck, wenn jede Spalte von feld jede Ziffer zwischen 1 und n*n
	 * enthaelt. False sonst. enthaeltJedeZiffer(int[] feld) verwenden.
	 */
	public boolean checkSpalten() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern

		for (int spalte = 0; spalte < feld[0].length; spalte++) {
			int[] sf = new int[feld.length];
			for (int zeile = 0; zeile < feld.length; zeile++) {
				sf[zeile] = feld[zeile][spalte];
			}
			if (!enthaeltJedeZahl(sf)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Gibt true zurueck, wenn jeder Block von feld jede Ziffer zwischen 1 und n*n
	 * enthaelt. False sonst. enthaeltJedeZiffer(int[] feld) verwenden. Siehe
	 * Pseudocode in Aufgabenstellung
	 */
	public boolean checkBloecke() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		for (int zeile = 0; zeile < feld.length; zeile += n) {
			for (int spalte = 0; spalte < feld.length; spalte += n) {
				int[] block = new int[n*n];
				int index = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						block[index] = feld[zeile + i][spalte + j];
						index++;
					}
				}
				if (!enthaeltJedeZahl(block)) {
					return false;
				}
			}
		}
		return false;
	}

	/*
	 * Gibt true zurueck, wenn das Sudoku korrekt geloest wurde. False sonst.
	 * checkZeilen(), checkSpalten(), checkBloecke() verwenden
	 */
	public boolean geloest() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		
		return checkZeilen()&&checkSpalten()&&checkBloecke();
	}

	/*
	 * NICHT AENDERN! Auf jeden Fall verwenden! Gibt einen String zurueck, der das
	 * Feld feld gemaess den Vorgaben fuer die Ausgabe auf die Konsole uebersetzt.
	 */
	public String toString() {
		String ausgabe = "";
		int groesse = n * n;

		// Spaltennummern
		ausgabe += String.format("%4s", "");
		for (int j = 0; j < groesse; j++) {
			ausgabe += String.format(" %2d ", j);
			if ((j + 1) % n == 0)
				ausgabe += " ";
		}
		ausgabe += "\n";

		for (int i = 0; i < groesse; i++) {

			// Horizontale Linie
			if (i % n == 0) {
				ausgabe += String.format("%3s", "");
				ausgabe += "+";
				for (int j = 0; j < groesse; j++) {
					ausgabe += "----";
					if ((j + 1) % n == 0)
						ausgabe += "+";
				}
				ausgabe += "\n";
			}

			// Zeilennummer
			ausgabe += String.format("%2d ", i);

			for (int j = 0; j < groesse; j++) {
				if (j % n == 0)
					ausgabe += "|";

				if (feld[i][j] == 0) {
					ausgabe += String.format(" %2s ", "-");
				} else {
					ausgabe += String.format(" %2d ", feld[i][j]);
				}
			}

			ausgabe += "|\n";
		}

		// Untere Linie
		ausgabe += String.format("%3s", "");
		ausgabe += "+";
		for (int j = 0; j < groesse; j++) {
			ausgabe += "----";
			if ((j + 1) % n == 0)
				ausgabe += "+";
		}
		ausgabe += "\n";

		return ausgabe;
	}
}
