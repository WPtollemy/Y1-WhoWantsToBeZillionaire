package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AboutGUI extends JPanel {

	/**
	 * Declaring serialVerionUID
	 * also creating all the variables/objects
	 */
	private static final long serialVersionUID = 1L;

	private JPanel north = new JPanel();
	private JPanel east = new JPanel();
	private JPanel south = new JPanel();
	private JPanel west = new JPanel();
	private JPanel center = new JPanel();
	private Container realContentPane;
	
	private JLabel aboutLbl = new JLabel();
	private JButton backBtn = new JButton();
	private JButton addQuestions = new JButton();
	
	public AboutGUI(Container newContentPane) {
		
		//Gets content pane from StartGUI to use to go back to
		realContentPane = newContentPane;
		
		setLayout(new BorderLayout());
		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		
		north.setPreferredSize(new Dimension(200,200));
		east.setPreferredSize(new Dimension(400,200));
		south.setPreferredSize(new Dimension(200,200));
		west.setPreferredSize(new Dimension(400,200));
		
		center.add(aboutLbl);
		north.add(backBtn);
		south.add(addQuestions);
		
		//Basic label giving the information about the game. Uses html to separate the lines
		aboutLbl.setText("<html>This game is based off of the tv shows Who wants to be a Millionaire "
						+"<br>and other show Mastermind. Multiple players can compete to win One "
						+"<br>Million pounds. Players get asked 15 questions of varying difficulty"
						+"<br>on their chosen topic. Each player gets two lifelines, one 5050 "
						+"<br>and one ask the audience. Recommended 3 players."
						+"<br>"
						+"<br>Produced by William Piears. ");
		backBtn.setText("Back a page");
		addQuestions.setText("Add more questions");
		
		//Changes to add questions panel/screen
		addQuestions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				CardLayout cl = (CardLayout)(realContentPane.getLayout());
				cl.show(realContentPane, "layoutQuestionsAdd");
			}
		});
		
		//Goes back a page by re-loading the StartGUI
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			    CardLayout cl = (CardLayout)(realContentPane.getLayout());
			    cl.show(realContentPane, "layoutStart");
			}
		});
		
		this.setVisible(true);
	}
}
