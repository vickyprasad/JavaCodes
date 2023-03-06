package loginInfo;

import java.sql.*;
import java.util.*;

public class LoginAssignment1 {
	static Connection con=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void login(String username,String password)
	{
		boolean exit=true;
		Scanner sc=new Scanner(System.in);
		String query="select username,password from login_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			boolean status=false;
			while(rs.next())
			{
				String dbuser=rs.getString(1);
				String dbpassword=rs.getString(2);
				if(dbuser.equals(username) && dbpassword.equals(password)) {
					System.out.println("LOGIN SUCCESSFULL");
					status=true;
					while(exit) {
						System.out.println("\nSelect Option:\n 1.Add Product\n 2.Display Product\n 3.Exit ");
						int choice=sc.nextInt();
							switch(choice) {
								case 1:
													
									System.out.println("Enter Product Name");
									String name=sc.next();
									System.out.println("Enter Product Price");
									double price=sc.nextDouble();
									LoginAssignment1.addProduct(name,price);
							
									break;
							
								case 2:
							
									LoginAssignment1.displayProduct();
									break;
								case 3:
									exit=false;
							}
													
						}
						
					}
				}
			
			
				if(status==false)
				{
					System.out.println("Invalid Details");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addProduct(String name, double price) {
		String query="insert into product_info (product_name,product_price) values('"+name+"',"+price+")";
		try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+" Query Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void displayProduct()
	{
		String query="select * from product_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("ID\tNAME\t\tPRICE");
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
	
	public void signup(String name,String username,String password) {
		String query="insert into login_info (name,username,password) values('"+name+"','"+username+"','"+password+"')";
		try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+"Query Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	

