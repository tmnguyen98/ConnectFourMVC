/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ConnectFourModel.java
 */
package mvc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JPanel;

/**
 * A model class represent for MVC for the ConnectFour game
 * @author tuan nguyen
 *
 */
public class ConnectFourModel implements ModelInterface {

	ArrayList<PlayerObserver> playerObserver = new ArrayList<PlayerObserver>();
	ArrayList<WinnerObserver> winnerObservers = new ArrayList<WinnerObserver>();
	public int[][] player = new int[6][7];
	public static int[] playerPosition = new int[2];
	public int playerTurn = 1;
	static int totalBoardChecking = 0;
	
	/**
	 * A class that set which player play
	 * @param row The row of the player drop
	 * @param playerTurn the turn of the player
	 */
	public void setPlayer(int row, int playerTurn) {
		//Check if that position already have the move of the player
		if (player[playerPosition[0]][playerPosition[1]] == 0) {
			player[playerPosition[0]][row] = playerTurn;
			totalBoardChecking++;				//Checking if the board is full
			notifyPlayerObservers();
		}
	}
	
	/**
	 * A class that get the turn of the Player
	 * @param column the column of that player
	 * @param row the row of that player
	 */
	public int getPlayer(int column, int row) {
		return player[column][row];
	}
	
	/**
	 * A notify class for the observer pattern
	 */
	public void notifyPlayerObservers() {
		for (int i = 0; i < playerObserver.size(); i++) {
			PlayerObserver observer = (PlayerObserver)playerObserver.get(i);
			observer.updatePlayer();
			
		}
	}
	
	/**
	 * A register observer for the observer pattern
	 */
	@Override
	public void registerObserver(PlayerObserver o) {
		playerObserver.add(o);
		
	}

	/**
	 * A remove observer for the observer pattern
	 */
	@Override
	public void removeObserver(PlayerObserver o) {
		int i = playerObserver.indexOf(o);
		if (i >= 0) {
			playerObserver.remove(i);
		}
		
	}

	/**
	 * A class that set the position of the player
	 */
	@Override
	public void setPosition(int row) {
		playerPosition[1] = row;
		int columnPosition = 5;
		boolean checker = true;
		//CHeck whether out of the board and player already used the postion
		while ((columnPosition >= 0) && (checker)) {
			if (player[columnPosition][row] == 0) {
				playerPosition[0] = columnPosition;
				checker = false;
			}
			columnPosition--;
		}
		
	}
	/**
	 * A class that get the position of the board
	 */
	@Override
	public int[] getPosition() {
		return playerPosition;
	}

	/**
	 * A class that set the player's turn
	 * @param turn the player turn
	 */
	@Override
	public void setPlayerTurn(int turn) {
		//Check the panel to make sure user turn, not other's turn
		if (player[playerPosition[0]][playerPosition[1]] != turn) {
			playerTurn = turn;
		}
		
	}

	/**
	 * A class that get the player's turn
	 */
	@Override
	public int getPlayerTurn() {
		return playerTurn;
		
	}

	/**
	 * A class that use for the reset button that reset everything
	 */
	@Override
	public void reset() {
		player = new int[6][7];
		playerPosition = new int[2];
		playerTurn = 1;
		ConnectFourView.numClicking = new int[7];
		totalBoardChecking = 0;
	}

	/**
	 * A class used for observer pattern
	 */
	@Override
	public void registerObserver(WinnerObserver o) {
		winnerObservers.add(o);
		
	}

	/**
	 * A class used for observer pattern
	 */
	@Override
	public void removeObserver(WinnerObserver o) {
		int i = winnerObservers.indexOf(o);
		if (i >= 0) {
			winnerObservers.remove(i);
		}
		
	}
	
	/**
	 * A class represent the observer pattern
	 * @param result the result of the game, whether draw or win, lose
	 */
	public void notifyWinnerObservers(String result) {
		for (int i = 0; i < winnerObservers.size(); i++) {
			WinnerObserver observer = (WinnerObserver)winnerObservers.get(i);
			observer.updateWinner(result);
			
		}
	}

	/**
	 * A class that check the condition to win the game
	 */
	@Override
	public void checkCondition() {
		rowChecking();
		columnChecking();
		positiveHorizontalChecking();
		negativeHorizontalChecking();
		TotalBoardChecking();
		
	}
	
