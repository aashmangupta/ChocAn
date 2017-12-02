package interfaces;

import control.UserManager;
import java.util.Scanner;
import control.ChocAnControl;

public class OperatorInterface extends UserInterface {
	boolean logged_in = false;
	public long operator_id;
	static String input;
	static Scanner scan;
	
  public OperatorInterface(){
  }

  public boolean login(){
	 boolean success = false;
	
	UserInterface.prompt("Enter Operator ID or type 'x' to exit:");
	input = scan.next();
	if (input.equals("x")){
		return false;
	}
	else {
		operator_id = Long.parseLong(input);
		
    for (int i = 0; i < ChocAnControl.operatorIds.size(); i++){       //provider_data_user has to be an array from the main program
      if (ChocAnControl.operatorIds.get(i) == (operator_id)) {
    	  success = true;
    	  break;
      }
      }
    if (success == true){
      UserInterface.prompt("Operator Login Successful");
      logged_in = true;
      return true;
    }
    else {
      UserInterface.prompt("Incorrect Operator Login");
      return login();
    }
  }

  public void addMember(){
	  UserManager usermanager = new UserManager();
      usermanager.addMember();
  }
  public void editMember(){
	  UserManager usermanager = new UserManager();
      usermanager.editMember();
  }
  public void deleteMember(){
	  UserManager usermanager = new UserManager();
	  usermanager.deleteMember();
  }
  public void addProvider(){
	  UserManager usermanager = new UserManager();
	  usermanager.addProvider();
  }
  public void editProvider(){
    UserManager usermanager = new UserManager();
    usermanager.editProvider();
  }
  public void deleteProvider(){
	UserManager usermanager = new UserManager();
    usermanager.deleteProvider();
  }

public static String operatorMenu() {
	// TODO Auto-generated method stub
	return null;
}
}
