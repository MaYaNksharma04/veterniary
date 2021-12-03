package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Doctor;
import dao.Doctordao;

@WebServlet("/DoctorRegisterServlet")
public class DoctorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoctorRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			//getting beans from jsp page
			String username = request.getParameter("username");
			String password = request.getParameter("password");
						
			//set these beans
			
			Doctor d = new Doctor();
			d.setUsername(username);
			d.setPassword(password);
		
			//we need to call the business method which registers
			int result = Doctordao.registerdoctor(d);
			
			if(result > 0)
			{
				response.sendRedirect("AdminLogin.jsp");
			}
			else
			{
				response.sendRedirect("AdminRegister.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
