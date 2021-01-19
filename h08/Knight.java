import java.util.ArrayList;

/**
 * Eine Ableitung der Chessman Klasse, die einen Springer implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Knight extends Chessman {
    /**
     * Erstellt einen neuen Springer an der Position pos.
     * 
     * @param pos Position des Springers.
     */
    public Knight(Position pos) {
        super(pos);
    }
    
    /**
     * Gibt eine ArrayList mit den moeglichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> ret = new ArrayList<>();
		int[] longarray = new int[] { -2, 2 };
		int[] shortarray = new int[] { -1, 1 };
		for (int longint : longarray) {
			for (int shortint : shortarray) {
				if (Position.isValid(this.getPosition().getX() + longint, this.getPosition().getY() + shortint))
					ret.add(new Position(this.getPosition().getX() + longint, this.getPosition().getY() + shortint));
				if (Position.isValid(this.getPosition().getX() + shortint, this.getPosition().getY() + longint))
					ret.add(new Position(this.getPosition().getX() + shortint, this.getPosition().getY() + longint));
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
        return "Springer: " + this.getPosition().toString();
    }
    
    /**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     */
    public void print() {
		super.print('S');
	}

}
