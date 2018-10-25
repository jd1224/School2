package SourceCodePull;
//**************************************************************************************************
// CLASS: Cricket (Cricket.java)
//
// DESCRIPTION
// This is the Cricket class for the interface example in "Interfaces: Section 6".
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
 * Cricket is a subclass of Insect, i.e., a Cricket "is a" Insect. Note that since Insect implements
 * the MakesNoise interface, so does Cricket by extension. This means that Cricket must implement
 * the MakesNoise interface by providing an implementation of the makeNoise() method. Furthermore,
 * Cricket is overriding makeNoise() inherited from Insect so we use the @Override annotation to
 * inform the compiler of
 * that fact (so as to avoid accidental overloading).
 */
public class Cricket extends Insect {
    @Override
    public void makeNoise() {
        System.out.println("Chirp");
    }
}
