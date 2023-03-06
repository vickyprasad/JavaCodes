package CRUD_operations.Employee;
import java.sql.*;
import java.util.*;
public class EmpADD {

			public static void main(String[] args) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Enter Employee Id");
				int id=sc1.nextInt();
				System.out.println("Enter Employee Name");
				String name=sc1.next();
				System.out.println("Enter Employee Salary");
				double salary=sc1.nextDouble();
				System.out.println("Enter Employee Designation");
				String designation=sc1.next();
				
				Connection con=null;
				Statement stmt=null;
				String query="insert into Employee values("+id+",'"+name+"',"+salary+",'"+designation+"')";
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
					stmt=con.createStatement();
					int count=stmt.executeUpdate(query);
					System.out.println(count+"Employee Details Inserted");
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


