package objects;

//BUILT BY: DEREK HASTINGS

public class Member extends User{
	
	public boolean accountStatus;
	
	public Member() {
		super("John Doe", 123456789, "001 main street", "town", "000001", "state");
		this.accountStatus = true;
	}
	
	public Member(String name, long ID, String add, String city, String zip, String st, 
			boolean status) {
		super(name, ID, add, city, zip, st);
		this.accountStatus = status;
	}
	
}
