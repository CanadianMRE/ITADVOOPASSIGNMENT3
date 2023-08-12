package utilities;

import java.io.Serializable;

public class TreeWord implements Comparable<TreeWord>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lineNum;
	private String word;
	private String file;
	
	public TreeWord(String word, String file, int lineNum) {
		this.word = word;
		this.file = file;
		this.lineNum = lineNum;
	}

	@Override
	public int compareTo(TreeWord o) {
		return this.word.compareTo(o.word);
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
