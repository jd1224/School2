//***********************************************************
// Name: Joshua Coe
// Title: Assignment2.java
// Author:  Joshua Coe
// Description: An interactive menu for In-N-Out burger
// Time spent: 2 hours
// Date: 8/25/2017
//>Part 1 Answers:
//>>1
//>>>a. This statement evaluates to true.
//>>>b. This statement evaluates to false, because the both conditions are false.
//>>>c. This statement evaluates to true, because both conditions are true.
//>>>d. This statement evaluates to true, because the first condition in the or statement is true so the second one is not tested.
//>>2.:
//String fullName="";
//Scanner sc = new Scanner(System.in);
//System.out.print("Enter your full name: ");
//fullName = sc.nextLine();
//>>3.This code prints "Hy".  It is the first character(index 0) as a string, concatenated with the last character (length -1, or index 4) as a string.
//**************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

public class Assignment2 {
	
	public static void main(String[] args) {
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();//set fmt1 to currency later on
		Scanner sc = new Scanner(System.in);//instantiate Scanner as sc
		final double HAMBURGER_PRICE=2.75, CHEESEBURGER_PRICE=3.25, FRIES_PRICE=2.5, DRINKS_PRICE=1.5;//declare constants for prices
		int numHamburger=0, numCheeseburger=0, numFries=0, numDrinks=0, numItems=0;//initialize variables to 0 in case incorrect input is given
		double hamburgerTotal=0, cheeseburgerTotal=0, friesTotal=0, drinksTotal=0, totalCost=0;//same as above
		String highCost = "";//initialize string to hold highest cost item
		
		System.out.println("Welcome to the In-N-Out Menu:");//print menu options and prompt user for input
		System.out.println("________________________________");
		System.out.println("Hamburger: "+fmt1.format(HAMBURGER_PRICE));
		System.out.println("Cheeseburger: "+fmt1.format(CHEESEBURGER_PRICE));
		System.out.println("French Fries: "+fmt1.format(FRIES_PRICE));
		System.out.println("Shakes & Beverages: "+fmt1.format(DRINKS_PRICE));
		System.out.print("\nHow many hamburger(s) would you like to buy? ");
		if (sc.hasNextInt()) {//make sure the input is an integer to match the variable type
			
			numHamburger = sc.nextInt();//read the next int and assign to variable
			hamburgerTotal = numHamburger*HAMBURGER_PRICE;//calculate price of all items and assign to variable
			
		}else {//if not an integer
			
			System.out.println("You can only buy Hamburgers in integer quantities.");//print this statement
			sc.next();//consume the value and move to the next if/else statement
						
		}//if/else
		System.out.print("How many chesseburger(s) would you like to buy? ");
		if (sc.hasNextInt()) {//make sure the input is an integer to match the variable type
			
			numCheeseburger = sc.nextInt();//read the next int and assign to variable
			cheeseburgerTotal = numCheeseburger*CHEESEBURGER_PRICE;//calculate price of all items and assign to variable
			
		}else {//if not an integer
			
			System.out.println("You can only buy Cheeseburgers in integer quantities.");// print this statement
			sc.next();//consume the value and move to the next if/else statement
			
		}//if/else
		System.out.print("How many French fries would you like to buy? ");
		if (sc.hasNextInt()) {//make sure the input is an integer to match the variable type
			
			numFries = sc.nextInt();//read the next int and assign to variable
			friesTotal = numFries*FRIES_PRICE;//calculate price of all items and assign to variable
			
		}else {//if not an integer
			
			System.out.println("You can only buy French Fries in integer quantities.");// print this statement
			sc.next();//consume the value and move to the next if/else statement
						
		}//if/else
		System.out.print("How many drink(s) would you like to buy? ");
		if (sc.hasNextInt()) {//make sure the input is an integer to match the variable type
			
			numDrinks = sc.nextInt();//read the next int and assign to variable
			drinksTotal = numDrinks*DRINKS_PRICE;//calculate price of all items and assign to variable
			
		}else {//if not an integer
			
			System.out.println("You can only buy Drinks in integer quantities.");// print this statement
			sc.next();//consume the value and exit the if/else statement
			
		}//if/else
		
		sc.close();
		totalCost=(hamburgerTotal+cheeseburgerTotal+friesTotal+drinksTotal);//calculate the total cost of all items
		numItems=(numHamburger+numCheeseburger+numFries+numDrinks);//calculate the total number of items
		
		//begin nested if/else statement to determine highest cost item	and singular or plural output in the end						
		if (hamburgerTotal>cheeseburgerTotal&&hamburgerTotal>friesTotal&&hamburgerTotal>drinksTotal) {
			
			if (numHamburger>1) {//determine singular or plural item name in final statements
				highCost="hamburgers";
			}else {
				highCost="hamburger";
			}
		}else if(cheeseburgerTotal>friesTotal&&cheeseburgerTotal>drinksTotal) {//no need to check against already false conditions
			
			if (cheeseburgerTotal==hamburgerTotal) {//check if these are equal and implement a case if they are
				highCost = "hamburgers and cheeseburgers";
			}else {
				if (numCheeseburger>1) {//determine singular or plural item name in final statements
					highCost="cheeseburgers";
				}else {
					highCost="cheeseburger";
				}
			}
		}else if(friesTotal>drinksTotal) {
			
			if (friesTotal==cheeseburgerTotal) {//check if these are equal and implement a case if they are
				
				highCost = "fries and cheeseburgers";
			}else if (friesTotal==hamburgerTotal) {//check if these are equal and implement a case if they are
				
				highCost = "fries and hamburgers";
			}else
			
			highCost = "fries";
		}else {
			if (drinksTotal==friesTotal) {//check if these are equal and implement a case if they are
				
				highCost = "drinks and fries";
			}else if (drinksTotal==cheeseburgerTotal) {//check if these are equal and implement a case if they are
				
				highCost= "drinks and cheeseburgers";
			}else if (drinksTotal==hamburgerTotal) {//check if these are equal and implement a case if they are
				
				highCost = "drinks and hamburgers";
			}else {
			
				if (numDrinks>1) {//determine singular or plural item name in final statements
					highCost="drinks";
				}else {
					highCost="drink";
				}
			}
		}//end if/else for determining highest cost item ordered
		//print calculated output using fmt1 to format currency for appropriate output
		System.out.println("\nTotal cost for the hamburger(s): "+fmt1.format(hamburgerTotal));
		System.out.println("Total cost for the cheeseburger(s): "+fmt1.format(cheeseburgerTotal));
		System.out.println("Total cost for the fries: "+fmt1.format(friesTotal));
		System.out.println("Total cost for the drinks: "+fmt1.format(drinksTotal));
		System.out.println("The "+highCost+" had the highest total cost.");
		System.out.println("\nTotal cost for your order: "+fmt1.format(totalCost));
		System.out.println("Total number of item(s) ordered: "+numItems);
		
	}//end main

}//end class
