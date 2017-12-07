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
    public boolean produceMemberReports() {
    		for(int i =0; i < ChocAnControl.members.size(); i++) {
    			MemberReport memRep = new MemberReport(ChocAnControl.members.get(i), ChocAnControl.visits);
    		}
    		return false;
    }
    
    public boolean produceManagerSummary() {
    		SummaryReport sumRep = new SummaryReport(ChocAnControl.visits, ChocAnControl.providers);
        return false;
    }

    public boolean produceProviderReports() {
      for(int i =0; i < ChocAnControl.providers.size(); i++) {
        ProviderReport report = new ProviderReport(ChocAnControl.providers.get(i), ChocAnControl.visits);
      }
        return false;
    }

    public boolean produceEFT() {
    		EFTReport EFT = new EFTReport(ChocAnControl.visits);
        return false;
    }

    public boolean checkVisits() {
        
        return true;
    }
}
