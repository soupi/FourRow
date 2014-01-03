package game;

import java.io.Serializable;
import java.util.List;

public final class Board implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<List<Disc>> matrix;
	private int              heightLimit;
	private int              winnerID = -1;
	private int              lastMove = -1;

	public List<List<Disc>> getMatrix()   { return matrix; }
	public int              getWinnerID() { return winnerID; }
	public int              getLastMove() { return lastMove; }
	public Boolean          isFinished()  { return false; /* stub */ }
	public Boolean 			checkWinConditions()
	{
		/* check */
		return false;
	}
	Boolean                 addDisc(int row, Disc disc) 
	{
		if (row >= matrix.size())
			return false;

		if (matrix.get(row).size() >= heightLimit)
			return false;

		if (!matrix.get(row).add(disc))
			return false;

		lastMove = row;
		return true;
	}
	
}
