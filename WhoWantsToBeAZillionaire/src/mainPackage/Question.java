package mainPackage;

public class Question {

	private String questionText;
	private String answerOne;
	private String answerTwo;
	private String answerThree;
	private String answerFour;
	private String correctAnswer;
	private boolean beenShown;

	/** 
	 * Empty constructor for Question
	 * so I can enter empty questions when 
	 * needed and set data later.
	 */
	public Question() {
	}

	/**
	 * Simple getters and setters for each
	 * variable in the class
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}

	public void setAnswerFour(String answerFour) {
		this.answerFour = answerFour;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public void setBeenShown(boolean beenShown) {
		this.beenShown = beenShown;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getAnswerOne() {
		return answerOne;
	}

	public String getAnswerTwo() {
		return answerTwo;
	}

	public String getAnswerThree() {
		return answerThree;
	}

	public String getAnswerFour() {
		return answerFour;
	}
	
	/**
	 * getAnswer method is used to find out which
	 * answer the player has selected
	 * @param i
	 * @return
	 */
	public String getAnswer(int i){
		if(i == 0){
			return answerOne;
		}else if(i == 1){
			return answerTwo;
		}else if(i == 2){
			return answerThree;
		}else if(i == 3){
			return answerFour;
		}else{
			return null;
		}
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public boolean isBeenShown() {
		return beenShown;
	}

	public String toString() {
		return questionText + ", " + answerOne + ", " + answerTwo + ", " + answerThree + ", " + answerFour + ", "
				+ correctAnswer + ", " + beenShown;
	}
}
