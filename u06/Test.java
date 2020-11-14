import java.awt.Point;

public class Test {
    public static void main(String[] args) {
        NewArrayList list = new NewArrayList();
        list.add(1.4);
        list.add("1,75");
        list.add("1.75");
        list.add("hallo");
        list.add(1243);
        list.add("128745");
        list.add("🤣💩");
        list.add("👌👀👌👀👌👀👌👀👌👀 good shit go౦ԁ sHit👌");
        list.add(new Point(1,2));
        System.out.println(list);
        System.out.println(list.getIntegers());
        System.out.println(list.getDoubles());
        try {
            System.out.println(list.getStrings());
        }
        catch (WrongElementException e) {
            System.out.println("" + e.getIndex());
        }
        XPoint punkt = new XPoint(1,2);
        Point a = new Point(0,0);
        Point b = new Point(2,4);
        System.out.println(punkt.isOnLine(a, b));
        System.out.println(punkt.getPhi());
        System.out.println(punkt.getR());
    }
}