package MeterDash;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GUi extends JFrame 
{
	//Formats height and width of GUI
	private static final int frame_HEIGHT = 400;
	private static final int frame_WIDTH = 300;
	
	JLabel lblSearchBar = createlabel("Choose an athlete");
	JComboBox athletes;
	
	//Declares check boxes
	JCheckBox FirstName = new JCheckBox("Display the Runner's First Name", true);
	JCheckBox LastName = new JCheckBox("Display the Runner's Last Name", true);
	JCheckBox Nation = new JCheckBox("Display the Runner's Nation of Origin", true);
	JCheckBox LaneNumber = new JCheckBox("Display the Lane Number", true);
	JCheckBox ReactionTime = new JCheckBox("Display the Runner's Reaction Time", true);
	JCheckBox FinishTime = new JCheckBox("Display the Finishing Time", true);
	JCheckBox Ranking = new JCheckBox("Display the Runner's Ranking", true);
	
	boolean pointer = false;
	
	public GUi() throws FileNotFoundException
	{
		Scanner console = new Scanner(System.in);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meter Dash Search Tool");
		setSize(frame_HEIGHT, frame_WIDTH);
		
		String[] athleteNames = {"Please Select ", "Usain Bolt", "Justin Gatlin", "Andre De Grasse", "Yohan Blake", "Akani Simbine", "Ben Youssef Meite", "Jimmy Vicaut", "Trayvon Bromell"};
		athletes = new JComboBox(athleteNames);
		
		//Declares new combo box panel
		JPanel ComboPanel = new JPanel();
		ComboPanel.setLayout(new GridLayout(1,1));;
		ComboPanel.add(lblSearchBar);
		ComboPanel.add(athletes);
		add(ComboPanel, BorderLayout.NORTH);
		
		JPanel CheckPanel = new JPanel();
		CheckPanel.setLayout(new GridLayout(7,1));
		
		//Adds new check boxes
		CheckPanel.add(FirstName);
		CheckPanel.add(LastName);
		CheckPanel.add(Nation);
		CheckPanel.add(LaneNumber);
		CheckPanel.add(ReactionTime);
		CheckPanel.add(FinishTime);
		CheckPanel.add(Ranking);
		add(CheckPanel,BorderLayout.WEST);
		
		//Declares GUI buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		JButton enter = new JButton("Enter");
		JButton exit = new JButton("Exit");
		JButton clear = new JButton("Clear");
		buttonPanel.add(clear);
		buttonPanel.add(enter);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//button listener
		do 
		{
			ButtonListener listener = new ButtonListener();
			exit.addActionListener(listener);
			clear.addActionListener(listener);
			enter.addActionListener(listener);
		} while(pointer);
	}
	
	public void InputPanel()
	{
		JPanel InputPanel = new JPanel();
		Box nameBox = Box.createHorizontalBox();
		nameBox.add(lblSearchBar);
		InputPanel.add(nameBox);
		add(InputPanel, BorderLayout.CENTER);
	}

	public JLabel createlabel(String prompt)
	{
		JLabel createlabel = new JLabel(prompt);
		return createlabel;
	}
	
	public void ReadResultsFile(String Name) throws FileNotFoundException
	{
		String FileName = Name;
		FileName += ".txt";
		File toRead = new File(FileName);
		Scanner Results = new Scanner(toRead);
		
		//Declarations
		Results.useDelimiter(",");
		String strLastName = "";
		String strFirstName;
		String strNation;
		int intLaneNumber;
		double dReactionTime;
		double dFinishTime;
		int intRankingNumber;
		
		//Finds checked boxes and prints results
		do
		{
			strLastName = Results.next();
			strFirstName = Results.next();
			strNation = Results.next();
			intLaneNumber = Integer.parseInt(Results.next());
			dReactionTime = Double.parseDouble(Results.next());
			dFinishTime = Double.parseDouble(Results.next());
			intRankingNumber = Integer.parseInt(Results.next());
	
		} while (Results.hasNext(","));
		
		Output(strLastName,strFirstName,strNation,intLaneNumber,dReactionTime,dFinishTime,intRankingNumber);
	}
	
	public void Output(String strLastName, String strFirstName,	String strNation, int intLaneNumber, double dReactionTime, double dFinishTime, int intRankingNumber)
	{
		if(LastName.isSelected()==true)
			System.out.println(strLastName);
		
		if(FirstName.isSelected()==true)
			System.out.println(strFirstName);
		
		if(Nation.isSelected()==true)
			System.out.println(strNation);
		
		if(LaneNumber.isSelected()==true)
			System.out.println(intLaneNumber);
		
		if(ReactionTime.isSelected()==true)
			System.out.println(dReactionTime);
		
		if(FinishTime.isSelected()==true)
			System.out.println(dFinishTime);
		
		
		if(Ranking.isSelected()==true)
			System.out.println(intRankingNumber);

	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
				switch(e.getActionCommand())
				{
					case "Clear":
					athletes.setSelectedIndex(0);
					break;
					case "Exit":
					System.exit(0);
					break;
					case "Enter":
					if(athletes.getSelectedIndex() == 0) {
						System.out.println("Please select a runner first");
						break;}
					else {
						try {
							ReadResultsFile((String)athletes.getSelectedItem());
						} catch (FileNotFoundException e1) {e1.printStackTrace();}
						break;}
					
				}
			}
	}
}