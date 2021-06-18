import javax.swing.JFrame;

/**
 * 
 * @author Mike Taylor
 * 
 * Main driver class. Creates the JFrame and instantiates the ReaderOfBooksPanel.java class.
 *
 */
public class ReaderOfBooks {

	public static void main(String[] args) {
		ReaderOfBooksPanel readerPanel = new ReaderOfBooksPanel();
	
		JFrame frame = new JFrame("Reader of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(readerPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
