package four;

import java.util.List;

public class BoardAdapter {
	Board board;
	public List<List<Disc>> getMatrix()   { return board.getMatrix(); }
	public int              getWinnerID() { return board.getWinnerID(); }
	public Boolean          isFinished()  { return board.isFinished(); }
	
	public BoardAdapter(Board board) { this.board = board; }
}
