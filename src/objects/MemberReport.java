package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.FileReader;

//BUILT BY: AASHMAN GUPTA

public class MemberReport {
	File currFile;
	Member currMember;
	ArrayList<Visit> visitArray;
	String dateVisit;
	
	/**
	   * Constructor.
	   * 
	   * @param member, current member.
	   * @param visits, record containing all the visits.
	   */
	
	public MemberReport(Member member, ArrayList<Visit> visits) {
		currMember = member;
		//currFile = new File(currMember.name + currMember.id + ".txt");

		if (new File("release").exists()) {
			currFile = new File("release" + File.separator + "reports" + File.separator + currMember.name + currMember.id+ ".txt");
		}		
		else {
			currFile = new File("reports" + File.separator + currMember.name + currMember.id + ".txt");
		}
		visitArray = visits;
		generateFile();
	}
	
	/**
	   * This is the generate file function. It creates a file for a specific member detailing their history.
	   * @param 
	   * @return void
	   */
	
	void generateFile() {
		int i = 0;
		String memID;
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			fileWriter.write("Member name: " + currMember.name);
			fileWriter.write(System.lineSeparator());
			memID = Objects.toString("Member Id: " + currMember.id);
			fileWriter.write(memID);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Member address: " + currMember.address);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Member city: " + currMember.city);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Member state: " + currMember.state);
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Member ZIP code: " + currMember.zipCode);
			fileWriter.write(System.lineSeparator());
			fileWriter.write(System.lineSeparator());
			
			while(i < visitArray.size()) {
				if(currMember.name == visitArray.get(i).member.name)	{
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
					dateVisit = dateFormat.format(visitArray.get(i).dateOfService);
					fileWriter.write("Date of service: " + dateVisit);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Provider name: " + visitArray.get(i).provider.name);
					fileWriter.write(System.lineSeparator());
					fileWriter.write("Service name: " + visitArray.get(i).service.getName());
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

	}
}




