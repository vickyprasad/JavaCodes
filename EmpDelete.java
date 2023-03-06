package CRUD_operations.Employee;



import java.sql.*;
import java.util.Scanner;

public class EmpDelete {

			public static void main(String[] args) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Enter Employee Id");
				int id=sc1.nextInt();
								
				Connection con=null;
				Statement stmt=null;
				String query="delete from Employee where Id=("+id+")";
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
					stmt=con.createStatement();
					int count=stmt.executeUpdate(query);
					if(count!=0) {
											
					System.out.println(count+"Employee Deleted");
					}
					else{
						System.out.println("Employee not Found");
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


