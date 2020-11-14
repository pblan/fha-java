import java.util.*;

public class BlattVergleich implements Comparator<Blatt> {
    /**
     * 
     * @param b1
     * @param b2
     * @return -1 => b1 > b2; 0 => b1 = b2; 1 => b1 < b2
     */
    public int compare(Blatt b1, Blatt b2) {
        BlattEigenschaft isDrilling = a -> a[0] == a[1] && a[1] == a[2];
        BlattEigenschaft isPaar = a -> (a[0] == a[1] || a[1] == a[2] || a[0] == a[2]) && !isDrilling.process(a);
        BlattSumme summe = a -> a[0] + a[1] + a[2];
        BlattSumme paarSumme = a -> a[0] == a[1] ? a[0] + a[1] : (a[0] == a[2] ? a[0] + a[2] : a[1] + a[2]);
        BlattErgebnis ergebnis = (a, b) -> a == b ? 0 : (a < b ? -1 : 1);

        int[] b1Cards, b2Cards;
        b1Cards = b1.getKarten();
        b2Cards = b2.getKarten();

        if (isDrilling.process(b1Cards) && isDrilling.process(b2Cards))
            return ergebnis.compare(summe.calc(b1Cards), summe.calc(b2Cards));
        else if (isDrilling.process(b1Cards)) return 1;
        else if (isDrilling.process(b2Cards)) return -1;

        if (isPaar.process(b1Cards) && isPaar.process(b2Cards)) {
            if (ergebnis.compare(paarSumme.calc(b1Cards), paarSumme.calc(b2Cards)) == 0)
                return ergebnis.compare(summe.calc(b1Cards), summe.calc(b2Cards));
            else return ergebnis.compare(paarSumme.calc(b1Cards), paarSumme.calc(b2Cards));
        }
        else if (isPaar.process(b1Cards)) return 1;
        else if (isPaar.process(b2Cards)) return -1;

        return ergebnis.compare(summe.calc(b1Cards), summe.calc(b2Cards));
    }
}
