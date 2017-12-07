package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
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

//Created by Alexander Ramsayer

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
    public static DateFormat dateFormat;
    
    /**
	   * Constructor.
	   * Sets up the central control for the ChocAn system
	   */
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

      
     Scanner s;
      try {
        s = new Scanner(new File("release"+File.separator+"data"+ File.separator+"members.txt"));
      
      Member temp;
      UserInterface.state("loading members...");
      while (s.hasNextLine()){
           temp = new Member();
           UserInterface.state(".");
           
           temp.id = Long.parseLong(s.nextLine());
           temp.name = s.nextLine();
           temp.address = s.nextLine();
           temp.city = s.nextLine();
           temp.state = s.nextLine();
           temp.zipCode =  s.nextLine();
           temp.accountStatus = Boolean.parseBoolean(s.nextLine());
           
           members.add(temp);
           
      }
      s.close();
      UserInterface.prompt("...done");
      
      }
      catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        s = new Scanner(new File("release"+File.separator+"data"+ File.separator+"providers.txt"));
      
      Provider temp;
      UserInterface.state("loading providers...");
      while (s.hasNextLine()){
           temp = new Provider();
           UserInterface.state(".");
           
           temp.id = Long.parseLong(s.nextLine());
           temp.name = s.nextLine();
           temp.address = s.nextLine();
           temp.city = s.nextLine();
           temp.state = s.nextLine();
           temp.zipCode =  s.nextLine();
           temp.totalFees = Integer.parseInt(s.nextLine());
           temp.totalConsultations = Integer.parseInt(s.nextLine());
           
           providers.add(temp);
           
      }
      s.close();
      UserInterface.prompt("...done");
      
      }
      catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        s = new Scanner(new File("release"+File.separator+"data"+ File.separator+"visits.txt"));
      
      Visit temp;
      UserInterface.state("loading visits...");
      while (s.hasNextLine()){
           temp = new Visit();
           UserInterface.state(".");
           
           long memberId = Long.parseLong(s.nextLine());
           long providerId = Long.parseLong(s.nextLine());
           long serviceId = Long.parseLong(s.nextLine());
           
           Member tempM = new Member();
           Provider tempP = new Provider();
           Service tempS = new Service();
           
           for (int i = 0; i < members.size(); ++i) { //loop to find member
             if (members.get(i).id == memberId) {
               tempM = members.get(i);
             }
           }
           for (int i = 0; i < providers.size(); ++i) {  //loop to find provider
             if (providers.get(i).id == providerId) {
               tempP = providers.get(i);
             }
           }
           for (int i = 0; i < providerDirectory.services.size(); ++i) {  //loop to find provider
             if (providerDirectory.services.get(i).code == serviceId) {
               tempS = providerDirectory.services.get(i);
             }
           }
           
           temp.member = tempM;
           temp.provider = tempP;
           temp.service = tempS;
           try {temp.dateOfService = dateFormat.parse(s.nextLine());}
           catch(ParseException p) {}
           temp.comments = s.nextLine();
                     
           visits.add(temp);
           
      }
      s.close();
      UserInterface.prompt("...done");
      
      }
      catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      managerIds.add((long) 900000001);
      managerIds.add((long) 900000002);
      managerIds.add((long) 900000003);

      operatorIds.add((long) 1000000001);
      operatorIds.add((long) 1000000002);
      operatorIds.add((long) 1000000003);

    }
    
    public ChocAnControl(boolean test) {
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
    }

    /**
	   * Creates new provider directory for use.
	   *
	   * @return ProviderDirectory
	   */
	public ProviderDirectory getProviderDirectory(){
		return new ProviderDirectory();
	}
	
	/**
	   * Method called to run the Main Accounting Procedure.
	   *
	   * @return void
	   */
	public static void runMainAccountingProcedure() {
	    mainProcedure.produceMemberReports();
	    mainProcedure.produceManagerSummary();
	    mainProcedure.produceProviderReports();
	    mainProcedure.produceEFT();
	}
	
	/**
	   * Checks time to run the Main Accounting Procedure.
	   * 
	   * @return void
	   */
	public static void checkTimeAndDate() {
	  runMainAccountingProcedure();
	}

	/**
	   * Method called to generate a report.
	   * 
	   * @param type, string used to check what kind of report to generate
	   * @return boolean
	   */
	public boolean generateReport(String type) {
	    if(type == "member") mainProcedure.produceMemberReports();
	    if(type == "manager") mainProcedure.produceManagerSummary();
	    if(type == "provider") mainProcedure.produceProviderReports();
	    if(type == "EFT") mainProcedure.produceEFT();

	    return true;
	}

	/**
	   * Method called to start service control.
	   * 
	   * @return void
	   */
  public static void runServiceControl() {
    // TODO Auto-generated method stub

  }



}
