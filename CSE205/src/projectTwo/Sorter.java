package projectTwo;
//**************************************************************************************************************

// CLASS: Sorter
//
// DESCRIPTION
// Implements the insertion sort algorithm to sort an ArrayList<> of Students.
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http:www.devlang.com
//**************************************************************************************************************
//package tuition;

import java.util.ArrayList;

public class Sorter {

    public static final int SORT_ASCENDING  = 0;
    public static final int SORT_DESCENDING = 1;

    /**
     *  Sorts pList into ascending (pOrder = SORT_ASCENDING) or descending (pOrder = SORT_DESCENDING) order
     *  using the insertion sort algorithm.
     */
    public static void insertionSort(ArrayList<Student> pList, int pOrder) {
        for (int i = 1; i < pList.size(); ++i) {
            for (int j = i; keepMoving(pList, j, pOrder); --j) {
                swap(pList, j, j - 1);
            }
        }
    }

    /**
     *  Returns true if we need to continue moving the element at pIndex until it reaches its proper location.
     */
    private static boolean keepMoving(ArrayList<Student> pList, int pIndex, int pOrder) {
        if (pIndex < 1) return false;
        Student after = pList.get(pIndex);
        Student before = pList.get(pIndex - 1);
        return (pOrder == SORT_ASCENDING) ? after.compareTo(before) < 0 : after.compareTo(before) > 0;
    }

    /**
     *  Swaps the elements in pList at pIndex1 and pIndex2.
     */
    private static void swap(ArrayList<Student> pList, int pIndex1, int pIndex2) {
        Student temp = pList.get(pIndex1);
        pList.set(pIndex1, pList.get(pIndex2));
        pList.set(pIndex2, temp);
    }

}
