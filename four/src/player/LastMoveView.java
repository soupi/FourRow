package player;

public class LastMoveView extends AbstractView {

	@Override
	public void print() 
	{
		util.Pair<game.Disc, Integer> move = getGame().getBoard().getLastMove();
		System.out.println("Last Move: (" + move.first + ", " + move.second + ")");
	}
}

