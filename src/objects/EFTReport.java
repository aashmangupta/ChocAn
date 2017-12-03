package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class EFTReport {
	File currFile;
	ArrayList<Visit> visitArray;

	EFTReport(ArrayList<Visit> visits) {
		currFile = new File("EFT.txt");
		visitArray = visits;
		if(visits.isEmpty()) {
			System.out.println("ERROR: No visits exist so far.");
			return;
		}
		return;
	}
	
	void generateFile() {
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			for(int i = 0; i < visitArray.size(); i++) {
				fileWriter.write(visitArray.get(i).provider.name + '\n');
				fileWriter.write((int) visitArray.get(i).provider.id + '\n');
				fileWriter.write(visitArray.get(i).service.getFee() + "\n\n");	
			}
			fileWriter.close();
		}
		
		catch(IOException e) {
			System.out.println("Error IOexception e.");
		}
		return;
	}
}
