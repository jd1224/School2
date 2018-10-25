package projectTwo;
//********************************************************************************************************
//CLASS: Student.java
//
//DESCRIPTION
//Super class with common methods to all students including a toString in the format that the spec needs for output
//
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, FallB 2017
//Project Number: Project 2
//
//AUTHOR
//Joshua Coe, jcoe4@asu.edu
//********************************************************************************************************
import java.text.DecimalFormat;
public abstract class Student implements java.lang.Comparable<Student>{

	private int mCredits;
	private String mFname, mId, mLname;
	private double mTuition;
	/**
	 * constructor to set id and name to new objects
	 * @param pId String ID number
	 * @param pFname String first name
	 * @param pLname String last name
	 */
	public Student(String pId, String pFname, String pLname) {
		mId = pId;
		setmFname(pFname);
		setmLname(pLname);
	}
	/**
	 * abstract method to be overwritten by sub-classes to calculate tuition
	 */
	abstract void calcTuition();
	/**
	 * method to define which variable to sort by. takes one student and 
	 * compares it to another lexicographically based on the mId variable
	 * @returns -1 if object calling method is lower than object called upon,
	 * 1 if object calling method is higher than object called upon
	 * 0 if objects are the same
	 */
	public int compareTo(Student pStudent) {
		if(this.getMId().compareTo(pStudent.getMId())<0) {
			return -1;
		}else if (this.getMId().compareTo(pStudent.getMId())>0) {
			return 1;
		}else {return 0;}
	}
	//below are all of the getters and setters for the private instance variables
	public void setMId(String pId) {
		mId=pId;
	}
	
	public String getMId() {
		return mId;
	}

	public int getmCredits() {
		return mCredits;
	}

	public void setmCredits(int mCredits) {
		this.mCredits = mCredits;
	}

	public String getmFname() {
		return mFname;
	}

	public void setmFname(String mFname) {
		this.mFname = mFname;
	}

	public String getmLname() {
		return mLname;
	}

	public void setmLname(String mLname) {
		this.mLname = mLname;
	}

	public double getmTuition() {
		return mTuition;
	}
	
	//this is protected so that only objects of this class or direct subclasses can change it.
	protected void setmTuition(double mTuition) {
		this.mTuition = mTuition;
	}
	/**
	 * toString override method to print the student object in the format required for the spec output
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return this.getMId()+" "+this.getmLname()+" "+this.getmFname()+" "+df.format(this.getmTuition());
	}//end toString
}//end class
