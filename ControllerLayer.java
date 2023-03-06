import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/grocerylink")
public class ControllerLayer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String item=req.getParameter("Grocery");
		String quantity=req.getParameter("quantity");
		String delivery=req.getParameter("Delivery");
		
		int qty=Integer.parseInt(quantity);
		
		ModelLayer m1=new ModelLayer();
		
		double bill=m1.calculateBill(item, qty,delivery);
		req.setAttribute("bill", bill);
		RequestDispatcher rd=req.getRequestDispatcher("ViewLayer.jsp");
			
		PrintWriter pw=resp.getWriter();
		
			
		rd.include(req, resp);
		
			
			
		
	}
}
