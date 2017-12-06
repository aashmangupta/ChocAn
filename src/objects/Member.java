package objects;

//BUILT BY: DEREK HASTINGS

public class Member extends User{
	
	public boolean accountStatus;
	
	/**
	   * Constructor.
	   */
	public Member() {
		super("John Doe", 123456789, "001 main street", "town", "000001", "state");
		this.accountStatus = true;
	}
	
	/**
	   * Constructor.
	   * 
	   * @param name, name of the member
	   * @param ID, ID of the member
	   * @param add, address of the member
	   * @param city, city of the member
	   * @param zip, zip code string of the member
	   * @param st, state of the member
	   * @param status, boolean to represent the account status of the member 
	   */
	public Member(String name, long ID, String add, String city, String zip, String st, 
			boolean status) {
		super(name, ID, add, city, zip, st);
		this.accountStatus = status;
	}
	
}
