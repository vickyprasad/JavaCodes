package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Validation;

@WebServlet("/loginlink")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		
		Validation v1=new Validation();
		boolean status=v1.validate(user,pass);
		
		if(status) {
			resp.sendRedirect("welcome.jsp");
		}
		else {
			resp.sendRedirect("index.html");
		}
	}
}
