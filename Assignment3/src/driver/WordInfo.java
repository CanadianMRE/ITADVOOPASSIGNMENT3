package driver;
import java.util.ArrayList;
import java.util.List;

public class WordInfo implements Comparable<WordInfo> {
    private String word;
    private List<String> files;
    private List<Integer> lines;
    private int occurrences;

    public WordInfo(String word, String file, int lineNumber) {
        this.word = word;
        files = new ArrayList<>();
        files.add(file);
        lines = new ArrayList<>();
        lines.add(lineNumber);
        occurrences = 1;
    }

    public String getWord() {
        return word;
    }

    public List<String> getFiles() {
        return files;
    }

    public List<Integer> getLines() {
        return lines;
    }

    public int getOccurrences() {
        return occurrences;
    }
  
    public void addLine(String file, int lineNumber) {
        files.add(file);
        lines.add(lineNumber);
        occurrences++; // Increment occurrences when adding a line
    }
    
    @Override
    public int compareTo(WordInfo other) {
        return word.compareTo(other.word);
    }

    @Override
    public String toString() {
        return word + ": " + occurrences;
    }
}
