

public class ShortAnswerQuestion extends Question {
	protected String answer;
	
	
	public ShortAnswerQuestion(String qText, String answer	) {
		super(qText);
		this.answer = answer;
	}

	
	public String getCorrectAnswer() {
		
		return answer;
	}

	
	public void addCorrectAnswer(String answer) {
	this.answer = answer;

	}

}
