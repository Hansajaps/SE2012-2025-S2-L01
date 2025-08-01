import java.util.Scanner;

public class Welcome{
	public static void main(String [] args){
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter your First Name: ");
		String Fname = sc.nextLine();
		
		System.out.print("Enter your Last Name: ");
		String Lname = sc.nextLine();
		
		System.out.println("Welcome to the Second Year " + Fname + " " + Lname);
		

	
	}
}
		