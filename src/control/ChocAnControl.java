package control;

import java.util.ArrayList;
import objects.Member;
import objects.Provider;
import objects.ProviderDirectory;
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
	
	

}
