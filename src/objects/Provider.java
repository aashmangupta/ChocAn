package objects;

public class Provider extends User{
	
	int totalFees;
	int totalVisits;	
	
	public Provider() {
		super("John Doe", 123456789, "001 main street", "town", "000001", "state");
		this.totalFees = 0;
		this.totalVisits = 0;
	}
	
	public Provider(String name, long ID, String add, String city, String zip, String st, 
			int fees, int visits) {
		super(name, ID, add, city, zip, st);
		this.totalFees = fees;
		this.totalVisits = visits;
	}
	
}
