import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class NewArrayList extends ArrayList<Object> {
    /*
    public void add(String x) {
        if (x.matches("[0-9]+")) super.add(Integer.valueOf(x));
        else if (x.matches("[0-9]*.[0-9]+")) super.add(Double.valueOf(x));
        else super.add(x);
    }
    */

    public void add(String x) {
        Scanner sc = new Scanner(x);
        sc.useLocale(Locale.US);

        if (sc.hasNextInt()) super.add(Integer.valueOf(x));
        else if (sc.hasNextDouble()) super.add(Double.valueOf(x));
        else super.add(x);
        
        sc.close();
    }

    public void add(int x) {
        super.add(Integer.valueOf(x));
    }

    public void add(double x) {
        super.add(Double.valueOf(x));
    }

    public ArrayList<Integer> getIntegers() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Integer) res.add((Integer) this.get(i));
        }
        return res;
    }

    public ArrayList<Double> getDoubles() {
        ArrayList<Double> res = new ArrayList<Double>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) instanceof Double) res.add((Double) this.get(i));
        }
        return res;
    }

    public ArrayList<String> getStrings() {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < this.size(); i++) {
            if (!( (this.get(i) instanceof Integer) || (this.get(i) instanceof Double) || (this.get(i) instanceof String) )) 
                throw new WrongElementException(i); 
            res.add(this.get(i).toString());
        }
        return res;
    }
}
