package interfaces;

import java.util.Scanner;

import control.ChocAnControl;

public class ManagerInterface extends UserInterface {
	//boolean l = false;
	boolean reportGenerated = false; 				// default is false
	long manager_id;												//variable to store manager id
	static Scanner scan;
	static String input;

	public ManagerInterface() {				//Constructor
		scan = new Scanner(System.in);	//Defining a new scanner
	}

	/**
  * This method is used for providers to login
  *
  * @param none.
  * @return boolean.
  */
	public boolean login() {
		boolean success = false;

		UserInterface.prompt("Enter Manager ID or type 'x' to exit:");
		input = scan.next();
        if(input.equals("x")) {					//checks if the manager wants to exit
          return false;
        }
        else {
		manager_id = Long.parseLong(input);

		for (int i = 0; i < ChocAnControl.managerIds.size(); i++) {		//checks if manager login exists
			if (ChocAnControl.managerIds.get(i).equals(manager_id)) {
				success = true;
				break;
			}
		}
		if (success == true) {																				//login exists
			UserInterface.prompt("Manager Login Successful");
			return true;
		} else {																											//login doesnt exist
			UserInterface.prompt("Incorrect Manager Login - try again");
			return login();
		}
        }
	}

	/**
  * This method lists the options that a given operator can take
  *
  * @param none.
  * @return String.
  */
	public static String managerMenu() {

		boolean menuActive = true;

		while(menuActive) {															//stays active until the manager decides to logout
			UserInterface.prompt("\n\n");
			UserInterface.prompt("**************************");
			UserInterface.prompt("** Choc-An Manager Menu **");
			UserInterface.prompt("**************************");
			UserInterface.prompt("");
			UserInterface.prompt("Enter a selection:");
			UserInterface.prompt("Generate Member Reports - \"member\"");
			UserInterface.prompt("Generate Provider Reports - \"provider\"");
			UserInterface.prompt("Generate Summary Reports - \"summary\"");
			UserInterface.prompt("Generate EFT files - \"eft\"");
			UserInterface.prompt("Log Out and return to main menu - \"logout\"");
			input = scan.next();
			switch(input) {
			case "member":
				UserInterface.prompt("Generating Member reports...");
				produceMemberReport();												//calls the method to create the member report
				UserInterface.prompt("...done.");
				break;

			case "provider":
				UserInterface.prompt("Generating Provider reports...");
				produceProviderReport();											//calls the method to create the provider report
				UserInterface.prompt("...done.");
				break;

			case "summary":
				UserInterface.prompt("Generating Summary reports...");
				produceManagerSummary();											//calls the method to create the manager summary
				UserInterface.prompt("...done.");
				break;

			case "eft":
				UserInterface.prompt("Generating EFT files...");
				produceEFTReport();														//calls the method to create the EFT report
				UserInterface.prompt("...done.");
				break;

			case "logout":																	//calls the method to log the manager out
				menuActive = false;
				break;

			default:																				//default method if an invalid selection is made
				UserInterface.prompt("Invalid selection, try again.");
				break;

			}

		}
		return "login";
	}

	/**
  * This is the option a manager can take to produce the member report
  *
  * @param none.
  * @return boolean.
  */
	public static boolean produceMemberReport() {
		ChocAnControl.mainProcedure.produceMemberReports();							//calls the member report production method from main procedure
		return true;
	}

	/**
  * This is the option a manager can take to produce the provider report
  *
  * @param none.
  * @return boolean.
  */
	public static boolean produceProviderReport() {
		ChocAnControl.mainProcedure.produceProviderReports();				//calls the provider report production method from main procedure
		return true;
	}

	/**
  * This is the option a manager can take to produce the manager summary
  *
  * @param none.
  * @return boolean.
  */
	public static boolean produceManagerSummary() {
		ChocAnControl.mainProcedure.produceManagerSummary();				//calls the manager summary production method from main procedure
		return true;
	}

	/**
  * This is the option a manager can take to produce the EFT report
  *
  * @param none.
  * @return boolean.
  */
	public static boolean produceEFTReport(){
		ChocAnControl.mainProcedure.produceEFT();										//calls the EFT report production method from main procedure
		return true;
	}
}
