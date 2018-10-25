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
public class ProjectOne {

	public static void main(String[] args) {
		
		ProjectOne mainObject= new ProjectOne();
		mainObject.run();
		
	}//end main
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input File: ");
		String fileName = sc.next();
		File in = new File(fileName);
		sc.close();
		int sum = 0;
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		
		try {
			ArrayList<Integer> start = readIn(in);
			ArrayList<Integer> upRuns = runs("up", start);
			ArrayList<Integer> downRuns = runs("down", start);
			outputList = merge(upRuns, downRuns);
			sum = sum(outputList);
		}
		catch (FileNotFoundException ex) {
			System.out.println("That file could not be opened.");
			System.exit(-1);
		}
		
		try {
			writeFile("p01-runs.txt", sum, outputList);
		}
		catch (FileNotFoundException ex) {
			System.out.println("That file could not be accessed or created.");
		}
		catch (SecurityException ex) {
			System.out.println("Write Access Denied.");
		}
	}//end run method
	
	private ArrayList<Integer> readIn(File input) throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(input);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		while(fileIn.hasNextInt()) {
			intList.add(fileIn.nextInt());
		}
		fileIn.close();
		return intList;
	}//end readIn method
	
	private ArrayList<Integer> runs(String choice, ArrayList<Integer> list){
		
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			outputList.add(0);
		}
		int k = 0;
		if(choice.equals("up")) {
			for(int i=0;i<list.size();i++) {
				//System.out.println("Trying "+list.get(i));
				while (i<list.size()-1&&list.get(i)<list.get(i+1)) {
					i++;
					k++;
				}
				if(k!=0) {					
					outputList.set(k, outputList.get(k)+1);
					k=0;
				}
			}
		}//end up
		else {
			for(int i=0;i<list.size()-1;i++) {
				while(i<list.size()-1&&list.get(i)>list.get(i+1)) {
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
	
	private ArrayList<Integer> merge(ArrayList<Integer> x, ArrayList<Integer> y){
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		for(int i =0; i<x.size();i++) {
			outputList.add(x.get(i)+y.get(i));
		}
		return outputList;
	}//end merge method
	
	private int sum(ArrayList<Integer> list) {
		int sum = 0;
		for(Integer x : list) {
			sum+=x;
		}
		return sum;
	}//end sum method
	
	private void writeFile(String fileName, int sum, ArrayList<Integer> list) throws FileNotFoundException, SecurityException{
		
		PrintWriter out = new PrintWriter(fileName);
		out.println("runs_total, "+sum);
		for(int i=1;i<list.size();i++) {
			out.println("runs_"+i+" "+list.get(i));
		}
		out.close();
	}
	
}
