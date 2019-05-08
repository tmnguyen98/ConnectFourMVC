/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * SideButtons.java
 */

package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A sub class for the view class that have reset button and exit button
 * @author tuan nguyen
 *
 */
public class SideButtons extends JPanel {
	JButton resetButton = new JButton("Reset");
	JButton exitButton = new JButton("Exit");
	ControllerInterface controller;
	
	public SideButtons(ControllerInterface controller) {
		this.controller = controller;
		exitButton.addActionListener(new exitButtonListener());
		resetButton.addActionListener(new resetButtonListener());
		add(resetButton);
		add(exitButton);
	}
	
	/**
	 * A sub class to implement the action of the exit button
	 * @author tuan nguyen
	 *
	 */
	private class exitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	/**
	 * A sub class to implement the action of the reset button
	 * @author tuan nguyen
	 *
	 */
	private class resetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
					Board.grid[i][j].setBackground(Color.DARK_GRAY);
				}
			}
			
			controller.reset();
		}
		
	}
}
