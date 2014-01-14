package game;

import util.Pair;

public class FourInRowLogic implements BoardLogic {
	private final int WIN = 4;
	
	/**
	 * Thank the lord I didn't have to write that.
	 * @param move
	 * @return
	 */
	public boolean checkWinConditions(Disc[][] matrix, Pair<Disc, Integer> move)
	{
		int ROWS = matrix.length;
		int COLS = matrix[0].length;
		
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
