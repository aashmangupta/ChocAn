package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;
import java.io.FileReader;

//BUILT BY: AASHMAN GUPTA

public class MemberReport {
	File currFile;
	Member currMember;
	ArrayList<Visit> visitArray;
	String dateVisit;
	
	public MemberReport(Member member, ArrayList<Visit> visits) {
		currMember = member;
		//currFile = new File(currMember.name + currMember.id + ".txt");
		if (new File("release").exists()) {
		      currFile = new File("release\\reports\\" + currMember.name + currMember.id + ".txt");
		}		
		else {
		      currFile = new File("reports\\" + currMember.name + currMember.id + ".txt");
		}
		visitArray = visits;
		generateFile();
	}
	
	/**
	   * This is the generate file function. It creates a file for a specific user detailing the user's credentials and history.
	   * @param 
	   * @return void
	   */
	
	void generateFile() {
		int i = 0;
		String memID;
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			fileWriter.write(currMember.name);
			fileWriter.write(System.lineSeparator());
			memID = Objects.toString(currMember.id);
			fileWriter.write(memID);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currMember.address);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currMember.city);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currMember.state);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(currMember.zipCode);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(System.lineSeparator());
			
			while(i < visitArray.size()) {
				if(currMember.name == visitArray.get(i).member.name)	{
					dateVisit = visitArray.get(i).dateOfService.toString();
					fileWriter.write(dateVisit);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(visitArray.get(i).provider.name);
					fileWriter.write(System.lineSeparator());
					fileWriter.write(visitArray.get(i).service.getName());
					fileWriter.write(System.lineSeparator());
					fileWriter.write(System.lineSeparator());
				}
				i++;
			}
			fileWriter.close();
		}
		catch(IOException e) {
			System.out.println("Error");
		}
	}
	
	
	/**
	   * This is the email function. It will print out the file on the screen. 
	   * @param
	   * @return void
	   */
	
	void email() {
		try {
			FileReader fileReader = new FileReader(currFile);
			
			
			fileReader.close();
		}
		catch(IOException e) {
			System.out.println("File doesn't exist");
		}
	}
}




