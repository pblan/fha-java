import java.util.Arrays;

public class KomplexeZahl {
    private double real;
    private double imaginary;

    public KomplexeZahl(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void addiere(KomplexeZahl z) {
        this.real += z.real;
        this.imaginary += z.imaginary;
    }

    public void multipliziere(KomplexeZahl z) {
        double real = (this.real * z.real) - (this.imaginary * z.imaginary);
        double imaginary = (this.real * z.imaginary) + (z.real * this.imaginary);
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getBetrag() {
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary);
    }

    public String toString() {
        String res = "";
        res += this.real;
        res += this.imaginary < 0.0 ? " - " + (this.imaginary == -1.0 ? "" : -this.imaginary) + "i" : "";
        res += this.imaginary > 0.0 ? " + " + (this.imaginary == 1.0 ? "" : this.imaginary) + "i" : "";
        return res;
    }

    public KomplexeZahl[] getWurzel() {
        double abs, phi, real, imaginary;
        KomplexeZahl[] res = new KomplexeZahl[2];

        if (this.real == 0 && this.imaginary == 0) {
            res[0] = new KomplexeZahl(0.0, 0.0);
            res[1] = new KomplexeZahl(0.0, 0.0);
            return res;
        }

        abs = this.getBetrag();
        phi = Math.atan2(this.imaginary, this.real);
        System.out.println(phi);
        real = Math.sqrt(abs) * Math.cos(phi/2);
        imaginary = Math.sqrt(abs) * Math.sin(phi/2);

        res[0] = new KomplexeZahl(real, imaginary);

        real = Math.sqrt(abs) * Math.cos((phi + 2* Math.PI)/2);
        imaginary = Math.sqrt(abs) * Math.sin((phi + 2* Math.PI)/2);

        res[1] = new KomplexeZahl(real, imaginary);

        return res;
    }

    public KomplexeZahl getSumme(KomplexeZahl z) {
        KomplexeZahl res = new KomplexeZahl(this.real, this.imaginary);
        res.addiere(z);
        return res;
    }

    public KomplexeZahl getProdukt(KomplexeZahl z) {
        KomplexeZahl res = new KomplexeZahl(this.real, this.imaginary);
        res.multipliziere(z);
        return res;
    }

    public static void main(String[] args) {
        KomplexeZahl z = new KomplexeZahl(0,0);     // z := 0
        System.out.println("z = " + z);
        z = new KomplexeZahl(1,0);                  // z := 1
        System.out.println("z = " + z);
        z = new KomplexeZahl(0,1);                  // z := i
        System.out.println("z = " + z);
        z = new KomplexeZahl(-4,0);                 // z := -4
        System.out.println("z = " + z);
        KomplexeZahl[] wurzeln = z.getWurzel();     // => 2i und -2i
        System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
        z = new KomplexeZahl(1,1);                  // z := 1+i
        System.out.println("z = " + z);
        double betrag = z.getBetrag();
        System.out.println("|z| = " + betrag);      // => sqrt(2) = 1.41...
        KomplexeZahl z2 = new KomplexeZahl(2,1);    // z2 := 2+i
        System.out.println("z2 = " + z2);
        z.addiere(z2);
        System.out.println("z nach Addition von z2 = " + z);
        z.multipliziere(z2);
        System.out.println("z nach Multiplikation von z2 = " + z);
        z2 = z.getProdukt(new KomplexeZahl(-1,0));  // z2 := -z
        System.out.println("z2 = " + z2);
        KomplexeZahl summe = z.getSumme(z2);        // z := z - z2 = 0
        System.out.println("summe = " + summe);
    }
}
