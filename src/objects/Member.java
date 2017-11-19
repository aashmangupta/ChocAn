package objects;

public class Member extends User{
	
	boolean accountStatus;
	
	public Member(String name, long ID, String add, String city, String zip, String st, 
			boolean status) {
		super(name, ID, add, city, zip, st);
		this.accountStatus = status;
	}
	
}
