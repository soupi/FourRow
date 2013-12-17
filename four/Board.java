package four;

import java.util.List;

public final class Board {
	private List<List<Disc>> matrix;
	private int              heightLimit;
	private int winner = -1;
	
	public List<List<Disc>> getMatrix()   { return matrix; }
	public int              getWinnerID() { return winner; }
	public Boolean          isFinished()  { return false; /* stub */ }
	public Boolean          addDisc(int row, Disc disc) 
	{
		if (row >= matrix.size())
			return false;
		
		if (matrix.get(row).size() >= heightLimit)
			return false;
		
		return matrix.get(row).add(disc);
	}
	
}
