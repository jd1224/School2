package SourceCodePull;
//**************************************************************************************************
// CLASS: Cat (Cat.java)
//
// DESCRIPTION
// This is the Cat class for the interface example in "Interfaces: Section 6".
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
 * Cat is a subclass of Mammal, i.e., a Cat "is a" Mammal. Note that since Mammal implements the
 * MakesNoise interface, so does Cat by extension. This means that Cat must implement the MakesNoise
 * interface by providing an implementation of the makeNoise() method. Furthermore, Cat is overriding
 * makeNoise() inherited from Mammal so we use the @Override annotation to inform the compiler of
 * that fact (so as to avoid accidental overloading).
 */
public class Cat extends Mammal {
    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }
}
