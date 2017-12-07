package tests;

//created by: Alex Ramsayer, testing Spencer Fuhriman's methods

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import control.ChocAnControl;
import interfaces.ProviderInterface;
import objects.Visit;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import objects.Member;
import objects.Provider;
import objects.EFTReport;


public class ValidateMemberTest {
  
    ProviderInterface inter;
    ChocAnControl control;
    InputStream in;
    String inputs;
    

	@Before
	public void setUp() throws Exception {
		control = new ChocAnControl();
	}

	@Test
	public void testSwipeMemberCardSuccess() {
		inputs = "6776";
		in = new ByteArrayInputStream(inputs.getBytes());
		inter = new ProviderInterface(true, in);
		ChocAnControl.members.add(new Member("test Member", 6776, "1234 lane", "San Diego", "92128", "California", true));
		assertTrue(inter.swipeMemberCard());
	}
	
	@Test
	public void testSwipeMemberCardFail() {
		inputs = "10000000001";
		in = new ByteArrayInputStream(inputs.getBytes());
		inter = new ProviderInterface(true, in);
		assertFalse(inter.swipeMemberCard());
	}

	@Test
	public void testSwipeMemberCardSuspend() {
		inputs = "23456";
		in = new ByteArrayInputStream(inputs.getBytes());
		inter = new ProviderInterface(true, in);
		ChocAnControl.members.add(new Member("test Member", 23456, "1234 lane", "San Diego", "92128", "California", false));
		inter.swipeMemberCard();
	}
	
	@Test
	public void testSwipeMemberCardSanity() {
		inputs = "8423 8423 8423";
		in = new ByteArrayInputStream(inputs.getBytes());
		inter = new ProviderInterface(true, in);
		assertFalse(inter.swipeMemberCard());
		ChocAnControl.members.add(new Member("test Member", 8423, "1234 lane", "San Diego", "92128", "California", true));
		assertTrue(inter.swipeMemberCard());
		ChocAnControl.members.remove(ChocAnControl.members.size() - 1);
		assertFalse(inter.swipeMemberCard());
		
	}
}
