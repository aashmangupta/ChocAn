package objects;

import java.util.Date;

public class Visit {
	private Date dateOfService;
	private Member member = new Member();
	private Provider provider = new Provider();
	private Service service = new Service();
	
	public Visit(Date d, Member m, Provider p, Service s) {
		Date = d;
		member = m;
		provider = p;
		service = s;
	}
	
	public Date getDate() {
		return Date;
	}

	public void setDate(Date newDate) {
		dateOfService = newDate;
	}
	
}

