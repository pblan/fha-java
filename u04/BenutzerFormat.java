import java.util.Locale;

public class BenutzerFormat implements BruchFormat {
    String format;
    Locale locale = Locale.GERMAN;

    public BenutzerFormat(String format) {
        this.format = format;
    }

    public BenutzerFormat(String format, Locale locale) {
        this.format = format;
        this.locale = locale;
    }

    public String bruchToString(int zaehler, int nenner) {
        return "" + String.format(this.locale, this.format, 1. * zaehler / nenner);
    }
}
