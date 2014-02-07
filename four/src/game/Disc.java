package game;

import java.io.Serializable;

/**
 * a game disc
 * @author Gil Mizrahi
 *
 */
public final class Disc implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int playerID;
	public int  getPlayerID() { return playerID; }
	public      Disc(int id) { playerID = id; }
	public String toString() { return String.valueOf(playerID); }
}
