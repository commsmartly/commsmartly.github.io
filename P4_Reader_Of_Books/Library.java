/**
 * The library class that represents a collection of books and provides methods for managing them 
 * 
 * @author Mike Taylor
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Library implements LibraryInterface {

	private ArrayList<Book> bookList = new ArrayList<>();
		
	public Library() {
		ArrayList<Book> newLibrary = new ArrayList<>();
	}
	
	@Override   
	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookListCopy = new ArrayList<>(this.bookList);				
		return bookListCopy;
	}

	@Override
	public void addBook(Book newBook) {
		if (newBook != null); {
			this.bookList.add(newBook); 
		} 
	}		
			
	@Override
	public void removeBook(int index) {
		
		if (index >= this.bookList.size()) {
			System.out.println("Invalid index");
		} else {
			this.bookList.remove(index);
		}			
	}

	@Override
	public Book getBook(int index) {
	
		if (index >= this.bookList.size()) {
			System.out.println("Invalid index");
			return null;			
		}
		
		else if (this.bookList.get(index) != null) {
			return getBooks().get(index);
			
		} else {
			System.out.println("Invalid index");
			return null;
		}				
	}
	
	@Override
	public void loadLibraryFromCSV(String csvFilename) {
							
		String csvFileReference = csvFilename;
		
		Scanner scan = new Scanner(csvFileReference);
		csvFileReference = scan.nextLine();
		File file = new File(csvFileReference);
				
		try {			
			Scanner fileScan = new Scanner(file);			
			
			while (fileScan.hasNextLine()) {						
				String line = fileScan.nextLine();					
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");

				String title = lineScan.next();
				String author = lineScan.next();
				String genre = lineScan.next();
				String filename = lineScan.next();
				
				Book csvBooks = new Book(title,author);			
				csvBooks.setGenre(genre);
				csvBooks.setFilename(filename);
				
				addBook(csvBooks);
			
				lineScan.close();		
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + csvFilename + " not found!");
		} 
		scan.close();
				
	}

	public String toString() {

		String output = "";
		
		for (Book books : getBooks()) {
			output += books;
		}		
		return output;	
	}


	
	
}
