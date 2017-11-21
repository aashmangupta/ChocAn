public class OperatorInterface extends UserInterface {
boolean logged_in = false;
String Operator_user;
String Operator_pass;

  public OperatorInterface(String username, String password){
    Operator_user = username;
    Operator_pass = password;
  }

  public boolean login(){
    boolean success = 0;
    for (int i = 0; i < provider_data_user.size; i++){       //provider_data_user has to be an array from the main program
      if (provider_data_user[i].equals(Operator_user)){
        for (int j = 0; i < provider_data_pass.size; i++){    //provider_data_pass has to be an array from the main program
          if (provider_data_pass[j].equals(Operator_pass)){
            success = 1;
            break;
          }
        }
        break;
      }
    }
    if (success == 1){
      this.prompt("Operator Login Successful");
      logged_in = true;
      return true;
    }
    else {
      this.prompt("Incorrect Operator Login");
      return false;
    }
  }

  public void addMember(){
      UserManager.addMember();
  }
  public void editMember(){
    UserManager.editMember();
  }
  public void deleteMember(){
    UserManager.deleteMember();
  }
  public void addProvider(){
    UserManager.addProvider();
  }
  public void editProvider(){
    UserManager.editProvider();
  }
  public void deleteProvider(){
    UserManager.deleteProvider();
  }
}
