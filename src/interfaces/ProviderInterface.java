package interfaces;

import java.util.Date
import java.util.Scan;
import objects.Provider;
import control.ChocAnControl;

//scanner needs to be imported in the main

public class ProviderInterface extends UserInterface {
  boolean logged_in = false;
  String Provider_user;
  String Provider_pass;

  public ProviderInterface(String provider, String password){
    Provider_user = provider;
    Provider_pass = password;
  }

  public boolean login(){
      boolean success = 0;
      for (int i = 0; i < provider_data_user.size; i++){       //provider_data_user has to be an array from the main program
        if (provider_data_user[i].equals(Provider_user)){
          for (int j = 0; i < provider_data_pass.size; i++){    //provider_data_pass has to be an array from the main program
            if (provider_data_pass[j].equals(Provider_pass)){
              success = 1;
              break;
            }
          }
          break;
        }
      }
      if (success == 1){
       this.prompt("Provider Login Successful");
        logged_in = true;
        return true;
      }
      else {
        this.prompt("Incorrect Provider Login");
        return false;
      }
  }
  public boolean swipeMemberCard(long member_number){
    boolean success = 0;
    for (int i = 0; i < member_numbers; i++){     //member_numbers has to be an array from the main program
      if (member_numbers[i].equals(member_number)){
        success = 1;
        break;
      }
    }
    if (success == 1){
      this.prompt("Member number is verified");
	     return true;
    }
    else {
      this.prompt("Member number does not exist");
      return false;
    }
  }
  public void getProviderDirectory(){
    this.prompt("Enter 6 digit service code");
    int code = "";
    ////scanner
    ProviderDirectory.getService(code);
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
}
