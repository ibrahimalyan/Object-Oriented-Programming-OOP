

public class MultipleChoiceQuestion extends Question {
	protected String[] answers  = new String [6];
	protected int  numberOfAnswers;
	protected int correctAnswerIndex;

	public MultipleChoiceQuestion (String qText, String correctAnswer )  {
		super(qText);
		correctAnswerIndex = 0;
		numberOfAnswers = 1;
		this.answers[correctAnswerIndex] = correctAnswer;
		
	}
	
	public String toString (){
		String result = qText;
		for(int i =0 ; i < numberOfAnswers ; i++) {
			result = result + "\n" + answers[i];
			
		}
		return result;
		
	}
	public String getCorrectAnswer() {
		
		return this.answers[correctAnswerIndex];
	}

	
	public void addCorrectAnswer(String answer) {
		
		if (numberOfAnswers >= 6) {
			return;
		}
		
		answers[numberOfAnswers] = answer;
		correctAnswerIndex = numberOfAnswers;
		numberOfAnswers ++;
		

	}
	public void addAnswer(String answer) {
		
		if (numberOfAnswers >= 6) {
			return;
		}
		
		answers[numberOfAnswers] = answer;
		numberOfAnswers ++;
		
	}

}
