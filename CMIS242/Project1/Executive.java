/************************************************************
*Class Executive.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 1 September 2018
*Description: subclass of Employee which adds
*executive specific methods and variables. 
*/
public class Executive extends Employee{

	private int currentStockPrice;
	/**
	 *constructor which adds currentStockPrice for Executive
	 */
	public Executive(String name, int monthlySalary, int currentStockPrice){
		super(name, monthlySalary);
		this.currentStockPrice = currentStockPrice;
	}
	/**
	 *overridden method to calculate the annual salary for an executive
	 *based on a bonus of 30000 when the stockprice is greater
	 *than 50 and no bonus if less than 50
	 */
	public int annualSalary(){
		
		int partA = super.annualSalary();
		int partB;
		if(currentStockPrice>50){
			partB = 30000;
		}else{
			partB=0;
		}
		return partA+partB;
	}
	/**
	 *overridden toString method to add executive specific
	 *variables with inline tags
	 */
	public String toString(){
		return super.toString()+" Stock: " + this.currentStockPrice;
	}

}