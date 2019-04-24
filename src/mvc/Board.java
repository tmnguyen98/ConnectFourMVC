package mvc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	private int spacing = 5;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1400, 1200);
		g.setColor(Color.GRAY);
		drawSquare(g);
	}

	private void drawSquare(Graphics g) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				g.fillRect(spacing+i*100, spacing+j*100+100, 100-2*spacing, 100-2*spacing);
			}
		}
		
	}
}
