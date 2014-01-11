package player;

import game.Disc;
import game.Game;

import java.util.Observable;
import java.util.Observer;

public abstract class ViewDecorator implements View, Observer {

	View view;
	
	public ViewDecorator(View view)
	{
		this.view = view;
	}

	@Override
	public void update(Observable o, Object arg) {
		print();		
	}

	@Override
	public Disc[][] getMatrix() {
		return view.getMatrix();
	}

	@Override
	public Game getGame() {
		return view.getGame();
	}
	public void setGame(Game game) {
		view.setGame(game);
	}
}
