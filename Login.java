package loginInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
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
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String user=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		String query="select username,password from login_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			boolean status=false;
			while(rs.next())
			{
				String dbuser=rs.getString(1);
				String dbpassword=rs.getString(2);
				if(dbuser.equals(user) && dbpassword.equals(password)) {
					System.out.println("LOGIN SUCCESSFULL");
					status=true;
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

}
