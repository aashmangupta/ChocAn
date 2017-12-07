package tests;

//created by: Ben Sanders testing Aashman's code

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
	ArrayList<Visit> testList;
	File testFile;
	Member testMem;
	Provider testPro;
	EFTReport eft;

	@Before
	public void setUp() throws Exception {
		testMem = new Member();
		testPro = new Provider();
		visit = new Visit();
		testList.add(visit);
		eft = new EFTReport(testList);
	}

	@Test
	public void testGenerateFile() {
		eft = new EFTReport(testList);
		testFile = new File("//release//reports");
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testFileCorrectness{
		eft = new EFTReport(testList);
		
	}
	
	@Test //for failure
	public void test3{
		eft = new EFt
	}

}
