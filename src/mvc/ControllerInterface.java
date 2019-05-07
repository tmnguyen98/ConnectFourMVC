package mvc;

public interface ControllerInterface {
	void setPlayer(int row, int playerTurn);
	void setPosition(int row);
	void setPlayerTurn(int turn);
	void reset();
}
