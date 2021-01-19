

/**
 * Eine Klasse die eine Liste mit Objekten eines beliebigen Datentyps enthält.
 * 
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 */
public class MyArrayList<T> {
    // Array zum speichern der Elemente
    private T[] arr;
    // int um festzuhalten welche Elemente des Arrays schon beschrieben sind.
    private int index;

    /**
     * Konstruktor um eine neue leere Liste zu erstellen.
     * 
     */
    MyArrayList() {
        this.arr = (T[]) new Object[10];
        this.index = 0;
    }

    /**
     * Fuegt ein Element hinten an die Liste an.
     * 
     * @param element Das Element das eingefuegt wird.
     */
    public void addLast(T element) {
        if (this.index >= this.arr.length) {
            Object[] temp = new Object[2*arr.length];
            System.arraycopy(this.arr, 0, temp, 0, this.arr.length);
            arr = (T[]) temp;
        }
        this.arr[this.index] = element;
        this.index += 1;
    }

    /**
     * Fuegt ein Element vorne an die Liste an. 
     * 
     * @param element Das Element das eingefuegt wird.
     */
    public void addFirst(T element) {
        if (this.index >= arr.length) {
            Object[] temp = new Object[2*arr.length];
            System.arraycopy(this.arr, 0, temp, 1, this.arr.length);
            arr = (T[]) temp;
        } else {
            System.arraycopy(this.arr, 0, this.arr, 1, this.index);
        }
        this.arr[0] = element;
        this.index += 1;
    }

    /**
     * Gibt das Element an Stelle i zurueck.
     * 
     * @throws ArrayIndexOutOfBoundsException Falls der index zu gross oder negativ ist.
     * @param i Index des zurueckzugebenden Elements.
     * @return Element an der Stelle i in der Liste.
     */
    public T get(int i) {
        if (i < 0 || i >= this.index) {
            throw new ArrayIndexOutOfBoundsException("Index zu gross oder zu klein.");
        } else {
            return this.arr[i];
        }
    }

    /**
     * loescht den gesamten Inhalt der Liste.
     * 
     */
    public void clear() {
        this.arr = (T[]) new Object[10];
        this.index = 0;
    }

    /**
     * Gibt die Laenge der Liste zurueck.
     * 
     * @return Laenge der Liste.
     */
    public int size() {
        return this.index;
    }
}