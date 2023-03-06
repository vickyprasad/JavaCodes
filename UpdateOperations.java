package CRUD_operations;

import java.sql.*;
import java.util.Scanner;


public class UpdateOperations {

			public static void main(String[] args) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Enter Product Id");
				int id=sc1.nextInt();
				System.out.println("Enter Product price");
				double price=sc1.nextDouble();
				
				Connection con=null;
				Statement stmt=null;
				String query="update product_info set Product_price="+price+" where product_Id=("+id+")";
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
					stmt=con.createStatement();
					int count=stmt.executeUpdate(query);
					if(count!=id) {
											
					System.out.println(count+"Product updated");
					}
					else{
						System.out.println("Product Not Found");
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


