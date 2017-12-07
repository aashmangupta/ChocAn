 package interfaces;

import java.util.Date;
import java.util.Scanner;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Service;
import control.ChocAnControl;
import control.ServiceControl;


public class ProviderInterface extends UserInterface {
  public static long provider_id;                  //defining variable to store provider id
  public static long current_member = -1;         //defining variable to store member id
  static Scanner scan;
  static String input;

  public ProviderInterface() {      //Constructor
    scan = new Scanner(System.in);  //Defining a new scanner
  }

  /**
  * This method is used for providers to login
  *
  * @param none.
  * @return boolean.
  */
  public boolean login() {
    boolean success = false;

    UserInterface.prompt("Enter Provider ID or type 'x' to exit:");
    input = scan.next();
    if (input.equals("x")) {          //checks if provider wants to exit
      return false;
    } else {
      provider_id = Long.parseLong(input);

      for (int i = 0; i < ChocAnControl.providers.size(); i++) {    //checks if provider login exists
        if ((ChocAnControl.providers.get(i).id) == (provider_id)) {

          success = true;
          break;
        }
      }
      if (success == true) {                                    //login exists
        UserInterface.prompt("Provider Login Successful");
        return true;
      }
      else {                                                    //login doesnt exist
        UserInterface.prompt("Incorrect Provider Login - Try again");
        return login();
      }
    }
  }

  /**
  * This method is used for providers to enter member identification information
  *
  * @param none.
  * @return boolean.
  */
  public static boolean swipeMemberCard() {
    UserInterface.prompt("Enter member ID");
    Scanner swipe_id = new Scanner(System.in);
    long member_id = swipe_id.nextLong();
    boolean success = false;
    boolean suspended = true;
    for (int i = 0; i < ChocAnControl.members.size(); i++) {      //checks if member id exists
      if (ChocAnControl.members.get(i).id == (member_id)) {
        success = true;
        if (ChocAnControl.members.get(i).accountStatus == (false)){
        suspended = true;
        }
      break;
      }
    }
    if (success == true) {                                      //member number exists
      UserInterface.prompt("Member number is verified");
      current_member = member_id;
      return true;
    } 
    else if (suspended == true){
    	UserInterface.prompt("Member number is suspended");
    	return false;
    }
    else {
      UserInterface.prompt("Member number does not exist");     //member number does not exist
      return false;
    }
  }

  /**
  * This method lists the options that a given provider can take
  *
  * @param none.
  * @return String.
  */
  public static String providerMenu() {
    boolean menuActive = true;

    while (menuActive) {                                        //stays active until the provider decides to logout
      UserInterface.prompt("\n\n");
      UserInterface.prompt("**************************");
      UserInterface.prompt("** ChocAn Provider Menu **");
      UserInterface.prompt("**************************");
      UserInterface.prompt("");
      UserInterface.prompt("Enter a selection:");
      UserInterface.prompt("Swipe member card - \"swipe\"");
      UserInterface.prompt("Get Provider Directory - \"directory\"");
      UserInterface.prompt("Create Visit \"visit\"");
      UserInterface.prompt("Log Out and return to main menu - \"logout\"");
      input = scan.next();
      switch (input) {

        case "swipe":
          swipeMemberCard();                                  //calls the method to input member information
          break;

        case "directory":
          getProviderDirectory();                             //calls the method to view the provider directory
          break;

        case "visit":
          createVisit();                                      //calls the method to create a visit
          break;

        case "logout":
          menuActive = false;                                 //logs the provider out
          break;

        default:                                              //default method if an invalid selection is made
          UserInterface.prompt("Invalid selection, try again");
          break;
      }
    }
    return "login";
  }

  /**
  * This the option a provider can take to create a visit
  *
  * @param none.
  * @return none.
  */
  private static void createVisit() {
    if (current_member == -1){                          //error detection member card hasnt been called
      UserInterface.prompt("Please swipe member card");
      return;
    }
    Service svc;
    
    boolean visitSelect = true;
    long code = 0;
    while(visitSelect){
    
    	UserInterface.prompt("Enter 6 digit service code");				//prompts user to input a service code
    	code = Long.valueOf(scan.nextLong());
    	if (ChocAnControl.serviceControl.displayName(code)){			//checks if service code exists
    		UserInterface.prompt("Is this the correct service? 'y' for yes, any other key to try again");
    		if (scan.next().equals("y")){								//checks with the user if name of service is correct
        	visitSelect = false;										//if not, they may keep entering
    		}
    	}
    	else{
    		UserInterface.prompt("Invalid service code");				//user is told if service code doesn't exist
    	}
    }	
    
    svc = ChocAnControl.providerDirectory.getService(code);     //searches directory for inputted code

    ChocAnControl.serviceControl.createVisit(current_member, provider_id, svc);     //calls method to create a vist

    UserInterface.prompt("Visit for member #" + Long.toString(current_member) + " created.");   //outputs what occured
    UserInterface.prompt("Service Provided: " + svc.getName());
    UserInterface.prompt("Fee: " + Integer.toString(svc.getFee()));
    }

  /**
  * This is the option a provider can take to access the directory
  *
  * @param none.
  * @return boolean.
  */
  private static void getProviderDirectory() {
    ChocAnControl.providerDirectory.getDirectory();         //calls the method to retrieve the provider directory
    UserInterface.prompt("Emailing file to Provider ID: " + Long.toString(provider_id));
    ChocAnControl.providerDirectory.email();                //gives the text file of the provider directory
    UserInterface.prompt("...done.");

  }


}

