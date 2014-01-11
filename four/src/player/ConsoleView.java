package player;

import game.Disc;

public class ConsoleView extends AbstractView {

	@Override
	public void print() {
		
		Disc[][] matrix = game.getBoard().getMatrix();
		
		for (Disc[] row : matrix)
		{
			for (Disc disc : row)
				System.out.print(disc.getPlayerID() + " ");
			System.out.println("");
		}
	}
}
