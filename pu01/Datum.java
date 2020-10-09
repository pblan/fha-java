public class Datum {
    public static final int[] monatslaengen = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int tag, monat, jahr;
    public Datum(int tag, int monat, int jahr) {
        // Exception (siehe Text unten)
        if (jahr < 1800 || jahr > 2100) throw new DateOutOfRangeException("year out of range");
        if (monat < 1 || monat > 12) throw new InvalidDateException("month out of range");
        if (tag < 1 || tag > getMonatslaenge(monat, jahr)) throw new InvalidDateException("day out of range");

        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public static int getMonatslaenge(int monat, int jahr) {
        // gibt Laenge des Monats zurueck. Berücksichtigt Schaltjahre.
        int res = monatslaengen[monat-1];
        return (isSchaltjahr(jahr)) && (monat == 2) ? res-1 : res; 
        
    }

    public static boolean isSchaltjahr(int jahr) {
        // gibt true zurück, wenn das uebergebene Jahr ein Schaltjahr ist,
        // ansonsten false
        return ((jahr % 4 == 0) && !(jahr % 100 == 0)) || (jahr % 400 == 0);
    }
   
    public boolean equals(Datum a) {
        // ueberprueft, ob this und a das gleiche Datum haben.
        return (this.tag == a.tag) && (this.monat == a.monat) && (this.jahr == a.jahr);
    }

    public boolean isGleicherTag(Datum a) {
        // ueberprueft, ob Tag und Monat gleich sind
        // (ohne Berücksichtigung des Jahres)
        return (this.tag == a.tag) && (this.monat == a.monat);
    }

    public String toString() {
        // gibt eine passende String-Darstellung des Datums zurück
        return "" + this.tag + "." + this.monat + "." + this.jahr;
    }

    public Datum morgen() {
        // gibt das Datum von this + 1 Tag zurück
        Datum morgen = new Datum(this.tag, this.monat, this.jahr);
        morgen.tag %= Datum.getMonatslaenge(morgen.monat, morgen.jahr);
        morgen.tag++;
        if (morgen.tag == 1) {
            morgen.monat %= 12;
            morgen.monat++;
        }
        if (morgen.monat == 1) {
            morgen.jahr++;
        }
        return morgen;
    }
    
    public Datum gestern() {
        // gibt das Datum von this - 1 Tag zurück
        Datum gestern = new Datum(this.tag, this.monat, this.jahr);
        gestern.tag--;
        if (gestern.tag == 0) {
            gestern.monat--;
        }
        if (gestern.monat == 0) {
            gestern.jahr--;
            gestern.monat = 12;
        }
        gestern.tag = getMonatslaenge(gestern.monat, gestern.jahr);

        return gestern;
    }
} 