package game;

public interface BoardLogic {
	boolean checkWinConditions(Disc[][] matrix, int moveRow, int moveCol) throws Exception;
}
