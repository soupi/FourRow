package game;

import java.io.Serializable;

public final class Disc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int playerID;
	public int  getPlayerID() { return playerID; }
	public void setPlayerID(int id) { playerID = id; }
	
	public      Disc() { }
	public      Disc(int id) { setPlayerID(id); }
}
