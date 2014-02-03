package aspects;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public aspect LoggerAspect {
	
	private long startTime = 0;
    private Map<Long, PrintWriter> writers = new HashMap<Long, PrintWriter>();
	
	pointcut logMoveTimeElapsed(game.Game game) : this(game) && 
		call (public int player.IPlayer.makeMove(..));
	pointcut logBoardAndMoves(game.Game game) : target(game) && 
		call (void game.Game.makeMove(..)); 
	pointcut logGame() : call (public int game.GameManager.loop(..));
	
    before(game.Game game) : logMoveTimeElapsed(game) {
    	 startTime = System.nanoTime();
    }
 
    after(game.Game game) : logMoveTimeElapsed(game) {
    	if (writers.get(game.getID()) == null) return;
    	long estimatedTime = (System.nanoTime() - startTime)/1000;
    	writers.get(game.getID()).println("Move decided after: " + estimatedTime + " milliseconds.");
    }
    
    before(game.Game game) : logBoardAndMoves(game) {
    	if (writers.get(game.getID()) == null) return;
    	PrintWriter writer = writers.get(game.getID());
    	game.Board board = game.getBoard();
    	printBoard(writer, board);
    }
    
    void printBoard(PrintWriter writer, game.Board board)
    {
		for (int i = 0; i < board.ROWS; ++i)
		{
			for (int k = 0; k < board.COLS; ++k)
				writer.print("--");
			
			writer.println("");
			writer.print("|");
			for (int j = 0; j < board.COLS; ++j)
				writer.print(((board.getDisc(i, j) != null) ? 
						board.getDisc(i, j) : " ")  + " ");
			writer.println("");
		}
		for (int k = 0; k < board.COLS; ++k)
			writer.print("--");
		writer.println("");
    }

   after(game.Game game) : logBoardAndMoves(game)
   {
	   if (writers.get(game.getID()) == null) return;
	   writers.get(game.getID()).println("Last Move was by player " + game.getLastMove().first.getPlayerID() + 
			   " in row " + (game.getLastMove().second + 1));
   }
   after(game.Game game) throwing(Exception e) : logBoardAndMoves(game)
   {
	  if (writers.get(game.getID()) == null) return;
	  writers.get(game.getID()).println("Exception thrown: " + e.getMessage());
   }
   
    
    before() : logGame() {
    	long id = ((game.GameManager)thisJoinPoint.getTarget()).getID();
    	PrintWriter writer = null;
		try {
			writer = new PrintWriter("log" + id + ".txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writers.put(id, writer);
    	if (writer == null) return;
    	writers.get(id).println("Game number " + id + " has started");
    }
    after() returning (int winner) : logGame() {
    	game.GameManager manager = ((game.GameManager)thisJoinPoint.getTarget());
    	long id = manager.getID();
    	if (writers.get(id) == null) 
		{
			writers.remove(id);
			return;
		}
    	
		printBoard(writers.get(id), manager.getBoard());
    	
    	writers.get(id).println("Game number " + id + " has finished with the result: ");
    	
		if (winner == -1)
			writers.get(id).println("draw.");
		else 
			writers.get(id).println("player number " + winner + " won.");
		    
		writers.get(id).close();
		writers.remove(id);
    }
} 
