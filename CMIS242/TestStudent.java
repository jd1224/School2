//TestStudent.java
import java.util.ArrayList;

class TestStudent{
	
	public static void main(String[] args){
		
		//create ArrayLists for grade books
		ArrayList<Student> CMIS242FallA = new ArrayList<>();
		ArrayList<Student> CMIS242FallB = new ArrayList<>();
		ArrayList<Student> CMIS242FallC = new ArrayList<>();
		ArrayList<Student> CMIS242FallD = new ArrayList<>();
		ArrayList<Student> CMIS242FallE = new ArrayList<>();
		ArrayList<Student> CMIS242FallF = new ArrayList<>();
		
		//fill ArrayLists with students
		for (int i=0;i<25;i++){CMIS242FallA.add(new Student("Name"));}
		for (int i=0;i<25;i++){CMIS242FallB.add(new Student("Name"));}
		for (int i=0;i<25;i++){CMIS242FallC.add(new Student("Name"));}
		for (int i=0;i<25;i++){CMIS242FallD.add(new Student("Name"));}
		for (int i=0;i<25;i++){CMIS242FallE.add(new Student("Name"));}
		for (int i=0;i<25;i++){CMIS242FallF.add(new Student("Name"));}
		
		//This totals the lists then prints the total number of students
		int listTotals = (CMIS242FallA.size()+CMIS242FallB.size()+
						CMIS242FallC.size()+CMIS242FallD.size()+
						CMIS242FallE.size()+CMIS242FallF.size());
		
		System.out.println(listTotals);
		
		//this single line replaces the preceding code to total the lists
		//then print the number of students
		System.out.println(Student.numStudents);
		
		removeStudent(CMIS242FallA, 1);
		System.out.println(Student.numStudents);
	}
	
	private static void removeStudent(ArrayList list, int index){
		
		list.remove(index);
		Student.removeStudent();
		
	}
}