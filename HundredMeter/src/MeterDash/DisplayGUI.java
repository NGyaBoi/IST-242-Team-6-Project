package MeterDash;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import MeterDash.DisplayGUI.ButtonListener;


public class DisplayGUI extends JFrame
{
	JLabel lblFirstName, lblLastName, lblNation, lblLaneNumber, lblReactionTime, lblFinishTime, lblRanking, lblVoid;
	JLabel displayFirstName, displayLastName, displayNation, displayLaneNumber, displayReactionTime, displayFinishTime, displayRanking;
	
	private static final int frame_HEIGHT = 400;
	private static final int frame_WIDTH = 300;
	
	boolean pointer = false;
	
	public DisplayGUI(String FirstName, String LastName, String Nation, int LaneNumber, double ReactionTime, double FinishingTime, int Ranking)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Displaying Information");
		setSize(frame_HEIGHT, frame_WIDTH);
		
		lblFirstName = new JLabel("First Name:");	
		lblLastName = new JLabel("Last Name:");
		lblNation = new JLabel("Nation:");
		lblLaneNumber = new JLabel("Lane Number:");
		lblReactionTime = new JLabel("Reaction Time:");
		lblFinishTime = new JLabel("Finishing Time:");
		lblRanking = new JLabel("Ranking:");
		lblVoid = new JLabel("");
		
		
		this.displayFirstName = new JLabel(FirstName);	
		this.displayLastName = new JLabel(LastName);
		this.displayNation = new JLabel(Nation);
		this.displayLaneNumber = new JLabel(Integer.toString(LaneNumber));
		this.displayReactionTime = new JLabel(Double.toString(ReactionTime));
		this.displayFinishTime = new JLabel(Double.toString(FinishingTime));
		this.displayRanking = new JLabel(Integer.toString(Ranking));
		
		JPanel ComboPanel = new JPanel();
		ComboPanel.setLayout(new GridLayout(7,1));;
		
		JPanel DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(7,1));;
		
		add(DisplayPanel, BorderLayout.EAST);
		add(ComboPanel, BorderLayout.WEST);
		
		ComboPanel.add(lblFirstName);
		if(GUi.FirstName.isSelected()==true)
			DisplayPanel.add(displayFirstName);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblLastName);
		if(GUi.LastName.isSelected()==true)
			DisplayPanel.add(displayLastName);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblNation);
		if(GUi.Nation.isSelected()==true)
			DisplayPanel.add(displayNation);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblLaneNumber);
		if(GUi.LaneNumber.isSelected()==true)
			DisplayPanel.add(displayLaneNumber);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblReactionTime);
		if(GUi.ReactionTime.isSelected()==true)
			DisplayPanel.add(displayReactionTime);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblFinishTime);
		if(GUi.FinishTime.isSelected()==true)
			DisplayPanel.add(displayFinishTime);
		else {DisplayPanel.add(lblVoid);}
		
		ComboPanel.add(lblRanking);
		if(GUi.Ranking.isSelected()==true)
			DisplayPanel.add(displayRanking);
		else {DisplayPanel.add(lblVoid);}
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		JButton enter = new JButton("Enter");
		JButton exit = new JButton("Exit");
		JButton VaA = new JButton("View Another Athlete"); 
		buttonPanel.add(VaA);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
		do 
		{
			ButtonListener listener = new ButtonListener();
			exit.addActionListener(listener);
			VaA.addActionListener(listener);
		} while(pointer);
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
				switch(e.getActionCommand())
				{
					case "Clear":
						break;
					case "View Another Athlete":
						dispose();
						break;
					case "Exit":
						System.exit(0);
						break;
				}
			}
	}
}
