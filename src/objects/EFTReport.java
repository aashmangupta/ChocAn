package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class EFTReport {
	File currFile;
	Provider currProvider;
	ArrayList<Visit> visitArray;

	EFTReport(ArrayList<Visit> visits) {
		currFile = new File("EFT.txt");
		visitArray = visits;
	}
	
	void generateFile() {
		
	}
}
