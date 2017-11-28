package control;

import objects.Member;
import objects.Provider;
import objects.Visit;
import objects.Service;
import control.ChocAnControl;
import interfaces.UserInterface;
import java.util.Date;
import java.util.Scanner;

public class ServiceControl {
	private long code;
	private Date date;
	private String comments;
	Scanner sc = new Scanner(System.in); 
	Service service = new Service();
	String commentString = "";
	int i = 0;
	
	
	public ServiceControl(long c, Date d, String com) {
		code = c;
		date = d;
		comments = com;
		ChocAnControl ChocAn = new ChocAnControl();
	}
	
	/**
	 * This method is used by providers to create new visits for members.
	 * 
	 * @param Member, Provider.
	 * @return boolean.
	 */
	public boolean createVisit(Member m, Provider p, Service s){
		Visit newVisit = new Visit(date, m, p, s);
		return true;
	}
	
	/**
	 * This method displays the name of the visit (service) on the screen for the provider and member.
	 * 
	 * @param long.
	 * @return void.
	 * 
	 */
	public void displayName(long c) {
		for(i = 0; i < 5; ++i) {
			if(service.getCode() == c) {
				ChocAn.userInterface.prompt(service.getName());
				return;
			}
		}
		
		ChocAn.userInterface.prompt("Error: Service not found.");
	}
	
	/**
	 * This method allows providers to enter comments on visits created.
	 * 
	 * @param none.
	 * @return void.
	 */
	public void enterComments() {
		ChocAnControl.userInterface.prompt("Enter comments:");
		commentString = sc.next();
		commentString += sc.nextLine();
		return;
	}
	
	/**
	 * This method displays an error in the event of invalid information being entered or other issues.
	 * 
	 * @param none.
	 * @return void.
	 */
	public void displayError() {
		ChocAnControl.userInterface.prompt("Error");
	}
}
