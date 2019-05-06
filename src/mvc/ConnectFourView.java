package mvc;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConnectFourView extends JFrame {
	
	ControllerInterface controller;
	ModelInterface model;
	JFrame view = new JFrame();

	public ConnectFourView(ControllerInterface controller, ModelInterface model) {
		this.controller = controller;
		this.model = model;
		//model.registerObserver((PlayerObserver) this);
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
		ButtonView buttons = new ButtonView();
		SideButtons sideButtons = new SideButtons();
		view.add(board, BorderLayout.CENTER);
		view.add(buttons, BorderLayout.NORTH);
		view.add(sideButtons, BorderLayout.SOUTH);
	}
}
