import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author Mike Taylor 
 * The class for the JPanel LibraryPanel that holds the
 * buttons, and the import text field and load button.
 * 
 *
 */
public class LibraryPanel extends JPanel {

	private Library library = new Library();
	private ActionListener buttonListener;
	private JPanel bookListPanel = new JPanel();
	private JPanel importPanel = new JPanel();
	private JScrollPane bookListScrollPane = new JScrollPane(bookListPanel);
	private JTextField importTextField;
	private JButton importButton;

	public LibraryPanel(ActionListener bl) {
		buttonListener = bl;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(250, 800));

		// bookListScrollPane
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookListScrollPane.setPreferredSize(new Dimension(400, 300));
		add(bookListScrollPane);

		// LoadLibraryPanel
		this.importPanel = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(importPanel);

		// Text Field
		this.importTextField = new JTextField("etext/booklist-full.csv");
		this.importTextField.addActionListener(new TextFieldActionListener());
		this.importPanel.add(this.importTextField);

		// LOAD button
		this.importButton = new JButton("LOAD");
		this.importButton.addActionListener(new LoadButtonActionListener());
		this.importPanel.add(this.importButton);
	}

	/**
	 * ActionListener for the TextField for loading a CSV file. Does the same thing
	 * as the LoadButtonActionListener.
	 * 
	 * Listens for the enter key, and then checks and then executes the
	 * loadLibraryFromCSV method with the filename. Creates buttons from the
	 * BookButton class from the book objects found.
	 * 
	 * @return void
	 */
	private class TextFieldActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = importTextField.getText();

			library.loadLibraryFromCSV(input);
			for (Book book : library.getBooks()) {
				BookButton button = new BookButton(book);
				button.addActionListener(buttonListener);
				bookListPanel.add(button);
			}

			bookListPanel.invalidate();
			bookListPanel.validate();
			bookListPanel.repaint();
		}
	}

	/**
	 * ActionListener for the LOAD button for loading a CSV file. Does the same
	 * thing as the TextFieldActionListener.
	 * 
	 * Listens for the enter key, and then checks and then executes the
	 * loadLibraryFromCSV method with the filename. Creates buttons from the
	 * BookButton class from the book objects found.
	 * 
	 * @return void
	 */
	private class LoadButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = importTextField.getText();

			library.loadLibraryFromCSV(input);
			for (Book book : library.getBooks()) {
				BookButton button = new BookButton(book);
				button.addActionListener(buttonListener);
				bookListPanel.add(button);
			}

			bookListPanel.invalidate();
			bookListPanel.validate();
			bookListPanel.repaint();
		}
	}

}
