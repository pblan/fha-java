// import java.lang.Math;

public class Test {
    public static void main(String[] args) {
        // int n = 1000000000;
        // double phi = (1 + Math.sqrt(5))/2;
        // double phiN = Math.pow(phi, n);
        // System.out.println(phiN/Math.sqrt(5) + 0.5);
        // long startTime = System.nanoTime();
        // System.out.println(Calc.fibonacci3(n));
        // long endTime = System.nanoTime();
        // long timeElapsed = endTime - startTime;
        // System.out.println("Execution time (optimised AF) in milliseconds : " + (double) timeElapsed / 1000000);

        // startTime = System.nanoTime();
        // System.out.println(Calc.fibonacci2(n));
        // endTime = System.nanoTime();
        // timeElapsed = endTime - startTime;
        // System.out.println("Execution time (optimised) in milliseconds : " + (double) timeElapsed / 1000000);

        // startTime = System.nanoTime();
        // System.out.println(Calc.fibonacci4(n));
        // endTime = System.nanoTime();
        // timeElapsed = endTime - startTime;
        // System.out.println("Execution time (unoptimised) in milliseconds : " + (double) timeElapsed / 1000000);

        // startTime = System.nanoTime();
        // System.out.println(Calc.fibonacciFun(n));
        // endTime = System.nanoTime();
        // timeElapsed = endTime - startTime;
        // System.out.println("Execution time (unoptimised) in milliseconds : " + (double) timeElapsed / 1000000);




        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.addLast(2);
        System.out.println("Groesse der Liste: " + list1.size()); // 1
        for (int i = 0; i < 10; i++) {
            list1.addFirst(i);
        }
        System.out.println("Groesse der Liste: " + list1.size()); // 11
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " "); // 9 8 7 6 5 4 3 2 1 0 2
        }
        System.out.println();
        list1.clear();
        System.out.println("Groesse der Liste: " + list1.size()); // 0
        MyArrayList<String> list2 = new MyArrayList<>();
        list2.addFirst("Java");
        String s = list2.get(0);
        System.out.println(s); // Java
    }
}
