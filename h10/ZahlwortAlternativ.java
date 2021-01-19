package homework_10;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.Map.entry;

/**
 * Klasse ZahlwortAlternativ1, welche aus einer Zahl zwischen 1 und 10.000 das deutsche dazugehoerende Wort generiert.
 * 
 * @author Felix Racz
 */
public class ZahlwortAlternativ {
	/**
	 * Zahlstrings fuer die implementierung der dreier-Gruppen-Berechnung.
	 */
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

		ret += getZahlwortDreier(x % 1000, rek) + ZahlwortAlternativ.dDreier[rek];

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
		Map<Integer, String> zahlen = Map.ofEntries(entry(1, "ein"), entry(2, "zwei"), entry(3, "drei"),
				entry(4, "vier"), entry(5, "fuenf"), entry(6, "sechs"), entry(7, "sieben"), entry(8, "acht"),
				entry(9, "neun"), entry(10, "zehn"), entry(11, "elf"), entry(12, "zwoelf"), entry(20, "zwanzig"),
				entry(30, "dreissig"), entry(40, "vierzig"), entry(50, "fuenfzig"), entry(60, "sechzig"),
				entry(70, "siebzig"), entry(80, "achtzig"), entry(90, "neunzig"));
		if (x == 0) {
			return "";
		}
		if (x == 1 && rek == 0) {
			return "eins";
		}
		if (x <= 12) {
			return zahlen.get(x);
		}
		if (x < 20) {
			if (x == 16) {
				return "sechzehn";				
			}
			if (x == 17) {
				return "siebzehn";
			}
			return zahlen.get(x % 10) + "zehn";
		}
		if (x < 100) {
			if (x % 10 == 0) {
				return zahlen.get(x);
			} else {
				return zahlen.get(x % 10) + "und" + zahlen.get(x - x % 10);
			}
		}
		if (x < 1000) {
			String ret = zahlen.get(x / 100) + "hundert";
			if (x % 100 == 0) {
				return ret;
			} else {
				return ret + ZahlwortAlternativ.getZahlwortDreier(x % 100, rek);
			}
		}
		return null;
	}

	/**
	 * Gibt alle Zahlen zwischen start und stop zurueck
	 * 
	 * @param start Startwert des zu betrachtenden Bereiches
	 * @param stop  Stopwert des zu betrachtenden Bereichs
	 * @return Stream aller ausgeschriebenen Zahlwoerter
	 */
	public static Stream<String> getZahlStream(int start, int stop) {
		return IntStream.iterate(start, i -> i + 1).limit(stop).mapToObj(i -> ZahlwortAlternativ.getZahlwort(i));
	}
}
