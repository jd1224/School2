import javax.swing.*;
public class GradeCalc  {

	public static void main(String[] args){
		GradeCalc calc = new GradeCalc();
		calc.run();
	}
	
	public void run()  {
		
		
		int hw1, hw2, hw4, proj1, proj2, proj3, midTerm, finalExam;
		hw1=100;
		hw2=100;
		hw4=100;
		proj1=100;
		proj2=100;
		proj3=100;
		midTerm=100;
		finalExam=0;
		for(int i=0;i<11;i++) {
			double finalGrade = (.10*hw1)+(.10*hw2)+(.10*hw4)+(.10*proj1)+(.10*proj2)+(.10*proj3)+(.20*midTerm)+(.20*(i*10));
			JOptionPane.showMessageDialog(null, "With a grade on the final exam of "+i*10+"% your final grade is "+finalGrade+"%");
		}
	}
}
