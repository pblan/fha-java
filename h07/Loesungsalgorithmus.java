/**
 * Interface für Lösungsalgorithmen des Schiebepuzzles
 */
public interface Loesungsalgorithmus {
    /**
     * Methode, welche das Schiebepuzzle nach einem bestimmten Algorithmus löst.
     * @param sp zu lösendes Schiebepuzzle
     * @return Anzahl, der zur Lösung gebrauchten Schritte
     */
    public int loese(Schiebepuzzle sp);
}
