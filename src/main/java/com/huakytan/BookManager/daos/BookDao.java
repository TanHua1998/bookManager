package com.huakytan.BookManager.daos;

import com.huakytan.BookManager.models.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    boolean addBook(UUID id, Book book);

    boolean deleteBookById(UUID id);

    boolean updateBookById(UUID id, Book book);

    Optional<Book> selectBookById(UUID id);

    List<Book> selectAllBooks();

    default boolean addBook(Book book) {
        UUID id = UUID.randomUUID();
        return addBook(id, book);
    }
}
