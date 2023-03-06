
package CRUD_operations;
import java.sql.*;
import java.util.Scanner;

public class DeleteProduct {

			public static void main(String[] args) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Enter Product Id");
				int id=sc1.nextInt();
								
				Connection con=null;
				Statement stmt=null;
				String query="delete from product_info where product_Id=("+id+")";
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
					stmt=con.createStatement();
					int count=stmt.executeUpdate(query);
					if(count!=0) {
											
					System.out.println(count+"Product Deleted");
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


