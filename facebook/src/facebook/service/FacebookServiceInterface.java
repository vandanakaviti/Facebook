package facebook.service;

import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int signUpService(FacebookUser fu);
	
	FacebookUser signInService(FacebookUser fu);

	int editProfileService(FacebookUser fu, FacebookUser fu1);
	
	int deleteProfileService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);
	
	ArrayList<FacebookUser> viewAllProfilesService();

	ArrayList<FacebookUser> searchProfileService(FacebookUser fu);

	int createTimelineService(FacebookTimeline ft);

}
