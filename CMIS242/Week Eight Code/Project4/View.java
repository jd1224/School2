/************************************************************
*Class View.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 14 October 2018
*Description: Main class of the program which creates a GUI
*to perform the specified operations and contains an HashMap
*for storing all of the student objects with their ID numbers
*as their keys.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
//create the GUI and add an actionlistener
public class View implements ActionListener{
	//declare variables to be used in multiple methods
	private HashMap<String, Student> studentList = new HashMap<>();
	private JTextField idNumber, name, major;
	private JComboBox<String> grades, selection;
	private String[] selectionList = {"Insert", "Delete", "Find", "Update"};
	private String[] gradeList = {"A", "B", "C", "D", "F"};
	private String sID, sName, sMajor, sGrade;
	//creates the GUI window and instantiates objects needed
	public View(){
	
		JFrame frame = new JFrame("Project 4");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(0,2));
		//left panel start
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(6,0));
		left.add(new JLabel("ID:"));
		left.add(new JLabel("Name:"));
		left.add(new JLabel("Major:"));
		left.add(new JLabel("Choose Selection:"));
		JButton process = new JButton("Process Request");
		process.addActionListener(this);
		left.add(process);
		//right panel start
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(6,0));
		idNumber = new JTextField(20);
		right.add(idNumber);
		name = new JTextField(20);
		right.add(name);
		major = new JTextField(20);
		right.add(major);
		selection = new JComboBox<String>(selectionList);
		right.add(selection);
		//add panels to frame
		frame.add(left);
		frame.add(right);
		frame.setVisible(true);
	
	}
	//helper to clear fields after operations are performed
	public void clearFields(){
		idNumber.setText("");
		name.setText("");
		major.setText("");
	}
	//JOptionPane for grade choices
	public String gradeWindow(){
		String[] possibleValues = gradeList;
		return (String)JOptionPane.showInputDialog(null,
             "Choose one", "Input",
             JOptionPane.INFORMATION_MESSAGE, null,
             possibleValues, possibleValues[0]);
	}
	//JOptionPane to choose number of credits for class
	public int creditsWindow(){
		String[] possibleValues = {"1","2","3","4","5","6"};
		String result = (String)JOptionPane.showInputDialog(null,
             "Choose one", "Input",
             JOptionPane.INFORMATION_MESSAGE, null,
             possibleValues, possibleValues[0]);
		return Integer.parseInt(result);
	}
	//re-usable success window
	private void successWindow(String input){
		JOptionPane.showMessageDialog(null, input, "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	//re-usable failure window
	private void failureWindow(String input){
		JOptionPane.showMessageDialog(null, input, "Operation Failed", JOptionPane.ERROR_MESSAGE);
	}
	//capture actions on button press
	//use a switch to choose the appropriate actions
	public void actionPerformed(ActionEvent e){
		sID = idNumber.getText();
		sName = name.getText();
		sMajor = major.getText();
		String selected = (String)selection.getSelectedItem();
		switch (selected){
			case "Insert":
				if (sID.equals("")){
					failureWindow("ID Number Cannot Be Blank.");
				}else if(studentList.containsKey(sID)){
					failureWindow("No Duplicate IDs Are Allowed\nUse The Find Function To Check ID Numbers.");
				}else{
					Student student = new Student(sName, sMajor);
					studentList.put(sID, student);
					successWindow("Successfully added:\n"+student);
				}
				clearFields();
				break;
			case "Find":
				if(studentList.containsKey(sID)){
					Student temp = studentList.get(sID);
					successWindow(""+temp);
				}else{
					failureWindow("Student Record Not Found.\nCheck ID Number and Try Again.");
				}
				clearFields();
				break;
			case "Delete":
				if(studentList.containsKey(sID)){
					Student temp = studentList.get(sID);
					studentList.remove(sID);
					successWindow(""+temp+"\nRemoved from Database.");
				}else{
					failureWindow("Student Record Not Found.\nCheck ID Number and Try Again.");
				}
				clearFields();
				break;
			case "Update":
				if (studentList.containsKey(sID)){
					Student temp = studentList.get(sID);
					String grade = gradeWindow();
					int credits = creditsWindow();
					temp.courseCompleted(grade, credits);
					successWindow(""+temp+"\nAdded "+credits+" credits with a grade of "+grade);
				}else{
					failureWindow("Student Record Not Found.\nCheck ID Number and Try Again.");
				}
				clearFields();
				break;
		}
	}
	//main method of the program creates an instance of View
	public static void main(String[] args){
		View view = new View();
	}

}