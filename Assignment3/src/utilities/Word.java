package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Word {
	private String word;
	private Map<String, FileInfo> fileOccurances;
	
	/**
	 * @param word
	 * @param file
	 */
	public Word(String word) {
		this.word = word;
		this.fileOccurances = new HashMap<>();
	}
	
	public void addWord(String file, int line) {
		FileInfo existingFile = fileOccurances.get(file);
		
		if (existingFile == null) {
			existingFile = new FileInfo(file);
			fileOccurances.put(file, existingFile);
		}
		
		existingFile.add(line);
	}
	
	public String getKey() {
		return word;
	}

	public String toStringPF() {
		String result = "\n\nWord: " + word;
		
		for (Map.Entry<String, FileInfo> entry : fileOccurances.entrySet()) {
			FileInfo val = entry.getValue();
			
			result += val.toStringPF();
		}
		
		return result;
	}
	
	public String toStringPL() {
		String result = "\n\nWord: " + word;
		
		for (Map.Entry<String, FileInfo> entry : fileOccurances.entrySet()) {
			FileInfo val = entry.getValue();
			
			result += val.toStringPL();
		}
		
		return result;
	}
	
	public String toStringPO() {
		String result = "\n\nWord: " + word;
		
		for (Map.Entry<String, FileInfo> entry : fileOccurances.entrySet()) {
			FileInfo val = entry.getValue();
			
			result += val.toStringPO();
		}
		
		return result;
	}
	
	class FileInfo {
		private int occurances;
		private ArrayList<Integer> lines;
		private String file;
		
		public FileInfo(String file) {
			this.file = file;
			this.occurances = 0;
			this.lines = new ArrayList<>();
		}
		
		public void add(int line) {
			occurances++;
			lines.add(line);
		}
		
		public String toStringPF() {
			return "\n" + file;
		}
		
		public String toStringPL() {
			return toStringPF() + " | Lines: " + lines.toString();
		}
		
		public String toStringPO() {
			return toStringPL() + " | Occurances: " + occurances;
		}
	}
}
