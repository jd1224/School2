package assignment5;
/*-------------------------------------------------------------------------
//AUTHOR: Joshua Coe
//FILENAME: Geek.java
//SPECIFICATION: A question and answer program using the Geek class
//FOR: CSE 110- Assignment 5
//TIME SPENT: 5 hours
//----------------------------------------------------------------------*/ 
public class Geek {
	private String name;
	private static int numOfQuestions;
	
	/**
	 * constructor
	 * @param name- string to store as name
	 * @param numQ- number of questions asked to this geek
	 */
	public Geek(String name, int numQ) {
		this.name=name;
		numOfQuestions=numQ;
	}//end constructor
	/**
	 * overrides the geek default constructor so name is not set to null
	 */
	public Geek() {
		name="?";
		numOfQuestions=0;
	}//end default override constructor
	
	/**
	 * accessor for private variable name
	 * @return - String name
	 */
	public String getName(){
		return name;
	}//end accessor
	
	/**
	 * accessor for private variable name
	 * @return - int number of questions asked
	 */
	public int getNumberOfQuestions() {
		return numOfQuestions;
	}//end accessor
	
	/**
	 * returns whether the sum of two integers is even
	 * @param x int 1
	 * @param y int 2
	 * @return boolean
	 */
	public boolean isEven(int x, int y) {
		int sum=x+y;
		numOfQuestions+=1;
		return (sum%2==0);
		
	}//end isEven
	
	/**
	 * Reads two integers and provides a sum of every number between them(inclusive of input)
	 * @param first integer
	 * @param second integer
	 * @return integer sum of all numbers between first and second
	 */
	public int sum(int first, int second) {
		int result=0;
		if (first==second) {//if first is equal to second then return the number
			result= first;
		}else if (second>first) {
			for (int i=first;i<=second;i++) {//start at the smaller number and work to the larger(inclusive)
				result +=i;//adding each number to the result
			}		
		}else {
			for (int i=second;i<=first;i++) {//start at the smaller number and work to the largest(inclusive)
				result +=i;//adding each number to the result
			}
		}
		numOfQuestions+=1;
		return result;	
	}//end sum
	/**
	 * read a year as an integer and return whether it is a leap year or not
	 * @param year- integer year to be tested
	 * @return- boolean true if leap year, false if not.
	 */
	public boolean isLeapYear(int year) {
		if (year%4==0&&year<=1582) {//if prior to 1582, every year divisible by 4 was a leap year without exception
			numOfQuestions+=1;
			return true;
		}else if (year%4==0&&year>1582) {//if after 1582 most years divisible by 4 are a leap year with the following exceptions
			if (year%400==0) {//if they are divisible by 400 they are a leap year
				numOfQuestions+=1;
				return true;
			}else if (year%100==0) {//if they are not divisible by 400, but are divisible by 100 they are not a leap year
				numOfQuestions+=1;
				return false;
			}else {//other wise they are divisible by four and are a leap year
				numOfQuestions+=1;
				return true;
			}
		}else {//if not divisible by four, add a question asked, and return false
			numOfQuestions+=1;
			return false;
		}
	}//end leapYear

}//end class
