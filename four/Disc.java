package four;

public final class Disc {
	int playerID;
	public int  getPlayerID() { return playerID; }
	public void setPlayerID(int id) { playerID = id; }
	
	public      Disc() { }
	public      Disc(int id) { setPlayerID(id); }
}
