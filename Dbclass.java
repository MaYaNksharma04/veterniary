package database;
import java.sql.*;

public class Dbclass 
{
	public static Connection getconnectedtodatabase()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_database","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
