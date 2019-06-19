package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
import mainPackage.Player;

public class GameGUI extends JPanel{
	
	/**
	 * Adds all the Panels, buttons, labels etc
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlMainWest = new JPanel();
	private JPanel pnlMainCenter = new JPanel();
	private JPanel pnlCenterTop = new JPanel();
	private JPanel centerTopMid = new JPanel();
	private JPanel centerTopEast = new JPanel();
	private JPanel pnlCenterMid = new JPanel();
	private JPanel pnlCenterBot = new JPanel();
	private StartGUI mainFrame;
	private Container realContentPane;
	private FinishGUI layoutFinal;
	
	private ArrayList<JButton> buttonArray = new ArrayList<JButton>();
	private JLabel moneyLadder = new JLabel();
	private JLabel playerName = new JLabel();
	private JButton answerOne = new JButton();
	private JButton answerTwo = new JButton();
	private JButton answerThree = new JButton();
	private JButton answerFour = new JButton();
	private JLabel questionText = new JLabel();
	private JLabel[] moneyLabels = new JLabel[16];
	private JButton lifeline5050 = new JButton();
	private JButton lifelineATA = new JButton();
	private JLabel[] ataButtonLabels = new JLabel[4];
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> playersFinal = new ArrayList<Player>();
	private int[] buttonCount = { 0, 1, 2, 3};
	private Question currentQuestion;
	private int questionCount = 0;
	private int currentPlayer = 0;
	private int gameLevel = 0;
	
	private GridLayout layout = new GridLayout(2,2);
	
	private Color color2 = new Color(0,255,0);

	public GameGUI(StartGUI setStart) {
		
		//Sets a new StartGUI as the previous one and gets their players
		mainFrame = setStart;
		players = mainFrame.getPlayers();
		realContentPane = mainFrame.getContentPane();

		//Gets the first question of the first player to display
		currentQuestion = players.get(0).getQuestion(0);
		
		//Adds JButtons to a JButton array for loops
		buttonArray.add(answerOne);
		buttonArray.add(answerTwo);
		buttonArray.add(answerThree);
		buttonArray.add(answerFour);
		
		setLayout(new BorderLayout());
		add(pnlMainWest, BorderLayout.WEST);
		add(pnlMainCenter, BorderLayout.CENTER);
		
		//Creates a vertical box to make the money ladder and display the current player
		Box box = Box.createVerticalBox();
		pnlMainWest.add(box);
		box.add(moneyLadder);
		box.add(playerName);
		
		/**Loops through list of labels in reverse order to add
		 * 'money' highest to lowest to the box, font is also 
		 * set for each label, empty label added at the start to 
		 * separate the labels more.
		 */
		for(int i = 14; i >= 0; i--){
			box.add(new JLabel(" "));
			moneyLabels[i] = new JLabel(score(i));
			moneyLabels[i].setFont(new Font(moneyLadder.getName(), Font.BOLD, 18));
			moneyLabels[i].setOpaque(true);
			box.add(moneyLabels[i]);
		}
		//Invisible label for each player to start on
		moneyLabels[15] = new JLabel("");
		moneyLabels[15].setVisible(false);
		
		//Sets size for money ladder panel and sets title and player text
		pnlMainWest.setPreferredSize(new Dimension(200, JFrame.HEIGHT));
		moneyLadder.setText("Money Ladder");
		moneyLadder.setFont(new Font(moneyLabels[1].getName(), Font.BOLD, 20));
		playerName.setText(players.get(currentPlayer).getName());
		moneyLadder.setFont(new Font(moneyLabels[1].getName(), Font.BOLD, 18));
		
		//Organises the frame by adding panels and layouts
		pnlMainCenter.setLayout(new GridLayout(3, 1));
		pnlMainCenter.add(pnlCenterTop);
		pnlMainCenter.add(pnlCenterMid);
		pnlMainCenter.add(pnlCenterBot);
		
