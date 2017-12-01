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
    boolean match;
    boolean loggedIn = false;
    boolean programActive = true;
    ProviderInterface pi;
    
    ChocAnControl control = new ChocAnControl();
    
    while(!loggedIn) {
    UserInterface.prompt("Welcome to ChocAn!");
    UserInterface.prompt("Provider, Manager, or Operator?");
    input = scan.nextLine();
    UserInterface.prompt("Enter ID:");
    id = scan.nextLong();
    if(checkUser(id, input)) {
      if(input.equals("p")) {
        pi = new ProviderInterface(id);
        while(programActive)
        pi.prompt("Create Visit, Get Directory, Swipe Member Card");
        input = scan.nextLine();
        if(input.equals("create")) {
          if(pi.current_member == 0) pi.prompt("Swipe a Member first!");
          else ChocAnControl.serviceControl.createVisit(pi.current_member, pi.provider_id, pi.getService());
        }
        if(input.equals("get")) {
          
        }
        if(input.equals("swipe")) {
          
        }
      }
      if(input == "m") {
       
      }
      if(input == "o") {
        
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
    if(type.equals("p")) {
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
