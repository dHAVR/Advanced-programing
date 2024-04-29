package com.example.lab9compulsory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    private BookDAO dao = new BookDAO();

    public BookRepository() {
    }

    public Book findByIdRepo(int id) {
        return dao.findById(id);
    }

    public List<Book> getAllBooksRepo(String namePattern) {
        return dao.getAllBooks();
    }

    public List<Book> findByName(String s) {
        return dao.findByName(s);
    }
}
