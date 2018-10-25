package assignment6;
/*-------------------------------------------------------------------------
//AUTHOR: Joshua Coe
//FILENAME: NumberCollection.java
//SPECIFICATION: A custom array class with various functions
//FOR: CSE 110- Assignment 6
//TIME SPENT: 3 Hours
//----------------------------------------------------------------------*/
import java.util.Arrays;

public class NumberCollection {

	private int count;
	private int[] numberArray;
	/**
	 * constructor for NumberArray Objects
	 * @param arraySize, int desired size of the array
	 */
	public NumberCollection(int arraySize) {
		
		numberArray= new int[arraySize];
		count = 0;
	}//end constructor
	/**
	 * Helper function to find the index of an element of the array if it exists
	 * @param searchingNum, int number to be found
	 * @return index of element if already in array, -1 if element is not in array
	 */
	private int indexOf(int searchingNum) {
		
		int index=-1;
		for (int i=0; i<count;i++) {
			if (numberArray[i]==searchingNum) {
				index = i;
			}
		}
		return index;
	}//end indexOf
	/**
	 * adds a number to the NumberArray object unless it already exists in the object;
	 * increases the size of the number array object's capacity by double current size if 
	 * new entry would be out of bounds
	 * @param numberToAdd, int number to be added
	 * @return boolean true if number is added, false if number is not added due to duplication of elements
	 */
	public boolean addNumber(int numberToAdd) {
		
		if (indexOf(numberToAdd)==-1) {//checks the return from the helper function to ensure no duplication
			if (count>=numberArray.length) {//check to see if adding a number would be out of bounds
				numberArray= Arrays.copyOf(numberArray, 2*numberArray.length);//doubles the size of the array to allow more input
			}
			numberArray[count]=numberToAdd;//adds number at index equal to count
			count ++;//increases count to keep track of total numbers in the array
			return true;//returns true if the number was added
		}else {
			return false;//returns false if it was not
		}
	}//end addNumber
	/**
	 * determines the highest number in the array
	 * @return, int highest number, or 0 if there are no entries in the array
	 */
	public int findMax() {
		
		int max = numberArray[0];
		if (count>0) {//make sure there are numbers in the array
			for (int i = 0; i<count;i++) {//loop through all elements to determine if they are largest
				if (numberArray[i]>max){
					max = numberArray[i];
				}
			}
		}else {//return 0 if no elements exist
			return 0;
		}
		return max;//return the highest number in the array
	}//end find max
	/**
	 * determines the lowest number in the array
	 * @return, int lowest number in the array or 0 if no elements exist
	 */
	public int findMin() {
		
		int min=numberArray[0];
		if (count>0) {
			for (int i=0;i<count;i++) {
				if (numberArray[i]<min) {
					min=numberArray[i];
				}//end if
			}//end for
		}else {return 0;}
		return min;
	}//end method
	
	public int computeSum() {
		int sum=0;
		for (int i=0; i<count; i++) {
			sum+=numberArray[i];			
		}//end for
		return sum;
	}//end method
	/**
	 * override the basic toString method and return the array in format
	 * {a,b,c,d,e...} rather than returning the pointer for the object
	 */
	public String toString() {
		String output ="";
		for (int i=0; i<count;i++) {//loop through the array starting at index 0 ending at the last filled element
			if (i<count-1) {//if the element is not the last element add a comma and space after the element and append to string
				output+=numberArray[i]+", ";
			}else {
				output += numberArray[i];
			}
						
		}//end for
		return "{"+output+"}";//return the array as a string enclosed in braces
	}//end toString
}//end class
