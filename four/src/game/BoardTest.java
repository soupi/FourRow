package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void test() {
		Board board  = new Board(new FourInRowLogic());
		
		try { 
			assertEquals("empty board should not be finished", false, board.checkFinishConditions());
		} catch(Exception e) { fail(); }
		assertEquals("shouldn't be finished", false, board.isFinished());
		
		
		Disc[] discs = new Disc[] { new Disc(1), new Disc(2) };
		
		for (int row = 0, col = 0; row < board.ROWS; ++row, col = 0)
			while (board.addDisc(row, discs[ col % 2]))
				++col;
		
		StringBuffer strBuf = new StringBuffer();
		
		for (int row = 0; row < board.ROWS; ++row)
			for (int col = 0; col < board.COLS; ++col)
				strBuf.append((board.getDisc(row, col) != null) ? board.getDisc(row, col).getPlayerID() : null);	
		
		assertEquals("matrix should be full\n" + strBuf.toString(), true, board.isMatrixFull());
		

		try {
			assertEquals("should be true", true, board.checkFinishConditions());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		try {
			assertEquals(true, board.checkWinConditions(board.getLastMove()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		assertEquals("should be finished" + strBuf.toString(), true, board.isFinished());
		
	}
}
