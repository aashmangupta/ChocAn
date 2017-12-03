package interfaces;

import java.util.Date;
import java.util.Scanner;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Service;
import control.ChocAnControl;


public class ProviderInterface extends UserInterface {
  public static long provider_id;
  public static long current_member = -1;
  static Scanner scan;
  static String input;

  public ProviderInterface() {
    scan = new Scanner(System.in);
  }

  public boolean login() {
    boolean success = false;

    UserInterface.prompt("Enter Provider ID or type 'x' to exit:");
    input = scan.next();
    if (input.equals("x")) {
      return false;
    } else {
      provider_id = Long.parseLong(input);

      for (int i = 0; i < ChocAnControl.providers.size(); i++) { // provider_data_user has to be an
                                                                 // array from the main program
        if ((ChocAnControl.providers.get(i).id) == (provider_id)) { // tell my boy to implement
                                                                    // getId functionality
          success = true;
          break;
        }
      }
      if (success == true) {
        UserInterface.prompt("Provider Login Successful");
        return true;
      } else {
        UserInterface.prompt("Incorrect Provider Login - Try again");
        return login();
      }
    }
  }

  public static boolean swipeMemberCard() {
    UserInterface.prompt("Enter member ID");
    Scanner swipe_id = new Scanner(System.in);
    long member_id = swipe_id.nextLong();
    boolean success = false;
    for (int i = 0; i < ChocAnControl.members.size(); i++) { // member_numbers has to be an array
                                                             // from the main program
      if (ChocAnControl.members.get(i).id == (member_id)) {
        success = true;
        break;
      }
    }
    if (success == true) {
      UserInterface.prompt("Member number is verified");
      current_member = member_id;
      return true;
    } else {
      UserInterface.prompt("Member number does not exist");
      return false;
    }
  }

  /*
   * May not be needed if ChocAnControl gathers the information itself public boolean enterCode(long
   * code){ //checks whether code was entered correctly //returns true if so return false; } public
   * boolean enterDate (Date date){ //checks database if date exists //returns true if so return
   * false; }
   */

  public static String providerMenu() {
    boolean menuActive = true;

    while (menuActive) {
      UserInterface.prompt("\n\n");
      UserInterface.prompt("**************************");
      UserInterface.prompt("** ChocAn Provider Menu **");
      UserInterface.prompt("**************************");
      UserInterface.prompt("");
      UserInterface.prompt("Enter a selection:");
      UserInterface.prompt("Swipe member card - \"swipe\"");
      UserInterface.prompt("Get Provider Directory - \"directory\"");
      UserInterface.prompt("Create Visit \"visit\"");
      UserInterface.prompt("Log Out and return to main menu - \"logout\"");
      input = scan.next();
      switch (input) {

        case "swipe":
          swipeMemberCard();
          break;

        case "directory":
          getProviderDirectory();
          break;

        case "visit":
          createVisit();
          break;

        case "logout":
          menuActive = false;
          break;

        default:
          break;
      }
    }
    return "login";
  }

  private static void createVisit() {

    Service svc;

    UserInterface.prompt("Enter 6 digit service code");
    long code = scan.nextLong();
    svc = ChocAnControl.providerDirectory.getService(code);
    if (svc.getName().equals("Error: invalid code")){
      UserInterface.prompt("Error: invalid code");
      createVisit();
    }
    else {

    ChocAnControl.serviceControl.createVisit(current_member, provider_id, svc);

    UserInterface.prompt("Visit for member #" + Long.toString(current_member) + "created.");
    UserInterface.prompt("Service Provided: " + svc.getName());
    UserInterface.prompt("Fee: " + Integer.toString(svc.getFee()));
    }
  }

  private static void getProviderDirectory() {
    ChocAnControl.providerDirectory.getDirectory();
    UserInterface.prompt("Emailing file...");
    ChocAnControl.providerDirectory.email();
    UserInterface.prompt("...done.");

  }


}
