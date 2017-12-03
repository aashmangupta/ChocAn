package control;

import objects.Member;
import objects.Provider;
import control.ChocAnControl;
import objects.Visit;
import objects.Service;
import interfaces.UserInterface;
import java.util.Scanner;

public class ServiceControl {
	private Scanner sc;
	private Service service;
	private String commentString;
	private Member mem;
	private Provider pro;
	int i;
	private long code;
	private Date date;
	private Scanner sc = new Scanner(System.in);
	private Service service = new Service();
	private String commentString = "";
	private Member mem = new Member();
	private Provider pro = new Provider();
	int i = 0;

	public ServiceControl() {
		sc = new Scanner(System.in);
		service = new Service();
		commentString = "";
		mem = new Member();
		pro = new Provider();
		i = 0;
	}

	/**
	 * This method is used by providers to create new visits for members.
	 *
	 * @param Member, Provider.
	 * @return boolean.
	 */
	public boolean createVisit(long m, long p, Service s){

	    UserInterface.prompt("Attempting to generate visit");
		//loop to find member
		for(i = 0; i < ChocAnControl.members.size(); ++i) {
			if(ChocAnControl.members.get(i).id == m) {
				mem = ChocAnControl.members.get(i);
			}
		}
		//loop to find provider
		for(i = 0; i < ChocAnControl.providers.size(); ++i) {
			if(ChocAnControl.providers.get(i).id == m) {
				pro = ChocAnControl.providers.get(i);
			}
		}
		date = new Date();	//gets current time and date
		Visit newVisit = new Visit(mem, pro, s, date);	//creates visit
		PrintWriter out = new PrintWriter("visits.txt");	//writing to a separate text file
		out.println(mem);
		out.println(pro);
		out.println(s);
		out.println(date);
		ChocAnControl.visits.add(newVisit);	//stores visit in ArrayList
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
				UserInterface.prompt(service.getName());
				return;
			}
		}

		UserInterface.prompt("Error: Service not found.");
	}

	/**
	 * This method allows providers to enter comments on visits created.
	 *
	 * @param none.
	 * @return void.
	 */
	public void enterComments() {
		UserInterface.prompt("Enter comments:");
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
		UserInterface.prompt("Error");
	}
}
