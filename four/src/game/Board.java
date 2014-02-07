package game;

import java.io.Serializable;

import util.Pair;

/**
 * Model for the board of the game
 * @author Gil Mizrahi
 *
 */
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
	
	/**
	 * returns the next empty column in a row
	 * @param row
	 * @return the next empty column in a row
	 */
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
	
	/**
	 * checks if the game is finished
	 * @return true or false
	 * @throws Exception when the board is invalid
	 */
	public boolean checkFinishConditions() throws Exception 
	{		
		if (isMatrixFull())
		{
			 finished = true;
		}
		if (checkWinConditions(lastMove))
			{ finished = true; winnerID = lastMove.first.getPlayerID(); }

		return finished;
	}	
	/**
	 * checks if the board matrix is full
	 * @return true or false
	 */
	public boolean isMatrixFull()
	{
		for (int row = 0; row < matrix.length; ++row)
			if (getNextEmptyCol(row) != -1)
				return false;
		
		return true;
	}
	/**
	 * adds a disc to a row
	 * @param row to add the disc to
	 * @param newDisc the new disc
	 * @return indicates success | failure
	 */
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
	/**
	 * returns the disc in row i and column j
	 * @param i row
	 * @param j column
	 * @return the disc present
	 */
	public Disc getDisc(int i, int j)
	{
		return matrix[i][j];
	}
	/**
	 * checks if the move answers the winning conditions 
	 * @param move move to check
	 * @return true or false
	 * @throws Exception 
	 */
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
