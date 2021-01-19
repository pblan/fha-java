/**
 * Eine Exception die geworfen werden kann, falls eine Position ungueltig ist.
 * 
 */
public class WrongPositionException extends RuntimeException{

    /**
	 * Konstruktor
	 * 
	 * @param s String, der in der Exception angezeigt wird.
	 */
    public WrongPositionException(String s) {
        super(s);
    }
}
