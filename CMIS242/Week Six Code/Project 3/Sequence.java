/************************************************************
*Class View.java
*Author: Joshua Coe, JCoe9@umuc.edu
*Date: 30 September 2018
*Description: Abstract utility class to perform all of the
*calculations necessary to complete the operations specified
*in the documentation
*/
//abstract as it will not be instantiated and contains only static
//variables and methods
public abstract class Sequence{

	private static int count = 0;
	//iterative compute which resets count to 0 at the beginning for efficiency
	public static long computeIterative(int n){
		//Throw a new error if the number is too large or negative
		if(n>130||n<0){
			throw new NumberFormatException("Too Large");
		}
		count = 0;
		long num=0;
		long first = 1;
		long second = 0;
		
		for(int i=0;i<n;i++){
			//System.out.print(count+"|"+num+"\n");
			num=second*2+first;
			first = second;
			second = num;
			count++;
		}
		return num;
	}
	//public recursive method calls getefficiency to reset count, then 
	//calls the method which actually conducts the recursive calculations
	public static long computeRecursive(int n){
		//Throw a new error if the number is too large or negative
		if(n>130||n<0){
			throw new NumberFormatException("Too Large");
		}
		getEfficiency();
		return innerRecursive(0,1,n);
		
	}
	//performs the recursive calculations
	private static long innerRecursive(long prev2, long prev, int n){
			if(count==n){
				return prev2;
			}else{
				count++;
				long num=prev2+(2*prev);
				return(innerRecursive(prev,num,n));
			}
		}
		
	//gets the efficiency of the last running method and sets the count back to 0
	public static int getEfficiency(){
		int out = count;
		count = 0;
		return out;
	}

}