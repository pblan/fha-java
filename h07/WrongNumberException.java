
<<<<<<< HEAD
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
=======
public class WrongNumberException extends RuntimeException{

	private static final long serialVersionUID = 1L;

>>>>>>> 16149a3f418eb74432bd57c8e0747541722fe108
	public WrongNumberException(String s) {
		super(s);
	}
}
