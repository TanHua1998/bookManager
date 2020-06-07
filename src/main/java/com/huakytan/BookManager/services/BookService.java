package com.huakytan.BookManager.services;

import com.huakytan.BookManager.daos.BookDao;
import com.huakytan.BookManager.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("testDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Optional<Book> getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public boolean deleteBookById(UUID id) {
        return bookDao.deleteBookById(id);
    }

    public boolean updateBookById(UUID id, Book newBook) {
        return bookDao.updateBookById(id, newBook);
    }

    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }
}
