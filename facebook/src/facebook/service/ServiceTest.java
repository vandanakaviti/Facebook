package facebook.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public class ServiceTest {
	FacebookServiceInterface fs = null;
	
	@Before
	public void setUp() throws Exception {
		fs = new FacebookService();
	}

	@After
	public void tearDown() throws Exception {
		fs = null;
	}

	@Test
	public void testSignUpService() {
		System.out.println("SIGN-UP SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = s.next();
		
		System.out.print("Enter your password : ");
		String password = s.next();
		
		System.out.print("Enter your email : ");
		String email = s.next();
		
		System.out.print("Enter your date of birth : ");
		String dateOfBirth = s.next();
		
		System.out.print("Enter your gender : ");
		String gender = s.next();
		System.out.println();
		
		FacebookUser fu = new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setDateOfBirth(dateOfBirth);
		fu.setGender(gender);
		
		int i = fs.signUpService(fu);
		assert i>0: "Test failed to sign-up";
		
	}

	@Test
	public void testSignInService() {
		System.out.println("SIGN-IN SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your email : ");
		String email = s.next();
		System.out.print("Enter your password : ");
		String password = s.next();
		System.out.println();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser user = fs.signInService(fu);
		assert user != null: "Test failed to sign-in";
	}

	@Test
	public void testEditProfileService() {
		System.out.println("EDITING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter email whose profile you wish to edit : ");
		String email = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		System.out.print("Edit name : ");
		String name = s.next();
		
		System.out.print("Edit password : ");
		String password = s.next();
		
		System.out.print("Edit date of birth : ");
		String dateOfBirth = s.next();
		
		System.out.print("Edit gender : ");
		String gender = s.next();
		System.out.println();
		
		FacebookUser fu1 = new FacebookUser();
		fu1.setName(name);
		fu1.setPassword(password);
		fu1.setDateOfBirth(dateOfBirth);
		fu1.setGender(gender);
		
		int i = fs.editProfileService(fu, fu1);
		assert i>0: "Test failed to edit profile";
	}

	@Test
	public void testDeleteProfileService() {
		System.out.println("DELETING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to delete : ");
		String email = s.next();
		System.out.println();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		int i = fs.deleteProfileService(fu);
		assert i>0: "Test failed to delete profile";
	}

	@Test
	public void testViewProfileService() {
		System.out.println("VIEWING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to view : ");
		String email = s.next();
		System.out.println();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser user = fs.viewProfileService(fu);
		assert user != null: "Test failed to view profile";
	}

	@Test
	public void testSearchProfileService() {
		System.out.println("SEARCHING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a name you wish to search : ");
		String name = s.next();
		System.out.println();
		
		FacebookUser fu = new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis = fs.searchProfileService(fu);
		assert lis != null: "Test failed to search profile";
	}
	
	@Test
	public void testCreateTimelineService() {
		System.out.println("CREATING TIMELINE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter message id : ");
		String message_id = s.next();
		
		System.out.print("Enter sender email id : ");
		String sender = s.next();
		
		System.out.print("Enter receiver email id : ");
		String receiver = s.next();
		
		System.out.print("Enter message : ");
		String message = s.next();
		
		System.out.print("Enter date : ");
		String message_date = s.next();
		
		System.out.println();
		
		FacebookTimeline ft = new FacebookTimeline();
		ft.setMessageid(message_id);
		ft.setSender(sender);
		ft.setReceiver(receiver);
		ft.setMessage(message);
		ft.setDate(message_date);
		
		int i = fs.createTimelineService(ft);
		assert i>0 : "Test failed to create timeline";
	}

}
