package com.example.lab9compulsory;

import java.util.List;

public class BookRepository extends AbstractRepository<Book, Integer>{
    private BookDAO dao = new BookDAO();

    public BookRepository() {
        super(Book.class);
    }

}
