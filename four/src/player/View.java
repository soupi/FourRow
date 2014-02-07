package player;

import java.util.Observer;

import game.Game;

/**
 * View for the game
 * @author Gil Mizrahi
 *
 */
public interface View extends Observer 
{
	void print();
	game.Board getBoard();
	Game getGame();
	void setGame(Game game);
}