		pnlCenterTop.setLayout(new BorderLayout());
		pnlCenterTop.add(centerTopMid, BorderLayout.CENTER);
		pnlCenterTop.add(centerTopEast, BorderLayout.LINE_END);
		//lifelines added to the top of the screen
		centerTopMid.add(lifeline5050);
		centerTopMid.add(lifelineATA);
		
		//5050 Lifeline button action
		lifeline5050.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Loops through 5050 method until 2 buttons are disabled
				int enabledCount = 0;
				while(enabledCount < 2){
					if(lifeline5050()){
						enabledCount++;
					}else{
						//Do nothing
					}
				}
				//Then sets that 5050 has been used by that player and disables the button
				players.get(currentPlayer).fiftyfiftyUsed();
				lifeline5050.setEnabled(false);
			}
		});
		lifeline5050.setText("50 50 Lifeline");
		
		//Ask the audience lifeline button action
		lifelineATA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Similar to 5050 it calls the method then sets it to be used for the player, then disables it
				lifelineATA();
				players.get(currentPlayer).ataUsed();
				lifelineATA.setEnabled(false);
			}
		});
		lifelineATA.setText("Ask the audience Lifeline");
	
		//A second box is made for the ask the audience group of labels 
		Box boxTwo = Box.createVerticalBox();
		centerTopEast.add(boxTwo);
		for(int i = 0; i < 4; i++){
			ataButtonLabels[i] = new JLabel("");
			boxTwo.add(ataButtonLabels[i]);
		}
		
		pnlCenterMid.add(questionText);
		questionText.setText(currentQuestion.getQuestionText());
		questionText.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 20));
		
		//Layout is given gaps so the buttons are spaces apart
		layout.setHgap(20);
		layout.setVgap(30);
		pnlCenterBot.setLayout(layout);
		
		//The buttons are shuffled so the answers are added at random
		shuffleArray(buttonCount);
		
		/**
		 * Loops through but buttonCount list adding them and setting 
		 * the text of that random button to be an answer. It will
		 * also give each button an action listener which will 
		 * call check answer and next question when pressed.
		 */
		for (int i = 0; i < buttonArray.size(); i++) {
			final int k = i;
			
			pnlCenterBot.add(buttonArray.get(i));
			buttonArray.get(i).setText(currentQuestion.getAnswer(buttonCount[i]));
			buttonArray.get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					checkAnswer(buttonArray.get(k));
					nextQuestion();
				}
			});
		}
		this.setVisible(true);
	}
	
	//Check answer method that will check if the answer is correct
	public void checkAnswer(JButton selectedButton){
		//Sets the text of the button to be the selected answer
		String selectedAnswer = selectedButton.getText();
		
		/**
		 * Checks if the selected answer is correct then it will
		 * check if that makes the player a winner and adds them
		 * to a list of finished players
 		 */
		if(selectedAnswer.equals(currentQuestion.getCorrectAnswer())){
			players.get(currentPlayer).increaseScore(players.get(currentPlayer).getCurrentScore());
			if(players.get(currentPlayer).getCurrentScore() == 1000000){
				playersFinal.add(players.get(currentPlayer));
			}
		}else{
			//Else it's incorrect so the player is added to finished players
			//and removed from the current players list
			playersFinal.add(players.get(currentPlayer));
			players.remove(currentPlayer);
			
			// It then checks if there are no more players and if so it will move onto
			// the final panel/screen
			if(players.size() == 0){
				layoutFinal = new FinishGUI(playersFinal);
				realContentPane.add(layoutFinal, "layoutFinal");
				
				CardLayout cl = (CardLayout)(realContentPane.getLayout());
				cl.show(realContentPane, "layoutFinal");
			}
		}
	}

	//Comment this
	public void nextQuestion(){
		questionCount++;
		currentPlayer = questionCount % players.size();
		if(currentPlayer == 0){
			gameLevel++;
		}
		
		for(int i = 14; i >= 0; i--){
			moneyLabels[i].setBackground(new JLabel().getBackground());
		}
		
		moneyLabels[getScore(players.get(currentPlayer).getCurrentScore())].setBackground(color2);
		
		if(getScore(players.get(currentPlayer).getCurrentScore()) == 5){
			players.get(currentPlayer).setDifficulty(1);
		}else if(getScore(players.get(currentPlayer).getCurrentScore()) == 10){
			players.get(currentPlayer).setDifficulty(2);
		}else{
			//Do nothing
		}

		if(gameLevel == 15){
			layoutFinal = new FinishGUI(playersFinal);
			realContentPane.add(layoutFinal, "layoutFinal");

			CardLayout cl = (CardLayout)(realContentPane.getLayout());
			cl.show(realContentPane, "layoutFinal");
		}

		currentQuestion = players.get(currentPlayer).getQuestion(gameLevel);

		questionText.setText(currentQuestion.getQuestionText());
		shuffleArray(buttonCount);
		for(int i = 0; i < buttonArray.size(); i++){
			buttonArray.get(i).setEnabled(true);
			buttonArray.get(i).setText(currentQuestion.getAnswer(buttonCount[i]));
			buttonArray.get(i).setBackground(new JButton().getBackground());
			ataButtonLabels[i].setText("");
		}
		
		if(players.get(currentPlayer).get5050()){
			lifeline5050.setEnabled(false);
		}else{
			lifeline5050.setEnabled(true);
		}
		
		if(players.get(currentPlayer).getATA()){
			lifelineATA.setEnabled(false);
		}else{
			lifelineATA.setEnabled(true);
		}
		
		playerName.setText(players.get(currentPlayer).getName());
	}
	
	//Get score is used to check the players score and which money ladder label should be highlighted
	public int getScore(int i) {
		switch(i){
		case 0:
			return 15;
		case 100:
			return 0;
		case 200:
			return 1;
		case 300:
			return 2;
		case 500:
			return 3;
		case 1000:
			return 4;
		case 2000:
			return 5;
		case 4000:
			return 6;
		case 8000:
			return 7;
		case 16000:
			return 8;
		case 32000:
			return 9;
		case 64000:
			return 10;
		case 125000:
			return 11;
		case 250000:
			return 12;
		case 500000:
			return 13;
		case 1000000:
			return 14;
		default:
			return 15;
		}
	}

	//used for the money ladder labels to determine what text should be displayed
	public String score(int i){

		switch(i)
		{
		case 0:
			return "100";
		case 1:
			return "200";
		case 2:
			return "300";
		case 3:
			return "500";
		case 4:
			return "1,000";
		case 5:
			return "2,000";
		case 6:
			return "4,000";
		case 7:
			return "8,000";
		case 8:
			return "16,000";
		case 9:
			return "32,000";
		case 10:
			return "64,000";
		case 11:
			return "125,000";
		case 12:
			return "250,000";
		case 13:
			return "500,000";
		case 14:
			return "1,000,000";
		default:
			return "0";
		}
	}

	//Shuffle used to shuffle the button count
	static void shuffleArray(int[] ar)
	{
		// Implementing Fisher–Yates shuffle
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	//lifeline 5050 method shuffle them and gets the first one in the list
	//It then checks if it is right, if not it will disable it
	public boolean lifeline5050(){
		shuffleArray(buttonCount);
		if(!(buttonArray.get(buttonCount[0]).getText().equals(currentQuestion.getCorrectAnswer())) && buttonArray.get(buttonCount[0]).isEnabled()){
			buttonArray.get(buttonCount[0]).setEnabled(false);
			return true;
		}
		else{
			//Do nothing
			return false;
		}
	}

	//Will check the players difficulty and call the correct method
	public void lifelineATA(){
		shuffleArray(buttonCount);
		if(players.get(currentPlayer).getDifficulty() == 0){
			getEasyPercentages();
		}else if(players.get(currentPlayer).getDifficulty() == 1){
			getMediumPercentages();
		}else if(players.get(currentPlayer).getDifficulty() == 2){
			getHardPercentages();
		}
	}
	
	//Easy percentages is used for all the easy questions and when Ask the audience is used
	public void getEasyPercentages(){
		//Sets the total to be 100 so there can be no higher than 100%
		int totalRemaining = 100;
		Random random = new Random();
		int calculatedCorrect;
		//The correct answer could be anywhere so I have a list of incorrect and a just a list: 0-3
		int[] calculatedIncorrect = new int[3];
		int[] numbers = new int[4];
		
		numbers[0] = 0;
		numbers[1] = 1;
		numbers[2] = 2;
		numbers[3] = 3;
		
		//Percentages are calculated using random so it could be a varying percentage
		calculatedCorrect = random.nextInt(30) + 40;
		totalRemaining -= calculatedCorrect;
		
		calculatedIncorrect[0] = random.nextInt(totalRemaining);
		totalRemaining -= calculatedIncorrect[0];
		
		calculatedIncorrect[1] = random.nextInt(totalRemaining);
		totalRemaining -= calculatedIncorrect[1];
		
		calculatedIncorrect[2] = totalRemaining;
		
		//Loop to go through each button and set a label to their percentage
		for(int i = 0; i < buttonArray.size(); i++){
			//If it is the correct answer it will give it the correct answer %
			if(buttonArray.get(buttonCount[i]).getText().equals(currentQuestion.getCorrectAnswer())){
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedCorrect + "%");
				//Then number 3 in the number list is replaced with this one
				numbers[3] = numbers[i];
			}else{
				//If it's incorrect it will display an incorrect % and when it gets to the last one it will then do the replaced number
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedIncorrect[numbers[i]] + "%");
			}
			//Fonts are set so they are easier to read
			ataButtonLabels[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		}
	}

	//Medium percentages are the same but slightly different at calculated the actual percentages
	//so there is less of a chance of it being right
	public void getMediumPercentages(){
		int totalRemaining = 100;
		Random random = new Random();
		int calculatedCorrect;
		int[] calculatedIncorrect = new int[3];
		int[] numbers = new int[4];
		numbers[0] = 0;
		numbers[1] = 1;
		numbers[2] = 2;
		numbers[3] = 3;
		
		calculatedCorrect = random.nextInt(30) + 30;
		totalRemaining -= calculatedCorrect;
		
		calculatedIncorrect[0] = random.nextInt(totalRemaining/2) + (totalRemaining/4);
		totalRemaining -= calculatedIncorrect[0];
		
		calculatedIncorrect[1] = random.nextInt(totalRemaining);
		totalRemaining -= calculatedIncorrect[1];
		
		calculatedIncorrect[2] = totalRemaining;
		
		for(int i = 0; i < buttonArray.size(); i++){
			if(buttonArray.get(buttonCount[i]).getText().equals(currentQuestion.getCorrectAnswer())){
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedCorrect + "%");
				numbers[3] = numbers[i];
			}else{
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedIncorrect[numbers[i]] + "%");
			}
			ataButtonLabels[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		}
	}
	
	//Hard percentages are also the same as above, as the percentages now give a rarer chance of the
	//audience knowing the correct answer
	public void getHardPercentages(){
		int totalRemaining = 100;
		Random random = new Random();
		int calculatedCorrect;
		int[] calculatedIncorrect = new int[3];
		int[] numbers = new int[4];
		numbers[0] = 0;
		numbers[1] = 1;
		numbers[2] = 2;
		numbers[3] = 3;

		calculatedIncorrect[0] = random.nextInt(40) + 13;
		totalRemaining -= calculatedIncorrect[0];
		
		calculatedCorrect = random.nextInt(totalRemaining/2) + 20;
		totalRemaining -= calculatedCorrect;
		
		calculatedIncorrect[1] = random.nextInt(totalRemaining/2) + (totalRemaining/4);
		totalRemaining -= calculatedIncorrect[1];
		
		calculatedIncorrect[2] = totalRemaining;
		
		for(int i = 0; i < buttonArray.size(); i++){
			if(buttonArray.get(buttonCount[i]).getText().equals(currentQuestion.getCorrectAnswer())){
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedCorrect + "%");
				numbers[3] = numbers[i];
			}else{
				ataButtonLabels[i].setText(buttonArray.get(buttonCount[i]).getText()+ " has: " + calculatedIncorrect[numbers[i]] + "%");
			}
			ataButtonLabels[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		}
	}
}
