package SimpleFileCounter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class CountHandler implements HttpHandler {
    private final ExecutorService executor;

    public CountHandler(ExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"POST".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        try {
            String result = countWordsInFiles();
            exchange.sendResponseHeaders(200, result.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(result.getBytes());
            }
        } catch (Exception e) {
            String error = "Error: " + e.getMessage();
            exchange.sendResponseHeaders(500, error.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(error.getBytes());
            }
        }
    }

    private String countWordsInFiles() throws Exception {
        // List of files to process
        String[] files = {"file1.txt", "file2.txt", "file3.txt"};

        // Create tasks for each file
        List<Future<FileResult>> futures = new ArrayList<>();
        for (String filename : files) {
            futures.add(executor.submit(new WordCountTask(filename)));
        }

        // Collect results
        StringBuilder result = new StringBuilder();
        int totalWords = 0;

        for (Future<FileResult> future : futures) {
            FileResult fileResult = future.get();
            result.append("<p><strong>").append(fileResult.filename).append(":</strong> ")
                    .append(fileResult.wordCount).append(" words, ")
                    .append(fileResult.lineCount).append(" lines</p>");
            totalWords += fileResult.wordCount;
        }

        result.append("<hr><p><strong>Total words across all files: ").append(totalWords).append("</strong></p>");
        return result.toString();
    }
}