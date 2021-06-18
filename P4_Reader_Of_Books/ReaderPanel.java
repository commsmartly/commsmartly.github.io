import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Mike Taylor 
 * 
 * A container for the GUI components that provide the
 * Reader functionality. It houses the Title and Author labels and the
 * text area that displays the book contents.
 *
 */
public class ReaderPanel extends JPanel {

	private JPanel infoPanel;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JTextArea bookTextArea;
	private JScrollPane bookTextScrollPane;

	public ReaderPanel() {

		setPreferredSize(new Dimension(450, 500));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// InfoPanel
		this.infoPanel = new JPanel();
		this.add(infoPanel);

		// titleLabel
		this.titleLabel = new JLabel("Title: ");
		infoPanel.add(titleLabel);

		// authorLabel
		this.authorLabel = new JLabel("Author: ");
		infoPanel.add(authorLabel);

		// bookText Area
		this.bookTextArea = new JTextArea();
		bookTextArea.setEditable(false);
		bookTextArea.setText("Please load a file.");

		// bookTextScrollPane
		this.bookTextScrollPane = new JScrollPane(bookTextArea);
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookTextScrollPane.setPreferredSize(new Dimension(400, 550));
		add(bookTextScrollPane);
	}

	/**
	 * Takes in a Book and updates all associated components with information from
	 * the Book.
	 * 
	 * @param Takes in a book object
	 * @return void
	 */
	public void loadBook(Book book) {
		String bookText = book.getText();
		this.bookTextArea.setText(bookText);
		this.authorLabel.setText("Title: " + book.getAuthor());
		this.titleLabel.setText("Author: " + book.getTitle());

	}

}
