package game;

import java.util.ArrayList;
import java.util.List;

public class DiscFactory {
	
	List<Disc> discs = new ArrayList<Disc>();
	private DiscFactory() { }
	
	public static DiscFactory getInstance()
	{
		DiscFactory factory = new DiscFactory();
		return factory;
	}
	
	public Disc getDisc(int playerID)
	{
		for (Disc disc : discs)
			if (disc.playerID == playerID)
				return disc;
		
		Disc disc = new Disc(playerID);
		discs.add(disc);
		return disc;
	}
	
}
