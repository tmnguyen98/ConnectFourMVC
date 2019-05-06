package mvc;

public interface ModelInterface {
	void setPlayer(int column, int row, int playerTurn);
	void registerObserver(PlayerObserver o);
	void removeObserver(PlayerObserver o);
}
