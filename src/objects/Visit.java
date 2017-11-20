package objects;

import java.util.Date;

public class Visit {
	private Date dateOfService;
	private Member member = new Member();
	private Provider provider = new Provider();
	private Service service = new Service();
	
	public Visit(Date d, Member m, Provider p, Service s) {
		dateOfService = d;
		member = m;
		provider = p;
		service = s;
	}
	
	/**
	 * 
	 * @return Date, this returns the date the visit is on.
	 */
	public Date getDate() {
		return Date;
	}
	
	/**
	 * 
	 * @param newDate, a new date for the visit to be set to.
	 */
	public void setDate(Date newDate) {
		dateOfService = newDate;
	}
	
}

