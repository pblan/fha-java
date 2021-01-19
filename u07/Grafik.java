import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Zweck: Fuer Praesenzuebung zu verwendende Klasse, die den Rahmen
 *        bietet, um geometrische Figuren auf dem Bildschirm anzeigen
 *        zu lassen.<br>
 *        Der Rahmen besteht dabei aus den Klassen Grafik und Figur.
 */
public class Grafik {

  private JFrame frame;
  private JPanel panel;
  private ArrayList<Figur> figuren = new ArrayList<Figur>();

  /**
   * Oeffnet ein Grafikfenster mit einer Zeichenflaeche der angegebenen
   * Breite und Hoehe.
   *
   * @param  width
   *                 Breite der Zeichenflaeche
   * @param  height
   *                 Hoehe der Zeichenflaeche
   */
  public Grafik(int width, int height) {
    this.frame = new JFrame();
    this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.panel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < Grafik.this.figuren.size(); i++) {
          Grafik.this.figuren.get(i).paint(g);
        }
      }
    };
    this.panel.setPreferredSize(new Dimension(width, height));
    this.frame.add(this.panel);
    this.frame.pack();
    this.frame.setVisible(true);
  }

  /**
   * Aktualisiert die Zeichenflaeche. Aenderungen werden erst sichtbar, nachdem
   * diese Methode aufgerufen wurde. Vor der Aktualisierung wird ms Millisekunden
   * gewartet.<br>
   * Damit ist eine einfache Animation moeglich.
   * 
   * @param  verzoegerung
   *            Zeit in Millisekunden, die vor der Aktualisierung gewartet wird.
   */
  public void aktualisiere(int verzoegerung) {
    // frame.repaint();
    try {
      Thread.sleep(verzoegerung);
      SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
          Grafik.this.panel.paint(Grafik.this.panel.getGraphics());
        }
      });
    } catch (InterruptedException e) {
    } catch (InvocationTargetException e) {
    }
  }

  /**
   * Diese Methode fuegt die uebergebene Figur in die Zeichenflaeche ein.
   *
   * @param  f
   *           in die Zeichenflaeche einzufuegende Figur
   */
  public void add(Figur f) {
    this.figuren.add(f);
  }

  /**
   * Mit dieser Methode wird die uebergebene Figur von der Zeichenflaeche entfernt
   *
   * @param  f  zu entfernende Figur
   */
  public void remove(Figur f) {
    this.figuren.remove(f);
  }
}

abstract class Figur {

  /**
   * Gibt die Anzahl an Punkten zurueck. Es handelt sich um eine abstrakte Methode
   * die in allen Unterklassen von Figur ueberschrieben werden muss
   *
   * @return  Punktanzahl
   */
  public abstract int getPunktCount();

  /**
   * Gibt den zum index gehoerenden Punkt zurueck. Es handelt sich um eine
   * abstrakte Methode die in allen Unterklassen von Figur überschrieben werden
   * muss
   *
   * @param   i  Punktindex
   * @return     Punkt an der Stelle i
   */
  public abstract Point getPunkt(int i);

  /**
   * Diese Methode zeichnet zwischen den jeweils benachbarten Punkten der Liste
   * eine Verbindungslinie.
   *
   * @param  g
   *            Graphikobjekt, auf dem die Punkte der Figur eingezeichnet werden
   */
  public void paint(Graphics g) {
    for (int i = 0; i < getPunktCount() - 1; i++) {
      g.drawLine(getPunkt(i).x,     getPunkt(i).y,
                 getPunkt(i + 1).x, getPunkt(i + 1).y);
    }
  }

  /**
   * Alle Punkte der Figur werden um die angegebenen Werte verschoben.
   * 
   * @param  x
   *            Verschiebungswert in x-Richtung
   * @param  y
   *            Verschiebungswert in y-Richtung
   */
  public void verschiebe(int x, int y) {
    for (int i = 0; i < getPunktCount(); i++) {
      getPunkt(i).translate(x, y);
    }
  }

  @Override
  public String toString() {
    return "Leere Figur:";
  }
}

