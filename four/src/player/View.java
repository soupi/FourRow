package player;

import java.util.Observable;
import java.util.Observer;

import game.Disc;
import game.Game;

public abstract class View implements Observer {
	Game game;
	public void update(Observable o, Object arg)
	{
		print();
	}
	public abstract void print();
	public Disc[][] getMatrix() {
		return game.getBoard().getMatrix();
	}
}