package mainPackage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	//ArrayLists to store the players and every question
	private ArrayList<Player> players;
	private ArrayList<Question> genKnow1Quest;
	private ArrayList<Question> genKnow2Quest;
	private ArrayList<Question> genKnow3Quest;
	private ArrayList<Question> hist1Quest;
	private ArrayList<Question> hist2Quest;
	private ArrayList<Question> hist3Quest;
	private ArrayList<Question> movie1Quest;
	private ArrayList<Question> movie2Quest;
	private ArrayList<Question> movie3Quest;

	public Game() {
		players = new ArrayList<Player>();
		genKnow1Quest = new ArrayList<Question>();
		genKnow2Quest = new ArrayList<Question>();
		genKnow3Quest = new ArrayList<Question>();
		hist1Quest = new ArrayList<Question>();
		hist2Quest = new ArrayList<Question>();
		hist3Quest = new ArrayList<Question>();
		movie1Quest = new ArrayList<Question>();
		movie2Quest = new ArrayList<Question>();
		movie3Quest = new ArrayList<Question>();
	}

	/**
	 * Method to get players to
	 * pass them through multiple
	 * classes. Getter and setter
	 * for players
	 * @return
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * I am initialising the questions so a random selection can be made
	 * Used this site to help make my code
	 * http://stackoverflow.com/questions/32265533/reading-contents-of-a-file-
	 * into-class-objects I am adding all the questions in a file into a ArrayList of
	 * my class Question. I open the file, and look at it line by line and
	 * separate each data parts with a ";" then I add each data part into a
	 * field into an instance of a class which is then added into a ArrayList.
	 * 
	 * Reads file, inputs into ArrayList for ease of use
	 */
	public void initialiseQuestions() {
		//Setting the file to be the correct one
		File file = new File("genKnow1Quest.txt");
		//Create a new BufferedReader to read the file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields
				// Each data will be separated with a specific character
				String[] data = line.split(";");

				// Create new Question object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				genKnow1Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * It is then repeated for each file of questions which there is 3 for
		 * each category to signify difficulty
		 */
		file = new File("genKnow2Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				genKnow2Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("genKnow3Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				genKnow3Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("hist1Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				hist1Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("hist2Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				hist2Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("hist3Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				hist3Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("movie1Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				movie1Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("movie2Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				movie2Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("movie3Quest.txt");
		br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Read file line by line
		line = "";
		try {
			while ((line = br.readLine()) != null) {
				// Parse line to extract individual fields

				String[] data = line.split(";");

				// Create new Employee object
				Question question = new Question();
				question.setQuestionText(data[0]);
				question.setAnswerOne(data[1]);
				question.setAnswerTwo(data[2]);
				question.setAnswerThree(data[3]);
				question.setAnswerFour(data[4]);
				question.setCorrectAnswer(data[5]);
				question.setBeenShown(Boolean.valueOf(data[6]));

				// Add object to list
				movie3Quest.add(question);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Empties arrays so questions can
	 * be re-added, so more players can play
	 */
	public void clearArrays(){
		genKnow1Quest.clear();
		genKnow2Quest.clear();
		genKnow3Quest.clear();
		movie1Quest.clear();
		movie2Quest.clear();
		movie3Quest.clear();
		hist1Quest.clear();
		hist2Quest.clear();
		hist3Quest.clear();
	}
	
	//Method made for testing classes
	public ArrayList<Question> getGenKnow1(){
		return genKnow1Quest;
	}

	//This will add players and can be used multiple times
	public void addPlayer(String newName, String newCategory) {
		Player player = new Player(newName, newCategory);
		setPlayerQuestions(player);
		players.add(player);
	}
	
	//Method to remove players from player list
	//If two players are the same it removes the latest one
	public void removePlayer(String getName)
	{
		//sets i as -1 so it won't automatically
		//get rid of index 0;
		int i = -1;
		//loops through players to find the right one
		for(Player temp : players)
		{
			if(temp.getName().equals(getName)){
				i = players.indexOf(temp);
			}
		}
		//Try and catch so I can ignore the Out of bounds when none found
		try{
		players.remove(i);
		}catch (ArrayIndexOutOfBoundsException e){
			//Do nothing
		}
	}
	
	//Method to make sure give the players their questions
	public void setPlayerQuestions(Player currentPlayer)
	{
		//Finds out what category the player has then sets questions accordingly
		if(currentPlayer.getCategory().equals("General Knowledge"))
		{
			addGeneralKnowledgeQuestions(currentPlayer);
		}
		else if(currentPlayer.getCategory().equals("History"))
		{
			addHistoryQuestions(currentPlayer);
		}
		else if(currentPlayer.getCategory().equals("Movies"))
		{
			addMovieQuestions(currentPlayer);
		}
	}
	
	/**
	 * Methods that are the same but with slight changes depending 
	 * on the category chosen. They find the questions then use
	 * the addQuestion method to add the questions
	 * @param currentPlayer
	 */
	public void addGeneralKnowledgeQuestions(Player currentPlayer)
	{
		int number;
		Random random = new Random();
		Question question = new Question();
		//Loops through 5 easy questions adding 5 random ones
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(genKnow1Quest.size());
			question = genKnow1Quest.get(number);
			currentPlayer.addQuestion(question);
			genKnow1Quest.remove(number);
		}
		
		//Then 5 medium style questions
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(genKnow2Quest.size());
			question = genKnow2Quest.get(number);
			currentPlayer.addQuestion(question);
			genKnow2Quest.remove(number);
		}
		
		//Then 5 hard style questions
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(genKnow3Quest.size());
			question = genKnow3Quest.get(number);
			currentPlayer.addQuestion(question);
			genKnow3Quest.remove(number);
		}
	}

	//Same as prior method but file name changes
	public void addHistoryQuestions(Player currentPlayer)
	{
		int number;
		Random random = new Random();
		Question question = new Question();
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(hist1Quest.size());
			question = hist1Quest.get(number);
			currentPlayer.addQuestion(question);
			hist1Quest.remove(number);
		}
		
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(hist2Quest.size());
			question = hist2Quest.get(number);
			currentPlayer.addQuestion(question);
			hist2Quest.remove(number);
		}
		
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(hist3Quest.size());
			question = hist3Quest.get(number);
			currentPlayer.addQuestion(question);
			hist3Quest.remove(number);
		}
	}
	
	//Same as above
	public void addMovieQuestions(Player currentPlayer)
	{
		int number;
		Random random = new Random();
		Question question = new Question();
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(movie1Quest.size());
			question = movie1Quest.get(number);
			currentPlayer.addQuestion(question);
			movie1Quest.remove(number);
		}
		
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(movie2Quest.size());
			question = movie2Quest.get(number);
			currentPlayer.addQuestion(question);
			movie2Quest.remove(number);
		}
		
		for(int i=0; i < 5; i++)
		{
			number = random.nextInt(movie3Quest.size());
			question = movie3Quest.get(number);
			currentPlayer.addQuestion(question);
			movie3Quest.remove(number);
		}
	}
	
	/**
	 * Useless method
	 * Text based Zillionaire to test
	 * funcionality and for practice
	 * (May not work anymore)
	 */
	public void startGame()
	{
		boolean allPlayersOut = false;
		while (allPlayersOut == false)
		{	
			
			for (int x=0; x < 15; x++)
			{
				
				//next it will loop through each player and ask them their question
				for (int i =0; i < players.size(); i++)
				{
					Scanner scanner = new Scanner(System.in);
					String questionText;
					Question question = new Question();
					Player player = players.get(i);
					if(!player.isPlayerOut())
					{
						questionText = players.get(i).showQuestion(x);
						question = player.getQuestion(x);
						System.out.println(questionText);
						System.out.println(question.getAnswerOne() + "\n" + question.getAnswerTwo() + "\n" + question.getAnswerThree() + "\n" + question.getAnswerFour());
						String selectedAns = scanner.nextLine();
						if(selectedAns.equals(question.getCorrectAnswer()))
						{
							switch(x)
							{
							case 0:
								player.setCurrentScore(100);
								break;
							case 1:
								player.setCurrentScore(200);
								break;
							case 2:
								player.setCurrentScore(300);
								break;
							case 3:
								player.setCurrentScore(500);
								break;
							case 4:
								player.setCurrentScore(1000);
								break;
							case 5:
								player.setCurrentScore(2000);
								break;
							case 6:
								player.setCurrentScore(4000);
								break;
							case 7:
								player.setCurrentScore(8000);
								break;
							case 8:
								player.setCurrentScore(16000);
								break;
							case 9:
								player.setCurrentScore(32000);
								break;
							case 10:
								player.setCurrentScore(64000);
								break;
							case 11:
								player.setCurrentScore(125000);
								break;
							case 12:
								player.setCurrentScore(250000);
								break;
							case 13:
								player.setCurrentScore(500000);
								break;
							case 14:
								player.setCurrentScore(1000000);
								break;
								
							}
						}
						else
						{
							player.setPlayerOut(true);
						}
					}
				}

				for(Player temp : players)
				{
					System.out.println(temp.getName() + ": " + temp.getCurrentScore());
				}

				//for loop to check if everyone is out
				for (int i =0; i < players.size(); i++)
				{
					if (!(players.get(i).isPlayerOut())){
						allPlayersOut = false;
						break;
					}
					else {
						allPlayersOut = true;
					}
				}
				
				if(x==14){
					allPlayersOut = true;
				}
			}
		}
	}

}
