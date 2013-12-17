package four;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board        board;
	private List<Player> players = new ArrayList<>();
	private int          turn = 0;
	
	
	public int          getTurn() { return turn; }
	public Board        getBoard() { return board; }
	public List<Player> getPlayers() { return players; }
	public Boolean      makeMove() 
	{ 
		if (turn > players.size())
			return false; // throw exception
		
		while (!board.addDisc(players.get(turn).makeMove(), new Disc(players.get(turn).getID())));
		
		++turn;
		if (turn >= players.size()) // turn around
			turn = 0;
		
		return true; 
	}
}
