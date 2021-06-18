import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Mike Taylor
 * 
 * Description: 
 * A music analytics tool called Jukebox Hero.  The user will provide a music catalog in the form of a csv file where 
 * each row in the file represents a single song with the following values (csv): Artist, Album, Title, Duration (in secs).
 *
 * The Jukebox Hero tool will allow the user to open a music catalog file, print stats about the catalog (number of songs,
 * number of artists, number of albums, total play time), search for songs in the catalog, and display the entire catalog.
 *
 */
public class JukeboxHero {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// prints the menu at the start of the program
		String input = "";
		System.out.println("********************************");
		System.out.println("*         Program Menu         *");
		System.out.println("********************************");
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyze catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.println("");
		System.out.println("Please enter a command (press M for Menu): ");
			
		// The arraylist to store the songs from the file		
		ArrayList<Song> songList = new ArrayList<>();	
		// The arraylist to store songs the user searched for
		ArrayList<Song> searchResults = new ArrayList<>();
		
		//the while loop that runs when a user selects a section from the menu - most of the program is in here. Program ends when q is selected.
		while (!input.toLowerCase().equals("q")) {
			input = scan.next();
			switch (input.toLowerCase()) {
			
			// loads songs to songList
			case "l":
				System.out.println("Please enter filename: ");
				String inputFileName = scan.next();
				File file = new File(inputFileName);
				
				try {			
					Scanner fileScan = new Scanner(file);
					System.out.println("Loading "+ inputFileName);			
					
					while (fileScan.hasNextLine()) {						
						String line = fileScan.nextLine();					
						Scanner lineScan = new Scanner(line);
						lineScan.useDelimiter(",");

						String artist = lineScan.next();
						String album = lineScan.next();
						String song = lineScan.next();
						int seconds = lineScan.nextInt();
						
						Song songs = new Song(song,artist,album,seconds);
						songList.add(songs);
						
						lineScan.close();		
					}
					System.out.println("Successfully loaded " + songList.size() + " songs!");
					System.out.println("");
					System.out.println("Please enter a command (press M for Menu): ");
					fileScan.close();
				} catch (FileNotFoundException e) {
					System.out.println("File " + inputFileName + " not found!");
					System.out.println("");
					System.out.println("Please enter a command (press M for Menu): ");
				} 
				break;
			
			// searches song titles that are loaded
			case "s":
				System.out.println("Search Catalog...");
				System.out.println("Please enter the search query: ");
				String result = scan.next();
				int hasResult = 0;
								
				for (int i = 0; i < songList.size(); i++) {
					if ((songList.get(i).getTitle().toLowerCase().contains(result) ||
					((songList.get(i).getTitle().contains(result) || (((songList.get(i).getTitle().toUpperCase().contains(result)))))))) {
						hasResult++;
						 
						if (!searchResults.contains(songList.get(i)))
							searchResults.add(songList.get(i));								
					} 	
				}
				
				if (hasResult >= 1) {
					System.out.println("Found " + hasResult + " matches");
					for (Song songs : searchResults) {
						System.out.println(songs);
					}
				} else System.out.println("Found 0 matches");
				System.out.println("");
				System.out.println("Please enter a command (press M for Menu): ");				
				break;
				
			// analyses the songs 	
			case "a":
				
				System.out.println("Catalog Analysis...");
				
				ArrayList<String> artistList = new ArrayList<>();
				ArrayList<String> albumList = new ArrayList<>();
				
				int hasArtist = 0;
				int hasAlbum = 0;
				
				//builds artist list
				for (int i = 0; i < songList.size(); i++) {
					songList.get(i).getArtist();
					if (!artistList.contains(songList.get(i).getArtist()))
						hasArtist++;
						artistList.add(songList.get(i).getArtist());
				} 
				//builds album list
				for (int i = 0; i < songList.size(); i++) {
					songList.get(i).getAlbum();
					if (!albumList.contains(songList.get(i).getAlbum()))
						hasAlbum++;
						albumList.add(songList.get(i).getAlbum());
				}
				//print number of artists
				for (int i = 0; i < 1; i++) {
					System.out.println("      Artists: " + hasArtist);
				}
				
				//print number of albums
				for (int i = 0; i < 1; i++) {
					System.out.println("      Albums: " + hasAlbum);
				}
				//print number of songs
				for (int i = 0; i < 1; i++) {
					System.out.println("      Songs: " + songList.size());
					
				}
				// print total playtime
				int sum = 0;
				for (int i = 0; i < songList.size(); i++) {
					sum += songList.get(i).getPlayTime();
				}
				System.out.println("      Catalog Playtime: " + sum);
				System.out.println("");
				System.out.println("Please enter a command (press M for Menu): ");
				break;
			// prints the songs in songList	
			case "p":
				System.out.println("Song list contains " + songList.size() + " songs...");
				System.out.println("---------------------------------");
				for (Song songs : songList) {
					System.out.println(songs);	
				}
				System.out.println("");
				System.out.println("Please enter a command (press M for Menu): ");
				break;
			// prints the menu	
			case "m":
				System.out.println("********************************");
				System.out.println("*         Program Menu         *");
				System.out.println("********************************");
				System.out.println("(L)oad catalog");
				System.out.println("(S)earch catalog");
				System.out.println("(A)nalyze catalog");
				System.out.println("(P)rint catalog");
				System.out.println("(Q)uit");
				System.out.println("");
				System.out.println("Please enter a command (press M for Menu): ");
				break;
			// prints that it quits the program, because of the while loop	
			case "q":
				System.out.println("Goodbye!");
				break;
			// if all else fails, prints this	
			default:
				System.out.println("Invalid selection!");
				System.out.println("");
				System.out.println("Please enter a command (press M for Menu): ");
			}
		}
		scan.close();

	}

}
