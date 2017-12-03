package control;

import java.util.ArrayList;
import java.util.Date;
import objects.Member;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Service;
import objects.Visit;

public class ChocAnControl {
  
    public static ArrayList<Long> managerIds;
    public static ArrayList<Long> operatorIds;
    public static ArrayList<Member> members;
    public static ArrayList<Provider> providers;
    public static ArrayList<Visit> visits;
    public static ProviderDirectory providerDirectory;
    public static AccountingProcedure mainProcedure;	
    public static ServiceControl serviceControl;
    public static boolean isFridayAtMidnight;
    
    public ChocAnControl(){
      managerIds = new ArrayList<Long>();
      operatorIds = new ArrayList<Long>();
      members = new ArrayList<Member>();
      providers = new ArrayList<Provider>();
      visits = new ArrayList<Visit>();
      providerDirectory = new ProviderDirectory();
      mainProcedure = new AccountingProcedure();
      isFridayAtMidnight = false;
      serviceControl = new ServiceControl();
      
      
      
      //Populating with initial sample data
      members.add(new Member("Frank", 000000001, "123 paul bryant", "tuscaloosa", "35401", "alabama", true));
      members.add(new Member("Tom", 000000002, "321 university blvd", "tuscaloosa", "35401", "alabama", true));
      members.add(new Member("Jan", 000000003, "100 campus dr", "tuscaloosa", "35401", "alabama", false));

      providers.add(new Provider("Phil", 98765432, "111 14th ave", "tuscaloosa", "35401", "alabama", 20, 0));
      providers.add(new Provider("Matt", 200000000, "1000 15th st", "tuscaloosa", "35401", "alabama", 80, 0));
      providers.add(new Provider("John", 300000000, "100 16th st", "tuscaloosa", "35401", "alabama", 20, 0));

      managerIds.add((long) 9876543);
      managerIds.add((long) 002);
      managerIds.add((long) 003);

      operatorIds.add((long)45632);
      operatorIds.add((long)002);
      operatorIds.add((long)003);
      
      visits.add(new Visit(members.get(0), providers.get(1), new Service("servicename", 92349, 234)));
      
    }
    

	public ProviderDirectory getProviderDirectory(){
		return new ProviderDirectory();
	}
	
	public void runMainAccountingProcedure() {
	    mainProcedure.produceMemberReport();
	    mainProcedure.produceManagerSummary();
	    mainProcedure.produceProviderReports();
	    mainProcedure.produceEFT();
	}
	
	public void checkTimeAndDate() {
	  //checks date
	}
	
	public boolean generateReport(String type) {
	    if(type == "member") mainProcedure.produceMemberReport();
	    if(type == "manager") mainProcedure.produceManagerSummary();
	    if(type == "provider") mainProcedure.produceProviderReports();
	    if(type == "EFT") mainProcedure.produceEFT();
	    
	    return true;
	}


  public static void runServiceControl() {
    // TODO Auto-generated method stub
    
  }
	
	

}
