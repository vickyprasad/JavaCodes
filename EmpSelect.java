package CRUD_operations.Employee;

import java.sql.*;

public class EmpSelect {
	public static void main(String[] args)
	{
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String query="select * from Employee";
	
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		System.out.println("ID\tNAME\t\tSALARY\t\t\tDESIGNATION");
		System.out.println("===============================================================================");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			double salary=rs.getDouble(3);
			String designation=rs.getString(4);
			System.out.println(id+"\t"+name+"\t\t"+salary+"\t\t"+designation);
		}
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	}

}
