package control;

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
	 * This method is used by providers to create new visits for members.
	 * 
	 * @param Member, Provider.
	 * @return boolean.
	 */
	public boolean createVisit(Member m, Provider p){
		Visit newVisit = new Visit(date, m, p, s);
		
	}
	
	/**
	 * This method displays the name of the visit on the screen for the provider and member.
	 * 
	 * @param long.
	 * @return void.
	 * 
	 */
	public void displayName(long c) {
		//print the name of the visit
	}
	
	/**
	 * This method allows providers to enter comments on visits created.
	 * 
	 * @param none.
	 * @return void.
	 */
	public void enterComments() {
		
	}
	
	/**
	 * This method displays an error in the event of invalid information being entered or other issues.
	 * 
	 * @param none.
	 * @return void.
	 */
	public void displayError() {
		userInterface.prompt("Error");
	}
}
