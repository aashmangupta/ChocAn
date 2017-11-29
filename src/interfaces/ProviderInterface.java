package interfaces;

import java.util.Date;
import java.util.Scanner;
import objects.Provider;
import objects.ProviderDirectory;
import control.ChocAnControl;


public class ProviderInterface extends UserInterface {
  long Provider_id;
  long current_member;

  public ProviderInterface(long id){
    Provider_id = id;
  }

  public boolean login(){
      boolean success = false;
      for (int i = 0; i < providerId.size(); i++){       //provider_data_user has to be an array from the main program
        if (provider.getId().equals(Provider_id)){		//tell my boy to implement getId functionality
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
  public boolean swipeMemberCard(long member_number){
    boolean success = false;
    for (int i = 0; i < member_numbers; i++){     //member_numbers has to be an array from the main program
      if (member_numbers[i].equals(member_number)){
        success = true;
        break;
      }
    }
    if (success == true){
      UserInterface.prompt("Member number is verified");
      current_member = member_number;
	     return true;
    }
    else {
      UserInterface.prompt("Member number does not exist");
      return false;
    }
  }
  public void getProviderDirectory(){
    UserInterface.prompt("Enter 6 digit service code");
    Scanner service = new Scanner(System.in);
    long code = service.nextInt();
    ProviderDirectory provider = new ProviderDirectory();
    provider.getService(code);
  }
  public void getServiceControl(){
	ChocAnControl control.runServiceControl();
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
}
