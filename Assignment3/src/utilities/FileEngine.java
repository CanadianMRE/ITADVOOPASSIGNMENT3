package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The FileEngine class is responsible for running the word tracking process.
 * It reads input files, processes the data, outputs results, and handles serialization.
 */
public class FileEngine {

    /**
     * Runs the word tracking process based on command line arguments.
     *
     * @param args Command line arguments passed to the program.
     */
    public static void run(String[] args) {
        // Parse args
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

        BSTree<TreeWord> wordTree = SerializeBTree.loadSerialized();

        loadInput(wordTree, new File(inputFile));

        outputTree(wordTree, option, outputFile);

        // Save to repository.ser file
        SerializeBTree.serializeBTree(wordTree);
    }
    
    /**
     * Outputs the word tracking results based on the specified option and output path.
     *
     * @param bTree         The binary search tree containing TreeWord objects.
     * @param outputOption  The output option (-pf, -pl, or -po).
     * @param outputPath    The path of the output file (null if console output).
     */
    public static void outputTree(BSTree<TreeWord> bTree, String outputOption, String outputPath) {
        WordInfo wordInfo = new WordInfo();
        
        Iterator<TreeWord> iter = bTree.inorderIterator();
        
        while (iter.hasNext()) {
            TreeWord next = iter.next();
            
            wordInfo.addWord(next.getWord(), next.getFile(), next.getLineNum());
        }
        
        // get output string
        String outputString;
        
        switch(outputOption) {
            case "-pl":
                outputString = wordInfo.outputPL();
                break;
            case "-po":
                outputString = wordInfo.outputPO();
                break;
            default:
                outputString = wordInfo.outputPF();
        }

        // output with given method
        if (outputPath == null || outputPath.equals("")) {
            System.out.print(outputString);
        } else {
            // output to file
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
                writer.write(outputString);
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }
        }
    }

    /**
     * Loads input data from a file into the binary search tree.
     *
     * @param bTree      The binary search tree to store the data.
     * @param inputPath  The path of the input file.
     */
    public static void loadInput(BSTree<TreeWord> bTree, File inputPath) {
        // create a bufferedReader
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(inputPath));

            int lineNumber = 1;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase(); // Normalize to lower-case
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (!word.isEmpty()) {
                        TreeWord newWord = new TreeWord(word, inputPath.toString(), lineNumber);
                        
                        bTree.add(newWord);
                    }
                }
                lineNumber++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
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
    }

    /**
     * Prints the usage instructions for the WordTracker program.
     */
    public static void printUsage() {
        System.out.println("Usage: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]\n" +
                           "Options:\n" +
                           "  <input.txt>    : Path and filename of the text file to be processed.\n" +
                           "  -pf            : Print words in alphabetic order with corresponding files.\n" +
                           "  -pl            : Print words with files and line numbers where they occur.\n" +
                           "  -po            : Print words with files, line numbers, and frequency of occurrence.\n" +
                           "  -f <output.txt>: Redirect the report to the specified output file.\n\n" );
    }
   
}
