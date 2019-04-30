package mvc;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConnectFourView extends JFrame {
	
	public ConnectFourView() {
        // Set the title bar text
        setTitle("Connect Four");

        // Set the size of the GUI
        setSize(900, 750);
        
        // Set background of the GUI
        setBackground(Color.DARK_GRAY);
        
        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build the panel and add it to the frame
        buildBoard();

        //Display the window
        setVisible(true);
	}
	
	private void buildBoard() {
		
		Board board = new Board();
		ButtonView buttons = new ButtonView();
		SideButtons sideButtons = new SideButtons();
		add(board, BorderLayout.CENTER);
		add(buttons, BorderLayout.NORTH);
		add(sideButtons, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new ConnectFourView();
	}
}
