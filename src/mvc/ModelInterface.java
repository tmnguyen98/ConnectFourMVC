/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ModelInterface.java
 */

package mvc;

/**
 * An interface for the model class
 * @author tuan nguyen
 *
 */
public interface ModelInterface {
	void setPlayer(int row, int playerTurn);
	int getPlayer(int column, int row);
	void registerObserver(PlayerObserver o);
	void removeObserver(PlayerObserver o);
	void registerObserver(WinnerObserver o);
	void removeObserver(WinnerObserver o);
	void setPosition(int row);
	int[] getPosition();
	void setPlayerTurn(int turn);
	int getPlayerTurn();
	void reset();
	void checkCondition();
}
