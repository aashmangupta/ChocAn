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
	
	
	/**
	 * This method returns the code of the service.
	 * 
	 * @param none.
	 * @return code.
	 */
	public long getCode() {
		return code;
	}
	
	/**
	 * This method returns the name of the service.
	 * 
	 * @param none.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the fee of a service
	 * 
	 * @return fee
	 */
	public int getFee() {
		return fee;
	}
}
