/**
 * Creates a playlist of three song objects and does computations.
 *
 * @author Mike Taylor
 * @version Fall 2020
 * 
 */
// 

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlayList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// User input for Song 1 (mySong)
		
		System.out.println("Enter title: ");
		String title = scan.nextLine();
		
		System.out.println("Enter artist: ");
		String artist = scan.nextLine();
		
		System.out.println("Enter album: ");
		String album = scan.nextLine();
		
		System.out.println("Enter play time (mm:ss): ");
		String songPlayTime = scan.nextLine();	
		
		int colon = songPlayTime.indexOf(":");
		int minutes = Integer.parseInt(songPlayTime.substring(0 , colon));
		int seconds = Integer.parseInt(songPlayTime.substring((colon + 1) , songPlayTime.length()));
		int totalSec = minutes * 60 + seconds;
		
		Song mySong = new Song(title, artist, album, totalSec);
		
		
		
		// User input for Song 2 (mySong2)
		
		System.out.println("Enter title: ");
		title = scan.nextLine();
		
		System.out.println("Enter artist: ");
		artist = scan.nextLine();
		
		System.out.println("Enter album: ");
		album = scan.nextLine();
		
		System.out.println("Enter play time (mm:ss): ");
		songPlayTime = scan.nextLine();	
				
		colon = songPlayTime.indexOf(":");
		minutes = Integer.parseInt(songPlayTime.substring(0 , colon));
		seconds = Integer.parseInt(songPlayTime.substring((colon + 1) , songPlayTime.length()));
		totalSec = minutes * 60 + seconds;
		
		Song mySong2 = new Song(title, artist, album, totalSec);
		
		// User input for Song 3 (mySong3)
		
		System.out.println("Enter title: ");
		title = scan.nextLine();
		
		System.out.println("Enter artist: ");
		artist = scan.nextLine();
		
		System.out.println("Enter album: ");
		album = scan.nextLine();
		
		System.out.println("Enter play time (mm:ss): ");
		songPlayTime = scan.nextLine();	
				
		colon = songPlayTime.indexOf(":");
		minutes = Integer.parseInt(songPlayTime.substring(0 , colon));
		seconds = Integer.parseInt(songPlayTime.substring((colon + 1) , songPlayTime.length()));
		totalSec = minutes * 60 + seconds;
		
		Song mySong3 = new Song(title, artist, album, totalSec);
		
				
		// Determines the average play time of the three songs
		double avePlaytime = ((mySong.getPlayTime() + mySong2.getPlayTime() + mySong3.getPlayTime()) / 3.0);
		
		DecimalFormat myFormatter = new DecimalFormat("#.00");
		String output = myFormatter.format(avePlaytime);
		System.out.println("Average play time: " + output);
		

		// Determines the number of seconds away from 240 seconds for each song	
		int target = 240;
		int song1Distance = 0;
		int song2Distance = 0;
		int song3Distance = 0;
					
		if (mySong.getPlayTime() < target) {
			song1Distance = target - mySong.getPlayTime();
		}
			else {
				song1Distance = mySong.getPlayTime() - target;
			}
		
		if (mySong2.getPlayTime() < target) {
			song2Distance = target - mySong2.getPlayTime();
		}
			else {
				song2Distance = mySong2.getPlayTime() - target;
			}
		
		if (mySong3.getPlayTime() < target) {
			song3Distance = target - mySong3.getPlayTime();
		}
			else {
				song3Distance = mySong3.getPlayTime() - target;
			}
		
		// Determines which song is the closest to 4 minutes and prints the title
		if (song1Distance <= song2Distance && song1Distance <= song3Distance) {
			System.out.println("Song with play time closest to 240 secs is: " + mySong.getTitle());
		}	
		else if (song2Distance <= song1Distance && song2Distance <= song3Distance) {
			System.out.println("Song with play time closest to 240 secs is: " + mySong2.getTitle());
		}
		else if (song3Distance <= song1Distance && song3Distance <= song2Distance) {
			System.out.println("Song with play time closest to 240 secs is: " + mySong3.getTitle());
		}
		
		// Formatting
		System.out.println("========================================================================================");
		System.out.println("Title                          Artist               Album                      Play Time");
		System.out.println("========================================================================================");
		
		// song playtime variables
		int song1PT = mySong.getPlayTime();
		int song2PT = mySong2.getPlayTime();
		int song3PT = mySong3.getPlayTime();
		
		// song order variables
	
		// Determines which song is the shortest and longest and prints in that order			
		if (song1PT <= song2PT && song2PT <= song3PT && song1PT <= song3PT) {
			System.out.println(mySong);
			System.out.println(mySong2);
			System.out.println(mySong3);
		}	
		else if (song1PT <= song3PT && song3PT <= song2PT && song1PT <= song2PT) {
			System.out.println(mySong);
			System.out.println(mySong3);
			System.out.println(mySong2);
		}
		else if (song2PT <= song1PT && song1PT <= song3PT && song2PT <= song3PT) {
			System.out.println(mySong2);
			System.out.println(mySong);
			System.out.println(mySong3);	
		}
		else if (song2PT <= song3PT && song3PT <= song1PT && song2PT <= song1PT) {
			System.out.println(mySong2);
			System.out.println(mySong3);
			System.out.println(mySong);		
		}
		else if (song3PT <= song1PT && song1PT <= song2PT && song3PT <= song2PT) {
			System.out.println(mySong3);
			System.out.println(mySong);
			System.out.println(mySong2);		
		}
		else if (song3PT <= song2PT && song2PT <= song1PT && song3PT <= song1PT) {
			System.out.println(mySong3);
			System.out.println(mySong2);
			System.out.println(mySong);		
		}
		else {
			System.out.println("Error");
		}
		
		// Formatting
		System.out.println("========================================================================================");
		
		// Close scanner
		scan.close();
	}
}
