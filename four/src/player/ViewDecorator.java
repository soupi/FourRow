package player;

import game.Game;

import java.util.Observable;
import java.util.Observer;

public abstract class ViewDecorator implements View, Observer {

	View view;
	
	public ViewDecorator(View view)
	{
		this.view = view;
	}

	public void update(Observable o, Object arg) {
		print();		
	}

	public game.Board getBoard() {
		return view.getBoard();
	}

	public Game getGame() {
		return view.getGame();
	}
	public void setGame(Game game) {
		view.setGame(game);
	}
}
