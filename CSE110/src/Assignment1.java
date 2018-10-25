//***********************************************************
// Name: Joshua Coe
// Title: Assignment1.java
// Author:  Joshua Coe
// Description: A calculator to determine the tip given a total bill and percent to tip
// Time spent: 45 minutes
// Date: 8/17/2017
//>Part 1 Answers:
//a. The JVM could not find the main class to run because the class name no longer matches the name on the class file.
//b. Several errors returned based including not being able to resolve Celsius to a variable.  Without the quotes, the JVM thinks that Celsius is an undefined variable.
//   in addition, leaving this string opened created several syntax errors related to the proper closing of statements with ; and ) because it is looking for the ends of
//   statements where they should not be.
//c. The JVM returned an error in closing the statement and told me to insert a ; to close the statement.
//d. The JVM recognized that the class was not closed because it did not contain a closing bracket at the end.  The closing bracket that is left closes the main method.
//e. The variable fahrenheitTemp cannot be resolved because it was never declared.(I changed it in the declaration)
//>Part 2 Answers:
//1
//>>a The value of mystery is 5
//>>b The value of mystery is 3
//>>c The value of mystery is 4
//2
//>>a 0 
//>>b 3.3333333333333335
//>>c 2
//>>d 4.3
//>>e 0.24806201550387597
//>>f 1
//>>g 1
//**************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

class Assignment1 {
	
	public static void main(String[] args) {
		
		NumberFormat fmt1= NumberFormat.getCurrencyInstance();//create variable to print as currency
		NumberFormat fmt2= NumberFormat.getPercentInstance();//create variable to print as percent
		double billAmount, tipDecimal, tipAmount, totalBill;//create the necessary variables in type double
		int tipPercent;// create tip percent as type int(for input)
		Scanner sc = new Scanner(System.in);//create a new scanner variable for input
		
		System.out.print("Enter the bill amount: ");//prompt user for input, enter input on same line
		billAmount = sc.nextDouble();//scan for the next double input

		System.out.print("What percent would you like to tip: ");//prompt user for input
		tipPercent = sc.nextInt();//scan for the next int input
		
		tipDecimal = (double)tipPercent/100;//assign the decimal form of the tip to tipDecimal(cast as double otherwise result will be 0)
		tipAmount = billAmount*tipDecimal;//assign the product of billAmount and tipDecimal to tip amount
		totalBill = tipAmount + billAmount;//calculate the total and assign to totalBill
		sc.close();//close the scanner
		
		System.out.println("Bill amount: "+fmt1.format(billAmount));
		System.out.println("Tip percent: "+fmt2.format(tipDecimal));
		System.out.println("Tip Amount: "+ fmt1.format(tipAmount));
		System.out.println("Total amount with tip: "+fmt1.format(totalBill));//print the relevant information for the user in the correct format.
	
	}//end main method
	
}//end class
