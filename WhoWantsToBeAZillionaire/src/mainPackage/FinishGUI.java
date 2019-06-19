package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class FinishGUI extends JPanel{
	
	private JPanel contentPane = new JPanel();
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	
	private JButton end = new JButton();
	private JLabel endScores = new JLabel();
	
	private String scores = "<html>";

	public FinishGUI(ArrayList<Player> endPlayers){
		
		add(contentPane);
		
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(north, BorderLayout.PAGE_START);
		contentPane.add(center, BorderLayout.CENTER);
		contentPane.add(south, BorderLayout.PAGE_END);
		//Button and label added
		center.add(endScores);
		south.add(end);
		end.setText("End Game");
		
		//Button to end game, which closes program
		end.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		//Loops through players and appends them to a string and a new line
		for(int i = 0; i < endPlayers.size(); i++){
			scores += "<br>" + endPlayers.get(i).getName() + " - " + endPlayers.get(i).getCategory() + ": " + endPlayers.get(i).getCurrentScore() + "</br>";
		}
		
		endScores.setText(scores);
	}
}
