package homework;

/**
 * Eine Implementierung des Interfaces Rechenoperation, welche das Potenzieren
 * als Operation bereitstellt.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 * @version 1.0
 */
public class Quadrat implements Rechenoperation {
	// Attribute
	/** Exponent */
	double exponent;

	/**
	 * Konstruktor der einen beliebigen reellen Exponenten setzt.
	 * 
	 * @param exponent Exponent der beim Potenzieren benutzt werden soll.
	 */
	public Quadrat(double exponent) {
		this.exponent = exponent;
	}

	/**
	 * Default Konstruktor, der den Exponenten auf 2 festlegt.
	 * 
	 */
	public Quadrat() {
		this(2);
	}

	/**
	 * Getter fuer den Exponenten.
	 * 
	 * @return Aktueller Exponent.
	 */
	public double getExponent() {
		return this.exponent;
	}

	/**
	 * Setter fuer den Exponenten.
	 * 
	 * @param exponent Neuer Exponent.
	 */
	public void setExponent(double exponent) {
		this.exponent = exponent;
	}

	/**
	 * Berechnet die Potenz von der uebergebenen Zahl.
	 * 
	 * @param x Zahl, die potenziert wird.
	 */
	public double berechne(double x) {
		return Math.pow(x, this.exponent);
	}
}
