//Student.java class used to create student objects
class Student{
	
	//Class variable to count the current number of students
	private static int numStudents = 0;
	
	//instance variable for name of student
	private String name;
	
	//constructor to set name and increment numStudents
	public Student(String name){
		
		this.name = name;
		numStudents ++;
		
	}
	
	//Class method to decrement numStudents when needed
	public static void removeStudent(){
		numStudents --;
	}
	
	public String getName(){return name;}
}