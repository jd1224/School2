package quizMaker;
import java.util.*;

public class ChoiceQuestion extends Question {
	private ArrayList<String> letters = new ArrayList<String>();
	private ArrayList<String> choices = new ArrayList<String>();
	private String alpha = "abcdefghijklmnopqrstuvwxyz";
	private int choiceNumber =0;
	
	public ChoiceQuestion(String question, String answer) {
		this.setAnswer(answer);
		this.setQuestion(question);
	}
	
	public ChoiceQuestion() {
		this.setAnswer("");
		this.setQuestion("");
	}

	@Override
	public void display() {
		
		super.display();
		for (int i =0;i<choices.size();i++) {
			System.out.print(letters.get(i)+". ");
			System.out.println(choices.get(i));
		}
	}
	public void addChoice(String choice) {
		choices.add(choice);
		letters.add(alpha.substring(choiceNumber, choiceNumber+1));
		choiceNumber++;
	}
	
	public boolean checkAnswer(String guess) {
		
		int index = letters.indexOf(guess.toLowerCase());
		if(choices.get(index).equals(this.getAnswer())) {
			return true;
		}else {return false;} 
		
	}
	
	public void addChoices() {
		boolean choosing = true;
		Scanner sc = new Scanner(System.in);
		while (choosing) {
			System.out.println("Enter a choice, or \"ZONK\" to quit.");
			String choice = sc.nextLine();
			if (choice.equals("ZONK")) {
				choosing = false;
			}else {
				choices.add(choice);
			}
		}
		sc.close();
	}
}
