package facebook.dao;

public class DAOFactory {

	public static FacebookDAOInterface createObject() {
		return new FacebookDAO();
	}

}
