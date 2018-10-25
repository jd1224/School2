
public class Numbers{

	private Object[] array;
	private int size;
	
	public Numbers(int i){
		
		array = new Object[i];
		size = 0;
	}
	
	public void add(Object i){
		try{
			array[size++] = i;
		}catch (IndexOutOfBoundsException ex1){
			System.out.println("Index Out of Bounds");
		}
	}
	
	public void drop(int i){
		try{
			array[i] = null;
		}catch (IndexOutOfBoundsException ex1){
			System.out.println("Index Out of Bounds");
		}
	}
	
	public Object get(int i) throws IndexOutOfBoundsException{
			return array[i];
	}
	
	public int getSize(){
		return size;
	}
}