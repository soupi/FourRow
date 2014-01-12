package game;
import player.IPlayer;
import util.DynamicProxy;

public class AbstractPlayerFactory {
	private PlayerFactory playerFactory;
	private int numOfPlayersToCreate = 2;
	public void setPlayerFactory(PlayerFactory pf, int num) 
	{ 
		playerFactory = pf; 
		if (num > 0)
			numOfPlayersToCreate = num;
	}

	IPlayer[] getNewPlayers()
	{
		IPlayer[] players = new IPlayer[numOfPlayersToCreate];
		for (int i = 0; i < numOfPlayersToCreate; ++i)
		{
			IPlayer p = (IPlayer)DynamicProxy.newInstance(playerFactory.getNewPlayer());
			players[i] = p;
			players[i].setID(i);
		}
		return players;
	}
}