	/**
	 * A class that check whether user filled the board
	 */
	private void TotalBoardChecking() {
		if (totalBoardChecking == 42) {
			notifyWinnerObservers("draw");
		}
	}
	
	/**
	 * A class that check the row
	 */
	private void rowChecking() {
		int rightmatch = 1;
		int leftmatch = 1;
		
		//User drop from left to right
		for (int i = playerPosition[1]; i > 0; i--) {
			if (player[playerPosition[0]][i] != player[playerPosition[0]][i-1]) {
				break;
			}
			rightmatch++;
		}
		
		//User drop from right to left
		for (int i = playerPosition[1]; i < 6; i++) {
			if (player[playerPosition[0]][i] != player[playerPosition[0]][i+1]) {
				break;
			}
			leftmatch++;
		}
		
		//Check whether have 4 matches
		if ((rightmatch == 4) || (leftmatch == 4)) {
			int result = player[playerPosition[0]][playerPosition[1]];
			notifyWinnerObservers(Integer.toString(result));
		}
	}
	
	/**
	 * A class that check the column
	 */
	private void columnChecking() {
		int leftmatch = 1;
		
		/**
		 * Check the column went from bottom to top
		 */
		for (int i = playerPosition[0]; i < 5; i++) {
			if (player[i][playerPosition[1]] != player[i+1][playerPosition[1]]) {
				break;
			}
			leftmatch++;
		}
		
		/**
		 * Check whether having 4 matches
		 */
		if ((leftmatch == 4)) {
			int result = player[playerPosition[0]][playerPosition[1]];
			notifyWinnerObservers(Integer.toString(result));
		}
	}
	
	/**
	 * A class that check the horizontal condition
	 */
	private void positiveHorizontalChecking() {
		int rightmatch = 1;
		int leftmatch = 1;
		int verticalChange = playerPosition[0];
		int horizontalChange = playerPosition[1];
		
		//User do from down to up
		for (int i = playerPosition[0]; i > 0; i--) {
			if (horizontalChange == 6) {
				break;
			}else if (player[verticalChange][horizontalChange] != player[verticalChange-1][horizontalChange+1]) {
				break;
			}
			rightmatch++;
			verticalChange--;
			horizontalChange++;
		}
		
		//User do from up to down
		verticalChange = playerPosition[0];
		horizontalChange = playerPosition[1];
		for (int i = playerPosition[1]; i > 0; i--) {
			if (verticalChange == 5) {
				break;
			} else if (player[verticalChange][horizontalChange] != player[verticalChange+1][horizontalChange-1]) {
				break;
			}
			leftmatch++;
			verticalChange++;
			horizontalChange--;
			System.out.println("After: " + verticalChange + " " + horizontalChange);
		}
		
		//Check whether there are 4 matches or not
		if ((rightmatch == 4) || (leftmatch == 4)) {
			int result = player[playerPosition[0]][playerPosition[1]];
			notifyWinnerObservers(Integer.toString(result));
		}
	}
	
	/**
	 * A class that check the horizontal condition
	 */
	private void negativeHorizontalChecking() {
		int rightmatch = 1;
		int leftmatch = 1;
		int verticalChange = playerPosition[0];
		int horizontalChange = playerPosition[1];
		
		//Check user play from up to down
		for (int i = playerPosition[0]; i > 0; i--) {
			if ((horizontalChange == 0) || (verticalChange == 0)) {
				break;
			}else if (player[verticalChange][horizontalChange] != player[verticalChange-1][horizontalChange-1]) {
				break;
			}
			rightmatch++;
			verticalChange--;
			horizontalChange--;
		}
		
		//Check user play from down to up
		verticalChange = playerPosition[0];
		horizontalChange = playerPosition[1];
		for (int i = playerPosition[0]; i < 5; i++) {
			if ((horizontalChange == 6) || (verticalChange == 5)) {
				break;
			} else if (player[verticalChange][horizontalChange] != player[verticalChange+1][horizontalChange+1]) {
				break;
			}
			leftmatch++;
			verticalChange++;
			horizontalChange++;
			System.out.println("After: " + verticalChange + " " + horizontalChange);
		}
		
		//Check the match
		if ((rightmatch == 4) || (leftmatch == 4)) {
			int result = player[playerPosition[0]][playerPosition[1]];
			notifyWinnerObservers(Integer.toString(result));
		}
	}
	
}
