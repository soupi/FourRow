package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class FourInRowLogicTest {

	@Test
	public void test() throws Exception {
		Disc[][] matrix = new Disc[5][5];
		
		for (int row = 0; row < matrix.length; ++row)
			for (int col = 0; col < matrix[row].length; ++col)
				matrix[row][col] = null;
		
		BoardLogic logic = new FourInRowLogic();
		
		try { logic.checkWinConditions(matrix, -1, -1); fail(); }
		catch (Exception e) { /* OK! */ }
		
		assertEquals("empty matrix = false", false, 
				logic.checkWinConditions(matrix, 2, 0));
		
		matrix[2][0] = new Disc(1);
		
		assertEquals("1 cell matrix = false", false, 
				logic.checkWinConditions(matrix, 2, 0));
		
		matrix[2][1] = new Disc(1);
		matrix[2][2] = new Disc(2);
		matrix[2][3] = new Disc(1);
		
		assertEquals("not 4", false, 
				logic.checkWinConditions(matrix, 2,3));
		
		matrix[0][0] = new Disc(1);
		matrix[1][0] = new Disc(1);
		matrix[3][0] = new Disc(1);
		assertEquals("horizontal", true, 
				logic.checkWinConditions(matrix, 1, 0));
		
		// clean
		for (int row = 0; row < matrix.length; ++row)
			for (int col = 0; col < matrix[row].length; ++col)
				matrix[row][col] = null;
		
		matrix[0][0] = new Disc(1);
		matrix[1][0] = new Disc(2);
		matrix[2][0] = new Disc(2);
		matrix[3][0] = new Disc(2);

		matrix[0][1] = new Disc(2);
		matrix[1][1] = new Disc(1);
		matrix[2][1] = new Disc(2);
		matrix[3][1] = new Disc(2);

		matrix[0][2] = new Disc(2);
		matrix[1][2] = new Disc(2);
		matrix[2][2] = new Disc(1);
		matrix[3][2] = new Disc(2);

		matrix[0][3] = new Disc(2);
		matrix[1][3] = new Disc(2);
		matrix[2][3] = new Disc(2);
		matrix[3][3] = new Disc(1);

		assertEquals("/", true, 
				logic.checkWinConditions(matrix, 2, 2));

	}
}
