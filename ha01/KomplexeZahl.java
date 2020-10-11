import java.util.Arrays;

/**
 * Describes a complex number z with it's corresponding real and imaginary parts
 * Handles addition, multiplication, square root, absolute value
 */
public class KomplexeZahl {
    private double real;
    private double imaginary;

    /**
     * Creates a new KomplexeZahl
     * @param real
     * @param imaginary
     */
    public KomplexeZahl(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * 
     * @return real part of current KomplexeZahl (real value)
     */
    public double getReal() {
        return this.real;
    }

    /**
     * 
     * @param real part to set (real value)
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * 
     * @return imaginary part of current KomplexeZahl (real value)
     */
    public double getImaginary() {
        return this.imaginary;
    }

    /**
     * 
     * @param imaginary part to set (real value)
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * Adds a given KomplexeZahl onto the current KomplexeZahl
     * @param KomplexeZahl to be added
     */
    public void addiere(KomplexeZahl z) {
        this.real += z.real;
        this.imaginary += z.imaginary;
    }

    /**
     * Multiplies a given KomplexeZahl onto the current KomplexeZahl
     * z * z' = (x + iy) * (x' + iy') = (xx' - yy') + i(xy' - x'y)
     * @param KomplexeZahl to be multiplied 
     */
    public void multipliziere(KomplexeZahl z) {
        double real = (this.real * z.real) - (this.imaginary * z.imaginary); 
        double imaginary = (this.real * z.imaginary) + (z.real * this.imaginary);
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Returns absolute value of current KomplexeZahl
     * z := x + iy => abs(z) = sqrt(x^2 + y^2)
     * @return absolute value of current KomplexeZahl
     */
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

    /**
     * Returns both square roots of the current KomplexeZahl
     * Returns 0 iff current KomplexeZahl equals 0
     * @return array containing the two square roots of current KomplexeZahl
     */
    public KomplexeZahl[] getWurzel() {
        double abs, phi, real, imaginary;
        KomplexeZahl[] res = new KomplexeZahl[2];

        if (this.real == 0 && this.imaginary == 0) {
            res[0] = new KomplexeZahl(0.0, 0.0);
            res[1] = new KomplexeZahl(0.0, 0.0);
            return res;
        }
                                                                        // z:= x + iy; z1 := sqrt(z); z2 := conjugated z1
        abs = this.getBetrag();                                         // r := abs(z)
        phi = Math.atan2(this.imaginary, this.real);                    // phi := arc length of z
        real = Math.sqrt(abs) * Math.cos(phi/2);                        // R(z1) = sqrt(r) * cos(phi/2) <= Moivre for k=0
        imaginary = Math.sqrt(abs) * Math.sin(phi/2);                   // I(z1) = sqrt(r) * sin(phi/2) <= Moivre for k=0

        res[0] = new KomplexeZahl(real, imaginary);                     // res << z1

        real = Math.sqrt(abs) * Math.cos((phi + 2* Math.PI)/2);         // R(z2) = sqrt(r) * cos((phi + 2pi)/2) <= Moivre for k=1
        imaginary = Math.sqrt(abs) * Math.sin((phi + 2* Math.PI)/2);    // I(z2) = sqrt(r) * sin((phi + 2pi)/2) <= Moivre for k=1

        res[1] = new KomplexeZahl(real, imaginary);                     // res << z2

        return res;
    }

    /**
     * Returns new KomplexeZahl which is the sum of current KomplexeZahl and given KomplexeZahl
     * @param KomplexeZahl to be added
     * @return sum of current KomplexeZahl and given KomplexeZahl
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {
        KomplexeZahl res = new KomplexeZahl(this.real, this.imaginary);
        res.addiere(z);
        return res;
    }

    /**
     * Returns new KomplexeZahl which is the product of current KomplexeZahl and given KomplexeZahl
     * @param KomplexeZahl to be multiplied with
     * @return product of current KomplexeZahl and given KomplexeZahl
     * */
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
