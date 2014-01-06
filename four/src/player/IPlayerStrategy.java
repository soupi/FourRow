package player;

import game.Disc;


public interface IPlayerStrategy {
	int makeMove(int id, Disc[][] matrix);
}
