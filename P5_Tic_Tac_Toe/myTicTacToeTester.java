import java.awt.Point;

public class myTicTacToeTester {

	public static void main(String[] args) {

		TicTacToeGame myGame = new TicTacToeGame();
	
		myGame.choose(TicTacToe.BoardChoice.X, 1, 1);
		myGame.choose(TicTacToe.BoardChoice.O, 0, 2);
		myGame.choose(TicTacToe.BoardChoice.X, 2, 2);
		myGame.choose(TicTacToe.BoardChoice.O, 1, 2);
		myGame.choose(TicTacToe.BoardChoice.X, 0, 0);
		myGame.choose(TicTacToe.BoardChoice.O, 1, 0);

		System.out.println("toString: ");
		System.out.println(myGame);
	}

}
