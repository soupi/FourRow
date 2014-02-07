package player;


/**
 * defines print() from AbstractView. prints the last move on the screen.
 * @author Gil Mizrahi
 *
 */
public class LastMoveView extends AbstractView {

	/**
	 * prints the last move on the screen.
	 */
	@Override
	public void print() 
	{
		util.Pair<game.Disc, Integer> move = getGame().getBoard().getLastMove();
		System.out.println("Last Move: (" + move.first + ", " + move.second + ")");
	}
}

