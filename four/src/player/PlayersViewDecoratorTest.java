package player;

import static org.junit.Assert.*;
import game.Board;
import game.Game;

import java.util.Observable;

import org.junit.Test;

public class PlayersViewDecoratorTest {

	@Test
	public void test() throws Exception {
		View view = new View()
		{

			@Override
			public void update(Observable o, Object arg) {}
			@Override
			public void print() {}
			@Override
			public Board getBoard() { return null; }
			@Override
			public Game getGame() {
				// Auto-generated method stub
				return new game.Game() { 
					public IPlayer[] getPlayersQueue() { 
						return new IPlayer[] { new Player() };
					}
				};
			}

			@Override
			public void setGame(Game game) { }
		};
		
		PlayersViewDecorator vd = new PlayersViewDecorator(view);
		vd.print();
	}
}
