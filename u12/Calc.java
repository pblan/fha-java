public class Calc {
    public static Tuple<Double, Integer> getMax(double[] arr) {
        double max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return new Tuple<Double, Integer>(max, maxIndex);
    }

    public static int fibonacci(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        Pair<Integer> fibo = new Pair<>(1,1) ;
        for (int i = 2; i < n; i++) {
            int fir = fibo.get1();
            int sec = fibo.get2();
            fibo.set1(fir+sec);
            fibo.set2(fir);
        }
        return fibo.get1();
    }

    public static int fibonacci2(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        int fir = 1;
        int sec = 1;
        for (long i = 2; i < n; i++) {
            int temp = fir;
            fir = fir + sec;
            sec = temp;
        }
        return fir;
    }

    public static int fibonacci3(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        int fir = 1;
        int sec = 1;
        long iters = 2;

        int newFir;
        int newSec;
        while (true) {
            newSec = fir*(fir+2*sec);
            newFir = fir*fir + (fir+sec)*(fir+sec);
            iters = 2*iters + 1;
            fir = newFir;
            sec = newSec;
            if (2*iters + 1 > n) {
                break;
            }
        }
        for (long i = iters; i < n; i++) {
            int temp = fir;
            fir = fir + sec;
            sec = temp;
        }
        return fir;
    }

    public static int fibonacci2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        int fir = 1;
        int sec = 1;
        for (int i = 2; i < n; i++) {
            int temp = fir;
            fir = fir + sec;
            sec = temp;
        }
        return fir;
    }

    public static int fibonacci3(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        int fir = 1;
        int sec = 1;
        int iters = 2;

        int newFir;
        int newSec;

        while (true) {
            if (2*iters + 1 > n) {
                break;
            }
            newSec = fir*(fir+2*sec);
            newFir = fir*fir + (fir+sec)*(fir+sec);
            iters = 2*iters + 1;
            fir = newFir;
            sec = newSec;

        }
        for (int i = iters; i < n; i++) {
            int temp = fir;
            fir = fir + sec;
            sec = temp;
        }
        return fir;
    }

    public static int[] fibonacci4(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be larger than 0.");
        }
        int fir = 1;
        int sec = 1;
        int iters = 2;

        int newFir;
        int newSec;

        while (true) {
            if (2*iters + 1 > n) {
                break;
            }
            newSec = fir*(fir+2*sec);
            newFir = fir*fir + (fir+sec)*(fir+sec);
            iters = 2*iters + 1;
            fir = newFir;
            sec = newSec;

        }
        if (iters-n  > 10) {
            int m = iters-n;
            int[] ms = fibonacci4(m);
            int mn = (fir+sec)*ms[1] + fir*ms[0];
            int mnMinusOne = fir*ms[0] + sec*(ms[1]-ms[0]);
            int[] ret = {mn, mnMinusOne};
            return ret;
        }
        for (int i = iters; i < n; i++) {
            int temp = fir;
            fir = fir + sec;
            sec = temp;
        }
        int[] ret = {fir, sec};
        return ret;
    }

    public static int[] fibonacciFun(int n) {
        int[] ret = {1532868155, -1};
        return ret;
    }
}
