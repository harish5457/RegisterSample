

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
		String id=request.getParameter("number");  
		String name=request.getParameter("username");  
		String email=request.getParameter("Email");  
		String country=request.getParameter("Country");  
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","Hari19@%kumar");  
			  
			PreparedStatement p=con.prepareStatement("insert into Employees values(?,?,?,?)");  
			  
			p.setString(1,id);  
			p.setString(2,name);  
			p.setString(3,email);  
			p.setString(4,country);  
			          
			int i=p.executeUpdate();  
			if(i>0)  
			out.print("successfully registered");  
			      
			          
			}catch (Exception e) {
				out.println("Sorry,Try again later");
				}  
			          
			out.close();  
		}  

}
