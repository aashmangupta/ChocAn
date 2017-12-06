package objects;

//BUILT BY: DEREK HASTINGS

public class User {
	
	public String name;
	public long id;
	public String address;
	public String city;
	public String zipCode;
	public String state;
	
	/**
	   * Constructor.
	   * 
	   * @param name, name of the user
	   * @param ID, ID of the user
	   * @param add, address of the user
	   * @param zip, zip code string of the user
	   * @param st, state of the user
	   */
	public User(String name, long ID, String add, String city, String zip, String st) {
		this.name = name;
		this.id = ID;
		this.address = add;
		this.city = city;
		this.zipCode = zip;
		this.state = st;
	}
	
}
