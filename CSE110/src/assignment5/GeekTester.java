package assignment5;

public class GeekTester {
	
	public static void main(String[] args) {
		
		Geek myGeek = new Geek("Geek", 0);
		
		System.out.println(myGeek.getName());
		System.out.println("expected myGeek\n");
		System.out.println(myGeek.getNumberOfQuestions());
		System.out.println("expected 0\n");
		System.out.println(myGeek.isEven(2, 3));
		System.out.println("expected false\n");
		System.out.println(myGeek.isEven(2, 2));
		System.out.println("expected true\n");
		System.out.println(myGeek.getNumberOfQuestions());
		System.out.println("expected 2\n");
		System.out.println(myGeek.sum(1, 10));
		System.out.println("expected 55\n");
		System.out.println(myGeek.sum(10, 1));
		System.out.println("expected 55\n");
		System.out.println(myGeek.sum(10, 10));
		System.out.println("expected 10\n");
		System.out.println(myGeek.sum(-2, 2));
		System.out.println("expected 0\n");		
		System.out.println("num?"+myGeek.getNumberOfQuestions());
		System.out.println("expected 6\n");
		System.out.println(myGeek.isLeapYear(1580));
		System.out.println("expected true\n");
		System.out.println(myGeek.isLeapYear(1582));
		System.out.println("expected false\n");
		System.out.println(myGeek.isLeapYear(2000));
		System.out.println("expected true\n");
		System.out.println(myGeek.isLeapYear(1900));
		System.out.println("expected false\n");
		System.out.println("num?"+myGeek.getNumberOfQuestions());
		System.out.println("expected 10");
	}

}
