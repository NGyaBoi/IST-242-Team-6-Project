package MeterDash;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUi extends JFrame 
{
	private static final int frame_HEIGHT = 400;
	private static final int frame_WIDTH = 300;
	JLabel lblSearchBar = createlabel("Choose an athlete");
	JTextField txtName = textfield();
	JComboBox athletes;
	boolean pointer = false;
	public GUi()
	{
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
		}while(pointer);
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
				}
			}
	}
}