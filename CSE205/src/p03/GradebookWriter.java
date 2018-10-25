//********************************************************************************************************
// CLASS: GradebookWriter (GradebookWriter.java)
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

import java.io.*;


/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file name passed to the ctor.
 */
public class GradebookWriter extends PrintWriter {

    /**
     * GradebookWriter()
     * Call the super class ctor that takes a String.
     */
    public GradebookWriter(String pFname) throws FileNotFoundException{
    	super(pFname);
    }

    /**
     * iterates over the student list and writes each student to 
     * the file opened in the CTOR using an enhanced for loop
     * and the overridden toString() method of Student
     */
    public void writeGradebook(Roster pRoster) {
    	for (Student x:pRoster.getStudentList()) {
    			this.println(x);
    		
    	}
    	this.close();
    }
}
