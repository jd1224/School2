/************************************************************
*Class Student.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 14 October 2018
*Description: Class which defines a Studnet object
*to be used in the View class
*/
public class Student{
	//Declare variables to be used in multiple methods of this class
	private String name, major;
	private double gpa;
	private int grades=0, possibleGrades=0;
	//Constructor to take name and major as parameters
	public Student(String name, String major){
		this.name = name;
		this.major = major;
		this.gpa = 4.0;
	}
	//Method to add a course and re-calculate GPA when finished
	public void courseCompleted(String grade, int credits){
		possibleGrades += credits;
		
		
		switch (grade){
			case "A":
				grades += credits*4;
				break;
			case "B":
				grades += credits*3;
				break;
			case "C":
				grades += credits*2;
				break;
			case "D":
				grades += credits*1;
				break;
			case "F":
				break;
		}
		
		calcGPA();
		
	}
	//Helper method to calculate GPA
	private void calcGPA(){
		this.gpa = (double)grades/possibleGrades;
	}
	//Overridden toString method to return the specified String
	public String toString(){
		return "Name: "+this.name+"\nMajor: "+this.major+"\nGPA: "+this.gpa;
	}
}