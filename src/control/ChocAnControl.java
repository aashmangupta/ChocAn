package control;

import java.util.ArrayList;

import objects.Member;
import objects.Provider;
import objects.ProviderDirectory;
import interfaces.UserInterface;

public class ChocAnControl {
	
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
	    mainProcedure.produceMemberReports();
	    mainProcedure.produceManagerSummary();
	    mainProcedure.produceProviderReports();
	    mainProcedure.produceEFT();
	}
	
	public void checkTimeAndDate() {
	  //checks date
	}
	
	public boolean generateReport(String type) {
	    if(type == "member") mainProcedure.produceMemberReports();
	    if(type == "manager") mainProcedure.produceManagerSummary();
	    if(type == "provider") mainProcedure.produceProviderReports();
	    if(type == "EFT") mainProcedure.produceEFT();
	}

}
