/**
 * Eine Klasse, die es ermoeglicht zwei Spieler, die eine Strategie des Interfaces
 * GefangenenStrategie implementieren, gegeneinander spielen zu lassen.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class GefangenenDilemma {
	// Attribute
	/** die zwei Spieler */
	private GefangenenStrategie player1;
	private GefangenenStrategie player2;

	public GefangenenDilemma(GefangenenStrategie player1, GefangenenStrategie player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * Methode, die genau n Runden spielt.
	 * 
	 * @param n Anzahl der Runden.
	 */
	public void spiele(int n) {
		int points[] = new int[2];
		for (int i = 0; i < n; i++) {
			boolean player1Dec = this.player1.getNextDecision();
			boolean player2Dec = this.player2.getNextDecision();

			points[0] += player1Dec == player2Dec ? (player1Dec ? 2 : 4) : player1Dec ? 6 : 1;
			points[1] += player1Dec == player2Dec ? (player2Dec ? 2 : 4) : player2Dec ? 6 : 1;

			this.player1.setOpponentsLastDecision(player2Dec);
			this.player2.setOpponentsLastDecision(player1Dec);
		}
		System.out.println("Spieler 1 hat: " + points[0] + " Punkte");
		System.out.println("Spieler 2 hat: " + points[1] + " Punkte");
		System.out.println("Damit gewinnt " + (points[0] > points[1] ? "Spieler 2!" : points[0] < points[1] ? "Spieler 1!" : "niemand. :("));
	}
}
