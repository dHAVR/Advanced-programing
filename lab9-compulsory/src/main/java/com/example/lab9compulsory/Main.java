package com.example.lab9compulsory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        Book foundBook = bookRepository.findByIdRepo(1);
        System.out.println("Found Book: " + foundBook.toString());
        Book book = new Book();
        book.setTitle("Nineteen Eighty-Four");
        book.setAuthors("George Orwell");
        List<Book> foundListBook = bookRepository.findByName("Nineteen Eighty-Four");
        System.out.println("Found List Book: " + foundListBook.toString());

        EntityManagerFactorySingleton.closeEntityManagerFactory();
    }
}
