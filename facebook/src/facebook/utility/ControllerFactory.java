package facebook.utility;

import facebook.controller.FacebookController;
import facebook.controller.FacebookControllerInterface;

public class ControllerFactory {

	public static FacebookControllerInterface createObject() {
		return new FacebookController();
	}

}
