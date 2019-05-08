/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ConnectFourTestDrivejava
 */

package mvc;

/**
 * A class that test the products, or the game
 * @author tuan nguyen
 *
 */
public class ConnectFourTestDrive {
    public static void main(String[] args) {
        ModelInterface model = new ConnectFourModel();
        ControllerInterface controller = new ConnectFourController(model);
    }
    
} 