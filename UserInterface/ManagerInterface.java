public class ManagerInterface extends UserInterface {
  boolean reportGenerated = false; //default is false

  
  public ManagerInterface(){
  }
  
  public void login(){
    //enters manager's credentials to be verified for access
  }
  public boolean produceMemberReport(){
    //produces report for members
    //requires an email function (from database)
	  return false;
  }
  public boolean produceProviderReport(){
    //produces report for members
    //requires an email function (from database)
	  return false;
  }
  public boolean produceManagerSummary(){
    //produces a report for managers
    //requires an email function (to the logged-in manager)
	  return false;
  }
}
