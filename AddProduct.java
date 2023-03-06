package CRUD_operations;
import java.sql.*;
import java.util.Scanner;

public class AddProduct {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();
		System.out.println("Enter Product Name");
		String name=sc1.next();
		System.out.println("Enter Product Price");
		double price=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		String query="insert into product_info values("+id+",'"+name+"',"+price+")";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+"Product Inserted");
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
