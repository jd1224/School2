/************************************************************
*Class Salesman.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 1 September 2018
*Description: subclass of Employee which adds methods for
*specific Salesman methods and variables.
*/
public class Salesman extends Employee{

	private int annualSales;
	/**
	 *constructor which adds the annualSales variable to the super class constructor
	 */
	public Salesman(String name, int monthlySalary, int annualSales){
		super(name, monthlySalary);
		this.annualSales = annualSales;
	}
	/**
	 *overridden annualSalary method from super class
	 *to calculate annual salary for a salesman based
	 *on 2% commission up to a cap of 20000
	 */
	public int annualSalary(){
		
		int partA = super.annualSalary();
		int partB;
		int commission = (int)(annualSales*.02);
		if(commission<20000){
			partB = commission;
		}else{
			partB=20000;
		}
		return partA+partB;
	}
	/**
	 *overridden toString method to add salesman specific
	 *variables with inline tags
	 */
	public String toString(){
		return super.toString()+" Sales: "+annualSales;
	}

}