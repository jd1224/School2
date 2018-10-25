package SourceCodePull;
//**************************************************************************************************
// CLASS: Mammal (Mammal.java)
//
// DESCRIPTION
// This is the Mammal class for the interface example in "Interfaces: Section 6".
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
 * Mammal is an abstract class that implements the MakesNoise interface. As an abstract class,
 * however, Mammal is not required to provide an implementation of the makeNoise() method because
 * the expectation is that the subclasses of Mammal will override makeNoise() and provide their
 * own specific implementation.
 */
public abstract class Mammal implements MakesNoise {
}
