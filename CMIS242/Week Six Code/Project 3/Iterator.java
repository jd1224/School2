
public class Iterator{

	private int count =0;
	private int methodCall = 0;
	private int loops = 0;
	
	public int recursiveIterator(int prev2, int prev, int end){
		
		
		//System.out.print(count+"|"+prev2+"\n");
		if(count==end){
			return prev2;
		}else{
			count++;
			methodCall++;
			int num=prev2+(2*prev);
			return(recursiveIterator(prev,num,end));
		}
	}
	
	public int iterativeIterator(int prev, int prev2, int end){
		int num=0;
		int first = prev2;
		int second = prev;
		for(int i=0;i<end;i++){
			//System.out.print(count+"|"+num+"\n");
			num=second*2+first;
			first = second;
			second = num;
			count++;
			loops++;
		}
		return num;
	}
	
	public int getMethodCall(){
		return methodCall;
	}
	
	public int getLoops(){
		return loops;
	}

}