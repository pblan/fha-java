
public class Ableitungstest {

  public static void main(String[] args) {
    Funktion f1 = new AXhochN(3, 2);   // Fassung mit Konstruktoren, die
    Funktion f2 = new AXhochN(7, 1);   // noch nicht `private' sind
    Funktion f  = new Summe(f1, f2);
    // Wenn die statische Methode `get' implementiert wurde,
    // muessen diese drei Zeilen ein- und die oberen drei
    // auskommentiert werden:
    /*
    Funktion f1 = AXhochN.get(3, 2);    // schon voll optimierte Fassung
    Funktion f2 = AXhochN.get(7, 1);
    Funktion f  = Summe.get(f1, f2);
    */
    test(f);

  }

  public static void test(Funktion f) {
    for (int i = 0; i < 4; i++) {
      System.out.println(i + ". Ableitung: " + f);
      System.out.println("f(2) = " + f.getY(2));
      f = f.getAbleitung();
    }
    System.out.println("==============");
  }
}

