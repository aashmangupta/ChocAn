package objects;

//Coded by Ben Sanders

import java.util.Date;

public class Visit {
	public Date dateOfService;
	public Member member = new Member();
	public Provider provider = new Provider();
	public Service service = new Service();
	public String comments;
	
	public Visit() {
		
	}
	
	public Visit(Member m, Provider p, Service s, String comment) {
		dateOfService = new Date();
		member = m;
		provider = p;
		service = s;
		comments = comment;
	}
	
	/**
	 * This method gets the Date of the visit.
	 * 
	 * @param none.
	 * @return Date, this returns the date the visit is on.
	 */
	public Date getDate() {
		return dateOfService;			//returns date of service
	}
	
	/**
	 * This method sets a new date for the visit.
	 * 
	 * @param newDate, a new date for the visit to be set to.
	 * @return void.
	 */
	public void setDate(Date newDate) {
		dateOfService = newDate;			//sets new date
	}
	
}

