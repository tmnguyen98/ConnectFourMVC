/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * WinnerObserver.java
 */
package mvc;

/**
 * An interface for the observer pattern that notify about the winner
 * @author tuan nguyen
 *
 */
public interface WinnerObserver {
	void updateWinner(String result);
}
