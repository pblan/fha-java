public class WrongElementException extends RuntimeException {
    private int index;

    public WrongElementException(int i) {
        super("Wrong data element in " + i);
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}