public class ManagerInterface extends UserInterface {
  boolean logged_in = false;
  boolean reportGenerated = false; //default is false
  String Manager_user;
  String Manager_pass;

  public ManagerInterface(String manager, String password){
    Manager_user = manager;
    Manager_pass = password;
  }

  public boolean login(){
    boolean success = 0;
    for (int i = 0; i < manager_data_user.size; i++){       //manager_data_user has to be an array from the main program
      if (manager_data_user[i].equals(Manager_user)){
        for (int j = 0; i < manager_data_pass.size; i++){    //manager_data_pass has to be an array from the main program
          if (manager_data_pass[j].equals(Manager_pass)){
            success = 1;
            break;
          }
        }
        break;
      }
    }
    if (success == 1){
      this.prompt("Manager Login Successful");
      return true;
    }
    else {
      this.prompt("Incorrect manager Login");
      return false;
    }
  }
  public boolean produceMemberReport(){
    //produces report for members
    //seperate text file output
	  return false;
  }
  public boolean producemanagerReport(){
    //produces report for members
    //seperate text file output
	  return false;
  }
  public boolean produceManagerSummary(){
    //produces a report for managers
    //seperate text file output
	  return false;
  }
}
