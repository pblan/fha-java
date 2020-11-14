package homework;

/**
 * Eine Implementierung des Interfaces Rechenoperation, welche die Addition mit
 * einer festgelegten Zahl aufruft.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 * @version 1.0
 */
public class Addition implements Rechenoperation {
	// Atribute
	/** Die Zahl, die bei berechne aufaddiert wird. */
	private double summand;

	/**
	 * Konstrukter fuer die Addition.
	 * 
	 * @param summand Zahl, die bei berechne aufaddiert wird.
	 */
	public Addition(double summand) {
		this.summand = summand;
	}

	/**
	 * Getter fuer den Summanden.
	 * 
	 * @return Summand der in Addition festgehalten ist.
	 */
	public double getSummand() {
		return this.summand;
	}

	/**
	 * Setter fuer den Summanden.
	 * 
	 * @param summand Neuer Summand fuer die Addition.
	 */
	public void setSummand(double summand) {
		this.summand = summand;
	}

	/**
	 * Berechnet die Summe von x und der festgelegten Zahl.
	 * 
	 * @param x Zahl auf die addiert wird.
	 * @return Summe von x und der festgelegten Zahl.
	 */
	public double berechne(double x) {
		return x + summand;
	}
}
