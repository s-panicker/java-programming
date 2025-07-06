package SimpleFileCounter;
// WordCountTask.java
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.Callable;

public class WordCountTask implements Callable<FileResult> {
    private final String filename;

    public WordCountTask(String filename) {
        this.filename = filename;
    }

    @Override
    public FileResult call() throws Exception {
        System.out.println("Processing " + filename + " on thread: " + Thread.currentThread().getName());

        int wordCount = 0;
        int lineCount = 0;

        // File I/O: Read the file line by line
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                // Count words (split by spaces)
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }

        // Simulate some work (so you can see threading in action)
        Thread.sleep(1000);

        System.out.println("Finished " + filename + " - Words: " + wordCount + ", Lines: " + lineCount);
        return new FileResult(filename, wordCount, lineCount);
    }
}

