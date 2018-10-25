import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumbers{
	
	private ArrayList<String> names;
	private int[] numbers;
	
	public PhoneNumbers(){
		names = new ArrayList<String>();
		numbers = new int[30];
	}
	
	public int entry(String name){
		if (name.equalsIgnoreCase("quit")){
			return -2;
		}
		if(checkSize()){
			if(checkName(name)){
				return numbers[names.indexOf(name)];
			}else{
				names.add(name);
				return names.indexOf(name);
			}
		}else{
			if(checkName(name)){
				return numbers[names.indexOf(name)];
			}else{
				return -1;
			}
		}
	}

	private	
	
	private boolean checkSize(){
		return names.size()<=30;
	}
	
	private boolean checkName(String name){
		return names.contains(name);
	}
	
	public static void main(String[] args){
		PhoneNumbers book = new PhoneNumbers();
		System.out.println("Phone Book");
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while (running){
			System.out.print("Enter a name: ");
			String name = sc.next();
			int result = book.entry(name);
			
			if (result == -2){
				System.exit(0);
			}else if (result == -1){
				System.out.print("Enter a phone number in the format 1234567890: ");
				try{
					
				}
			}
			
		}
	}
}