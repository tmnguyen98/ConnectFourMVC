package mvc;

public class ConnectFourController implements ControllerInterface {
    ModelInterface model;
    ConnectFourView view;

    public ConnectFourController(ModelInterface model) {
        this.model = model;
        view = new ConnectFourView(this, model);
        view.createView();
    }
    
    public void setPlayer(int column, int row, int playerTurn) {
    	model.setPlayer(column, row, playerTurn);
    }
}
