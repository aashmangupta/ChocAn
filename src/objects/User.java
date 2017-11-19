package objects;

public class User {
	
	public String name;
	public long id;
	public String address;
	public String city;
	public String zipCode;
	public String state;
	
	public User(String name, long ID, String add, String city, String zip, String st) {
		this.name = name;
		this.id = ID;
		this.address = add;
		this.city = city;
		this.zipCode = zip;
		this.state = st;
	}
	
}
