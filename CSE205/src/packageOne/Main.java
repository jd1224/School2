package packageOne;
//********************************************************************************************************
//CLASS: Main.java
//
//DESCRIPTION
//A program to count the runs in a given text file; runs are defined as sets of integers either increasing or decreasing in size
//over three or more places in the list
//
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, FallB 2017
//Project Number: Project 1
//
//AUTHOR
//Joshua Coe, jcoe4@asu.edu
//********************************************************************************************************
import java.util.*;
import java.io.*;
public class Main {
/**
 * instantiates an object of main and runs it
 * @param args
 */
	public static void main(String[] args) {
		
		Main mainObject= new Main();
		mainObject.run();
		
	}//end main
	/**
	 * organizes the methods of the class into a method that runs them in the correct order to 
	 * return a list of runs
	 * handles exceptions that may arise in the program
	 */
	private void run() {
		
		//Scanner sc = new Scanner(System.in);
		//System.out.print("Input File: ");//get the input file name (lines commented to fit specs un-comment to allow user input)
		String fileName = "p01-in.txt";//sc.next();
		File in = new File(fileName);//create a file object
		//sc.close();//close the resource
		int sum = 0;
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		
		try {//try these steps
			ArrayList<Integer> start = readIn(in);//could throw FileNotFoundException if file is not present or cannot be read
			ArrayList<Integer> upRuns = runs("up", start);//count the positive runs
			ArrayList<Integer> downRuns = runs("down", start);//count the negative runs
			outputList = merge(upRuns, downRuns);//merge the two lists into one
			sum = sum(outputList);//get the total of all runs regardless of size
		}
		catch (FileNotFoundException ex) {//catch the exception and terminate the program
			System.out.println("That file could not be opened.");
			System.exit(-1);
		}//end try/catch
		
		try {//attempt to write the output to file
			writeFile("p01-runs.txt", sum, outputList);
		}
		catch (FileNotFoundException ex) {//catch exception if the file cannot be created
			System.out.println("That file could not be accessed or created.");
			System.exit(-1);
		}
		catch (SecurityException ex) {//catch exception if the file or directory are write protected
			System.out.println("Write Access Denied.");
			System.exit(-1);
		}//end try/catch
	}//end run method
	/**
	 * reads in a file with integers and returns it as an ArrayList<Integer
	 * @param input file to be read
	 * @return ArrayList<Integer> of values from the file
	 * @throws FileNotFoundException if file is not present
	 */
	private ArrayList<Integer> readIn(File input) throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(input);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		while(fileIn.hasNextInt()) {
			intList.add(fileIn.nextInt());
		}
		fileIn.close();
		return intList;
	}//end readIn method
	/**
	 * returns an ArrayList<Integer> of the amount of runs of a given length in the arrayList<Integer> it receives
	 * @param choice "up" or "down" to count either positive runs(1,2,3) or negative runs(3,2,1)
	 * @param list ArrayList<Integer> to be parsed
	 * @return ArrayList<Integer> with count of runs of various lengths from 1 to the length of list
	 */
	private ArrayList<Integer> runs(String choice, ArrayList<Integer> list){
		
		ArrayList<Integer> outputList = new ArrayList<Integer>();//creates the output list and initializes it to all zeros in the length of the input list
		for(int i=0;i<list.size();i++) {
			outputList.add(0);
		}
		int k = 0;//count variable for both positive and negative runs
		if(choice.equals("up")) {//finds positive runs
			for(int i=0;i<list.size();i++) {
				while (i<list.size()-1&&list.get(i)<=list.get(i+1)) {
					i++;
					k++;
				}
				if(k!=0) {//if k is equal to zero do not add to the zero index/this will throw off the sum method					
					outputList.set(k, outputList.get(k)+1);
					k=0;
				}
			}
		}//end up
		else {//finds negative runs
			for(int i=0;i<list.size()-1;i++) {
				while(i<list.size()-1&&list.get(i)>=list.get(i+1)) {
					i++;
					k++;
				}
				if(k!=0) {
					outputList.set(k, outputList.get(k)+1);
					k=0;
				}
			}
		}//end down
		return outputList;
	}//end runs method
	/**
	 * merges two ArrayList<Integer> objects by adding each element to the other
	 * @param x first ArrayList<Integer>
	 * @param y second ArrayList<Integer>
	 * @return ArrayList<Integer> whose elements are the sum of each element of the two sources
	 */
	private ArrayList<Integer> merge(ArrayList<Integer> x, ArrayList<Integer> y){
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		for(int i =0; i<x.size();i++) {
			outputList.add(x.get(i)+y.get(i));
		}
		return outputList;
	}//end merge method
	/**
	 * find the sum of all elements in an ArrayList<Integer>
	 * @param list ArrayList<Integer> to be summed
	 * @return the total sum of the elements
	 */
	private int sum(ArrayList<Integer> list) {
		int sum = 0;
		for(Integer x : list) {
			sum+=x;
		}
		return sum;
	}//end sum method
	/**
	 * attempt to write the contents of an array to a specified file
	 * @param fileName the name of the file to write to or create
	 * @param sum the total of all elements of the ArrayList<Integer>
	 * @param list ArrayLisr<Integer> to be the source for the file
	 * @throws FileNotFoundException if file cannot be written to
	 * @throws SecurityException if security manager does not allow write access to the file
	 */
	private void writeFile(String fileName, int sum, ArrayList<Integer> list) throws FileNotFoundException, SecurityException{
		
		PrintWriter out = new PrintWriter(fileName);
		out.println("runs_total, "+sum);
		for(int i=1;i<list.size();i++) {
			out.println("runs_"+i+" "+list.get(i));
		}
		out.close();
	}//end writeFile
	
}//end class
