# Project 04: ReaderOfBooks

* Author: Mike Taylor
* Class: CS121 Section 4-9
* Semester: Fall 2020

## Overview

A GUI application for loading and reading a collection of books. 
This application allows a user to load books, and select from a list of buttons to read them. 

## Compiling and Using

To compile, execute the following command in the main project directory:

```
$ javac ReaderOfBooks.java
```

Run the compiled class with the command:

```
$ java ReaderOfBooks
```

## Description

Type in the filepath for a csv file for books. A filepath is pre-loaded for convenience. 

Click on a book you want to read. Read the book. 

Load more books, or the same books if you want, go nuts! 

To exit, click the X. 

## Explanation for some things
In the loadingfromcsv method, I chose to append the books after pressing load books, because that is what the function of loading books should be. 
If we want to add a remove books option in the future, that would be a more appropriate button to remove duplicates. Some users might want to load a book more than once. Who knows? 

In BookButton class, I omitted the ELLIPSIS instance variable and setTitleText() method shown in the diagram but not in the requirements, since I didn't find them necessary and they weren't required.

I made different ActionListeners to help my brain understand. I know I can make one ActionListener with an if/else statement, but this works fine too.

## Reflection

This was SO HARD. I didn't quite finish everything I wanted, but I I'm at the point where I'm happy enough with it. I WAY overthought some things. 
I tried to reinent the wheel so many places before realizing where I could take from the Book and Library classes that I already did.

ActionListeners were the bane of my existance. Literal days evaporated of me not getting anywhere. I need to ask for help more, but I am stubborn. 
Things eventually started to click one piece at a time. I'd erase 10 lines of code in places that I only needed 2. 

Besides that, I learned a lot. Which is the goal. I noticed that some books weren't loading all the way, and I found out it was because of a char encoding error, 
so I tried to encode in UTF 8 but the method I tried didn't work. Then I thought that it could be because of my operating system, 
and it turned out I was right, because it worked in onyx. I decided not to go down another rabbit hole when I am pretty sure it's not even an error I need to correct. 

Turns out I kinda hate Java GUIs? Can't we just use CSS instead?

## Sources used
Super was super helpful - https://www.javatpoint.com/super-keyword
ScrollPanes took me forever to comprehend how to do correctly. https://www.javatpoint.com/java-jscrollpane#:~:text=A%20JscrollPane%20is%20used%20to,whose%20size%20can%20change%20dynamically.

- Textbook (read the GUI chapter twice)
- Slides
- Previous activities and lectures
- p4 intro YouTube video, like 6 times
- Trial and error and error and error and error
- CoffeeCoffeeCoffeeCoffee
- Thanksgiving break "freetime" 