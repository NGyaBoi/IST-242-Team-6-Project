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
	private static final int frame_HEIGHT = 400;
	private static final int frame_WIDTH = 300;
	JLabel lblSearchBar = createlabel("Choose an athlete");
	JTextField txtName = textfield();
	JComboBox athletes;
	boolean pointer = false;
	
	public GUi() throws FileNotFoundException
	{
		Scanner console = new Scanner(System.in);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meter Dash Search Tool");
		setSize(frame_HEIGHT, frame_WIDTH);
		
		String[] athleteNames = {"Please Select ", "Usain Bolt", "Justin Gatlin", "Andre De Grasse", "Yohan Blake", "Akani Simbine", "Ben Youssef Meite", "Jimmy Vicaut", "Trayvon Bromell"};
		athletes = new JComboBox(athleteNames);
		
		JPanel ComboPanel = new JPanel();
		ComboPanel.setLayout(new GridLayout(1,1));;
		ComboPanel.add(lblSearchBar);
		ComboPanel.add(athletes);
		add(ComboPanel, BorderLayout.NORTH);
		
		JPanel CheckPanel = new JPanel();
		//CheckPanel.setLayou);
		CheckPanel.setLayout(new GridLayout(7,1));
		JCheckBox FirstName = new JCheckBox("Display the Runner's First Name", false);
		JCheckBox LastName = new JCheckBox("Display the Runner's Last Name", false);
		JCheckBox Nation = new JCheckBox("Display the Runner's Nation of Origin", false);
		JCheckBox LaneNumber = new JCheckBox("Display the Lane Number", false);
		JCheckBox ReactionTime = new JCheckBox("Display the Runner's Reaction Time", false);
		JCheckBox FinishTime = new JCheckBox("Display the Finishing Time", false);
		JCheckBox Ranking = new JCheckBox("Display the Runner's Ranking", false);
		CheckPanel.add(FirstName);
		CheckPanel.add(LastName);
		CheckPanel.add(Nation);
		CheckPanel.add(LaneNumber);
		CheckPanel.add(ReactionTime);
		CheckPanel.add(FinishTime);
		CheckPanel.add(Ranking);
		add(CheckPanel,BorderLayout.WEST);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		JButton enter = new JButton("Enter");
		JButton exit = new JButton("Exit");
		JButton clear = new JButton("Clear");
		buttonPanel.add(clear);
		buttonPanel.add(enter);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
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
	
	public JTextField textfield()
	{
		JTextField textfield = new JTextField();
		return textfield;
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
		
		Results.useDelimiter(",");
		String strLastName = "";
		String strFirstName;
		String strNation;
		int intLaneNumber;
		double dReactionTime;
		double dFinishTime;
		int intRankingNumber;
		
		do
		{
			strLastName = Results.next();
			System.out.println(strLastName);
			
			strFirstName = Results.next();
			System.out.println(strFirstName);
			
			strNation = Results.next();
			System.out.println(strNation);
			
			intLaneNumber = Integer.parseInt(Results.next());
			System.out.println(intLaneNumber);
			
			dReactionTime = Double.parseDouble(Results.next());
			System.out.println(dReactionTime);
			
			dFinishTime = Double.parseDouble(Results.next());
			System.out.println(dFinishTime);
			
			intRankingNumber = Integer.parseInt(Results.next());
			System.out.println(intRankingNumber);
			
		} while (Results.hasNext(","));
			
			
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