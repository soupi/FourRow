package player;

public final class Player {
	private int id;
	IPlayerStrategy strategy;
	View            view;
	
	public int  getID()       { return id; }
	public void setID(int id) { this.id = id; }
	public int  makeMove()    { return strategy.makeMove(id, view.getMatrix()); }
	public View getView()     { return view; }
	
}
