package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Patient;
import dao.Patientdao;


@WebServlet("/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet1() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String fullname = request.getParameter("fullname");
			Patient p1 = Patientdao.getpatientbyfullname(fullname);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body><center");
			out.println("<h1>VETERNAIAN MANAGAEMENT SYSTEM</h1>");
			
			out.println("<table width='100%'>");
			out.println("<form action = 'UpdateServlet2' method='post'>");
			out.println("<input type ='text'   name = 'fullname'  readonly  value = '"+fullname+"'>");
			out.println("<input type ='text'   name = 'address'  value = '"+p1.getAddress()+"'>");
			out.println("<input type ='text'   name = 'email'    value = '"+p1.getEmail()+"'>");
			out.println("<input type ='number' name = 'phone'   value = '"+p1.getPhone()+"'>");
			out.println("<input type ='text'   name = 'pet'        value = '"+p1.getPet()+"'>");
			out.println("<input type ='text'   name = 'breed'      value = '"+p1.getBreed()+"'>");
			out.println("<input type ='text'   name = 'pet_gender' value = '"+p1.getPet_gender()+"'>");
			out.println("<input type ='text'   name = 'disease'    value = '"+p1.getDisease()+"'>");
			
			out.println("<input type ='submit' value = 'update'>");
			out.println("</form>");
			out.println("<br><br>");
			out.println("<h2>All Pet Records</h2>");
			out.println("<table width ='100%' border='1'>");
			out.println("<tr><td>fullname</td><td>address</td><td>email</td><td>phone</td><td>pet</td><td>breed</td><td>pet_gender</td><td>disease</td></tr>");
			/*out.println("<tr><td>fullname</td><td>address</td><td>email</td><td>phone</td><td>pet</td><td>breed</td><td>pet_gender</td><td>disease</td><td>edit</td><td>delete</td></tr>");*/
			List<Patient> list = Patientdao.viewallpatient();
			
			
			for (Patient p: list)
			{		
			/*out.println("<tr><td><a href='Sortbypetservlet'>sort</a></td><td><a  href='Sortbyfullnameservlet'>sort</a></td><td><a>sort</a></td><td><a>sort</a></td><td><a>sort</a></td><td><a>sort</a></td></tr>");*/
			out.println("<tr><td>"+p.getFullname()+"</td><td>"+p.getAddress()+"</td><td>"+p.getEmail()+"</td><td>"+p.getPhone()+"</td><td>"+p.getPet()+"</td><td>"+p.getBreed()+"</td><td>"+p.getPet_gender()+"</td><td>"+p.getDisease()+"</td><td><a href ='UpdateServlet1?="+p.getPet()+"'>update</a></td><td><a href = 'DeleteServlet?="+p.getPet()+"'>delete</a></td></tr>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



}
