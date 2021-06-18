/**
 * The library class that represents a collection of books and provides methods for managing them 
 * 
 * @author Mike Taylor
 * 
 */


import java.util.ArrayList;


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

	public String toString() {

		String output = "";
		
		for (Book books : getBooks()) {
			output += books;
		}		
		return output;	
	}
	
	
}
