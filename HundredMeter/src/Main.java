/*
 * 
 */

import javax.swing.JFrame;

import MeterDash.GUi;

public class Main
{
	public static void main(String[] args)
	{
		GUi frame = new GUi();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("100m Dash Seach Tool");
		frame.setVisible(true);
	}
}
