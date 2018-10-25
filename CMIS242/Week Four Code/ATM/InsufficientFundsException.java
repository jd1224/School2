/************************************************************
*Class InsufficientFundsException.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 15 September 2018
*Description: User defined checked exception to throw in ATM program
*/
public class InsufficientFundsException extends Exception{

	public InsufficientFundsException(String message){
	
		super(message);
	
	}

}