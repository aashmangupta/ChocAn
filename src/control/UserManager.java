package control;

//import java.util.ArrayList;

import objects.Member;
import objects.Provider;
import control.ChocAnControl;

public class UserManager {
	
	ChocAnControl ChocAn;
	
	public UserManager() {
		ChocAn = new ChocAnControl();
	}
	
	/**
	 * 
	 */
	public void areYouSure() {
		//Prompt user to make sure they do want to delete a user
	}
		
	public boolean addMember() {
		boolean out = true;
		Member memToAdd;
		for(int i = 0; i < ChocAn.members.size(); i++) {
			if(ChocAn.members.get(i).name.equals("member 1"))  {
				out = false;
			}
		}
		if(out) {
			//memToAdd = new Member();
			//memToAdd.name = ChocAn.userInterface.promt();     memToAdd.id = ChocAn.userInterface.prompt();
			//memToAdd.address = ChocAn.userInterface.prompt(); memToAdd.city = ChocAn.userInterface.prompt();
			//memToAdd.zipCode = ChocAn.userInterface.prompt(); memToAdd.state = ChocAn.userInterface.prompt();
			//memToAdd.accountStatus = true;
			ChocAn.members.add(/*memToAdd*/);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean editMember() {
		return true;
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
