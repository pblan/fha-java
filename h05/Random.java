/**
 * Implementiert die Strategie zufaellig zu betruegen oder zu kooperieren.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public class Random implements GefangenenStrategie {
	/**
	 * Gibt einen zufaelligen Zug zurueck.
	 * 
	 * @return nachster Spielzug
	 */
	public boolean getNextDecision() {
		return Math.random() < 0.5;
	}

	/**
	 * Tut nichts, da die Strategie nicht von den Entscheidungen des Gegner
	 * abhaengt.
	 * 
	 * @param decision letzter Spielzug des Gegners.
	 */
	public void setOpponentsLastDecision(boolean decision) {
		// DO NOTHING
	}

}
