package tests;

//created by: Alex Ramsayer

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import interfaces.ProviderInterface;
import objects.Visit;
import java.io.File;
import objects.Member;
import objects.Provider;
import objects.EFTReport;


public class ValidateMemberTest {
  
    ProviderInterface inter = new ProviderInterface();
    

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSwipeMemberCard() {
		inter.swipeMemberCard();
	}
	
}
