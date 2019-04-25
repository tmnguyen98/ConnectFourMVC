package mvc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	private int spacing = 5;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		drawSquare(g);
	}

	private void drawSquare(Graphics g) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				g.fillRect(spacing+i*105+75, spacing+j*105+50, 105-2*spacing, 105-2*spacing);
			}
		}
		
	}
}
