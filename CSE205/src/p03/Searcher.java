//********************************************************************************************************
// CLASS: Searcher (Searcher.java)
//
// COURSE AND PROJECT INFO
// Program to read, display, and write a gradebook file using a GUI
// CSE205 Object Oriented Programming and Data Structures, Fall B 2017
// Project Number: 03
//
// AUTHOR
// Joshua Coe(jcoe4@asu.edu)
//********************************************************************************************************
package p03;

import java.util.ArrayList;
/**
 * implements binary search to find the requested name in the list
 *returns -1 if the item is not present
 */
public class Searcher {
		 
	    public static int search(ArrayList<Student> names, String key) {
	    
	    int first = 0;
	    int last  = names.size();
	 
	    while (first < last) {
	        int mid = first + ((last - first) / 2);
	        if (key.compareTo(names.get(mid).getLastName()) < 0) {
	            last = mid;
	        } else if (key.compareTo(names.get(mid).getLastName()) > 0) {
	            first = mid + 1;
	        } else {
	            return mid;
	        }
	    }
	    return -1;
	}
	    
}
