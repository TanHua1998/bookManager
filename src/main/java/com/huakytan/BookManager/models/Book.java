package com.huakytan.BookManager.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

import java.util.UUID;

public class Book {
    private final UUID id;
    @NotBlank
    private final String title;
    private final String price;
    private final String author;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("price") String price,
                @JsonProperty("author") String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
