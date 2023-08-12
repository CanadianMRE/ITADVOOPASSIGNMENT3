Group 7's Word Tracker Program ReadMe
==========================

Completion Status:
------------------
Completeness of the assignment: 100%
Known deficiencies and/or missing functionalities: None.

Overview:
---------
The Word Tracker program is designed to read text files, track unique words,
and provide various options to analyze and display word occurrences within the files.

Features:
---------
- Reads and tracks unique words from text files.
- Provides options to display word occurrences:
  - Print the words in alphabetic order along with file names.
  - Print the words in alphabetic order along with file names and line numbers.
  - Print the words in alphabetic order along with file names, line numbers, and frequency of occurrences.

Installation:
--------------
1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Download the Word Tracker program source code and save it to a directory of your choice.

Usage:
------
1. Open a command prompt or terminal.
2. Navigate to the directory where the Word Tracker program source code is saved.
3. Compile and run the program by typing the following command:
java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]
- Replace <input.txt> with the path and filename of the text file to be processed..
- Use -pf to print words along with file names.
- Use -pl to print words along with file names and line numbers.
- Use -po to print words along with file names, line numbers, and frequency of occurrences.
- Optionally, use -f <output.txt> to redirect the report to a specified output file.

Example Usage:
--------------
java -jar .\WordTracker.jar res/textfile.html -pf -f output.txt
java -jar .\WordTracker.jar res/textfile.html -pl
java -jar .\WordTracker.jar res/textfile.html -po -f output.txt

Additional Information:
------------------------
- The program supports both relative and absolute file paths for input and output files.
- Unique words are tracked and organized using a Binary Search Tree (BST) data structure.

Contact:
--------
For any questions or issues, please contact us.
Group 7.
