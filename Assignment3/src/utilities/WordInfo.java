package utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordInfo {
	private Map<String, Word> Words;
	private ArrayList<Word> OrderedWords;
	
	public WordInfo() {
		this.Words = new HashMap<>();
		this.OrderedWords = new ArrayList<>();
	}
	
	public void addWord(String word, String file, int line) {
		Word wordList = Words.get(word);
		
		if (wordList == null) {
			wordList = new Word(word);
			Words.put(word, wordList);
			OrderedWords.add(wordList);
		}
		
		wordList.addWord(file, line);
	}
	
	public String outputPF() {
		StringBuffer output = new StringBuffer();
		
		OrderedWords.forEach((val) -> output.append(val.toStringPF()));

		return output.toString();
	}

	
	public String outputPL() {
		StringBuffer output = new StringBuffer();
		
		OrderedWords.forEach((val) -> output.append(val.toStringPL()));

		return output.toString();
	}

	
	public String outputPO() {
		StringBuffer output = new StringBuffer();

		OrderedWords.forEach((val) -> output.append(val.toStringPO()));
		
		return output.toString();
	}
	
}
