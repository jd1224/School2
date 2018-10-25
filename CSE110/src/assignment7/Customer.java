package assignment7;
/*-------------------------------------------------------------------------
//AUTHOR: CSE110 instructor
//FILENAME: Customer.java
//SPECIFICATION: The class Customer describes information on a customer
//and has a first name (a String), last name (String),  ID number (integer),
//number of matinee tickets (integer),  number of normal tickets (integer), and total cost (double).
//YOUR Lab Letter and Name of the TA for your Closed lab
//FOR: CSE 110- on-line section A
//TIME SPENT: how long it took you to complete the assignment
//----------------------------------------------------------------------*/


import java.util.StringTokenizer;
import java.text.NumberFormat;

public class Customer
{
private String lastName;
private String firstName;
private int customerID;
private int matineeTickets;
private int normalTickets;
private double totalCost;

// This constructor sets the first name and last name to "???", customer ID,
// the number of matinee tickets, and the number of normal tickets to 0,
// and the total cost to 0.0.
public Customer()
  {
		  lastName = "???";
		  firstName = "???";
		  customerID = 0;
		  matineeTickets = 0;
		  normalTickets = 0;
		  totalCost = 0.0;
	  }
// This constructor constructs a Customer object  given the last name,
// first name, customer id, the number of matinee tickets, the number
// of normal tickets.
public Customer(String customerInfo)
  {
		 String []tokenizer = customerInfo.split(" ");
      firstName = tokenizer[0].trim();
      lastName =tokenizer[1].trim();
      customerID = Integer.parseInt(tokenizer[2].trim());
      matineeTickets = Integer.parseInt(tokenizer[3].trim());
      normalTickets = Integer.parseInt(tokenizer[4].trim());
      totalCost = 0.0;
      computeTotalCost();
	 }

// This constructor cConstructs a Customer object using the string containing customer's info.
// It uses the StringTokenizer to extract first name, last name, id, the number of matinee tickets,
// and the number of normal tickets.
public Customer(String lName, String fName, int id, int matineeNum, int normalNum)
  {
		 lastName = lName;
		 firstName = fName;
		 customerID = id;
		 matineeTickets = matineeNum;
		 normalTickets = normalNum;
		 totalCost = 0.0;
		 computeTotalCost();
	 }

// This method sets the last name.
public void setLastName(String lName)
  {
		 lastName = lName;
	 }
// This method sets the first name.
public void setFirstName(String fName)
  {
		 firstName = fName;
	 }
// This method sets the customer ID.
public void setCustomerID(int id)
  {
		 customerID = id;
	 }

// This method set the value of number of matineeTickets to  have its parameter value.
// And it re-computes total cost.
public void setMatineeTickets(int matinee)
  {
		 matineeTickets = matinee;
		 computeTotalCost();
	 }

// This method set the value of number of notmalTickets to  have its parameter value.
// And it re-computes total cost.
public void setNormalTickets(int normal)
  {
		 normalTickets = normal;
		 computeTotalCost();
	 }


// This method returns the last name.
public String getLastName()
  {
		 return lastName;
	 }
// This method returns the first name.
public String getFirstName()
  {
		 return firstName;
	 }

// This method returns the customer ID.
public int getCustomerID()
  {
		 return customerID;
	 }

// This method returns the number of matinee tickets.
public int getMatineeTickets()
  {
		 return matineeTickets;
	 }

// This method returns the number of normal tickets.
public int getNormalTickets()
  {
		 return normalTickets;
	 }

// This method returns the total cost.
public double getTotalCost()
  {
		 return totalCost;
	 }

// This method compute the total cost based on the number of matinee tickets and normal tickets.
private void computeTotalCost()
  {
		totalCost = (5.00)*matineeTickets + (7.50)*normalTickets;
	 }

// This method checks if a customer object passed as a parameter and itself (customer object)
// are same using their last names, first names, and customerIDs.
public boolean equals(Customer other)
  {
		 if (lastName.equals(other.lastName) && firstName.equals(other.firstName)
		     && (customerID == other.customerID) )
		     return true;
		 else
		     return false;
  }
// This method compares a customer object passed as a parameter to itself (customer object)
// are same using their total costs.
public Customer hasMore(Customer other)
  {
		 if (totalCost >= other.totalCost)
		   return this;
		 else
		   return other;
	  }

// This method returns a string containing a customer's initials
// (first characters of firstName and lastName.)
public String toString()
	  {
		   String result = firstName.charAt(0) + "." + lastName.charAt(0) + ".";
		   return result;
	  }


} // end of the class Customer

