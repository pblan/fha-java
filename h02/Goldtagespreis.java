package goldpreis;
/**
 * Hilfsklasse zur Klasse Goldpreis, die Datum und Preis speichert. 
 * 
 * @version 1.0.0.2
 * @author Patrick Blaneck, Tim Wende, Felix Racz
 */
public class Goldtagespreis {
	/** public Datum zu einem Goldtagespreis */
	public String datum;
	/** public Preis zu einem Goldtagespreis */
	public double preis;
	
	/**
	 * Einfacher Konstruktor, der aus dem angegebenen Datum und Preis ein Goldtagespreisobjekt erstellt.
	 * 
	 * @param datum Datum
	 * @param preis	Preis
	 */
	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}
	
	public String toString() {
		return this.datum + "\t" + String.format("%,.2f", this.preis);
	}
}
