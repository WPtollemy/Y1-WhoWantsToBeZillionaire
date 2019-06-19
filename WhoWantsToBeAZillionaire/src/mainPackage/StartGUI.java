package mainPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.xml.transform.OutputKeys;

public class StartGUI extends JFrame {
	
	/**
	 * Creating the variables and
	 * also the serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Game game;

	private JButton addPlayer = new JButton();
	private JButton removePlayer = new JButton();
	private JButton quitGame = new JButton();
	private JButton about = new JButton();
	private JButton startGame = new JButton();
	private JLabel title = new JLabel();
	private JLabel playerCount = new JLabel();
	private JTextField enterName = new JTextField();
	private JComboBox<String> inputCategories = new JComboBox<String>();
	private JButton resetCategoriesBtn = new JButton();
	
	private Container contentPane = getContentPane();
	private JPanel layoutStart = new JPanel();
	private GameGUI layoutGame;
	private AboutGUI layoutAbout = new AboutGUI(contentPane);
	private AddQuestionsGUI layoutQuestionsAdd;
	private JPanel pnlMainTop = new JPanel();
	private JPanel pnlTopPageStart = new JPanel();
	private JPanel pnlTopCenter = new JPanel();
	private JPanel pnlMainBottom = new JPanel();
	private JPanel pnlBottomLeft = new JPanel();
	private JPanel pnlBottomRight = new JPanel();
	
	private GridLayout layout = new GridLayout();
	
	/**
	 * Create the frame.
	 * Maximise the frame on startup
	 */
	public StartGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Creates an instance of game so it can sort out/initialise the questions
		game = new Game();
		game.initialiseQuestions();
		
		//I use a CardLayout so that I can easily swap between frames/panels
		contentPane.setLayout(new CardLayout());
		contentPane.add(layoutStart, "layoutStart");
		contentPane.add(layoutAbout, "layoutAbout");
		
		//Splits frame in middle horizontally
		layoutStart.setLayout(new GridLayout(2,1));
		layoutStart.add(pnlMainTop);
		layoutStart.add(pnlMainBottom);
		
		//Shaped into two panels so the title can be in the middle
		pnlMainTop.setLayout(new BorderLayout());
		pnlMainTop.add(pnlTopPageStart, BorderLayout.PAGE_START);
		pnlTopPageStart.setPreferredSize(new Dimension(this.getWidth(), 200));
		pnlMainTop.add(pnlTopCenter, BorderLayout.CENTER);
		pnlTopCenter.add(title);
		
		//Splits bottom half into two vertically
		pnlMainBottom.setLayout(new GridLayout(1, 2));
		pnlMainBottom.add(pnlBottomLeft);
		pnlMainBottom.add(pnlBottomRight);
		
		//Puts left and right columns into multiple rows
		layout.setVgap(15);
		layout.setRows(6);
		layout.setColumns(1);
		pnlBottomLeft.setLayout(layout);
		pnlBottomRight.setLayout(new GridLayout(3, 1));
		
		//Adding basic objects, buttons, label, ComboBox
		pnlBottomRight.add(startGame);
		pnlBottomRight.add(about);
		pnlBottomRight.add(quitGame);
		
		pnlBottomLeft.add(playerCount);
		pnlBottomLeft.add(enterName);
		pnlBottomLeft.add(inputCategories);
		pnlBottomLeft.add(addPlayer);
		pnlBottomLeft.add(removePlayer);
		pnlBottomLeft.add(resetCategoriesBtn);
		
		//Puts categories into ComboBox
		inputCategories.addItem("General Knowledge");
		inputCategories.addItem("History");
		inputCategories.addItem("Movies");
		
		//Sets text on screen and font of title
		title.setText("Welcome to who wants to be a Zillionaire");
		title.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		playerCount.setText("Number of players: " + game.getPlayers().size());
		enterName.setText("Enter your name: ");
		
		//Clears text in TextField when focused
		enterName.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent evt){
				enterName.setText("");
			}
			
			public void focusLost(FocusEvent evt){
				//Do nothing
			}
		});
		
		//Sets text of buttons
		startGame.setText("Start Game");
		about.setText("About/Help");
		quitGame.setText("Quit Game");
		
		addPlayer.setText("Add Player");
		removePlayer.setText("Remove Player");
		resetCategoriesBtn.setText("Re-add the categories");
		
		//Action listener of button to add players
		addPlayer.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				//Simple check making sure text is there
				if(enterName.getText().equals("") || inputCategories.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null, "Unable to add player");
				}else{
					//Adds player then updates the screen data
					game.addPlayer(enterName.getText(), inputCategories.getSelectedItem().toString());
					
					playerCount.setText("Number of players: " + game.getPlayers().size());
					//Removes category so that no other play can choose that one so there are no repeat question
					inputCategories.removeItemAt(inputCategories.getSelectedIndex());
				}
			}
		});
		
		//Action listener of button to remove player
		removePlayer.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				//Removes player then updates screen
				game.removePlayer(enterName.getText());
				
				playerCount.setText("Number of players: " + game.getPlayers().size());
			}
		});
		
		//Re-adds the categories so players can use them more than once & more players can be added
		resetCategoriesBtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				StartGUI.this.resetCategories();
			}
		});

		/**
		 * Adds GameGUI panel here instead so parameter can
		 * be passed. Then loads the GameGUI so game can start
		 */
		startGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {			
				layoutGame = new GameGUI(StartGUI.this);
				contentPane.add(layoutGame, "layoutGame");
				
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, "layoutGame");
			}
		});
		
		//Adds AddQuestionsGUI for same reason as above, displays AboutGUI
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				layoutQuestionsAdd = new AddQuestionsGUI(contentPane);
				contentPane.add(layoutQuestionsAdd, "layoutQuestionsAdd");
				
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, "layoutAbout");
			}
		});
		
		//Quit's the program
		quitGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void showGUI() {
		this.setVisible(true);
	}
	
	//Method called in GameGUI to set players
	public ArrayList<Player> getPlayers() {
		return game.getPlayers();
	}
	
	//Getter for the contentPane so I can call it in GameGUI
	public Container getThisPane(){
		return contentPane;
	}
	
	//Method called in reset categories action listener to reset categories
	public void resetCategories(){
		//Warns user that doing this could mean in repeated questions
		int response = JOptionPane.showConfirmDialog(null, "This could result in repeated questions", "Would you like to re-add the categories?", JOptionPane.OK_CANCEL_OPTION);
		
		if (response == JOptionPane.CANCEL_OPTION) {
			//Do nothing
		} else if (response == JOptionPane.OK_OPTION) {
			//Clears the arrays and re-adds the questions 
			game.clearArrays();
			game.initialiseQuestions();

			//Clears the ComboBox and re-adds the values
			inputCategories.removeAllItems();
			inputCategories.addItem("General Knowledge");
			inputCategories.addItem("History");
			inputCategories.addItem("Movies");
		} else if (response == JOptionPane.CLOSED_OPTION) {
			//Do nothing
		}
	}
}