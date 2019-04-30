package mvc;

import java.util.ArrayList;

public class ConnectFourModel implements ModelInterface {

	ArrayList<PlayerObserver> playerObserver = new ArrayList<PlayerObserver>();
	
	public void notifyPlayerObservers() {
		for (int i = 0; i < playerObserver.size(); i++) {
			PlayerObserver observer = (PlayerObserver)playerObserver.get(i);
			
		}
	}
	
	@Override
	public void registerObserver(PlayerObserver o) {
		playerObserver.add(o);
		
	}

	@Override
	public void removeObserver(PlayerObserver o) {
		int i = playerObserver.indexOf(o);
		if (i >= 0) {
			playerObserver.remove(i);
		}
		
	}
	
}
