package homework;

import java.util.*;

/**
 * Eine Klasse, die Rechenoperationen in eine Liste aufbewahrt. Man kann
 * Rechenoperationen hinzufuegen und die Rechenoperationen nacheinander auf ein
 * Feld aus Werten anwenden.
 * 
 * @author Patrick Blaneck, Tim Wende, Felix Racz
 * @version 1.0
 */
public class Rechenoperationsliste {
	// Atribute
	/** Liste, die alle Rechenoperationen festhaelt */
	private ArrayList<Rechenoperation> list;

	/**
	 * Konstruktor der eine neue Rechenoperationsliste erstellt.
	 * 
	 */
	public Rechenoperationsliste() {
		list = new ArrayList<>();
	}

	/**
	 * Fuegt zu der Liste eine neue Rechenoperation hinzu.
	 * 
	 * @param operation Die Operation die zur Liste hinzugefuegt werden soll.
	 */
	public void add(Rechenoperation operation) {
		list.add(operation);
	}

	/**
	 * Fuehrt alle Operationen in der liste auf ein Feld aus und gibt ein neues Feld
	 * mit den Ergebnissen zurueck.
	 * 
	 * @param feld Feld aus doubles auf das die Operationen angewandt werden sollen.
	 * @return gibt ein Feld zurueck.
	 */
	public double[] transform(double[] feld) {
		double[] transformed = feld.clone();
		for (int i = 0; i < transformed.length; i++) {
			for (Rechenoperation operation : list) {
				transformed[i] = operation.berechne(transformed[i]);
			}
		}
		return transformed;
	}
}
