package com.huakytan.BookManager.daos;

import com.huakytan.BookManager.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresDao")
public class PostgresBookDataAccess implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresBookDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addBook(UUID id, Book book) {
        final String sql = "INSERT INTO book(id, title, price, author) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id, book.getTitle(), book.getPrice(), book.getAuthor());
    }

    @Override
    public int deleteBookById(UUID id) {
        final String sql = "DELETE FROM book WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        final String sql = "UPDATE book SET title=?, price=?, author=? WHERE id=?";
        return jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getAuthor(), id);
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        final String sql = "SELECT * FROM book WHERE id=?";
        //	queryForObject(String sql, Object[] args, RowMapper<T> rowMapper)
        Book target = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, rowNum) -> {
                    return new Book(UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("title"),
                            resultSet.getString("price"),
                            resultSet.getString("author"));
                });
        return Optional.ofNullable(target);
    }

    @Override
    public List<Book> selectAllBooks() {
        final String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String price = resultSet.getString("price");
            String author = resultSet.getString("author");
            return new Book(id, title, price, author);
        });
    }
}
