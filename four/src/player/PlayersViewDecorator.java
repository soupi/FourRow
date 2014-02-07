package player;


/**
 * prints the current player before calling the view's print()
 * @author Gil Mizrahi
 *
 */
public class PlayersViewDecorator extends ViewDecorator {
	/**
	 * Constructor
	 * @param view to decorate
	 */
	public PlayersViewDecorator(View view)
	{
		super(view);
	}
	/**
	 * prints the current player before calling the view's print()
	 */
	@Override
	public void print() {
	 	System.out.println("current player: " + view.getGame().getPlayersQueue().peek() + "\n");
	 	view.print();
	}
}
