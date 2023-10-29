

public class QuestionsCatalog {
	public  Question[] questions = new  Question[20] ;
	public static final int SHORT = 1, MULTIPLE = 2, BOTH = 3;
	private int numberOfQuestions;
	
	public  QuestionsCatalog() {
		numberOfQuestions=0;
	}
	
	public void addQuestion(Question q) {
		
		questions[numberOfQuestions] = q;
		numberOfQuestions ++;
		
	}
	
	public Question[] generateQuestionnaire(int num, int type) {
		
		int count = 0;
		
        for (int i = 0 ; i < numberOfQuestions ; i ++) {
	
			int type_of_q = SHORT;
			if (questions[i] instanceof MultipleChoiceQuestion) {
				type_of_q = MULTIPLE;
			}
			if (type == 1 || type == 2) {
				if (type_of_q == type) {
					count ++;
				}
			}else {
				count ++;
			}
			
		}
		
		Question[] result = new Question[count];
		
		int res_i = 0;
		
		for (int i = 0 ; i < numberOfQuestions ; i ++) {
			
			
			int type_of_q = SHORT;
			if (questions[i] instanceof MultipleChoiceQuestion) {
				type_of_q = MULTIPLE;
			}
			if (type != BOTH ) {
				if (type_of_q == type) {
					result[res_i] = questions[i];
					res_i ++;
				}
			}else {
				result[res_i] = questions[i];
				res_i ++;
			}
			
		}
		
		return result;
		
		
		
	}
	
	
	
}
