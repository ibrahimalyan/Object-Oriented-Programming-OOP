

public abstract class  Question {
	protected String qText ;
	
	public Question(String qText) {
		this.qText = qText;
	}

	public void setqText(String qText) {
		this.qText = qText;
	}
    
	public String toString() {
		return qText;
		
	}
	

    public abstract String getCorrectAnswer();
    public abstract void addCorrectAnswer(String answer);

	
	
}
