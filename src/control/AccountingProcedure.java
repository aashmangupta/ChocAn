package control;

import objects.ProviderReport;

public class AccountingProcedure {
    public boolean produceMemberReports() {
        return false;
    }
    
    public boolean produceManagerSummary() {
        return false;
    }

    public boolean produceProviderReports() {
      for(int i =0; i < ChocAnControl.providers.size(); i++) {
        ProviderReport report = new ProviderReport(ChocAnControl.providers.get(i), ChocAnControl.visits);
      }
        return false;
    }

    public boolean produceEFT() {
        return false;
    }

    public boolean checkVisits() {
        
        return true;
    }
}
