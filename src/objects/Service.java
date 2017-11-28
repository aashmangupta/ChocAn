package objects;

public class Service {
	private String name;
	private long code;
	private int fee;
	
	public Service() {
	}
	
	public Service(String n, long c, int f) {
		name = n;
		code = c;
		fee = f;
	}
	
	private void setVar() {
		name = name;
		code = code;
		fee = fee;
	}
	
	/**
	 * This
	 * 
	 * @param none.
	 * @return code.
	 */
	public long getCode() {
		return code;
	}
}
