package player;

public class ConsoleView extends AbstractView {

	/**
	 * prints the game board
	 */
	@Override
	public void print() {
		
		for (int i = 0; i < game.getBoard().ROWS; ++i)
		{
			for (int j = 0; j < game.getBoard().COLS; ++j)
				System.out.print(((game.getBoard().getDisc(i, j) != null) ? 
						game.getBoard().getDisc(i, j) : " ") + " ");
			System.out.println("");
		}
	}
}
