package driver;

import utilities.*;

public class WordTracker {
    /**
     * @param args
     */
    public static void main(String[] args) {
    	printDescription();
    	FileEngine.run(args);
    }
    public static void printDescription() {
        System.out.println("Description:\n"+ 
        				   " The WordTracker program reads text files and collects and stores all the unique words it finds in those files.\n"+
        		           " The BST will be able to store information from multiple text files. It will also keep track of each occurrence\n"+
        		           " of a word in a file and the line on which it was found in that file\n");
        }
}
