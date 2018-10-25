//********************************************************************************************************
// CLASS: Main (Main.java)
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

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * The Main class containing the main() and run() methods.
 */
public class Main {

    // The Roster of students that is read from "gradebook.txt".
    private Roster mRoster;

    // A reference to the View object.
    private View mView;

    /**
     * This is where execution starts. Instantiate a Main object and then call run().
     */
    public static void main(String[] pArgs){
        Main runner = new Main();
        runner.run();
    }

    /**
     * attempts to save the changes to mRoster into the gradebook.txt file
     * catches exception for the file being unable to be written to and exits without saving
     */
    public void exit() {
    	try {
    		GradebookWriter write = new GradebookWriter("gradebook.txt");
    		write.writeGradebook(mRoster);
    		write.close();
    		System.exit(-1);
    	}catch (FileNotFoundException ex) {
    		mView.messageBox("Could not open gradebook.txt for writing. Exiting without saving.");
    		System.exit(-1);
    	}
    }

    /**
     * Accessor method for mRoster.
     */
    public Roster getRoster() {
        return mRoster;
    }

    /**
     * Accessor method for mView.
     */
    public View getView() {
        return mView;
    }

    /**
     * run() is the main routine.
     * instantiates the GUI from View class, and calls the appropriate 
     * method to read the gradebook into an ArrayList of Students
     *
     */
    public void run() {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	setView(new View(this));
    	try {
    		GradebookReader read = new GradebookReader("gradebook.txt");
    		setRoster(read.readGradebook());
    		//System.out.println(mRoster.getStudentList().toString());
    		
    	}catch (FileNotFoundException ex){
    		mView.messageBox("Your file could not be accessed\n"
    					   + "exiting program now");
    		System.exit(-1);
    	}/*catch (NoSuchElementException ex) {
    		mView.messageBox("File gradebook.txt is in an incorrect format."
    						+ "Exiting program now.");
    		System.exit(-1);
    	}*/
    }
   

    /**
     * search() is called when the Search button is clicked on the View. The input parameter is the non-empty last name
     * of the Student to locate. Call getStudent(pLastName) on the Roster object to get a reference to the Student with
     * that last name. If the student is not located, getStudent() returns null.
     */
    public Student search(String pLastName) {
    	return(mRoster.getStudent(pLastName));
    }

    /**
     * Mutator method for mRoster.
     */
    public void setRoster(Roster pRoster) {
        mRoster = pRoster;
    }

    /**
     * Mutator method for mView.
     */
    public void setView(View pView) {
        mView = pView;
    }
}
