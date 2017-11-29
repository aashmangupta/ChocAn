package interfaces;

import control.UserManager;

public class OperatorInterface extends UserInterface {
boolean logged_in = false;
String Operator_id;

  public OperatorInterface(String id){
    Operator_id = id;
  }

  public boolean login(){
    boolean success = true;
    for (int i = 0; i < operatorIds.size; i++){       //provider_data_user has to be an array from the main program
      if (operatorIds[i].equals(Operator_id)) {
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
      return false;
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
}
