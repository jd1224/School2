package lab6;
/**
/*-------------------------------------------------------------------------
// AUTHOR: Joshua Coe/copied from Lab6 instructions
// FILENAME: SuperHero.java
// SPECIFICATION: Super Hero Class with relevant instance variables and methods
// FOR: CSE 110- Lab #6
// TIME SPENT: 45 minutes
//-----------------------------------------------------------*/ 

import java.util.Scanner;

/**
 * designs a class for super heroes
 * @author j
 *
 */
public class SuperHero {
	
	private static int numberOfHeroes;
	private String heroName, secretIdentity;
	private int numberOfLifeChances, numberOfPeopleSaved;
	
	/**
	 * constructor for SuperHero object
	 * @param initHeroName-String to set hero name
	 * @param initSecretIdentity- String to set hero secret identity
	 * @param initPeopleSaved- int to set number of people hero has saved
	 * increments static variable number of heroes by 1
	 * sets number of lives to 2
	 * 
	 */	
	public SuperHero(String initHeroName, String initSecretIdentity, int initPeopleSaved) {
		numberOfHeroes++; // one more hero created
		numberOfLifeChances = 2; // start the hero with two lives
		heroName = initHeroName;
		secretIdentity = initSecretIdentity;
		numberOfPeopleSaved = initPeopleSaved;
		}
	
	/**
	 * constructor for SuperHero object
	 * @param initHeroName- String to set hero name
	 * sets secret identity to unknown and people saved to 0
	 * increments static variable number of heroes by 1
	 * sets number of lives to 2
	 */
	public SuperHero(String initHeroName) {
		numberOfHeroes++;
		numberOfLifeChances=2;
		heroName=initHeroName;
		secretIdentity="unknown";
		numberOfPeopleSaved=0;
	}
	
	/**
	 * gets the number of heroes created
	 * @return int- number of hero objects created(Static)
	 */
	public static int getNumberOfHeroes() {
		return numberOfHeroes;
	}
	
	/**
	 * add a save to the save counter
	 * @param num- number of saves to add to the save counter
	 */
	public void recordSave(int num) {
		numberOfPeopleSaved+=num;
	}
	
	/**
	 * add one save to the save counter
	 */
	public void recordSave() {
		numberOfPeopleSaved+=1;
	}
	
	/**
	 * decrements lives by 1, if last life lost, prints death statement
	 */
	public void killHero() {
		if (numberOfLifeChances>=1) {
			numberOfLifeChances-=1;			
		}else {
			System.out.println(heroName+" is Dead!");	
		}
	}
	
	/**
	 * returns a record of the object
	 */
	public void printSuperHeroRecord() {
		String isAlive="Alive";
		if (numberOfLifeChances<1) {
			isAlive="Dead";
		}
		System.out.print( "Name: "+heroName+
				"\nSecret Identity: "+secretIdentity+
				"\nStatus: "+isAlive+
				"\nPeople Saved: "+numberOfPeopleSaved);
	}
}