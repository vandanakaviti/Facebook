package facebook.utility;

import java.util.Comparator;

import facebook.entity.FacebookUser;

public class sortByName implements Comparator<FacebookUser> {

	@Override
	public int compare(FacebookUser u1, FacebookUser u2) {
		return u1.getName().compareTo(u2.getName());
	}

}
