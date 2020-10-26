package goldpreis;

import java.util.*;
import java.io.*;

/**
 * Eine Klasse die aus einer Textdatei Goldpreise einlesen kann und ein paar
 * einfache Methoden bereitstellt um Werte auszulesen.
 * 
 * @version 1.0.0.1
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public class Goldpreis {
	/** Liste mit Goldpreisen */
	private ArrayList<Goldtagespreis> list;
	/**
	 * Eine Konstante um nicht im Code eine -1 stehen zu haben, bei der man den
	 * Zweck vielleicht nicht sofort erkennt.
	 */
	private static final double NO_PRICE = -1;

	/**
	 * Liest aus der angegebenen Datei die Goldpreise in eine Arraylist ein.
	 * 
	 * @param dateiname Der Name der zu lesenden Datei.
	 */
	public Goldpreis(String dateiname) {
		try {
			File f = new File(dateiname);
			Scanner sc = new Scanner(f);
			list = new ArrayList<>();
			while (sc.hasNextLine()) {
				addPreis(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden.");
		}

	}

	/**
	 * Hilfsfunktion, die aus einem String aus dem gegebenen Format automatisch ein
	 * neues Goldtagespreisobjekt erstellt und der Liste hinzufuegt.
	 * 
	 * @param s String der hinzugefuegt werden soll.
	 */
	private void addPreis(String s) {
		s = s.replace(".", "").replace(",", ".");
		String[] arr = s.split("\t");
		String datum = arr[0];
		double preis = NO_PRICE;
		try {
			preis = Double.parseDouble(arr[1]);
		} catch (NumberFormatException e) {
			if (!arr[1].equals("kein Nachweis")) {
				System.out.println("Irgendwas ist beim Goldpreis schiefgelaufen.");
			}
		}
		list.add(new Goldtagespreis(datum, preis));
	}

	/**
	 * Hilfsfunktion, die in einem Durchlauf der Liste den maximalen und den minimalen Goldpreis bestimmt und in einem Array zurueck gibt.
	 * 
	 * @return Array mit min. und max. Goldpreis
	 */
	private double[] getMinMaxValues() {
		double max = NO_PRICE;
		double min = NO_PRICE;
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).preis > max) {
				max = this.list.get(i).preis;
			}
			// Da NO_PRICE < alle Goldpreise ist muessen wir immer ersetzen, falls NO_PRICE
			// gerade das Minimum ist.
			if ((this.list.get(i).preis < min && this.list.get(i).preis != NO_PRICE) || min == NO_PRICE) {
				min = this.list.get(i).preis;
			}
		}
		return new double[] {min, max};
	}

	/**
	 * Sucht zu einem vorgegebenen Datum den Preis. Existiert das Datum nicht oder
	 * hat es das falsche Format wird eine NumberFormatException geworfen.
	 * 
	 * @throws NumberFormatException falls das Datum nicht gefunden werden konnte
	 *         weil es nicht existiert oder das Format falsch war.
	 * @param datum Das Datum zu dem der Preis gefunden werden soll.
	 * @return Den Preis zum angebenen Datum.
	 */
	public double getPreis(String datum) {
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).datum.equals(datum)) {
				return this.list.get(i).preis;
			}
		}
		throw new NumberFormatException("Tag kommt nicht in der Datei vor.");
	}

	/**
	 * Gibt die Tage aus an denen Die Goldpreise am hoechsten waren und die Tage an
	 * denen sie am niedriegsten waren in Form eine Bildschirmausgabe.
	 */
	public void printMinMax() {
		double[] temp = this.getMinMaxValues();
		double min = temp[0];
		double max = temp[1];
		ArrayList<String> arrMax = new ArrayList<>();
		ArrayList<String> arrMin = new ArrayList<>();
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).preis == min) {
				arrMin.add(this.list.get(i).datum);
			}
			if (this.list.get(i).preis == max) {
				arrMax.add(this.list.get(i).datum);
			}
		}

		System.out.printf("Den niedrigsten Goldpreis von %.2f Euro gab es an folgenden Tagen:\n", min);
		for (int i = 0; i < arrMin.size(); i++) {
			System.out.println(arrMin.get(i));
		}

		System.out.printf("Den hoechsten Goldpreis von %.2f Euro gab es an folgenden Tagen:\n", max);
		for (int i = 0; i < arrMax.size(); i++) {
			System.out.println(arrMax.get(i));
		}
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < this.list.size(); i++) {
			ret += this.list.get(i).toString() + "\n";
		}
		return ret;
	}
}
