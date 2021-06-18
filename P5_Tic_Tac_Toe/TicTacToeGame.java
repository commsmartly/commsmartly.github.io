import java.awt.Point;
/**
 * This class manages game state information and logic for a game of tic-tac-toe. It implements the TicTacToe interface. 
 *  
 * @author Mike Taylor
 *
 */
public class TicTacToeGame implements TicTacToe {

	private BoardChoice[][] gameGrid;
	private GameState gameState;
	private Point[] movesList;
	private Point moves;
	private int numMovesIndex = 0;
	private BoardChoice lastPlayer;

	public TicTacToeGame() {
		newGame();
	}

	public void newGame() {

		gameGrid = new BoardChoice[3][3];
		movesList = new Point[9];
		gameState = GameState.IN_PROGRESS;
		numMovesIndex = 0;
		
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				gameGrid[i][j] = BoardChoice.OPEN;
			}
		}
	}

	public boolean choose(BoardChoice player, int row, int col) {
		
		if (lastPlayer != player && row < 3 && col < 3 && gameState == GameState.IN_PROGRESS) {
			if (gameGrid[row][col] == BoardChoice.OPEN) {
				gameGrid[row][col] = player;
				lastPlayer = player;
				moves = new Point(row,col);
				if (numMovesIndex != movesList.length) {
					for (int i = 0; i < 1; i++) {
						movesList[i + numMovesIndex] = moves;
						numMovesIndex++;
					}
				}
				getMoves();				
				gameOver();
				
				return true;
			}else {
				return false;
			}
		} 
		return false;
	}

	public boolean gameOver() {
		// Checks rows
		for (int i = 0; i < 3; i++) {
			if (gameGrid[i][0] == gameGrid[i][1] && gameGrid[i][1] == gameGrid[i][2] && gameGrid[i][0] != BoardChoice.OPEN) {
				if (gameGrid[i][0] == BoardChoice.X) {
					gameState = GameState.X_WON;	
					return true;
					
				} else if (gameGrid[i][0] == BoardChoice.O) {
					gameState = GameState.O_WON;					
					return true;
				}
			}
		}	
		
		// Checks columns
		for (int j = 0; j < 3; j++)	{
			if (gameGrid[0][j] == gameGrid[1][j] && gameGrid[1][j] == gameGrid[2][j] && gameGrid[0][j] != BoardChoice.OPEN) {
				if (gameGrid[0][j] == BoardChoice.X) {
					gameState = GameState.X_WON;
					return true;
					
				} else if (gameGrid[0][j] == BoardChoice.O) {
					gameState = GameState.O_WON;
					return true;
				}
			}
		}
		// Checks diagonal top left to right
		if (gameGrid[0][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][2] && gameGrid[0][0] != BoardChoice.OPEN)	{
			if (gameGrid[0][0] == BoardChoice.X) {
				gameState = GameState.X_WON;
				return true;
				
			} else if (gameGrid[0][0] == BoardChoice.O) {
				gameState = GameState.O_WON;
				return true;
			}
		}
					
			// Checks diagonal bottom left to right
		if (gameGrid[0][2] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][0] && gameGrid[0][2] != BoardChoice.OPEN)	{
			if (gameGrid[0][2] == BoardChoice.X) {
				gameState = GameState.X_WON;
				return true;
				
			} else if (gameGrid[0][2] == BoardChoice.O) {
				gameState = GameState.O_WON;
				return true;
			} 
		}
			
		else if (numMovesIndex == 9) {
			gameState = GameState.TIE;
			return true;
		}
			
		return false;
	}


	public GameState getGameState() {
		return gameState;
	}

	public BoardChoice[][] getGameGrid() {
		BoardChoice[][] boardCopy = new BoardChoice[3][3];
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				boardCopy[i][j] = gameGrid[i][j];
			}
		}
		
		return boardCopy;
	}

	public Point[] getMoves() {
		Point[] temp = new Point[numMovesIndex];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = movesList[i];
		}
		
		return temp;
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				output += gameGrid[i][j] + "  "; 
			}
			output += "\n";
		}

		return output;
	}

}
