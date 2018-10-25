import java.util.Scanner;
import java.util.InputMismatchException;
public class Counter{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive integer and I will add all numbers from 1 to it: ");
		try{
			int in = sc.nextInt();
			System.out.println("The recursive method returns: "+recursiveCount(in));
			System.out.println("The iterative method returns: "+iterativeCount(in));
			System.out.println("Gauss' method returns: "+gaussCount(in));
		}catch(InputMismatchException ex1){
			System.out.println("Failed to compute. Next time enter an integer.");
		}catch(NumberFormatException ex2){
			System.out.println("Failed to compute. Next time enter a positive integer.");
		}
	}
	private static int recursiveCount(int in){
		if(in<0){
			throw new NumberFormatException("Negative Integer.");
		}
		if(in==0){
			return 0;
		}else{
			return(in+recursiveCount(in-1));
		}
	}
	private static int iterativeCount(int in){
		if(in<0){
			throw new NumberFormatException("Negative Integer.");
		}
		int count = 0;
		for(int i=1;i<=in;i++){
			count+=i;
		}
		return count;
	}
	private static int gaussCount(int in){
		if(in<0){
			throw new NumberFormatException("Negative Integer.");
		}
		return (in*(in+1))/2;
	}
}