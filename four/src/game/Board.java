package game;

import java.io.Serializable;
import util.Pair;

public final class Board implements Serializable {
	
	// private fields
	private static final long serialVersionUID = 1L;
	public final int ROWS = 6;
	public final int COLS = 7;
	private int winnerID = -1;
	private boolean finished = false;
	private Disc[][] matrix = new Disc[ROWS][COLS];
	private Pair<Disc, Integer> lastMove = new Pair<Disc,Integer>(null, -1);

	// public methods
	public Disc[][] getMatrix()   { return matrix; }
	public Pair<Disc, Integer> getLastMove() { return lastMove; }
	public int     getWinnerID() { return winnerID; }
	public boolean isFinished()  { return finished; } // need to implement winning conditions or 
	public boolean checkFinishConditions() 
	{
		finished = (isMatrixFull() || checkWinConditions());
		
		return finished;
	}	
	public boolean isMatrixFull()
	{
		for (int row = 0; row < matrix.length; ++row)
			if (getNextEmptyCol(row) != -1)
				return false;
		
		return true;
	}
	public int getNextEmptyCol(int row)
	{
		for (int i = 0; i < matrix[row].length; ++i)
			if (matrix[row][i] == null)
				return i;
		return -1;
	}
	public boolean checkWinConditions()
	{
		/* check and mark winner if win achieved */
		return false;
	}
	boolean addDisc(int row, Disc newDisc) 
	{
		if (row >= matrix.length)
			return false;

		int col = getNextEmptyCol(row);
		if (col == -1)
			return false;

		matrix[row][col] = newDisc;

		lastMove.first  = newDisc;
		lastMove.second = row;
		
		return true;
	}
}
