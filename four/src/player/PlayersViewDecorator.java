package player;

public class PlayersViewDecorator extends ViewDecorator {

	
	public PlayersViewDecorator(View view)
	{
		super(view);
	}
	
	@Override
	public void print() {
	 	System.out.println("current player: " + view.getGame().getPlayersQueue()[0] + "\n");
	 	view.print();
	}
}
