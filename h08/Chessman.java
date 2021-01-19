import java.util.ArrayList;

/**
 * Abstrakte Klasse, die es ermoeglicht eine Schachfigur zu implementieren.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public abstract class Chessman {

    /** Position der Schachfigur */
    private Position pos;

    /** 
     * Erstellt eine neue Schachfigur an einer gegebenen Position.
     * 
     */
    public Chessman(Position pos) {
        this.pos = pos;
    }

    /** 
     * Gibt die Position, an der die Schachfigur steht, zurueck.
     * 
     * @return Position Position der Schachfigur.
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Bewegt die Figur auf die angegebene Position.
     * 
     * @param pos Position, auf die die Figur bewegt werden soll.
     * @throws WrongMoveException falls die Figur nicht auf das Feld bewegt werden kann.
     */
    public void moveTo(Position pos) {
        if (!this.canMoveTo(pos)) {
            throw new WrongMoveException("Die Figur kann nicht auf das angegebene Feld gezogen werden.");
        } else {
            this.pos = pos;
        }
    }

    /**
     * Gibt eine ArrayList mit den moelgichen Zuegen zurueck.
     * 
     * @return ArrayList<Position> Liste mit moeglichen Zuegen.
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Testet, ob eine Figur auf das angegebene Feld bewegt werden kann.
     * 
     * @param pos Position, fuer die getestet werden soll, ob die Figur an die Stelle bewegt werden kann.
     * @return true, falls die Figur zu pos bewegt werden kann, sonst false.
     */
    public boolean canMoveTo(Position pos) {
        for (Position temp : getMoveList()) {
            if (temp.equals(pos)) return true;
        }
        return false;
    }

    /**
     * Platzhalter zum (freiwilligen) Ueberschreiben in den Unterklassen bei dynamischen Klassen.
     * 
     */
    public void print() {};

    /**
     * Gibt eine Schachfigur und ihre moeglichen Zuege in der Konsole aus.
     * 
     * @param c Erster Buchstabe der Schachfigur.
     */
    public void print(char c) {
        System.out.println(this);
        ArrayList<Position> movelist = this.getMoveList();
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                char field = '_';
                if (this.pos.getX() == x && this.pos.getY() == y) {
                    field = c;
                } else {
                    for (Position move : movelist) {
                        if (move.getX() == x && move.getY() == y) {
                            field = '█';
                        }
                    }
                }
                System.out.print("|" + field);
            }
            System.out.println("|");
        }
        System.out.println();
    }
}