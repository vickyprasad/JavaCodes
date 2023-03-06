package CRUD_operations;

import java.sql.*;

public class jdbcDEMO1 {
	static Connection con=null;
	static Statement stmt=null;
	static String query="insert into product_info values(2,'MOBILE',10000.50)";
public static void main(String[] args)
	{
	try {
		//Load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish connection 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		
		//Create statement platform 
		stmt=con.createStatement();
																		
		//Execute SQL query
		int count=stmt.executeUpdate(query);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
		
}
