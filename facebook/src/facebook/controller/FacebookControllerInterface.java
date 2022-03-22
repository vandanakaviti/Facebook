package facebook.controller;

import java.util.ArrayList;

import facebook.entity.FacebookUser;

public interface FacebookControllerInterface {

	int signUp();
	
	FacebookUser signIn();

	int editProfileController(String email);

	int deleteProfileController();

	FacebookUser viewProfileController();
	
	ArrayList<FacebookUser> viewAllProfilesController();

	ArrayList<FacebookUser> searchProfileController();

	ArrayList<FacebookUser> sortProfileController();

	int createTimelineController();

}
