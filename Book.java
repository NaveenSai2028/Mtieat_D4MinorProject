public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String category;
    private int availableCopies;

    public Book(int bookId, String bookName, String author, String category, int availableCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        setAvailableCopies(availableCopies);
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies >= 0) {
            this.availableCopies = availableCopies;
        } else {
            System.out.println("Invalid copy count! Copies cannot be negative.");
        }
    }

    public void displayBookDetails() {
        System.out.println("ID: " + bookId + " | Title: " + bookName + " | Author: " + author +
                " | Category: " + category + " | Available Copies: " + availableCopies);
    }
}
