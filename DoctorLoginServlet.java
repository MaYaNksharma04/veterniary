package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctordao;

@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			//getting beans from jsp page
			String username = request.getParameter("username");
			String password = request.getParameter("password");
						
			int result = Doctordao.logindoctor(username,password);
			
			if(result > 0)
			{
				response.sendRedirect("ViewallServlet");
			}
			else
			{
				response.sendRedirect("AdminLogin.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
