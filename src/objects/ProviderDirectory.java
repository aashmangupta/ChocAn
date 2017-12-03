package objects;

import objects.Service;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import interfaces.UserInterface;

public class ProviderDirectory {
	private ArrayList<Service> services = new ArrayList<Service>();	//makes service ArrayList
	File writeFile;	//makes file to be written to and sent as an email
	
	public ProviderDirectory() {
		services.add(new Service("Aerobics Exercise Session", 883948, 20));	//populates ArrayList
		services.add(new Service("Cardio Exercse Session", 883951, 20));		//populates ArrayList
		services.add(new Service("Dietitian Session", 598470, 30));			//populates ArrayList
		services.add(new Service("Hypnosis Session", 883950, 80));			//populates ArrayList
		services.add(new Service("Shock Therapy Session", 883949, 60));		//populates ArrayList
		services.add(new Service("Error: invalid code", 000000, 0));			//populates ArrayList
	}
	
	/**
	 * This function writes all the services to a file and emails it to the provider.
	 * 
	 * @param none
	 * @return void
	 */
	public void email() {
		int i = 0;
		
		if(new File("release").exists()){
		  writeFile = new File("release\\data\\ProviderDirectory.txt");
		}
		else {
		  writeFile = new File("data\\ProviderDirectory.txt");
		}
		
		//creates file
		Service currServ = new Service();						//holder service
		
		try {
			FileWriter fileWriter = new FileWriter(writeFile);	//sets up file writer
			fileWriter.write("Services: \n");
			fileWriter.write("name - code - fee \n");
			fileWriter.write("");
			
			for(i = 0; i < services.size() - 1; ++i) {			//loops through services to write each to file
				currServ = services.get(i);						//gets a specific service
				fileWriter.write(currServ.getName() + " - ");	//writes name
				fileWriter.write(currServ.getCode() + " - ");	//writes code
				fileWriter.write(currServ.getFee() + " \n");		//writes fee
			}
			fileWriter.close();									//closes file
		}
		
		catch(IOException e) {									//catches IOException
			System.out.println("Error");
		}
	}
	
	/**
	 * This method finds a specific service in the service directory using its
	 * 	code then returns it.
	 * 
	 * @param code
	 * @return Service
	 */
	public Service getService(long code) {
		int i = 0;
		for(i = 0; i < 5; ++i) {						//loops through service directory
			if(services.get(i).getCode() == code) {	//if service code is the code being searched for
				return services.get(i);				//return service
			}
		}
		return services.get(5);						//service not found, return error service
	}
	
	/**
	 * This method prints the Provider Directory to the screen.
	 * 
	 * @param none
	 * @return none
	 */
	public void getDirectory() {
		int i = 0;
		Service currServ = new Service();						//holder service
		String outStr = "";
		
		UserInterface.state("Services:\n");
		UserInterface.state("name - code - fee\n");
		for(i = 0; i < services.size() - 1; ++i) {				//loops through services
			currServ = services.get(i);							//service to be printed
			outStr += currServ.getName();
			outStr += " - ";
			outStr += currServ.getCode();
			outStr += " - ";
			outStr += currServ.getFee();
			UserInterface.prompt(outStr);
			outStr = "";
		}
		return;
	}
}
