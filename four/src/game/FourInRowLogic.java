package game;


/**
 * implements Four In A Row winning conditions board logic
 * @author Gil Mizrahi
 *
 */
public class FourInRowLogic implements BoardLogic {
	private final int WIN = 4;
	
	/**
	 * Thank the lord I didn't have to write that.
	 * @param move
	 * @return
	 * @throws Exception 
	 */
	public boolean checkWinConditions(Disc[][] matrix, int rowIndex, int colIndex) throws Exception
	{
		int ROWS = matrix.length;
		int COLS = matrix[0].length;
		
		if (rowIndex < 0 || ROWS <= rowIndex || colIndex < 0 || COLS <= colIndex )
			throw new Exception("move (" + rowIndex + ", " + colIndex + ") is out of bounds");
		if (matrix[rowIndex][colIndex] == null)
			return false;
		
		int count = 1;

		int c = matrix[rowIndex][colIndex].getPlayerID();
		
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
