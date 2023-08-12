package utilities;

import java.io.Serializable;

public class TreeWord implements Comparable<TreeWord>, Serializable {
	/**
	 * A unique identifier for serialization purposes.
	 */
	private static final long serialVersionUID = 1L;
	
	private int lineNum;
	private String word;
	private String file;
	
	/**
	 * Constructs a TreeWord object with the specified word, file, and line number.
	 * @param word The word represented by this TreeWord object.
	 * @param file The name of the file where the word occurs.
	 * @param lineNum The line number in the file where the word occurs.
	 */
	public TreeWord(String word, String file, int lineNum) {
		this.word = word;
		this.file = file;
		this.lineNum = lineNum;
	}

	@Override
	public int compareTo(TreeWord o) {
		return this.word.compareTo(o.word);
	}

	/**
	 * Returns the line number where the word occurs.
	 * @return The line number where the word occurs.
	 */
	public int getLineNum() {
		return lineNum;
	}

	/**
	 * Sets the line number where the word occurs.
	 * @param lineNum The line number to set.
	 */
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	/**
	 * Returns the word represented by this TreeWord object.
	 * @return The word represented by this TreeWord object.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Sets the word represented by this TreeWord object.
	 * @param word The word to set.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Returns the name of the file where the word occurs.
	 * @return The name of the file where the word occurs.
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Sets the name of the file where the word occurs.
	 * @param file The name of the file to set.
	 */
	public void setFile(String file) {
		this.file = file;
	}
}
