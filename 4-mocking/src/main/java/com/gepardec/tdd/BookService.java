package com.gepardec.tdd;

import java.util.List;

// External Service
public interface BookService {
    List<String> retrieveAllBookTitles(String user);
    void deleteBook(String user, String bookName);
}
