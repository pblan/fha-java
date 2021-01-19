
/**
 * Wird geworfen wenn die Zahl ungueltig ist.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public class WrongNumberException extends RuntimeException{
	/**
	 * Konstruktor! (Warum muss ich die scheisse kommentieren?)
	 * 
	 * @param s String, der in der Exception angezeigt wird.
	 */
	public WrongNumberException(String s) {
		super(s);
	}
}
