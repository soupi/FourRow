package player;

import java.util.Observable;
import java.util.Observer;

import game.Disc;
import game.Game;

public abstract class AbstractView implements View, Observer {
	Game game;
	public void update(Observable o, Object arg)
	{
		print();
	}
	public abstract void print();
	public Disc[][] getMatrix() {
		return game.getBoard().getMatrix();
	}
	public Game getGame() { return game; }
	public void setGame(Game g) { this.game = g; }
}
