package control;

import java.util.ArrayList;

import objects.Member;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Visit;
import interfaces.UserInterface;

public class ChocAnControl {
  
    ArrayList<String> provider_data_pass = new ArrayList<String>();
	ArrayList<String> provider_data_user = new ArrayList<String>();
	ArrayList<Member> members = new ArrayList<Member>();
	ArrayList<Provider> providers = new ArrayList<Provider>();
	ArrayList<Visit> visits = new ArrayList<Visit>();
	ProviderDirectory providerDirectory;
	AccountingProcedure mainProcedure;	
	ServiceControl serviceControl;
	UserInterface userInterface;
	boolean isFridayAtMidnight;

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
