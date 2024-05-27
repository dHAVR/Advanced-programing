package com.example.lab11home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    /*
    {
        "title": "New Book Title",
            "authors": "Author Name",
            "average_rating": 4.5,
            "isbn": "1234567890",
            "isbn13": "1234567890123",
            "language_code": "en",
            "num_pages": 300,
            "ratings_count": 100,
            "text_reviews_count": 10,
            "publication_date": "2024-01-01",
            "publisher": "Publisher Name"
    }
     */


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}