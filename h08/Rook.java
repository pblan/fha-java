import java.util.ArrayList;

/**
 * Eine Ableitung der Chessman Klasse, die einen Turm implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Rook extends Chessman {

    /**
     * Erstellt einen neuen Turm an der Position pos.
     * 
     * @param pos Position des Springers.
     */
    public Rook(Position pos) {
        super(pos);
    }

    /**
     * Gibt eine ArrayList mit den moeglichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> moves = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            Position tPos1 = new Position(this.getPosition().getX(), i);
            Position tPos2 = new Position(i, this.getPosition().getY());

            if (!tPos1.equals(this.getPosition())) moves.add(tPos1);
            if (!tPos2.equals(this.getPosition())) moves.add(tPos2);
        }

        return moves;
    }

    /**
     * Gibt die Figur mit Position als String aus.
     * 
     * @return Figur als String.
     */
    public String toString() {
        return "Turm: " + this.getPosition().toString();
    }

    /**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     */
    public void print() {
		super.print('T');
	}
}
