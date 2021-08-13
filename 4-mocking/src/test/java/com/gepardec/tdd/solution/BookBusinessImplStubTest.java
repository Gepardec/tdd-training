package com.gepardec.tdd.solution;

import com.gepardec.tdd.BookBusinessImpl;
import com.gepardec.tdd.BookService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookBusinessImplStubTest {

    @Test
    public void usingStub() {
        BookService bookService = new BookServiceStub();
        BookBusinessImpl bookBusiness = new BookBusinessImpl(bookService);
        assertEquals(2, bookBusiness.retrieveAllJavaBookTitles("gepard").size());
    }
}
