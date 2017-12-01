package control;

import objects.ProviderReport;

public class AccountingProcedure {
    boolean produceMemberReport() {
        return false;
    }
    
    boolean produceManagerSummary() {
        return false;
    }

    public boolean produceProviderReports() {
      for(int i =0; i < ChocAnControl.providers.size(); i++) {
        ProviderReport report = new ProviderReport(ChocAnControl.providers.get(i), ChocAnControl.visits);
      }
        return false;
    }

    boolean produceEFT() {
        return false;
    }

    boolean checkVisits() {
        
        return true;
    }
}
