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
	public void areYouSure() {
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
			else { memToAdd.accountStatus = false; }
			
			ChocAn.members.add(memToAdd);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean editMember() {
		boolean out = false;
		int memNum;
		long memID;
		String query;
		ChocAn.userInterface.prompt("Enter member ID");					//Access prompt
		memID = scan.nextLong();
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).id == memID)  {
				out = true;
				memNum = i;
			}
		}
		if(out) {
			ChocAn.userInterface.prompt("Enter member ID");					//Access prompt
			query = scan.nextLine();
			return false;
		}
		else {
			return false;
		}
	}
	public boolean deleteMember() {
		return true;
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
