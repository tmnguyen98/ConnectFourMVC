package mvc;

public interface ModelInterface {
	void registerObserver(PlayerObserver o);
	void removeObserver(PlayerObserver o);
}
