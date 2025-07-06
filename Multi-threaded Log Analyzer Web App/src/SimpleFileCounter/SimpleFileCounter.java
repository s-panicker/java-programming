package SimpleFileCounter;


import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.concurrent.*;

public class SimpleFileCounter {
    private static final int PORT = 8080;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception {
        SimpleFileCounter app = new SimpleFileCounter();
        app.createSampleFiles();
        app.startServer();
    }

    private void createSampleFiles() {
        try {
            // Create some sample text files
            Files.write(Paths.get("file1.txt"), "Hello World\nThis is file 1\nHave a nice day!".getBytes());
            Files.write(Paths.get("file2.txt"), "Java is great\nMultithreading rocks\nFile IO is easy".getBytes());
            Files.write(Paths.get("file3.txt"), "Simple example\nLess complexity\nMore fun".getBytes());
            System.out.println("Sample files created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating files: " + e.getMessage());
        }
    }

    private void startServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", new HomeHandler());
        server.createContext("/count", new CountHandler(executor));
        server.start();
        System.out.println("Server started at http://localhost:" + PORT);
        System.out.println("Press Ctrl+C to stop");
    }
}
