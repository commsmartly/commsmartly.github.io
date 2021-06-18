import javax.swing.JButton;

/**
 * 
 * @author Mike Taylor
 *
 * A class that creates the BookButton titles from a book object. 
 * 
 */
public class BookButton extends JButton {
	
	private static int MAX_TEXT_LENGTH = 20;
	private Book book;
	
	public BookButton (Book newBook) {
		super(newBook.getTitle().substring(0, Math.min((MAX_TEXT_LENGTH - 1),newBook.getTitle().length())));
		this.setToolTipText(newBook.toString());
		book = newBook;
	}
	
	/**
	 * Returns the book object from the button that was pressed.
	 *
	 *@return Book object
	 *  
	 */
	public Book getBook() {
		return book;
	}
	
}
