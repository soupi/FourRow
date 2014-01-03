package game;

import player.Player;

public final class GameManager {
	Game game;
	
	public void init(AbstractPlayerFactory fact)
	{
		game = new Game();
		Player player = fact.getNewPlayer();
		game.addPlayer(player);
		game.addObserver(player.getView());
	}
	
	public void loop() { 	
		game.makeMove();
	}
}
