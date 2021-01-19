/**
<<<<<<< HEAD
 * Interface fuer einen Loesungsalgorithmus
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public interface Loesungsalgorithmus {
	/**
	 * Loest ein uebergebenes Spiel.
	 * 
	 * @param spiel das Spiel.
	 */
	public void loese(Schiebepuzzle spiel);
=======
 * Interface für Lösungsalgorithmen des Schiebepuzzles
 */
public interface Loesungsalgorithmus {
    /**
     * Methode, welche das Schiebepuzzle nach einem bestimmten Algorithmus löst.
     * @param sp zu lösendes Schiebepuzzle
     * @return Anzahl, der zur Lösung gebrauchten Schritte
     */
    public int loese(Schiebepuzzle sp);
>>>>>>> 16149a3f418eb74432bd57c8e0747541722fe108
}
