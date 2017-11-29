import java.util.ArrayList;
import java.util.Scanner;
import control.ChocAnControl;
import interfaces.ManagerInterface;
import interfaces.OperatorInterface;
import interfaces.ProviderInterface;
import interfaces.UserInterface;

public class main {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    String input;
    Long id;
    boolean match, loggedIn;
    
    ChocAnControl control = new ChocAnControl();
    
    while(!loggedIn) {
    UserInterface.prompt("Welcome to ChocAn!");
    UserInterface.prompt("Provider, Manager, or Operator?");
    input = scan.nextLine();
    UserInterface.prompt("Enter ID:");
    id = scan.nextLong();
    if(checkUser(id, input)) {
      if(input == "p") {
        ProviderInterface pi = new ProviderInterface(id);
      }
      if(input == "m") {
        ManagerInterface mi = new ManagerInterface();
      }
      if(input == "o") {
        OperatorInterface mi = new OperatorInterface();
      }    
      loggedIn = true;
    }
    else {
      UserInterface.prompt("Invalid ID");
      loggedIn = false;
    }
   }
    
    
    
    

  }
  
  public static boolean checkUser(Long id, String type) {
    if(type == "p") {
      for(int i = 0; i < ChocAnControl.providers.size(); i++) {
        if(id == ChocAnControl.providers.get(i).id) return true;
      }
      return false;
    }
    if(type == "m") {
      for(int i = 0; i < ChocAnControl.managerIds.size(); i++) {
        if(id == ChocAnControl.managerIds.get(i)) return true;
      }
      return false;
    }
    if(type == "o") {
      for(int i = 0; i < ChocAnControl.operatorIds.size(); i++) {
        if(id == ChocAnControl.operatorIds.get(i)) return true;
      }
      return false;
    }
    return false;
  }

}
