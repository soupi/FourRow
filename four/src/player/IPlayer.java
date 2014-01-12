package player;

public interface IPlayer {
	void setStrategy(IPlayerStrategy strategy);
	void setView(View view);
	View getView();
	int  getID();
	void setID(int id);
	int  makeMove();
	String toString();
}