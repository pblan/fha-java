
public class DreizeilenFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		int length = Math.max(String.valueOf(zaehler).length(), String.valueOf(nenner).length());
		StringBuilder st = new StringBuilder();
		
		st.append(String.format("%" + length + "d", zaehler));
		st.append("\n");
		
		for(int i = 0; i < length; i++) {
			st.append("-");
		}
		
		st.append("\n");
		st.append(String.format("%" + length + "d", nenner));
		
		return st.toString();
	}
}
