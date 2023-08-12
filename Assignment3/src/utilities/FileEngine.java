package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileEngine {

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
	
	public static void outputTree(BSTree<TreeWord> bTree, String outputOption, String outputPath) {
		WordInfo wordInfo = new WordInfo();
		
		Iterator<TreeWord> iter = bTree.inorderIterator();
		
		while (iter.hasNext()) {
			TreeWord next = iter.next();
			
			wordInfo.addWord(next.getWord(), next.getFile(), next.getLineNum());
		}
		
		// get output string
		String outputString;
		
		System.out.println(outputOption);
		switch(outputOption) {
		case "-pl":
			System.out.println("PL");
			outputString = wordInfo.outputPL();
			
			break;
		case "-po":
			System.out.println("PO");
			outputString = wordInfo.outputPO();
			
			break;
		default:
			System.out.println("PF");
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
					word = word.replaceAll(
					          "[^a-zA-Z0-9]", "");
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

	public static void printUsage() {
		System.out.println("Usage: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
	}
}
