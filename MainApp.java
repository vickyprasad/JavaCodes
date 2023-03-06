package loginInfo;
import java.util.*;

public class MainApp {

	public static void main(String[] args) {
		LoginAssignment1 l1=new LoginAssignment1();
		
		Scanner sc=new Scanner(System.in);
		String name,user,pass;
		boolean status=true;
		while(status) {
			System.out.println("Enter your choice");
			System.out.println("\n 1.LOGIN\n 2.SIGNUP\n 3.EXIT");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Username ");
				user=sc.next();
				System.out.println("Enter Password");
				pass=sc.next();
				l1.login(user, pass);
								
				break;
				
			case 2:
				System.out.println("Enter Name ");
				name=sc.next();
				System.out.println("Enter User Name ");
				user=sc.next();
				System.out.println("Enter Password ");
				pass=sc.next();
				l1.signup(name, user, pass);
				break;
				
			case 3:
				status=false;
				break;
				
			}
			
		}
	}

}
