/**
 * Klasse, die ein Blatt eines Pokerspiels modelliert.
 * 
 * @author Patrick Gustav Blaneck, Felix Racz, Tim Wende
 */
public class Blatt {
    private int[] karten = new int[3];

    /**
     * Konstruktor, der ein neues Blatt mit gegebenen Karten initialisiert.
     * 
     * @throws IllegalArgumentException falls das Array keinem gültigen Blatt entspricht
     * @param karten Array, das ein Blatt modelliert
     */
    public Blatt(int[] karten) {
        if (karten.length > 3) throw new IllegalArgumentException("Array ist zu lang!");
        for (int karte : karten) 
            if (karte < 2 || karte > 14) throw new IllegalArgumentException("Kartenwert an Position " + karte + " ist ungültig!");
        this.karten = karten.clone();
    }

    /**
     * toString()
     * 
     * @return Stringdarstellung des Blattes
     */
    public String toString() {
        return this.karten[0] + ", " + this.karten[1] + ", " + this.karten[2];
    }

    /**
     * Gibt eine Kopie der Karten des aktuellen Blattes zurück.
     * 
     * @return Kopie des Blattes
     */
    public int[] getKarten() {
        return this.karten.clone();
    }
}