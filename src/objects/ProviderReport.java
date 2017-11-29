package objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProviderReport {
	File currFile;
	String provName;
	
	ProviderReport(Provider provider, ArrayList<Visit> visits) {
		provName = provider.name;
		currFile = new File(provName + ".txt");
	}
	
	void email() {
		
	}

	void generateFile() {
		
	}
}
