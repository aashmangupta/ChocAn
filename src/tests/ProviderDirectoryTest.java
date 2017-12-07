package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import objects.ProviderDirectory;

public class ProviderDirectoryTest {
	ProviderDirectory proDir;

	@Before
	public void setUp() throws Exception {
		proDir = new ProviderDirectory();
	}

	@Test
	public void testGetDirectory() {
		proDir.getDirectory();
		assertEquals("d", proDir.getDirectory());
	}

	public void testException() {
		
	}
	
	public void testFailure() {
		
	}
}
