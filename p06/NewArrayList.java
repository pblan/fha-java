import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class NewArrayList extends ArrayList<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add(String x) {
//		if(isInt(x) == true) {
//			add(Integer.parseInt(x));
//		} else if (isDouble(x)) {
//			add(Double.parseDouble(x));
//		} else {
//			super.add(x);
//		}
		
		Scanner sc = new Scanner(x);
		sc.useLocale(Locale.US);
		if (sc.hasNextInt()==true) {
			add(Integer.parseInt(x));
		} else if (sc.hasNextDouble()==true) {
			add(Double.parseDouble(x));
		} else {
			super.add(x);
		}
		sc.close();
	}
	
	public void add(int x) {
		super.add(Integer.valueOf(x));
	}
	
	public void add(double x) {
		super.add(Double.valueOf(x));
	}
	
	boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	public ArrayList<Integer> getIntegers() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i) instanceof Integer) list.add((Integer) this.get(i));
		}
		return list;
	}
	

	public ArrayList<Double> getDoubles() {
		ArrayList<Double> list = new ArrayList<>();
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i) instanceof Double) list.add((Double) this.get(i));
		}
		return list;
	}
	
	public ArrayList<String> getStrings() throws WrongElementException {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < this.size(); i++) {
			if(!((this.get(i) instanceof Integer) || (this.get(i) instanceof Integer) || (this.get(i) instanceof String))) {
				throw new WrongElementException(i);
			} else {
				list.add(this.get(i).toString());
			}
		}
		return list;
	}
}
