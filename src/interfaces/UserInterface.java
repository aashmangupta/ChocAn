package interfaces;

//Created by Spencer Fuhriman

public abstract class UserInterface {

  public abstract boolean login();

  /**
   * This is the universal print function for ChocAn.
   * 
   * @param prompt, string pulled in to print out to console
   * @return void
   */
  public static void prompt(String prompt){
      System.out.println(prompt);
  }
  
  /**
   * This is the function initiated to print out the state
   * 
   * @param state, string pulled in to print out
   * @return void
   */
  public static void state(String state){
	  System.out.print(state);
  }

}
