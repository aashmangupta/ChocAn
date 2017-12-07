package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import control.ChocAnControl;
import control.ServiceControl;
import objects.Member;
import objects.Provider;
import objects.Service;
import objects.ProviderDirectory;

import java.util.ArrayList;
import objects.Visit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import objects.EFTReport;

//Created by Ben Sanders, testing Alex Ramsayer's Method

public class ServiceControlTest {
	ChocAnControl chocAn;
	ServiceControl servCont;
	ProviderDirectory proDir;
	Member mem;
	Provider pro;
	Service serv;
	String com;
	boolean tester;
	boolean tester2;
	long id;

	@Before
	public void setUp() throws Exception {
		com = "";
		tester = true;
	}

	@Test
	public void testCreateVisit() {
		servCont = new ServiceControl();
		proDir = new ProviderDirectory();
		serv = proDir.getService(883948);
		mem = new Member("test_member", 1133, "123 street", "northlake", "767676", "Oaklahoma", true);
		pro = new Provider("test_provider", 3311, "123 lane", "south", "132413", "New Mexico", 10, 0);
		ChocAnControl.members.add(mem);
		ChocAnControl.providers.add(pro);
		
		
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
		assertTrue(tester);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testException() {
		chocAn = new ChocAnControl();
		servCont = new ServiceControl();
		serv = proDir.getService(883948);
		mem = new Member("test_member", 1133, "123 street", "northlake", "767676", "Oaklahoma", true);
		pro = new Provider("test_provider", 3311, "123 lane", "south", "132413", "New Mexico", 10, 0);
		ChocAnControl.members.add(mem);
		ChocAnControl.providers.add(pro);
		
		
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
	}
	
	@Test
	public void testFailure() {
		servCont = new ServiceControl();
		proDir = new ProviderDirectory();
		serv = proDir.getService(883948);
		mem = new Member("test_member", 1133, "123 street", "northlake", "767676", "Oaklahoma", false);
		pro = new Provider("test_provider", 3311, "123 lane", "south", "132413", "New Mexico", 10, 0);
		ChocAnControl.members.add(mem);
		ChocAnControl.providers.add(pro);
		
		
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
		assertFalse(tester);
	}
}
