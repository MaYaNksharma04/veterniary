package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Patient;
import dao.Patientdao;


@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			
		  //1. get all the beans from the jsp and html page
			
		String fullname= request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String pet = request.getParameter("pet");
		String breed = request.getParameter("breed");
		String pet_gender = request.getParameter("pet_gender");
		String disease = request.getParameter("disease");
		
		//2. get this bean inside the bean class (admin class), setUsername() and setPassword()	
		Patient p= new Patient();
		//u.setId(id);
		p.setFullname(fullname);
		p.setAddress(address);
		p.setEmail(email);
		p.setPhone(phone);
		p.setPet(pet);
		p.setBreed(breed);
		p.setPet_gender(pet_gender);
		p.setDisease(disease);
		//3. call the dao method which register this particulars admin 
		 int result = Patientdao.updatestudentsdetail(p);
		 
		 //4. depending om the result we have to decide at which page it should show the result, success page or error page
		 if(result>0)
		 {
			response.sendRedirect("ViewallServlet"); 
		 }
		 else
		 {
			response.sendRedirect("ViewallServlet"); 
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
