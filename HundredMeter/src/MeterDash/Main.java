/*
 * 
 */

package MeterDash;

import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		GUi frame = new GUi();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("100m Dash Seach Tool");
		frame.setVisible(true);
	}
}
