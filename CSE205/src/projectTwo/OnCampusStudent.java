package projectTwo;
//********************************************************************************************************
//CLASS: OnCampusStudent.java
//
//DESCRIPTION
//extends student and implements methods and variables unique to on campus students
//
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, FallB 2017
//Project Number: Project 2
//
//AUTHOR
//Joshua Coe, jcoe4@asu.edu
//********************************************************************************************************
import java.text.DecimalFormat;
import projectTwo.TuitionConstants;
import java.text.*;
public class OnCampusStudent extends Student{

	private boolean mResident;
	private double mProgramFee;
	/**
	 * constructor to set id and name to new objects/calls super constructor
	 * @param pId String ID number
	 * @param pFname String first name
	 * @param pLname String last name
	 */
	public OnCampusStudent(String pId, String pFname, String pLname) {
		super(pId, pFname, pLname);
	}
	/**
	 * calculates tuition per rules in spec for on campus student
	 */
	public void calcTuition() {
			
		double tuition = 0.0;
		if(this.ismResident()) {
			tuition+=TuitionConstants.ONCAMP_RES_BASE;
		}else {tuition+=TuitionConstants.ONCAMP_NONRES_BASE;}
		if (this.getmCredits()>18) {
			tuition+=(this.getmCredits()-18)*TuitionConstants.ONCAMP_ADD_CREDITS;
		}
		tuition += this.getmProgramFee();
		
		this.setmTuition(tuition);
	}
//getters and setters
	public boolean ismResident() {
		return mResident;
	}

	public void setmResident(boolean mResident) {
		this.mResident = mResident;
	}

	public double getmProgramFee() {
		return mProgramFee;
	}

	public void setmProgramFee(double mProgramFee) {
		this.mProgramFee = mProgramFee;
	}
}//end class
