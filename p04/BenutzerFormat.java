import java.util.Locale;

/*
 * Dieses Format gibt eine Dezimalzahl wie bei DoubleFormat zur�ck, erm�glicht
 * es aber zus�tzlich, die Dezimalzahl wie bei printf zu formatieren. Der
 * printf-Steuerungsstring wird im Konstruktor �bergeben und als Attribut
 * gespeichert. Benutzen Sie String.format bei der eigentlichen Umwandlung.
*/
public class BenutzerFormat implements BruchFormat{

	private String format;
	private Locale l;
	
	public BenutzerFormat(String format) {
		this.format = format;
	}
	
	public BenutzerFormat(String format, Locale l) {
		this.l = l;
		this.format = format;
	}
	
	@Override
	public String bruchToString(int zaehler, int nenner) {
		return String.format(l, format, ((double) zaehler/nenner));
	}

}
