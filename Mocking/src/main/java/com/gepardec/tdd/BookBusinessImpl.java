package com.gepardec.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookBusinessImpl {

    private static final String JAVA_STRING = "java";

    private final BookService bookService;

    public BookBusinessImpl(BookService bookService) {
        this.bookService = bookService;
    }

    public List<String> retrieveAllJavaBookTitles(String user) {
        return bookService.retrieveAllBookTitles(user).stream()
                .filter(b -> b.toLowerCase().contains(JAVA_STRING))
                .collect(Collectors.toList());
    }

    public void deleteAllNoneJavaBooks(String user) {
        bookService.retrieveAllBookTitles(user).stream()
                .filter(b -> !b.toLowerCase().contains(JAVA_STRING))
                .forEach(b -> bookService.deleteBook(user, b));
    }
}
