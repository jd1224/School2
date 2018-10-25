package projectTwo;
//********************************************************************************************************
//CLASS: OnlineStudent.java
//
//DESCRIPTION
//extends student and implements methods and variables unique to on-line students
//
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, FallB 2017
//Project Number: Project 2
//
//AUTHOR
//Joshua Coe, jcoe4@asu.edu
//********************************************************************************************************
import projectTwo.TuitionConstants;
import java.text.*;
public class OnlineStudent extends Student{

	private boolean mTechFee;
	/**
	 * constructor to set id and name to new objects/calls super constructor
	 * @param pId String ID number
	 * @param pFname String first name
	 * @param pLname String last name
	 */
	public OnlineStudent(String pId, String pFname, String pLname) {
		super(pId, pFname, pLname);
	}
	/**
	 * calculates tuition based on the spec rules for an online student
	 */
	public void calcTuition() {
		
		double tuition = (double)this.getmCredits()*TuitionConstants.ONLINE_CREDIT_RATE;
		
		if (this.ismTechFee()) {tuition+=TuitionConstants.ONLINE_TECH_FEE;}
		
		this.setmTuition(tuition);
		
	}
//getters and setters
	public boolean ismTechFee() {
		return mTechFee;
	}

	public void setmTechFee(boolean mTechFee) {
		this.mTechFee = mTechFee;
	}	
}//end class
