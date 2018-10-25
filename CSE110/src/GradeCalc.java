
public class GradeCalc {

	
	public static void main(String[] args) {
		
		double assignment = .30*(120/120.0);
		double midTerms = .20*(189.0/200.0);
		double finalExam = .20*(95.0/100.0);
		double quiz = .15*(60.0/68.0);
		double lab = .15*(80.0/80.0);
		
		double total = assignment+midTerms+quiz+lab+finalExam;
		System.out.println(total);
	}
	
}
