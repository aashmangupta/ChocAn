package interfaces;

import control.UserManager;
import java.util.Scanner;
import control.ChocAnControl;

//Created by Spencer Fuhriman

public class OperatorInterface extends UserInterface {
	//boolean logged_in = false;					//default is false
	public long operator_id;						//variable to store operator id
	static String input;
	static Scanner scan;

  public OperatorInterface(){				//Constructor
    scan = new Scanner(System.in);	//Defining a new scanner
  }

	/**
  * This method is used for providers to login
  *
  * @param none.
  * @return boolean.
  */
  public boolean login(){
	 boolean success = false;

	UserInterface.prompt("Enter Operator ID or type 'x' to exit:");
	input = scan.next();
	if (input.equals("x")){								//checks if the manager wants to exit
		return false;
	}
	else {
		operator_id = Long.parseLong(input);

    for (int i = 0; i < ChocAnControl.operatorIds.size(); i++){       //checks if operator login exists
      if (ChocAnControl.operatorIds.get(i) == (operator_id)) {
    	  success = true;
    	  break;
      }
    }
    if (success == true){																						//login exists
      UserInterface.prompt("Operator Login Successful");
      //logged_in = true;
      return true;
    }
    else {																													//login doesnt exist
      UserInterface.prompt("Incorrect Operator Login");
      return login();
    }
	}
  }

	/**
  * This is the option an operator can take to add a member
  *
  * @param none.
  * @return void.
  */
  public static void addMember(){
	  UserManager usermanager = new UserManager();
      usermanager.addMember();																		//calls the method to add a member
  }

	/**
  * This is the option an operator can take to edit a member
  *
  * @param none.
  * @return void.
  */
  public static void editMember(){
	  UserManager usermanager = new UserManager();
      usermanager.editMember();																	//calls the method to edit a member
  }

	/**
  * This is the option an operator can take to delete a member
  *
  * @param none.
  * @return void.
  */
  public static void deleteMember(){
	  UserManager usermanager = new UserManager();
	  usermanager.deleteMember();																	//calls the method to delete a member
  }

	/**
  * This is the option an operator can take to add a provider
  *
  * @param none.
  * @return void.
  */
  public static void addProvider(){
	  UserManager usermanager = new UserManager();
	  usermanager.addProvider();																//calls the method to add a provider
  }

	/**
  * This is the option an operator can take to edit a provider
  *
  * @param none.
  * @return void.
  */
  public static void editProvider(){
    UserManager usermanager = new UserManager();
    usermanager.editProvider();																//calls the method to edit a provider
  }

	/**
  * This is the option an operator can take to delete a provider
  *
  * @param none.
  * @return void.
  */
  public static void deleteProvider(){
	UserManager usermanager = new UserManager();
    usermanager.deleteProvider();														//calls the method to delete a provider
  }

	/**
  * This method lists the options that a given operator can take
  *
  * @param none.
  * @return String, lets the software know the user is logged in
  */
  public static String operatorMenu() {

	boolean menuActive = true;

	while(menuActive){															//stays active until the operator decides to logout
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
		UserInterface.prompt("Log Out and return to main menu - \"logout\"");
		input = scan.next();
		switch(input){
		case "addm":
			UserInterface.prompt("Adding member...");
			addMember();																			//calls the method to add a member
			break;

		case "editm":
			UserInterface.prompt("Editing member...");
			editMember();																			//calls the method to edit a member
			break;

		case "deletem":
			UserInterface.prompt("Deleting member...");
			deleteMember();																	 //calls the method to delete a member
			break;

		case "addp":
			UserInterface.prompt("Adding provider...");
			addProvider();																	//calls the method to add a provider
			break;

		case "editp":
			UserInterface.prompt("Editing provider...");
			editProvider();																	//calls the method to edit a provider
			break;

		case "deletep":
			UserInterface.prompt("Deleting provider...");
			deleteProvider();																//calls the method to delete a provider
			break;

		case "logout":																		//logs the operator out
			menuActive = false;
			break;

		default:																					//default method if an invalid selection is made
			UserInterface.prompt("Invalid selection, try again");
			break;
		}
	}
	return "login";

}

}
