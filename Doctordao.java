																						package dao;
import java.sql.*;
import beans.Doctor;
import database.Dbclass;

public class Doctordao {

	public static int registerdoctor(Doctor d) 
	{
		int result = 0;
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("insert into doctor (username, password) values (?,?)");
			
			
			ps.setString(1,d.getUsername());
			ps.setString(2,d.getPassword());
			
			result = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static int logindoctor(String username, String password) 
	{
		int result = 0;
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("select * from doctor where username = ? and password = ?");
			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				result = 1;
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	
}
