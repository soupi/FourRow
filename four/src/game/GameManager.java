package game;

import java.util.Observer;

import player.Player;


/**
 * The GameManager creates a game objects and loops through until the game is finished
 * @author suppi
 *
 */
public final class GameManager {
	Game game;
	
	/**
	 * initializing the game. it creates new players and viewers and adds them to the game.
	 * @param fact an AbstractPlayerFactory which will be used to create the players
	 */
	public GameManager(AbstractPlayerFactory fact)
	{
		game = new Game();
		
		Player[] players = fact.getNewPlayers();
		game.addPlayers(players);
		for ( Player player : players)
		{
			player.getView().setGame(game);
			this.addViewer(player.getView());
		}
	}
	
	/**
	 * 	 * adds a viewer to the game
	 * @param view the view to be added
	 */
	public void addViewer(Observer view)
	{
		game.addObserver(view);
	}
	
	/**
	 * removes a viewer from the game
	 * @param view view to be deleted
	 */
	public void deleteViewer(player.View view)
	{
		game.deleteObserver(view);
	}
	
	/**
	 * loops through the game until it is finished
	 */
	public void loop() {
		while (!game.isFinished())
			try { game.makeMove(); }
			catch (Exception e) { System.err.println("error while calling game.makeMove(): " + e.toString()); break; }
	}
}
