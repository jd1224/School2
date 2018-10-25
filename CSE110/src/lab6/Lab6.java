package lab6;
/**
/**
/*-------------------------------------------------------------------------
// AUTHOR:Instructor published code from Lab6/Joshua Coe
// FILENAME: Lab6.java
// SPECIFICATION: Test the SuperHero class
// FOR: CSE 110- Lab #6
// TIME SPENT: 45 minutes
//-----------------------------------------------------------*/ 
import java.util.Scanner;//import package for Scanner class

public class Lab6 {
	
	public static void main(String[] args) {
		// Create a Scanner object for later use
		Scanner scan = new Scanner(System.in);//instantiate an object of type Sanner named scan
		
		// Create a superhero called Spider-Man
		System.out.println("Creating Spider-Man.......");
		
		SuperHero spiderman = new SuperHero("Spider-Man");//instantiate an object of type SuperHero named Spider-Man
		
		// Ask the user to enter a superhero name
		System.out.println("\nWhat is the name of your superhero?");
		String heroName = scan.nextLine(); // This is line 10 reads input and stores to variable
		
		System.out.println("What is his secret identity?");
		String identity = scan.nextLine();//read input and stor to variable
		
		System.out.println("Creating your super hero.......");
		SuperHero yourHero = new SuperHero(heroName, identity, 10);//instantiate an object of type SuperHero named yourHero
		
		System.out.println("\nSpider-Man just saved 100 lives!");
		spiderman.recordSave(100);//increase object's saves by 100
		
		System.out.println("Oops, Spider-Man was shot dead twice!");
		spiderman.killHero();//decrement lives by 1; 1 remaining
		spiderman.killHero();//decrement lives by 1; hero is dead
		
		System.out.print("\nYour hero saved a kidnapped kid ");
		System.out.println("but was shot once");
		yourHero.killHero();//decrement lives of object by 1;1 remaining
		yourHero.recordSave();//add 1 save to object
		
		System.out.println("\n---- Superhero information ----");
		int numHeroes = SuperHero.getNumberOfHeroes();//creates a local variable and stores the value from SuperHero in it
		System.out.println("There are " + numHeroes + " known superheroes.");
		
		spiderman.printSuperHeroRecord();//print objects record using method from class SuperHero
		
		System.out.println();
		yourHero.printSuperHeroRecord();//print objects record using method from Class SuperHero
		
	}

}
