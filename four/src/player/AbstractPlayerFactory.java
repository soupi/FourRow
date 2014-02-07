package player;
import util.LoggerDynamicProxy;


/**
 * An abstract player factory which creates players
 * @author Gil Mizrahi
 *
 */
public class AbstractPlayerFactory {
	private PlayerFactory playerFactory;
	private int numOfPlayersToCreate = 2;
	
	/**
	 * Constructor
	 * @param pf player factory
	 * @param numOfPlayers number of players to create. has to be 2 or more. for lower numbers, num of players will be set to 2
	 */
	public void setPlayerFactory(PlayerFactory pf, int numOfPlayers) 
	{ 
		playerFactory = pf; 
		if (numOfPlayers > 0)
			numOfPlayersToCreate = numOfPlayers;
	}

	/**
	 * returns an array of players
	 * @return array of players
	 */
	public IPlayer[] getNewPlayers()
	{
		IPlayer[] players = new IPlayer[numOfPlayersToCreate];
		for (int i = 0; i < numOfPlayersToCreate; ++i)
		{
			// wrap in logger dynamic proxy
			IPlayer p = (IPlayer)LoggerDynamicProxy.newInstance(playerFactory.getNewPlayer());
			players[i] = p;
			players[i].setID(i);
		}
		return players;
	}
}
