public class Test {
    public static void main(String[] args) {
        Datum test = new Datum(28,2,2003);
        System.out.println(test.morgen().toString());
        Datum test2 = new Datum(1,1,2003);
        System.out.println(test2.gestern().toString());
    }
}
