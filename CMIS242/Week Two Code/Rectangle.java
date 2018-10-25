
public class Rectangle{

	//instance variable for length and width
	private int length, width;
	
	//constructor to set length and width
	public Rectangle(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	//overridden toString method
	public String toString(){
		//pull the class of the object to use in the String
		String tClass = this.getClass().toString().substring(6);
		
		//return the object type and area with length and width variables
		return "The area of this "+tClass+" object is: "+this.area()+
				"\nLength: "+this.length+
				"\nWidth: "+this.width;
	}
	
	//helper to get the area of the shape
	private int area(){
		return this.length * this.width;
	}


}