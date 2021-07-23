package com.gepardec.tdd;

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
