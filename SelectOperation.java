package CRUD_operations;

import java.sql.*;

import java.util.Scanner;

public class SelectOperation {
	public static void main(String[] args) {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String query="select * from product_info";
	
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		System.out.println("ID\tNAME\\ttPRICE");
		System.out.println("=============================");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			double price=rs.getDouble(3);
			System.out.println(id+"\t"+name+"\t\t"+price);
		}
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	}
}
