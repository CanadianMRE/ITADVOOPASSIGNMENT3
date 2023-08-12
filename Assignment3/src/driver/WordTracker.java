package driver;

import utilities.*;
/**
 * WordTracker - A program for tracking unique words in text files.
 * This program reads text files, collects and stores unique words, and tracks their occurrences in files and lines.
 * The program uses a Binary Search Tree (BST) to store and manage word information from multiple text files.
 * 
 * @author Group 7
 */
public class WordTracker {
	
    /**
     * The main method of the WordTracker program.
     * It prints the program description and delegates the execution to the FileEngine class.
     *
     * @param args Command-line arguments passed to the program.
     */
    public static void main(String[] args) {
    	printDescription();
    	FileEngine.run(args);
    }
    
    /**
     * Prints the description of the WordTracker program.
     * The program reads text files, collects and stores all unique words found in those files,
     * and tracks occurrences of words in files and lines.
     */
    public static void printDescription() {
        System.out.println("Description:\n"+ 
        				   " The WordTracker program reads text files and collects and stores all the unique words it finds in those files.\n"+
        		           " The BST will be able to store information from multiple text files. It will also keep track of each occurrence\n"+
        		           " of a word in a file and the line on which it was found in that file\n");
    }
}
