public class bookMethod {

    class Book {
        String title;
        String author;

        // Constructor to initialize title and author
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Method to display book info
        public void displayBookInfo() {
            System.out.println("Book Title: " + title + ", Author: " + author);
        }
    }

    public class Main {
        public void main(String[] args) {
            Book myBook = new Book("Java Basics", "John Doe");
            myBook.displayBookInfo();  // Output: Book Title: Java Basics, Author: John Doe
        }
    }
}
