package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	
	private class exitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
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
