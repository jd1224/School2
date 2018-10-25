//********************************************************************************************************
// CLASS: View (View.java)
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH  = 500;
    public static final int FRAME_HEIGHT = 250;

    // Declare instance variables
    private JButton mClearButton;
    private JTextField[] mExamText; 
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private Main mMain;
    private JButton mSaveButton;
    private JTextField mSearchText;
    private JButton mSearchButton;
    private Student mStudent;
    private boolean cleared=true; //added variable to check state of cleared and uncleared boxes
    							 //this way the user must enter and search a valid name before trying to enter input	
    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the frame visible at the end.
     */
    public View(Main pMain) {

        // Save a reference to the Main object pMain in mMain.
        mMain=pMain;

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout.
        // Add a JLabel "Student Name: " to panelSearch
        // Create mSearchText and make the field 25 cols wide
        // Add mSearchText to the panel
        // Create mSearchButton
        // Make this View the action listener for the button
        // Add the button to the panel
        JPanel panelSearch = new JPanel();
        JLabel name = new JLabel("Student Name: ");
        mSearchText = new JTextField(25);
        mSearchButton = new JButton("Search");
        mSearchButton.addActionListener(this);
        
        panelSearch.add(name);
        panelSearch.add(mSearchText);
        panelSearch.add(mSearchButton);
        
        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout.
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of CourseConstants.NUM_HOMEWORKS JTextFields
        // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
        //     Create textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        JPanel panelHomework = new JPanel();
        JLabel homework = new JLabel("Homework: ");
        panelHomework.add(homework);
        mHomeworkText  = new JTextField[CourseConstants.NUM_HOMEWORKS];
        for(int i=0;i<CourseConstants.NUM_HOMEWORKS;i++) {
        	mHomeworkText[i] = new JTextField(5);
        	panelHomework.add(mHomeworkText[i]);
        }

        // Create the exam panel which contains the "Exam: " label and the two exam text fields. The pseudocode is omitted
        // because this code is very similar to the code that creates the panelHomework panel.
        JPanel panelExam = new JPanel();
        JLabel exam = new JLabel("Exams: ");
        panelExam.add(exam);
        mExamText = new JTextField[CourseConstants.NUM_EXAMS];
        for (int i =0;i<CourseConstants.NUM_EXAMS;i++) {
        	mExamText[i] = new JTextField(5+i);
        	panelExam.add(mExamText[i]);
        }

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout.
        // Create the Clear button mClearButton.
        // Make this View the action listener for mClearButton.
        // Add the  Clear button to the panel.
        // Repeat the three above statements for the Save button.
        // Repeat the three above statements for the Exit button.
        JPanel panelButtons = new JPanel();
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        
        panelButtons.add(mClearButton);
        panelButtons.add(mSaveButton);
        panelButtons.add(mExitButton);

        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout.
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain.
        // Add panelExam to panelMain.
        // Add panelButtons to panelMain.
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);
        
        
       /* JButton cleared1 = new JButton("cleared"); //uncomment to test cleared variable.
        cleared1.addActionListener(this);
        panelMain.add(cleared1);*/

        // Initialize the remainder of the frame, add the main panel to the frame, and make the frame visible.
        setTitle("Gradebookulator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panelMain);
        setVisible(true);
    }

    /**
     * overrides the actionPerformed method of the implemented ActionListener interface
     * provides appropriate method calls for the JButtons in this GUI
     */
    public void actionPerformed(ActionEvent pEvent) {
    	if(pEvent.getActionCommand().equals("Search")) {
    		if (mSearchText.getText().equals("")) {						//ensure a search term is entered and clear the gui if it is not
    			messageBox("You must enter a search term!");
    			clear();
    		}else {
    			String name = mSearchText.getText();
        		mStudent=mMain.search(name);								//use mMain to search the roster for the student
        		if(mStudent!=null) {										//if the search returns a student display it
        			cleared=false;											//set cleared to false so that saving will work
        			displayStudent(mStudent);
        		}else {
        			messageBox("Student not found.\n"
        					 + "User input is case sensitive.");						//if the search returns null, display a message dialog and call the clear method
        			clear();
        		}
    		}
    		
    	}else if(pEvent.getActionCommand().equals("Clear")) {			//call the clear method
    		clear();
    	}else if(pEvent.getActionCommand().equals("Exit")) {			//call the exit method from mMain
    		saveStudent();
    		mMain.exit();
    	}else if(pEvent.getActionCommand().equals("Save")) {			//call the save method
    		saveStudent();
    	}
    }

    /**
     * set all text boxes to clear, and set the mStudent reference to null so that nothing is saved on exit
     */
    private void clear() {
    	cleared=true;
    	mSearchText.setText("");
    	for (int i=0;i<CourseConstants.NUM_HOMEWORKS;i++) {
    		mHomeworkText[i].setText("");
    	}
    	for(int i=0;i<CourseConstants.NUM_EXAMS;i++) {
    		mExamText[i].setText("");
    	}
    	mStudent=null;
    }

    /**
     *uses a pair of for loops to fill the GUI boxes with the relevant student information 
    */
    private void displayStudent(Student pStudent) {
    	for (int i=0;i<CourseConstants.NUM_HOMEWORKS;i++) {
    		int hw = pStudent.getHomework(i);
    		String hwStr = Integer.toString(hw);
    		mHomeworkText[i].setText(hwStr);
    	}
    	for(int i=0;i<CourseConstants.NUM_EXAMS;i++) {
    		int ex = pStudent.getExam(i);
    		String exStr = Integer.toString(ex);
    		mExamText[i].setText(exStr);
    	}
    }

    /**
     * messageBox()
     *
     * Displays a message box containing some text.
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * uses a pair of for loops to write the input from the screen into the 
     * Roster for later saving into the output file
     * catch a number format exception if the input is not an integer
     * checks the cleared variable to ensure no null pointer exceptions
     * are thrown due to a null mStudent object.
     */
    private void saveStudent() {
    	if(!cleared) {
	   		try{
	   			for (int i=0;i<CourseConstants.NUM_HOMEWORKS;i++) {
	   	    		String hwStr=mHomeworkText[i].getText();
	   	    		int hw = Integer.parseInt(hwStr);
	   	    		mStudent.setHomework(i, hw);
	   	    	}
	   	    	for(int i=0;i<CourseConstants.NUM_EXAMS;i++) {
	   	    		String exStr=mExamText[i].getText();
	   	    		int ex = Integer.parseInt(exStr);
	   	    		mStudent.setExam(i, ex);
	   	    	}
	   		}catch (NumberFormatException ex) {						//if non-integer characters are entered, display a warning box
	   			messageBox("Scores must be integers!");
	   			mStudent.setExamList(mStudent.getExamList());
	   			mStudent.setHomeworkList(mStudent.getHomeworkList());	//set the lists back to their previous state without trying to save the improper input
	   		}
	   	
    	}
    }//end save
}
