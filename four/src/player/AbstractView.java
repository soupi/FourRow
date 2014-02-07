package player;

import java.util.Observable;
import java.util.Observer;
import game.Game;

/**
 * abstract view class for the game.
 * print() needs to be overriden
 * @author Gil Mizrahi
 *
 */
public abstract class AbstractView implements View, Observer {
	Game game;

	@Override
	public void update(Observable o, Object arg)
	{
		print();
	}
	public abstract void print();
	/**
	 * returns the game board
	 */
	public game.Board getBoard() {
		return game.getBoard();
	}
	/**
	 * returns the reference to the game object
	 */
	public Game getGame() { return game; }
	/**
	 * sets reference to the game object
	 */
	public void setGame(Game g) { this.game = g; }
}
