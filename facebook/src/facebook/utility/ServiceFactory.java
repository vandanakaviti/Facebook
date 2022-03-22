package facebook.utility;

import facebook.service.FacebookService;
import facebook.service.FacebookServiceInterface;

public class ServiceFactory {

	public static FacebookServiceInterface createObject() {
		return new FacebookService();
	}

}
