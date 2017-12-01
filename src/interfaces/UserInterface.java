package interfaces;



public abstract class UserInterface {

  public abstract boolean login();

  public static void prompt(String prompt){
      System.out.println(prompt);
  }

}
