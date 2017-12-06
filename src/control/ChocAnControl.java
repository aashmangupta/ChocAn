package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import interfaces.UserInterface;
import objects.Member;
import objects.Provider;
import objects.ProviderDirectory;
import objects.Service;
import objects.Visit;

public class ChocAnControl {

    public static ArrayList<Long> managerIds;
    public static ArrayList<Long> operatorIds;
    public static ArrayList<Member> members;
    public static ArrayList<Provider> providers;
    public static ArrayList<Visit> visits;
    public static ProviderDirectory providerDirectory;
    public static AccountingProcedure mainProcedure;
    public static ServiceControl serviceControl;
    public static boolean isFridayAtMidnight;
    static DateFormat dateFormat;

    public ChocAnControl(){
      dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      managerIds = new ArrayList<Long>();
      operatorIds = new ArrayList<Long>();
      members = new ArrayList<Member>();
      providers = new ArrayList<Provider>();
      visits = new ArrayList<Visit>();
      providerDirectory = new ProviderDirectory();
      mainProcedure = new AccountingProcedure();
      isFridayAtMidnight = false;
      serviceControl = new ServiceControl();

      
     /* Scanner s;
      try {
        s = new Scanner(new File("release"+File.separator+"data"+ File.separator+"members.txt"));
      
      Member temp;
      UserInterface.state("loading members...");
      while (s.hasNextLine()){
           temp = new Member();
           UserInterface.state(".");
           temp.id = s.nextLong();
           temp.name = s.next();
           temp.address = s.next();
           temp.city = s.next();
           temp.zipCode =  s.next();
           temp.state = s.next();
           temp.accountStatus = s.nextBoolean();
           
           members.add(temp);
           
      }
      s.close();
      UserInterface.prompt("...done");
      
      }
      catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
*/
      providers.add(new Provider("Phil", 98765432, "111 14th ave", "tuscaloosa", "35401", "alabama", 20, 0));
      providers.add(new Provider("Matt", 200000000, "1000 15th st", "tuscaloosa", "35401", "alabama", 80, 0));
      providers.add(new Provider("John", 300000000, "100 16th st", "tuscaloosa", "35401", "alabama", 20, 0));

      managerIds.add((long) 9876543);
      managerIds.add((long) 002);
      managerIds.add((long) 003);

      operatorIds.add((long)45632);
      operatorIds.add((long)002);
      operatorIds.add((long)003);

      visits.add(new Visit(members.get(0), providers.get(1), new Service("servicename", 883950, 80)));

    }


	public ProviderDirectory getProviderDirectory(){
		return new ProviderDirectory();
	}

	public void runMainAccountingProcedure() {
	    mainProcedure.produceMemberReports();
	    mainProcedure.produceManagerSummary();
	    mainProcedure.produceProviderReports();
	    mainProcedure.produceEFT();
	}

	public void checkTimeAndDate() {
	  //checks date
	}

	public boolean generateReport(String type) {
	    if(type == "member") mainProcedure.produceMemberReports();
	    if(type == "manager") mainProcedure.produceManagerSummary();
	    if(type == "provider") mainProcedure.produceProviderReports();
	    if(type == "EFT") mainProcedure.produceEFT();

	    return true;
	}


  public static void runServiceControl() {
    // TODO Auto-generated method stub

  }



}
