
/**
 * Eine Exception, die geworfen werden kann, wenn ein Zug ungueltig ist.
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
	public WrongMoveException(String s) {
		super(s);
	}
}
