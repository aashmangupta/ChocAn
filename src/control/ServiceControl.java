
import java.util.Date;

public class ServiceControl {
	public long code;
	public Date date;
	public String comments;
	
	public ServiceControl(long c, Date d, String com) {
		code = c;
		date = d;
		comments = com;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public boolean creatVisit(Member m, Provider p){
		Visit visit = new Visit(date, m, p, s);
		
	}
	
	/**
	 * 
	 */
	public void displayName(long c) {
		
	}
	
	/**
	 * 
	 */
	public void enterComments() {
		
	}
	
	/**
	 * 
	 */
	public void displayError() {
		
	}
}
