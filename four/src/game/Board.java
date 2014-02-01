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
	private BoardLogic logic;
	
	private int getNextEmptyCol(int row)
	{
		for (int i = 0; i < matrix[row].length; ++i)
			if (matrix[row][i] == null)
				return i;
		return -1;
	}
	
	// public methods
	public Board(BoardLogic logic) { this.logic = logic; }
	public Pair<Disc, Integer> getLastMove() { return lastMove; }
	public int     getWinnerID() { return winnerID; }
	public boolean isFinished()  { return finished; }
	public boolean checkFinishConditions() throws Exception 
	{		
		if (!isMatrixFull())
		{
			if (checkWinConditions(lastMove))
			{ finished = true; winnerID = lastMove.first.getPlayerID(); }
		}
		else { finished = true; }
		
		return finished;
	}	
	public boolean isMatrixFull()
	{
		for (int row = 0; row < matrix.length; ++row)
			if (getNextEmptyCol(row) != -1)
				return false;
		
		return true;
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
	public Disc getDisc(int i, int j)
	{
		return matrix[i][j];
	}
	public boolean checkWinConditions(Pair<Disc, Integer> move) throws Exception
	{		
		int row = move.second;
		if (row < 0 || row > matrix.length)
			return false;
		
		int col = COLS-1;
		for (int i = 0; i < matrix[row].length; ++i)
			if (matrix[row][i] == null)
				{ col = i-1; break; }
		
		return logic.checkWinConditions(matrix, row, col);
	}
}
