package mainPackage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddQuestionsGUI extends JPanel{

	private JComboBox<String> categories = new JComboBox<String>();
	private JComboBox<String> newDifficulty = new JComboBox<String>();
	private JTextField newQuestionText = new JTextField();
	private JTextField newCorrectAnswer = new JTextField();
	private JTextField newIncorrectAnswerOne = new JTextField();
	private JTextField newIncorrectAnswerTwo = new JTextField();
	private JTextField newIncorrectAnswerThree = new JTextField();
	private JButton backBtn = new JButton();
	private JButton addQuestionBtn = new JButton();
	private JLabel pageTitle = new JLabel();
	private JLabel categoryTxt = new JLabel();
	private JLabel difficultyTxt = new JLabel();
	private JLabel questionTextTxt = new JLabel();
	private JLabel correctAnsTxt = new JLabel();
	private JLabel incorrectAnsTxt = new JLabel();
	
	private Container contentPane;
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel pnlSouthEast = new JPanel();
	private JPanel pnlSouthWest = new JPanel();
	
	private String entireQuestion;
	private String filename = new String("hist1Quest.txt");
	
	public AddQuestionsGUI(Container newContainerFoo){

		contentPane = newContainerFoo;
		setLayout(new BorderLayout());
		
		categories.addItem("General Knowledge");
		categories.addItem("History");
		categories.addItem("Movies");
		
		newDifficulty.addItem("Easy");
		newDifficulty.addItem("Medium");
		newDifficulty.addItem("Hard");
		
		//Creates two boxes for the data fields and labels identifying each one
		Box box = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		
		add(north, BorderLayout.PAGE_START);
		add(center, BorderLayout.CENTER);
		
		north.setPreferredSize(new Dimension(this.getWidth(), 200));
		center.setLayout(new GridLayout(1,6));
		
		//Adds blank panels to put main panels in the middle
		north.add(pageTitle);
		center.add(new JPanel());
		center.add(new JPanel());
		center.add(pnlSouthWest);
		center.add(pnlSouthEast);
		center.add(new JPanel());
		center.add(new JPanel());
		
		//Adds the boxes to the panels 
		pnlSouthEast.add(box);
		pnlSouthWest.add(box2);
		
		//Adds all the objects and data to the panels
		box.add(categories);
		box.add(newDifficulty);
		box.add(newQuestionText);
		box.add(newCorrectAnswer);
		box.add(newIncorrectAnswerOne);
		box.add(newIncorrectAnswerTwo);
		box.add(newIncorrectAnswerThree);
		box.add(addQuestionBtn);
		box.add(backBtn);
		
		box2.add(categoryTxt);
		box2.add(new JLabel(" "));
		box2.add(difficultyTxt);
		box2.add(questionTextTxt);
		box2.add(correctAnsTxt);
		box2.add(new JLabel(" "));
		box2.add(incorrectAnsTxt);
		
		pageTitle.setText("Add another question to any category");
		categoryTxt.setText("Choose the category of the question: ");
		difficultyTxt.setText("Choose the difficulty of the question: ");
		questionTextTxt.setText("Enter the question text here: ");
		correctAnsTxt.setText("Enter the correct answer here: ");
		incorrectAnsTxt.setText("Enter selected incorrect answers here: ");
		addQuestionBtn.setText("Add question");
		backBtn.setText("Back a page");
		
		//Add question button action listener so it will work when pressed
		addQuestionBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//String formatted so it can be entered correctly into the files
				entireQuestion = newQuestionText.getText() + ";" + newCorrectAnswer.getText() + ";" + newIncorrectAnswerOne.getText()
						+ ";" + newIncorrectAnswerTwo.getText() + ";" + newIncorrectAnswerThree.getText() + ";"
						+ newCorrectAnswer.getText() + ";false";
				
				//Checks which category is selected and calls corresponding method
				if(categories.getSelectedItem().equals("General Knowledge")){
					addGeneralKnowledgeQuestion();
				}else if(categories.getSelectedItem().equals("Movies")){
					addMoviesQuestion();
				}else if(categories.getSelectedItem().equals("History")){
					addHistoryQuestion();
				}else{
					//Do nothing
				}
				
				//TextFields are cleared at the end of method
				newQuestionText.setText("");
				newCorrectAnswer.setText("");
				newIncorrectAnswerOne.setText("");
				newIncorrectAnswerTwo.setText("");
				newIncorrectAnswerThree.setText("");
			}
		});
		
		//Back button -- goes back a back
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "layoutAbout");
			}
		});
	}
	
	//Method called in the action listener to add the question to the file
	public void addGeneralKnowledgeQuestion(){
		//Checks what difficulty is selected and sets a string to the filename
		if(newDifficulty.getSelectedItem().equals("Easy")){
			filename = "genKnow1Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Medium")){
			filename = "genKnow2Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Hard")){
			filename = "genKnow3Quest.txt";
		}
		
		//Sets a file to be the string made
		File file = new File(filename);
		
		//Creates a file writer to write to the file
		FileWriter fw;
		try {
			//true needed so data can be appended to the file
			fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			//Line written in so it doesn't have two questions on the same line
			bw.write("\r\n");
			bw.append(entireQuestion);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Same as method above but adapted for movies instead of general knowledge
	public void addMoviesQuestion(){
		if(newDifficulty.getSelectedItem().equals("Easy")){
			filename = "movie1Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Medium")){
			filename = "movie2Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Hard")){
			filename = "movie3Quest.txt";
		}
		
		File file = new File(filename);
		
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\r\n");
			bw.append(entireQuestion);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Same as above with slight differences
	public void addHistoryQuestion(){
		if(newDifficulty.getSelectedItem().equals("Easy")){
			filename = "hist1Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Medium")){
			filename = "hist2Quest.txt";
		}else if(newDifficulty.getSelectedItem().equals("Hard")){
			filename = "hist3Quest.txt";
		}
		
		File file = new File(filename);
		
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\r\n");
			bw.append(entireQuestion);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
