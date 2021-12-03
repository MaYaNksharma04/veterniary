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


@WebServlet("/ViewallServlet")
public class ViewallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewallServlet() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			try
			{
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<html><body><center");
				out.println("<h1>VETERNAIAN MANAGAEMENT SYSTEM</h1>");
				out.println("<form action ='Multiplevalueservlet' method = 'get'>");
				out.println("<input type ='text' name='value'>");
				out.println("<input type ='submit' value='search'>");
				out.println("</form>");
				
				out.println("<table width='100%'>");
				out.println("<form action = 'Insertservlet' method='post'>");
				out.println("<input type ='text' name = 'fullname' placeholder = 'fullname'>");
				out.println("<input type ='text' name = 'address' placeholder = 'address'>");
				out.println("<input type ='text' name = 'email' placeholder = 'email'>");
				out.println("<input type ='number' name = 'phone' placeholder = 'phone'>");
				out.println("<input type ='text' name = 'pet' placeholder = 'pet'>");
				out.println("<input type ='text' name = 'breed' placeholder = 'breed'>");
				out.println("<input type ='text' name = 'pet_gender' placeholder = 'pet_gender'>");
				out.println("<input type ='text' name = 'disease' placeholder = 'disease'>");
				
				out.println("<input type ='submit' value = 'insert new pet entry'>");
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
				out.println("<tr><td>"+p.getFullname()+"</td><td>"+p.getAddress()+"</td><td>"+p.getEmail()+"</td><td>"+p.getPhone()+"</td><td>"+p.getPet()+"</td><td>"+p.getBreed()+"</td><td>"+p.getPet_gender()+"</td><td>"+p.getDisease()+"</td><td><a href ='UpdateServlet1?fullname="+p.getFullname()+"'>update</a></td><td><a href = 'DeleteServlet?fullname="+p.getFullname()+"'>delete</a></td></tr>");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
