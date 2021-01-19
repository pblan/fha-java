import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Index {
    HashMap<String, ArrayList<Integer>> verzeichnis;

    public Index() {
        this.verzeichnis = new HashMap<String, ArrayList<Integer>>();
    }

    public void wortHinzufuegen(String begriff, int seitenzahl) {
        this.verzeichnis.putIfAbsent(begriff, new ArrayList<Integer>());
        if (!this.verzeichnis.get(begriff).contains(seitenzahl))
            this.verzeichnis.get(begriff).add(seitenzahl);
    }

    public ArrayList<Integer> getAlleFundstellen(String wort) {
        ArrayList<Integer> res = this.verzeichnis.get(wort);
        return res == null ? new ArrayList<Integer>() : res;
    }

    public int getErsteFundstelle(String wort) {
        ArrayList<Integer> res = getAlleFundstellen(wort);
        Collections.sort(res);
        return res.isEmpty() ? -1 : res.get(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : this.verzeichnis.keySet()) {
            sb.append(key);
            sb.append(": [");
            String prefix = "";
            for (int seite : this.verzeichnis.get(key)) {
                sb.append(prefix);
                prefix = ", ";
                sb.append(seite);
            }
            sb.append("]\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Index index = new Index();
        index.wortHinzufuegen("boolean", 1);
        index.wortHinzufuegen("boolean", 15);
        index.wortHinzufuegen("boolean", 3);
        index.wortHinzufuegen("boolean", 15);
        index.wortHinzufuegen("if", 45);
        index.wortHinzufuegen("if", 2);
        index.wortHinzufuegen("if", 10);
        index.wortHinzufuegen("if", 45);
        System.out.println(("index"));
        System.out.println(index);
        ArrayList<Integer> seiten = index.getAlleFundstellen("boolean");
        System.out.println("seiten = " + seiten);
        int ersteStelle = index.getErsteFundstelle("if");
        System.out.println("ersteStelle = " + ersteStelle);

        Index zusatz = new Index();
        File f = new File("p03/zauberlehrling.txt");
        try {
            Scanner sc = new Scanner(f);
            int zeile = 1;
            System.out.println("" + sc.hasNextLine());
            while (sc.hasNextLine()) {
                String[] woerter = sc.nextLine().split(" ");
                for (String wort : woerter) {
                    if (wort.length() >= 3 && Character.isUpperCase(wort.charAt(0))) {
                        zusatz.wortHinzufuegen(wort, zeile);
                        System.out.println(wort + "@" + zeile);
                    }
                }
                zeile++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(zusatz);
    }
}
