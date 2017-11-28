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
	 * 
	 */
	public boolean areYouSure() {
		String check;
		ChocAn.userInterface.prompt("Are you sure that you want to delete? (yes/no)");					//Access prompt
		check = scan.nextLine();
		if(check.equals("yes")) {
			return true;
		}
		else {
			return false;
		}
		//Prompt user to make sure they do want to delete a user
	}
		
	public boolean addMember() {
		boolean out = true;
		long memID;
		int stat;
		ChocAn.userInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		Member memToAdd;
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).id == memID)  {
				out = false;
			}
		}
		if(out) {
			memToAdd = new Member();
			ChocAn.userInterface.prompt("Enter member name");					//Access prompt
			memToAdd.name = scan.nextLine();
			ChocAn.userInterface.prompt("Enter member address");				//Access prompt
			memToAdd.address = scan.nextLine();
			ChocAn.userInterface.prompt("Enter member city");				//Access prompt
			memToAdd.city = scan.nextLine();
			ChocAn.userInterface.prompt("Enter member zip code");			//Access prompt
			memToAdd.zipCode = scan.nextLine();
			ChocAn.userInterface.prompt("Enter member state");					//Access prompt
			memToAdd.state = scan.nextLine();
			ChocAn.userInterface.prompt("Enter account stauts: 1-active, 0-suspended");					//Access prompt
			stat = scan.nextInt();
			if(stat == 1) { memToAdd.accountStatus = true; }
			if(stat == 0) { memToAdd.accountStatus = false; }
			
			ChocAn.members.add(memToAdd);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean editMember() {
		boolean out = false;
		int memNum = 0;
		long memID;
		int test;
		String query = "none";
		ChocAn.userInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).id == memID)  {
				out = true;
				memNum = i;
			}
		}
		while(query != "stop") {
			if(out) {
				ChocAn.userInterface.prompt("What do you want to edit? (ID, name, add, city, zip, st, status) (stop) to end edit");					//Access prompt
				query = scan.nextLine();
				if(query.equals("ID")) {
					ChocAn.userInterface.prompt("Enter new member ID");					//Access prompt
					ChocAn.members.get(memNum).id = scan.nextLong();
					memID = ChocAn.members.get(memNum).id;
				}
				else if(query.equals("name")) {
					ChocAn.userInterface.prompt("Enter new member name");					//Access prompt
					ChocAn.members.get(memNum).name = scan.nextLine();
				}
				else if(query.equals("add")) {
					ChocAn.userInterface.prompt("Enter new member address");					//Access prompt
					ChocAn.members.get(memNum).address = scan.nextLine();
				}
				else if(query.equals("city")) {
					ChocAn.userInterface.prompt("Enter new member city");					//Access prompt
					ChocAn.members.get(memNum).city = scan.nextLine();
				}
				else if(query.equals("zip")) {
					ChocAn.userInterface.prompt("Enter new member zipCode");					//Access prompt
					ChocAn.members.get(memNum).zipCode = scan.nextLine();
				}
				else if(query.equals("st")) {
					ChocAn.userInterface.prompt("Enter new member state");					//Access prompt
					ChocAn.members.get(memNum).state = scan.nextLine();
				}
				else if(query.equals("status")) {
					ChocAn.userInterface.prompt("Enter new member status (1 for active, 0 for suspended");					//Access prompt
					test = scan.nextInt();
					if(test == 0) { ChocAn.members.get(memNum).accountStatus = true; }
					if(test == 1) { ChocAn.members.get(memNum).accountStatus = false; }
					
				}
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public boolean deleteMember() {
		boolean out = false;
		int memNum = 0;
		long memID;
		int test;
		String query = "none";
		ChocAn.userInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).id == memID)  {
				out = true;
				memNum = i;
			}
		}
		if(out) {
			if(areYouSure()) {
				ChocAn.members.remove(memNum);
				return true;
			}
			else {
				ChocAn.userInterface.prompt("The member with ID" + memID + "was not deleted");
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean addProvider() {
		return true;
	}
	public boolean editProvider() {
		return true;
	}
	public boolean deleteProvider() {
		return true;
	}
	
}
