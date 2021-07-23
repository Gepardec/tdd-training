package com.gepardec.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookBusinessImpl {

    private final BookService bookService;

    BookBusinessImpl(BookService bookService) {
        this.bookService = bookService;
    }

    public List<String> retrieveAllJavaBookTitles(String user) {
        return bookService.retrieveAllBookTitles(user).stream()
                .filter(b -> b.toLowerCase().contains("java"))
                .collect(Collectors.toList());
    }
}
