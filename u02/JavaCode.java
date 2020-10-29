import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;

public class JavaCode {

    ArrayList<String> code = new ArrayList<String>();

    public String toString() {
        String res = "";
        for (String line : code) res += line + "\n";
        return res;
    }

    public File ladeFile() throws FileNotFoundException {
        File file = null;//Dateiauswahlfenster auf derzeitigen Projektordner
        JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
        int state = fc.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        else {
            throw new FileNotFoundException("Auswahl abgebrochen");
        }
        return file;
    }

    // Aufgabe 1
    public void ladeCode(File f) {
        //laedt einen Java-Quelltext aus der angegebenen Datei
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Konnte Datei nicht finden!");
            System.exit(1);
        }
        this.ladeCode(sc);
        sc.close();
    }

    private void ladeCode(Scanner sc) {
        //laedt einen Java-Quelltext mit Hilfe des angegebenen Scanners
        while (sc.hasNextLine()) {
            this.code.add(sc.nextLine());
        }
    }

    public void schreibeCode(File f) {
        //Schreibt den Code in die angegebene Datei
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            System.out.println("Konnte Datei nicht finden!");
            System.exit(1);
        }
        this.schreibeCode(pw);
        pw.close();
    }

    private void schreibeCode(PrintWriter pw) {
        //Schreibt den Code mit Hilfe des angegebenen PrintWriters
        for (String line : this.code) {
            pw.println(line);
        }
    }

    // Aufgabe 2    
    public void ladeCode(URL url) throws IOException {
        URLConnection con = url.openConnection();  
        Object content = con.getContent();  
        Scanner sc = new Scanner((InputStream) content);  
        this.ladeCode(sc);
    }

    // Aufgabe 3
    public void ladeCode() {
        File f = null;
        try {
            f = ladeFile();
        } catch (FileNotFoundException e) {
            System.out.println("Datei " + f + " nicht gefunden.");
            System.exit(1);
        }
        
        ladeCode(f);
    }

    public void schreibeCode() {
        File f = null;
        try {
            f = ladeFile();
        } catch (FileNotFoundException e) {
            System.out.println("Datei " + f + " nicht gefunden.");
            System.exit(1);
        }
        
        schreibeCode(f);
    }
    
    // Aufgabe 4
    public void entferneKommentare() {
        //Entfernt alle Kommentare im Code
        boolean multiline = false;

        for(int i = 0; i < code.size(); i++) {
            // Einzeilige Kommentare entfernen
            code.set(i, code.get(i).split("//")[0]);
            
            // Mehrzeilige Kommentare entfernen
            if(code.get(i).contains("/*"))
                multiline = true;
            if(code.get(i).contains("*/"))
                multiline = false;
            if(multiline || code.get(i).contains("*/"))
                code.set(i, "");
        }
    }

    public static void main(String[] args) {
        JavaCode jc = new JavaCode();
        /*try {
            jc.ladeCode(new URL("https://paddel.xyz/matse/KommentarTest.java"));
        } catch (IOException e) {
            // TESTING IDC
            e.printStackTrace();
        }*/
        File src = new File("KommentarTest.java");
        File dest = new File("KommentarTest_copy.java");
        jc.ladeCode(src);
        jc.entferneKommentare();
        jc.schreibeCode(dest);
    }
}
