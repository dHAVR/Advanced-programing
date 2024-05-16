package com.example.lab9compulsory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        Book foundBook = bookRepository.findById(1);
        System.out.println("Found Book: " + foundBook.toString());
        EntityManagerFactorySingleton.closeEntityManagerFactory();
    }
}
