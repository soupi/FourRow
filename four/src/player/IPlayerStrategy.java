package player;

/**
 * interface for players strategy. defines makeMove()
 * @author Gil Mizrahi
 *
 */
public interface IPlayerStrategy {
	int makeMove(int id, game.Board board);
}
