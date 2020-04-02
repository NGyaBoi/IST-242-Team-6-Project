package MeterDash;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class GUi extends JFrame implements ActionListener
{
	private static final int frame_HEIGHT = 400;
	private static final int frame_WIDTH = 300;
	JLabel lblSearchBar = createlabel("Please enter the athlete.");
	JTextField txtName = textfield();
	JComboBox athletes;

	public GUi()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meter Dash Search Tool");
		setSize(frame_HEIGHT, frame_WIDTH);
		
		String[] athleteNames = {"", "More to be added"}
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		JButton enter = new JButton("Enter");
		JButton exit = new JButton("Exit");
		JButton clear = new JButton("Clear");
		buttonPanel.add(clear);
		buttonPanel.add(enter);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		athletes = new JComboBox(athleteName);
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
}
