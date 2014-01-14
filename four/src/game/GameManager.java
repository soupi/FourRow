package game;

import java.util.Observer;

import player.AbstractPlayerFactory;
import player.IPlayer;


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
		
		IPlayer[] players = fact.getNewPlayers();
		game.addPlayers(players);
		for (IPlayer player : players)
		{
			player.View view = player.getView();
			view.setGame(game);
			this.addViewer(view);
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
	public int loop() {
		while (!game.isFinished())
			try { game.makeMove(); }
			catch (Exception e) { System.err.println("error while calling game.makeMove(): " + e.toString()); break; }
		
		/* -------- */
		for (int i = 0; i < game.getBoard().ROWS; ++i)
		{
			for (int j = 0; j < game.getBoard().COLS; ++j)
				System.out.print(game.getBoard().getDisc(i, j) + " ");
			System.out.println("");
		}
		/* ---------*/
		return game.getWinner();
	}
}
