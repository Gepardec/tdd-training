package com.gepardec.tdd.solution;

import com.gepardec.tdd.BookBusinessImpl;
import com.gepardec.tdd.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

// @RunWith(MockitoJUnitRunner.class)
public class BookBusinessImplMockInjectionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    BookService bookService;

    @InjectMocks
    BookBusinessImpl bookBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void usingMockito() {
        List<String> allBookTitles = List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        assertEquals(2, bookBusiness.retrieveAllJavaBookTitles("gepard").size());
    }

    @Test
    public void usingMockito_WithBDD() {
        List<String> allBookTitles = List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

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

        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

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

        Mockito.when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        bookBusiness.deleteAllNoneJavaBooks("gepard");
        Mockito.verify(bookService).deleteBook(eq("gepard"), argumentCaptor.capture());

        assertEquals("Learn Python the Hard Way", argumentCaptor.getValue());
    }
}
