package interfaces;

import control.ChocAnControl;

public class ManagerInterface extends UserInterface {
  boolean logged_in = false;
  boolean reportGenerated = false; //default is false
  String Manager_id;

  public ManagerInterface(String id){
    Manager_id = id;
  }

  public boolean login(){
    boolean success = false;
<<<<<<< HEAD
    for (int i = 0; i < managerIds.size(); i++){       //manager_data_user has to be an array from the main program
      if (managerIds[i].equals(Manager_id)){
=======
    for (int i = 0; i < ChocAnControl.managerIds.size(); i++){       //manager_data_user has to be an array from the main program
      if (ChocAnControl.managerIds.get(i).equals(Manager_id)){
>>>>>>> 3ad8dafa71ea16e5d1835dde3a2964e9ae0c2e8d
    	  success = true;
    	  break;
          }
    }
    if (success == true){
      UserInterface.prompt("Manager Login Successful");
      return true;
    }
    else {
      UserInterface.prompt("Incorrect manager Login");
      return false;
    }
  }
  public boolean produceMemberReport(){
    //produces report for members
    //separate text file output
	  return false;
  }
  public boolean producemanagerReport(){
    //produces report for members
    //separate text file output
	  return false;
  }
  public boolean produceManagerSummary(){
    //produces a report for managers
    //separate text file output
	  return false;
  }
}
