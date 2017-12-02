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
  }

  public static void addMember(){
	  UserManager usermanager = new UserManager();
      usermanager.addMember();
  }
  public static void editMember(){
	  UserManager usermanager = new UserManager();
      usermanager.editMember();
  }
  public static void deleteMember(){
	  UserManager usermanager = new UserManager();
	  usermanager.deleteMember();
  }
  public static void addProvider(){
	  UserManager usermanager = new UserManager();
	  usermanager.addProvider();
  }
  public static void editProvider(){
    UserManager usermanager = new UserManager();
    usermanager.editProvider();
  }
  public static void deleteProvider(){
	UserManager usermanager = new UserManager();
    usermanager.deleteProvider();
  }

  public static String operatorMenu() {
	
	boolean menuActive = true;
	
	while(menuActive){
		UserInterface.prompt("\n\n");
		UserInterface.prompt("**************************");
		UserInterface.prompt("** Choc-An Operator Menu **");
		UserInterface.prompt("**************************");
		UserInterface.prompt("");
		UserInterface.prompt("Enter a selection:");
		UserInterface.prompt("Add Member - \"addm\"");
		UserInterface.prompt("Edit Member - \"editm\"");
		UserInterface.prompt("Delete Member - \"deletem\"");
		UserInterface.prompt("Add Provider - \"addp\"");
		UserInterface.prompt("Edit Provider - \"editp\"");
		UserInterface.prompt("Delete Provider - \"deletep\"");
		UserInterface.prompt("Log Out and return to main menu - \"logout\"")
		input = scan.next();
		switch(input){
		case "addm":
			UserInterface.prompt("Adding member...");
			addMember();
			break;
	
		case "editm":
			UserInterface.prompt("Editing member...");
			editMember();
			break;
	
		case "deletem":
			UserInterface.prompt("Deleting member...");
			deleteMember();
			break;
	
		case "addprovider":
			UserInterface.prompt("Adding provider...");
			addProvider();
			break;
	
		case "editprovider":
			UserInterface.prompt("Editing provider...");
			editProvider();
			break;
		
		case "deleteprovider":
			UserInterface.prompt("Delete provider...");
			editProvider();
			break;
	
		case "logout":
			menuActive = false;
			break;
	
		default:
			UserInterface.prompt("Invalid selection, try again");
			break;
		}
	}
	return "login";
	
}
  
}
