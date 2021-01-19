public class DreizeilenFormat implements BruchFormat {
    public String bruchToString(int zaehler, int nenner) {
        String zaehler_str = String.valueOf(zaehler);
        String nenner_str = String.valueOf(nenner);

        int digits = zaehler_str.length() > nenner_str.length() ? zaehler_str.length() : nenner_str.length();

        return String.format("%" + digits + "d\n%s\n%" + digits + "d", zaehler, "-".repeat(digits), nenner);
    }
}
