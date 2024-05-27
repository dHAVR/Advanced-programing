package com.example.lab11home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setAuthors(bookDetails.getAuthors());
        book.setAverageRating(bookDetails.getAverageRating());
        book.setIsbn(bookDetails.getIsbn());
        book.setIsbn13(bookDetails.getIsbn13());
        book.setLanguageCode(bookDetails.getLanguageCode());
        book.setNumPages(bookDetails.getNumPages());
        book.setRatingsCount(bookDetails.getRatingsCount());
        book.setTextReviewsCount(bookDetails.getTextReviewsCount());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setPublisher(bookDetails.getPublisher());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}