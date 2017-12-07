package tests;

//created by: Derek Hastings testing Aashman's code


import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import objects.Visit;
import java.io.File;
import objects.Member;
import objects.Provider;
import objects.EFTReport;


public class EFTReportTest {
	Visit visit;
	ArrayList<Visit> testList, visitArr;
	ArrayList<String> testList2;
	File testFile;
	Member testMem;
	Provider testPro;
	EFTReport eft;

	@Before
	public void setUp() throws Exception {
		System.out.println("Hello world!");
		testMem = new Member();
		testPro = new Provider();
		visit = new Visit();
		testList.add(visit);
		eft = new EFTReport(testList);
	}

	@Test
	public void testGenerateFile() {
		
	}
	
	/*@Test
	public void testGenerateFile2() {
		eft = new EFTReport(visitArr);
	}*/
}
