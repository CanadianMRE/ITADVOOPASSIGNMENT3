package driver;
import utilities.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import exceptions.TreeException;

public class WordTracker {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            printUsage();
            return;
        }

        String inputFile = args[0];
        String option = args[1];
        
        if (!option.matches("-pf|-pl|-po")) {
            System.out.println("Invalid option: " + option);
            printUsage();
            return;
        }

        BSTree<WordInfo> wordTree = new BSTree<>();
        BufferedReader reader = null;
        try {
        	reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase(); // Normalize to lowercase
                    if (!word.isEmpty()) {
                        WordInfo wordInfo = new WordInfo(word, inputFile, lineNumber);
                        if (wordTree.contains(wordInfo)) {
                            wordTree.search(wordInfo).getElement().addLine(inputFile,lineNumber);
                        } else {
                            wordTree.add(wordInfo);
                        }
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        } catch (TreeException e) {
            System.out.println("Error with binary search tree: " + e.getMessage());
            return;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }

        if (option.equals("-pf")) {
            printWordsWithFiles(wordTree);
        } else if (option.equals("-pl")) {
            printWordsWithFilesAndLines(wordTree);
        } else if (option.equals("-po")) {
            printWordsWithOccurrences(wordTree);
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
    }

    private static void printWordsWithFiles(BSTree<WordInfo> wordTree) {
        Iterator<WordInfo> iterator = wordTree.inorderIterator();
        while (iterator.hasNext()) {
            WordInfo wordInfo = iterator.next();
            System.out.println("Word: " + wordInfo.getWord() +
                    ", Files: " + wordInfo.getFiles());
        }
    }

    private static void printWordsWithFilesAndLines(BSTree<WordInfo> wordTree) {
        Iterator<WordInfo> iterator = wordTree.inorderIterator();
        while (iterator.hasNext()) {
            WordInfo wordInfo = iterator.next();
            System.out.println("Word: " + wordInfo.getWord() +
                    ", Files: " + wordInfo.getFiles() +
                    ", Lines: " + wordInfo.getLines());
        }
    }

    private static void printWordsWithOccurrences(BSTree<WordInfo> wordTree) {
        Iterator<WordInfo> iterator = wordTree.inorderIterator();
        while (iterator.hasNext()) {
            WordInfo wordInfo = iterator.next();
            System.out.println("Word: " + wordInfo.getWord() +
                    ", Files: " + wordInfo.getFiles() +
                    ", Lines: " + wordInfo.getLines() +
                    ", Occurrences: " + wordInfo.getOccurrences());
        }
    }
}
