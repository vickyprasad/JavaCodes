import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelLayer {
	static Connection con=null;
	static{
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public double calculateBill(String name,int qty,String delivery) {
		Statement stmt=null;
		ResultSet rs=null;
		double bill = 0;
	
		String dname;
		double dprice;
		String query="select Name,Price from grocery_info";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				 dname=rs.getString(1);
				 dprice=rs.getDouble(2);
				if(name.equalsIgnoreCase(dname)) {
					if(delivery.equalsIgnoreCase("Regular")) {
						bill=(qty*dprice)+30;
					}
					else if(delivery.equalsIgnoreCase("Quick")) {
						bill=(qty*dprice)+60;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bill;
	}
	

}
