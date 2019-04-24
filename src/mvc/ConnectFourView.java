package mvc;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnectFourView extends JFrame {
	
	public ConnectFourView() {
        // Set the title bar text
        setTitle("Connect Four");

        // Set the size of the GUI
        setSize(900, 750);
        
        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build the panel and add it to the frame
        buildBoard();

        //Display the window
        setVisible(true);
	}
	
	private void buildBoard() {
		
		Board board = new Board();
		this.setContentPane(board);
	}

	public static void main(String[] args) {
		new ConnectFourView();
	}
}
