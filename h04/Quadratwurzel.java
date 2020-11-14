package homework;

/**
 * Eine Implementierung des Interfaces Rechenoperation, welche die Wurzel als
 * Operation bereitstellt.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 * @version 1.0
 */
public class Quadratwurzel implements Rechenoperation {
	// Attribute
	/** Wurzelexponent */
	private double wExponent;

	/**
	 * Konstruktor der einen beliebigen Wurzelexponenten setzt.
	 * 
	 * @param wExponent Wurzelexponent der benutzt werden soll.
	 */
	public Quadratwurzel(double wExponent) {
		this.wExponent = wExponent;
	}

	/**
	 * Default Konstruktor der den Wurzelexponenten auf 2 festsetzt.
	 * 
	 */
	public Quadratwurzel() {
		this(2);
	}

	/**
	 * Getter fuer den Wurzelexponenten.
	 * 
	 * @return Aktueller Wurzelexponent.
	 */
	public double getWExponent() {
		return this.wExponent;
	}

	/**
	 * Setter fuer den Wurzelexponenten.
	 * 
	 * @param wExponent Neuer Wurzelexponent.
	 */
	public void setWExponent(double wExponent) {
		this.wExponent = wExponent;
	}

	/**
	 * Berechnet die Wurzel von der uebergebenen Zahl mit dem gespeicherten
	 * Wurzelexponenten.
	 * 
	 * @throws ArithmeticException wenn die uebergebene Zahl negativ ist.
	 * @param x Zahl aus der die Quadratwurzel gezogen wird.
	 * @return Quadratwurzel der uebergebenen Zahl.
	 */
	public double berechne(double x) {
		if (x < 0) {
			throw new ArithmeticException("Die Zahl darf nicht negativ sein.");
		}
		return Math.pow(x, 1 / this.wExponent);
	}
}
