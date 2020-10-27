package eMailAdressbuch;
import java.io.*;

public class MailTest {
	public static void main(String[] args) {
		EMailAdressBuch matseAdressen = new EMailAdressBuch();
		EMailAdressBuch meineAdressen = new EMailAdressBuch();
		try {
			matseAdressen.einlesen("mitarbeiter_matse_intern.txt");
			matseAdressen.einlesen("mitarbeiter_matse_extern.txt");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException" + e);
		}
		System.out.println(matseAdressen);
		
		try {
			meineAdressen.einlesen("emailadressbuch.txt");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException" + e);
		}
	}
}
