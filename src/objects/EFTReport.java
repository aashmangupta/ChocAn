package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

//BUILT BY: AASHMAN GUPTA

public class EFTReport {
	File currFile;
	ArrayList<Visit> visitArray;

	public EFTReport(ArrayList<Visit> visits) {
		//currFile = new File("EFT.txt");
		if (new File("release").exists()) {
		      currFile = new File("release\\reports\\EFT.txt");
		}		
		else {
		      currFile = new File("reports\\EFT.txt");
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
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			for(int i = 0; i < visitArray.size(); i++) {
				fileWriter.write(visitArray.get(i).provider.name);
				fileWriter.write(System.lineSeparator());
				fileWriter.write((int) visitArray.get(i).provider.id);
				fileWriter.write(System.lineSeparator());
				fileWriter.write(visitArray.get(i).service.getFee());
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
