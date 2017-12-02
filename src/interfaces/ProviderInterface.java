package interfaces;

import java.util.Date;

import java.util.Scanner;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Service;
import control.ChocAnControl;


public class ProviderInterface extends UserInterface {
  public long provider_id;
  public long current_member = 0;
  static Scanner scan;
  static String input;
  
  public ProviderInterface(long id){
  }

  public boolean login(){
	  UserInterface.prompt("Enter ID");
	  Scanner login_id = new Scanner(System.in);
	  provider_id = login_id.nextLong();
      boolean success = false;
      for (int i = 0; i < ChocAnControl.providers.size(); i++){       //provider_data_user has to be an array from the main program
        if ((ChocAnControl.providers.get(i).id) == (provider_id)){		//tell my boy to implement getId functionality
        	success = true;
        }
      }
      if (success == true){
       UserInterface.prompt("Provider Login Successful");
        return true;
      }
      else {
        UserInterface.prompt("Incorrect Provider Login");
        return false;
      }
  }
  public boolean swipeMemberCard(){
	UserInterface.prompt("Enter member ID");
	Scanner swipe_id = new Scanner(System.in);
	long member_id = swipe_id.nextLong();
    boolean success = false;
    for (int i = 0; i < ChocAnControl.members.size(); i++){     //member_numbers has to be an array from the main program
      if (ChocAnControl.members.get(i).id == (member_id)){
        success = true;
        break;
      }
    }
    if (success == true){
      UserInterface.prompt("Member number is verified");
      current_member = member_id;
	     return true;
    }
    else {
      UserInterface.prompt("Member number does not exist");
      return false;
    }
  }
  public Service getService(){
    UserInterface.prompt("Enter 6 digit service code");
    Scanner service = new Scanner(System.in);
    long code = service.nextLong();
    ProviderDirectory provider = new ProviderDirectory();
    return provider.getService(code);
    
  }
  public void getServiceControl(){
	ChocAnControl.runServiceControl();
  }
/*                May not be needed if ChocAnControl gathers the information itself
  public boolean enterCode(long code){
    //checks whether code was entered correctly
    //returns true if so
	  return false;
  }
  public boolean enterDate (Date date){
    //checks database if date exists
    //returns true if so
	  return false;
  }
  */

public static String providerMenu() {
	boolean menuActive = null;
	
	UserInterface.prompt("\n\n");
	UserInterface.prompt("**************************");
	UserInterface.prompt("** Choc-An Manager Menu **");
	UserInterface.prompt("**************************");
	UserInterface.prompt("");
	UserInterface.prompt("Enter a selection:");
	UserInterface.prompt("Enter member ID - \"ID\"");
	UserInterface.prompt("Generate Provider Reports - \"provider\"");
	UserInterface.prompt("Generate Summary Reports - \"summary\"");
	UserInterface.prompt("Generate EFT files - \"eft\"");
	UserInterface.prompt("Log Out and return to main menu - \"logout\"");
	input = scan.nextLine();
	switch (input){
	case "ID":
		
	
	}
}
}
