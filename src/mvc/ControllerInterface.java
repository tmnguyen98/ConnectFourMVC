/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ControllerInterface.java
 */

package mvc;

/**
 * A Interface for the controller of ConnectFour game
 * @author tuan nguyen
 *
 */
public interface ControllerInterface {
	void setPlayer(int row, int playerTurn);
	void setPosition(int row);
	void setPlayerTurn(int turn);
	void reset();
	void checkCondition();
}
