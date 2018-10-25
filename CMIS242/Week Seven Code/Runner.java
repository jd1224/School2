import java.util.ArrayList;

public class Runner{

	public static void main(String[] args){
		
		ArrayList<Integer> numberList = new ArrayList<>();
		
		//numberList.add("1");
		//class would not compile with the previous input because of a 
		//type mis-match
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);
		
		for (int i= numberList.size();i>=0;i--){
			try{
				System.out.println((int)numberList.get(i));
			}catch (IndexOutOfBoundsException ex1){
				System.out.println("Failed");	
			}
		}
		
		Numbers number = new Numbers(3);
		//this code compiles because a String is a sub-class
		//of Object and is allowed in the Numbers object
		number.add("1");
		number.add(2);
		number.add(3);
		number.add(4);
		
		for (int i= number.getSize();i>=0;i--){
			try{
				System.out.println((int)number.get(i));
			}catch (IndexOutOfBoundsException ex1){
				System.out.println("Failed");	
			}
		}
	}

}