package lab8;
/*-------------------------------------------------------------------------
//AUTHOR:Joshua Coe/Instructor
//FILENAME: Arrays.java
//SPECIFICATION: 
//FOR: CSE 110- Lab #8
//TIME SPENT: 45 Minutes
//-----------------------------------------------------------*/
import java.util.Random;

public class Arrays {
	// Instance Variables
	private int[] array;
	private int count = 0;
	
	// Constructors
	/**
	 * Constructor that creates an object Arrays of size input filled
	 * with random integers between 1 and 10
	 * @param size length of object
	 */
	public Arrays(int size) {
		array = new int[size];
		count = size;
		Random rand = new Random();
		for (int i = 0; i < count; i++) {
		array[i] = (rand.nextInt(10));
		}
	}
	/**
	 * creates an object Arrays using the values passed in the argument
	 * @param arr array to use in creating Arrays object
	 */
	public Arrays(int[] arr) {
		count = arr.length;
		array=arr;
	}
	
	// findMin
	/**
	 * calculates the lowest number in the object
	 * @return lowest number in object
	 */
	public int findMin() {
		int min = array[0]; // Set min to the first element
		for (int i = 1; i < count; i++) {
		// Reassign min if there is a smaller element
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min; // Return the smallest element
	}
	// findMax
	/**
	 * calculates the highest number in the object
	 * @return highest number in the object
	 */
	public int findMax() {
		int max = array[0];
		for (int i =1;i<count;i++) {
			if (array[i]>max) {
				max = array[i];
			}
		}
		return max;
	}
	// calcSum
	/**
	 * private method to sum all numbers in the object
	 * @return sum of all numbers in the array
	 */
	private int calcSum() {
		int sum = 0;
		for (int i=0;i<count;i++) {
			sum+=array[i];
		}
		return sum;
	}
	// calcAverage
	/**
	 * calculate the average of the numbers in the object using the helper
	 * method calcSum
	 * @return double average of all numbers in the object
	 */
	public double calcAverage() {
		return (double)calcSum()/count;
	}
	// toString
	/**
	 * override the base toString method and return a String of the object
	 * in the format "[ x,y,...z ]"
	 */
	public String toString() {
		String output = "[ ";
		for (int i = 0; i < count; i++) {
			output += array[i];
			if (i != count - 1) {
				output += ", ";
			}
		}
		return output + " ]";
	}
	
}
