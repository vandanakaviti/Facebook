package facebook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;
import facebook.service.FacebookServiceInterface;
import facebook.utility.ServiceFactory;
import facebook.utility.sortByName;

public class FacebookController implements FacebookControllerInterface {
	FacebookServiceInterface fs = null;
	Scanner s = null;
	Logger log = Logger.getLogger("Whatsapp Controller");
	
	public FacebookController() {
		s = new Scanner(System.in);
		fs = ServiceFactory.createObject();
	}
	
	@Override
	public int signUp() {
		
		System.out.println("CREATING PROFILE : ");
		
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
		
		if (i > 0) {
			System.out.println("Profile created");
			System.out.println();
		}
		
		else {
			System.out.println("Could not create your profile");
			System.out.println();
		}
		
		return i;

	}
	
	@Override
	public FacebookUser signIn() {
		System.out.print("Enter your email : ");
		String email = s.next();
		System.out.print("Enter your password : ");
		String password = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser user = fs.signInService(fu);
		return user;
	}

	@Override
	public int editProfileController(String email) {
		System.out.println("EDITING PROFILE : ");
		
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
		
		
		int i = fs.editProfileService(fu, fu1);
		
		if (i > 0) {
			System.out.println("Profile edited");
			System.out.println();
		}	
		else {
			System.out.println("Could not edit your profile");
			System.out.println();
		}
		
		return i;

	}

	@Override
	public int deleteProfileController() {
		System.out.println("DELETING PROFILE : ");
		System.out.print("Enter the email whose profile you wish to delete : ");
		String email = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		int i = fs.deleteProfileService(fu);
		
		if (i > 0) {
			System.out.println("Profile deleted");
			System.out.println();
		}
		
		else {
			System.out.println("Could not delete your profile");
			System.out.println();
		}
		return i;
	}

	@Override
	public FacebookUser viewProfileController() {
		System.out.println("VIEWING PROFILE : ");
		System.out.print("Enter the email whose profile you wish to view : ");
		String email = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser user = fs.viewProfileService(fu);
		
		if (user != null) {
			System.out.println("Name is " + user.getName());
			System.out.println("Password is " + user.getPassword());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Date of Birth is " + user.getDateOfBirth());
			System.out.println("Gender is " + user.getGender());
			System.out.println();
		}
		
		else {
			System.out.println("Profile not found");
			System.out.println();
		}
		
		return user;

	}
	
	@Override
	public ArrayList<FacebookUser> viewAllProfilesController() {
		System.out.println("VIEWING ALL PROFILES : " + "\n");
		ArrayList<FacebookUser> lis = new ArrayList<FacebookUser>();
		FacebookUser fu = new FacebookUser();
		
		lis = fs.viewAllProfilesService();
		
		if (lis != null) {
			System.out.println("Profiles in Sorted Order");
			for (FacebookUser user : lis) {
				System.out.println("^^^^^^^^^^^^^^");
				System.out.println("Name is " + user.getName());
				System.out.println("Password is " + user.getPassword());
				System.out.println("Email is " + user.getEmail());
				System.out.println("Date of Birth is " + user.getDateOfBirth());
				System.out.println("Gender is " + user.getGender());
			}
		}
			
			System.out.println();
		return lis;
	}

	@Override
	public ArrayList<FacebookUser> searchProfileController() {
		System.out.println("SEARCHING PROFILES : ");
		System.out.print("Enter a name you wish to search : ");
		String name = s.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis = fs.searchProfileService(fu);
		
		if (lis != null) {
			if (lis.size() > 1) {System.out.println(lis.size() + " profiles found");}
			else {System.out.println(lis.size() + " profile found");}
			for (FacebookUser user : lis) {
				System.out.println("-----------------------");
				System.out.println("Name is " + user.getName());
				System.out.println("Password is " + user.getPassword());
				System.out.println("Email is " + user.getEmail());
				System.out.println("Date of Birth is " + user.getDateOfBirth());
				System.out.println("Gender is " + user.getGender());
			}
			System.out.println();
		}
		
		else {
			System.out.println("No profiles found with the given name");
		}
		
		return lis;
	}

	@Override
	public ArrayList<FacebookUser> sortProfileController() {
		System.out.println("SORTING PROFILES BY NAME : ");
		ArrayList<FacebookUser> lis = new ArrayList<FacebookUser>();
		FacebookUser fu = new FacebookUser();
		
		lis = fs.viewAllProfilesService();
		
		if (lis != null) {
			Collections.sort(lis, new sortByName());
			System.out.println("Profiles in Sorted Order");
			for (FacebookUser user : lis) {
				System.out.println("^^^^^^^^^^^^^^");
				System.out.println("Name is " + user.getName());
				System.out.println("Password is " + user.getPassword());
				System.out.println("Email is " + user.getEmail());
				System.out.println("Date of Birth is " + user.getDateOfBirth());
				System.out.println("Gender is " + user.getGender());
			}
			
			System.out.println();
		}
		
		else {
			System.out.println("No profiles found");
			System.out.println();
		}
		
		return lis;
		
	}

	@Override
	public int createTimelineController() {
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
		
		int i = fs.createTimelineService(ft);
		
		if (i > 0) {
			System.out.println("Timeline updated");
		}
		
		else {
			System.out.println("Could not update timeline");
		}
		
		return i;
		
		
	}

}
