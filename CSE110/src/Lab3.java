/*-------------------------------------------------------------------------
// AUTHOR: Joshua Coe
// FILENAME: Lab3.java
// SPECIFICATION: String comparison for content and length
// FOR: CSE 110- Lab #3
// TIME SPENT: 20 minutes
//-----------------------------------------------------------*/
import java.util.Scanner;//import the scanner class

public class Lab3 {
	
	public static void main(String[] args) {
		
		String input1, input2;//create variables for the strings to be stored in
		Scanner sc = new Scanner(System.in);//instantiate scanner as sc
		
		System.out.print("Enter the first string: ");//prompt the user for input
		input1 = sc.nextLine();//read the next line to include spaces, store as input1
		
		System.out.print("Enter the second string: ");//prompt the user for input
		input2 = sc.nextLine();//read the next line to include spaces, store as input2
		
		sc.close();//close the scanner
		
		if (input1.equals(input2)) {//compare the contents of the strings
			
			System.out.println("The strings are the same.");//print results if they are the same
		
		}else {//if they are not the same print the below line
			
			System.out.println("The strings are not the same.");
			
		}//end if/else
		
		if (input1.length()>input2.length()) {//is input 1 longer than input2
			
			System.out.println("\""+input1+"\" is longer than \""+input2+"\"");
			
		}else if (input1.length()<input2.length()) {//if not is input 1 shorter than input 2
			
			System.out.println("\""+input2+"\" is longer than \""+input1+"\"");
		
		}else {//if not they must be equal in length
			
			System.out.println("The strings have the same length.");
			
		}//end if/else
		
	}//end main

}//end class
