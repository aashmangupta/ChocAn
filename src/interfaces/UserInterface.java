package interfaces;



public abstract class UserInterface {

  abstract boolean login();

  public static void prompt(String prompt){
      System.out.println(prompt);
  }

}
