package projectTwo;
//********************************************************************************************************
//CLASS: Main.java
//
//DESCRIPTION
//program to read student information from a text file, calculate tuition, and return a text file in the proper format
//
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, FallB 2017
//Project Number: Project 2
//
//AUTHOR
//Joshua Coe, jcoe4@asu.edu
//********************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    /**
     *  Instantiate a Main object and call run() on the object.
     */
    public static void main(String[] args) {
    	
    	Main main = new Main();
    	main.run();
    }
    
    /**
     *  Calls other methods to implement the sw requirements.
     */
    private void run() {
        
    	String fName = "p02-students.txt";
    	ArrayList<Student> studentList;
    	try {
    		studentList = readFile(fName);
    		calcTuition(studentList);
    		Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
    		writeFile(studentList);
    	}
    	catch (FileNotFoundException ex) {
    		System.out.println("File could not be opened for reading or writing. Program exiting.");
    		//JOptionPane.showMessageDialog(null, "Your File was not found.\nExiting Program", "File Not Found", 0);
    		System.exit(-1);
    	}
    }//end run method

    /**
     * Calculates the tuition for each student. Write an enhanced for loop that iterates over each Student in
     * pStudentList. For each Student, call calcTuition() on that Student. Note: this is a polymorphic method
     * call.
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for(Student x:pStudentList) {
        	x.calcTuition();
        }
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as an ArrayList
     * <Student> object.
     * @param fName String location of file to read from
     */
    private ArrayList<Student> readFile(String fName) throws FileNotFoundException {
        
    	ArrayList<Student> returnList = new ArrayList<>();
    	Scanner in = new Scanner(new File(fName));
    	while (in.hasNextLine()) {
    		String[] temp = in.nextLine().split(" ");
    		if (temp[0].equalsIgnoreCase("c")) {
    			returnList.add(readOnCampusStudent(temp));
    		}else {
    			returnList.add(readOnlineStudent(temp));
    		}
    	}	
    	in.close();	
    	return returnList;
    }

    /**
     * Reads the information for an on-campus student.
     * @param a String[] in the format {"c", id, last, first, resident?, programFee, credits}
     * used to create an on-campus student object and return it to the calling method
     */
    private OnCampusStudent readOnCampusStudent(String[] in) {
    	
    	OnCampusStudent newOne = new OnCampusStudent(in[1], in[3], in[2]);
    	if (in[4].equalsIgnoreCase("R")) {
    		newOne.setmResident(true);
    	}else {newOne.setmResident(false);}
    	newOne.setmProgramFee(Double.parseDouble(in[5]));
    	newOne.setmCredits(Integer.parseInt(in[6]));
    	return newOne;
    }

    /**
     * Reads the information for an online student.
     * @param in a String[] in the format{"o", id, last, first, techfee?, credits}
     * which is used to create an online student object and return it to the calling method 
     */
    private OnlineStudent readOnlineStudent(String[] in) {
    
    	OnlineStudent newOne = new OnlineStudent(in[1], in[3], in[2]);
    	if(in[4].equalsIgnoreCase("t")) {
    		newOne.setmTechFee(true);
    	}else {newOne.setmTechFee(false);}
    	newOne.setmCredits(Integer.parseInt(in[5]));
    	return newOne;
    }

    /**
     *  Writes the output file to "p02-tuition.txt" per the software requirements.
     *  @param pStudentList is the list to write to the file. each element is 
     *  written using the toString method of the class to which it belongs
    */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        
    	PrintWriter out = new PrintWriter("p02-tuition.txt");
    	for (Student x:pStudentList) 
        	out.println(x);
        
    	out.close();
    }//end writeFile
    /**
     * used during testing to print the list at various points in the code
     * @param list to have each element printed.
     */
   /* private void printList(ArrayList<Student> list) {
    	for (Student x:list) {
    		System.out.println(x);
    	}
    }//end printList*/
}//end class
