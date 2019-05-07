package mvc;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ConnectFourModel implements ModelInterface {

	ArrayList<PlayerObserver> playerObserver = new ArrayList<PlayerObserver>();
	public int[][] player = new int[6][7];
	public static int[] playerPosition = new int[2];
	public int playerTurn = 1;
	
	public void setPlayer(int row, int playerTurn) {
		if (player[playerPosition[0]][playerPosition[1]] == 0) {
			player[playerPosition[0]][row] = playerTurn;
			notifyPlayerObservers();
		}
	}
	
	public int getPlayer(int column, int row) {
		return player[column][row];
	}
	
	public void notifyPlayerObservers() {
		for (int i = 0; i < playerObserver.size(); i++) {
			PlayerObserver observer = (PlayerObserver)playerObserver.get(i);
			observer.updatePlayer();
			
		}
	}
	
	@Override
	public void registerObserver(PlayerObserver o) {
		playerObserver.add(o);
		
	}

	@Override
	public void removeObserver(PlayerObserver o) {
		int i = playerObserver.indexOf(o);
		if (i >= 0) {
			playerObserver.remove(i);
		}
		
	}

	@Override
	public void setPosition(int row) {
		playerPosition[1] = row;
		int columnPosition = 5;
		boolean checker = true;
		while ((columnPosition >= 0) && (checker)) {
			if (player[columnPosition][row] == 0) {
				playerPosition[0] = columnPosition;
				checker = false;
			}
			columnPosition--;
		}
		
	}

	@Override
	public int[] getPosition() {
		return playerPosition;
	}

	@Override
	public void setPlayerTurn(int turn) {
		if (player[playerPosition[0]][playerPosition[1]] != turn) {
			playerTurn = turn;
		}
		
	}

	@Override
	public int getPlayerTurn() {
		return playerTurn;
		
	}

	@Override
	public void reset() {
		player = new int[6][7];
		playerPosition = new int[2];
		playerTurn = 1;
		ConnectFourView.numClicking = new int[7];
	}
	
}
