package homework_10;

import java.util.stream.Stream;

public class ZahlwortTest {

	/**
	 * Vorgegebene main Funktion.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// testen, ob ein paar typische Zahlwoerter richtig herauskommen:
		System.out.println(); System.out.println("Test 1:");
		int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69,
		70, 131, 195, 201, 202, 211, 1111, 2345 };
		for (int z: testtabelle) {
		String zahlwort = Zahlwort.getZahlwort(z);
		System.out.println("zahl = " + z + " --> " + zahlwort);
		}
		// testen, ob die Stream-Methode ordentlich funktioniert:
		System.out.println(); System.out.println("Test 2:");
		int start = 8;
		int stop = 12;
		Stream<String> ss = Zahlwort.getZahlStream(start, stop);
		ss.limit(stop-start+1).forEach(System.out::println);
		// sollte eine Ausnahme produzieren:
		System.out.println(); System.out.println("Test 3:");
		int zahl = 10000;
		String wort = Zahlwort.getZahlwort(zahl);
		
		// testen, ob alle Methoden das selbe zurueckgeben
//		for (int i = 1; i < 10000; i++) {
//			if (!Zahlwort.getZahlwort(i).equals(ZahlwortAlternativ.getZahlwort(i)) || !Zahlwort.getZahlwort(i).equals(ZahlwortAlternativ2.getZahlwort(i))) {
//				System.out.println(Zahlwort.getZahlwort(i));
//			}
//		}
	}
}
