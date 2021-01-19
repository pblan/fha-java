/**
 * Ein Interface, dass eine Strategie fuer das Spiel Gefangenendilemma
 * festhaelt.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public interface GefangenenStrategie {
	/**
	 * Diese Methode gibt als Ergebnis die naechste eigene Spielentscheidung
	 * zurueck. true entspricht dabei kooperieren und false betruegen.
	 */
	public boolean getNextDecision();

	/**
	 * In dieser Methode wird dem Spieler der letzte Zug des Gegners mitgeteilt.
	 * true entspricht dabei kooperieren und false betruegen.
	 */
	public void setOpponentsLastDecision(boolean decision);
}
