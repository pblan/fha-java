
/**
 * Klasse, die die Koordinaten von den Punkten einer Kochkurve berechnen kann.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class KochKurve {
    /**
     * Testfunktion.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        kochKurve(0,500,500,500, 2);
    }

    /**
     * Funktion, die die Eckpunkte einer Kochkurve mit beliebiger Rekursionstiefe in die Konsole schreibt.
     * 
     * @param ax x-Wert des Anfangspunkts der Kochkurve.
     * @param ay y-Wert des Anfangspunkts der Kochkurve.
     * @param bx x-Wert des Endpunkts der Kochkurve.
     * @param by y-Wert des Endpunkts der Kochkurve.
     * @param rek Rekursionstiefe.
     */
    public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
        System.out.print("Rekursionstiefe " + rek + ":");
        KochKurve.kochKurve(new double[] { ax, ay }, new double[] { bx, by }, rek);
        System.out.print(KochKurve.print(new double[] { bx, by }));
    }

    /**
     * Ruft sich selbst rekursiv wieder auf, um die Koordinaten der Punkte einer Kochkurve mit der gewuenschten Rekursionstiefe auszugeben.
     * 
     * @param a Anfangspunkt des zu betrachtenden Bereichs der Kochkurve.
     * @param b Endpunkt des zu betrachtenden Bereichs der Kochkurve.
     * @param rek Rekursionstiefe.
     */
    private static void kochKurve(double[] a, double[] b, int rek) {
        if (rek != 0) {
            // Laenge eines Streckenabschnittes der Kochkurve.
            double lx = (b[0] - a[0]) / 3;
            double ly = (b[1] - a[1]) / 3;
            double[] mxy = KochKurve.getCorner(a, b, lx, ly);
            // x und y Koordinaten der Punkte der Kochkurve (x[i], y[i]) in einem Array festhalten, zum rekursiven Aufruf der Funktion kockKurve.
            double[] x = new double[] { a[0] + lx, mxy[0], a[0] + lx * 2, b[0] };
            double[] y = new double[] { a[1] + ly, mxy[1], a[1] + ly * 2, b[1] };
            double[] temp = new double[] { a[0], a[1] };
            // Mehrfaches rekursives aufrufen der Funktion kochKurve.
            for (int i = 0; i < x.length; i++) {
                KochKurve.kochKurve(temp, new double[] { x[i], y[i] }, rek - 1);
                temp = new double[] { x[i], y[i] };
            }
        } else {
            System.out.print(KochKurve.print(a));
        }
    }

    /**
     * Gibt Eine Koordinatenpaar im gewuenschten Format aus.
     * 
     * @param k Koordinatenpaar.
     * @return String des Koordinatenpaars.
     */
    private static String print(double[] k) {
        return String.format(" (%.1f/%.1f)", k[0], k[1]).replace(",0", "");
        // Die Ausgabe ist anders als die auf dem Aufgabenblatt, da String.format rundet, die Musterausgabe allerdings nicht.
    }

    /**
     * Berechnet die Koordinaten des Eckpunktes des Dreiecks in der Kochkurve.
     * 
     * @param a Array mit x- und y-Koordinate des Anfangspunktes der Kochkurve.
     * @param b Array mit x- und y-Koordinate des Endpunktes der Kochkurve.
     * @param lx x-Komponente der Laenge eines Streckenabschnittes der Kochkurve
     * @param ly y-Komponente der Laenge eines Streckenabschnittes der Kochkurve
     * @return Array mit x- und y-Koordinate des Eckpunktes des Dreiecks in der Kochkurve.
     */
    private static double[] getCorner(double[] a, double[] b, double lx, double ly) {
        // Berechnet die Koordinaten des Eckpunktes komponentenweise.
        double x = a[0] + lx * 3 / 2 + ly * Math.sqrt(3) / 2;
        double y = a[1] + ly * 3 / 2 - lx * Math.sqrt(3) / 2;
        return new double[] { x, y };
    }
}