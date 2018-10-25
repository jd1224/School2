package SourceCodePull;
//**************************************************************************************************

// CLASS: Main (Main.java)
//
// DESCRIPTION
// This is the Main (test) class for the interface example in "Interfaces: Section 6".
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science and Engineering
// Fulton Schools of Engineering
// Arizona State University
// Tempe, AZ 85287-8809
// http://www.devlang.com
//Ammended by:
//Joshua Coe
//CSE 205 Fall B 2017
//**************************************************************************************************
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        // Create an ArrayList named critters where each element of critters is an object that
        // implements the MakeNoise interface.
        ArrayList<MakesNoise> critters = new ArrayList<>();

        // Add several objects of different classes to critters. Any object added to critters
        // must be an object of a class that implements MakesNoise. If not, you will get a syntax
        // error.
        critters.add(new Dog());
        critters.add(new Cat());
        critters.add(new Cricket());
        critters.add(new Cat());
        critters.add(new Cricket());
        critters.add(new Bee());
        critters.add(new Frog());
        someMethod(critters);
    }

    public void someMethod(ArrayList<MakesNoise> pCritters) {
        // Iterate over the elements of pCritters calling makeNoise() which is the only abstract
        // method in the MakesNoise interface. Note that this is a polymorphic method call because
        // the makeNoise() method that gets called depends on the actual object type of the element.
        // That is, when critter is a Dog, we will call Dog.makeNoise(). When critter is a Cat, we
        // will call Cat.makeNoise().
        for (MakesNoise critter : pCritters) {
            critter.makeNoise();
        }
    }
}
