public class Tuple<T,U> {
    private T data1;
    private U data2;

    Tuple(T data1, U data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public T get1() {
        return this.data1;
    }

    public U get2() {
        return this.data2;
    }

    public void set1(T data) { 
        this.data1 = data;
    }

    public void set2(U data) { 
        this.data2 = data;
    }

    public String toString() {
        return this.data1.toString() + this.data2.toString();
    }

    public boolean equals(Object z) {
        if (!(z instanceof Tuple)) {
            return false;
        } else {
            Tuple<?, ?> t = (Tuple<?, ?>) z;
            return this.data1.equals(t.get1()) && this.data2.equals(t.get2());

        }

        // try {
        //     z = (Tuple<T, U) z;
        // } catch (ClassCastException) {

        // }
    }
}
