package player;

import java.util.ArrayList;

import game.Disc;


public interface IPlayerStrategy {
	int makeMove(int id, ArrayList<ArrayList<Disc>> matrix);
}
