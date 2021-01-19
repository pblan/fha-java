public class Bisektionsverfahren implements Verfahren {
    public double getNullstelle(Funktion f, double xMin, double xMax) {
        double xMed = (xMin + xMax) / 2;
        double cond = Math.pow(10, -10);
        while ((xMax - xMin) > cond) {
            if (Math.abs(f.getY(xMed)) < cond) break; 
            if (f.getY(xMin) * f.getY(xMed) < 0) xMax = xMed;
            else if (f.getY(xMax) * f.getY(xMed) < 0) xMin = xMed;
            xMed = (xMin + xMax) / 2;
        }
        return xMed;
    }
}
