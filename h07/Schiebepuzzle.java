import java.awt.Point;
import java.util.ArrayList;
/**
 * Simuliert ein Schiebepuzzle.
 * Enthaelt ein Feld, welches die Positionen der einzelnen Zahlen enthaelt
 * und Methoden um Plättchen zu verschieben
 */
public class Schiebepuzzle {

	private Point[] feld;
/**
 * Gibt das aktuelle Spielfeld zurück
 * @return eindimensionales Array von Punkten
 */
	public Point[] getFeld(){
		return this.feld;
	}
	/**
	 * Initialisiert ein bereits gelöstes Spielfeld
	 * letzter Punkt entspricht dem leeren Feld
	 */
	public Schiebepuzzle() {
		int k = 0;
		this.feld = new Point[16];
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				feld[k]=new Point(j, i);
				k++;
			}
		}
	}
/**
 * Schiebt die übergebene Zahl in das leere Feld
 * @throws WrongNumberException wird geworfen, wenn die Zahl nicht zwischen 1 und 15 liegt
 * @throws WrongMoveException wird geworfen, wenn der Zug nicht möglich ist
 * @param i zu verschiebende Zahl
 */
	public void schiebe(int i) {
		if ((i < 1) || (i > 15)) {
			throw new WrongNumberException("i liegt nicht zwischen 1 und 15");
		} else if (!istVerschiebbar(i)) {
			throw new WrongMoveException("Zug ist nicht moeglich");
		} else {
			Point temp = feld[15];
			feld[15] = feld[i - 1];
			feld[i - 1] = temp;
		}
	}

/**
 * Prüft ob Zahl verschiebbar ist
 * @param i zu prüfende Zahl
 * @return Wahrheitswert
 */
	public boolean istVerschiebbar(int i) {
		if (1==Math.abs(feld[i-1].x - feld[15].x)+Math.abs(feld[i-1].y - feld[15].y)) {
			return true;
		} else {
			return false;
		}
	}
/**
 * Führt 100 zufaellige Zuege aus
 */
	public void mische() {
		for(int i=0;i<100;i++){
			schiebe(getLegalMoves().get((int)Math.floor(getLegalMoves().size()*Math.random())));
		}
	}
	/**
	 * Gibt ArrayList von allen verschiebbaren Plaetchen zurück
	 * @return ArrayList
	 */
	public ArrayList<Integer> getLegalMoves(){
		ArrayList<Integer>legalMoves= new ArrayList<>();
		for(int i =0;i<16;i++){
			if (1==Math.abs(feld[i].x - feld[15].x)+Math.abs(feld[i].y - feld[15].y)) {
				legalMoves.add(i+1);
			}
		}
		return legalMoves;
	}
	
	public String toString() {
		int[][] positionen = new int[4][4];
		for (int i = 0; i < 16; i++) {
			positionen[feld[i].x-1][feld[i].y-1] = i+1;
		}
		String s = "";
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if(positionen[i][j]<10) {
					s+="| "+positionen[i][j];
				}else if(positionen[i][j]<16) {
					s+="|"+positionen[i][j];
				}else {
					s+="|  ";
				}
				
			}
			s+="|\n-------------\n";
		}
		return s;
	}
}
