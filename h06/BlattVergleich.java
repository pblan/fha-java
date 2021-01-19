import java.util.*;

/**
 * Klasse, die Comparator<Blatt> implementiert und ein gewinnendes Blatt nach folgenden Regeln ermittelt:
 * - Drilling schlägt Paar, Paar schlägt komplett unterschiedliche Karten.
 * - Bei 2 Drillingen bzw. Paaren zählt das mit dem höheren Wert.
 * - Bei 2 Paaren mit gleichem Wert zählt die 3. Karte.
 * - Bei komplett unterschiedlichen Karten zählt die Summe der drei Karten. 
 * 
 * @author Patrick Gustav Blaneck, Felix Racz, Tim Wende
 */
public class BlattVergleich implements Comparator<Blatt> {

    /**
     * Gibt nach folgenden Regeln den Gewinner aus:
     * - Drilling schlägt Paar, Paar schlägt komplett unterschiedliche Karten.
     * - Bei 2 Drillingen bzw. Paaren zählt das mit dem höheren Wert.
     * - Bei 2 Paaren mit gleichem Wert zählt die 3. Karte.
     * - Bei komplett unterschiedlichen Karten zählt die Summe der drei Karten. 

     * @param b1 Blatt von Spieler 1
     * @param b2 Blatt von Spieler 2
     * @return int > 0: Spieler 1 gewinnt, int < 0: Spieler 2 gewinnt, 0: unentschieden
     */
    @Override
    public int compare(Blatt b1, Blatt b2) {
        int[] b1Karten, b2Karten;
        b1Karten = b1.getKarten();
        b2Karten = b2.getKarten();

        if (isDrilling(b1Karten) && isDrilling(b2Karten))
            return Integer.compare(b1Karten[0], b2Karten[0]);
        else if (isDrilling(b1Karten)) return 1;
        else if (isDrilling(b2Karten)) return -1;

        if (isPaar(b1Karten) && isPaar(b2Karten)) {
            if (Integer.compare(getPaarWert(b1Karten), getPaarWert(b2Karten)) == 0) // Paarsummen gleich => Gesamtsummen entscheidend
                return Integer.compare(getSumme(b1Karten), getSumme(b2Karten));
            return Integer.compare(getPaarWert(b1Karten), getPaarWert(b2Karten));
        }
        else if (isPaar(b1Karten)) return 1;
        else if (isPaar(b2Karten)) return -1;

        return Integer.compare(getSumme(b1Karten), getSumme(b2Karten));
    }

    /**
     * Gibt zurück, ob ein Blatt ein Drilling ist.
     * 
     * @param a Array, das ein Blatt modelliert
     * @return false: ist kein Drilling, true: ist Drilling
     */
    public boolean isDrilling(int[] a) {
        return a[0] == a[1] && a[1] == a[2];
    }

    /**
     * Gibt zurück, ob ein Blatt ein Paar enthält und kein Drilling ist.
     * 
     * @param a Array, das ein Blatt modelliert
     * @return false: enthält kein Paar oder ist Drilling, true: enthält Paar
     */
    public boolean isPaar(int[] a) {
        return (a[0] == a[1] || a[1] == a[2] || a[0] == a[2]) && !isDrilling(a);
    }

    /**
     * Gibt die Summe der Kartenwerte zurück.
     * 
     * @param a Array, das ein Blatt modelliert
     * @return Summe des Arrays
     */
    public int getSumme(int[] a) {
        return a[0] + a[1] + a[2];
    }

    /**
     * Gibt die Summe der Kartenwerte des Paares zurück.
     * 
     * @param a Array, das ein Blatt modelliert
     * @return -1: Blatt hat kein Paar, sonst: Summe der zwei gleichen Elemente
     */
    public int getPaarWert(int[] a) {
        return (a[0] == a[1] || a[0] == a[2]) ? a[0] : (a[1] == a[2] ? a[1] : -1);
    }
}