package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Patient;
import database.Dbclass;

public class Patientdao 
{

	public static int insertpatient(Patient p) 
	{
		int result = 0;
		
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("insert into patient (fullname, address, email, phone, pet, breed, pet_gender, disease) value (?,?,?,?,?,?,?,?)");
			
			
			ps.setString(1,p.getFullname());
			ps.setString(2,p.getAddress());
			ps.setString(3, p.getEmail());
			ps.setLong(4, p.getPhone());
			ps.setString(5, p.getPet());
			ps.setString(6, p.getBreed());
			ps.setString(7, p.getPet_gender());
			ps.setString(8, p.getDisease());
			
			result = ps.executeUpdate();
			
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static List<Patient> viewallpatient() 
	{
		List<Patient> list = new ArrayList<Patient>();
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("select * from patient");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Patient pa = new Patient();
				pa.setFullname(rs.getString(1));
				pa.setAddress(rs.getString(2));
				pa.setEmail(rs.getString(3));
				pa.setPhone(rs.getLong(4));
				pa.setPet(rs.getString(5));
				pa.setBreed(rs.getString(6));
				pa.setPet_gender(rs.getString(7));
				pa.setDisease(rs.getString(8));
				
				
				list.add(pa);
				
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public static int deletepatientbyfullname(String fullname) 
	{
		int result = 0;
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("delete from patient where fullname=?");
			
			
			ps.setString(1, fullname);
			
		   result = ps.executeUpdate();
			
		   conn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}

	public static Patient getpatientbyfullname(String fullname) 
	{
		Patient pa = new Patient();
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("select * from patient where fullname=?");
			
			
			ps.setString(1, fullname);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				pa.setFullname(rs.getString(1));
				pa.setAddress(rs.getString(2));
				pa.setEmail(rs.getString(3));
				pa.setPhone(rs.getLong(4));
				pa.setPet(rs.getString(5));
				pa.setBreed(rs.getString(6));
				pa.setPet_gender(rs.getString(7));
				pa.setDisease(rs.getString(8));
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pa;
		
	}

	public static int updatestudentsdetail(Patient p) 
	{
		int result=0;
		
		try
		{
			Connection conn = Dbclass.getconnectedtodatabase();
			
			PreparedStatement ps = conn.prepareStatement("update patient set fullname = ?, address = ?, email = ?, phone = ?, pet = ?, breed = ?, pet_gender = ?, disease = ? where fullname =?");
			
			ps.setString(1, p.getFullname());
			ps.setString(2, p.getAddress());
			ps.setString(3, p.getEmail());
			ps.setLong(4,   p.getPhone());
			ps.setString(5, p.getPet());
			ps.setString(6, p.getBreed());
			ps.setString(7, p.getPet_gender());
			ps.setString(8, p.getDisease());
			ps.setString(9,p.getFullname());
			
			result = ps.executeUpdate();
			conn.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}

























