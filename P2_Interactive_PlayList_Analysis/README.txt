# Project 02: JukeboxHero

* Author: Mike Taylor
* Class: CS121 Section 4-9
* Semester: Fall 2020

## Overview

A music analytics tool called Jukebox Hero.  The user will provide a music catalog in the form of a csv file where 
each row in the file represents a single song with the following values (csv): Artist, Album, Title, Duration (in secs).

The Jukebox Hero tool will allow the user to open a music catalog file, print stats about the catalog (number of songs,
 number of artists, number of albums, total play time), search for songs in the catalog, and display the entire catalog.


## Compiling and Using

To compile, execute the following command in the main project directory:

```
$ javac JukeboxHero.java
```

Run the compiled class with the command:

```
$ java JukeboxHero
```


## Description
You will be prompted to select from a menu using a single character. The menu is load, print, search, analysis, menu, and quit. 

The load option asked you to type in the name of the csv file of songs to load. After it loads, it will tell 
you how many songs it loaded.

The print option will print all of the songs in a nice readable format that are loaded. If no songs are loaded, 
it will print 0 songs.

The search option prompts you for a search term, and returns case-agnostic results from song titles. If you search 
for the same thing again, it will return the same results again.If no songs are loaded, it will find 0 matches. 

The analysis option displays the number of songs, unique artists, unique albums, and total play time in seconds. 
If no songs are loaded, there will be 0 results.

The menu option prints the menu again.

The quit option quits the program.

## Reflection
This came a little bit easier than the last project for me, but I still struggled at some parts. Loading the songs and printing
them was a breeze, but searching was a nightmare. 

I spent so long trying to figure out how on earth contains() would be useful. “Yeah, I know there is a match in there, now tell 
me which one it is!” I would think to myself. I scoured the textbook for answers. I tried all sorts of for loop combinations, I 
got close, and then far away, and then forget what I did earlier and wish I didn’t delete it.

Anyway, turns out there was a misplaced semicolon that wasted probably 3 hours of my time. 

After I got the search feature implemented, it was smooth sailing. I used the same basic idea I figured out for the analyses 
section as well. 


## Sources used

- I used this for figuring out how to count songs in song list.
[decimalFormat](Used https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#size--)

- Textbook
- Slides
- Previous activities and lectures
- Trial and error
- Coffee