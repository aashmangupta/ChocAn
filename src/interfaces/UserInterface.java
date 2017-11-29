package interfaces;



public abstract class UserInterface {

  abstract void login();

  public static void prompt(String prompt){
      System.out.println(prompt);
  }

}
