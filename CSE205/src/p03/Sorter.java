//********************************************************************************************************
// CLASS: Sorter (Sorter.java)
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
 * class to sort ArrayList<Student>
 *
 */
public abstract class Sorter {
	/**
	 * public interface method for this class
	 * @param pList ArrayList<Student> to sort
	 */
	public static void sort(ArrayList<Student> pList) {
		quickSort(pList, 0, pList.size()-1);
	}
	/**
	 * Recursive implementation of quickSort algorithm returns a list sorted in ascending order
	 * lexicographically, by last name
	 * @param pList list to be sorted
	 * @param pFromIdx Index to begin with
	 * @param pToIdx index to end with
	 */
	private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
		
		if(pFromIdx>=pToIdx) {
			return;
		}
		
		int p=partition(pList,pFromIdx,pToIdx);
		quickSort(pList,pFromIdx,p);
		quickSort(pList,p+1,pToIdx);
	}
	/**
	 * helper method to partition a list in two based on a pivot point in the center
	 * @param pList list to be sorted
	 * @param pFromIdx index to begin from
	 * @param pToIdx index to end at
	 * @return int index where the pivot point ends up
	 */
	private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
		Student pivot = pList.get(pFromIdx);
		int i = pFromIdx-1;
		int j = pToIdx+1;
		while(i<j) {
			i++;while (pList.get(i).compareTo(pivot)<0) {i++;}
			j--;while (pList.get(j).compareTo(pivot)>0) {j--;}
			if(i<j) {swap(pList,i,j);}
			
		}
		return j;
	}
	/**
	 * helper method to swap two items in an ArrayList<Student>
	 * @param pList list to swap items in
	 * @param pIdx1 first item
	 * @param pIdx2 second item
	 */
	private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
		Student temp = pList.get(pIdx2);
		pList.set(pIdx2, pList.get(pIdx1));
		pList.set(pIdx1, temp);
		//System.out.println("swap "+pList.get(pIdx2)+" for "+pList.get(pIdx1));
	}
}
