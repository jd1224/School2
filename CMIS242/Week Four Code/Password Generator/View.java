import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View implements ActionListener{

	private JButton create, close, clear;
	private JTextField inputLength, outputPassword, reversedPassword;
	
	public View(){
		//Create the frame with basic layout and settings
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 170);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		
		//create button panel and buttons
		JPanel buttonPan = new JPanel();
		
		create = new JButton("Create");
		//add action listeners to perform actions
		create.addActionListener(this);
		close = new JButton("Close");
		close.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		buttonPan.add(create);
		buttonPan.add(clear);
		buttonPan.add(close);
		//end create button panel and buttons
		//create entry field panel and text field
		JPanel entryPanel = new JPanel();
		
		JLabel inputLabel = new JLabel("Input the length for your password: ");
		inputLength = new JTextField(2);
		inputLength.setText("0");
		JLabel inputChoices = new JLabel("Randomly chosen from numbers, symbols, and letters.");
		//set a tooltip to show the characters that will be chosen from
		inputChoices.setToolTipText("1234567890!@#$%^&*abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		entryPanel.add(inputLabel);
		entryPanel.add(inputLength);
		entryPanel.add(inputChoices);
		//end create entry field
		//Create output panel
		JPanel outputPanel = new JPanel(new GridLayout(3,2));
		
		JLabel outputLabel = new JLabel("Random Password: ");
		JLabel reversedLabel = new JLabel("Backwards Password: ");
		outputPassword = new JTextField(50);
		reversedPassword = new JTextField(50);
		//set editable to false so user cannot edit the field
		outputPassword.setEditable(false);
		reversedPassword.setEditable(false);
		
		outputPanel.add(outputLabel);
		outputPanel.add(outputPassword);
		outputPanel.add(reversedLabel);
		outputPanel.add(reversedPassword);
		//end create output panel
		
		//add all of the panels to the main frame
		frame.add(outputPanel, BorderLayout.NORTH);
		frame.add(entryPanel, BorderLayout.CENTER);
		frame.add(buttonPan, BorderLayout.SOUTH);
		//set frame to visible to draw all components
		frame.setVisible(true);
	}
	/**
	 *method to create the password and set the
	 *text int the two JTextField objects to the
	 *appropriate String text
	 */
	private void createPassword(){
		String passwordOut="";
		//enter a try catch for numberformat exception
		try{
			int passwordLength = Integer.parseInt(inputLength.getText());
			Password password = new Password(passwordLength);
			passwordOut = password.getPassword();
		}catch (NumberFormatException ex1){
			//present a warning popup if a non-integer is entered
			JOptionPane.showMessageDialog(null, 
			"You may only input an Integer!\nAnd you cannot leave the box blank!", 
			"ERROR", 2);
		}
		outputPassword.setText(passwordOut);
		reversedPassword.setText(reversed(passwordOut));
	}
	
	/**
	 *Helper method to reverse a String
	 *@param orig String to be reversed
	 *@returns String which is the reverse of orig
	 */
	private String reversed(String orig){
		String output = "";
		char[] chars = orig.toCharArray();
		for(int i=chars.length-1;i>=0;i--){
			output = output + chars[i];
		}
		return output;
	}
	/**
	 *Method to clear all text and reset the 
	 *input size to 0
	 */
	private void clear(){
		outputPassword.setText("");
		reversedPassword.setText("");
		inputLength.setText("0");
		
	}
	
	/**
	 *implements ActionListner's only method
	 *Uses a switch to choose from the helper
	 *methods to execute the correct action for 
	 *the button pressed
	 */
	public void actionPerformed(ActionEvent e){
		String event = e.getActionCommand();
		
		switch (event){
			case "Create":
				createPassword();
				break;
			case "Clear":
				clear();
				break;
			case "Close":
				System.exit(0);
		}
	}
}