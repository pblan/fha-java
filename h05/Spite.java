/**
 * Implementiert den Spite als Strategie fuer das GefangenenStrategie Interface,
 * wurde der Spite einmal betrogen betruegt er immer.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Spite implements GefangenenStrategie {
	// Attribute
	/** Variable die festhaelt, ob der spite schon einmal betrogen wurde. */
	private boolean trust = true;

	/**
	 * Gibt den naechsten Spielzug zurueck. Sobald der pavlov einmal betruegt wurde,
	 * betruegt der Spite immer. Davor kooperiert er.
	 * 
	 * @return naechster Spielzug.
	 */
	public boolean getNextDecision() {
		return trust;
	}

	/**
	 * Ueberprueft nur ob der Gegenspieler betruegt, betruegt dieser wechselt der
	 * spite darauf immer zu betruegen.
	 * 
	 * @param decision Entscheidung des Gegners.
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.trust &= decision;
	}
}
