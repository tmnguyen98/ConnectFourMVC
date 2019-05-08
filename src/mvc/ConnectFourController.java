/**
 * Tuan Nguyen
 * CS 210
 * 5/7/2019
 * Lab 13
 * ConnectFourController.java
 */

package mvc;

/**
 * A model class represent MVC for ConnectFour game
 * @author tuan nguyen
 *
 */
public class ConnectFourController implements ControllerInterface {
    ModelInterface model;
    ConnectFourView view;

    /**
     * Constructor of controller class
     * @param model the model of the game
     */
    public ConnectFourController(ModelInterface model) {
        this.model = model;
        view = new ConnectFourView(this, model);
        view.createView();
    }
    
    /**
     * A class that talk to model about setting the player
     */
    public void setPlayer(int row, int playerTurn) {
    	model.setPlayer(row, playerTurn);
    }

    /**
     * A class that talk to model about setting the possition
     */
	@Override
	public void setPosition(int row) {
		model.setPosition(row);
		
	}

    /**
     * A class that talk to model about setting the next player Turn
     */
	@Override
	public void setPlayerTurn(int turn) {
		model.setPlayerTurn(turn);
		
	}

    /**
     * A class that talk to model about resetting the game
     */
	@Override
	public void reset() {
		model.reset();
		
	}

	/**
	 * A class that talk to model about checking the Condition to win the game
	 */
	@Override
	public void checkCondition() {
		model.checkCondition();
		
	}
}
