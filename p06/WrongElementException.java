
public class WrongElementException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int index;
	
	public WrongElementException(int i) {
		
		super("Typ des Elements stimmt nicht" + i);
		this.index = i;
	}
	
	public int getIndex() {
		return this.index;
	}
}
