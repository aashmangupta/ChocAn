package objects;

public class Provider extends User{
	
	int totalFees;
	int totalVisits;
	User provider;
	
	public Provider(String name, long ID, String add, String city, String zip, String st, 
			int fees, int visits) {
		super(name, ID, add, city, zip, st);
		this.totalFees = fees;
		this.totalVisits = visits;
	}
	
}
