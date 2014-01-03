package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import player.Player;

public class Game extends Observable {
	private Board        board;
	private List<Player> players = new ArrayList<Player>();
	private int          turn    = 0;
	
	public int          getTurn() { return turn; }
	public Board        getBoard() { return board; }
	public List<Player> getPlayers() { return players; }
	Boolean             makeMove() 
	{ 
		if (turn > players.size())
			return false; // throw exception
		
		// try to add until success
		while (!board.addDisc(players.get(turn).makeMove(), DiscFactory.getInstance().getDisc(players.get(turn).getID())));
		board.checkWinConditions();
		++turn;
		if (turn >= players.size()) // turn around
			turn = 0;
		
	    setChanged();
	    notifyObservers(board);
		
		return true; 
	}
}
