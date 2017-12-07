package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import control.ChocAnControl;
import control.ServiceControl;
import objects.Member;
import objects.Provider;
import objects.Service;


public class ServiceControlTest {
	ChocAnControl chocAn;
	ServiceControl servCont;
	Member mem;
	Provider pro;
	Service serv;
	String com;
	boolean tester;
	boolean tester2;
	long id;

	@Before
	public void setUp() throws Exception {
		chocAn = new ChocAnControl();
		servCont = new ServiceControl();
		serv = new Service("test", 900000009, 10);
		mem = new Member(String name, long ID, String add, String city, String zip, String st, 
				boolean status);
		pro = new Provider(String name, long ID, String add, String city, String zip, String st, 
				int fees, int consul);
		com = "";
		tester = true;
	}

	@Test
	public void testCreateVisit() {
		tester = servCont.createVisit(700000001, 800000001, serv, com);
		assertTrue(tester);
	}
	
	@Test
	public void testSanity() {
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
		tester2 = servCont.createVisit(mem.id, pro.id, serv, com);
		
		assertEquals(ChocAnControl.visits.get(0), ChocAnControl.visits.get(1));
	}
	
	@Test
	public void testFailure() {
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
		assertEquals(tester, false);
	}
}
