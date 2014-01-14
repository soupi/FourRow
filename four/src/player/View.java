package player;

import java.util.Observer;

import game.Game;

public interface View extends Observer {
	void print();
	game.Board getBoard();
	Game getGame();
	void setGame(Game game);
}
