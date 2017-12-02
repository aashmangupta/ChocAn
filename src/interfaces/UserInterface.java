package interfaces;



public abstract class UserInterface {

  public abstract boolean login();

  public static void prompt(String prompt){
      System.out.println(prompt);
  }
  public static void state(String state){
	  System.out.println(state);
  }

}
