public class Pair<T> {
    
    private T data1;
    private T data2;

    Pair(T data1, T data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public T get1() {
        return this.data1;
    }

    public T get2() {
        return this.data2;
    }

    public void set1(T data) { 
        this.data1 = data;
    }

    public void set2(T data) { 
        this.data2 = data;
    }

    public String toString() {
        return this.data1.toString() + this.data2.toString();
    }

    public boolean equals(Object z) {
        if (!(z instanceof Pair)) {
            return false;
        } else {
            Pair<?> t = (Pair<?>) z;
            return this.data1.equals(t.get1()) && this.data2.equals(t.get2());

        }

        // try {
        //     z = (Tuple<T, U) z;
        // } catch (ClassCastException) {

        // }
    }

}
