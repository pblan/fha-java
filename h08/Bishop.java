
import java.util.ArrayList;
/**
 * Eine Ableitung der Chessman Klasse, die einen Lauefer implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Bishop extends Chessman {

	/**
     * Erstellt einen neuen Laufer an der Position pos.
     * 
     * @param pos Position des Springers.
     */
	public Bishop(Position pos) {
		super(pos);
	}

	/**
     * Gibt eine ArrayList mit der moeglichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> res = new ArrayList<>();
		for (int x = -7; x <= 7; x++) {
			// Durchgehen der Diagonalen
			for (int y : new int[] { -x, x }) {
				// Check, ob Position gültig und nicht current
				if (x != 0 && y != 0 && Position.isValid(this.getPosition().getX() + x, this.getPosition().getY() + y))
					res.add(new Position(this.getPosition().getX() + x, this.getPosition().getY() + y));
			}
		}
		return res;
	}

	/**
     * Gibt die Figur mit Position als String aus.
     * 
     * @return Figur als String.
     */
	public String toString() {
		return "Laeufer: " + this.getPosition().toString();
	}

	/**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     */
    public void print() {
		super.print('L');
	}
}
