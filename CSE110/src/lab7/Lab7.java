package lab7;
/*-------------------------------------------------------------------------
//AUTHOR:Joshua Coe
//FILENAME: Lab7.java
//SPECIFICATION: 
//FOR: CSE 110- Lab #7
//TIME SPENT: 30 Minutes
//-----------------------------------------------------------*/ 

import java.util.Scanner;

public class Lab7 {
	
	
	public static void main(String[] args) {
		
		final int SIZE=5;//create final integer for size of array
		//Scanner sc = new Scanner(System.in);
		int count = 0;
		
		int[] array = new int[SIZE];//initialize array of integers with size SIZE
		
		for (int i=0;i<SIZE;i++) {//begin filling array
			System.out.print("Please enter an integer: ");//prompt
			array[i]=getAnInt();//get an integer with the helper method
			count++;//increase the count
		}//end fill array
		
		System.out.println("Processing each array element...");//prompt to seperate input from output
		
		for (int i = 0; i<count; i++) {//loop through with companion variable in case array is not full
			System.out.println(array[i]+1);//print out array elements on separate lines
		}
		
	}
	
	//helper method to ensure input
public static int getAnInt() {
		
		Scanner sc = new Scanner(System.in);
		int a=0;
		boolean choosing = true;
		//System.out.println("...");
		while (choosing) {
			
			if(sc.hasNextInt()) {
				a=sc.nextInt();
				choosing = false;
			}else {
				System.out.print("Please enter an integer: ");
				sc.next();
			}
		}return a;
	}

}
