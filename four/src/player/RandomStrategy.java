package player;

import java.util.Random;

/**
 * randomly decides on moves
 * @author Gil Mizrahi
 *
 */
public class RandomStrategy implements IPlayerStrategy 
{
	/**
	 * randomly decides on moves
	 */
	@Override
	public int makeMove(int id, game.Board board) 
	{
		return new Random().nextInt(board.ROWS);
	}
}
