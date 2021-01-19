import java.awt.Point;

/**
 * @author FinnDriediger
 *
 */
public class XPoint extends Point{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param p
	 */
	public void swap(Point p) {
		Point temp = (Point) p.clone();
		p.setLocation(this);
		this.setLocation(temp);
	}
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isOnLine(Point a, Point b) {
		if(((a.getX() - super.getX())/b.getX()) == ((a.getY() - super.getY())/b.getY())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return
	 */
	public double getR() {
		return Math.sqrt((this.x*this.x) + (this.y*this.y));
	}
	
	/**
	 * @return
	 */
	public double getPhi() {
		return Math.atan2(this.x, this.y); // atan2 ueberprueft die Winkel automatisch auf Richtigkeit
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public XPoint(int x, int y) {
		super(x,y);
	}
	
	/** Default-Konstruktor
	 * 
	 */
	public XPoint() {
		super(0, 0);
	}
	
	/**
	 * @param p
	 */
	public XPoint(Point p) {
		super(p);
	}
	
}
