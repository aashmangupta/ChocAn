package interfaces;

import control.UserManager;
import java.util.Scanner;
import control.ChocAnControl;

public class OperatorInterface extends UserInterface {
boolean logged_in = false;
long operator_id;

  public OperatorInterface(Long id){
  }

  public boolean login(){
	UserInterface.prompt("Enter ID");
	Scanner id = new Scanner(System.in);
	operator_id = id.nextLong();
    boolean success = true;
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

public static String operatorMenu() {
	// TODO Auto-generated method stub
	return null;
}
}
