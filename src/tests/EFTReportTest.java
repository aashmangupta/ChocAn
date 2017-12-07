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
	ArrayList<Visit> testList;
	Visit visit;
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
		eft = new EFTReport(visit);
	}

	@Test
	public void testGenerateFile() {
		testFile = new File("//release//reports");
		assertTrue(testFile.exists());
		
	}
	
	@Test (expected )
	public void test2{
		
	}
	
	@Test
	public void test3{
		
	}

}
