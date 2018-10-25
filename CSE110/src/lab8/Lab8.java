package lab8;
/*-------------------------------------------------------------------------
//AUTHOR:Joshua Coe/Instructor
//FILENAME: Lab8.java
//SPECIFICATION: 
//FOR: CSE 110- Lab #8
//TIME SPENT: 30 Minutes
//-----------------------------------------------------------*/

import lab8.Arrays;

public class Lab8 {
	
	public static void main(String[] args) {
		
		// Create an Arrays object using the first constructor
		Arrays arr1 = new Arrays(5);
		// Print the contents of the array in arr1
		System.out.println(arr1);
		// Call findMin, findMax, and calcAverage on arr1 and print their values
		System.out.println("Min: " + arr1.findMin());
		System.out.println("Max: " + arr1.findMax());
		System.out.println("Average: " + arr1.calcAverage());
		System.out.println();
		//create a new array to use in the next constructor
		int[] arr2 = {2,4,6};
		//create an object Arrays arr3 with the values of arr2
		Arrays arr3 = new Arrays(arr2);
		//print out the object, minimum, maximum, and average of arr3
		System.out.println(arr3);
		System.out.println("Min: " + arr3.findMin());
		System.out.println("Max: " + arr3.findMax());
		System.out.println("Average: " + arr3.calcAverage());
		
	}
}
