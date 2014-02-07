package game;

/**
 * defines an interface to check game logic
 * @author Gil Mizrahi
 *
 */
public interface BoardLogic {
	boolean checkWinConditions(Disc[][] matrix, int moveRow, int moveCol) throws Exception;
}
