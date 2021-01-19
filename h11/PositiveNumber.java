import java.math.BigInteger;
/**
 * Eine Klasse die eine Positive Zahl als int speichert.
 * Diese kann man mithilfe von String die eine beliebige Basis zwischen 2 und 32 hat besetzt werden.
 * Die Ziffern sind dann nach der 9 die Zeichen A-V.
 * Die Klasse kann außerdem die Zahl auch in beliebiger Basis (2-32) zurueckgeben.
 * 
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class PositiveNumber {
    // Der Wert als Integer (kann recht einfach durch BigInteger ersetzt werden.)
    private int value = 0;

    /**
     * Setzt die Zahl auf den angegeben String zur Basis 10.
     * 
     * @throws NumberFormatException falls ungueltige Ziffern enthalten sind.
     * @throws ArithmeticException falls der Wert groesser als Integer,.MAX_VALUE waere.
     * @param s String der Zahl
     */
    public void setDecimal(String s) {
        this.value = getBaseNNumber(s, 10);
    }

    /**
     * Setzt die Zahl auf den angegeben String zur Basis 16.
     * 
     * @throws NumberFormatException falls ungueltige Ziffern enthalten sind.
     * @throws ArithmeticException falls der Wert groesser als Integer,.MAX_VALUE waere.
     * @param s String der Zahl
     */
    public void setHexadecimal(String s) {
        this.value = getBaseNNumber(s, 16);
    }

    /**
     * Setzt die Zahl auf den angegeben String zur Basis 2.
     * 
     * @throws NumberFormatException falls ungueltige Ziffern enthalten sind.
     * @throws ArithmeticException falls der Wert groesser als Integer,.MAX_VALUE waere.
     * @param s String der Zahl
     */
    public void setBinary(String s) {
        this.value = getBaseNNumber(s, 2);
    }

    /**
     * Setzt die Zahl auf den angegeben String zur angegeben Basis.
     * 
     * @throws NumberFormatException falls ungueltige Ziffern enthalten sind.
     * @throws ArithmeticException falls der Wert groesser als Integer,.MAX_VALUE waere.
     * @throws IllegalArgumentException falls die Basis ungueltig ist (nicht zwischen 2 und 32).
     * @param s String der Zahl
     * @param base die Basis
     */
    public void setBaseN(String s, int base) {
        if (base > 32 || base < 2) {
            throw new IllegalArgumentException("Base must be smaller than or equal to 32 and larger than 1.");
        }
        this.value = getBaseNNumber(s, base);
    }

    /**
     * Gibt die Zahl als String zur Basis 10 zurueck.
     * 
     * @return String der Zahl
     */
    public String getDecimal() {
        return getBaseNString(this.value, 10);
    }

    /**
     * Gibt die Zahl als String zur Basis 16 zurueck.
     * 
     * @return String der Zahl
     */
    public String getHexadecimal() {
        return getBaseNString(this.value, 16);
    }

    /**
     * Gibt die Zahl als String zur Basis 2 zurueck.
     * 
     * @return String der Zahl
     */
    public String getBinary() {
        return getBaseNString(this.value, 2);
    }

    /**
     * Gibt die Zahl als String zur angegebenen Basis zurueck.
     * 
     * @throws IllegalArgumentException falls die Basis ungueltig ist (nicht zwischen 2 und 32).
     * @return String der Zahl
     */
    public String getBaseN(int base) {
        if (base > 32 || base < 2) {
            throw new IllegalArgumentException("Base must be smaller than or equal to 32 and larger than 1.");
        }
        return getBaseNString(this.value, base);
    }

    /**
     * Interne Funktion um eine Zahl in einen String zu wandeln.
     * 
     * @throws IllegalArgumentException falls die Basis ungueltig ist (nicht zwischen 2 und 32).
     * @throws NumberFormatException falls intern irgendwas kaputt geht
     * @param number Zahl die zum String gewandelt wird.
     * @param base Basis in der der String sein soll
     * @return String Zahl als String zur angegebenen Basis
     */
    private static String getBaseNString(int number, int base) {
        if (base > 32 || base < 2) {
            throw new IllegalArgumentException("Base must be smaller than or equal to 32 and larger than 1.");
        }
        BigInteger Bnumber = BigInteger.valueOf(number);
        BigInteger Bbase = BigInteger.valueOf(base);
        StringBuilder ret = new StringBuilder();
        while (Bnumber.compareTo(BigInteger.ZERO) == 1) {
            ret.append(getChar(Bnumber.mod(Bbase).intValue()));
            Bnumber = Bnumber.divide(Bbase);
        }
        if (ret.length() == 0) { 
            ret.append(0);
        } 
        return ret.reverse().toString();
    }

    /**
     * Interne Funktion um einen String in eine ein int (oder BigInteger) zu wandeln.
     * 
     * @throws ArithmeticException Falls der Wert nicht im int Bereich liegt.
     * @param number Zahl als String
     * @param base Basis
     * @return Zahl als int
     */
    public static int getBaseNNumber(String number, int base) {
        BigInteger pot = BigInteger.ONE;
        BigInteger res = BigInteger.ZERO;
        BigInteger Bbase = BigInteger.valueOf(base);
        number = number.toUpperCase();
        for (int i = number.length()-1; i >= 0; i--) {
            char ch = number.charAt(i);
            if (getInt(ch) >= base) {
                throw new NumberFormatException("Unknown Character '" + ch + "' for base " + base);
            }
            res = res.add(pot.multiply(BigInteger.valueOf(getInt(ch))));
            pot = pot.multiply(Bbase);
        }
        return res.intValueExact();
    }
    
    /**
     * Interne Funktion, um aus einem int den zugehoerigen char zu machen
     * 
     * @throws NumberFormatException Wenn der int der konvertiert wird nicht im gueltigen Bereich liegt (0-31).
     * @param n int der gewandelt werden soll
     * @return char Ziffer die zum int gehoert.
     */
    private static char getChar(int n){
        if (n < 0 || n > 31) {
            throw new NumberFormatException("Can only convert ints from 0 to 31 to char");
        }
        return (char) ((n > 9) ? (n - 10 + 'A') : ( n + '0'));
    }

    /**
     * Interne Funktion, um aus char zu int zu konvertieren.
     * 
     * @throws NumberFormatException Falls das uebergebene Zeichen ungueltig ist.
     * @param ch char der umgewandelt werden soll.
     * @return int Wert zum uebergebenen char.
     */
    private static int getInt(char ch) {
        if (Character.isDigit(ch)) {
            return ch - '0';
        } else if (ch >= 'A' && ch <= 'V') {
            return ch - 'A' + 10;
        } else {
            throw new NumberFormatException("Can only convert digits and letters from A-V");
        }
    }
}