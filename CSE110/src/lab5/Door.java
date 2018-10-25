/*-------------------------------------------------------------------------
// AUTHOR: Joshua Coe
// FILENAME: Door.java
// SPECIFICATION: Create the door class with encapsulate variables.
// FOR: CSE 110- Lab #5
// TIME SPENT: 45 minutes
//-----------------------------------------------------------*/

package lab5;

public class Door {
	
	private String name;
	private String state;
	/**
	   Constructor for the Door class
	   @param nameInit sets name of instance
	   @param stateInit sets state of instance
	 */
	public Door(String nameInit, String stateInit) {
		name = nameInit;
		state = stateInit;
	}
	
	/**
	  returns the name of the door
	 */
	public String getName() {
		return name;
	}
	/**
	   sets the name of the door
	   @param newName sets name of instance
	 */
	public void setName(String newName) {
		name = newName;
	}
	/**
	   returns the state
	 */
	public String getState() {
		return state;
	}
	/**
	   sets the state of the door to an input string
	   @param newState sets state of instance
	 */
	public void setState(String newState) {
		state = newState;
	}
	/**
	   sets state to "open"
	 */
	public void open() {
		state = "open";
	}
	/**
	   sets state to "closed"
	 */
	public void closed() {
		state = "closed";
	}

}
