package mvc;

public class ConnectFourController implements ControllerInterface {
    ModelInterface model;
    ConnectFourView view;

    public ConnectFourController(ModelInterface model) {
        this.model = model;
        view = new ConnectFourView(this, model);
        view.createView();
    }
    
    public void setPlayer(int row, int playerTurn) {
    	model.setPlayer(row, playerTurn);
    }

	@Override
	public void setPosition(int row) {
		model.setPosition(row);
		
	}

	@Override
	public void setPlayerTurn(int turn) {
		model.setPlayerTurn(turn);
		
	}

	@Override
	public void reset() {
		model.reset();
		
	}
}
