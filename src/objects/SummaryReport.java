package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class SummaryReport {
	File currFile;
	ArrayList<Visit> visitArray;
	ArrayList<Provider> providerArray;
	String dateVisit;
	
	public SummaryReport(ArrayList<Visit> visits, ArrayList<Provider> providers) {
		currFile = new File("summaryReport.txt");
		visitArray = visits;
		providerArray = providers;
		if(visits.isEmpty()) {
			System.out.println("ERROR: No visits exist so far.");
			return;
		}
		generateFile();
		return;
	}
	
	void generateFile() {
		int currProvider;
		
		for(int i = 0; i < providerArray.size(); i++) {
	
		}
	}
	
	void email() {
		
	}
}
