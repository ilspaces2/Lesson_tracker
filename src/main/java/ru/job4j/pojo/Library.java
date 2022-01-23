package ru.job4j.pojo;

public class Library {

    public static void print(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println("Книга: " + books[i].getName() + ", " + books[i].getPage() + " страниц.");
        }
        System.out.println("----");
    }

    public static void main(String[] args) {
        Book one = new Book("Cars", 100);
        Book two = new Book("Womens", 200);
        Book three = new Book("Clean Code", 150);
        Book four = new Book("Thriller", 30);
        Book[] books = new Book[]{one, two, three, four};
        print(books);
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        print(books);
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getName())) {
                System.out.println("Книга: " + books[i].getName() + ", " + books[i].getPage() + " страниц.");
            }
        }
    }
}