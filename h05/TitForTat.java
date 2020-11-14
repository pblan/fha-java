/**
 * Eine Klasse, die das Interface GefangenenStrategie mit der TitForTat
 * Strategie implementiert.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class TitForTat implements GefangenenStrategie {
	// Attribute
	/** Speichert die Entscheidung des Gegners vom letzten Zug */
	private boolean opponentsLastDecision = true;

	/**
	 * Gibt den naechsten Spielzug zurueck.
	 * 
	 * @return naechster Spielzug.
	 */
	public boolean getNextDecision() {
		return this.opponentsLastDecision;
	}

	/**
	 * Speichert den letzten Zug des Gegners.
	 * 
	 * @param decision letzter Spielzug des Gegners.
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentsLastDecision = decision;
	}
}
