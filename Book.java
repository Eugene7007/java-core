package Lesson3;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private boolean status;

    private static List<Book> books = new ArrayList<>();

    public Book(String isbn, String name, String author, int year, boolean status) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public void getBookInfo() {
        System.out.printf("%s, %s, %s, %s.", isbn, name, author, year);
        System.out.println(status ? "Available" : "Not Available");
    }

    public void getBooks() {
        if (books.isEmpty()) {
            System.out.println("No books.");
        } else {
            for (Book book : books) {
                book.getBookInfo();
            }
        }
    }

    public void addNewBook(Book newBook) {
        books.add(newBook);
        System.out.printf("Added: %s.", newBook.name);
    }

    public void reserveBook() {
        if (status) {
            status = false;
            System.out.printf("%s reserved.", name);
        } else {
            System.out.printf("%s is already reserved.", name);
        }
    }
}
