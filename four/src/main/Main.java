package main;

import player.AbstractPlayerFactory;
import player.RandomPlayerFactory;
import game.*;

public class Main {

	public static void main(String[] args) 
	{
		AbstractPlayerFactory aFactory = new AbstractPlayerFactory();
		aFactory.setPlayerFactory(new RandomPlayerFactory(), 2);
		
		GameManager gMan = new GameManager(aFactory, 0);

		int winner = gMan.loop();
		if (winner == -1)
			System.out.println("draw.");
		else 
			System.out.println("player number " + winner + " won.");
		
		System.out.println("game over.");
	}

}
