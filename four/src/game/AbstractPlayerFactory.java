package game;
import player.Player;

public class AbstractPlayerFactory {
	private PlayerFactory playerFactory;
	public void setPlayerFactory(PlayerFactory pf) { playerFactory = pf; }

	Player getNewPlayer()
	{
		return playerFactory.getNewPlayer();
	}
}
