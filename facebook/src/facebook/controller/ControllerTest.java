package facebook.controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

class ControllerTest {
	FacebookControllerInterface fc = null;

	@BeforeEach
	void setUp() throws Exception {
		fc = new FacebookController();
	}

	@AfterEach
	void tearDown() throws Exception {
		fc = null;
	}

	@Test
	void testsignUp() {
		int i = fc.signUp();
		assert i>0: "Test failed to create profile";
	}

	@Test
	void testEditProfileController() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to edit : ");
		String email = s.next();
		int i = fc.editProfileController(email);
		assert i>0: "Test failed to edit profile";
	}

	@Test
	void testDeleteProfileController() {
		int i = fc.deleteProfileController();
		assert i>0: "Test failed to delete profile";
	}

	@Test
	void testViewProfileController() {
		FacebookUser user = fc.viewProfileController();
		assert user != null: "Test failed to create profile";
	}

	@Test
	void testSearchProfileController() {
		ArrayList<FacebookUser> lis = fc.searchProfileController();
		assert lis != null: "Test failed to search profiles";
	}
	
	@Test
	void testSortProfileController() {
		ArrayList<FacebookUser> lis = fc.sortProfileController();
		assert lis != null: "Test failed to search profiles";
	}
	
	@Test
	void testCreateTimelineController() {
		int i = fc.createTimelineController();
		assert i>0 : "Test failed to create timeline";
	}

}
