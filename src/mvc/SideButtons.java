package mvc;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SideButtons extends JPanel {
	JButton resetButton = new JButton("Reset");
	JButton exitButton = new JButton("Exit");
	
	public SideButtons() {
		add(resetButton);
		add(exitButton);
	}
}
