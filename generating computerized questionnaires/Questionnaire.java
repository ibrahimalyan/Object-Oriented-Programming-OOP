

public class Questionnaire {
	
	private Question[] questions;
	private int q_index;
	private int correct_answers;
	
	public Questionnaire(int type, int num, QuestionsCatalog cat) {
		
		questions = cat.generateQuestionnaire(num, type);
		q_index = 0;
		correct_answers = 0;
		
	}


	public boolean hasNext() {
		
		if (q_index == questions.length) {
			return false;
		}
		return true;
		
	}
	
	public Question getNext() {
		
		Question q = questions[q_index];
		
		q_index ++;
		
		return q;
		
		
	}
	public void checkAnswer(String answer) {
		
		Question q = questions[q_index-1];
		
		if (q.getCorrectAnswer().equals(answer)) {
			correct_answers ++;
			
		}
		
		
	}
	
	public int getTotalQuestions() {
		
		return questions.length;
		
	}
	
	
	public int getCorrectAnswers() {
		
		return correct_answers;
		
		
	}
}
