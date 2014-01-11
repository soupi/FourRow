package player;

import java.util.Observer;

import game.Disc;
import game.Game;

public interface View extends Observer {
	void print();
	Disc[][] getMatrix();
	Game getGame();
	void setGame(Game game);
}
