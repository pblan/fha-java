
import java.util.ArrayList;

/**
 * Eine Ableitung der Chessman Klasse, die einen Bauer implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Pawn extends Chessman {
	/** Bitschalter der festhaelt, ob es der erste Zug des Bauers ist. */
	private boolean unmoved = true;

	/**
     * Erstellt einen neuen Bauern an der Position pos.
     * 
     * @param pos Position des Springers.
     */
	public Pawn(Position pos) {
		super(pos);
	}

	/**
     * Bewegt die Figur auf die angegebene Position.
     * 
     * @param pos Position, auf die die Figur bewegt werden soll.
     * @throws PawnWantsToEvolveException Falls der Bauer am hintersten Feld angekommen ist und verwandelt werden muss.
     */
	public void moveTo(Position pos) {
		super.moveTo(pos);
		this.unmoved = false;
		if (pos.getX() == 1)
			throw new PawnWantsToEvolveException();
	}

	/**
     * Gibt eine ArrayList mit den moeglichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> ret = new ArrayList<>();
		if (Position.isValid(this.getPosition().getX() - 1, this.getPosition().getY()))
			ret.add(new Position(this.getPosition().getX() - 1, this.getPosition().getY()));
		if (this.unmoved)
			ret.add(new Position(this.getPosition().getX() - 2, this.getPosition().getY()));
		return ret;
	}

	/**
     * Gibt die Figur mit Position als String aus.
     * 
     * @return Figur als String.
     */
	public String toString() {
		return "Bauer: " + this.getPosition().toString();
	}

	/**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     */
    public void print() {
		super.print('B');
	}
}
