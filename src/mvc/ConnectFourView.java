/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ConnectFourView.java
 */

package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A class that represent the view of MVC for ConnectFour game
 * @author tuan nguyen
 *
 */
public class ConnectFourView extends JFrame implements PlayerObserver, WinnerObserver{
	
	JButton[] buttongroup = new JButton[7];
	static int[] numClicking = new int[7];
	JPanel playButtonJPanel = new JPanel();
	ControllerInterface controller;
	ModelInterface model;
	JFrame view = new JFrame();

	public ConnectFourView(ControllerInterface controller, ModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((PlayerObserver) this);
		model.registerObserver((WinnerObserver) this);
	}
	
	/**
	 * A method that create the frame and panel for the game
	 */
	public void createView() {
		
        // Set the title bar text
        view.setTitle("Connect Four");

        // Set the size of the GUI
        view.setSize(900, 750);
        
        // Set background of the GUI
        view.setBackground(Color.DARK_GRAY);
        
        // Specify an action for the close button
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build the panel and add it to the frame
        buildBoard();

        //Display the window
        view.setVisible(true);
	}
	
	/**
	 * A sub class that build the front-end of the game
	 */
	private void buildBoard() {
		
		Board board = new Board();
		buildButtonGroup();
		SideButtons sideButtons = new SideButtons(this.controller);
		view.add(board, BorderLayout.CENTER);
		view.add(this.playButtonJPanel, BorderLayout.NORTH);
		view.add(sideButtons, BorderLayout.SOUTH);

	}

	/**
	 * A sub class that build the upper buttons, mainly for the game
	 */
	private void buildButtonGroup() {
		//Create 7 buttons
		for (int i = 0; i < 7; i++) {
			JButton singleButton = new JButton(Integer.toString(i + 1));
			buttongroup[i] = singleButton;
		}
		
		playButtonJPanel.setLayout(new GridLayout(1,7));
		
		//Add button to the game
		for (int i = 0; i < 7; i++) {
			buttongroup[i].addActionListener(new ButtonListener());
			playButtonJPanel.add(buttongroup[i]);
		}
	}
	
	/**
	 * A sub class that implement the action for the game
	 * @author tuan nguyen
	 *
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Get the information needed
			JButton column = (JButton) e.getSource();
			String message = (String) column.getText();
			int playerPosition[] = model.getPosition();
			
			//Check if the position is outside the board
			if (playerPosition[0] >= 0) {
				//Set the position and the turn
				controller.setPosition(Integer.parseInt(message)-1);
				int playerTurn = model.getPlayerTurn();

				//Turn for first player
				if ((playerTurn == 1)) {
					controller.setPlayer(Integer.parseInt(message)-1, 1);
					controller.checkCondition();
					controller.setPlayerTurn(2);
				//Turn for second player
				} else if ((playerTurn == 2)) {
					controller.setPlayer(Integer.parseInt(message)-1, 2);
					controller.checkCondition();
					controller.setPlayerTurn(1);
				}
			}
		}
		
	}
	/**
	 * A sub class for the observer pattern use to change the interface of the game
	 */
	@Override
	public void updatePlayer() {
		int[] playerPosition = model.getPosition();
		int player = model.getPlayer(playerPosition[0], playerPosition[1]);
		//Check the number clicking of user
		if (numClicking[playerPosition[1]] < 6) {
			//Player 1 turn -> change panel to red
			if ((player == 1)) {
				Board.grid[playerPosition[0]][playerPosition[1]].setBackground(Color.RED);
				numClicking[playerPosition[1]]++;
			//Player 2 turn -> Change panel to yellow
			} else if ((player == 2)) {
				Board.grid[playerPosition[0]][playerPosition[1]].setBackground(Color.YELLOW);
				numClicking[playerPosition[1]]++;
			}	
		}

	}

	/**
	 * A sub class for the observer pattern that show who is the winner
	 */
	@Override
	public void updateWinner(String result) {
		if (result == "draw") {
			// Display the result
			JOptionPane.showMessageDialog(null, "Two players are draw");
		} else if (result.equals("1")) {
			JOptionPane.showMessageDialog(null, "Player 1 won");
		} else if (result.equals("2")) {
			JOptionPane.showMessageDialog(null, "Player 2 won");
		}
		
	}
}
