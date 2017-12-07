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
	
	UserManager userManager;

	@Before
	public void setUp() throws Exception {
		userManager = new UserManager();
	}

	@Test
	public void testSuccess() {
		userManager.editMember("7000000002", "name", "Not Ben");
		assertEquals("Not Ben", ChocAnControl.members.get(1).name);
	}
	
	@Test
	public void testFail() {
		boolean check;
		String input;
		check = userManager.editMember();
		userManager.editMember("8000000002", "name", "Not Ben");
		assertEquals(false, check);
	}
	
	@Test
	public void testEditing() {
		String nameHolder = ChocAnControl.members.get(1).name;
		String checkName;
		String input;
		userManager.editMember("7000000002", "name", "Not Ben");
		userManager.editMember("7000000002", "name", "Ben Sanders");
		checkName = ChocAnControl.members.get(1).name;

		assertEquals(nameHolder, checkName);
	}

}