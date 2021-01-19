package homework_10;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Klasse ZahlwortAlternativ2, welche aus einer Zahl zwischen 1 und 10.000 das deutsche
 * dazugehoerende Wort generiert.
 * 
 * @author Tim Wende
 */
public class ZahlwortAlternativ2 {
	/**
	 * Zahlstrings fuer die implementierung der dreier-Gruppen-Berechnung.
	 */
	public static final String[] dZahl = new String[] { "ein", "zwei", "drei", "vier", "fuenf", "sech", "sieb", "acht", "neun" };
	public static final String[] dSprachbesonderheiten = new String[] { "elf", "zwoelf", "zehn", "zwan" };
	public static final String[] dDreier = new String[] { "", "tausend", "millionen", "milliarden", "billionen", "billiarden", "trillionen" };

	/**
	 * Gibt das Zahlwort zu einer Zahl zurueck
	 * 
	 * @param x die Zahl
	 * @return Ausgeschriebenes Zahlwort
	 */
	public static String getZahlwort(int x) {
		if (x <= 0 || x >= 10000)
			throw new ArithmeticException();

		return getZahlwort(x, 0);
	}

	/**
	 * Rekursive Hilfsmethode
	 * 
	 * @param x die Zahl
	 * @param rek die Rekursionstiefe
	 * @return Ausgeschriebenes Zahlwort
	 */
	public static String getZahlwort(int x, int rek) {
		String ret = "";

		if (x / 1000 != 0)
			ret = getZahlwort(x / 1000, rek + 1);

		ret += getZahlwortDreier(x % 1000, rek) + ZahlwortAlternativ2.dDreier[rek];

		return ret;
	}

	/**
	 * Hilfsmethode fuer Dreierpaeckchen
	 * 
	 * @param x die Zahl (zwischen 0 und 9999 inklusive)
	 * @param rek die Rekursionstiefe
	 * @return Ausgeschriebenes Zahlwort des Paeckchens
	 */
	public static String getZahlwortDreier(int x, int rek) {
		String ret = "";

		int[] zahl = new int[String.valueOf(x).split("").length];
		for (int i = 0; i < zahl.length; i++) {
			zahl[i] = Integer.valueOf(String.valueOf(x).split("")[i]);
		}

		ret += ZahlwortAlternativ2.getZahlwortHunderter(zahl);
		ret += ZahlwortAlternativ2.getZahlwortEiner(zahl, rek);
		ret += (zahl.length >= 2 && zahl[zahl.length - 2] != 0 && zahl[zahl.length - 1] != 0 && zahl[zahl.length - 2] != 1) ? "und" : "";

		ret += ZahlwortAlternativ2.getZahlwortZehner(zahl);

		ret = ret.replace("einzehn", ZahlwortAlternativ2.dSprachbesonderheiten[0]);
		ret = ret.replace("zweizehn", ZahlwortAlternativ2.dSprachbesonderheiten[1]);
		return ret;
	}

	/**
	 * Hilfsmethode fuer die Einer
	 * 
	 * @param zahl die Zahl (zwischen 0 und 9999 inklusive)
	 * @param rek die Rekursionstiefe
	 * @return Ausgeschriebene Einerstelle
	 */
	public static String getZahlwortEiner(int[] zahl, int rek) {
		String ret = "";
		if (zahl.length >= 1 && zahl[zahl.length - 1] != 0) {
			ret += ZahlwortAlternativ2.dZahl[zahl[zahl.length - 1] - 1];
			ret += ((zahl.length == 1 || (zahl.length >= 2 && zahl[zahl.length - 2] == 0)) && zahl[zahl.length - 1] == 1 && rek == 0) ? "s" : "";
			if ((zahl.length >= 2 && zahl[zahl.length - 2] != 1) || (zahl.length == 1)) {
				ret += (zahl[zahl.length - 1] == 6) ? "s" : "";
				ret += (zahl[zahl.length - 1] == 7) ? "en" : "";
			}
		}
		return ret;
	}

	/**
	 * Hilfsmethode fuer die Zehner
	 * 
	 * @param zahl die Zahl (zwischen 0 und 9999 inklusive)
	 * @return Ausgeschriebene Zehnerstelle
	 */
	public static String getZahlwortZehner(int[] zahl) {
		String ret = "";
		if (zahl.length >= 2 && zahl[zahl.length - 2] != 0)
			if (zahl[zahl.length - 2] != 1 && zahl[zahl.length - 2] != 2)
				ret += ZahlwortAlternativ2.dZahl[zahl[zahl.length - 2] - 1] + (((zahl[zahl.length - 2]) != 3) ? "zig" : "ssig");
			else if (zahl[zahl.length - 2] != 2)
				ret += ZahlwortAlternativ2.dSprachbesonderheiten[2];
			else
				ret += ZahlwortAlternativ2.dSprachbesonderheiten[3] + "zig";
		return ret;
	}

	/**
	 * Hilfsmethode fuer die Hunderter
	 * 
	 * @param zahl die Zahl (zwischen 0 und 9999 inklusive)
	 * @return Ausgeschriebene Hunderterstelle
	 */
	public static String getZahlwortHunderter(int[] zahl) {
		String ret = "";
		if (zahl.length >= 3 && zahl[zahl.length - 3] != 0) {
			ret += ZahlwortAlternativ2.dZahl[zahl[zahl.length - 3] - 1];
			ret += (zahl[zahl.length - 3] == 6) ? "s" : "";
			ret += (zahl[zahl.length - 3] == 7) ? "en" : "";
			ret += "hundert";
		}
		return ret;
	}
	
	/**
	 * Gibt alle Zahlen zwischen start und stop zurueck
	 * 
	 * @param start Startwert des zu betrachtenden Bereiches
	 * @param stop  Stopwert des zu betrachtenden Bereichs
	 * @return Stream aller ausgeschriebenen Zahlwoerter
	 */
	public static Stream<String> getZahlStream(int start, int stop) {
		return IntStream.iterate(start, i -> i + 1).limit(stop).mapToObj(i -> ZahlwortAlternativ2.getZahlwort(i));
	}
}
