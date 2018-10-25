package homeWorkOne;
import java.io.*;
import java.util.*;

public class FileCopy {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean done = false;
		
		while (!done) {
			
			System.out.print("Input File: ");
			String inFile = sc.next();
			try {
				String newName = copyFile(inFile);
				System.out.println("copying file...");
				System.out.println("File copied to: "+newName);
				done=true;
				
			}
			catch (FileNotFoundException exception) {
				System.out.println("Bad Input File Name. Please Try Again");
			}
		}
		
		sc.close();
	}
	
	public static String copyFile(String inFile)throws FileNotFoundException {
		
		File in = new File(inFile);
		Scanner input = new Scanner(in);
		PrintWriter output = new PrintWriter(inFile+".txt");
		int count =0;
		while (input.hasNextLine()) {
			output.printf("[%03d]", count);
			output.println(input.nextLine());
			count++;
		}
		
		input.close();
		output.close();
		
		return (inFile+".txt");
	}
	
}
