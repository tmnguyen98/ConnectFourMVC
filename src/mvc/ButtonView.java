package mvc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonView extends JPanel implements PlayerObserver {
	JButton[] buttongroup = new JButton[7];
	int rowIncreasing = 5;
	
	public ButtonView() {
		
		for (int i = 0; i < 7; i++) {
			JButton singleButton = new JButton(Integer.toString(i + 1));
			buttongroup[i] = singleButton;
		}
		
		setLayout(new GridLayout(1,7));
		
		for (int i = 0; i < 7; i++) {
			buttongroup[i].addActionListener(new ButtonListener());
			add(buttongroup[i]);
		}
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { 
			JButton column = (JButton) e.getSource();
			String message = (String) column.getText();

			if ((rowIncreasing >= 0) && (rowIncreasing % 2 == 0)) {
				Board.grid[rowIncreasing][Integer.parseInt(message)-1].setBackground(Color.RED);
			} else if ((rowIncreasing >= 0) && (rowIncreasing % 2 != 0)) {
				Board.grid[rowIncreasing][Integer.parseInt(message)-1].setBackground(Color.YELLOW);
			}
			rowIncreasing -= 1;
			
		}
		
	}

	@Override
	public void updatePlayer() {
		// TODO Auto-generated method stub
		
	}
}
