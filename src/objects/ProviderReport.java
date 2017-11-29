package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class ProviderReport {
	File currFile;
	Provider currProvider;
	ArrayList<Visit> visitArray;
	String dateVisit;
	
	ProviderReport(Provider provider, ArrayList<Visit> visits) {
		currProvider = provider;
		currFile = new File(currProvider.name + currProvider.id + ".txt");
		visitArray = visits;
	}
	
	void email() {
		
	}

	void generateFile() {
		
	}
}
