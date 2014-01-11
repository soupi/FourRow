package main;

import game.*;

public class Main {

	public static void main(String[] args) 
	{
		AbstractPlayerFactory aFactory = new AbstractPlayerFactory();
		aFactory.setPlayerFactory(new RandomPlayerFactory(), 2);
		
		GameManager gMan = new GameManager(aFactory);

		gMan.loop();
		
		System.out.println("game over.");
	}

}
