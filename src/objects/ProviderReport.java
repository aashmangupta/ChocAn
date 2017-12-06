package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
		      currFile = new File("release\\reports\\" + currProvider.name + currProvider.id + ".txt");
		}
		else {
		      currFile = new File("reports\\" + currProvider.name + currProvider.id + ".txt");
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
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			fileWriter.write(currProvider.name);
			fileWriter.write(System.lineSeparator());
			fileWriter.write((int) currProvider.id);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currProvider.address);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currProvider.city);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currProvider.state);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currProvider.zipCode);
			fileWriter.write(System.lineSeparator());

			while(i < visitArray.size()) {
				if(currProvider.name == visitArray.get(i).provider.name) {
					dateVisit = visitArray.get(i).dateOfService.toString();
					count = count + 1;
					fileWriter.write(dateVisit);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(visitArray.get(i).member.name);
					fileWriter.write(System.lineSeparator());
					fileWriter.write((int)visitArray.get(i).member.id);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(visitArray.get(i).service.hashCode());
					fileWriter.write(System.lineSeparator());
					fee = visitArray.get(i).service.getFee();
					totalFee = totalFee + fee;
					fileWriter.write(fee);
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
		try {
			FileReader fileReader = new FileReader(currFile);
			
			fileReader.close();
		}
		catch(IOException e) {
			System.out.println("File doesn't exist");
		}
		//no emails need to be actually sent for the demo
	}
}
