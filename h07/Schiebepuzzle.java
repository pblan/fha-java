
/**
 * Eine Klasse um ein Schiebepuzzle zu erzeugen und auf diesem gültige Züge
 * ausführen.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public class Schiebepuzzle {
	/** Das Spielfeld */
	private int[][] spielfeld;
	/** Der Index des leeren Feldes. */
	private int[] emptyTileIndex;

	/** Platzhalter Zahl fuer das leere Feld. */
	private static final int EMPTY = 16;

	/**
	 * Konstrukter der das Feld initialisiert.
	 * 
	 */
	public Schiebepuzzle() {
		spielfeld = new int[4][4];
		for (int i = 0; i < 16; i++) {
			spielfeld[i / 4][i % 4] = i + 1;
		}
		this.emptyTileIndex = new int[] { 3, 3 };
	}

	/**
	 * Schiebt das Plaettchen mit der Zahl i auf das leere Feld wenn dies moeglich
	 * ist.
	 * 
	 * @throws WrongMoveException   Wenn die Zahl nicht verschoben werden kann.
	 * @throws WrongNumberException Wenn die Zahl nicht zwischen 1 und 15 liegt.
	 * @param i Zahl die verschoben werden soll.
	 */
	public void schiebe(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException(i + " liegt nicht zwischen 1 und 15.");
		} else if (!istVerschiebbar(i)) {
			throw new WrongMoveException("Die " + i + " kann nicht bewegt werden");
		} else {
			int[] index = getIndex(i);

			int x = this.emptyTileIndex[0];
			int y = this.emptyTileIndex[1];
			if (Math.abs(index[0] - x) + Math.abs(index[1] - y) == 1) {
				this.spielfeld[x][y] = i;
				this.spielfeld[index[0]][index[1]] = EMPTY;
				this.emptyTileIndex[0] = index[0];
				this.emptyTileIndex[1] = index[1];
			}
		}
	}

	/**
	 * Testet ob eine Zahl verschoben werden kann.
	 * 
	 * @throws IllegalArgumentException Wenn die Zahl, die getestet wird, nicht
	 *                                  zwischen 1 und 15 liegt.
	 * @param i Zahl die getestet wird.
	 * @return boolean Gibt an, ob die Zahl verschoben werden kann.
	 */
	public boolean istVerschiebbar(int i) {
		if (i < 1 || i > 15) {
			throw new WrongNumberException(i + " liegt nicht zwischen 1 und 15.");
		}

		int[] index = getIndex(i);

		return Math.abs(index[0] - this.emptyTileIndex[0]) + Math.abs(index[1] - this.emptyTileIndex[1]) == 1;
	}

	/**
	 * Gibt den Index einer Zahl i zurueck.
	 * 
	 * @throws IllegalArgumentException Wenn die Zahl, deren Index gesucht wird,
	 *                                  nicht zwischen 1 und 15 liegt.
	 * @param num Zahl von der der Index gefunden werden soll.
	 * @return int[] in dem x und y Koordinate stehen.
	 */
	public int[] getIndex(int num) {
		int[] ret = new int[2];
		if (num < 1 || num > 15) {
			throw new WrongNumberException(num + " liegt nicht zwischen 1 und 15.");
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (spielfeld[i][j] == num) {
						ret[0] = i;
						ret[1] = j;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * Gibt einen Klon des Spielfeldes aus
	 * 
	 * @return int[][] Spielfeld
	 */
	public int[][] getSpielfeld() {
		int[][] ret = new int[4][4];
		for (int i = 0; i < this.spielfeld.length; i++) {
			ret[i] = this.spielfeld[i].clone();
		}

		return ret;
	}

	/**
	 * Gibt den Index des leeren Feldes.
	 * 
	 * @return int[] Index des leeren Feldes.
	 */
	public int[] getEmptyTileIndex() {
		return this.emptyTileIndex.clone();
	}

	/**
	 * Spielt 100 zufaellige Zuege.
	 * 
	 */
	public void mische() {
		int rnd = 0;
		int counter = 100;
		while (counter > 0) {
			rnd = (int) (Math.random() * 15 + 1);
			if (this.istVerschiebbar(rnd)) {
				this.schiebe(rnd);
				counter--;
			}
		}
	}

	/**
	 * Gibt das Spielfeld in dem gesuchten Stringformat aus.
	 * 
	 * @return String Spiel in Stringformat.
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < spielfeld.length; i++) {
			ret.append("|");
			for (int j = 0; j < spielfeld[i].length; j++) {
				if (spielfeld[i][j] != 16) {
					ret.append(String.format("%2d", spielfeld[i][j]));
					ret.append("|");
				} else {
					ret.append("  |");
				}
			}
			ret.append("\n");
			ret.append("-".repeat(13));
			ret.append("\n");
		}
		return ret.toString();
	}
}
