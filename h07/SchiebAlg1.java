<<<<<<< HEAD

import java.util.ArrayList;
import java.util.Random;

/**
 * Eine Implementierung des Interfaces Loesungsalgorithmus.
 * 
 * @author TestSubject009871
 *
 */
public class SchiebAlg1 implements Loesungsalgorithmus {

	@Override
	/**
	 * Schiebt so lange ein zufaelliges Feld, bis die 1 an der richtigen Stelle steht.
	 * 
	 */
	public void loese(Schiebepuzzle spiel) {
		int[][] spielfeld = spiel.getSpielfeld();

		ArrayList<Integer> possibilities = getPossibilities(spiel);
		Random rnd = new Random();

		while (spielfeld[0][0] != 1) {
			spiel.schiebe(possibilities.get(rnd.nextInt(possibilities.size())).intValue());
			spielfeld = spiel.getSpielfeld();
			possibilities = getPossibilities(spiel);
		}
	}
	/**
	 * Gibt eine Arrayliste mit allen moeglichen Zuegen zurueck.
	 * 
	 * @param spiel Ein Schiebepuzzle
	 * @return Arrayliste mit Zahlen, die verschoben werden koennen.
	 */
	private ArrayList<Integer> getPossibilities(Schiebepuzzle spiel) {
		int[] empty = spiel.getEmptyTileIndex();
		int[][] spielfeld = spiel.getSpielfeld();

		ArrayList<Integer> possibilities = new ArrayList<>();

		if (empty[0] > 0) possibilities.add(spielfeld[empty[0] - 1][empty[1]]);
		if (empty[0] < 3) possibilities.add(spielfeld[empty[0] + 1][empty[1]]);
		if (empty[1] > 0) possibilities.add(spielfeld[empty[0]][empty[1] - 1]);
		if (empty[1] < 3) possibilities.add(spielfeld[empty[0]][empty[1] + 1]);
		

		return possibilities;

	}

=======
/**
 * Lösungsalgorithmus der das Schiebepuzzle löst, indem er zufällig Plättchen verschiebt
 */
public class SchiebAlg1 implements Loesungsalgorithmus {
    /**
     * Schiebt solange zufällig bis das Plättchen mit der Nummer 1 auf der richtigen Position ist
     */
    public int loese(Schiebepuzzle sp){
        int nrSteps=0;
        while(2!=sp.getFeld()[0].x+sp.getFeld()[0].y){    
            nrSteps++;
            sp.schiebe((int)sp.getLegalMoves().get((int)Math.floor(sp.getLegalMoves().size()*Math.random())));
        }
        return nrSteps;
    }
>>>>>>> 16149a3f418eb74432bd57c8e0747541722fe108
}
