package player;


public class RandomPlayerFactory implements PlayerFactory {

	@Override
	public Player getNewPlayer() {
		Player player = new Player();
		player.setStrategy(new player.RandomStrategy());
		player.setView(new player.PlayersViewDecorator(new player.LastMoveView()));
		
		return player;
	}
}
