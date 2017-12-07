package tests;

//import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import control.ChocAnControl;
import control.UserManager;
import objects.Member;

//CREATED BY AASHMAN

public class UserManagerTest {
	
	//Test to see if correct:		Edit a certain member and then check name to make sure
	//Test for exception: 	  		Enter an ID that does not exist to edit
	//Test to edit and edit back:	Edit the name of a member and then edit it back 
	
	UserManager userManager;
	Member memToAdd;
	ChocAnControl control;

	@Before
	public void setUp() throws Exception {
		userManager = new UserManager();
		control = new ChocAnControl();
	}

	@Test
	public void testSuccess() {
		memToAdd = new Member();
		ChocAnControl.members.add(memToAdd);
		userManager.editMember("123456789", "name", "Not John");
		assertEquals("Not John", ChocAnControl.members.get(7).name);
	}
	
	@Test
	public void testFail() {
		long id = 123456789;
		memToAdd = new Member("John Doe", id, "001 main street", "town", "000001", "st", true);
		ChocAnControl.members.add(memToAdd);
		userManager.editMember("8000000002", "name", "Not Ben");
		assertEquals("John Doe", ChocAnControl.members.get(7).name);
	}
	
	@Test
	public void testEditing() {
		memToAdd = new Member();
		ChocAnControl.members.add(memToAdd);
		String nameHolder = ChocAnControl.members.get(7).name;
		String checkName;
		userManager.editMember("123456789", "name", "Not John");
		userManager.editMember("123456789", "name", "John Doe");
		checkName = ChocAnControl.members.get(7).name;

		assertEquals(nameHolder, checkName);
	}

}