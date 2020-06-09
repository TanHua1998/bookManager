package com.huakytan.BookManager.daos;

import com.huakytan.BookManager.models.Book;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("testDao")
public class TestBookDataAccess implements BookDao {
    private static List<Book> db = new ArrayList<Book>();

    @Override
    public List<Book> selectAllBooks() {
        return db;
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        return db.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public int addBook(UUID id, Book book) {
        db.add(new Book(id, book.getTitle(), book.getPrice(), book.getAuthor()));
        return 1;
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> target = selectBookById(id);
        if (target.isEmpty()) return 0;
        db.remove(target.get());
        return 1;
    }

    @Override
    public int updateBookById(UUID id, Book newBook) {
        return selectBookById(id).map(target -> {
            int indexOfTarget = db.indexOf(target);
            if (indexOfTarget >= 0) {
                db.set(indexOfTarget, new Book(id, newBook.getTitle(), newBook.getPrice(), newBook.getAuthor()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
