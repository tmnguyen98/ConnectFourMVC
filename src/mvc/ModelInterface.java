package mvc;

public interface ModelInterface {
	void setPlayer(int row, int playerTurn);
	int getPlayer(int column, int row);
	void registerObserver(PlayerObserver o);
	void removeObserver(PlayerObserver o);
	void setPosition(int row);
	int[] getPosition();
	void setPlayerTurn(int turn);
	int getPlayerTurn();
}
