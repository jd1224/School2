/*-------------------------------------------------------------------------
// AUTHOR: Joshua Coe
// FILENAME: Lab4.java
// SPECIFICATION: Read a series of integers (excluding zero) and compare them for largest, smallest, even, odd, and average value.
// FOR: CSE 110- Lab #4
// TIME SPENT: 30 minutes
//-----------------------------------------------------------*/
import java.util.Scanner;//import scanner to read user input

public class Lab4 {
	
	public static void main(String[] args) {
		//largest and smallest are initialized at the upper and lower limits of int so that the formulas in the body will set positive and negative integers to the variables.
		int smallest=(int)Math.pow(2, 31), largest=(int)Math.pow(-2, 31), numOfInts=0, evenTotal=0, oddTotal=0, runningTotal=0;//initialize variables. 
		double average=0.0;
		Scanner sc = new Scanner(System.in);//instantiate scanner as sc.
		boolean finished = false;//set sentinel boolean to false
		
		System.out.println("Enter a series of integers (zero to quit)");//prompt user for input
		while (!finished) {//checck condition of sentinel and  begin while loop
			
			if (sc.hasNextInt()) {//ensure the user entered an int
				
				int temp = sc.nextInt();//assign input to local variable temp
				
				if (temp==0) {//check for escape character
					
					finished = true;//if entered set sentinel to true and exit while loop
					
				}else {//if not escape character begin checking the input and set it accordingly
					
					if (temp<smallest) {//check for smallest number entered
						smallest = temp;
					}
					if (temp>largest) {//check for largest number entered
						largest = temp;
					}
					if (temp%2==0) {//check for even
						evenTotal += 1;
					}else {//else it is an odd number
						oddTotal +=1;
					}//if/else
				numOfInts += 1;//always add to the number of ints entered
				runningTotal += temp;//always add the amount to running total to determine the average later
					
				}//if/else
				
				
			}else {//if user entered a non integer
				
				System.out.println("Enter only integers (zero to quit)");//print warning message
				sc.next();//consume the input and remain in the loop 
				
			}//else
		}//while
		sc.close();//close the scanner
		if (numOfInts>0) {//if the user entered any integers 
			
			average = (double)runningTotal/numOfInts;//calculate the average only once after all numbers are entered
			//display results
			System.out.println("The smallest integer is "+smallest);
			System.out.println("The largest integer is "+largest);
			System.out.println("The number of integers entered is "+numOfInts);
			System.out.println("Total even numbers entered is "+evenTotal);
			System.out.println("Total odd numbers entered is "+oddTotal);
			System.out.println("The average value is "+average);
			
		}else {//if no integers are entered display the following message
			
			System.out.println("No data was entered.");
			
		}//if/else		
		
	}//main

}//class
