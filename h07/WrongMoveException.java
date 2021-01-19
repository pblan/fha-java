
<<<<<<< HEAD
/**
 * Wird geworfen wenn die Schiebeoperation ungueltig ist.
 * 
 * @author Patrick Blaneck, Felix Racz, Tim Wende
 *
 */
public class WrongMoveException extends RuntimeException{
	/**
	 * Konstruktor
	 * 
	 * @param s String, der in der Exception angezeigt wird.
	 */
=======
public class WrongMoveException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

>>>>>>> 16149a3f418eb74432bd57c8e0747541722fe108
	public WrongMoveException(String s) {
		super(s);
	}
}
