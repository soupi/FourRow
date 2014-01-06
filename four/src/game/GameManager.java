package game;

import player.Player;

public final class GameManager {
	Game game;
	
	public void init(AbstractPlayerFactory fact)
	{
		game = new Game();
		
		Player[] players = fact.getNewPlayers();
		game.addPlayers(players);
		for ( Player player : players)
			game.addObserver(player.getView());
	}
	
	public void loop() {
		while (!game.isFinished())
			try { game.makeMove(); }
			catch (Exception e) { break; }
	}
}
