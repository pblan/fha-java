import java.awt.Point;

/** Linie zwischen zwei Punkten */
public class Linie extends Figur {

  private Point[] punkte;

  @Override
  /**
   * Gibt die Anzahl an Punkten des Polygonszugs dieser Figur zurueck.
   * Ueberschreibt die abstrakte Methode der Basisklasse.
   *
   * @return  Anzahl an Punkten des Polygonzugs dieser Figur
   */
  public int getPunktCount() {
    return this.punkte.length;
  }

  @Override
  /**
   * Gibt den gewuenschten Punkt des Polygonszugs dieser Figur zurueck.
   * Ueberschreibt die abstrakte Methode der Basisklasse.
   *
   * @param   i  Index des gewuenschten Punktes
   * @return     gewuenschter Punkt mit Index i
   */
  public Point getPunkt(int i) {
    return this.punkte[i];
  }

  /**
   * Erstellt das Objekt fuer eine Linie, die zwischen den beiden
   * uebergebenen Punkten verlaeuft
   *
   * @param  x1  Startpunkt der Linie
   * @param  x2  Endpunkt der Linie
   */
  public Linie(Point x1, Point x2) {
    this.punkte = new Point[] { x1, x2 };
  }
}

