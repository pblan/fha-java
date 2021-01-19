/**
 * Implementiert die PerKind Strategie fuer das Interface GefangenenStrategie.
 * Die Strategie schreibt vor, periodisch das Pattern kooperieren, kooperieren,
 * verraten zu spielen.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class PerKind implements GefangenenStrategie {
	// Attribute
	/** Zaehlvariable, um die PerKind Strategie zu realisieren. */
	int counter = 0;

	/**
	 * Gibt den naechsten Spielzug zurueck. Mit der perkind Strategie wird
	 * periodisch das Pattern kooperieren, kooperieren, verraten gespielt.
	 * 
	 * @return naechster Spielzug
	 */
	public boolean getNextDecision() {
		return this.counter != 2;
	}

	/**
	 * Da die perkind Strategie nicht von den Zuegen des Gegners abhaengt wird nur
	 * der Zaehler erhoeht.
	 * 
	 * @param decision der letzte Spielzug des Gegners.
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.counter = (this.counter + 1) % 3;
	}
}
