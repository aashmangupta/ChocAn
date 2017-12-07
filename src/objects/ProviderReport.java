package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;
import java.io.FileReader;

//BUILT BY: AASHMAN GUPTA

public class ProviderReport {
	File currFile;
	Provider currProvider;
	ArrayList<Visit> visitArray;
	String dateVisit;




	public ProviderReport(Provider provider, ArrayList<Visit> visits) {
		currProvider = provider;
		//currFile = new File(currProvider.name + currProvider.id + ".txt");
		
		if (new File("release").exists()) {
	 currFile = new File("release" + File.separator + "reports" + File.separator + currProvider.name + currProvider.id+ ".txt");
		}		
		else {
		      currFile = new File("reports" + File.separator + currProvider.name + currProvider.id + ".txt");
		}

		visitArray = visits;
		if(visits.isEmpty()) {
			System.out.println("ERROR: No visits exist so far.");
			return;
		}
		generateFile();
		return;
	}

	void generateFile() {
		int i = 0, totalFee = 0, count = 0, fee;
		String provID, memID, feeStr, serviceCode;
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			fileWriter.write("Provider name: ");
			fileWriter.write(currProvider.name);
			fileWriter.write(System.lineSeparator());
			provID = Objects.toString(currProvider.id);
			fileWriter.write("Provider ID: ");
			fileWriter.write(provID);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Provider address: ");
			fileWriter.write(currProvider.address);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Provider city: ");
			fileWriter.write(currProvider.city);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Provider state: ");
			fileWriter.write(currProvider.state);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Provider ZIP code: ");
			fileWriter.write(currProvider.zipCode);
			fileWriter.write(System.lineSeparator());

			while(i < visitArray.size()) {
				if(currProvider.name == visitArray.get(i).provider.name) {
					dateVisit = visitArray.get(i).dateOfService.toString();
					count = count + 1;
					fileWriter.write("Date of service: ");
					fileWriter.write(dateVisit);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Date and time data were received by the computer: ");
					fileWriter.write("FIX DATE OF SERVICE AND THIS");
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Member name: ");
					fileWriter.write(visitArray.get(i).member.name);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Member ID: ");
					memID = Objects.toString(visitArray.get(i).member.id);
					fileWriter.write(memID);
					fileWriter.write(System.lineSeparator());
					serviceCode = Objects.toString(visitArray.get(i).service.getCode());
					fileWriter.write("Service code: ");
					fileWriter.write(serviceCode);
					fileWriter.write(System.lineSeparator());
					fee = visitArray.get(i).service.getFee();
					totalFee = totalFee + fee;
					fileWriter.write("Fee to be paid: ");
					feeStr = Objects.toString(fee);
					fileWriter.write(feeStr);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(System.lineSeparator());
				}
				i++;
			}
			fileWriter.write(count + " consultations in total.");
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Total Feel: " + totalFee);
			fileWriter.write(System.lineSeparator());
			fileWriter.close();
		}

		catch(IOException e) {
			System.out.println("Error IOexception e.");
		}
	}

	void email() {
		
	}
}
