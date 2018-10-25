package assignment4;
/*-------------------------------------------------------------------------
/*-------------------------------------------------------------------------
// AUTHOR: Joshua Coe 
// FILENAME: Triangle.java
// SPECIFICATION: (Assignment 4) New class for objects of type Triangle with encapsulated instance variables
// TIME SPENT: 2 hours
//----------------------------------------------------------------------*/ 
public class Triangle {
	private int s1, s2, s3;
	/**
	 * constructor for triangle class
	 * @param side1 is a side of the triangle
	 * @param side2 is a side of the triangle
	 * @param side3 is a side of the triangle
	 */
	public Triangle(int side1, int side2, int side3) {	
		s1 = side1;
		s2 = side2;
		s3 = side3;		
	}//end constructor
	/**
	 * helper method to determine the longest side
	 * @return length of longest side as int
	 */
	private int largest() {
		if (s1>s2&&s1>s3) {
			return s1;
		}else if (s2>s3) {
			return s2;
		}else {
			return s3;
		}
	}//end largest
	/**
	 * helper method to determine the shortest side
	 * @return length of shortest side as int
	 */
	private int shortest() {
		if (s1<s2&&s1<s3) {
			return s1;
		}else if (s2<s3) {
			return s2;
		}else {
			return s3;
		}
	}//end shortest
	/**
	 * determine if the triangle is equilateral
	 * @return boolean
	 */
	public boolean is_equilateral() {
		return (shortest()==largest());
	}
	/**
	 * determine if triangle is isosceles
	 * @return boolean
	 */
	public boolean is_isosceles() {
		if (s1==s2||s1==s3||s2==s3) {
			return true;
		}else {return false;}
		}
	
	/**
	 * determine if triangle is scalene
	 * @return boolean
	 */
	public boolean is_scalene() {
		if (s1!=s2&&s1!=s3&&s2!=s3) {
			return true;
		}else {return false;}
	}//end scalene
	/**
	 * print a string with the length of the sides of the triangle
	 */
	public String toString() {
		return s1+" "+s2+" "+s3;
	}//end toString
	
}//end class