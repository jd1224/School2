//********************************************************************************************************
// CLASS: Roster (Roster.java)
//
// COURSE AND PROJECT INFO
// Program to read, display, and write a gradebook file using a GUI
// CSE205 Object Oriented Programming and Data Structures, Fall B 2017
// Project Number: 03
//
// AUTHOR
// Joshua Coe(jcoe4@asu.edu)
//********************************************************************************************************package p03;
package p03;
import java.util.*;

/**
 * The Roster class encapsulates an ArrayList<Student> which stores the information for each student in the gradebook.
 */
public class Roster {

    // Declare mStudentList
    ArrayList<Student> mStudentList;

    /**
     * <<CTOR>> sets an empty arraylist of students
     */
    public Roster() {
    	mStudentList=new ArrayList<>();
    }

    /**
     * adds student to the list
     *
     */
    public void addStudent(Student pStudent) {
    	mStudentList.add(pStudent);
    }

    /**
     * returns the student object or null if the student
     * does not exist
     */
    public Student getStudent(String pLastName) {
    	int index = Searcher.search(getStudentList(), pLastName);
    	//System.out.println(index);
    	if(index==-1) {
    		return null;
    	}else return mStudentList.get(index);
    	
    }

    /**
     * getStudentList()
     * Accessor method for mStudentList.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * setStudentList()
     * Mutator method for mStudentList.
     */
    public void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster()
     * Called to sort the roster by last name.
     *
     * PSEUDOCODE:
     * Call Sorter.sort() passing the list of students
     */
    public void sortRoster() {
    	Sorter.sort(mStudentList);
    }

    /**
     * Returns a String representation of this Roster. Handy for debugging.
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) result += student + "\n";
        return result;
    }
}
