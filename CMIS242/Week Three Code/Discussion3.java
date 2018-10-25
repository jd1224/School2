import java.util.Scanner;

public class Discussion3{
	
	public static void main(String[] args){
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		while (running){
			String choice;
			try{
				System.out.print("Please enter and Integer and I will reverse it: ");
				choice = sc.next();
				System.out.println(choice+" Reversed is "+reverse(choice));
				running = false;
			}catch (NumberFormatException ex){
				System.out.println("I said an Integer only!");
			}
		}		
	}//end main
	
	/**
	 *Static method to reverse an integer
	 *@param orig String input of an integer to be revrsed
	 *@return int the reveserd integer
	 *@throws NumberFormatException if the String does not contain and integer
	 */
	private static int reverse(String origString) throws NumberFormatException{
		//attempt to parse and integer from the parameter
		int orig = Integer.parseInt(origString);
		int reversed=0;
		//reverse the integer
		while(orig>0){
			reversed*=10;
			reversed+=orig%10;
			orig/=10;
		}
		return reversed;
	}//end revese
}//end class