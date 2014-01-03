package game;

import java.io.Serializable;
import java.util.ArrayList;
import util.Pair;

public final class Board implements Serializable {
	
	// private fields
	private static final long serialVersionUID = 1L;
	public final int ROWS = 6;
	public final int COLS = 7;
	private ArrayList<ArrayList<Disc>> matrix = new ArrayList<ArrayList<Disc>>();
	private int winnerID = -1;
	private Pair<Disc, Integer> lastMove = new Pair<Disc,Integer>(null, -1);

	// public methods
	public ArrayList<ArrayList<Disc>> getMatrix()   { return matrix; }
	public Pair<Disc, Integer> getLastMove() { return lastMove; }
	public int     getWinnerID() { return winnerID; }
	public Boolean isFinished()  { return false; /* stub */ }
	
	public Board() 
	{
		// int matrix arrays
		for (int i = 0; i < ROWS; ++i)
			matrix.add(new ArrayList<Disc>(COLS));
	}
	
	public Boolean checkWinConditions()
	{
		/* check */
		return false;
	}
	Boolean addDisc(int row, Disc disc) 
	{
		if (row >= matrix.size())
			return false;

		if (matrix.get(row).size() >= COLS)
			return false;

		if (!matrix.get(row).add(disc))
			return false;

		lastMove.first  = disc;
		lastMove.second = row;
		
		return true;
	}
}
