//********************************************************************************************************
// CLASS: Student (Student.java)
//
// COURSE AND PROJECT INFO
// Program to read, display, and write a gradebook file using a GUI
// CSE205 Object Oriented Programming and Data Structures, Fall B 2017
// Project Number: 03
//
// AUTHOR
// Joshua Coe(jcoe4@asu.edu)
//********************************************************************************************************
package p03;

import java.util.ArrayList;



/**
 * The Student class stores the grade information for one Student.
 */
public class Student implements Comparable<Student> {

    // Declare the instance variables.
    private ArrayList<Integer> mExamList, mHomeworkList;
    private String mLastName, mFirstName;

    /**
     * Constructor to accept first and last names, set the 
     * appropriate variables, and instantiate the ArrayLists
     */
    public Student(String pFirstName, String pLastName) {
    	mFirstName = pFirstName;
    	mLastName = pLastName;
    	mExamList = new ArrayList<>();
    	mHomeworkList = new ArrayList<>();
    }

    /**
     * adds an exam score to the list
    */
    public void addExam(int pScore) {
    	mExamList.add(pScore);
    }

    /**
     *adds a homework score to the list
     */
    public void addHomework(int pScore) {
    	mHomeworkList.add(pScore);
    }

    /**
     * lexicographically compares two Student objects by
     * their mLastName variables returns -1 if the object 
     * calling the method is lower, 1 if it is higher,
     * and 0 if they are the same
     *
     */
    @Override
   public int compareTo(Student pStudent) {
    	if(mLastName.compareTo(pStudent.getLastName())<0) {
    		return -1;
    	}else if(mLastName.compareTo(pStudent.getLastName())>0) {
    		return 1;
    	}else {return 0;}
    }

    /**
     * getExam()
     *
     * Accessor method to retreive an exam score from the list of exams.
     */
    public int getExam(int pNum) {
        return getExamList().get(pNum);
    }

    /**
     * getExamList()
     *
     * Accessor method for mExamList.
     */
    protected ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * getFirstName()
     *
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * getHomework()
     *
     * Accessor method to retrieve a homework score from the list of homeworks.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    protected ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * setExam()
     *
     * Mutator method to store an exam score into the list of exam scores.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * setExamList()
     *
     * Mutator method for mExamList.
     */
    protected void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework scores.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    protected void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * overrides the base toString method and returns
     * a string in the prescribed format for the output file
     */
    public String toString() {
    	String out = mLastName+" "+mFirstName+" ";
    	for(int x:mHomeworkList) {
    		out+=x+" ";
    	}
    	for(int x:mExamList) {
    		out+=x+" ";
    	}
    	return out;
    }
}
