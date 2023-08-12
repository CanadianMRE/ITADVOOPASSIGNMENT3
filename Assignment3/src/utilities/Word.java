package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * The Word class represents a word along with its occurrences in various files and line numbers.
 * It provides methods for adding occurrences and generating formatted string representations.
 */
public class Word {
    private String word;
    private Map<String, FileInfo> fileOccurrences;

    /**
     * Constructor to create a new Word object with the given word.
     *
     * @param word The word to be stored in this Word object.
     */
    public Word(String word) {
        this.word = word;
        this.fileOccurrences = new HashMap<>();
    }

    /**
     * Add occurrence of the word in a specific file at the given line number.
     *
     * @param file The file in which the word occurred.
     * @param line The line number in the file where the word occurred.
     */
    public void addWord(String file, int line) {
        FileInfo existingFile = fileOccurrences.get(file);

        if (existingFile == null) {
            existingFile = new FileInfo(file);
            fileOccurrences.put(file, existingFile);
        }

        existingFile.add(line);
    }

    /**
     * Get the key (word) associated with this Word object.
     *
     * @return The word associated with this Word object.
     */
    public String getKey() {
        return word;
    }

    /**
     * Get a formatted string representation of word occurrences per file.
     *
     * @return Formatted string with word occurrences per file.
     */
    public String toStringPF() {
        String result = "\n\nWord: " + word;

        for (Map.Entry<String, FileInfo> entry : fileOccurrences.entrySet()) {
            FileInfo val = entry.getValue();

            result += val.toStringPF();
        }

        return result;
    }

    /**
     * Get a formatted string representation of word occurrences per file and line numbers.
     *
     * @return Formatted string with word occurrences per file and line numbers.
     */
    public String toStringPL() {
        String result = "\n\nWord: " + word;

        for (Map.Entry<String, FileInfo> entry : fileOccurrences.entrySet()) {
            FileInfo val = entry.getValue();

            result += val.toStringPL();
        }

        return result;
    }

    /**
     * Get a formatted string representation of word occurrences per file, line numbers, and total occurrences.
     *
     * @return Formatted string with word occurrences per file, line numbers, and total occurrences.
     */
    public String toStringPO() {
        String result = "\n\nWord: " + word;

        for (Map.Entry<String, FileInfo> entry : fileOccurrences.entrySet()) {
            FileInfo val = entry.getValue();

            result += val.toStringPO();
        }

        return result;
    }

    /**
     * Inner class to represent information about a specific file's occurrences of the word.
     */
    class FileInfo {
        private int occurrences;
        private ArrayList<Integer> lines;
        private String file;

        /**
         * Constructor to create FileInfo object for a specific file.
         *
         * @param file The file associated with this FileInfo object.
         */
        public FileInfo(String file) {
            this.file = file;
            this.occurrences = 0;
            this.lines = new ArrayList<>();
        }

        /**
         * Add occurrence of the word in this file at the given line number.
         *
         * @param line The line number where the word occurred.
         */
        public void add(int line) {
            occurrences++;
            lines.add(line);
        }

        /**
         * Get a formatted string representation of the file name.
         *
         * @return Formatted string with the file name.
         */
        public String toStringPF() {
            return "\n" + file;
        }

        /**
         * Get a formatted string representation of the file name and line numbers.
         *
         * @return Formatted string with the file name and line numbers.
         */
        public String toStringPL() {
            return toStringPF() + " | Lines: " + lines.toString();
        }

        /**
         * Get a formatted string representation of the file name, line numbers, and total occurrences.
         *
         * @return Formatted string with the file name, line numbers, and total occurrences.
         */
        public String toStringPO() {
            return toStringPL() + " | Occurrences: " + occurrences;
        }
    }
}
