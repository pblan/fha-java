public class Blatt {
    private int[] karten = new int[3];

    public Blatt(int[] karten) {
        if (karten.length > 3) throw new IllegalArgumentException("Array ist zu lang!");
        for (int karte : karten) 
            if (karte < 2 || karte > 14) throw new IllegalArgumentException("Kartenwert an Position " + karte + "ist ungültig!");
        this.karten = karten.clone();
    }

    public String toString() {
        return this.karten[0] + ", " + this.karten[1] + ", " + this.karten[2];
    }

    public int[] getKarten() {
        return this.karten.clone();
    }
}
