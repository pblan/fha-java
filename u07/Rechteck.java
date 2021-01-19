import java.awt.Point;

public class Rechteck extends Figur {
    private Point[] punkte;

    public int getPunktCount() {
        return this.punkte.length;
    }

    public Point getPunkt(int i) {
        return this.punkte[i];
    }

    public Rechteck(Point x1, Point x2) {
        this.punkte = new Point[] { x1 , new Point((int) x2.getX(), (int) x1.getY()), x2, new Point((int) x1.getX(), (int) x2.getY()), x1 };
    }

    public Rechteck(Rechteck r) {
        this.punkte = r.punkte.clone();
    }

    public void skaliere(double d) {
        for (int i = 0; i < this.punkte.length; i++) {
            double x = this.punkte[i].getX();
            double y = this.punkte[i].getY();
            if (i == 0 || i == 3 || i == 4) {
                x -= (x*d) / 2;
                y = i == 0 || i == 4 ? y - (y*d) / 2 : y + (y*d) / 2;
                this.punkte[i].setLocation(x, y);
            } 
            else {
                x += (x*d) / 2;
                y = i == 1 ? y - (y*d) / 2 : y + (y*d) / 2;
            }
        }
    }
}
