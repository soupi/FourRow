package game;

import java.util.Observable;

import player.Player;

public class Game extends Observable 
{
	private Board    board;
	private Player[] players;
	private int      turn    = 0;
	
	void addPlayers(Player[] players) 
	{ 
		this.players = players; 
	}
	public boolean  isFinished() { return board.isFinished(); }
	public int      getTurn() { return turn; }
	public Board    getBoard() { return board; }
	public Player[] getPlayers() { return players; }
	void            makeMove() throws Exception 
	{ 
		if (turn > players.length)
			turn = 0;
		
		if (isFinished())
			throw new Exception("game is already finished");
		
		// try to add until success
		while (!board.addDisc(players[turn].makeMove(), DiscFactory.getInstance().getDisc(players[turn].getID())));
		board.checkWinConditions();
		++turn;
		if (turn >= players.length) // turn around
			turn = 0;
		
	    setChanged();
	    notifyObservers(board);
	}
}
