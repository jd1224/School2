/************************************************************
*Class View.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 30 September 2018
*Description: Main class of the program which creates a GUI
*to perform the specified operations and return the nth number
*of the sequence and the efficiency of the operations
*defined in the project documentation
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class View{
	//main method
	public static void main(String[] args){
		View view = new View();
	}
	
	ButtonGroup bg = new ButtonGroup();
	JTextField input, output, efOut;
	//inner class to use the WindowAdapter to perform operations during close
	class closeCheck extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			long[] recursiveResults = new long[11];
			int[] recursiveEfficiency = new int[11];
			long[] iterativeResults = new long[11];
			int[] iterativeEfficiency = new int[11];
			for(int i=0;i<=10;i++){
				recursiveResults[i]= Sequence.computeRecursive(i);
				recursiveEfficiency[i]=Sequence.getEfficiency();
				iterativeResults[i]=Sequence.computeIterative(i);
				iterativeEfficiency[i]=Sequence.getEfficiency();;
			}
			//writes the required output to the file
			try{
				FileWriter writer = new FileWriter("out.txt");
				for(int i=0;i<recursiveResults.length;i++){
				writer.write(recursiveResults[i]+","+iterativeEfficiency[i]+","+recursiveEfficiency[i]+"\n");
				}
				writer.close();
			}catch (IOException ex1){
				failedWindow();
			}
		}
		//reusable failed window
		private void failedWindow(){
			JOptionPane.showMessageDialog(null, "File could not be written, check permissions.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	//inner class creates a listener for the button press
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//get the selected button and perform the calculations
			output.setText("");
			efOut.setText("");
			switch(bg.getSelection().getActionCommand()){
				case "Iterative":
					try{
						int num = Integer.parseInt(input.getText());
						output.setText(""+Sequence.computeIterative(num));
						efOut.setText(""+Sequence.getEfficiency());
					}catch (NumberFormatException ex1){
						failedWindow();
					}
					break;
				case "Recursive":
					try{
						int num = Integer.parseInt(input.getText());
						output.setText(""+Sequence.computeRecursive(num));
						efOut.setText(""+Sequence.getEfficiency());
					}catch (NumberFormatException ex1){
						failedWindow();
					}
					break;
			}
		}
		//failed window in case of errors
		private void failedWindow(){
			JOptionPane.showMessageDialog(null, "Enter a positive integer up to 130 in the input box.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	//create the window and components. Position them according to the documentation
	public View(){
		
		JFrame frame = new JFrame("Project 3");
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new closeCheck());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(0,2));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(6,0));
		
		JLabel entry = new JLabel("Enter n:");
		JLabel result = new JLabel("Result:");
		JLabel efficiency = new JLabel("Efficiency:");
		
		panelLeft.add(new JLabel());
		panelLeft.add(new JLabel());
		panelLeft.add(entry);
		panelLeft.add(new JLabel());
		panelLeft.add(result);
		panelLeft.add(efficiency);
		//end panelLeft
		
		JPanel panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(6,0));
		
		JRadioButton iterative = new JRadioButton("Iterative", true);
		iterative.setActionCommand("Iterative");
		JRadioButton recursive = new JRadioButton("Recursive");
		recursive.setActionCommand("Recursive");
		bg.add(iterative);
		bg.add(recursive);
		input = new JTextField(25);
		output = new JTextField(25);
		output.setEditable(false);
		efOut = new JTextField(25);
		efOut.setEditable(false);
		JButton compute = new JButton("Compute");
		compute.addActionListener(new ButtonListener());
		
		panelRight.add(iterative);
		panelRight.add(recursive);
		panelRight.add(input);
		panelRight.add(compute);
		panelRight.add(output);
		panelRight.add(efOut);
		
		frame.add(panelLeft);
		frame.add(panelRight);
		frame.setVisible(true);
	}
}