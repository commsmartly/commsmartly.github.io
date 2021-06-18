import java.io.File;
import java.util.Scanner;

/**
 * The driver class that uses Book.java and Library.java to operate the program
 * 
 * @author Mike
 *
 *
 *
 */
public class LibraryOfBooks {
	
	public static void main(String[] args) {
	
		Library library = new Library();
	
		Scanner scan = new Scanner(System.in);

		String input = "";
		
		// Menu
		System.out.println("************************");
		System.out.println("*     Program Menu     *");
		System.out.println("************************");
		System.out.println("(p)rint the library contents");
		System.out.println("(a)dd a book to the library");
		System.out.println("(d)elete a book in the library");
		System.out.println("(r)ead a book in the library");
		System.out.println("(q)uit");
		System.out.println();
		System.out.println("Please enter a command (press 'm' for Menu): ");

		while (!input.toLowerCase().equals("q")) {
			input = scan.next();
			switch (input.toLowerCase()) {
			
			case "p":				
				if (library.toString().isEmpty()) {
					System.out.println("Library empty, add a book!");
					System.out.println();
					System.out.println("Please enter a command (press 'm' for Menu): ");
				} else {
					System.out.println("****Library****");
					System.out.println(library);
					System.out.println();
					System.out.println("Please enter a command (press 'm' for Menu): ");
				}			
				break;

			case "a":
				System.out.println("Add book...");
				
				System.out.println("Enter title: ");
				String title = scan.next();
				
				System.out.println("Enter author: ");
				String author = scan.next();
				
				System.out.println("Enter genre: ");
				String genre = scan.next();
				
				System.out.println("Enter filename: ");
				String filename = scan.next();
				
				Book goodBook = new Book(title,author);
				goodBook.setGenre(genre);
				goodBook.setFilename(filename);
				
				library.addBook(goodBook);
				
				System.out.println("Done!"); // the method already checks if it's valid and provides a message back - including this done message so users know it executed
				System.out.println();
				System.out.println("Please enter a command (press 'm' for Menu): ");				
				break;
			
			case "d":
				
				if (library.toString().isEmpty()) {
					System.out.println("Library empty, add a book!");
					System.out.println();
					System.out.println("Please enter a command (press 'm' for Menu): ");
				}
				else {
					System.out.println("***Delete***");
					System.out.println("Please enter the index of the book: " + "0 - " + (library.getBooks().size() - 1));
					int inputToDelete = scan.nextInt();
					
					library.removeBook(inputToDelete);
					System.out.println("Done!"); // the method already checks if it's valid and provides a message back - including this done message so users know it executed
					System.out.println();
					System.out.println("Please enter a command (press 'm' for Menu): ");
				}				
				break;
			
			case "r":
		
				if (library.toString().isEmpty()) {
					System.out.println("Library empty, add a book!");
					System.out.println();
					System.out.println("Please enter a command (press 'm' for Menu): ");
				} else {
					System.out.println("Please enter the index of the book you want to read: " + "0 - " + (library.getBooks().size() - 1));
					int inputToRead = scan.nextInt();
					
					Book bookRead = library.getBook(inputToRead);
					
					if (bookRead != null) {
						String printThis = bookRead.getText();
						System.out.println(printThis);
						System.out.println();
						System.out.println("Please enter a command (press 'm' for Menu): ");
					} else {
						System.out.println();
						System.out.println("Please enter a command (press 'm' for Menu): ");
					}
				}					
				break;
			
			case "m":
				System.out.println("************************");
				System.out.println("*     Program Menu     *");
				System.out.println("************************");
				System.out.println("(p)rint the library contents");
				System.out.println("(a)dd a book to the library");
				System.out.println("(d)elete a book in the library");
				System.out.println("(r)ead a book in the library");
				System.out.println("(q)uit");
				System.out.println();
				System.out.println("Please enter a command (press 'm' for Menu): ");
				break;
			
			case "q":
				System.out.println("Goodbye!");
				break;
			
			default:
				System.out.println("Not a valid option!");
			}
		}
		scan.close();
		
	}
}
