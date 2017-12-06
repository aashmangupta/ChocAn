package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

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
			fileWriter.write(currProvider.name + '\n');
			fileWriter.write((int) currProvider.id + '\n');
			fileWriter.write(currProvider.address  + '\n');
			fileWriter.write(currProvider.city + '\n');
			fileWriter.write(currProvider.state + '\n');
			fileWriter.write(currProvider.zipCode + '\n');

			while(i < visitArray.size()) {
				if(currProvider.name == visitArray.get(i).provider.name) {
					dateVisit = visitArray.get(i).dateOfService.toString();
					count = count + 1;
					fileWriter.write(dateVisit + '\n');
					fileWriter.write(visitArray.get(i).member.name + '\n');
					fileWriter.write((int)visitArray.get(i).member.id + '\n');
					fileWriter.write(visitArray.get(i).service.hashCode()+ '\n');
					fee = visitArray.get(i).service.getFee();
					totalFee = totalFee + fee;
					fileWriter.write(fee + '\n');
					fileWriter.write('\n');
				}
				i++;
			}
			fileWriter.write(count + " consultations in total." + '\n');
			fileWriter.write("Total Feel: " + totalFee + '\n');
			fileWriter.close();
		}

		catch(IOException e) {
			System.out.println("Error IOexception e.");
		}
	}

	void email() {
		//no emails need to be actually sent for the demo
	}
}
