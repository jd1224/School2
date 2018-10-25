//***********************************************************
// Name: Joshua Coe
// Title: Assignment3.java
// Author:  Joshua Coe
// Description: Computes the greatest common divisor (GCD) of two numbers
// Time spent: 45 minutes
// Date: 9/4/2017
//>Part 1 Answers:
//>>1:
//>>>a. This loop prints: 10 9 8 7 6 5 4 3 2
//>>>b. This loop prints: 5 15
//>>2:
//for (int i = str.length; i>0; i--)
//  System.out.println(str.charAt(i-1));
//************************************************************

import java.util.Scanner;

public class Assignment3 {
	
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);//instantiate scanner to read user input
		int num1=0, num2=0;//initialize variables
		boolean choosing1 = true, choosing2 = true;
		
		while (choosing1) {//use while loops to ensure user inputs integer
			
			System.out.print("Enter the first positive integer: ");//prompt for input
			if (sc.hasNextInt()) {//check if input was an int and assign to variable
				num1 = sc.nextInt();
				
				if (num1>0)//check to make sure it is positive
					choosing1 = false;//change the sentinel so that the loop ends
				else//if not positive, print this error message and remain in the choosing 1 loop
					System.out.println("Please enter a positive integer.");
				
			}else {//if not an int print the following statement
				System.out.println("Please enter an integer.");
				sc.next();//consume whatever input the user entered to restart the loop
			}//end else
		
		}//end choosing 1
		while (choosing2) {//use while loops to ensure user inputs integer
			
			System.out.print("Enter the second positive integer: ");//prompt for input
			if (sc.hasNextInt()) {//check if input was an int and assign to variable
				num2 = sc.nextInt();
				
				if (num2>0)//check to make sure it is positive
					choosing2 = false;//change the sentinel so that the loop ends
				else//if not positive, print this error message and remain in the choosing 2 loop
					System.out.println("Please enter a positive integer.");
				
			}else {//if not an int print the following statement
				System.out.println("Please enter an integer.");
				sc.next();//consume whatever input the user entered to restart the loop
			}//end else
		
		}//end choosing 2
		sc.close();//close the scanner as no more input is needed.
		//System.out.println(num1+" "+num2);//uncomment to test choosing section.	
		
		int gcd1 = num1, gcd2 = num2;//declare variables to use in the loop so that original numbers are saved
		while (gcd1!=gcd2) {//implement the algorithm until both numbers are equal
			
			if (gcd1>gcd2) {//determine the larger number and set it to the value of itself minus the smaller number
				gcd1 = gcd1-gcd2;
			}else {
				gcd2 = gcd2 - gcd1;
			}//if/else
		}//while
		System.out.println("the GCD of "+num1+" and "+num2+" is: "+ gcd1);//display results
	}//end main
}//end class
