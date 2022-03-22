package facebook.dao;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;
import facebook.exception.ReservedWordException;

public class FacebookDAO implements FacebookDAOInterface {
	Connection con = null;
	public FacebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@Vandana-windows:1521:XE", "system", "orcl");
			}
		
		catch (Exception e){
			e.printStackTrace();
			}
	}

	@Override
	public int signUpDAO (FacebookUser fu) {
		int i = 0;
		try {
			
			if (fu.getName().contentEquals("Facebook")) { throw new ReservedWordException(); }
			
			PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?, ?, ?, ?, ?)");
//			CallableStatement ps = con.prepareCall("call {pro1(?, ?, ?, ?, ?)}");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			ps.setString(3, fu.getEmail());
			ps.setString(4, fu.getDateOfBirth());
			ps.setString(5, fu.getGender());
			
			i = ps.executeUpdate();
		}
		
		catch(ReservedWordException e){System.out.println(e);}
		catch(Exception e) {e.printStackTrace();}
		return i;
	}
	
	@Override
	public FacebookUser signInDAO(FacebookUser fu) {
		FacebookUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email = ?");
			ps.setString(1, fu.getEmail());
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String d = res.getString(4);
				String g = res.getString(5);
				
				user = new FacebookUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setDateOfBirth(d);
				user.setGender(g);
			}
			
			if (user.getPassword().contentEquals(fu.getPassword())) {
				return user;
			}
			
			else {
				System.out.println("Incorrect Password!");
				return null;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int editProfileDAO(FacebookUser fu, FacebookUser fu1) {
		int i = 0;
		
		try {
			
			if (fu1.getName() == "Facebook") { throw new ReservedWordException(); }
			
			PreparedStatement ps = con.prepareStatement("update facebookuser set name = ?, password = ?, dateofbirth = ?, gender = ? where email = ?");
			ps.setString(1, fu1.getName());
			ps.setString(2, fu1.getPassword());
			ps.setString(3, fu1.getDateOfBirth());
			ps.setString(4, fu1.getGender());
			ps.setString(5, fu.getEmail());
			
			i = ps.executeUpdate();
		}
		
		catch(ReservedWordException e){System.out.println(e);}
		catch(Exception e) { e.printStackTrace(); }
		
		return i;
	}
	
	@Override
	public int deleteProfileDAO(FacebookUser fu) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from facebookuser where email = ?");
			ps.setString(1, fu.getEmail());
			i = ps.executeUpdate();
		}
		catch(Exception e){e.printStackTrace();}
		return i;
	}
	
	@Override
	public FacebookUser viewProfileDAO(FacebookUser fu) {	
		FacebookUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email = ?");
			ps.setString(1, fu.getEmail());
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String d = res.getString(4);
				String g = res.getString(5);
				
				user = new FacebookUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setDateOfBirth(d);
				user.setGender(g);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public ArrayList<FacebookUser> viewAllProfilesDAO() {
		ArrayList<FacebookUser> lis = new ArrayList<FacebookUser>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from facebookuser");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String d = res.getString(4);
				String g = res.getString(5);
				
				FacebookUser user = new FacebookUser();
				user = new FacebookUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setDateOfBirth(d);
				user.setGender(g);
				
				lis.add(user);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lis;
	}

	@Override
	public ArrayList<FacebookUser> searchProfileDAO(FacebookUser fu) {
		ArrayList<FacebookUser> lis = new ArrayList<FacebookUser>();
		FacebookUser user = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where name = ?");
			ps.setString(1, fu.getName());
			
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String d = res.getString(4);
				String g = res.getString(5);
				
				user = new FacebookUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setDateOfBirth(d);
				user.setGender(g);
				
				lis.add(user);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lis;
	}

	@Override
	public int createTimelineDAO(FacebookTimeline ft) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into facebooktimeline values(?, ?, ?, ?, ?)");
			ps.setString(1, ft.getMessageid());
			ps.setString(2, ft.getSender());
			ps.setString(3, ft.getReceiver());
			ps.setString(4, ft.getMessage());
			ps.setString(5, ft.getDate());
			
			i = ps.executeUpdate();
		}

		catch(Exception e) {e.printStackTrace();}
		return i;
	}

}
