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
    public boolean addBook(UUID id, Book book) {
        db.add(new Book(id, book.getTitle(), book.getPrice(), book.getAuthor()));
        return true;
    }

    @Override
    public boolean deleteBookById(UUID id) {
        Optional<Book> target = selectBookById(id);
        if (target.isEmpty()) return false;
        db.remove(target.get());
        return true;
    }

    @Override
    public boolean updateBookById(UUID id, Book newBook) {
        return selectBookById(id).map(target -> {
            int indexOfTarget = db.indexOf(target);
            if (indexOfTarget >= 0) {
                db.set(indexOfTarget, new Book(id, newBook.getTitle(), newBook.getPrice(), newBook.getAuthor()));
                return true;
            }
            return false;
        }).orElse(false);
    }


}
