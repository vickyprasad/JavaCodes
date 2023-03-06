package CRUD_operations.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpUpdate {
	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id=sc1.nextInt();
		System.out.println("Enter Employee Salary");
		double salary=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		String query="update Employee set Salary="+salary+" where Id=("+id+")";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			if(count!=id) {
									
			System.out.println(count+" Employee updated");
			}
			else{
				System.out.println("Employee Not Found");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
