import java.util.Date;

public class ProviderInterface extends UserInterface {
  boolean validMember = false;
  boolean visitCreated = false;   //default is false

  
  public ProviderInterface(){
  }
  
  public void login(){
      //enters users credentials to be verfied for access
  }
  public boolean swipeMemberCard(){
    //member number is inputted
	  return true;
  }
  public void getProviderDirectory(){
    //provider directory accessed
  }
  public boolean enterCode(long code){
    //checks whether code was entered correctly
    //returns true if so
	  return false;
  }
  public boolean checkDatabase (long id){
    //checks database if id exists
    //returns true if so
	  return false;
  }
  public boolean checkDate (Date date){
    //checks database if date exists
    //returns true if so
	  return false;
  }
}
