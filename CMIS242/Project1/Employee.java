/************************************************************
*Class Employee.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 1 September 2018
*Description: Employee base class with common variables
*/
public class Employee{

	private String name;
	private int monthlySalary;
	
	public Employee(String name, int monthlySalary){
		
		this.name = name;
		this.monthlySalary = monthlySalary;
		
	}
	/**
	 *Calculate the annual salary for this employee
	 */
	public int annualSalary(){
		return monthlySalary * 12;
	}
	/**
	 *base toString method displays name and monthly salary with tags inline
	 */
	public String toString(){
		return this.getClass().toString().substring(6)+" Name: "+this.name+
				" Monthly: "+this.monthlySalary;
	}
}