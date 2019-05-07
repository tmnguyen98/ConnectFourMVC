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
import javax.swing.JPanel;

public class ConnectFourView extends JFrame implements PlayerObserver{
	
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
	}
	
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
	
	private void buildBoard() {
		
		Board board = new Board();
		buildButtonGroup();
		SideButtons sideButtons = new SideButtons(this.controller);
		view.add(board, BorderLayout.CENTER);
		view.add(this.playButtonJPanel, BorderLayout.NORTH);
		view.add(sideButtons, BorderLayout.SOUTH);

	}

	private void buildButtonGroup() {
		for (int i = 0; i < 7; i++) {
			JButton singleButton = new JButton(Integer.toString(i + 1));
			buttongroup[i] = singleButton;
		}
		
		playButtonJPanel.setLayout(new GridLayout(1,7));
		
		for (int i = 0; i < 7; i++) {
			buttongroup[i].addActionListener(new ButtonListener());
			playButtonJPanel.add(buttongroup[i]);
		}
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { 
			JButton column = (JButton) e.getSource();
			String message = (String) column.getText();
			int playerPosition[] = model.getPosition();
			
			if (playerPosition[0] >= 0) {
				controller.setPosition(Integer.parseInt(message)-1);
				int playerTurn = model.getPlayerTurn();

				
				if ((playerTurn == 1)) {
					controller.setPlayer(Integer.parseInt(message)-1, 1);
					controller.setPlayerTurn(2);
				} else if ((playerTurn == 2)) {
					controller.setPlayer(Integer.parseInt(message)-1, 2);
					controller.setPlayerTurn(1);
				}
			}
		}
		
	}
	
	@Override
	public void updatePlayer() {
		int[] playerPosition = model.getPosition();
		int player = model.getPlayer(playerPosition[0], playerPosition[1]);
		if (numClicking[playerPosition[1]] < 6) {
			if ((player == 1)) {
				Board.grid[playerPosition[0]][playerPosition[1]].setBackground(Color.RED);
				numClicking[playerPosition[1]]++;
			} else if ((player == 2)) {
				Board.grid[playerPosition[0]][playerPosition[1]].setBackground(Color.YELLOW);
				numClicking[playerPosition[1]]++;
			}	
		}

	}
}
