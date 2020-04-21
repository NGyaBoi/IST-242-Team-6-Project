package MeterDash;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DisplayGUI extends JFrame
{
	JLabel lblFirstName, lblLastName, lblNation, lblLaneNumber, lblReactionTime, lblFinishTime, lblRanking;
	JLabel displayFirstName, displayLastName, displayNation, displayLaneNumber, displayReactionTime, displayFinishTime, displayRanking;
	
	public DisplayGUI ()
	{
		lblFirstName = new JLabel("First Name:");	
		lblLastName = new JLabel("Last Name:");
		lblNation = new JLabel("Nation:");
		lblLaneNumber = new JLabel("Lane Number:");
		lblReactionTime = new JLabel("Reaction Time:");
		lblFinishTime = new JLabel("Finishing Time:");
		lblRanking = new JLabel("Ranking:");
	}
}
