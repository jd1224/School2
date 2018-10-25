package assignment5;

/*-------------------------------------------------------------------------
//AUTHOR: Joshua Coe
//FILENAME: Assignment5.java
//SPECIFICATION: A question and answer program using the Geek class
//FOR: CSE 110- Assignment 5
//TIME SPENT: 5 hours
//----------------------------------------------------------------------*/ 

import java.util.*;

public class Assignment5 {
	
	
	
	public static void main (String[] args) {

		
		Scanner console = new Scanner (System.in);
		String choice;
		char command;


		// print the menu
		printMenu();
		
		// create new Geek object
		Geek myGeek = new Geek("Geek", 0);

		do
		{
			// ask a user to choose a command
			System.out.println("\nPlease enter a command or type ?");
			choice = console.next().toLowerCase();
			command = choice.charAt(0);

			switch (command)
			{
				case 'a'://call getName function on obj myGeek
					System.out.println(myGeek.getName());
					
					break;
				case 'b': //call getNumQuestions function on obj myGeek
					System.out.println("Number of questions: " + 
					myGeek.getNumberOfQuestions());
					break;
				case 'c': //call isEven 
					int ac=0,bc=0;
					System.out.print("Enter a number: ");
					ac = getAnInt();//use helper to get the first int
					System.out.print("Enter another number: ");
					bc = getAnInt();//use helper to get the second int	
					boolean result=myGeek.isEven(ac, bc);//pass input as arguments to isEven method
					if (result) {//conditional return statements
						System.out.println("The sum of the numbers is even.");
					}else {
						System.out.println("The sum of the numbers is not even.");
					}
					break;
				case 'd': //call the sum function on obj myGeek
					int ad=0,bd=0;
					System.out.print("Enter a number: ");
					ad = getAnInt();//use helper to get first int
					System.out.print("Enter another number: ");
					bd = getAnInt();//use helper to get second int
					if (ad>=bd) {//conditional statement that orders the input from small to large
						System.out.println("The sum between "+bd+" and "+ad+" is "+myGeek.sum(ad, bd));
					}else {
						System.out.println("The sum between "+ad+" and "+bd+" is "+myGeek.sum(ad, bd));
					}
					break;
				case 'e': //
					boolean leapYear;
					System.out.print("Enter a year: ");
					int ae = getAnInt();
					leapYear=myGeek.isLeapYear(ae);
					if (leapYear) {
						System.out.println("The year "+ae+" is a leap year.");
					}else {
						System.out.println("The year "+ae+" is not a leap year.");
					}
					break;
				case '?':
					printMenu();
					break;
				case 'q':
					break;

				default:
					System.out.println("Invalid input");

			}

		} while (command != 'q');

	}  //end of the main method


	public static void printMenu()
	{
		System.out.print("\nCommand Options\n"
			+ "-----------------------------------\n"
			+ "a: get name\n"
			+ "b: number of questions asked\n"
			+ "c: sum is even\n"
			+ "d: sum between two integers\n"
			+ "e: leap year\n"
			+ "?: display the menu again\n"
			+ "q: quit this program\n\n");

	} // end of the printMenu method
	
	//re-usable helper method to ensure an integer is entered
	public static int getAnInt() {
			Scanner sc = new Scanner(System.in);
			int a=0;
			boolean choosing = true;
			//System.out.println("...");
			while (choosing) {//while loop to ensure only an int is returned by this method
				
				if(sc.hasNextInt()) {
					a=sc.nextInt();
					choosing = false;//once an int is entered exit the loop and return it as a
				}else {//if not an int return this message and consume the input
					System.out.print("Please enter an integer: ");
					sc.next();
				}
			}return a;
		}//end getAnInt

}  // end Assignment5 class