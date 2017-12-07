package control;

import java.util.ArrayList;
import objects.Member;
import objects.ProviderReport;
import objects.Visit;
import objects.MemberReport;
import objects.Provider;
import objects.SummaryReport;
import objects.EFTReport;

public class AccountingProcedure {
	
	/**
	   * This is the produceMemberReport function and it produces the member reports.
	   */
	
	public boolean produceMemberReports() {
    		for(int i =0; i < ChocAnControl.members.size(); i++) {
    			MemberReport memRep = new MemberReport(ChocAnControl.members.get(i), ChocAnControl.visits);
    		}
    		return false;
    }
    
	/**
	   * This is the produceManagerSummary function and it produces the summary report.
	   */
	
    public boolean produceManagerSummary() {
    		SummaryReport sumRep = new SummaryReport(ChocAnControl.visits, ChocAnControl.providers);
        return false;
    }

	/**
	   * This is the produceProviderReport function and it produces the provider report.
	   */
    
    public boolean produceProviderReports() {
      for(int i =0; i < ChocAnControl.providers.size(); i++) {
        ProviderReport report = new ProviderReport(ChocAnControl.providers.get(i), ChocAnControl.visits);
      }
        return false;
    }

    
	/**
	   * This is the produceEFT function and it produces the EFT report.
	   */
    
    public boolean produceEFT() {
    		EFTReport EFT = new EFTReport(ChocAnControl.visits);
        return false;
    }

    
	/**
	   * This is the checkVisits function and it checks if there are any visits.
	   */
    
    public boolean checkVisits() {
        
        return true;
    }
}
