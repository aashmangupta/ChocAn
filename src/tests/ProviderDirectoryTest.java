package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import objects.ProviderDirectory;
import objects.Service;

//Created by Spencer Fuhriman, testing Ben Sanders' code

public class ProviderDirectoryTest {
	ProviderDirectory test;
	Service srv;
	
	@Before
	public void setUp() throws Exception {
		test = new ProviderDirectory();
		srv  = new Service();
	}

	@Test
	public void testGetServiceSuccessServiceName() {
		long code = 883948;
		srv = test.getService(code);
		assertEquals("Aerobics Exercise Session", srv.getName());
	}
	@Test
	public void testGetServiceSuccessServiceFee() {
		long code = 883950;
		srv = test.getService(code);
		assertEquals("80", Integer.toString(srv.getFee()));
	}
	@Test
	public void testGetSerivceFailure() {
		long code = 3456453;
		srv = test.getService(code);
		assertEquals("Error: invalid code", srv.getName());
	}
}
