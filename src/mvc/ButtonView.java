package mvc;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonView extends JPanel {
	JButton[] buttongroup = new JButton[7]; 
	
	public ButtonView() {
		
		for (int i = 0; i < 7; i++) {
			JButton button = buildButton();
			buttongroup[i] = button;
		}
		
		setLayout(new GridLayout(1,7));
		
		for (int i = 0; i < 7; i++) {
			add(buttongroup[i]);
		}
	}

	private JButton buildButton() {
		JButton singleButton = new JButton("Press here");
		return singleButton;
	}
}
