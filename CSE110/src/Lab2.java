//***********************************************************
// Name: Joshua Coe
// Title: Lab2.java
// Description: takes 3 inputs and prints out the average of three test scores
// Time spent: 15 minutes
// Date: 8/17/2017
//***********************************************************

import java.util.Scanner;

public class Lab2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);     				//instantiate scanner as sc to receive input
		int test1, test2, test3;								//declare new variables 
		double average;
		final int NUM_TESTS = 3;								//if more test variables are added change this variable to refelct the total number of test variables
																//prompt user for input then use the sc instance of scanner to receive the input
		System.out.print("Enter the score on the first test: ");
		test1 = sc.nextInt();
		
		System.out.print("Enter the score on the second test: ");
		test2 = sc.nextInt();
		
		System.out.print("Enter the score on the third test: ");
		test3 = sc.nextInt();
		
		sc.close();												//close the scanner
		
		average = (test1+test2+test3)/(double) NUM_TESTS;		//use the algorithm to determine the average
																//display results
		System.out.println("Your first test score: " + test1);
		System.out.println("Your second test score: " + test2);
		System.out.println("Your third test score: " + test3);
		System.out.println("Your average test score: " + average);

	}//end main

}//end class
