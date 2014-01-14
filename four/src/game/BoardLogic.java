package game;

import util.Pair;

public interface BoardLogic {
	boolean checkWinConditions(Disc[][] matrix, Pair<Disc, Integer> move);
}
