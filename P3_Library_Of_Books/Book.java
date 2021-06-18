import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The book class that represents a book with a title, author, genre, and file
 * 
 * @author Mike Taylor
 *
 */

public class Book implements BookInterface {

	private String title;
	private String author;
	private String genre;
	private String filename;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	@Override
	public void setFilename(String filename) {

		if (filename != null) {
			File setFile = new File(filename);
			try {
				Scanner setFileScan = new Scanner(setFile);

				if (setFileScan.hasNext() && setFile != null) {
					this.filename = filename;
					setFileScan.close();
				} else {
					System.out.println("this.filename: " + this.filename);
					setFileScan.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("File " + setFile + " not found!");
				System.out.println("");
			}
		} else {
			System.out.println("File not found");
		}
	}

	public boolean exists() {
		return true;
	}

	@Override
	public boolean isValid() {

		if (getFilename() != null && getAuthor() != null && getGenre() != null && getTitle() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override

	public String getText() {

		String longString = "";
				
		if (isValid()) {
			File file = new File(filename);

			try {
				Scanner fileScan = new Scanner(file);
				System.out.println("Loading " + file);
                
				while (fileScan.hasNextLine()) {
					longString += fileScan.nextLine() + "\n";			
				}
				fileScan.close();
			} catch (FileNotFoundException e) {
				String notFound = "File not found!";
				return notFound;
			}

		} else {
			return null;
		}
		
		return longString;

	}

	public String toString() {
		String output = title + " by " +  author + " " + "(" + genre + ")" + "\n";

		return output;
	}
}
