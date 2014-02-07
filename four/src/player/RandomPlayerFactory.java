package player;

/**
 * Creates a player that has a random strategy with certain view
 * @author Gil Mizrahi
 *
 */
public class RandomPlayerFactory implements PlayerFactory {

	/**
	 * creates a new player
	 */
	@Override
	public Player getNewPlayer() 
	{
		Player player = new Player();
		player.setStrategy(new player.RandomStrategy());
		player.setView(new player.PlayersViewDecorator(new player.LastMoveView()));
		
		return player;
	}
}
