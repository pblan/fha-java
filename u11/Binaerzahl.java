public class Binaerzahl {
    public static final int MAX_DIGITS = 32;

    public StringBuilder bin;

    public Binaerzahl(int zahl) {
       if (zahl < 0) {
           throw new ArithmeticException("Zahl muss positiv sein.");
       }
       long pot = 1;
       for (int i = 0; i<MAX_DIGITS; i++){
           pot *= 2;
       }
       System.out.println(pot);
       bin = new StringBuilder();
       for (int i = MAX_DIGITS; i>=0; i--){
           if (zahl >= pot) {
               zahl -= pot;
            //    bin.append("1");
               bin.append("1");
           } else {
            //    bin.append("0");
            bin.append("0");
           }
           pot /= 2;
       }
    }

    public String toString() {
        StringBuilder temp = new StringBuilder(bin);
        if (temp.indexOf("1") == -1) {
            return "0";
        } else {
            return temp.delete(0, temp.indexOf("1")).toString();
        }
    }

    private static boolean indexAt(int i, StringBuilder bin) {
        if (i >= bin.length()) {
            throw new ArithmeticException("FUCK THIS SHIT");
        }
        return bin.charAt(i) == '1';
        // Integer a = Integer.MAX_VALUE;
    }

    public void add(Binaerzahl zahl2) {
        StringBuilder res = new StringBuilder();
        int uber = 0;
        int nextUber = 0;
        for (int i = bin.length()-1; i >= 0; i--){
            int add = 0;
            if (indexAt(i, this.bin) ^ indexAt(i, zahl2.bin)) {
                add = 1;
            } else if (indexAt(i, this.bin) && indexAt(i, zahl2.bin)) {
                add = 0;
                nextUber = 1;
            } else {
                add = 0;
            }

            if (add + uber == 2) {
                res.append("1");
                uber = nextUber;
            } else {
                res.append(String.valueOf(add + uber));
                uber = nextUber;
            }
            nextUber = 0;
        }
        System.out.println(res);
    }
}
