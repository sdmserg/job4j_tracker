package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean Code", 350);
        Book secondBook = new Book("Head First", 200);
        Book thirdBook = new Book("Design Patterns", 450);
        Book fourthBook = new Book("Data Structures and Algoritms", 800);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (int index = 0; index < books.length; index++) {
            Book  book = books[index];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        System.out.println("Replace of books with index 0 and 3.");
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        for (int index = 0; index < books.length; index++) {
            Book  book = books[index];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        System.out.println("Shown book with title Clean Code");
        for (int index = 0; index < books.length; index++) {
            Book  book = books[index];
            if ("Clean Code".equals(book.getTitle())) {
                System.out.println(book.getTitle() + " - " + book.getPageCount());
            }
        }
    }
}
