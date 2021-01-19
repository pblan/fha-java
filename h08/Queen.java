
import java.util.ArrayList;
/**
 * Eine Ableitung der Chessman Klasse, die eine Dame implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Queen extends Chessman {

	/**
     * Erstellt eine neue Dame an der Position pos.
     * 
     * @param pos Position des Springers.
     */
	public Queen(Position pos) {
		super(pos);
	}

	/**
     * Gibt eine ArrayList mit den moeglichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> ret = new ArrayList<>();
		for (int x = -7; x <= 7; x++) {
			for (int y = -7; y <= 7; y++) {
				if ((x == y || x == -y || x == 0 || y == 0) && !(x == 0 && y == 0)
						&& Position.isValid(this.getPosition().getX() + x, this.getPosition().getY() + y))
					ret.add(new Position(this.getPosition().getX() + x, this.getPosition().getY() + y));
			}
		}
		return ret;
	}

	/**
     * Gibt die Figur mit Position als String aus.
     * 
     * @return Figur als String.
     */
	public String toString() {
		return "Dame: " + this.getPosition().toString();
	}

	/**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     */
    public void print() {
		super.print('D');
	}
}
