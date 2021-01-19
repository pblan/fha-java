import java.awt.Point;

public class LinieTest {
  public static void main(String[] args) { 

    // neues Grafikfenster mit einer Zeichenflaeche der
    // angegebenen Breite und Hoehe oeffnen:
    Grafik g = new Grafik(1000, 1000);

    // eine Linie zeichnen, die vom angegebenen Startpunkt bis
    // zum angegebenen Endpunkt reicht:
    Point startpunkt = new Point( 100,  100);
    Point endpunkt   = new Point(200, 200);
    Rechteck l          = new Rechteck(startpunkt, endpunkt);
    // => Der Koordinatenursprung liegt links oben!

    g.add(l);           // die Linie in die Zeichenflaeche einfuegen
    g.aktualisiere(1000);  // die Zeichenflaeche sofort aktualisieren
    l.skaliere(2);
    g.aktualisiere(1000);  // die Zeichenflaeche sofort aktualisieren
  }
}

