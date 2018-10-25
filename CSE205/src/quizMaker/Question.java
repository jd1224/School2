package quizMaker;

public class Question {

	private String question, answer;

	public String getQuestion() {
		return question;
	}

	public Question() {
		question ="";
		answer = "";
	}
	
	public Question(String question, String answer) {
		this.question=question;
		this.answer=answer;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void display() {
		System.out.println(question);
	}
	
	public String toString() {
		
		return question;
	}
	
	public boolean equals(Question toCompare) {
		
		if (question.equalsIgnoreCase(toCompare.question)) {
			return true;
		}else {return false;}
	}
	
	public boolean checkAnswer(String guess) {
		if(guess.equalsIgnoreCase(answer)) {
			return true;
		}else {return false;}
	}
	
}
