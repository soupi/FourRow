package player;

import java.util.Random;

public class RandomStrategy implements IPlayerStrategy 
{
	@Override
	public int makeMove(int id, game.Board board) 
	{
		return new Random().nextInt(board.ROWS);
	}
}
