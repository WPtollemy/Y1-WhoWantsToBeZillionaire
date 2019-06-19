package mainPackage;
import java.util.ArrayList;

public class Player {

	private String name;
	private String category;
	private int currentScore;
	private int difficulty;
	private boolean playerOut;
	private boolean used5050;
	private boolean usedATA;
	private ArrayList<Question> playerQuestions;

	/**
	 * Constructor for player when
	 * adding new players into the player list
	 * 
	 * @param newName
	 * @param newCategory
	 */
	public Player(String newName, String newCategory) {
		name = newName;
		category = newCategory;
		currentScore = 0;
		difficulty = 0;
		playerOut = false;
		used5050 = false;
		usedATA = false;
		setPlayerQuestions(new ArrayList<Question>());
	}

	/**
	 * Empty constructor in case I
	 * needed to add empty players
	 */
	public Player() {
		name = null;
		category = null;
		currentScore = 0;
		difficulty = 0;
		playerOut = false;
		used5050 = false;
		usedATA = false;
		setPlayerQuestions(new ArrayList<Question>());
	}

	/**
	 * Lifeline methods to set them to be
	 * true when they player uses them
	 */
	public void fiftyfiftyUsed(){
		used5050 = true;
	}
	
	public void ataUsed(){
		usedATA = true;
	}
	
	/**
	 * Getters and setters made for variables
	 * so I can set and get at will i.e. to 
	 * check if a player has already done something
	 */
	public boolean get5050(){
		return used5050;
	}
	
	public boolean getATA(){
		return usedATA;
	}
	
	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public ArrayList<Question> getPlayerQuestions() {
		return playerQuestions;
	}

	public void setPlayerQuestions(ArrayList<Question> playerQuestions) {
		this.playerQuestions = playerQuestions;
	}

	public boolean isPlayerOut() {
		return playerOut;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setPlayerOut(boolean playerOut) {
		this.playerOut = playerOut;
	}
	
	/**
	 * Method made so that questions can be added to
	 * the players so they can be asked them
	 * @param addQuestion
	 */
	public void addQuestion(Question addQuestion)
	{
		getPlayerQuestions().add(addQuestion);
	}

	public Question getQuestion(int index)
	{
		return getPlayerQuestions().get(index);
	}
	
	/**
	 * Inoperable method used for checking questions
	 * Also used in prior idle text made Zillionaire
	 * @param index
	 * @return
	 */
	public String showQuestion(int index)
	{
		String string;
		Question question;
		question = getPlayerQuestions().get(index);
		string = question.getQuestionText();
		return string;
	}
	
	//Method to increase a players score
	public void increaseScore(int x){
		switch(x)
		{
		case 0:
			setCurrentScore(100);
			break;
		case 100:
			setCurrentScore(200);
			break;
		case 200:
			setCurrentScore(300);
			break;
		case 300:
			setCurrentScore(500);
			break;
		case 500:
			setCurrentScore(1000);
			break;
		case 1000:
			setCurrentScore(2000);
			break;
		case 2000:
			setCurrentScore(4000);
			break;
		case 4000:
			setCurrentScore(8000);
			break;
		case 8000:
			setCurrentScore(16000);
			break;
		case 16000:
			setCurrentScore(32000);
			break;
		case 32000:
			setCurrentScore(64000);
			break;
		case 64000:
			setCurrentScore(125000);
			break;
		case 125000:
			setCurrentScore(250000);
			break;
		case 250000:
			setCurrentScore(500000);
			break;
		case 500000:
			setCurrentScore(1000000);
			break;
		}
	}
	
	public String toString() {
		String playerOutText;

		if (playerOut) {
			playerOutText = "Player is out";
		} else {
			playerOutText = "Player is not out";
		}

		return "Name is " + name + "\n" + "Category chosen is " + category + "\n" + "Current Score is " + currentScore
				+ "\n" + playerOutText;
	}

}
