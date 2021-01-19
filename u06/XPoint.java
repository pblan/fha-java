import java.awt.Point;

public class XPoint extends Point {
    public XPoint() {
        super(0, 0);
    }

    public XPoint(int x, int y) {
        super(x, y);
    }

    public XPoint(Point p) {
        super(p);
    }
    
    //Tauscht die Koordinaten des this-Objekts mit Punkt p
    public void swap(Point p) {
        Point backup = (Point) p.clone();
        p.setLocation(this);
        this.setLocation(backup);
    }

    //Gibt zurueck, ob das this-Objekt auf der durch a und b beschriebenen 
    //Geraden liegt. 
    public boolean isOnLine(Point a, Point b) {
        return ((a.getX() - this.getX()) / b.getX()) == ((a.getY() - this.getY()) / b.getY());
    }

    //Gibt die Koordinate r des Punkts in Polarkoordinaten zurueck (entspricht dem Abstand zum Koordinatenursprung).
    public double getR() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    //Gibt die Koordinate phi des Punkts in Polarkoordinaten (im Bogenmass) zurück. Liegt der Punkt im Koordinatenursprung, wird 0 zurückgegeben.
    public double getPhi() {
        return Math.atan2(this.getY(), this.getX());
    }
}
