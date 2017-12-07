package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;

//BUILT BY: AASHMAN GUPTA

public class EFTReport {
	File currFile;
	ArrayList<Visit> visitArray;

	public EFTReport(ArrayList<Visit> visits) {
		//currFile = new File("EFT.txt");
		if (new File("release").exists()) {
		      currFile = new File("release" + File.separator + "reports" + File.separator + "EFT.txt");
		}		
		else {
		      currFile = new File("reports" + File.separator + "EFT.txt");
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
		int totalFee = 0;
		String provId, fee, provName;
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			for(int i = 0; i < visitArray.size(); i++) {
				fileWriter.write("Provider name: " + visitArray.get(i).provider.name);
				provName = visitArray.get(i).provider.name;
				totalFee = visitArray.get(i).service.getFee();
				
				for(int j = i + 1; j < visitArray.size(); j++) {
					if(provName == visitArray.get(j).provider.name) {
						totalFee = totalFee + visitArray.get(j).service.getFee();
						visitArray.remove(j);
						j--;
					}
				}
				
				
				fileWriter.write(System.lineSeparator());
				provId = Objects.toString(visitArray.get(i).provider.id); 
				fileWriter.write("Provider ID: " + provId);
				fileWriter.write(System.lineSeparator());
				fee = Objects.toString(totalFee);
				fileWriter.write("Amount to be transferred: " + fee);
				fileWriter.write(System.lineSeparator());
				fileWriter.write(System.lineSeparator());
			}
			fileWriter.close();
		}
		
		catch(IOException e) {
			System.out.println("Error IOexception e.");
		}
		return;
	}
}
