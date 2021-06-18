import java.util.Random;

/**
 * This class represents a 2D array grid of random numbers  
 * @author Mike
 *
 */
public class RandomGrid {

	private final int MAX_VALUE = 10;
	private int [][] grid;
//	private int numRows;
//	private int numCols;
	private Random random;
	

	
	// Constructor
	/**
	 * Creates a random nxm grid containing random numbers between 0-10
	 * @param n The number of rows.
	 * @param n The number of columns.
	 */
	public RandomGrid (int n,int m) {
		
		// I have to instantiate array
		grid = new int[n][m];
		
		// I have to instantiate the random object
		random = new Random();
		
		// I have to fill array with values
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = random.nextInt(MAX_VALUE + 1);
			}
		}
	
		
		
		
	}
	
	// Methods
	
	// toString
	public String toString() {
		String output = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				output += grid[i][j] + "  "; // append - not equals
				
			}
			output += "\n";
		}
		
		return output;
	}
	
}
