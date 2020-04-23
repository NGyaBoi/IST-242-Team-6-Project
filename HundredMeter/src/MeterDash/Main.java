/* Project Name:	Hundred Meter Dash
 * Team:			6
 * Authors:			Yifan Feng, Neel Ghosh, Matthew Marone
 * Section:			IST 242
 * Description		Pulls data from Men's 100m Dash at the 2016 Summer Olympics
 * 					and displays them at the user's request.
 * Date Created:	1/28/2020
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
