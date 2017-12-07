package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import control.ChocAnControl;
import control.UserManager;

//CREATED BY AASHMAN

public class UserManagerTest {
	
	//Test to see if correct:		Edit a certain member and then check name to make sure
	//Test for exception: 	  		Enter an ID that does not exist to edit
	//Test to edit and edit back:	Edit the name of a member and then edit it back 
	
	ChocAnControl ChocAn;
	UserManager userManager;

	@Before
	public void setUp() throws Exception {
		userManager = new UserManager();
	}

	@Test
	public void testSuccess() {
		String input = "7000000002";
		userManager.editMember();
		InputStream in = new ByteArrayInputStream(input.getBytes());
  		System.setIn(in);
		input = "name";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		input = "Not Ben";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		input = "stop";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals("Not Ben", ChocAn.members.get(1).name);
	}
	
	@Test
	public void testFail() {
		boolean check;
		String input;
		check = userManager.editMember();
		input = "8000000002";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals(false, check);
	}
	
	@Test
	public void testDelete() {
		String nameHolder = ChocAn.members.get(1).name;
		String checkName;
		String input;
		userManager.editMember();
		input = "7000000002";
		userManager.editMember();
		InputStream in = new ByteArrayInputStream(input.getBytes());
		input = "name";
		userManager.editMember();
		in = new ByteArrayInputStream(input.getBytes());
		input = "Not Ben";
		userManager.editMember();
		in = new ByteArrayInputStream(input.getBytes());
		input = "name";
		userManager.editMember();
		in = new ByteArrayInputStream(input.getBytes());
		input = "Ben Sanders";
		userManager.editMember();
		in = new ByteArrayInputStream(input.getBytes());
		checkName = ChocAn.members.get(1).name;

		assertEquals(nameHolder, checkName);
	}

}