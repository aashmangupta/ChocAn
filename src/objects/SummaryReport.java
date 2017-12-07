package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

//BUILT BY: AASHMAN GUPTA

public class SummaryReport {
	File currFile;
	ArrayList<Visit> visitArray;
	ArrayList<Provider> providerArray;
	String dateVisit;
	
	
	/**
	   * Constructor.
	   * @param visits, record containing all the visits.
	   * @param providers, array containing all the providers.
	   */
	
	public SummaryReport(ArrayList<Visit> visits, ArrayList<Provider> providers) {
		//currFile = new File("summaryReport.txt");

		if (new File("release").exists()) {
			currFile = new File("release" + File.separator + "reports" + File.separator + "summaryReport.txt");
		}		
		else {
			currFile = new File("reports" + File.separator + "summaryReport.txt");
		}
		visitArray = visits;
		providerArray = providers;
		if(visits.isEmpty()) {
			System.out.println("ERROR: No visits exist so far.");
			return;
		}
		generateFile();
		return;
	}

	/**
	   * This is the generate file function. It creates a record of visits and transactions.
	   * @param 
	   * @return void
	   */
	
	void generateFile() {
		Provider currProvider;
		int indivFeeTotal = 0, totalProviders = 0, totalConsultations = 0, indivConsult = 0, totalFee = 0;

		try {
			FileWriter fileWriter = new FileWriter(currFile);
			for(int i = 0; i < providerArray.size(); i++) {
				currProvider = providerArray.get(i);
				for(int j = 0; j < visitArray.size(); j++) {
					if(currProvider.name == visitArray.get(j).provider.name) {
						indivConsult++;
						indivFeeTotal = indivFeeTotal + visitArray.get(j).service.getFee();
					}
				}
				if(indivConsult > 0) {
					fileWriter.write("Provider name: " + currProvider.name);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("# of consultations: " + indivConsult);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Fee: " + indivFeeTotal);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(System.lineSeparator());
					totalProviders++;
					totalFee = totalFee + indivFeeTotal;
					totalConsultations = totalConsultations + indivConsult;
				}
				indivConsult = 0;
			}
			fileWriter.write("Total providers: " + totalProviders + '\n');
			fileWriter.write("Total consultations: " + totalConsultations + '\n');
			fileWriter.write("Total fee: " + totalFee + '\n');
			fileWriter.close();
		}
		catch(IOException e) {
			System.out.println("Error IOexception e.");
		}
		return;
	}

	
	/**
	   * This is the email function. It will print out the file on the screen. 
	   * @param
	   * @return void
	   */
	
	void email() {
		//no email needs to be actually sent in the demo
	}
}
