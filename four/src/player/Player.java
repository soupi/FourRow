package player;

/**
 * a player for the four in a row game
 * @author Gil Mizrahi
 *
 */
public final class Player implements IPlayer {
	private int id;
	IPlayerStrategy strategy;
	View            view;

	public void setStrategy(IPlayerStrategy strategy) { this.strategy = strategy; }
	public void setView(View view) { this.view = view; }
	public View getView()     { return view; }
	public int  getID()       { return id; }
	public void setID(int id) { this.id = id; }
	public int  makeMove()    { return strategy.makeMove(id, view.getBoard()); }
	public String toString()  { return String.valueOf(id); }
}
