package game;
import player.Player;

public class AbstractPlayerFactory {
	private PlayerFactory playerFactory;
	private int numOfPlayersToCreate = 2;
	public void setPlayerFactory(PlayerFactory pf, int num) 
	{ 
		playerFactory = pf; 
		if (num > 0)
			numOfPlayersToCreate = num;
	}

	Player[] getNewPlayers()
	{
		Player[] players = new Player[numOfPlayersToCreate];
		for (int i = 0; i < numOfPlayersToCreate; ++i)
		{
			players[i] = playerFactory.getNewPlayer();
			players[i].setID(i);
		}
		return players;
	}
}
