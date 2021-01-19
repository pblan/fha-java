/**
 * Implementiert die Strategie des Pavlov fuer das GefangenenStrategie
 * Interface. Der Pavlov kooperiert, wenn beide Spieler in der vorherigen Runde
 * gleich gehandelt haben (\Oxfored_Comma), und verraet, wenn dies nicht der
 * Fall ist.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Pavlov implements GefangenenStrategie {
	// Attribute
	/** Variablen zum Merken des naechsten Zugs. */
	private boolean nextDecision = true;

	/**
	 * Gibt den naechsten Spielzug zurueck. Der Pavlov kooperiert, wenn beide
	 * Spieler in der vorherigen Runde gleich gehandelt haben und verraet wenn dies
	 * nicht der Fall ist.
	 * 
	 * @return naechster Spielzug.
	 */
	public boolean getNextDecision() {
		return nextDecision;
	}

	/**
	 * Liest den letzten Spielzug des Gegners ein und setzt daraufhin den eigenen
	 * naechsten Zug.
	 * 
	 * @param decision Spielzug des Gegenspielers.
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.nextDecision = !(decision ^ nextDecision);
	}

}
