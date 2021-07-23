package com.gepardec.tdd;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

public class BookbBusinessImplMockitoTest {

    @Test
    public void usingMockito() {
        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        BookService bookService = mock(BookService.class);
        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        BookBusinessImpl bookBusiness = new BookBusinessImpl(bookService);
        assertEquals(2, bookBusiness.retrieveAllJavaBookTitles("gepard").size());
    }

    @Test
    public void usingMockito_WithBDD() {
        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        BookService bookService = mock(BookService.class);
        BookBusinessImpl bookBusiness = new BookBusinessImpl(bookService);

        //given
        given(bookService.retrieveAllBookTitles("gepard")).willReturn(allBookTitles);

        //when
        List<String> bookTitles = bookBusiness.retrieveAllJavaBookTitles("gepard");

        //then
        assertEquals(2, bookTitles.size());
    }
}
