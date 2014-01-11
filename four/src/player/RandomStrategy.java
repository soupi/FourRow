package player;

import game.Disc;
import java.util.Random;

public class RandomStrategy implements IPlayerStrategy 
{
	@Override
	public int makeMove(int id, Disc[][] matrix) 
	{
		return new Random().nextInt(matrix.length);
	}
}
