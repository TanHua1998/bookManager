package com.huakytan.BookManager.daos;

import com.huakytan.BookManager.models.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    int addBook(UUID id, Book book);

    int deleteBookById(UUID id);

    int updateBookById(UUID id, Book book);

    Optional<Book> selectBookById(UUID id);

    List<Book> selectAllBooks();

    default int addBook(Book book) {
        UUID id = UUID.randomUUID();
        return addBook(id, book);
    }
}
