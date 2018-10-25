package SourceCodePull;
//**************************************************************************************************
// CLASS: Dog (Dog.java)
//
// DESCRIPTION
// This is the Dog class for the interface example in "Interfaces: Section 6".
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science and Engineering
// Fulton Schools of Engineering
// Arizona State University
// Tempe, AZ 85287-8809
// http://www.devlang.com
//**************************************************************************************************

/**
 * Dog is a subclass of Mammal, i.e., a Dog "is a" Mammal. Note that since Mammal implements the
 * MakesNoise interface, so does Dog by extension. This means that Dog must implement the MakesNoise
 * interface by providing an implementation of the makeNoise() method. Furthermore, Dog is overriding
 * makeNoise() inherited from Mammal so we use the @Override annotation to inform the compiler of
 * that fact (so as to avoid accidental overloading).
 */
public class Dog extends Mammal {
    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }
}
