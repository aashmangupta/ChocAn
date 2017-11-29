package objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberReport {
	File currFile;
	String memName;
	
	MemberReport(Member member, ArrayList<Visit> visits) {
		memName = member.name;
		currFile = new File(memName + ".txt");
		
	}
	
	void email() {
		
	}

	void generateFile() {
		
	}
}
