package SourceCodePull;
//**************************************************************************************************
// CLASS: Insect (Insect.java)
//
// DESCRIPTION
// This is the Insect class for the interface example in "Interfaces: Section 6".
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
 * Insect is an abstract class that implements the MakesNoise interface. As an abstract class,
 * however, Insect is not required to provide an implementation of the makeNoise() method because
 * the expectation is that the subclasses of Insect will override makeNoise() and provide their
 * own specific implementation.
 */
public abstract class Insect implements MakesNoise {
}
