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
		
		mem = new Member();
		pro = new Provider();
		com = "";
		tester = true;
		id = 123456789;
	}

	@Test
	public void testCreateVisit() {
		tester = servCont.createVisit(mem.id, pro.id, serv, com);
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
