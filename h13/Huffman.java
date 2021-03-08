import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Eine Klasse um eine Datei die mit einer Huffmancodierung codiert wurde zu dekodieren.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class Huffman {

    public static void main(String[] args) {
        File f = new File("message.txt");
        System.out.println(decode(f));
    }

    /**
     * Dekodiert die Datei. Wenn das Format nicht richtig ist wird eine IllegalArgumentException geworfen.
     * 
     * 
     * @param f Textdatei die dekodiert werden soll.
     * @return dekodierte Nachricht.
     * @throws IllegalArgumentException Falls die Datei nicht das richtige Format hat.
     */
    public static String decode(File f) {
        HashMap<String, Character> code = new HashMap<>();
        String encodedMessage = "";
        // Einlesen der Datei
        try (Scanner sc = new Scanner(f)) {
            if (sc.hasNextLine()) encodedMessage = sc.nextLine();
            else throw new IllegalArgumentException("File Empty.");
            int cnt = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.isEmpty()) code.put(line, (char) (cnt < 26 ? 'A' + cnt : ' '));
                cnt++;
                if (cnt > 27) throw new IllegalArgumentException("Die Datei ist zu lang.");
            }
            if (cnt != 27) throw new IllegalArgumentException("Dateilänge nicht richtig. Es müssen genau 28 Zeilen in der Datei sein.");
        } catch(FileNotFoundException e) {
            System.out.println("This File does not exist.");
        }
        // Decodierung der Datei
        StringBuilder message = new StringBuilder();
        String curr = "";
        for (String e : encodedMessage.split("")) {
            curr += e;
            if (code.containsKey(curr)) {
                message.append(code.get(curr));
                curr = "";
            }
        }
        return message.toString();
    }
}
