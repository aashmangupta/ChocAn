package interfaces;

import java.util.Scanner;

import control.ChocAnControl;

public class ManagerInterface extends UserInterface {
	boolean logged_in = false;
	boolean reportGenerated = false; // default is false
	long manager_id;
	static Scanner scan;
	static String input;

	public ManagerInterface() {
		scan = new Scanner(System.in);
	}

	public boolean login() {
		boolean success = false;

		UserInterface.prompt("Enter Manager ID or type 'x' to exit:");
		input = scan.next();
        if(input.equals("x")) {
          return false;
        }
        else {
		manager_id = Long.parseLong(input);

		for (int i = 0; i < ChocAnControl.managerIds.size(); i++) {
			if (ChocAnControl.managerIds.get(i).equals(manager_id)) {
				success = true;
				break;
			}
		}
		if (success == true) {
			UserInterface.prompt("Manager Login Successful");
			return true;
		} else {
			UserInterface.prompt("Incorrect Manager Login - try again");
			return login();
		}
        }
	}

	public static String managerMenu() {

		boolean menuActive = true;

		while(menuActive) {
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
				UserInterface.prompt("Generating reports...");
				produceMemberReport();
				UserInterface.prompt("...done.");
				break;

			case "provider":
				UserInterface.prompt("Generating reports...");
				produceProviderReport();
				UserInterface.prompt("...done.");
				break;

			case "summary":
				UserInterface.prompt("Generating reports...");
				produceManagerSummary();
				UserInterface.prompt("...done.");
				break;

			case "eft":
				UserInterface.prompt("Generating reports...");
				produceEFTReport();
				UserInterface.prompt("...done.");
				break;

			case "logout":
				menuActive = false;
				break;

			default:
				UserInterface.prompt("Invalid selection, try again.");
				break;

			}

		}
		return "login";
	}

	public static boolean produceMemberReport() {
		ChocAnControl.mainProcedure.produceMemberReports();
		return true;
	}

	public static boolean produceProviderReport() {
		ChocAnControl.mainProcedure.produceProviderReports();
		return true;
	}

	public static boolean produceManagerSummary() {
		ChocAnControl.mainProcedure.produceManagerSummary();
		return true;
	}
	public static boolean produceEFTReport(){
		ChocAnControl.mainProcedure.produceEFT();
		return true;
	}
}
