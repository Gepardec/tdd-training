package com.gepardec.tdd.solution;

import com.gepardec.tdd.BookBusinessImpl;
import com.gepardec.tdd.BookService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

public class BookBusinessImplMockitoTest {

    @Test
    public void usingMockito() {
        List<String> allBookTitles = List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
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
        List<String> allBookTitles = List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
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

    @Test
    public void delete_withVerify() {

        List<String> allBookTitles = List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        BookService bookService = mock(BookService.class);
        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);
        BookBusinessImpl bookBusiness = new BookBusinessImpl(bookService);

        bookBusiness.deleteAllNoneJavaBooks("gepard");

        verify(bookService).deleteBook("gepard", "Learn Python the Hard Way");

        verify(bookService, Mockito.never()).deleteBook("gepard", "Think Java: How to think like a computer scientist");

        verify(bookService, Mockito.times(1)).deleteBook("gepard", "Pro WPF in C# 2008");

        // more useful tools: Mockito.atLeastOnce, Mockito.atLeast
    }

    @Test
    public void captureArgument() {
        List<String> allBookTitles = List.of("Learn Python the Hard Way",
                "Think Java: How to think like a computer scientist",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
                .forClass(String.class);

        BookService bookService = mock(BookService.class);
        Mockito.when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);
        BookBusinessImpl bookBusiness = new BookBusinessImpl(bookService);

        bookBusiness.deleteAllNoneJavaBooks("gepard");
        Mockito.verify(bookService).deleteBook(eq("gepard"), argumentCaptor.capture());

        assertEquals("Learn Python the Hard Way", argumentCaptor.getValue());
    }
}
