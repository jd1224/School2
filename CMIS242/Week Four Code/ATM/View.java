/************************************************************
*Class View.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 15 September 2018
*Description: This class creates the GUI window for the ATM
*program and implements the ActionListener interface to take 
*user input from a text field.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat; 
import java.util.Locale;

public class View implements ActionListener{

	//create private instance variables outside the method
	//so they can be used in all methods
	private Account savings = new Account();
	private Account checking = new Account();
	private JTextField inputField;
	private ButtonGroup bg;
	private NumberFormat fmt1= NumberFormat.getCurrencyInstance(Locale.US);
	
	public View(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 180);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(0,1));
		
		//create and organize buttons
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new BoxLayout(buttonPan, BoxLayout.Y_AXIS));
		JPanel topButtons = new JPanel();
		JPanel bottomButtons = new JPanel();
		
		JButton withdraw = new JButton("Withdraw");
		withdraw.setPreferredSize(new Dimension(100,30));
		withdraw.addActionListener(this);
		
		JButton deposit = new JButton("Deposit");
		deposit.setPreferredSize(new Dimension(100,30));
		deposit.addActionListener(this);
		
		JButton transfer = new JButton("Transfer to");
		transfer.setPreferredSize(new Dimension(100,30));
		transfer.addActionListener(this);
		
		JButton balance = new JButton("Balance");
		balance.setPreferredSize(new Dimension(100,30));
		balance.addActionListener(this);
		
		topButtons.add(withdraw);
		topButtons.add(deposit);
		bottomButtons.add(transfer);
		bottomButtons.add(balance);
		
		buttonPan.add(topButtons);
		buttonPan.add(bottomButtons);
		
		//create and organize radiobuttons and input text field
		JPanel radioPan = new JPanel();
		bg = new ButtonGroup();
		JRadioButtonMenuItem checking = new JRadioButtonMenuItem("Checking", true);
		checking.setActionCommand("checking");
		checking.addActionListener(this);
		JRadioButtonMenuItem savings = new JRadioButtonMenuItem("Savings");
		savings.setActionCommand("savings");
		savings.addActionListener(this);
		
		bg.add(checking);
		bg.add(savings);
		
		inputField = new JTextField(20);
		
		radioPan.add(checking);
		radioPan.add(savings);
		radioPan.add(inputField);
		
		frame.add(buttonPan);
		frame.add(radioPan);
		frame.setVisible(true);
	
	}
	/**
	 *Helper method to create an error window with the supplied 
	 *String as the text in the center
	 *@param display String to be displayed
	 */
	private void errorWindow(String display){
		JOptionPane.showMessageDialog(null, 
			display, 
			"ERROR", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 *Helper method to create a window with the supplied 
	 *String as the text in the center
	 *@param title String to be the window title
	 *@param display String to be displayed
	 */
	private void successWindow(String title, String display){
		JOptionPane.showMessageDialog(null, 
			display, 
			title, JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 *Implements ActionListener
	 *uses an if/else to set the current account by 
	 *grabbing the selcted button from the 
	 *buttongroup bg then uses a switch statement
	 *to call the methods from that account
	 */
	public void actionPerformed(ActionEvent e){
		Account currentAccount;
		Account oppositeAccount;
		String currentString="";
		ButtonModel selectedModel = bg.getSelection();
		currentString = selectedModel.getActionCommand();
		
		if(currentString.equals("checking")){
			currentAccount = this.checking;
			oppositeAccount = this.savings;
		}else{
			currentAccount = this.savings;
			oppositeAccount = this.checking;
		}
		
		switch (e.getActionCommand()){
			case "Withdraw":
				try{
					currentAccount.withdraw(inputField.getText());
					successWindow(currentString.toUpperCase()+" WITHDRAWAL", 
								"Withdrawal success. New account balance is: "+fmt1.format(currentAccount.balance()));
				}catch (InsufficientFundsException ex2){
					errorWindow("Insufficient Funds.");
				}catch (NumberFormatException ex1){
					errorWindow("You may only withdraw amounts in $20 increments.");
				}
				inputField.setText("");
				break;
			case "Balance":
				successWindow(currentString.toUpperCase()+" BALANCE", "Your current balance is: "+fmt1.format(currentAccount.balance()));
				inputField.setText("");
				break;
			case "Deposit":
				try{
					currentAccount.deposit(inputField.getText());
					successWindow(currentString.toUpperCase()+" DEPOSIT", 
								"Deposit Success. Your current balance is: "+fmt1.format(currentAccount.balance()));
				}catch(NumberFormatException ex3){
					errorWindow("You must enter a number.");
				}
				inputField.setText("");
				break;
			case "Transfer to":
				try{
					currentAccount.transferIn(oppositeAccount, inputField.getText());
					successWindow("TRANSFER", "Transfer success.");
				}catch (InsufficientFundsException ex2){
					errorWindow("Insufficient Funds.");
				}catch (NumberFormatException ex1){
					errorWindow("You must enter a number.");
				}
				inputField.setText("");
				break;
		}
		
	}

}