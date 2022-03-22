package facebook.dao;

import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int signUpDAO(FacebookUser fu);
	
	FacebookUser signInDAO(FacebookUser fu);

	int editProfileDAO(FacebookUser fu, FacebookUser fu1);
	
	int deleteProfileDAO(FacebookUser fu);

	FacebookUser viewProfileDAO(FacebookUser fu);
	
	ArrayList<FacebookUser> viewAllProfilesDAO();

	ArrayList<FacebookUser> searchProfileDAO(FacebookUser fu);

	int createTimelineDAO(FacebookTimeline ft);

}
