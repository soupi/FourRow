package player;

import game.Game;

import java.util.Observable;
import java.util.Observer;

/**
 * abstract class for view decorator
 * @author Gil Mizrahi
 *
 */
public abstract class ViewDecorator implements View, Observer {

	View view;
	/**
	 * Constructor
	 * @param view
	 */
	public ViewDecorator(View view)
	{
		this.view = view;
	}

	/**
	 * Observer's update
	 */
	@Override
	public void update(Observable o, Object arg) {
		print();
	}

	/**
	 * returns the board of the game
	 */
	public game.Board getBoard() {
		return view.getBoard();
	}

	/**
	 * returns a reference for the game
	 */
	public Game getGame() {
		return view.getGame();
	}
	/**
	 * sets the game reference
	 */
	public void setGame(Game game) {
		view.setGame(game);
	}
}
