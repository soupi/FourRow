package player;

public final class Player {
	private int id;
	IPlayerStrategy strategy;
	View            view;
	
	public void setStrategy(IPlayerStrategy strategy) { this.strategy = strategy; }
	public void setView(View view) { this.view = view; }
	public View getView()     { return view; }
	public int  getID()       { return id; }
	public void setID(int id) { this.id = id; }
	public int  makeMove()    { return strategy.makeMove(id, view.getMatrix()); }
}
