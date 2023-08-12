package utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * The WordInfo class manages information about words and their occurrences in different files and lines.
 * It provides methods for adding words, generating formatted output, and storing Word objects.
 */
public class WordInfo {
	private Map<String, Word> Words;
	private ArrayList<Word> OrderedWords;
	
	/**
	 * Initializes a new WordInfo object with an empty map and list to store words.
	 */
	public WordInfo() {
		this.Words = new HashMap<>();
		this.OrderedWords = new ArrayList<>();
	}
	
	/**
	 * Adds a word to the WordInfo object with the specified file and line number.
	 * If the word doesn't exist, it creates a new Word object and adds it to the map and list.
	 * @param word The word to add.
	 * @param file The name of the file.
	 * @param line The line number.
	 */
	public void addWord(String word, String file, int line) {
		Word wordList = Words.get(word);
		
		if (wordList == null) {
			wordList = new Word(word);
			Words.put(word, wordList);
			OrderedWords.add(wordList);
		}
		
		wordList.addWord(file, line);
	}
	
	/**
	 * Generates and returns the formatted output for the "Print Files" option.
	 * @return The formatted output for the "Print Files" option.
	 */
	public String outputPF() {
		
		StringBuffer output = new StringBuffer();
		
		OrderedWords.forEach((val) -> output.append(val.toStringPF()));

		return output.toString();
	}

	/**
	 * Generates and returns the formatted output for the "Print Files and Lines" option.
	 * @return The formatted output for the "Print Files and Lines" option.
	 */
	public String outputPL() {
		StringBuffer output = new StringBuffer();
		
		OrderedWords.forEach((val) -> output.append(val.toStringPL()));

		return output.toString();
	}

	/**
	 * Generates and returns the formatted output for the "Print Occurrences" option.
	 * @return The formatted output for the "Print Occurrences" option.
	 */
	public String outputPO() {
		StringBuffer output = new StringBuffer();

		OrderedWords.forEach((val) -> output.append(val.toStringPO()));
		
		return output.toString();
	}
}
