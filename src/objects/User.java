package objects;

public class User {
	
	String name;
	long id;
	String address;
	String city;
	String zipCode;
	String state;
	
	public User(String name, long ID, String add, String city, String zip, String st) {
		this.name = name;
		this.id = ID;
		this.address = add;
		this.city = city;
		this.zipCode = zip;
		this.state = st;
	}
	
}
