package SimpleFileCounter;

// HomeHandler.java
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;

public class HomeHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String html = """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Simple File Counter</title>
                <style>
                    body { font-family: Arial; margin: 40px; background: #f0f0f0; }
                    .container { background: white; padding: 30px; border-radius: 10px; }
                    button { background: #4CAF50; color: white; padding: 15px 25px; 
                            border: none; border-radius: 5px; cursor: pointer; font-size: 16px; }
                    button:hover { background: #45a049; }
                    .result { margin: 20px 0; padding: 15px; background: #e8f4f8; border-radius: 5px; }
                    .loading { display: none; color: #666; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>📁 Simple File Counter</h1>
                    <p>This app counts words in files using multithreading!</p>
                    
                    <button onclick="countWords()">Count Words in Files</button>
                    
                    <div class="loading" id="loading">⏳ Processing files...</div>
                    
                    <div id="results"></div>
                </div>
                
                <script>
                    function countWords() {
                        document.getElementById('loading').style.display = 'block';
                        document.getElementById('results').innerHTML = '';
                        
                        fetch('/count', { method: 'POST' })
                            .then(response => response.text())
                            .then(data => {
                                document.getElementById('results').innerHTML = 
                                    '<div class="result"><h3>Results:</h3>' + data + '</div>';
                            })
                            .catch(error => {
                                document.getElementById('results').innerHTML = 
                                    '<div class="result">Error: ' + error + '</div>';
                            })
                            .finally(() => {
                                document.getElementById('loading').style.display = 'none';
                            });
                    }
                </script>
            </body>
            </html>
            """;

        exchange.getResponseHeaders().set("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, html.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(html.getBytes());
        }
    }
}