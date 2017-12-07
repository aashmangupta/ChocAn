package tests;
import control.AccountingProcedure;
import control.ChocAnControl;
import javafx.scene.shape.Path;
import objects.Member;
import objects.Provider;
import objects.Service;
import objects.Visit;
import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class EFTTest {
	Visit visit;
	ArrayList<Visit> visitArray;
	AccountingProcedure x = new AccountingProcedure();
	Member m = new Member("Ash", 3456789, "address", "Phoenix", "85023", "street", true);
	Provider p = new Provider("Doc", 9876543, "address2", "Tusc", "85042", "street2", 80, 2);
	Service s = new Service("chemo", 893, 90);
	String comment = "No comment";
	ChocAnControl control;
	
	@Before
	public void setUp() throws Exception {
		control = new ChocAnControl(true);
	}

	@Test 
	public void testSuccess() {
		visit = new Visit(m, p, s, comment);
		File currFile = new File("release" + File.separator + "reports" + File.separator + "EFT.txt");
		ChocAnControl.visits.add(visit);
		x.produceEFT();
		assertEquals(currFile.exists(), true);
	}
	
	@Test (expected = NullPointerException.class)
	//@Test (expected = AssertionError.class)
	public void testFailure() {
		//File currFile = new File("release" + File.separator + "reports" + File.separator + "EFT.txt");
		//currFile.delete();
		x.produceEFT();
		//assertEquals(currFile.exists(), false);
	}
	
}
