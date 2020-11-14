public class Test {
    public static void main(String[] args) {
        Funktion a = (x) -> Math.exp(x) - 4;
        Funktion b = (x) -> Math.log(Math.abs(x+1)) - Math.sin(2 * x) - 0.5;
        Funktion c = (x) -> x * x - Math.sin(x) - 1;
        Funktion d = (x) -> Math.pow(x,4) + Math.pow(x,3) - 5;
        Funktion z = (x) -> x*x - 2;

        Bisektionsverfahren bisektion = new Bisektionsverfahren();
        Sekantenverfahren sekante = new Sekantenverfahren();

        System.out.println("Funktion:   f(x) := exp(x)-4 in (0.0,10.0)");
        System.out.println("  Nullstelle:\t " + bisektion.getNullstelle(a, 0.0, 10.0) + " (Bisektion)");
        System.out.println("  Nullstelle:\t " + sekante.getNullstelle(a, 0.0, 10.0) + " (Sekantenverfahren)");
        System.out.println("");

        System.out.println("Funktion:   f(x) := ln|x+1|-sin(2x)-0.5 in (0.0,10.0)");
        System.out.println("  Nullstelle:\t " + bisektion.getNullstelle(b, 0.0, 10.0) + " (Bisektion)");
        System.out.println("  Nullstelle:\t " + sekante.getNullstelle(b, 0.0, 10.0) + " (Sekantenverfahren)");
        System.out.println("");

        System.out.println("Funktion:   f(x) := x^2-sin(x)-1 in (0.0,10.0)");
        System.out.println("  Nullstelle:\t " + bisektion.getNullstelle(c, 0.0, 10.0) + " (Bisektion)");
        System.out.println("  Nullstelle:\t " + sekante.getNullstelle(c, 0.0, 10.0) + " (Sekantenverfahren)");
        System.out.println("");

        System.out.println("Funktion:   f(x) := x^4+x^3-5 in (0.0,10.0)");
        System.out.println("  Nullstelle:\t " + bisektion.getNullstelle(d, 0.0, 10.0) + " (Bisektion)");
        System.out.println("  Nullstelle:\t " + sekante.getNullstelle(d, 0.0, 10.0) + " (Sekantenverfahren)");
        System.out.println("");

        System.out.println("Funktion:   f(x) := x^2-1");
        System.out.println("  Nullstelle:\t " + bisektion.getNullstelle(z, 0.0, 10.0) + " (Bisektion)");
        System.out.println("  Nullstelle:\t " + sekante.getNullstelle(z, 0.0, 10.0) + " (Sekantenverfahren)");
        System.out.println("");
    }
}
