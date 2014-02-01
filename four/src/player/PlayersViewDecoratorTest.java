package player;

import static org.junit.Assert.*;
import game.Board;
import game.Game;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

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
					public Queue<IPlayer> getPlayersQueue() { 
						Queue<IPlayer> queue = new LinkedList<IPlayer>();
						queue.add( new Player() );
						return queue;
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
