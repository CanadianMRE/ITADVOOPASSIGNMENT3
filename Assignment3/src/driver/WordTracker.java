package driver;

import utilities.*;
import java.io.*;
import exceptions.TreeException;

public class WordTracker {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            printUsage();
            return;
        }

        String inputFile = args[0];
        String option = args[1];
        String outputFile = null;

        if (args.length >= 4 && args[2].equals("-f")) {
            outputFile = args[3];
        }

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
                        BSTreeNode<WordInfo> foundNode = wordTree.search(wordInfo);
                        if (foundNode != null) {
                            System.out.println("Adding word: " + wordInfo.getWord() +
                                    ", File: " + inputFile +
                                    ", Line: " + lineNumber +
                                    ", Occurrences: " + wordInfo.getOccurrences());

                            foundNode.getElement().addLine(inputFile, lineNumber);
                        } else {
                            System.out.println("Adding word: " + wordInfo.getWord() +
                                    ", File: " + inputFile +
                                    ", Line: " + lineNumber +
                                    ", Occurrences: " + wordInfo.getOccurrences());

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
            printWordsWithFiles(wordTree, outputFile);
        } else if (option.equals("-pl")) {
            printWordsWithFilesAndLines(wordTree, outputFile);
        } else if (option.equals("-po")) {
            printWordsWithOccurrences(wordTree, outputFile);
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
    }

    private static void printWordsWithFiles(BSTree<WordInfo> wordTree, String outputFile) {
        try (PrintWriter writer = getPrintWriter(outputFile)) {
            Iterator<WordInfo> iterator = wordTree.inorderIterator();
            while (iterator.hasNext()) {
                WordInfo wordInfo = iterator.next();
                String output = "Word: " + wordInfo.getWord() +
                        ", Files: " + wordInfo.getFiles();
                printToConsoleAndFile(output, writer);
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void printWordsWithFilesAndLines(BSTree<WordInfo> wordTree, String outputFile) {
        try (PrintWriter writer = getPrintWriter(outputFile)) {
            Iterator<WordInfo> iterator = wordTree.inorderIterator();
            while (iterator.hasNext()) {
                WordInfo wordInfo = iterator.next();
                String output = "Word: " + wordInfo.getWord() +
                        ", Files: " + wordInfo.getFiles() +
                        ", Lines: " + wordInfo.getLines();
                printToConsoleAndFile(output, writer);
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void printWordsWithOccurrences(BSTree<WordInfo> wordTree, String outputFile) {
        try (PrintWriter writer = getPrintWriter(outputFile)) {
            Iterator<WordInfo> iterator = wordTree.inorderIterator();
            while (iterator.hasNext()) {
                WordInfo wordInfo = iterator.next();
                String output = "Word: " + wordInfo.getWord() +
                        ", Files: " + wordInfo.getFiles() +
                        ", Lines: " + wordInfo.getLines() +
                        ", Occurrences: " + wordInfo.getOccurrences();
                printToConsoleAndFile(output, writer);
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static PrintWriter getPrintWriter(String outputFile) throws IOException {
        if (outputFile != null) {
            return new PrintWriter(new FileWriter(outputFile));
        } else {
            return null; // If outputFile is null, PrintWriter is not created
        }
    }

    private static void printToConsoleAndFile(String output, PrintWriter writer) {
        System.out.println(output);
        if (writer != null) {
            writer.println(output);
        }
    }
}
