package com.gepardec.tdd.workdir;

import com.gepardec.tdd.BookService;

import java.util.List;

public class BookServiceStub implements BookService {
    @Override
    public List<String> retrieveAllBookTitles(String user) {
        // TODO
        return null;
    }

    @Override
    public void deleteBook(String user, String bookName) {
        // not necessary
    }
}
