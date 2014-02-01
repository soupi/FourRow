
package game;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import player.IPlayer;

/**
 * The Game is responsible for controlling the game. it selects the current player to play and changes the board.
 * Game extends Observable and notify its observers when the board has changed.
 * @author suppi
 *
 */
public class Game extends Observable 
{
	private Board board = new Board(new FourInRowLogic());
	private Queue<IPlayer> players = new LinkedList<IPlayer>(); 
	
	/**
	 * adds players to queue
	 * @param players players to add
	 */
	void addPlayers(IPlayer[] players) 
	{
		for (IPlayer player : players)
			this.players.add(player);
	}
	public IPlayer[] getPlayersQueue() { return (IPlayer[]) players.toArray(); }
	public int      getWinner() { return board.getWinnerID(); }
	public boolean  isFinished() { return board.isFinished(); }
	public Board    getBoard() { return board; }
	void            makeMove() throws Exception 
	{ 
		if (players.size() < 1)
			throw new Exception("insufficient number of players");
		if (isFinished())
			throw new Exception("game is already finished");
			
		IPlayer currPlayer = players.poll();
		// try to add until success
		while (!board.addDisc(currPlayer.makeMove(), DiscFactory.getInstance().getDisc(currPlayer.getID())));
		players.add(currPlayer);
		
		board.checkFinishConditions();
		
	    setChanged();
	    notifyObservers(board);
	}
}
