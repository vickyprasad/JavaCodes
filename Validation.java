package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Validation {
	static	Connection con=null;
	
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validate(String user,String pass) {
		
		Statement stmt=null;
		ResultSet rs=null;
		boolean status =false;
		String query="select username,password from login_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				String username=rs.getString(1);
				String password=rs.getString(2);
				
				if(user.equals(username) && pass.equals(password)) {
					status=true;
				}else {
				status=false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return status;
	}
}
