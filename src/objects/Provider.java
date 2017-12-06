package objects;

//BUILT BY: DEREK HASTINGS

public class Provider extends User{
	
	public int totalFees;
	public int totalVisits;	
	
	/**
	   * Constructor.
	   */
	public Provider() {
		super("John Doe", 123456789, "001 main street", "town", "000001", "state");
		this.totalFees = 0;
		this.totalVisits = 0;
	}
	
	/**
	   * Constructor.
	   * 
	   * @param name, name of the provider
	   * @param ID, ID of the provider
	   * @param add, address of the provider
	   * @param city, city of the provider
	   * @param zip, zip code string of the provider
	   * @param st, state of the provider
	   * @param visits, amount of visits the provider has seen
	   * @param fees, total amout of fees owed to the provider 
	   */
	public Provider(String name, long ID, String add, String city, String zip, String st, 
			int fees, int visits) {
		super(name, ID, add, city, zip, st);
		this.totalFees = fees;
		this.totalVisits = visits;
	}
	
}
