public abstract class UserInterface {
	OperatorInterface operator = new OperatorInterface();
	ManagerInterface manager = new ManagerInterface();
	ProviderInterface provider = new ProviderInterface();

  abstract void login();

  public static void prompt(String prompt){
      System.out.println(prompt);
  }
  public void openOperatorInterface(){

  }
  public void openManagerInterface(){
      //gives access to the ManagerInterface class
  }
  public void openProviderInterface(){
      //gives access to the ProviderInterface class
  }

}
