package SimpleFileCounter;


// FileResult.java
public class FileResult {
    public String filename;
    public int wordCount;
    public int lineCount;

    public FileResult(String filename, int wordCount, int lineCount) {
        this.filename = filename;
        this.wordCount = wordCount;
        this.lineCount = lineCount;
    }
}