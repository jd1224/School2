/************************************************************
*Class EmployeeRun.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 1 September 2018
*Description: This is the main class of a program which takes
*input from a text file with information in the specified format
*then determines the annual salary of the employees and the average
*salary for that year and displays the output.
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class EmployeeRun{
	//create static variables to hold information that is needed in multiple methods of the class
	private static ArrayList<Employee> yr2014 = new ArrayList<>();
	private static ArrayList<Employee> yr2015 = new ArrayList<>();
	private static int total2014, total2015, count2014, count2015;
	
	//main method of the application
	public static void main(String[] args){
		
		//prompt the user for input, then take in the input with a new Scanner object
		System.out.print("Input the filename to scan for employee records: ");
		String fName = new Scanner(System.in).next();
		
		//enter a try catch block in case the file is not found
		try{
			//attempt to instantiate a scanner to read from fName
			Scanner sc = new Scanner(new File(fName));									
			int lineCount = 0;
			//enter the main loop for the application
			while(sc.hasNextLine()){													
				lineCount++;
				String[] temp = sc.nextLine().split(" ");
				//attempt to add an employee to the one of the year ArrayLists and print a warning if the format is incorrect
				if(temp[0].equals("2014")){												
					try{
						addItem(yr2014, temp);
					}catch (NumberFormatException ex){
						System.out.println("Line "+lineCount+" is not formatted correctly!");	
					}catch (IndexOutOfBoundsException ex1){
						System.out.println("Line "+lineCount+" is not formatted correctly!");
					}
				}else if (temp[0].equals("2015")){										
					try{
						addItem(yr2015, temp);
					}catch (NumberFormatException ex){
						System.out.println("Line "+lineCount+" is not formatted correctly!");
					}catch (IndexOutOfBoundsException ex1){
						System.out.println("Line "+lineCount+" is not formatted correctly!");
					}
				//print a warning if the input year is not 2014 or 2015
				}else{
					System.out.println("Line "+lineCount+" is not formatted correctly!");
				}
			}
		//print a warning if the file specified does not exist, then exit the program
		}catch (FileNotFoundException ex){
			System.out.println("File was not found!");
			System.exit(0);
		}
		printResults();
 	}//end main
	
	/**
	 *Determines the type of Employee instantiates the Employee Object, and 
	 *adds an Employee object to the supplied ArrayList<Employee>
	 *@param toAdd ArrayList<Employee> to add the employee object to
	 *@param temp String[] information to fill the constructor for an Employee object
	 *Throws NumberFormatException if temp[3] or temp[4] are not integers
	 */
	private static void addItem(ArrayList<Employee> toAdd, String[] temp) throws NumberFormatException, IndexOutOfBoundsException{
		//fill variables common to all Employees
		String type = temp[1];
		String name = temp[2];
		int weekly = Integer.parseInt(temp[3]);
		//determine the type of Employee to create, create it, then add it to the supplied ArrayList<Employee>
		if (type.equals("Employee")){
			Employee temporary = new Employee(name, weekly);
			toAdd.add(temporary);
		}else if (type.equals("Salesman")){
			int annualSales = Integer.parseInt(temp[4]);
			Salesman temporary = new Salesman(name, weekly, annualSales);
			toAdd.add(temporary);
		}else if (type.equals("Executive")){
			int stockP = Integer.parseInt(temp[4]);
			Executive temporary = new Executive(name, weekly, stockP);
			toAdd.add(temporary);
		}else{
			throw new NumberFormatException(""); 
		}
	}//end addItem
	
	/**
	 *print the results in a format that is easily readable
	 */
	private static void printResults(){
		System.out.println("***********************************2014***********************************");
		//print each item in the year 2014 while adding their salaries together and incrementing
		//the number of salaries to divide by for the average
		for(Employee x:yr2014){
			int annualSalary = x.annualSalary();
			total2014+=annualSalary;
			count2014++;
			System.out.println(x+" Annual: "+annualSalary);
		}
		//enter a try/catch in case there are no salaries in that year to catch a division by 0
		try{
			System.out.println("Average Salary: "+(total2014/count2014));
		}catch(ArithmeticException ex2){
			System.out.println("There were no salaries to average this year.");
		}
		
		System.out.println("***********************************2015***********************************");
		//print each item in the year 2015 while adding their salaries together and incrementing
		//the number of salaries to divide by for the average
		for(Employee x:yr2015){
			int annualSalary = x.annualSalary();
			total2015+=annualSalary;
			count2015++;
			System.out.println(x+" Annual: "+annualSalary);
		}
		//enter a try/catch in case there are no salaries in that year to catch a division by 0
		try{
			System.out.println("Average Salary: "+(total2015/count2015));
		}catch(ArithmeticException ex3){
			System.out.println("There were no salaries to average this year.");
		}
	}//end printResults
}//end Class