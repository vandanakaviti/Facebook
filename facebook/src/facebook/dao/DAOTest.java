package facebook.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

class DAOTest {
	FacebookDAOInterface fd = null;
	@BeforeEach
	void setUp() throws Exception {
		fd = new FacebookDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
		fd = null;
	}

	@Test
	void testSignUpDAO() {
		System.out.println("SIGN-UP DAO TEST");
		Scanner s = new Scanner(System.in);
		FacebookUser fu = new FacebookUser();
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
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setDateOfBirth(dateOfBirth);
		fu.setGender(gender);
		int i = fd.signUpDAO(fu);
		assert i>0: "Test failed to sign up";
	}

	@Test
	void testSignInDAO() {
		System.out.println("SIGN-IN DAO TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your email : ");
		String email = s.next();
		System.out.print("Enter your password : ");
		String password = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser user = fd.signInDAO(fu);
		assert user != null: "Test failed to sign-in";
	}

	@Test
	void testEditProfileDAO() {
		System.out.println("EDITING PROFILE DAO TEST");
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
		
		FacebookUser fu1 = new FacebookUser();
		fu1.setName(name);
		fu1.setPassword(password);
		fu1.setDateOfBirth(dateOfBirth);
		fu1.setGender(gender);
		
		int i = fd.editProfileDAO(fu, fu1);
		assert i>0: "Test failed to edit profile";
	}

	@Test
	void testDeleteProfileDAO() {
		System.out.println("DELETING PROFILE DAO TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to delete : ");
		String email = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		int i = fd.deleteProfileDAO(fu);
		assert i>0: "Test failed to delete profile";
	}

	@Test
	void testViewProfileDAO() {
		System.out.println("VIEWING PROFILE DAO TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to view : ");
		String email = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser user = fd.viewProfileDAO(fu);
		assert user != null: "Test failed to view profile";
	}

	@Test
	void testSearchProfileDAO() {
		System.out.println("SEARCHING PROFILE DAO TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a name you wish to search : ");
		String name = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis = fd.searchProfileDAO(fu);
		assert lis != null: "Test failed to search profile";
	}

	@Test
	void testSortProfileDAO() {
		System.out.println("SORTING PROFILE DAO TEST");
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
		
		FacebookTimeline ft = new FacebookTimeline();
		ft.setMessageid(message_id);
		ft.setSender(sender);
		ft.setReceiver(receiver);
		ft.setMessage(message);
		ft.setDate(message_date);
		
		int i = fd.createTimelineDAO(ft);
		assert i>0 : "Test failed to create timeline";
	}

}
