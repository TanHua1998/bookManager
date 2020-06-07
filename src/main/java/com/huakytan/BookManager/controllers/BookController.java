package com.huakytan.BookManager.controllers;

import com.huakytan.BookManager.models.Book;
import com.huakytan.BookManager.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/book")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id).orElse(null);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("{id}")
    public boolean deleteBookById(@PathVariable("id") UUID id) {
        return bookService.deleteBookById(id);
    }

    @PutMapping("{id}")
    public boolean updateBookById(@PathVariable("id") UUID id, @RequestBody Book newBook) {
        return bookService.updateBookById(id, newBook);
    }

    /**
     * In Background,Spring will try to bind the request body [which can be JSON/XML/Other]
     * to Book object[ Means crating a new object with the details found in the request body like title, price etc..]
     **/
    @PostMapping()
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
