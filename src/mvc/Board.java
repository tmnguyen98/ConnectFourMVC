/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * Board.java
 */

package mvc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A sub class for the view class in MVC class that build the board
 * @author tuan nguyen
 *
 */
public class Board extends JPanel {
	public static JPanel[][] grid = new JPanel[6][7];
	protected int[][] Player = new int[6][7];
	
	public Board() {
		//create the blocks
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				JPanel block = buildBlock();
				grid[i][j] = block;
			}
		}
		
		setLayout(new GridLayout(6,7));
		
		//Add the block to the panel
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				add(grid[i][j]);
			}
		}
		
	}

	/**
	 * A class to build each block of the board
	 * @return the panel, which is the block
	 */
	private JPanel buildBlock() {
		JPanel block = new JPanel();
		block.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		block.setBackground(Color.DARK_GRAY);
		return block;
	}
	
	
}
