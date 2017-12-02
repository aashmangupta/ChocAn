import java.util.Scanner;
import control.ChocAnControl;
import interfaces.ManagerInterface;
import interfaces.OperatorInterface;
import interfaces.ProviderInterface;
import interfaces.UserInterface;

public class main {

	public static void main(String[] args) {

		final Scanner scan = new Scanner(System.in);
		boolean programActive = true;
		String s = "login";
		UserInterface ui;
		ChocAnControl control = new ChocAnControl();

		while (programActive) {
			switch (s) {

			case "login":
			    printSpace();
				printWelcome();
				s = printLoginMenu(scan);
				break;

			case "manager":
				ui = new ManagerInterface();
				if (ui.login()) 
					s = ManagerInterface.managerMenu();
				else s = "login";
				break;

			case "operator":
				ui = new OperatorInterface((long) 100);
				if (ui.login()) s = OperatorInterface.operatorMenu();
				break;

			case "provider":
				ui = new ProviderInterface(100);
				if (ui.login()) s = ProviderInterface.providerMenu();
				break;

			default:
				break;
			}
		}

	}

	private static void printSpace() {
      UserInterface.prompt("\n\n\n\n\n\n\n\n");
  }

  public static boolean checkUser(Long id, String type) {
		if (type.equals("p")) {
			for (int i = 0; i < ChocAnControl.providers.size(); i++) {
				if (id == ChocAnControl.providers.get(i).id)
					return true;
			}
			return false;
		}
		if (type.equals("m")) {
			for (int i = 0; i < ChocAnControl.managerIds.size(); i++) {
				if (id.equals(ChocAnControl.managerIds.get(i)))
					return true;
			}
			return false;
		}
		if (type == "o") {
			for (int i = 0; i < ChocAnControl.operatorIds.size(); i++) {
				if (id == ChocAnControl.operatorIds.get(i))
					return true;
			}
			return false;
		}
		return false;
	}

	public static void printWelcome() {
		UserInterface.prompt("\n\n");
		UserInterface.prompt("**************************");
		UserInterface.prompt("**************************");
		UserInterface.prompt("*** Welcome to ChocAn! ***");
		UserInterface.prompt("**************************");
		UserInterface.prompt("**************************");
		UserInterface.prompt("");
	}

	public static String printLoginMenu(Scanner scan) {
		UserInterface.prompt("Log In as Provider, Manager, or Operator?");
		String type = scan.nextLine();
		if (type.equals("provider") || type.equals("Provider") || type.equals("p") || type.equals("P")) {
			return "provider";
		} else if (type.equals("manager") || type.equals("Manager") || type.equals("m") || type.equals("M")) {
			return "manager";
		} else if (type.equals("operator") || type.equals("Operator") || type.equals("o") || type.equals("O")) {
			return "operator";
		} else {
			UserInterface.prompt("Invalid log-in selection");
			return "login";
		}
	}

}
