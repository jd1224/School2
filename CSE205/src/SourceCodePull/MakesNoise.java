package SourceCodePull;
//**************************************************************************************************
// INTERFACE: MakesNoise (MakesNoise.java)
//
// DESCRIPTION
// This is the MakesNoise interface for the interface example in "Interfaces: Section 6".
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
 * MakesNoise is an interface that contains one public method: makeNoise(). Any class that
 * implements this interface must provide an implementation of makeNoise() that is specific to that
 * class (except for abstract classes which can implement an interface, but are not required to
 * provide actual implementations of the interface's abstract methods.
 */
public interface MakesNoise {
    void makeNoise();
}
