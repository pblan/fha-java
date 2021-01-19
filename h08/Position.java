
/**
 * Eine Klasse die eine Position in einem Schachspiel speichert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Position {

    /** Die Koordinaten der Position. */
    private int x;
    private int y;

    /**
     * Konstruktor, der ein neues Positionsobjekt erzeugt.
     * 
     * @param x x-Koordinate der Position.
     * @param y y-Koordinate der Position.
     * @throws WrongPositionException Falls die Position ungueltig ist.
     */
    public Position (int x, int y) {
        if (!isValid(x,y)) {
            throw new WrongPositionException("Ungueltige Position.");
        } else {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Copy-Konstruktor.
     * 
     * @param p Position die kopiert wird.
     */
    public Position(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Getter fuer die x-Koordinate.
     * 
     * @return x-Koordinate des Positionsobjekts.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter fuer die y-Koordinate.
     * 
     * @return y-Koordinate des Positionsobjekts.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Testet, ob this und p die gleiche Position sind. 
     * 
     * @param p Position die mit this verglichen wir.d
     * @return true, falls die Positionen uebereinstimmen, andernfalls false.
     */
    public boolean equals(Position p) {
        return this.x == p.x && this.y == p.y;
    }
    
    /**
     * Gibt zurueck ob, zwei Zahlen eine gueltige Position ergeben wuerden.
     * 
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @return true, falls die x- und y-Koordinate zusammen eine gueltige Positione ergeben.
     */
    public static boolean isValid(int x, int y) {
        return x>0 && x<9 && y>0 && y<9;
    }

    /**
     * Gibt eine Position als String aus.
     * 
     * @return Position als String.
     */
    public String toString() {
        return "(" + this.x + "/" +  this.y + ")";
    }

}
