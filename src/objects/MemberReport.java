package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;


public class MemberReport {
	File currFile;
	Member currMember;
	ArrayList<Visit> visitArray;
	String dateVisit;
	
	MemberReport(Member member, ArrayList<Visit> visits) {
		currMember = member;
		currFile = new File(currMember.name + currMember.id + ".txt");
		visitArray = visits;
	}
	
	/**
	   * This is the generate file function. It creates a file for a specific user detailing the user's credentials and history.
	   * @param 
	   * @return void
	   */
	
	void generateFile() {
		int i = 0, flag = 0;
		try {
			FileWriter fileWriter = new FileWriter(currFile);
			fileWriter.write(currMember.name + '\n');
			fileWriter.write((int) currMember.id + '\n');
			fileWriter.write(currMember.address  + '\n');
			fileWriter.write(currMember.city + '\n');
			fileWriter.write(currMember.state + '\n');
			fileWriter.write(currMember.zipCode + '\n');
			
			while(i <= visitArray.size()) {
				for(i = flag; i < visitArray.size(); i++) {
					if(currMember.name == visitArray.get(i).member.name) {
						break;
					}
				}
				if((i == visitArray.size()) && (currMember.name != visitArray.get(i).member.name)) {
					break;
				}
				dateVisit = visitArray.get(i).dateOfService.toString();
				fileWriter.write(dateVisit + '\n');
				fileWriter.write(visitArray.get(i).provider.name + '\n');
				fileWriter.write(visitArray.get(i).service.getName() + '\n');			
				fileWriter.write('\n');
				flag = i;
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





