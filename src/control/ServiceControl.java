package control; 

//Coded by Ben Sanders

import objects.Member;
import objects.Provider;
import control.ChocAnControl;
import objects.Visit;
import objects.Service;
import interfaces.UserInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServiceControl {
  private Scanner sc;			//creates scanner
  private Service service;
  private String commentString;
  private Member mem;
  private Provider pro;
  int i;
  private long code;
  private Date date;
  File writeFile;

  public ServiceControl() {
    sc = new Scanner(System.in);		//initializes scanner
    service = new Service();			//creates service to be used for 
    commentString = "";
    i = 0;
  }

  /**
   * This method is used by providers to create new visits for members.
   *
   * @param Member, Provider.
   * @return boolean.
   */
  public boolean createVisit(long m, long p, Service s) {

    UserInterface.prompt("Attempting to generate visit");
    
    for (i = 0; i < ChocAnControl.members.size(); ++i) {	//loop to find member
      if (ChocAnControl.members.get(i).id == m) {
        mem = ChocAnControl.members.get(i);
      }
    }
    for (i = 0; i < ChocAnControl.providers.size(); ++i) {	//loop to find provider
      if (ChocAnControl.providers.get(i).id == p) {
        UserInterface.prompt("Checking provider " + ChocAnControl.providers.get(i).toString());
        pro = ChocAnControl.providers.get(i);
      }
    }
    Visit newVisit = new Visit(mem, pro, s);	//creates visit
    ChocAnControl.visits.add(newVisit); 		//adds visit to visit list

    if (new File("release").exists()) {	//checks if outside or inside release folder
      writeFile = new File("release\\data\\visits.txt");	//moves into release and stores in data
    } else {
      writeFile = new File("data\\visits.txt");	//stores in data
    }

    try {
      FileWriter out = new FileWriter(writeFile); // writing to a separate text file
      out.write(Long.toString(mem.id) + " ");
      out.write(Long.toString(pro.id) + " ");
      out.write(Long.toString(s.getCode()) + " ");
      out.write(ChocAnControl.dateFormat.format(newVisit.dateOfService) + " ");
      out.close();	//closes file
      return true;
    } catch (IOException e) {	//catches IOException
      UserInterface.prompt("Error writing file for visits");
      return false;
    }
  }

  /**
   * This method displays the name of the visit (service) on the screen for the provider and member.
   *
   * @param long.
   * @return void.
   *
   */
  public void displayName(long c) {
    for (i = 0; i < 5; ++i) {	//loops through services
      if (service.getCode() == c) {	//checks service code against code being searched for
        UserInterface.prompt(service.getName());	//prints name of service
        return;
      }
    }

    UserInterface.prompt("Error: Service not found.");
    return;
  }

  /**
   * This method allows providers to enter comments on visits created.
   *
   * @param none.
   * @return void.
   */
  public void enterComments() {
    UserInterface.prompt("Enter comments:");	//prints to screen
    commentString = sc.next();	//takes in user input
    commentString += sc.nextLine();	//takes in user input
    return;
  }

  /**
   * This method displays an error in the event of invalid information being entered or other
   * issues.
   *
   * @param none.
   * @return void.
   */
  public void displayError() {
    UserInterface.prompt("Error");	//prints Error to screen
    return;
  }
}
