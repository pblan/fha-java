package eMailAdressbuch;

import java.util.*;
import java.io.*;

/**
 * Diese Klasse speichert ein Email Adressbuch in einer Hashmap. Sie stellt
 * einfache Methoden zum Hinzufuegen und Abfragen von Elementen und eine
 * Moeglichkeit aus einer Textdatei Daten einzulesen.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 * @version 4.20.69
 */
public class EMailAdressBuch {
	/** HashMap in der das Adressbuch gespeichert wird. */
	private HashMap<String, String> directory;

	/**
	 * Einfacher Konstruktor der ein neues Adressbuch erstellt.
	 */
	public EMailAdressBuch() {
		this.directory = new HashMap<>();
	}

	/**
	 * Methode zum Einfuegen von neuen Eintraegen. Ist eine Name schon vorhanden,
	 * wird die alte Mailadresse ueberschrieben
	 * 
	 * @param name  Name des Eintrags der eingefuegt wird.
	 * @param email Email des Eintrags der eingefuegt wird.
	 */
	public void einfuegen(String name, String email) {
		this.directory.put(name, email);
	}

	/**
	 * Methode zum Abfragen einer Mailadresse zu einem Namen.
	 * 
	 * @throws UnknownNameException falls der Name nicht im Adressbuch existiert.
	 * @param name Name zu dem die Mailadresse gesucht werden soll.
	 * @return Mailadresse zum Namen, der uebergeben wurde.
	 */
	public String abfrage(String name) {
		if (!this.directory.containsKey(name)) {
			throw new UnknownNameException("Dieser name existiert nicht im Adressbuch.");
		}
		return this.directory.get(name);
	}
	/**
	 * Methode zum Einlesen eines Adressbuches in Form einer Textdatei.
	 * Die Textdatei muss das Format "Name";"EMail" und ein Zeilenumbruch fuer jeden Eintrag haben.
	 * 
	 * @throws FilenNotFoundException Wenn die Datei nicht gefunden werden kann.
	 * @param dateiname Name der Datei die gelesen werden soll.
	 */
	public void einlesen(String dateiname) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(dateiname))){
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().split(";");
				this.einfuegen(temp[0],temp[1]);
			}
		}
	}
	
	@Override
	public String toString() {
		return this.directory.toString();
	}
}
