package game;

import java.io.Serializable;
import util.Pair;

public final class Board implements Serializable {
	
	// private fields
	private static final long serialVersionUID = 1L;
	public final int ROWS = 6;
	public final int COLS = 7;
	private final int WIN = 4;
	private int winnerID = -1;
	private boolean finished = false;
	private Disc[][] matrix = new Disc[ROWS][COLS];
	private Pair<Disc, Integer> lastMove = new Pair<Disc,Integer>(null, -1);

	// public methods
	public Disc[][] getMatrix()   { return matrix; }
	public Pair<Disc, Integer> getLastMove() { return lastMove; }
	public int     getWinnerID() { return winnerID; }
	public boolean isFinished()  { return finished; }
	public boolean checkFinishConditions() 
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
	public int getNextEmptyCol(int row)
	{
		for (int i = 0; i < matrix[row].length; ++i)
			if (matrix[row][i] == null)
				return i;
		return -1;
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

	/**
	 * Thank the lord I didn't have to write that.
	 * @param move
	 * @return
	 */
	public boolean checkWinConditions(Pair<Disc, Integer> move)
	{
		int count = 1;

		int rowIndex = move.second;
		int colIndex = 0;
		for (int i = 0; i < matrix[rowIndex].length; ++i)
			if (matrix[rowIndex][i] == null)
				{ colIndex = i-1; break; }
		
		int c = move.first.getPlayerID();
		
		// horizontal right
		for (int i=colIndex+1; i < COLS; i++) {
			
			if (matrix[rowIndex][i] != null && matrix[rowIndex][i].getPlayerID() == c)
				count++;
			else break;
		}
		if (count >= WIN) return true; // won horizontally
		// keep counting horizontal left
		for (int i=colIndex-1; i >=0; i--) {
			if (matrix[rowIndex][i] != null && matrix[rowIndex][i].getPlayerID() == c) 
				count++;
			else break;
		}
		if (count >= WIN) return true; // won horizontally

		count = 1;
		// vertical down
		for (int i=rowIndex+1; i < ROWS; i++) {
			if (matrix[i][colIndex] != null && matrix[i][colIndex].getPlayerID() == c)
				count++;
			else break;
		}
		if (count >= WIN) return true; // won vertical
		// keep counting vertical up
		for (int i=rowIndex-1; i >=0; i--) {
			if (matrix[i][colIndex] != null && matrix[i][colIndex].getPlayerID()==c) 
				count++;
			else
				break;
		}
		if (count >= WIN) return true; // won vertical

		// first diagonal:  /
		count = 1;
		// up
		int kol = colIndex+1;
		for (int i=rowIndex-1; i >= 0; i--) {
			if (kol>=COLS) break; // we reached the end of the board right side
			if (matrix[i][kol] != null && matrix[i][kol].getPlayerID()==c)
				count++;
			else 
				break;
			kol++;
		}
		if (count >= WIN) return true;
		// keep counting down
		kol = colIndex-1;
		for (int i=rowIndex+1; i < ROWS; i++) {
			if (kol<0) break; // we reached the end of the board left side
			if (matrix[i][kol] != null && matrix[i][kol].getPlayerID()==c) 
				count++;
			else
				break;
			kol--;
		}
		if (count >= WIN) return true; // won diagonal "/"

		// second diagonal : \
		count = 1;
		// up
		kol = colIndex-1;
		for (int i=rowIndex-1; i >= 0; i--) {
			if (kol<0) break; // we reached the end of the board left side
			if (matrix[i][kol] != null && matrix[i][kol].getPlayerID()==c)
				count++;
			else 
				break;
			kol--;
		}
		if (count >= WIN) return true; // won diagonal "\"
		// keep counting down
		kol = colIndex+1;
		for (int i=rowIndex+1; i < ROWS; i++) {
			if (kol>=COLS) break; // we reached the end of the board right side
			if (matrix[i][kol] != null && matrix[i][kol].getPlayerID()==c) 
				count++;
			else
				break;
			kol++;
		}
		if (count >= WIN) return true; // won diagonal "\"

		return false;
	}
}
