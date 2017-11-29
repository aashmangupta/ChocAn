package control;

//import java.util.ArrayList;

import objects.Member;
import objects.Provider;
import control.ChocAnControl;
import interfaces.UserInterface;
import java.util.Scanner;

public class UserManager {
	
	ChocAnControl ChocAn;
	Scanner scan;
	
	public UserManager() {
		ChocAn = new ChocAnControl();
		scan = new Scanner(System.in);
	}
	
	/**
	   * This is the check function to make sure the user wants to delete a user.
	   * 
	   * @return boolean
	   */
	public boolean areYouSure() {
		String check;
		UserInterface.prompt("Are you sure that you want to delete? (yes/no)");					//Access prompt
		check = scan.nextLine();
		if(check.equals("yes")) {
			return true;
		}												//Check to make sure 
		else {
			return false;
		}
		//Prompt user to make sure they do want to delete a user
	}
	
	/**
	   * This is the function initiated by the user to add a new member to the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean addMember() {
		boolean out = true;											//Check variable to make sure the member exists and is created
		long memID;													//Scan variable to take in member ID to make sure it doesnt exist
		int stat;													//Scan int variable to use as glorified scan boolean
		UserInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		Member memToAdd;
		for(int i = 0; i < ChocAnControl.members.size(); i++) {				//Search member list (arrayList in control) 
			if(ChocAnControl.members.get(i).id == memID)  {					//To see if member already exists
				out = false;
			}
		}
		if(out) {
			memToAdd = new Member();
			memToAdd.id = memID;
			UserInterface.prompt("Enter member name");							//Access prompt
			memToAdd.name = scan.nextLine();
			UserInterface.prompt("Enter member address");						//Access prompt
			memToAdd.address = scan.nextLine();
			UserInterface.prompt("Enter member city");							//Access prompt
			memToAdd.city = scan.nextLine();
			UserInterface.prompt("Enter member zip code");						//Access prompt
			memToAdd.zipCode = scan.nextLine();
			UserInterface.prompt("Enter member state");							//Access prompt
			memToAdd.state = scan.nextLine();
			UserInterface.prompt("Enter account stauts: 1-active, 0-suspended");	//Access prompt
			stat = scan.nextInt();
			if(stat == 1) { memToAdd.accountStatus = true; }
			if(stat == 0) { memToAdd.accountStatus = false; }
			
			ChocAnControl.members.add(memToAdd);						//Add member to the arrayList in control
			return true;
		}
		else {
			return false;
		}
	}
	/**
	   * This is the function initiated by the user to edit an existing member in the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean editMember() {
		boolean out = false;						//Check variable to make sure the member exists and is edited
		int memNum = 0;								//Starting the member in the array index
		long memID;									//Scan variable to take in member ID to look for/edit
		int test;									//Glorified boolean to use with scan
		String query = "none";						//String check for editing while loop
		UserInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		for(int i = 0; i < ChocAnControl.members.size(); i++) {
			if(ChocAnControl.members.get(i).id == memID)  {					//Check arrayList in control to find the referenced member
				out = true;
				memNum = i;
			}
		}
		if(out) {
			while(query != "stop") {
				if(out) {
					UserInterface.prompt("What do you want to edit? (ID, name, add, city, zip, st, status) (stop) to end edit");					//Access prompt
					query = scan.nextLine();
					if(query.equals("ID")) {
						UserInterface.prompt("Enter new member ID");					//Access prompt
						ChocAnControl.members.get(memNum).id = scan.nextLong();
						memID = ChocAnControl.members.get(memNum).id;
					}
					else if(query.equals("name")) {
						UserInterface.prompt("Enter new member name");					//Access prompt
						ChocAnControl.members.get(memNum).name = scan.nextLine();
					}
					else if(query.equals("add")) {
						UserInterface.prompt("Enter new member address");					//Access prompt
						ChocAnControl.members.get(memNum).address = scan.nextLine();
					}
					else if(query.equals("city")) {
						UserInterface.prompt("Enter new member city");					//Access prompt
						ChocAnControl.members.get(memNum).city = scan.nextLine();
					}
					else if(query.equals("zip")) {
						UserInterface.prompt("Enter new member zipCode");					//Access prompt
						ChocAnControl.members.get(memNum).zipCode = scan.nextLine();
					}
					else if(query.equals("st")) {
						UserInterface.prompt("Enter new member state");					//Access prompt
						ChocAnControl.members.get(memNum).state = scan.nextLine();
					}
					else if(query.equals("status")) {
						UserInterface.prompt("Enter new member status (1 for active, 0 for suspended");					//Access prompt
						test = scan.nextInt();
						if(test == 0) { ChocAnControl.members.get(memNum).accountStatus = true; }
						if(test == 1) { ChocAnControl.members.get(memNum).accountStatus = false; }
						
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	   * This is the function initiated by the user to remove a member in the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean deleteMember() {
		boolean out = false;										//Boolean to see if member exists and if deleted
		int memNum = 0;												//Int variable to represent the index in the member arrayList
		long memID;													//Scan variable to take in member ID to look for/edit
		UserInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).id == memID)  {				//Find the input member ID to set index for later use
				out = true;										
				memNum = i;
			}
		}
		
		if(out) {													//If found then remove that indexed member from the arrayList
			if(areYouSure()) {
				ChocAnControl.members.remove(memNum);
				return true;
			}
			else {																			//otherwise report error
				UserInterface.prompt("The member with ID" + memID + "was not deleted");
				return false;
			}
		}
		else {																				//otherwise report error
			UserInterface.prompt("The member with ID" + memID + "does not exist");
			return false;
		}
	}
	
	/**
	   * This is the function initiated by the user to add a new provider to the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean addProvider() {
		boolean out = true;											//Check variable to make sure the provider exists and is created
		long provID;												//Scan variable to take in provider ID to look for/edit
		UserInterface.prompt("Enter provider ID");					//Access prompt
		provID = scan.nextLong();
		Provider provToAdd;									
		for(int i = 0; i < ChocAnControl.providers.size(); i++) {		//Check to see if member by that ID already exists
			if(ChocAnControl.providers.get(i).id == provID)  {
				out = false;
			}
		}
		if(out) {													//If its not found then create it
			provToAdd = new Provider();	
			provToAdd.id = provID;
			UserInterface.prompt("Enter provider name");			//Access prompt
			provToAdd.name = scan.nextLine();
			UserInterface.prompt("Enter provider address");			//Access prompt
			provToAdd.address = scan.nextLine();
			UserInterface.prompt("Enter provider city");			//Access prompt
			provToAdd.city = scan.nextLine();
			UserInterface.prompt("Enter provider zip code");		//Access prompt
			provToAdd.zipCode = scan.nextLine();
			UserInterface.prompt("Enter provider state");			//Access prompt
			provToAdd.state = scan.nextLine();
			UserInterface.prompt("Enter the number of visits");		//Access prompt
			provToAdd.totalVisits = scan.nextInt();
			UserInterface.prompt("Enter the total cost of fees");	//Access prompt
			provToAdd.totalFees = scan.nextInt();
			
			ChocAnControl.providers.add(provToAdd);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	   * This is the function initiated by the user to edit an existing provider in the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean editProvider() {
		boolean out = false;
		int provNum = 0;
		long provID;
		//int test;
		String query = "none";
		UserInterface.prompt("Enter provider ID");					//Access prompt
		provID = scan.nextLong();
		for(int i = 0; i < ChocAnControl.providers.size(); i++) {
			if(ChocAnControl.providers.get(i).id == provID)  {
				out = true;
				provNum = i;
			}
		}
		while(query != "stop") {
			if(out) {
				UserInterface.prompt("What do you want to edit? "
						+ "(ID, name, add, city, zip, st, fees, visits) (stop) to end edit");					//Access prompt
				query = scan.nextLine();
				if(query.equals("ID")) {
					UserInterface.prompt("Enter new member ID");					//Access prompt
					ChocAnControl.providers.get(provNum).id = scan.nextLong();
					provID = ChocAnControl.providers.get(provNum).id;
				}
				else if(query.equals("name")) {
					UserInterface.prompt("Enter new member name");					//Access prompt
					ChocAnControl.providers.get(provNum).name = scan.nextLine();
				}
				else if(query.equals("add")) {
					UserInterface.prompt("Enter new provider address");					//Access prompt
					ChocAnControl.providers.get(provNum).address = scan.nextLine();
				}
				else if(query.equals("city")) {
					UserInterface.prompt("Enter new provider city");					//Access prompt
					ChocAnControl.providers.get(provNum).city = scan.nextLine();
				}
				else if(query.equals("zip")) {
					UserInterface.prompt("Enter new provider zipCode");					//Access prompt
					ChocAnControl.providers.get(provNum).zipCode = scan.nextLine();
				}
				else if(query.equals("st")) {
					UserInterface.prompt("Enter new member state");					//Access prompt
					ChocAnControl.providers.get(provNum).state = scan.nextLine();
				}
				else if(query.equals("visits")) {
					UserInterface.prompt("Enter new number of visits");					//Access prompt
					ChocAnControl.providers.get(provNum).totalVisits = scan.nextInt();					
				}
				else if(query.equals("fees")) {
					UserInterface.prompt("Enter new provider fee total");					//Access prompt
					ChocAnControl.providers.get(provNum).totalFees = scan.nextInt();
				}
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	/**
	   * This is the function initiated by the user to remove a provider in the system list.
	   * @param
	   * @return boolean 
	   */
	public boolean deleteProvider() {
		boolean out = false;
		int provNum = 0;
		long provID;
		UserInterface.prompt("Enter provider ID");					//Access prompt
		provID = scan.nextLong();
		for(int i = 0; i < ChocAnControl.providers.size(); i++) {
			if(ChocAnControl.providers.get(i).id == provID)  {
				out = true;
				provNum = i;
			}
		}
		if(out) {
			if(areYouSure()) {
				ChocAnControl.providers.remove(provNum);
				return true;
			}
			else {
				UserInterface.prompt("The provider with ID: " + provID + " :was not deleted");
				return false;
			}
		}
		else {
			return false;
		}
	}

}
