package objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

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

	void email() {
		
	}
}
