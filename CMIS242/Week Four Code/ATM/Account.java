/************************************************************
*Class Account.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 15 September 2018
*Description: This is the class which provides the methods for
*account objects used in the ATM program.
*/
public class Account{
	
	//static variable to count all withdrawls from all accounts
	private static int withdrawals = 0;
	private double balance;
	
	public Account(){
		balance = 0;
	}
	/**
	 *Method to withdraw funds from an account object
	 *implements logic to add a service fee of 1.5 if 4 or more
	 *withdrawls have been made from all account objects
	 *@param amount String amount to be withdrawn
	 *@throws NumberFormatException if amount does not contain a parseable double
	 *or amount is not a multiple of 20
	 *@throws InsufficientFundsException if amount is greater than balance or if
	 *super.withdrawls is greater than four and amount + 1.5 is greater than balance
	 */
	public void withdraw(String amount) throws NumberFormatException, InsufficientFundsException{
		double cash = Double.parseDouble(amount);
		double fee=0;
		if(withdrawals>3){
			fee=1.5;
		}		
		if(cash%20!=0){
			throw new NumberFormatException();
		}else if(cash+fee>balance){
			throw new InsufficientFundsException("Insufficient Funds");
		}else{
			this.balance -= cash+fee;
			withdrawals++;
		}
	}
	/**
	 *return double balance of the account
	 */
	public double balance(){
		return balance;
	}
	/**
	 *method to deposit funds into an account
	 *@param amount Sring amount to deposit
	 *@throws NumberFormatException if amount does not contain a parseable double
	 */
	public void deposit(String amount)throws NumberFormatException{
		double cash = Double.parseDouble(amount);
		balance += cash;
	}
	public void transferOut(double amount){
		this.balance -= amount;
	}
	/**
	 *method to transfer money into this account from another account
	 *@param from Account to transfer money from
	 *@param amount String amount to transfer
	 *@throws NumberFormatException if amount does not contain a parseable double
	 *@throws InsufficientFundsException if amount is greater than balance of from
	 */
	public void transferIn(Account from, String amount)throws NumberFormatException, InsufficientFundsException{
		double cash = Double.parseDouble(amount);
		if (cash>from.balance()){
			throw new InsufficientFundsException("Insufficient Funds");
		}else{
			this.balance += cash;
			from.transferOut(cash);
		}
	}
	
	

}